// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccg
    implements Runnable
{

    final ccf a;

    ccg(ccf ccf1)
    {
        a = ccf1;
        super();
    }

    public void run()
    {
label0:
        {
            if (ccf.a(a) == -1)
            {
                GLES20.glActiveTexture(33987);
                if (!ccf.b(a))
                {
                    break label0;
                }
                ccf.a(a, OpenGlUtils.a(ccf.c(a), -1, jp.co.cyberagent.android.gpuimage.OpenGlUtils.Direction.VERTICAL, true));
            }
            return;
        }
        ccf.a(a, OpenGlUtils.a(ccf.c(a), -1, true));
    }
}
