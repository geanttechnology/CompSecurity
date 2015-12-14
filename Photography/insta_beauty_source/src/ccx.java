// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccx
    implements Runnable
{

    final ccw a;

    ccx(ccw ccw1)
    {
        a = ccw1;
        super();
    }

    public void run()
    {
        if (ccw.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            ccw.a(a, OpenGlUtils.a(ccw.b(a), -1, true));
        }
        if (ccw.c(a) == -1)
        {
            GLES20.glActiveTexture(33988);
            ccw.b(a, OpenGlUtils.a(ccw.d(a), -1, true));
        }
    }
}
