// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Matrix;
import com.fotoable.beautyui.NewTouchImageView;

public class jz
    implements Runnable
{

    final NewTouchImageView a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private boolean h;

    public jz(NewTouchImageView newtouchimageview, float f1, float f2)
    {
        a = newtouchimageview;
        super();
        d = 0.0F;
        e = 0.0F;
        h = false;
        b = f1;
        c = f2;
        f = f1 / 10F;
        g = f2 / 10F;
    }

    public jz(NewTouchImageView newtouchimageview, float f1, float f2, boolean flag)
    {
        a = newtouchimageview;
        super();
        d = 0.0F;
        e = 0.0F;
        h = false;
        b = f1;
        c = f2;
        f = f1 / 10F;
        g = f2 / 10F;
        h = flag;
    }

    public void run()
    {
label0:
        {
            a.matrix.postTranslate(-f, -g);
            a.setImageMatrix(a.matrix);
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
        a.postDelayed(this, 12L);
    }
}
