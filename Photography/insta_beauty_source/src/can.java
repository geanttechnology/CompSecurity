// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class can
    implements Runnable
{

    final cam a;

    can(cam cam1)
    {
        a = cam1;
        super();
    }

    public void run()
    {
        if (cam.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cam.a(a, OpenGlUtils.a(cam.b(a), -1, true));
        }
    }
}
