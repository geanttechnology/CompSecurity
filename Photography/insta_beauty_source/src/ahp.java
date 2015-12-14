// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import com.fotoable.fotoproedit.activity.ProEditMosaicActivity;
import com.fotoable.fotoproedit.activity.mosaic.MosaicGLSurfaceView;

public class ahp
    implements amt
{

    final ProEditMosaicActivity a;

    public ahp(ProEditMosaicActivity proeditmosaicactivity)
    {
        a = proeditmosaicactivity;
        super();
    }

    public void a()
    {
        ProEditMosaicActivity.g(a).setVisibility(0);
    }

    public void a(int i)
    {
        ProEditMosaicActivity.a(a, ProEditMosaicActivity.f(a));
        ProEditMosaicActivity.d(a).setPenColor(i);
        android.graphics.Bitmap bitmap = a.a(i);
        ProEditMosaicActivity.g(a).setImageBitmap(bitmap);
    }

    public void b()
    {
        ProEditMosaicActivity.g(a).setVisibility(4);
    }
}
