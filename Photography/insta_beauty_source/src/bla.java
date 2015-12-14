// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.os.Handler;
import com.wantu.imagerender.ImageGLSurfaceView;

public class bla
    implements Runnable
{

    final ImageGLSurfaceView a;
    private Bitmap b;
    private String c;
    private float d;
    private Handler e;
    private boolean f;
    private boolean g;

    public bla(ImageGLSurfaceView imageglsurfaceview, Bitmap bitmap, String s, float f1, boolean flag, Handler handler, boolean flag1)
    {
        a = imageglsurfaceview;
        super();
        d = 1.0F;
        f = false;
        b = bitmap;
        c = s;
        d = f1;
        e = handler;
        f = flag;
        g = flag1;
    }

    public void run()
    {
        if (g)
        {
            ImageGLSurfaceView.access$000(a).a(b, c, d, e, f);
            a.getRender();
            a.requestRender();
            return;
        } else
        {
            ImageGLSurfaceView.access$000(a).b(b, c, d, e, f);
            return;
        }
    }
}
