// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;

import aeo;
import java.util.concurrent.Semaphore;

// Referenced classes of package jp.co.cyberagent.android.gpuimage:
//            GPUImage

class a
    implements Runnable
{

    final Semaphore a;
    final GPUImage b;

    public void run()
    {
        GPUImage.a(b).e();
        a.release();
    }

    (GPUImage gpuimage, Semaphore semaphore)
    {
        b = gpuimage;
        a = semaphore;
        super();
    }
}
