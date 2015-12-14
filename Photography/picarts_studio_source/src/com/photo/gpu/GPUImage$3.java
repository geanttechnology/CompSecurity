// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.gpu;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.util.concurrent.Semaphore;

// Referenced classes of package com.photo.gpu:
//            GPUImage

final class d
    implements Runnable
{

    private int a;
    private int b;
    private ByteBuffer c;
    private Semaphore d;

    public final void run()
    {
        GLES20.glReadPixels(0, 0, a, b, 6408, 5121, c);
        d.release();
    }

    phore(int i, int j, ByteBuffer bytebuffer, Semaphore semaphore)
    {
        a = i;
        b = j;
        c = bytebuffer;
        d = semaphore;
        super();
    }
}
