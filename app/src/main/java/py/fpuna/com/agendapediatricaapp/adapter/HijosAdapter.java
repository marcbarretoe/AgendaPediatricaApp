package py.fpuna.com.agendapediatricaapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import py.fpuna.com.agendapediatricaapp.R;
import py.fpuna.com.agendapediatricaapp.VacunasActivity;
import py.fpuna.com.agendapediatricaapp.dto.HijosDTO;


public class HijosAdapter extends RecyclerView.Adapter<HijosAdapter.ResultadoViewHolder>{
    private Context context;
    private List<HijosDTO> hijos;

    public HijosAdapter(Context context, List<HijosDTO> hijos) {
        this.context = context;
        this.hijos = hijos;

    }


    @Override
    public HijosAdapter.ResultadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_hijos, parent, false);
        return new HijosAdapter.ResultadoViewHolder(v);
    }

    private static int calculateAge(Date birthDate)
    {
        int years = 0;
        int months = 0;
        int days = 0;
        //create calendar object for birth day
        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(birthDate.getTime());
        //create calendar object for current day
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);
        //Get difference between years
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;
        //Get difference between months
        months = currMonth - birthMonth;
        //if month difference is in negative then reduce years by one and calculate the number of months.
        if (months < 0)
        {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
                months--;
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
        {
            years--;
            months = 11;
        }
        //Calculate the days
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE))
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE))
        {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else
        {
            days = 0;
            if (months == 12)
            {
                years++;
                months = 0;
            }
        }
        System.out.println("LA EDAD CALCULADA ES: " + years);
        //Create new Age object
        return years;
    }

    @Override
    public void onBindViewHolder(HijosAdapter.ResultadoViewHolder holder, int position) {
       HijosDTO item = hijos.get(position);

        holder.nombre.setText(item.getNombres()+ " " + item.getApellidos());
        holder.id.setText(String.valueOf(item.getId()));
        String descripcionSexo = "FEMENINO";
        //System.out.println("sexo" + item.getSexo());
        if(item.getSexo().toString().equalsIgnoreCase("M")){
            descripcionSexo = "MASCULINO";
        }
        holder.sexo.setText(descripcionSexo);
        //holder.edad.setText(item.getEdad);
        //holder.edad.setText("EDAD");
        holder.edad.setText(String.valueOf(calculateAge(item.getFechaNacimiento())));

    }

    @Override
    public int getItemCount() {
        return hijos.size();
    }

    public class ResultadoViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView nombre;
        private TextView sexo;
        private TextView edad;



        public ResultadoViewHolder(final View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.nombreHijo);
            id = (TextView) itemView.findViewById(R.id.idHijo);
            sexo = (TextView) itemView.findViewById(R.id.sexo);
            edad = (TextView) itemView.findViewById(R.id.edad);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, VacunasActivity.class);
                    intent.putExtra("hijo", nombre.getText());
                    intent.putExtra("id", id.getText());
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });
        }
    }

}
