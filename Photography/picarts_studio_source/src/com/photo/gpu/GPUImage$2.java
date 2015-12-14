// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import myobfuscated.aw.d;

// Referenced classes of package com.photo.gpu:
//            GPUImage

final class a
    implements Runnable
{

    private GPUImage a;

    public final void run()
    {
        synchronized (a.d)
        {
            a.d.d();
            a.d.notify();
        }
        return;
        exception;
        d1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (GPUImage gpuimage)
    {
        a = gpuimage;
        super();
    }
}
