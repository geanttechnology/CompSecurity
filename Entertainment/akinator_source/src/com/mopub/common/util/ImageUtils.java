// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class ImageUtils
{

    public ImageUtils()
    {
    }

    public static Bitmap applyFastGaussianBlurToBitmap(Bitmap bitmap, int i)
    {
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        int ai[] = new int[l * i1];
        bitmap.getPixels(ai, 0, l, 0, 0, l, i1);
        for (; i >= 1; i /= 2)
        {
            for (int j = i; j < i1 - i; j++)
            {
                for (int k = i; k < l - i; k++)
                {
                    int j1 = ai[((j - i) * l + k) - i];
                    int k1 = ai[(j - i) * l + k + i];
                    int l1 = ai[(j - i) * l + k];
                    int i2 = ai[((j + i) * l + k) - i];
                    int j2 = ai[(j + i) * l + k + i];
                    int k2 = ai[(j + i) * l + k];
                    int l2 = ai[(j * l + k) - i];
                    int i3 = ai[j * l + k + i];
                    ai[j * l + k] = 0xff000000 | (j1 & 0xff) + (k1 & 0xff) + (l1 & 0xff) + (i2 & 0xff) + (j2 & 0xff) + (k2 & 0xff) + (l2 & 0xff) + (i3 & 0xff) >> 3 & 0xff | (0xff00 & j1) + (0xff00 & k1) + (0xff00 & l1) + (0xff00 & i2) + (0xff00 & j2) + (0xff00 & k2) + (0xff00 & l2) + (0xff00 & i3) >> 3 & 0xff00 | (0xff0000 & j1) + (0xff0000 & k1) + (0xff0000 & l1) + (0xff0000 & i2) + (0xff0000 & j2) + (0xff0000 & k2) + (0xff0000 & l2) + (0xff0000 & i3) >> 3 & 0xff0000;
                }

            }

        }

        bitmap.setPixels(ai, 0, l, 0, 0, l, i1);
        return bitmap;
    }

    public static void setImageViewAlpha(ImageView imageview, int i)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            imageview.setImageAlpha(i);
            return;
        } else
        {
            imageview.setAlpha(i);
            return;
        }
    }
}
