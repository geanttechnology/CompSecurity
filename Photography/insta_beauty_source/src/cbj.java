// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbj
    implements Runnable
{

    final cbi a;

    cbj(cbi cbi1)
    {
        a = cbi1;
        super();
    }

    public void run()
    {
        if (cbi.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbi.a(a, OpenGlUtils.a(cbi.b(a), -1, true));
        }
    }
}
