// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cah
    implements Runnable
{

    final cag a;

    cah(cag cag1)
    {
        a = cag1;
        super();
    }

    public void run()
    {
        if (cag.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cag.a(a, OpenGlUtils.a(cag.b(a), -1, true));
        }
    }
}
