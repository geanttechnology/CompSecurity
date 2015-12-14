// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.c;

import android.graphics.Bitmap;
import com.cyberlink.youcammakeup.utility.aa;
import java.util.Date;
import java.util.Locale;

public class b
{

    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    private Bitmap h;

    public b(long l, String s, String s1, String s2, String s3, long l1, long l2)
    {
        h = null;
        a = l;
        b = s;
        c = s1;
        d = s2;
        e = s3;
        f = l1;
        g = l2;
    }

    public Bitmap a()
    {
        return h;
    }

    public void a(Bitmap bitmap)
    {
        h = bitmap;
    }

    public void b()
    {
        aa.a(h);
        h = null;
    }

    public String c()
    {
        return (new Date(f)).toString();
    }

    public String d()
    {
        return (new Date(g)).toString();
    }

    public String toString()
    {
        return String.format(Locale.US, "promotionId=%d, title=%s, message=%s, actionURL=%s, coverImgURL=%s, endDate=%d, lastModified=%d", new Object[] {
            Long.valueOf(a), b, c, d, e, Long.valueOf(f), Long.valueOf(g)
        });
    }
}
