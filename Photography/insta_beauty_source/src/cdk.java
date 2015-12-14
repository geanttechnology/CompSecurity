// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cdk
    implements Runnable
{

    final cdj a;

    cdk(cdj cdj1)
    {
        a = cdj1;
        super();
    }

    public void run()
    {
        if (cdj.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cdj.a(a, OpenGlUtils.a(cdj.b(a), -1, true));
        }
    }
}
