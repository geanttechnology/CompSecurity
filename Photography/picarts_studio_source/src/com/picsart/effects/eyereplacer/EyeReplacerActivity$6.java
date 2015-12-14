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

final class b
    implements android.widget.eListener
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
            (new ModernAsyncTask(seekbar) {

                private SeekBar a;
                private EyeReplacerActivity._cls6 b;

                protected final Object doInBackground(Object aobj[])
                {
                    aobj = EyeReplacerActivity.a(b.a);
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
                            ((a) (aobj)).a.runOnUiThread(new a._cls3(((a) (aobj))));
                            aobj.j = false;
                        }
                    }
                    return null;
                }

                protected final void onPostExecute(Object obj)
                {
                    if (EyeReplacerActivity.n(b.a).isShowing())
                    {
                        EyeReplacerActivity.n(b.a).dismiss();
                    }
                    if (!b.a.isFinishing())
                    {
                        EyeReplacerActivity.c(b.a).invalidate();
                    }
                }

            
            {
                b = EyeReplacerActivity._cls6.this;
                a = seekbar;
                super();
            }
            }).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                null
            });
            EyeReplacerActivity.n(a).show();
            return;
        }
    }

    _cls1.a(EyeReplacerActivity eyereplaceractivity, TextView textview)
    {
        a = eyereplaceractivity;
        b = textview;
        super();
    }
}
