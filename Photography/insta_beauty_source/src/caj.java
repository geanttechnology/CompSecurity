// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class caj
    implements Runnable
{

    final cai a;

    caj(cai cai1)
    {
        a = cai1;
        super();
    }

    public void run()
    {
        if (cai.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cai.a(a, OpenGlUtils.a(cai.b(a), -1, true));
        }
    }
}
