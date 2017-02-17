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

public class displaytable extends AppCompatActivity  implements View.OnTouchListener{

    String a="Mr.J. Jagadeesan";
    String b="Mr.R. Augustin Issac";
    String c="Mr.S. Jayakumar";
    String d="Mrs.T. Rathika";
    String e="Mr.R.J. Poovaraghan";
    String f="Mr. Balika.J.Chelliah";
    String g="Mrs. Sabitha";
    String h="Mrs.V. Praveena";
    String i="Mr.S. Pandiaraj";
    String j="Mr.S. Arunkumar";
    String k="Mr.T.H. Feiroz Khan";
    String l="Mr.B. Dojohn Loyd";
    String m="Ms.M.S. Bennet Praba";
    String n="Mrs. Mohanavalli Kirthika";
    String o="Mrs. Sarada";
    String p="Mr.S.P. MANIRAJ";
    String q="Ms.J. Ahalya Mary";
    String r="Mr. Narendran";
    String s="Ms. Mrudula Oruganti";
    String t="Mrs. Kalpana";
    String u="Mrs. Elavarsi";
    String v="Mr. Sarooraj";
    String w="Mr. Muneeswaran";
    String x="Ms. Akshaya";
    String y="Mr. Senthil";
    String z="Ms. Anlet";
    String a1="Mrs.S. Rajathi";
    String a2="Ms. Caroline El Fiorenza";
    String a3="Ms. Deva Hema";
    String a4="Ms. Angeline.R";
    String a5="Ms.M.S. Antony Vigil";



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
            if(recv.equals(a))
                view.setImageResource(R.drawable.hod);
            else if(recv.equals(b))
                view.setImageResource(R.drawable.august);
            else if(recv.equals(c))
                view.setImageResource(R.drawable.jk);
            else if(recv.equals(d))
                view.setImageResource(R.drawable.rathika);
            else if(recv.equals(e))
                view.setImageResource(R.drawable.poova);
            else if(recv.equals(f))
                view.setImageResource(R.drawable.bali);
            else if(recv.equals(g))
                view.setImageResource(R.drawable.sabitha);
            else if(recv.equals(h))
                view.setImageResource(R.drawable.praveena);
            else if(recv.equals(i))
                view.setImageResource(R.drawable.pandi);
            else if(recv.equals(j))
                view.setImageResource(R.drawable.arunkumar);
            else if(recv.equals(k))
                view.setImageResource(R.drawable.feiroz);
            else if(recv.equals(l))
                view.setImageResource(R.drawable.dojo);
            else if(recv.equals(m))
                view.setImageResource(R.drawable.bennet);
            else if(recv.equals(n))
                view.setImageResource(R.drawable.mohanavalli);
            else if(recv.equals(o))
                view.setImageResource(R.drawable.sarada);
            else if(recv.equals(p))
                view.setImageResource(R.drawable.maniraj);
            else if(recv.equals(q))
                view.setImageResource(R.drawable.ahalya);
            else if(recv.equals(r))
                view.setImageResource(R.drawable.naren);
            else if(recv.equals(s))
                view.setImageResource(R.drawable.mrudu);
            else if(recv.equals(t))
                view.setImageResource(R.drawable.kalpu);
            else if(recv.equals(u))
                view.setImageResource(R.drawable.elaa);
            else if(recv.equals(v))
                view.setImageResource(R.drawable.saroo);
            else if(recv.equals(w))
                view.setImageResource(R.drawable.munee);
            else if(recv.equals(x))
                view.setImageResource(R.drawable.akshaya);
            else if(recv.equals(y))
                view.setImageResource(R.drawable.senthil);
            else if(recv.equals(z))
                view.setImageResource(R.drawable.anlet);
            else if(recv.equals(a1))
                view.setImageResource(R.drawable.rajathi);
            else if(recv.equals(a2))
                view.setImageResource(R.drawable.caroline);
            else if(recv.equals(a3))
                view.setImageResource(R.drawable.deva);
            else if(recv.equals(a4))
                view.setImageResource(R.drawable.angelin);
            else if(recv.equals(a5))
                view.setImageResource(R.drawable.antony);
            else
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

