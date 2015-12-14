// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.bumptech.glide.load.engine.executor:
//            a

public final class GlideExecutor extends ThreadPoolExecutor
{

    public GlideExecutor()
    {
        this(a());
    }

    private GlideExecutor(int i)
    {
        this(i, ((ThreadFactory) (new a())));
    }

    private GlideExecutor(int i, ThreadFactory threadfactory)
    {
        super(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), threadfactory);
    }

    public GlideExecutor(String s)
    {
        this(a(), ((ThreadFactory) (new a(s))));
    }

    public GlideExecutor(String s, byte byte0)
    {
        this(1, ((ThreadFactory) (new a(s))));
    }

    private static int a()
    {
        File afile[];
        int i;
        try
        {
            afile = (new File("/sys/devices/system/cpu/")).listFiles(new FilenameFilter(Pattern.compile("cpu[0-9]+")) {

                private Pattern a;

                public final boolean accept(File file, String s)
                {
                    return a.matcher(s).matches();
                }

            
            {
                a = pattern;
                super();
            }
            });
        }
        catch (Throwable throwable)
        {
            if (Log.isLoggable("GlideExecutor", 6))
            {
                Log.e("GlideExecutor", "Failed to calculate accurate cpu count", throwable);
            }
            throwable = null;
        }
        if (afile != null)
        {
            i = afile.length;
        } else
        {
            i = 0;
        }
        return Math.min(4, Math.max(Math.max(1, Runtime.getRuntime().availableProcessors()), i));
    }
}
