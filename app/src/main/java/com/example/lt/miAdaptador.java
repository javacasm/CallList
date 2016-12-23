package com.example.lt;

import android.app.Activity;
import android.database.Cursor;
import android.provider.CallLog.Calls;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class miAdaptador extends BaseAdapter {

	private Activity actividad;
	private Cursor cursor;
	public miAdaptador(Activity act,Cursor c)
	{
		this.actividad=act;
		this.cursor=c;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cursor.getCount();
	}

	@Override
	public Object getItem(int posicion) {
		// TODO Auto-generated method stub
		return "Objeto "+posicion;
	}

	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public View getView(int posicion, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		LayoutInflater li= actividad.getLayoutInflater();
		View view=li.inflate(R.layout.layoutfila, null,true);



		TextView tvTelefono=(TextView)view.findViewById(R.id.tvTelefono);
		TextView tvFecha=(TextView)view.findViewById(R.id.tvFecha);
		cursor.moveToPosition(posicion);
		tvTelefono.setText("Tfno:"+cursor.getString(0));
		tvFecha.setText("Fecha:"+DateFormat.format("dd/MM/yy k:m ",cursor.getLong(1)));
		// TODO: mostrar imagen distinta segun sea llamada de entrada o salida
		// int tipo cursor.getInteger(2)
		/*switch( tipo)

		{
			case Type.Incaming
				setImage="Telefono rojo"
			case Type.Missing
				setImage="telefono verde"
		}
		*/
		return view;
	}

}
