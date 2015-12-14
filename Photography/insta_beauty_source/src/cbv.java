// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbv
    implements Runnable
{

    final cbu a;

    cbv(cbu cbu1)
    {
        a = cbu1;
        super();
    }

    public void run()
    {
        if (cbu.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbu.a(a, OpenGlUtils.a(cbu.b(a), -1, true));
        }
    }
}
