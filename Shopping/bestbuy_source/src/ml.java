// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Point;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;

final class ml
    implements android.hardware.Camera.PreviewCallback
{

    private static final String a = ml.getSimpleName();
    private final mi b;
    private final boolean c;
    private Handler d;
    private int e;

    ml(mi mi1, boolean flag)
    {
        b = mi1;
        c = flag;
    }

    void a(Handler handler, int i)
    {
        d = handler;
        e = i;
    }

    public void onPreviewFrame(byte abyte0[], Camera camera)
    {
        Point point = b.a();
        if (!c)
        {
            camera.setPreviewCallback(null);
        }
        if (d != null)
        {
            d.obtainMessage(e, point.x, point.y, abyte0).sendToTarget();
            d = null;
        }
    }

}
