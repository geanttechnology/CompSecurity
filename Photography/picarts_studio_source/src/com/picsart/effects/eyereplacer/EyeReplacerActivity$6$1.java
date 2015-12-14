// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.app.Activity;
import android.widget.SeekBar;
import android.widget.TextView;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a, EyeReplaceImageView

final class a extends ModernAsyncTask
{

    private SeekBar a;
    private lidate b;

    protected final Object doInBackground(Object aobj[])
    {
        aobj = EyeReplacerActivity.a(b.b);
        int i = a.getProgress() - 50;
        aobj.i = i;
        if (!((a) (aobj)).a.isFinishing())
        {
            aobj.j = true;
            ((a) (aobj)).a(((a) (aobj)).b, ((a) (aobj)).h, i);
            if (((a) (aobj)).a.isFinishing())
            {
                aobj.j = false;
            } else
            {
                ((a) (aobj)).a.runOnUiThread(new a(((a) (aobj))));
                aobj.j = false;
            }
        }
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        if (EyeReplacerActivity.n(b.b).isShowing())
        {
            EyeReplacerActivity.n(b.b).dismiss();
        }
        if (!b.b.isFinishing())
        {
            EyeReplacerActivity.c(b.b).invalidate();
        }
    }

    ( , SeekBar seekbar)
    {
        b = ;
        a = seekbar;
        super();
    }

    // Unreferenced inner class com/picsart/effects/eyereplacer/EyeReplacerActivity$6

/* anonymous class */
    final class EyeReplacerActivity._cls6
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        final EyeReplacerActivity a;
        private TextView b;

        public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            b.setText((new StringBuilder()).append(a.getString(0x7f0801e8)).append(" : ").append(i).toString());
        }

        public final void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public final void onStopTrackingTouch(SeekBar seekbar)
        {
            a.a = true;
            if (EyeReplacerActivity.a(a).j)
            {
                Utils.b(a, 0x7f080405);
                return;
            } else
            {
                b.setText((new StringBuilder()).append(a.getString(0x7f0801e8)).append(" : ").append(seekbar.getProgress()).toString());
                (new EyeReplacerActivity._cls6._cls1(this, seekbar)).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                    null
                });
                EyeReplacerActivity.n(a).show();
                return;
            }
        }

            
            {
                a = eyereplaceractivity;
                b = textview;
                super();
            }
    }

}
