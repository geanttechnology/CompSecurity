// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class caz
    implements Runnable
{

    final cay a;

    caz(cay cay1)
    {
        a = cay1;
        super();
    }

    public void run()
    {
        if (cay.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cay.a(a, OpenGlUtils.a(cay.b(a), -1, true));
        }
    }
}
