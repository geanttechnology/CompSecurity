// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import com.cyberlink.youcammakeup.Globals;
import java.text.SimpleDateFormat;

public class b
{

    long a;
    String b;
    int c;
    long d;
    long e;
    String f;
    long g;

    public b(long l, String s, int i, long l1, long l2, String s1, long l3)
    {
        a = l;
        b = s;
        c = i;
        d = l1;
        e = l2;
        f = s1;
        g = l3;
    }

    public long a()
    {
        return a;
    }

    public String b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }

    public long d()
    {
        return d;
    }

    public String e()
    {
        return f;
    }

    public String toString()
    {
        String s = Globals.a.format(Long.valueOf(g));
        return (new StringBuilder()).append("ID: ").append(a).append(", name: \"").append(b).append("\", imageCount: ").append(c).append(", fileId: ").append(d).append(", imageDateTaken: ").append(s).append(", imagePath: \"").append(f).append("\"").toString();
    }
}
