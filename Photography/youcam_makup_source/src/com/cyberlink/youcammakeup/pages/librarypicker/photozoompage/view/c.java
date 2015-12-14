// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.view:
//            b

public class c extends ImageView
{

    public c(Context context)
    {
        super(context);
    }

    public c(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    private static void a(Drawable drawable, boolean flag)
    {
        if (!(drawable instanceof b)) goto _L2; else goto _L1
_L1:
        ((b)drawable).a(flag);
_L4:
        return;
_L2:
        if (drawable instanceof LayerDrawable)
        {
            drawable = (LayerDrawable)drawable;
            int i = 0;
            int j = drawable.getNumberOfLayers();
            while (i < j) 
            {
                a(drawable.getDrawable(i), flag);
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDetachedFromWindow()
    {
        setImageDrawable(null);
        super.onDetachedFromWindow();
    }

    public void setImageDrawable(Drawable drawable)
    {
        Drawable drawable1 = getDrawable();
        super.setImageDrawable(drawable);
        a(drawable, true);
        a(drawable1, false);
    }
}
