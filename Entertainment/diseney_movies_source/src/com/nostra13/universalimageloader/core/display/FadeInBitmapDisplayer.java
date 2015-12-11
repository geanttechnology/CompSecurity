// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public class FadeInBitmapDisplayer
    implements BitmapDisplayer
{

    private final int durationMillis;

    public FadeInBitmapDisplayer(int i)
    {
        durationMillis = i;
    }

    public static void animate(ImageView imageview, int i)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(i);
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        imageview.startAnimation(alphaanimation);
    }

    public Bitmap display(Bitmap bitmap, ImageView imageview)
    {
        imageview.setImageBitmap(bitmap);
        animate(imageview, durationMillis);
        return bitmap;
    }
}
