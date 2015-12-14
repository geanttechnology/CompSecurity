// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vm
    implements Runnable
{

    final PipFreeStyleImageGLSurfaceView a;
    private Bitmap b;
    private String c;
    private Handler d;
    private boolean e;

    public vm(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, Bitmap bitmap, String s, Handler handler, boolean flag)
    {
        a = pipfreestyleimageglsurfaceview;
        super();
        b = bitmap;
        c = s;
        d = handler;
        e = flag;
    }

    public void run()
    {
        if (e)
        {
            PipFreeStyleImageGLSurfaceView.access$000(a).a(b, c, d);
            a.requestRender();
            return;
        } else
        {
            PipFreeStyleImageGLSurfaceView.access$000(a).b(b, c, d);
            return;
        }
    }
}
