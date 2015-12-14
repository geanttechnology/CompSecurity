// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class ahf
    implements android.view.View.OnClickListener
{

    final ProEditMosaicActivity a;

    public ahf(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

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
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.q(a), flag);
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
}
