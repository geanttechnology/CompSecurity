// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdd
    implements Runnable
{

    final cdc a;

    cdd(cdc cdc1)
    {
        a = cdc1;
        super();
    }

    public void run()
    {
        if (cdc.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cdc.a(a, OpenGlUtils.a(cdc.b(a), -1, true));
        }
    }
}
