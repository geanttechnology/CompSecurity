// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.bb;
import java.io.File;
import java.text.SimpleDateFormat;

public class o
{

    protected long a;
    protected String b;
    protected String c;
    protected String d;
    protected long e;

    public o(long l, File file, long l1)
    {
        a = l;
        e = l1;
        d = file.getAbsolutePath();
        file = bb.b(file.getName());
        b = file[0];
        c = file[1];
    }

    public o(long l, String s, long l1)
    {
        this(l, new File(s), l1);
    }

    public String a()
    {
        return c;
    }

    public String b()
    {
        return d;
    }

    public long c()
    {
        return e;
    }

    public String toString()
    {
        SimpleDateFormat simpledateformat = Globals.a;
        return (new StringBuilder()).append("ID: ").append(a).append(", FileName: ").append(b).append(", FileExtension: ").append(c).append(", LastModifiedTime: ").append(simpledateformat.format(Long.valueOf(e))).append(", RobustRepresentation: ").append(d).toString();
    }
}
