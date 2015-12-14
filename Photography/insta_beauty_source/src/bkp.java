// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.PointF;
import com.wantu.imagelib.decorator.sprite.ImageTransformPanel;

public class bkp extends gk
{

    final ImageTransformPanel a;

    private bkp(ImageTransformPanel imagetransformpanel)
    {
        a = imagetransformpanel;
        super();
    }

    public bkp(ImageTransformPanel imagetransformpanel, bko bko)
    {
        this(imagetransformpanel);
    }

    public boolean a(gi gi1)
    {
        gi1 = gi1.b();
        ImageTransformPanel.c(a, ImageTransformPanel.c(a) + ((PointF) (gi1)).x);
        ImageTransformPanel imagetransformpanel = a;
        float f = ImageTransformPanel.d(a);
        ImageTransformPanel.d(imagetransformpanel, ((PointF) (gi1)).y + f);
        return true;
    }
}
