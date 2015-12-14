// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.dialog.c;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class b
    implements android.widget.hangeListener
{

    private TextView a;
    private SeekBar b;
    private b c;

    public final void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        switch (i)
        {
        default:
            return;

        case 2131757113: 
            a.setVisibility(8);
            b.setVisibility(8);
            c.c.setDuration(15);
            return;

        case 2131757114: 
            a.setVisibility(8);
            b.setVisibility(8);
            c.c.setDuration(15);
            return;

        case 2131757115: 
            a.setVisibility(8);
            b.setVisibility(8);
            c.c.setDuration(60);
            return;

        case 2131757116: 
            a.setVisibility(0);
            break;
        }
        b.setVisibility(0);
        a.setText((new StringBuilder()).append(b.getProgress() + 15).append(c.c.getString(0x7f080661)).toString());
        c.c.setDuration(b.getProgress() + 15);
    }

    ator.VideoOptions(ator.VideoOptions videooptions, TextView textview, SeekBar seekbar)
    {
        c = videooptions;
        a = textview;
        b = seekbar;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$38

/* anonymous class */
    final class DrawingActivity._cls38
        implements c
    {

        final com.socialin.android.videogenerator.ProjectVideoGenerator.VideoOptions a;
        final StringBuilder b;
        final DrawingActivity c;
        private boolean d;

        public final void onViewCreated(View view, DialogFragment dialogfragment)
        {
            dialogfragment = (TextView)view.findViewById(0x7f10083d);
            SeekBar seekbar = (SeekBar)view.findViewById(0x7f10083e);
            Spinner spinner = (Spinner)view.findViewById(0x7f100835);
            Spinner spinner1 = (Spinner)view.findViewById(0x7f100837);
            EditText edittext;
            String as[];
            if (android.os.Build.VERSION.SDK_INT < 18 || d)
            {
                spinner1.setVisibility(8);
                view.findViewById(0x7f100836).setVisibility(8);
                a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.webm);
            } else
            {
                a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.mp4);
            }
            edittext = (EditText)view.findViewById(0x7f100834);
            as = new String[1];
            as[0] = com.socialin.android.photo.draw.DrawingActivity.a(c, DrawingActivity.b(c).c.k, false);
            b.append(as[0]);
            edittext.addTextChangedListener(new DrawingActivity._cls38._cls1(edittext));
            edittext.setText(as[0]);
            spinner.setOnItemSelectedListener(new DrawingActivity._cls38._cls2(spinner));
            spinner1.setOnItemSelectedListener(new DrawingActivity._cls38._cls3(spinner1, as));
            seekbar.setOnSeekBarChangeListener(new DrawingActivity._cls38._cls4(dialogfragment));
            ((RadioGroup)view.findViewById(0x7f100838)).setOnCheckedChangeListener(new DrawingActivity._cls38._cls5(this, dialogfragment, seekbar));
        }

            
            {
                c = drawingactivity;
                d = flag;
                a = videooptions;
                b = stringbuilder;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$38$1

/* anonymous class */
        final class DrawingActivity._cls38._cls1
            implements TextWatcher
        {

            private EditText a;
            private DrawingActivity._cls38 b;

            public final void afterTextChanged(Editable editable)
            {
                editable = a.getText().toString();
                b.b.setLength(0);
                b.b.append(editable);
                b.a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(editable).append(".").append(b.a.getFormat()).toString());
            }

            public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

                    
                    {
                        b = DrawingActivity._cls38.this;
                        a = edittext;
                        super();
                    }
        }


        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$38$2

/* anonymous class */
        final class DrawingActivity._cls38._cls2
            implements android.widget.AdapterView.OnItemSelectedListener
        {

            private Spinner a;
            private DrawingActivity._cls38 b;

            public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                b.a.setResolution(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.fromString(a.getSelectedItem().toString()));
                if (b.a.getFormat() == com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.mp4 && b.a.getResolution() == com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1080)
                {
                    b.a.setResolution(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoResolution.p1072);
                }
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

                    
                    {
                        b = DrawingActivity._cls38.this;
                        a = spinner;
                        super();
                    }
        }


        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$38$3

/* anonymous class */
        final class DrawingActivity._cls38._cls3
            implements android.widget.AdapterView.OnItemSelectedListener
        {

            private Spinner a;
            private String b[];
            private DrawingActivity._cls38 c;

            public final void onItemSelected(AdapterView adapterview, View view, int i, long l)
            {
                c.a.setFormat(com.socialin.android.videogenerator.ProjectVideoGenerator.VideoFormat.formatFromString(a.getSelectedItem().toString()));
                c.a.setOutputPath((new StringBuilder()).append(com.socialin.android.brushlib.project.a.a).append(b[0]).append(".").append(c.a.getFormat()).toString());
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

                    
                    {
                        c = DrawingActivity._cls38.this;
                        a = spinner;
                        b = as;
                        super();
                    }
        }


        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$38$4

/* anonymous class */
        final class DrawingActivity._cls38._cls4
            implements android.widget.SeekBar.OnSeekBarChangeListener
        {

            private TextView a;
            private DrawingActivity._cls38 b;

            public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                b.a.setDuration(i + 15);
                a.setText((new StringBuilder()).append(i + 15).append(b.c.getString(0x7f080661)).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

                    
                    {
                        b = DrawingActivity._cls38.this;
                        a = textview;
                        super();
                    }
        }

    }

}
