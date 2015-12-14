// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class ahv
    implements ale
{

    final ProEditMosaicActivity a;

    public ahv(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void a()
    {
        a.b();
        if (ProEditMosaicActivity.h(a))
        {
            ProEditMosaicActivity.d(a).shiftNormalMosaic();
            ProEditMosaicActivity.k(a).addView(ProEditMosaicActivity.d(a), new android.widget.FrameLayout.LayoutParams(-1, -1));
            return;
        }
        ProEditMosaicActivity.d(a).shiftColorPen();
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.width = a.getResources().getDisplayMetrics().widthPixels - yp.a(a, 10F);
        layoutparams.height = a.getResources().getDisplayMetrics().heightPixels - yp.a(a, 152F);
        if (azn.a(a))
        {
            layoutparams.height = a.getResources().getDisplayMetrics().heightPixels - yp.a(a, 202F);
        }
        layoutparams.leftMargin = yp.a(a, 5F);
        layoutparams.topMargin = yp.a(a, 8F);
        if (azn.a(a))
        {
            layoutparams.topMargin = yp.a(a, 58F);
        }
        ProEditMosaicActivity.k(a).setLayoutParams(layoutparams);
        ProEditMosaicActivity.k(a).addView(ProEditMosaicActivity.d(a), new android.widget.FrameLayout.LayoutParams(-1, -1));
    }
}
