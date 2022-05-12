package com.example.recbuscarregistro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterUsuarios extends RecyclerView.Adapter<AdapterUsuarios.UsuarioViewHolder> {

    private final List<usuario> listaUsuarios;

    public AdapterUsuarios(List<usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    @NonNull
    @Override
    public AdapterUsuarios.UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listrecyclerview, viewGroup, false);
        return new UsuarioViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder usuarioViewHolder, int i) {

        try {
            usuarioViewHolder.codigo.setText(listaUsuarios.get(i).getCodigo_pro())  ;
            usuarioViewHolder.nombre.setText(listaUsuarios.get(i).getNombre_pro());
            usuarioViewHolder.precio.setText(listaUsuarios.get(i).getPrecio_pro());
            usuarioViewHolder.cantidad.setText(listaUsuarios.get(i).getCantidad_pro());
        }catch (Exception ex){
            System.out.println(""+ex);
        }
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }
    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {


        EditText codigo,nombre,precio,cantidad;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo = itemView.findViewById(R.id.edtcodigo);
            nombre = itemView.findViewById(R.id.edtnombre);
            precio = itemView.findViewById(R.id.edtprecio);
            cantidad = itemView.findViewById(R.id.edtcantidad);

        }
    }
}



