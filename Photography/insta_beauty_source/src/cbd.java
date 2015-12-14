// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbd
    implements Runnable
{

    final cbc a;

    cbd(cbc cbc1)
    {
        a = cbc1;
        super();
    }

    public void run()
    {
        if (cbc.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbc.a(a, OpenGlUtils.a(cbc.b(a), -1, true));
        }
    }
}
