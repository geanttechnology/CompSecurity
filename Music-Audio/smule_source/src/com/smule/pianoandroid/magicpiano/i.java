// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            an, j

public class i extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/an.getName();
    private int b;
    private ProgressBar c;
    private TextView d;
    private TextView e;
    private j f;

    public i(Activity activity, String s)
    {
        super(activity, 0x7f0d007f);
        b = 0;
        requestWindowFeature(1);
        activity = activity.getLayoutInflater().inflate(0x7f03002a, null, false);
        setContentView(activity);
        setCanceledOnTouchOutside(false);
        d = (TextView)activity.findViewById(0x7f0a006d);
        d.setText(s);
        d.setTypeface(z.b(getContext()));
        e = (TextView)activity.findViewById(0x7f0a0087);
        s = e;
        int k;
        if (f != null)
        {
            k = 0;
        } else
        {
            k = 4;
        }
        s.setVisibility(k);
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final i a;

            public void onClick(View view)
            {
                i.a(a);
            }

            
            {
                a = i.this;
                super();
            }
        });
        c = (ProgressBar)activity.findViewById(0x7f0a00b4);
        setCancelable(false);
    }

    private void a()
    {
        if (f != null)
        {
            f.c_();
        }
        dismiss();
    }

    static void a(i k)
    {
        k.a();
    }

    public void a(int k, String s, boolean flag)
    {
        byte byte0 = 4;
        b = k;
        d.setText(s);
        if (b == 1)
        {
            (new Handler()).postDelayed(new Runnable() {

                final i a;

                public void run()
                {
                    a.dismiss();
                }

            
            {
                a = i.this;
                super();
            }
            }, 2000L);
            e.setVisibility(4);
        } else
        {
            if (b == 2)
            {
                e.setText(getContext().getResources().getString(0x7f0c01c0));
                findViewById(0x7f0a00b3).setOnClickListener(new android.view.View.OnClickListener() {

                    final i a;

                    public void onClick(View view)
                    {
                        a.dismiss();
                    }

            
            {
                a = i.this;
                super();
            }
                });
                return;
            }
            if (b == 0)
            {
                s = e;
                k = byte0;
                if (flag)
                {
                    k = 0;
                }
                s.setVisibility(k);
                return;
            }
        }
    }

    public void a(long l)
    {
        c.setProgress((int)l);
    }

    public void a(j j1)
    {
        f = j1;
        if (e != null)
        {
            j1 = e;
            int k;
            if (f != null)
            {
                k = 0;
            } else
            {
                k = 4;
            }
            j1.setVisibility(k);
        }
    }

    public void a(boolean flag)
    {
        if (flag && f != null)
        {
            e.setVisibility(0);
        } else
        {
            e.setVisibility(4);
        }
        super.show();
    }

    public void onBackPressed()
    {
        if (b == 2)
        {
            dismiss();
        }
    }

}
