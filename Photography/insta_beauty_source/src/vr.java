// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import com.fotoable.beautyui.newui.MNewTouchImageView;

public class vr
    implements Runnable
{

    final MNewTouchImageView a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;

    public vr(MNewTouchImageView mnewtouchimageview, float f1, float f2)
    {
        a = mnewtouchimageview;
        super();
        d = 0.0F;
        e = 0.0F;
        b = f1;
        c = f2;
        f = f1 / 10F;
        g = f2 / 10F;
    }

    public vr(MNewTouchImageView mnewtouchimageview, float f1, float f2, boolean flag)
    {
        a = mnewtouchimageview;
        super();
        d = 0.0F;
        e = 0.0F;
        b = f1;
        c = f2;
        f = f1 / 10F;
        g = f2 / 10F;
    }

    public void run()
    {
label0:
        {
            MNewTouchImageView.access$800(a).postTranslate(-f, -g);
            a.setImageMatrix(MNewTouchImageView.access$800(a));
            d = d + f;
            e = e + g;
            if (Math.abs(d - b) > 1.0F || Math.abs(e - c) > 1.0F)
            {
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    break label0;
                }
                a.postOnAnimation(this);
            }
            return;
        }
        a.postDelayed(this, 16L);
    }
}
