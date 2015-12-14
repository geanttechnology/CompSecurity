// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;
import mm;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements mm
{

    final ProEditMosaicActivity a;

    public void TouchBegin()
    {
        ProEditMosaicActivity.g(a).setVisibility(0);
    }

    public void TouchEnd()
    {
        ProEditMosaicActivity.g(a).setVisibility(4);
    }

    public void onColorSelector(int i)
    {
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
        ProEditMosaicActivity.d(a).setPenColor(i);
        android.graphics.Bitmap bitmap = a.a(i);
        ProEditMosaicActivity.g(a).setImageBitmap(bitmap);
    }

    ew(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
