// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdh
    implements Runnable
{

    final cdg a;

    cdh(cdg cdg1)
    {
        a = cdg1;
        super();
    }

    public void run()
    {
        if (cdg.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cdg.a(a, OpenGlUtils.a(cdg.b(a), -1, true));
        }
    }
}
