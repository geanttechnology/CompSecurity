// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;

// Referenced classes of package net.tsz.afinal.bitmap.display:
//            Displayer

public class SimpleDisplayer
    implements Displayer
{

    public SimpleDisplayer()
    {
    }

    private void animationDisplay(ImageView imageview, Bitmap bitmap, Animation animation)
    {
        if (animation != null)
        {
            animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
            imageview.startAnimation(animation);
        }
        imageview.setImageBitmap(bitmap);
    }

    private void fadeInDisplay(ImageView imageview, Bitmap bitmap)
    {
        bitmap = new TransitionDrawable(new Drawable[] {
            new ColorDrawable(0x106000d), new BitmapDrawable(imageview.getResources(), bitmap)
        });
        imageview.setImageDrawable(bitmap);
        bitmap.startTransition(300);
    }

    public void loadCompletedisplay(ImageView imageview, Bitmap bitmap, BitmapDisplayConfig bitmapdisplayconfig)
    {
        switch (bitmapdisplayconfig.getAnimationType())
        {
        default:
            return;

        case 1: // '\001'
            fadeInDisplay(imageview, bitmap);
            return;

        case 0: // '\0'
            animationDisplay(imageview, bitmap, bitmapdisplayconfig.getAnimation());
            return;
        }
    }

    public void loadFailDisplay(ImageView imageview, Bitmap bitmap)
    {
        imageview.setImageBitmap(bitmap);
    }
}
