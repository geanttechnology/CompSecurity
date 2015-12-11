// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.i;

import android.content.Context;
import android.os.StatFs;
import com.shazam.i.b.c;
import java.io.File;

public final class a
{

    private static final com.g.b.c a;
    private static final com.g.b.c b;

    private static long a(File file, int i, int j)
    {
        long l = i;
        long l1;
        file = new StatFs(file.getAbsolutePath());
        l1 = file.getBlockCount();
        l1 = ((long)file.getBlockSize() * l1) / 50L;
        l = l1;
_L2:
        return Math.max(Math.min(l, j), i);
        file;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static com.g.b.c a()
    {
        return a;
    }

    private static com.g.b.c a(String s, int i, int j)
    {
        try
        {
            s = new File(c.a().getApplicationContext().getCacheDir(), s);
            if (!s.exists())
            {
                s.mkdirs();
            }
            s = new com.g.b.c(s, a(((File) (s)), i, j));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static com.g.b.c b()
    {
        return b;
    }

    static 
    {
        a = a("OK_HTTP_CACHE", com.shazam.android.a.a, com.shazam.android.a.b);
        b = a("PICASSO_CACHE", com.shazam.android.a.c, com.shazam.android.a.d);
    }
}
