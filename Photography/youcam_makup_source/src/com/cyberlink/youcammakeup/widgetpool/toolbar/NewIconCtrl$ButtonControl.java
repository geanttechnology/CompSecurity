// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.z;

abstract class <init> extends Enum
{

    public static final a a;
    private static final a b[];

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/toolbar/NewIconCtrl$ButtonControl, s);
    }

    public static <init>[] values()
    {
        return (<init>[])b.clone();
    }

    protected abstract String a();

    protected void a(View view)
    {
        boolean flag = z.a(a(), true, Globals.d().getApplicationContext());
        view = view.findViewById(b());
        if (view != null)
        {
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            a(view, i);
        }
    }

    protected void a(View view, int i)
    {
        view.findViewById(0x7f0c072a).findViewById(0x7f0c072a).setVisibility(i);
    }

    protected abstract int b();

    protected void b(View view)
    {
        a(view, 4);
        z.a(a(), Boolean.valueOf(false), Globals.d().getApplicationContext());
    }

    static 
    {
        a = new NewIconCtrl.ButtonControl("None", 0) {

            protected String a()
            {
                return "none";
            }

            protected int b()
            {
                return 0;
            }

        };
        b = (new b[] {
            a
        });
    }

    private _cls1(String s, int i)
    {
        super(s, i);
    }

    _cls1(String s, int i, _cls1 _pcls1)
    {
        this(s, i);
    }
}
