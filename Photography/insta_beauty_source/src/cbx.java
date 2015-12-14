// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbx
    implements Runnable
{

    final cbw a;

    cbx(cbw cbw1)
    {
        a = cbw1;
        super();
    }

    public void run()
    {
        if (cbw.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbw.a(a, OpenGlUtils.a(cbw.b(a), -1, true));
        }
    }
}
