// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.nostra13.universalimageloader.a.a.a.b;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.b.f;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            b

public class a
{

    private static int a(ActivityManager activitymanager)
    {
        return activitymanager.getLargeMemoryClass();
    }

    public static com.nostra13.universalimageloader.a.a.a a(Context context, com.nostra13.universalimageloader.a.a.b.a a1, long l, int i)
    {
        File file;
        Object obj;
        file = b(context);
        if (l <= 0L && i <= 0)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        obj = f.b(context);
        obj = new com.nostra13.universalimageloader.a.a.a.a.f(((File) (obj)), file, a1, l, i);
        return ((com.nostra13.universalimageloader.a.a.a) (obj));
        IOException ioexception;
        ioexception;
        com.nostra13.universalimageloader.b.d.a(ioexception);
        return new b(f.a(context), file, a1);
    }

    public static com.nostra13.universalimageloader.a.b.a a(Context context, int i)
    {
        int j = i;
        if (i == 0)
        {
            ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
            i = activitymanager.getMemoryClass();
            if (d() && c(context))
            {
                i = a(activitymanager);
            }
            j = (i * 0x100000) / 8;
        }
        return new com.nostra13.universalimageloader.a.b.a.b(j);
    }

    public static com.nostra13.universalimageloader.core.a.d a(boolean flag)
    {
        return new com.nostra13.universalimageloader.core.a.a(flag);
    }

    public static ImageDownloader a(Context context)
    {
        return new com.nostra13.universalimageloader.core.download.a(context);
    }

    public static Executor a()
    {
        return Executors.newCachedThreadPool(a(5, "uil-pool-d-"));
    }

    public static Executor a(int i, int j, QueueProcessingType queueprocessingtype)
    {
        boolean flag;
        if (queueprocessingtype == QueueProcessingType.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            queueprocessingtype = new LIFOLinkedBlockingDeque();
        } else
        {
            queueprocessingtype = new LinkedBlockingQueue();
        }
        queueprocessingtype = (BlockingQueue)queueprocessingtype;
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, queueprocessingtype, a(j, "uil-pool-"));
    }

    private static ThreadFactory a(int i, String s)
    {
        return new com.nostra13.universalimageloader.core.b(i, s);
    }

    public static com.nostra13.universalimageloader.a.a.b.a b()
    {
        return new com.nostra13.universalimageloader.a.a.b.b();
    }

    private static File b(Context context)
    {
        context = f.a(context, false);
        File file = new File(context, "uil-images");
        if (file.exists() || file.mkdir())
        {
            context = file;
        }
        return context;
    }

    public static com.nostra13.universalimageloader.core.b.a c()
    {
        return new com.nostra13.universalimageloader.core.b.b();
    }

    private static boolean c(Context context)
    {
        return (context.getApplicationInfo().flags & 0x100000) != 0;
    }

    private static boolean d()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }
}
