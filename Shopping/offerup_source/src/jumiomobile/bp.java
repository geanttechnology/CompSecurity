// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

public class bp
{

    public static float a(ImageView imageview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return (float)imageview.getImageAlpha();
        } else
        {
            return imageview.getAlpha();
        }
    }

    public static ObjectAnimator a(ImageView imageview, int i, int j)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return ObjectAnimator.ofInt(imageview, "imageAlpha", new int[] {
                i, j
            });
        } else
        {
            return ObjectAnimator.ofFloat(imageview, "alpha", new float[] {
                (float)i / 255F, (float)j / 255F
            });
        }
    }

    public static void a(View view, Drawable drawable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view.setBackground(drawable);
            return;
        } else
        {
            view.setBackgroundDrawable(drawable);
            return;
        }
    }

    public static void a(ImageView imageview, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            imageview.setImageAlpha(i);
            return;
        } else
        {
            imageview.setAlpha((float)i / 255F);
            return;
        }
    }
}
