// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.android.brushlib.project.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.dialog.c;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a
    implements TextWatcher
{

    private EditText a;
    private tputPath b;

    public final void afterTextChanged(Editable editable)
    {
        editable = a.getText().toString();
        b.b.setLength(0);
        b.b.append(editable);
        b.b.setOutputPath((new StringBuilder()).append(a.a).append(editable).append(".gif").toString());
    }

    public final void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public final void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ator.GifOptions(ator.GifOptions gifoptions, EditText edittext)
    {
        b = gifoptions;
        a = edittext;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$35

/* anonymous class */
    final class DrawingActivity._cls35
        implements c
    {

        final com.socialin.android.videogenerator.ProjectVideoGenerator.GifOptions a;
        final StringBuilder b;
        final DrawingActivity c;

        public final void onViewCreated(View view, DialogFragment dialogfragment)
        {
            dialogfragment = (TextView)view.findViewById(0x7f100813);
            SeekBar seekbar = (SeekBar)view.findViewById(0x7f100814);
            view = (EditText)view.findViewById(0x7f100811);
            String s = com.socialin.android.photo.draw.DrawingActivity.a(c, DrawingActivity.b(c).c.k, true);
            a.setOutputPath((new StringBuilder()).append(a.a).append(s).append(".gif").toString());
            b.append(s);
            view.setText(s);
            dialogfragment.setText("0.5 sec");
            a.setDelay(50D);
            seekbar.setProgress(4);
            view.addTextChangedListener(new DrawingActivity._cls35._cls1(this, view));
            seekbar.setOnSeekBarChangeListener(new DrawingActivity._cls35._cls2(dialogfragment));
        }

            
            {
                c = drawingactivity;
                a = gifoptions;
                b = stringbuilder;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/draw/DrawingActivity$35$2

/* anonymous class */
        final class DrawingActivity._cls35._cls2
            implements android.widget.SeekBar.OnSeekBarChangeListener
        {

            private TextView a;
            private DrawingActivity._cls35 b;

            public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
            {
                b.a.setDelay(i * 10 + 10);
                a.setText((new StringBuilder()).append((double)(i + 1) / 10D).append(b.c.getString(0x7f080661)).toString());
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

                    
                    {
                        b = DrawingActivity._cls35.this;
                        a = textview;
                        super();
                    }
        }

    }

}
