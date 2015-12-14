// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccn
    implements Runnable
{

    final ccm a;

    ccn(ccm ccm1)
    {
        a = ccm1;
        super();
    }

    public void run()
    {
        if (ccm.a(a) != -1)
        {
            GLES20.glDeleteTextures(1, new int[] {
                ccm.a(a)
            }, 0);
            ccm.a(a, -1);
        }
        GLES20.glActiveTexture(33985);
        ccm.a(a, OpenGlUtils.a(ccm.b(a), -1, true));
    }
}
