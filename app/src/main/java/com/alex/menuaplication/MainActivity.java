package com.alex.menuaplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(MainActivity.this, view);
                p.getMenuInflater().inflate(R.menu.menu_layout, p.getMenu());//Le tienes que decir que te lo meta en el menu on p.getmenu
                p.show();

              //  p.getMenu().getItem(1).setIntent();//Si quieres añadirle algun funcion, intent o lo que sea al menu que has creado
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

//        //TODO inflar el menu_layout
//        //Puedes hacerlo por el xml como hemos hecho o programarlo desde aqui. Si lo crear programarlo no es necesario inflarlo
//        // getMenuInflater().inflate(R.menu.menu_layout, menu); //Para inflar el menu creado en la carpeta menu
//
//        // groupID, id, ordem, texto
//
//         MenuItem mi = menu.add(Menu.NONE, 1, 1, "Opcion 1");
//         MenuItem mi2 = menu.add(Menu.NONE, 2, 2, "Opcion 2");
//         menu.add(Menu.NONE, 3, 3, "Opcion 3");
//
//        mi2.setIcon(R.mipmap.ic_launcher);
//        mi2.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
//
//        mi.setIcon(R.mipmap.ic_launcher);
//        mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS); //Se puede poner en el xml con android:ShowActionAlways, ahi salen opciones
//
//        Intent i = new Intent(this, Main2Activity.class);
//        mi.setIntent(i);
//

       //CONTEXT MENU. Se puede asociar a cualquier vista y sale al pulsar3 sgunfos sobre el objeto

        EditText editText = (EditText) findViewById(R.id.editText);
        registerForContextMenu(editText);



        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, 8, 8, "Dame");
        Log.d(getClass().getCanonicalName(), "Contextmenucreado");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Listener para el menú

        Log.d(getClass().getCanonicalName(), item.getTitle().toString());

        return super.onOptionsItemSelected(item);
    }
}
