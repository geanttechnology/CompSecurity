// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TAdButton

public class _fullAlpha extends LayerDrawable
{

    protected int _disabledAlpha;
    protected int _fullAlpha;
    protected ColorFilter _pressedFilter;
    final TAdButton this$0;

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
            setColorFilter(_pressedFilter);
        } else
        if (!flag)
        {
            setColorFilter(null);
            setAlpha(_disabledAlpha);
        } else
        {
            setColorFilter(null);
            setAlpha(_fullAlpha);
        }
        invalidateSelf();
        return super.onStateChange(ai);
    }

    public (Drawable drawable)
    {
        this$0 = TAdButton.this;
        super(new Drawable[] {
            drawable
        });
        _pressedFilter = new LightingColorFilter(0xffcccccc, 1);
        _disabledAlpha = 100;
        _fullAlpha = 255;
    }
}
