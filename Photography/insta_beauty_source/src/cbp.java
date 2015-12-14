// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbp
    implements Runnable
{

    final cbo a;

    cbp(cbo cbo1)
    {
        a = cbo1;
        super();
    }

    public void run()
    {
        if (cbo.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbo.a(a, OpenGlUtils.a(cbo.b(a), -1, true));
        }
    }
}
