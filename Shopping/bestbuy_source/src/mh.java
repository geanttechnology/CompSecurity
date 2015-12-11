// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.hardware.Camera;
import android.os.Handler;

final class mh
    implements android.hardware.Camera.AutoFocusCallback
{

    private static final String a = mh.getSimpleName();
    private Handler b;
    private int c;

    mh()
    {
    }

    void a(Handler handler, int i)
    {
        b = handler;
        c = i;
    }

    public void onAutoFocus(boolean flag, Camera camera)
    {
        if (b != null)
        {
            camera = b.obtainMessage(c, Boolean.valueOf(flag));
            b.sendMessageDelayed(camera, 1500L);
            b = null;
        }
    }

}
