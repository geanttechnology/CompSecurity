// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Handler;
import com.fotoable.beautyui.newui.MNewTouchImageView;

public class vo
    implements Runnable
{

    final MNewTouchImageView a;
    private final float b;
    private final float c;
    private final float d;
    private final float e;
    private float f;
    private float g;

    public vo(MNewTouchImageView mnewtouchimageview, float f1, float f2, float f3, float f4)
    {
        a = mnewtouchimageview;
        super();
        d = f2;
        b = f3;
        c = f4;
        if (f1 < f2)
        {
            e = 1.07F;
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
            MNewTouchImageView.access$800(a).postScale(e, e, b, c);
            MNewTouchImageView.access$800(a).postTranslate(f / 10F, g / 10F);
            a.setImageMatrix(MNewTouchImageView.access$800(a));
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                a.postOnAnimation(this);
                return;
            } else
            {
                a.postDelayed(this, 16L);
                return;
            }
        }
        PointF pointf = MNewTouchImageView.access$900(a);
        Handler handler = new Handler();
        if (MNewTouchImageView.access$1000(a).x != 0.0F || MNewTouchImageView.access$1000(a).y != 0.0F)
        {
            handler.post(new vr(a, pointf.x, pointf.y, true));
            return;
        } else
        {
            handler.post(new vr(a, pointf.x, pointf.y, false));
            return;
        }
    }
}
