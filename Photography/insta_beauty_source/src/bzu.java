// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;
import jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity;

public class bzu extends Handler
{

    private WeakReference a;

    public bzu(CameraCaptureActivity cameracaptureactivity)
    {
        a = new WeakReference(cameracaptureactivity);
    }

    public void a()
    {
        a.clear();
    }

    public void handleMessage(Message message)
    {
        CameraCaptureActivity cameracaptureactivity;
        int i;
        i = message.what;
        cameracaptureactivity = (CameraCaptureActivity)a.get();
        if (cameracaptureactivity != null) goto _L2; else goto _L1
_L1:
        Log.w("CameraCaptureActivity", "CameraHandler.handleMessage: activity is null");
_L4:
        return;
_L2:
        switch (i)
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("unknown msg ").append(i).toString());

        case 0: // '\0'
            break;

        case 1: // '\001'
            cameracaptureactivity.a(((Boolean)message.obj).booleanValue());
            return;

        case 2: // '\002'
            CameraCaptureActivity.a(cameracaptureactivity);
            return;

        case 3: // '\003'
            CameraCaptureActivity.b(cameracaptureactivity);
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
