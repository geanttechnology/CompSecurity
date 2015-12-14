// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import com.fotoable.beautyui.newui.MNewTouchImageView;
import java.io.PrintStream;

public class vp extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
{

    final MNewTouchImageView a;

    private vp(MNewTouchImageView mnewtouchimageview)
    {
        a = mnewtouchimageview;
        super();
    }

    public vp(MNewTouchImageView mnewtouchimageview, vn vn)
    {
        this(mnewtouchimageview);
    }

    public boolean onScale(ScaleGestureDetector scalegesturedetector)
    {
        float f;
label0:
        {
label1:
            {
                f = scalegesturedetector.getScaleFactor();
                if (android.os.Build.VERSION.SDK_INT >= 14 && MNewTouchImageView.access$100(a) == com.fotoable.beautyui.newui.MNewTouchImageView.TouchState.DRAG)
                {
                    if ((double)Math.abs(f - 1.0F) <= 0.02D)
                    {
                        break label1;
                    }
                    MNewTouchImageView.access$102(a, com.fotoable.beautyui.newui.MNewTouchImageView.TouchState.ZOOM);
                }
                float f1 = MNewTouchImageView.access$200(a);
                MNewTouchImageView.access$202(a, MNewTouchImageView.access$200(a) * f);
                System.out.println((new StringBuilder()).append("savescale:").append(MNewTouchImageView.access$200(a)).append("maxScale:").append(MNewTouchImageView.access$300(a)).toString());
                if (MNewTouchImageView.access$200(a) > MNewTouchImageView.access$300(a))
                {
                    MNewTouchImageView.access$202(a, MNewTouchImageView.access$300(a));
                    f = MNewTouchImageView.access$300(a) / f1;
                }
                if (MNewTouchImageView.access$400(a) * MNewTouchImageView.access$200(a) > (float)MNewTouchImageView.access$500(a) && MNewTouchImageView.access$600(a) * MNewTouchImageView.access$200(a) > (float)MNewTouchImageView.access$700(a))
                {
                    break label0;
                }
                MNewTouchImageView.access$800(a).postScale(f, f, MNewTouchImageView.access$500(a) / 2, MNewTouchImageView.access$700(a) / 2);
            }
            return true;
        }
        MNewTouchImageView.access$800(a).postScale(f, f, scalegesturedetector.getFocusX(), scalegesturedetector.getFocusY());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
    {
        return true;
    }
}
