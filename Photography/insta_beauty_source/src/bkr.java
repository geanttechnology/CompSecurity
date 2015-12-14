// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.ScaleGestureDetector;
import com.wantu.imagelib.decorator.sprite.ImageTransformPanel;

public class bkr extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final ImageTransformPanel a;

    private bkr(ImageTransformPanel imagetransformpanel)
    {
        a = imagetransformpanel;
        super();
    }

    public bkr(ImageTransformPanel imagetransformpanel, bko bko)
    {
        this(imagetransformpanel);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        ImageTransformPanel.a(a, ImageTransformPanel.a(a) * scalegesturedetector.getScaleFactor());
        ImageTransformPanel.a(a, Math.max(0.1F, Math.min(ImageTransformPanel.a(a), 10F)));
        return true;
    }
}
