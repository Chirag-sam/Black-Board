package com.example.lenovo.bb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.FloatMath;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class displaytable extends AppCompatActivity  implements View.OnTouchListener{

    int staffdrawable[]={

            R.drawable.august,
            R.drawable.bali,
            R.drawable.jk,
            R.drawable.poova,
            R.drawable.bennet,
            R.drawable.pandi,
            R.drawable.praveena,
            R.drawable.arunkumar,
            R.drawable.antony,
            R.drawable.feiroz,
            R.drawable.dojo,
            R.drawable.ahalya,
            R.drawable.mrudu,
            R.drawable.maniraj,
            R.drawable.sellam,
            R.drawable.saroo,
            R.drawable.caroline,
            R.drawable.angelin,
            R.drawable.naren,
            R.drawable.sabitha,
            R.drawable.sarada,
            R.drawable.kalpu,
            R.drawable.senthil,
            R.drawable.bhaskar,
            R.drawable.prabu,
            R.drawable.shiny,
            R.drawable.ksubha,
            R.drawable.adlene,
            R.drawable.sharmila,
            R.drawable.vishnu,
            R.drawable.sathya,
            R.drawable.rajeswari,
            R.drawable.usha,
            R.drawable.saraswathi,
            R.drawable.saravanan,
            R.drawable.ganesan,
            R.drawable.sathish,
            R.drawable.divagar,
            R.drawable.nandhini,
            R.drawable.shivanandhini,
            R.drawable.kalaiarasi,
            R.drawable.shanthalakshmi,
            R.drawable.subha

    };



    private static final String TAG = "Touch";
    // These matrices will be used to move and zoom image
    Matrix matrix = new Matrix();
    Matrix savedMatrix = new Matrix();

    // We can be in one of these 3 states
    static final int NONE = 0;
    static final int DRAG = 1;
    static final int ZOOM = 2;
    int mode = NONE;

    // Remember some things for zooming
    PointF start = new PointF();
    PointF mid = new PointF();
    float oldDist = 1f;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_displaytable);
            ImageView view=(ImageView)findViewById(R.id.view);
            String recv=getIntent().getStringExtra("mytext");
            String x[]=getResources().getStringArray(R.array.Staff_Name);
            ArrayList<String> lis=new ArrayList<>(Arrays.asList(x));
            int pos=lis.indexOf(recv);
            view.setImageResource(staffdrawable[pos]);
            if (pos==-1)
                view.setImageResource(R.mipmap.b_board);

            view.setOnTouchListener(this);
        }


        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ImageView view = (ImageView) v;

            // Dump touch event to log
            dumpEvent(event);

            // Handle touch events here...
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    savedMatrix.set(matrix);
                    start.set(event.getX(), event.getY());
                    Log.d(TAG, "mode=DRAG");
                    mode = DRAG;
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    oldDist = spacing(event);
                    Log.d(TAG, "oldDist=" + oldDist);
                    if (oldDist > 10f) {
                        savedMatrix.set(matrix);
                        midPoint(mid, event);
                        mode = ZOOM;
                        Log.d(TAG, "mode=ZOOM");
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_POINTER_UP:
                    mode = NONE;
                    Log.d(TAG, "mode=NONE");
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (mode == DRAG) {
                        // ...
                        matrix.set(savedMatrix);
                        matrix.postTranslate(event.getX() - start.x,
                                event.getY() - start.y);
                    }
                    else if (mode == ZOOM) {
                        float newDist = spacing(event);
                        Log.d(TAG, "newDist=" + newDist);
                        if (newDist > 10f) {
                            matrix.set(savedMatrix);
                            float scale = newDist / oldDist;
                            matrix.postScale(scale, scale, mid.x, mid.y);
                        }
                    }
                    break;
            }

            view.setImageMatrix(matrix);
            return true; // indicate event was handled
        }

        /** Show an event in the LogCat view, for debugging */
        private void dumpEvent(MotionEvent event) {
            String names[] = { "DOWN", "UP", "MOVE", "CANCEL", "OUTSIDE",
                    "POINTER_DOWN", "POINTER_UP", "7?", "8?", "9?" };
            StringBuilder sb = new StringBuilder();
            int action = event.getAction();
            int actionCode = action & MotionEvent.ACTION_MASK;
            sb.append("event ACTION_").append(names[actionCode]);
            if (actionCode == MotionEvent.ACTION_POINTER_DOWN
                    || actionCode == MotionEvent.ACTION_POINTER_UP) {
                sb.append("(pid ").append(
                        action >> MotionEvent.ACTION_POINTER_ID_SHIFT);
                sb.append(")");
            }
            sb.append("[");
            for (int i = 0; i < event.getPointerCount(); i++) {
                sb.append("#").append(i);
                sb.append("(pid ").append(event.getPointerId(i));
                sb.append(")=").append((int) event.getX(i));
                sb.append(",").append((int) event.getY(i));
                if (i + 1 < event.getPointerCount())
                    sb.append(";");
            }
            sb.append("]");
            Log.d(TAG, sb.toString());
        }

        /** Determine the space between the first two fingers */
        private float spacing(MotionEvent event) {
            float x = event.getX(0) - event.getX(1);
            float y = event.getY(0) - event.getY(1);
            return (float) Math.sqrt(x * x + y * y);
        }

        /** Calculate the mid point of the first two fingers */
        private void midPoint(PointF point, MotionEvent event) {
            float x = event.getX(0) + event.getX(1);
            float y = event.getY(0) + event.getY(1);
            point.set(x / 2, y / 2);
        }




    }

