// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cax
    implements Runnable
{

    final caw a;

    cax(caw caw1)
    {
        a = caw1;
        super();
    }

    public void run()
    {
        if (caw.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            caw.a(a, OpenGlUtils.a(caw.b(a), -1, true));
        }
    }
}
