// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity;

public class bzs
    implements cdv
{

    final CameraCaptureActivity a;

    public bzs(CameraCaptureActivity cameracaptureactivity)
    {
        a = cameracaptureactivity;
        super();
    }

    public void a(cdu cdu)
    {
        Log.i("CameraCaptureActivity", (new StringBuilder()).append("onPrepared:encoder=").append(cdu).toString());
        if (cdu instanceof cdx)
        {
            a.a((cdx)cdu);
        }
    }

    public void b(cdu cdu)
    {
        Log.i("CameraCaptureActivity", (new StringBuilder()).append("onStopped:encoder=").append(cdu).toString());
        if (cdu instanceof cdx)
        {
            a.a(null);
        }
    }
}
