
package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.Manifest;
import android.util.Size;
import android.graphics.Matrix;
import android.widget.Toast;
import android.provider.MediaStore;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    //declaring button and text field
    private Button button;
    private Button change_colour_button;
    private Button open_camera;
    private TextView textView;
    private boolean state = false;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(grantResults){
//            startActivity(intent);
//    }else{
//            Toast.makeText(this, "Permission not granted by the user", Toast.LENGTH_SHORT).show();
//        }









    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode) {
                case PERMISSION_CODE: {
                    // If request is cancelled, the result arrays are empty.
                    if (grantResults.length > 0
                            && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // permission was granted, yay! Do the
                        //startActivity(camera_intent);
                    }
                    return;
                }

                // other 'case' lines to check for other
                // permissions this app might request.
            }

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we need to intialize button and text to show it in our app
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   if with the .equals
                //   if (textView.getText().equals(getString(R.string.first_text))){
                    if(state){
                        textView.setText("this is row string inputed");
                    }
                    else{
                        textView.setText(R.string.second_text);
                    }
                state =! state;
                //there are two ways firt one hardcoding string into the text
                //textView.setText("this is row string");
                //second is the resource file
                //textView.setText(R.string.second_text);
            }
        });
        change_colour_button = findViewById(R.id.change_colour_button);

        change_colour_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, child_activity.class);
                startActivity(intent);
            }
        });





        open_camera = findViewById(R.id.open_camera);
            open_camera.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   // Here, thisActivity is the current activity
                                                   // REQUEST THE PERMISSION
                                                   if (checkSelfPermission(Manifest.permission.CAMERA)
                                                           != PackageManager.PERMISSION_GRANTED) {
                                                       // Permission is  granted
                                                       // Should we show an explanation?
                                                       Toast.makeText(MainActivity.this, "click the button again", Toast.LENGTH_SHORT).show();

                                                       String[] Perm_string = {Manifest.permission.CAMERA};
                                                       requestPermissions(Perm_string,PERMISSION_CODE);

                                                       //             Toast.makeText(MainActivity.this, "Permission been denied ", Toast.LENGTH_SHORT).show();
                                                       } else {

                                                       Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                                       startActivityForResult(intent,IMAGE_CAPTURE_CODE);

                                                       // No explanation needed; request the permission

                                                           // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                                                           // app-defined int constant. The callback method gets the
                                                           // result of the request.
                                                       }

                                               }
//                    Intent camera_intent = new Intent( MainActivity.this, Camera_activity.class);


        });

    }


}