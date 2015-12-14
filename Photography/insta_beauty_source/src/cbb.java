// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbb
    implements Runnable
{

    final cba a;

    cbb(cba cba1)
    {
        a = cba1;
        super();
    }

    public void run()
    {
        if (cba.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cba.a(a, OpenGlUtils.a(cba.b(a), -1, true));
        }
    }
}
