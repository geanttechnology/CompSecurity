// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dialog;

import android.content.Context;

// Referenced classes of package com.socialin.android.dialog:
//            e

public final class f
{

    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    private String h;
    private android.view.View.OnClickListener i;
    private int j;
    private Context k;

    public f(Context context)
    {
        a = null;
        b = null;
        c = null;
        h = null;
        d = 0;
        f = true;
        g = true;
        i = null;
        j = 0x7f0c0181;
        k = context;
    }

    public final e a()
    {
        return new e(k, d, j, a, b, e, f, g, i, null, h, c, (byte)0);
    }

    public final f a(android.view.View.OnClickListener onclicklistener)
    {
        i = onclicklistener;
        f = true;
        return this;
    }

    public final f a(String s)
    {
        b = s;
        return this;
    }

    public final f a(String s, android.view.View.OnClickListener onclicklistener)
    {
        i = onclicklistener;
        if (onclicklistener != null)
        {
            f = true;
        }
        if (s != null)
        {
            c = s;
        }
        return this;
    }

    public final f a(boolean flag)
    {
        g = true;
        return this;
    }

    public final f b(String s)
    {
        if (s != null)
        {
            h = s;
        }
        return this;
    }
}
