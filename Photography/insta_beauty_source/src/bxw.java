// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Semaphore;
import jp.co.cyberagent.android.gpuimage.GPUImage;

public class bxw
    implements Runnable
{

    final Semaphore a;
    final GPUImage b;

    public bxw(GPUImage gpuimage, Semaphore semaphore)
    {
        b = gpuimage;
        a = semaphore;
        super();
    }

    public void run()
    {
        GPUImage.a(b).g();
        a.release();
    }
}
