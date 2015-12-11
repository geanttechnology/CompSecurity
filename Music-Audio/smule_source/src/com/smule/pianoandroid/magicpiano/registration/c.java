// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.j;
import com.smule.pianoandroid.utils.z;

public class c extends Dialog
{

    Context a;
    String b;
    Runnable c;
    Activity d;

    public c(Activity activity, String s)
    {
        super(activity, 0x1030010);
    }

    public static c a(Activity activity, String s)
    {
        c c1 = new c(activity, s);
        c1.setCancelable(false);
        c1.a = MagicApplication.getContext();
        c1.b = s;
        c1.d = activity;
        return c1;
    }

    public static c a(Activity activity, String s, String s1)
    {
        activity = a(activity, s);
        activity.show();
        return activity;
    }

    public void a(Runnable runnable)
    {
        c = runnable;
    }

    protected void onCreate(Bundle bundle)
    {
        bundle = d.getLayoutInflater().inflate(0x7f030061, null, false);
        j.a(bundle, d.getLayoutInflater().getContext());
        setCanceledOnTouchOutside(false);
        Object obj = (TextView)bundle.findViewById(0x7f0a01f5);
        ((TextView) (obj)).setTypeface(z.c(a));
        ((TextView) (obj)).setText(b);
        obj = (Button)bundle.findViewById(0x7f0a01f6);
        ((Button) (obj)).setTypeface(z.d(a));
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                a.dismiss();
                if (a.c != null)
                {
                    a.c.run();
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
        setContentView(bundle);
    }
}
