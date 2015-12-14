// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            m

public class CollageImageView extends ImageView
{

    private int a;
    private m b;

    public CollageImageView(Context context)
    {
        super(context);
    }

    public CollageImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CollageImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void a(m m1)
    {
        if (m1 == null)
        {
            return;
        }
        if (getDrawable() != null && (getDrawable() instanceof BitmapDrawable) && ((BitmapDrawable)getDrawable()).getBitmap() != null)
        {
            m1.a(a, ((BitmapDrawable)getDrawable()).getBitmap());
            return;
        } else
        {
            b = m1;
            return;
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        if (b != null && drawable != null && (drawable instanceof BitmapDrawable))
        {
            b.a(a, ((BitmapDrawable)drawable).getBitmap());
            b = null;
        }
        super.setImageDrawable(drawable);
    }

    public void setPosition(int i)
    {
        a = i;
    }
}
