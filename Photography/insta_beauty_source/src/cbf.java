// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbf
    implements Runnable
{

    final cbe a;

    cbf(cbe cbe1)
    {
        a = cbe1;
        super();
    }

    public void run()
    {
        if (cbe.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbe.a(a, OpenGlUtils.a(cbe.b(a), -1, true));
        }
    }
}
