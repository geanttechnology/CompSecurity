// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.smule.pianoandroid.utils.j;

public class n extends Dialog
{

    private static final String a = com/smule/pianoandroid/magicpiano/n.getName();
    private Runnable b;
    private Runnable c;

    private n(Activity activity, int i, String s, String s1, String s2, String s3, String s4, 
            Runnable runnable, Runnable runnable1, boolean flag)
    {
        super(activity, 0x7f0d007f);
        b = runnable;
        c = runnable1;
        requestWindowFeature(1);
        runnable = activity.getLayoutInflater().inflate(0x7f030031, null, false);
        j.a(runnable, activity.getLayoutInflater().getContext());
        setContentView(runnable);
        activity = (TextView)runnable.findViewById(0x7f0a008b);
        activity.setOnClickListener(new android.view.View.OnClickListener() {

            final n a;

            public void onClick(View view)
            {
                a.dismiss();
                if (n.a(a) != null)
                {
                    n.a(a).run();
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
        activity.setText(s3);
        s3 = (TextView)runnable.findViewById(0x7f0a008c);
        if (s4 == null)
        {
            s3.setVisibility(8);
            activity.setBackgroundResource(0x7f020082);
        } else
        {
            s3.setOnClickListener(new android.view.View.OnClickListener() {

                final n a;

                public void onClick(View view)
                {
                    a.dismiss();
                    if (n.b(a) != null)
                    {
                        n.b(a).run();
                    }
                }

            
            {
                a = n.this;
                super();
            }
            });
            s3.setText(s4);
        }
        ((TextView)runnable.findViewById(0x7f0a00d2)).setText(s);
        ((TextView)runnable.findViewById(0x7f0a00d4)).setText(s2);
        setCanceledOnTouchOutside(false);
        if (s1 != null)
        {
            ((TextView)runnable.findViewById(0x7f0a00d3)).setText(s1);
        } else
        {
            runnable.findViewById(0x7f0a00d3).setVisibility(8);
        }
        ((ImageView)runnable.findViewById(0x7f0a0040)).setImageResource(i);
        if (flag)
        {
            runnable.findViewById(0x7f0a0063).setOnClickListener(new android.view.View.OnClickListener() {

                final n a;

                public void onClick(View view)
                {
                    a.cancel();
                }

            
            {
                a = n.this;
                super();
            }
            });
            runnable.findViewById(0x7f0a0064).setOnClickListener(new android.view.View.OnClickListener() {

                final n a;

                public void onClick(View view)
                {
                }

            
            {
                a = n.this;
                super();
            }
            });
        }
    }

    public static n a(Activity activity, int i, String s, String s1, String s2, String s3, String s4, Runnable runnable, 
            Runnable runnable1)
    {
        return new n(activity, i, s, s1, s2, s3, s4, runnable, runnable1, true);
    }

    public static n a(Activity activity, int i, String s, String s1, String s2, String s3, String s4, Runnable runnable, 
            Runnable runnable1, boolean flag)
    {
        return new n(activity, i, s, s1, s2, s3, s4, runnable, runnable1, flag);
    }

    static Runnable a(n n1)
    {
        return n1.b;
    }

    static Runnable b(n n1)
    {
        return n1.c;
    }

    public void a(Runnable runnable)
    {
        b = runnable;
        findViewById(0x7f0a008b).setOnClickListener(new android.view.View.OnClickListener() {

            final n a;

            public void onClick(View view)
            {
                a.dismiss();
                if (n.a(a) != null)
                {
                    n.a(a).run();
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
    }

    public void b(Runnable runnable)
    {
        c = runnable;
        findViewById(0x7f0a008c).setOnClickListener(new android.view.View.OnClickListener() {

            final n a;

            public void onClick(View view)
            {
                a.dismiss();
                if (n.b(a) != null)
                {
                    n.b(a).run();
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
    }

    public void onBackPressed()
    {
        cancel();
    }

}
