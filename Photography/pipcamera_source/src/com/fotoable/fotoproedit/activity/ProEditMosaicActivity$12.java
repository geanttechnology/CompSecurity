// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.view.View;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditMosaicActivity

class a
    implements android.view.ditMosaicActivity._cls12
{

    final ProEditMosaicActivity a;

    public void onClick(View view)
    {
        boolean flag;
        if (!view.isSelected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.o(a), flag);
        if (flag)
        {
            ProEditMosaicActivity.d(a).shiftEraser();
            ProEditMosaicActivity.d(a).setBrushImagePath("mosaicRes/paintBrush/paintBrush0.png");
            return;
        } else
        {
            ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
            return;
        }
    }

    w(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }
}
