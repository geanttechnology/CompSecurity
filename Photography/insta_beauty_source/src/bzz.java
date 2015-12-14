// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class bzz
    implements Runnable
{

    final bzy a;

    bzz(bzy bzy1)
    {
        a = bzy1;
        super();
    }

    public void run()
    {
        if (bzy.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            bzy.a(a, OpenGlUtils.a(bzy.b(a), -1, true));
        }
    }
}
