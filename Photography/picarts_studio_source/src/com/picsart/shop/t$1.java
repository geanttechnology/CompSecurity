// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.d;
import com.picsart.studio.utils.DynamicHeightImageView;

// Referenced classes of package com.picsart.shop:
//            t, u

final class t>
    implements d
{

    private u a;

    public final boolean a(Object obj)
    {
        Object obj1 = (Drawable)obj;
        DynamicHeightImageView dynamicheightimageview = null;
        obj = dynamicheightimageview;
        if (obj1 instanceof BitmapDrawable)
        {
            obj1 = (BitmapDrawable)obj1;
            obj = dynamicheightimageview;
            if (((BitmapDrawable) (obj1)).getBitmap() != null)
            {
                obj = ((BitmapDrawable) (obj1)).getBitmap();
            }
        }
        dynamicheightimageview = a.a;
        double d1;
        if (obj == null)
        {
            d1 = 1.0D;
        } else
        {
            d1 = (float)((Bitmap) (obj)).getHeight() / (float)((Bitmap) (obj)).getWidth();
        }
        dynamicheightimageview.setHeightRatio(d1);
        return false;
    }

    ap(u u1)
    {
        a = u1;
        super();
    }
}
