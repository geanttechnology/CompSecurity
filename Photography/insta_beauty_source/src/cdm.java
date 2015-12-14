// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdm
    implements Runnable
{

    final cdl a;

    cdm(cdl cdl1)
    {
        a = cdl1;
        super();
    }

    public void run()
    {
        if (cdl.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cdl.a(a, OpenGlUtils.a(cdl.b(a), -1, true));
        }
    }
}
