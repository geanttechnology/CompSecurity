// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class alb
    implements Runnable
{

    final Bitmap a;
    final boolean b;
    final ale c;
    final MosaicGLSurfaceView d;

    public alb(MosaicGLSurfaceView mosaicglsurfaceview, Bitmap bitmap, boolean flag, ale ale)
    {
        d = mosaicglsurfaceview;
        a = bitmap;
        b = flag;
        c = ale;
        super();
    }

    public void run()
    {
        MosaicGLSurfaceView.access$002(d, MosaicGLSurfaceView.access$100(d, a));
        d.setMosaicOrPaint(b);
        (new Handler(d.getContext().getMainLooper())).post(new alc(this));
    }
}
