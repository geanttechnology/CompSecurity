// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cca
    implements Runnable
{

    final cby a;

    cca(cby cby1)
    {
        a = cby1;
        super();
    }

    public void run()
    {
label0:
        {
            if (cby.c(a) == -1)
            {
                GLES20.glActiveTexture(33987);
                if (!cby.d(a))
                {
                    break label0;
                }
                cby.b(a, OpenGlUtils.a(cby.e(a), -1, jp.co.cyberagent.android.gpuimage.OpenGlUtils.Direction.VERTICAL, true));
            }
            return;
        }
        cby.b(a, OpenGlUtils.a(cby.e(a), -1, true));
    }
}
