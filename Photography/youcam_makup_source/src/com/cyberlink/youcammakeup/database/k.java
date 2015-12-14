// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import android.content.ContentValues;

// Referenced classes of package com.cyberlink.youcammakeup.database:
//            d

public class k
{

    public long a;
    public d b;
    public String c;
    public int d;
    public int e;

    public k(long l, d d1, String s, int i, int j)
    {
        a = l;
        b = d1;
        c = s;
        d = i;
        e = j;
    }

    public k(k k1)
    {
        a = k1.a;
        b = k1.b;
        c = k1.c;
        d = k1.d;
        e = k1.e;
    }

    public long a()
    {
        return a;
    }

    public d b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public int d()
    {
        return d;
    }

    public int e()
    {
        return e;
    }

    protected ContentValues f()
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("ImageID", Long.valueOf(a()));
        contentvalues.put("Level", Integer.valueOf(b().a()));
        contentvalues.put("DataPath", c());
        contentvalues.put("FileWidth", Integer.valueOf(d()));
        contentvalues.put("FileHeight", Integer.valueOf(e()));
        return contentvalues;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ImageId: ").append(a).append(", Level: ").append(b.toString()).append(", FileWidth: ").append(d).append(", FileHeight: ").append(e).append(", DataPath: ").append(c).toString();
    }
}
