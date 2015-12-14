// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.opengl.GLES20;
import jp.co.cyberagent.android.gpuimage.OpenGlUtils;

class cbn
    implements Runnable
{

    final cbm a;

    cbn(cbm cbm1)
    {
        a = cbm1;
        super();
    }

    public void run()
    {
        if (cbm.a(a) == -1)
        {
            GLES20.glActiveTexture(33985);
            cbm.a(a, OpenGlUtils.a(cbm.b(a), -1, true));
        }
    }
}
