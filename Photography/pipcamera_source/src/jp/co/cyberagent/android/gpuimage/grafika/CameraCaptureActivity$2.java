// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;

import agx;
import agy;
import aha;
import android.util.Log;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.grafika:
//            CameraCaptureActivity

class a
    implements agy
{

    final CameraCaptureActivity a;

    public void a(agx agx)
    {
        Log.i("CameraCaptureActivity", (new StringBuilder()).append("onStopped:encoder=").append(agx).toString());
        if (agx instanceof aha)
        {
            a.a(null);
        }
    }

    (CameraCaptureActivity cameracaptureactivity)
    {
        a = cameracaptureactivity;
        super();
    }
}
