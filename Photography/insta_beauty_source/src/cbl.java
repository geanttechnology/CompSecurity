// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbl
    implements Runnable
{

    final cbk a;

    cbl(cbk cbk1)
    {
        a = cbk1;
        super();
    }

    public void run()
    {
        if (cbk.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbk.a(a, OpenGlUtils.a(cbk.b(a), -1, true));
        }
    }
}
