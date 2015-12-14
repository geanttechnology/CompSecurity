// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.os.StatFs;
import java.io.File;

public class h
{

    private File a;
    private long b;
    private long c;

    public h()
    {
    }

    public static h b(File file)
    {
        h h1 = new h();
        h1.a(file);
        file = new StatFs(file.getAbsolutePath());
        long l = file.getBlockSize();
        long l1 = file.getBlockCount();
        long l2 = file.getAvailableBlocks();
        h1.a(l1 * l);
        h1.b(l * l2);
        return h1;
    }

    public File a()
    {
        return a;
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(File file)
    {
        a = file;
    }

    public long b()
    {
        return b;
    }

    public void b(long l)
    {
        c = l;
    }

    public long c()
    {
        return c;
    }

    public String toString()
    {
        return String.format("[%s : %d / %d]", new Object[] {
            a().getAbsolutePath(), Long.valueOf(c()), Long.valueOf(b())
        });
    }
}
