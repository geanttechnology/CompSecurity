// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.instamag.activity.view.SAutoBgFrameLayout;

public class rf extends LayerDrawable
{

    protected ColorFilter a;
    protected int b;
    protected int c;
    final SAutoBgFrameLayout d;

    public rf(SAutoBgFrameLayout sautobgframelayout, Drawable drawable)
    {
        d = sautobgframelayout;
        super(new Drawable[] {
            drawable
        });
        a = new LightingColorFilter(0xffcccccc, 1);
        b = 100;
        c = 255;
    }

    public boolean isStateful()
    {
        return true;
    }

    protected boolean onStateChange(int ai[])
    {
        boolean flag1 = false;
        int j = ai.length;
        int i = 0;
        boolean flag = false;
        while (i < j) 
        {
            int k = ai[i];
            boolean flag2;
            if (k == 0x101009e)
            {
                flag2 = true;
            } else
            {
                flag2 = flag;
                if (k == 0x10100a7)
                {
                    flag1 = true;
                    flag2 = flag;
                }
            }
            i++;
            flag = flag2;
        }
        mutate();
        if (flag && flag1)
        {
            setColorFilter(a);
        } else
        if (!flag)
        {
            setColorFilter(null);
            setAlpha(b);
        } else
        {
            setColorFilter(null);
            setAlpha(c);
        }
        invalidateSelf();
        return super.onStateChange(ai);
    }
}
