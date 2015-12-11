// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;

public abstract class d
{

    public StringBuilder e;
    public boolean f;

    public d()
    {
    }

    protected final void a(Point point)
    {
        a("w", (new StringBuilder()).append(point.x).toString());
        a("h", (new StringBuilder()).append(point.y).toString());
    }

    protected final void a(String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return;
        }
        StringBuilder stringbuilder = e;
        String s2;
        if (f)
        {
            f = false;
            s2 = "?";
        } else
        {
            s2 = "&";
        }
        stringbuilder.append(s2);
        e.append(s);
        e.append("=");
        e.append(Uri.encode(s1));
    }

    public final void a(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        a("android_perms_ext_storage", s);
    }

    protected final transient void a(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < 2; i++)
        {
            stringbuilder.append(as[i]).append(",");
        }

        stringbuilder.append(as[2]);
        a("dn", stringbuilder.toString());
    }

    protected final void b()
    {
        a("udid", "mp_tmpl_advertising_id");
        a("dnt", "mp_tmpl_do_not_track");
    }

    public abstract String c(String s);

    public final void d(String s)
    {
        a("v", s);
    }

    protected final void e(String s)
    {
        a("av", s);
    }
}
