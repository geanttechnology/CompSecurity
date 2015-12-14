// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdb
    implements Runnable
{

    final cda a;

    cdb(cda cda1)
    {
        a = cda1;
        super();
    }

    public void run()
    {
        if (cda.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cda.a(a, OpenGlUtils.a(cda.b(a), -1, true));
        }
    }
}
