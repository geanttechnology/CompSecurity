// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class car
    implements Runnable
{

    final caq a;

    car(caq caq1)
    {
        a = caq1;
        super();
    }

    public void run()
    {
        if (caq.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            caq.a(a, OpenGlUtils.a(caq.b(a), -1, true));
        }
    }
}
