// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbz
    implements Runnable
{

    final cby a;

    cbz(cby cby1)
    {
        a = cby1;
        super();
    }

    public void run()
    {
        if (cby.a(a) == -1)
        {
            GLES20.glActiveTexture(33986);
            cby.a(a, OpenGlUtils.a(cby.b(a), -1, true));
        }
    }
}
