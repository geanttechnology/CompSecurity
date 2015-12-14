// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class ccp
    implements Runnable
{

    final cco a;

    ccp(cco cco1)
    {
        a = cco1;
        super();
    }

    public void run()
    {
        if (cco.a(a) == -1)
        {
            GLES20.glActiveTexture(33990);
            cco.a(a, OpenGlUtils.a(cco.b(a), -1, true));
        }
    }
}
