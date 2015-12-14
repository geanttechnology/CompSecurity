// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import com.fotoable.beautyui.NewTouchImageView;

public class jx
    implements Runnable
{

    final NewTouchImageView a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private float f;
    private float g;

    public jx(NewTouchImageView newtouchimageview, float f1, float f2, float f3, float f4)
    {
        a = newtouchimageview;
        super();
        d = f2;
        b = f3;
        c = f4;
        if (f1 < f2)
        {
            e = 1.02F;
            return;
        } else
        {
            e = 0.93F;
            return;
        }
    }

    public void run()
    {
        float f1 = a.getCurImageScale();
        if (e > 1.0F && f1 < d || e < 1.0F && d < f1)
        {
            a.matrix.postScale(e, e, b, c);
            a.matrix.postTranslate(f / 10F, g / 10F);
            a.setImageMatrix(a.matrix);
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                a.postOnAnimation(this);
                return;
            } else
            {
                a.postDelayed(this, 12L);
                return;
            }
        }
        PointF pointf = NewTouchImageView.access$100(a);
        Handler handler = new Handler();
        if (NewTouchImageView.access$200(a).x != 0.0F || NewTouchImageView.access$200(a).y != 0.0F)
        {
            handler.post(new jz(a, pointf.x, pointf.y, true));
            return;
        } else
        {
            handler.post(new jz(a, pointf.x, pointf.y, false));
            return;
        }
    }
}
