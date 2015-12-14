// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import com.fotoable.beautyui.NewTouchImageView;
import java.io.PrintStream;

public class jy extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final NewTouchImageView a;

    private jy(NewTouchImageView newtouchimageview)
    {
        a = newtouchimageview;
        super();
    }

    public jy(NewTouchImageView newtouchimageview, jw jw)
    {
        this(newtouchimageview);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f = scalegesturedetector.getScaleFactor();
        float f1 = a.saveScale;
        NewTouchImageView newtouchimageview = a;
        newtouchimageview.saveScale = newtouchimageview.saveScale * f;
        System.out.println((new StringBuilder()).append("mScaleFactor:").append(f).append("maxScale:").append(a.maxScale).toString());
        if (a.saveScale > a.maxScale)
        {
            a.saveScale = a.maxScale;
            f = a.maxScale / f1;
        }
        if (a.origWidth * a.saveScale <= (float)a.viewWidth || a.origHeight * a.saveScale <= (float)a.viewHeight)
        {
            a.matrix.postScale(f, f, a.viewWidth / 2, a.viewHeight / 2);
        } else
        {
            a.matrix.postScale(f, f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        }
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }
}
