// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cat
    implements Runnable
{

    final cas a;

    cat(cas cas1)
    {
        a = cas1;
        super();
    }

    public void run()
    {
        if (cas.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cas.a(a, OpenGlUtils.a(cas.b(a), -1, true));
        }
    }
}
