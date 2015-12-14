// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.File;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class apf
    implements Runnable
{

    final ape a;

    apf(ape ape1)
    {
        a = ape1;
        super();
    }

    public void run()
    {
        int i = 0;
        File afile[] = a.a.listFiles();
        if (afile != null)
        {
            int l = afile.length;
            int j = 0;
            int k = 0;
            for (; i < l; i++)
            {
                File file = afile[i];
                k = (int)((long)k + ape.b(a, file));
                j++;
                ape.a(a).put(file, Long.valueOf(file.lastModified()));
            }

            ape.b(a).set(k);
            ape.c(a).set(j);
        }
    }
}
