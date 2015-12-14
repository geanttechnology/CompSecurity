// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccj
    implements Runnable
{

    final cci a;

    ccj(cci cci1)
    {
        a = cci1;
        super();
    }

    public void run()
    {
        synchronized (a.a)
        {
            if (cci.a(a) != null && !cci.a(a).isRecycled() && cci.b(a) == -1)
            {
                GLES20.glActiveTexture(33985);
                cci.a(a, OpenGlUtils.a(cci.a(a), true));
            }
            if (cci.c(a) != null && !cci.c(a).isRecycled() && cci.d(a) == -1)
            {
                GLES20.glActiveTexture(33984);
                cci.b(a, OpenGlUtils.a(cci.c(a), true));
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
