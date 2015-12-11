// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package com.amazon.mShop.details:
//            ItemViewUtils

static final class val.imageView
    implements Runnable
{

    final Drawable val$drawable;
    final ImageView val$imageView;

    public void run()
    {
        if (val$drawable == null)
        {
            val$imageView.setImageResource(com.amazon.mShop.android.lib.ge);
            return;
        } else
        {
            val$imageView.setImageDrawable(val$drawable);
            return;
        }
    }

    (Drawable drawable1, ImageView imageview)
    {
        val$drawable = drawable1;
        val$imageView = imageview;
        super();
    }
}
