// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.content.Context;
import com.c.a.a.a.a.c;
import com.c.a.a.a.b.b;
import com.c.a.b.a.i;
import com.c.a.c.d;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.c.a.b:
//            b

public class a
{

    public static com.c.a.a.a.b.a a()
    {
        return new b();
    }

    public static com.c.a.a.a.b a(Context context, com.c.a.a.a.b.a a1, int j, int k)
    {
        if (j > 0)
        {
            return new com.c.a.a.a.a.b(d.b(context), a1, j);
        }
        if (k > 0)
        {
            return new com.c.a.a.a.a.a(d.b(context), a1, k);
        } else
        {
            return new c(d.a(context), a1);
        }
    }

    public static com.c.a.a.a.b a(File file)
    {
        File file1 = new File(file, "uil-images");
        if (file1.exists() || file1.mkdir())
        {
            file = file1;
        }
        return new com.c.a.a.a.a.b(file, 0x200000);
    }

    public static com.c.a.a.b.c a(int j)
    {
        int k = j;
        if (j == 0)
        {
            k = (int)(Runtime.getRuntime().maxMemory() / 8L);
        }
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            return new com.c.a.a.b.a.c(k);
        } else
        {
            return new com.c.a.a.b.a.b(k);
        }
    }

    public static com.c.a.b.b.d a(boolean flag)
    {
        return new com.c.a.b.b.a(flag);
    }

    public static com.c.a.b.d.b a(Context context)
    {
        return new com.c.a.b.d.a(context);
    }

    public static Executor a(int j, int k, i l)
    {
        boolean flag;
        if (l == i.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l = new com.c.a.b.a.a.c();
        } else
        {
            l = new LinkedBlockingQueue();
        }
        l = (BlockingQueue)l;
        return new ThreadPoolExecutor(j, j, 0L, TimeUnit.MILLISECONDS, l, b(k));
    }

    public static com.c.a.b.c.a b()
    {
        return new com.c.a.b.c.c();
    }

    private static ThreadFactory b(int j)
    {
        return new com.c.a.b.b(j);
    }
}
