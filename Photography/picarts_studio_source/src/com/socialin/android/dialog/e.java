// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import myobfuscated.f.m;

public final class e extends Dialog
{

    private android.view.View.OnClickListener a;
    private android.view.View.OnClickListener b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;

    private e(Context context, int k, int l, String s, String s1, int i1, boolean flag, 
            boolean flag1, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, String s2, String s3)
    {
        super(context, l);
        a = null;
        b = null;
        c = "";
        d = "";
        e = null;
        f = null;
        g = 0;
        h = -1;
        i = true;
        j = true;
        c = s;
        d = s1;
        i = flag;
        j = flag1;
        a = onclicklistener;
        b = onclicklistener1;
        h = i1;
        e = s2;
        f = s3;
        g = k;
        setContentView(0x7f0301e3);
        s = getLayoutInflater();
        if (!TextUtils.isEmpty(c))
        {
            ((ViewStub)findViewById(0x7f1008ae)).inflate();
            k = g;
            if (k == 0)
            {
                context = null;
            } else
            {
                context = getContext().getResources().getDrawable(k);
            }
            s1 = m.a(this);
            s1.setCompoundDrawablesWithIntrinsicBounds(context, null, null, null);
            s1.setText(c);
        }
        context = (TextView)findViewById(0x7f10067e);
        if (TextUtils.isEmpty(d))
        {
            context.setVisibility(8);
        } else
        {
            context.setText(d);
            context.setVisibility(0);
        }
        context = (FrameLayout)findViewById(0x7f1008af);
        if (h > 0)
        {
            context.addView(s.inflate(h, null));
        } else
        {
            context.setVisibility(8);
        }
        context = findViewById(0x7f10067f);
        if (i)
        {
            context.setVisibility(0);
            if (f != null)
            {
                ((Button)context).setText(f);
            }
            context.setOnClickListener(new android.view.View.OnClickListener() {

                private e a;

                public final void onClick(View view)
                {
                    if (e.a(a) != null)
                    {
                        e.a(a).onClick(view);
                    }
                    a.dismiss();
                }

            
            {
                a = e.this;
                super();
            }
            });
        } else
        {
            context.setVisibility(8);
        }
        context = findViewById(0x7f1008b0);
        if (j)
        {
            context.setVisibility(0);
            if (e != null)
            {
                ((Button)context).setText(e);
            }
            context.setOnClickListener(new android.view.View.OnClickListener() {

                private e a;

                public final void onClick(View view)
                {
                    if (e.b(a) != null)
                    {
                        e.b(a).onClick(view);
                    }
                    a.dismiss();
                }

            
            {
                a = e.this;
                super();
            }
            });
            return;
        } else
        {
            context.setVisibility(8);
            return;
        }
    }

    e(Context context, int k, int l, String s, String s1, int i1, boolean flag, 
            boolean flag1, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, String s2, String s3, byte byte0)
    {
        this(context, k, l, s, s1, i1, flag, flag1, onclicklistener, null, s2, s3);
    }

    static android.view.View.OnClickListener a(e e1)
    {
        return e1.a;
    }

    static android.view.View.OnClickListener b(e e1)
    {
        return e1.b;
    }
}
