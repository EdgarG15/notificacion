package com.example.practica3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManager notificationManager;
    static final String CANAL_ID="segundo canal";
    static final int NOTIFICATION_ID =1;
    public final static  String GRUPO_NOTIF = "grupo de notificaciones";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    CANAL_ID, "Mis Notificaciones",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripcion del canal");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,100,300,100});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {

            Intent intent = new Intent(MainActivity.this,MainActivity.class);
            Intent intent2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:6145765308"));
            Intent intent3= new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0?q=UTCH"));
            Intent intent4= new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.utch.edu.mx/"));
            PendingIntent pendingIntent = PendingIntent.getActivity(
                    MainActivity.this,0,intent, PendingIntent.FLAG_IMMUTABLE);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(
                    MainActivity.this,0,intent2, PendingIntent.FLAG_IMMUTABLE);
            PendingIntent pendingIntent3 = PendingIntent.getActivity(
                    MainActivity.this,0,intent3, PendingIntent.FLAG_IMMUTABLE);
            PendingIntent pendingIntent4 = PendingIntent.getActivity(
                    MainActivity.this,0,intent4, PendingIntent.FLAG_IMMUTABLE);

            @Override
            public void onClick(View view) {
                String s = "Texto largo con descripcion detallada de la notificacion";
                NotificationCompat.Builder noti =
                        new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                .setStyle(new NotificationCompat.BigTextStyle().bigText(s+s+s+s+s+s))
                                .setContentTitle("Actividad 8")
                                .setContentText("Practica para personalizar la vista de la notificación")
                                .setGroup(GRUPO_NOTIF)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.cazador));
                notificationManager.notify(NOTIFICATION_ID,noti.build());

                int idNotificacion2 =2;
                NotificationCompat.Builder noti2 =
                        new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                .setContentTitle("Nueva Conferencia 2")
                                .setContentText("Practica numero 2")
                                .setSmallIcon(com.google.android.material.R.drawable.abc_ic_star_black_16dp)
                                .setGroup(GRUPO_NOTIF);
                notificationManager.notify(idNotificacion2,noti2.build());

                int idNotificacion3 =3;
                NotificationCompat.Builder noti3 =
                        new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                .setContentTitle("Nueva Conferencia 3")
                                .setContentText("Practica numero 3")
                                .setSmallIcon(com.google.android.material.R.drawable.abc_ic_star_black_16dp)
                                .setGroup(GRUPO_NOTIF);
                notificationManager.notify(idNotificacion3,noti3.build());

                int idNotificacion4 =4;
                NotificationCompat.Builder noti4 =
                        new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                                .setContentTitle("Nueva Conferencia 4")
                                .setContentText("Practica numero 4")
                                .setSmallIcon(com.google.android.material.R.drawable.abc_ic_star_black_16dp)
                                .setGroup(GRUPO_NOTIF)
                                .setGroupSummary(true);
                notificationManager.notify(idNotificacion4,noti4.build());
            }
        });
    }
}