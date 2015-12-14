// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbr
    implements Runnable
{

    final cbq a;

    cbr(cbq cbq1)
    {
        a = cbq1;
        super();
    }

    public void run()
    {
        if (cbq.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbq.a(a, OpenGlUtils.a(cbq.b(a), -1, true));
        }
    }
}
