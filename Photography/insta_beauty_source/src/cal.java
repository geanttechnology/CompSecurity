// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cal
    implements Runnable
{

    final cak a;

    cal(cak cak1)
    {
        a = cak1;
        super();
    }

    public void run()
    {
        if (cak.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cak.a(a, OpenGlUtils.a(cak.b(a), -1, true));
        }
    }
}
