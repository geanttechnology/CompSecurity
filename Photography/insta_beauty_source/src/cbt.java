// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbt
    implements Runnable
{

    final cbs a;

    cbt(cbs cbs1)
    {
        a = cbs1;
        super();
    }

    public void run()
    {
        if (cbs.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbs.a(a, OpenGlUtils.a(cbs.b(a), -1, true));
        }
    }
}
