// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.graphics.Bitmap;

public final class ImageUtil
{

    public ImageUtil()
    {
    }

    public static final int getAverageColor(Bitmap bitmap, boolean flag)
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        if (bitmap == null)
        {
            return 0;
        }
        i1 = bitmap.getWidth();
        j1 = bitmap.getHeight();
        k = 1;
        l = 1;
        i = k;
        j = l;
        if (!flag) goto _L2; else goto _L1
_L1:
        float f = (float)i1 / (float)j1;
        if (f <= 1.33F) goto _L4; else goto _L3
_L3:
        i = 0;
        j = l;
_L2:
        if (i == 0 || j == 0) goto _L6; else goto _L5
_L5:
        int ai[];
        try
        {
            ai = new int[((i1 + j1) - 2) * 2];
            bitmap.getPixels(ai, 0, i1, 0, 0, i1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return 0;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            return 0;
        }
        i = 0 + i1;
        bitmap.getPixels(ai, i, i1, 0, j1 - 1, i1, 1);
        i += i1;
        bitmap.getPixels(ai, i, 1, 0, 1, 1, j1 - 2);
        bitmap.getPixels(ai, i + (j1 - 2), 1, i1 - 1, 1, 1, j1 - 2);
        bitmap = ai;
_L8:
        l = 0;
        k = 0;
        j = 0;
        i1 = bitmap.length;
        for (i = 0; i < i1; i++)
        {
            j1 = bitmap[i];
            l += (0xff0000 & j1) >> 16;
            k += (0xff00 & j1) >> 8;
            j += j1 & 0xff;
        }

        break; /* Loop/switch isn't completed */
_L4:
        i = k;
        j = l;
        if (f < 0.75F)
        {
            j = 0;
            i = k;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_308;
        }
        ai = new int[j1 * 2];
        bitmap.getPixels(ai, 0, 1, 0, 0, 1, j1);
        bitmap.getPixels(ai, j1, 1, i1 - 1, 0, 1, j1);
        bitmap = ai;
        continue; /* Loop/switch isn't completed */
        ai = new int[i1 * 2];
        bitmap.getPixels(ai, 0, i1, 0, 0, i1, 1);
        bitmap.getPixels(ai, i1, i1, 0, j1 - 1, i1, 1);
        bitmap = ai;
        if (true) goto _L8; else goto _L7
_L7:
        return 0xff000000 | l / bitmap.length << 16 | k / bitmap.length << 8 | j / bitmap.length;
        if (true) goto _L2; else goto _L9
_L9:
    }

    public static final Bitmap scaleBitmap(Bitmap bitmap, int i)
    {
        int j;
        int l;
        int i1;
        int j1;
        i1 = bitmap.getWidth();
        j1 = bitmap.getHeight();
        if (i1 <= i && j1 <= i)
        {
            return bitmap;
        }
        l = i;
        j = i;
        if (i1 <= j1) goto _L2; else goto _L1
_L1:
        int k = (i * j1) / i1;
_L4:
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, l, k, true);
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        return bitmap1;
_L2:
        k = j;
        if (j1 > i1)
        {
            l = (i * i1) / j1;
            k = j;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
