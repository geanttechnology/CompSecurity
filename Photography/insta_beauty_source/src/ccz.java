// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccz
    implements Runnable
{

    final ccy a;

    ccz(ccy ccy1)
    {
        a = ccy1;
        super();
    }

    public void run()
    {
        if (ccy.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            ccy.a(a, OpenGlUtils.a(ccy.b(a), -1, true));
        }
    }
}
