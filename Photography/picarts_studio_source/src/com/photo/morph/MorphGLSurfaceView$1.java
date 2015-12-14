// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;

import android.graphics.Bitmap;
import com.photo.morph.brushes.SelectBrush;
import com.photo.morph.brushes.a;

// Referenced classes of package com.photo.morph:
//            MorphGLSurfaceView, MorphRenderer, a

final class a
    implements Runnable
{

    private MorphGLSurfaceView a;

    public final void run()
    {
        com.photo.morph.MorphGLSurfaceView.a(a, com.photo.morph.MorphGLSurfaceView.a(a).c());
        MorphGLSurfaceView.b(a, com.photo.morph.MorphGLSurfaceView.a(a).d());
        MorphGLSurfaceView.b(a);
        com.photo.morph.MorphGLSurfaceView.a(a, Bitmap.createBitmap(MorphGLSurfaceView.c(a), MorphGLSurfaceView.d(a), android.graphics._fld88));
        com.photo.morph.MorphGLSurfaceView.a(a).setSelectionBitmap(MorphGLSurfaceView.e(a));
        MorphGLSurfaceView.b(a, Bitmap.createBitmap(MorphGLSurfaceView.c(a), MorphGLSurfaceView.d(a), android.graphics._fld88));
        com.photo.morph.MorphGLSurfaceView.a(a).setBrushAreaBitmap(MorphGLSurfaceView.f(a));
        if (MorphGLSurfaceView.g(a) != null)
        {
            MorphGLSurfaceView.g(a).a(com.photo.morph.MorphGLSurfaceView.a(a));
            MorphGLSurfaceView.g(a).a(MorphGLSurfaceView.f(a));
            if (MorphGLSurfaceView.g(a) instanceof SelectBrush)
            {
                ((SelectBrush)MorphGLSurfaceView.g(a)).g = MorphGLSurfaceView.e(a);
            }
        }
        if (MorphGLSurfaceView.h(a) != null)
        {
            MorphGLSurfaceView.h(a).c();
        }
    }

    (MorphGLSurfaceView morphglsurfaceview)
    {
        a = morphglsurfaceview;
        super();
    }
}
