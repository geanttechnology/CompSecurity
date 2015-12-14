// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

public class vr
    implements Runnable
{

    final PipFreeStyleImageGLSurfaceView a;
    private Handler b;

    public vr(PipFreeStyleImageGLSurfaceView pipfreestyleimageglsurfaceview, Handler handler)
    {
        a = pipfreestyleimageglsurfaceview;
        super();
        b = handler;
    }

    public void run()
    {
        PipFreeStyleImageGLSurfaceView.access$000(a).a(b);
        a.requestRender();
    }
}
