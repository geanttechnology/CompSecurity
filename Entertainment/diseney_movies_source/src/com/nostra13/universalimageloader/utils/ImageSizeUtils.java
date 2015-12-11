// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            L

public final class ImageSizeUtils
{

    private static int $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType[];

    static int[] $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType()
    {
        int ai[] = $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[ViewScaleType.values().length];
        try
        {
            ai[ViewScaleType.CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType = ai;
        return ai;
    }

    private ImageSizeUtils()
    {
    }

    public static int computeImageSampleSize(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
        int i;
        int j;
        boolean flag1;
        int i1;
        boolean flag2;
        boolean flag3;
        int j1;
        int k1;
        int l1;
        j = imagesize.getWidth();
        i = imagesize.getHeight();
        j1 = imagesize1.getWidth();
        k1 = imagesize1.getHeight();
        flag2 = true;
        flag3 = true;
        flag1 = true;
        i1 = j / j1;
        l1 = i / k1;
        $SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType()[viewscaletype.ordinal()];
        JVM INSTR tableswitch 1 2: default 76
    //                   1 96
    //                   2 167;
           goto _L1 _L2 _L3
_L1:
        i = ((flag1) ? 1 : 0);
_L5:
        j = i;
        if (i < 1)
        {
            j = 1;
        }
        return j;
_L2:
        if (flag)
        {
            i1 = j;
            int k = i;
            j = ((flag2) ? 1 : 0);
            do
            {
                if (i1 / 2 < j1)
                {
                    i = j;
                    if (k / 2 < k1)
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }
                i1 /= 2;
                k /= 2;
                j *= 2;
            } while (true);
        }
        i = Math.max(i1, l1);
        continue; /* Loop/switch isn't completed */
_L3:
        if (flag)
        {
            i1 = j;
            int l = i;
            j = ((flag3) ? 1 : 0);
            do
            {
                i = j;
                if (i1 / 2 < j1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i = j;
                if (l / 2 < k1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                i1 /= 2;
                l /= 2;
                j *= 2;
            } while (true);
        }
        i = Math.min(i1, l1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static float computeImageScale(ImageSize imagesize, ImageSize imagesize1, ViewScaleType viewscaletype, boolean flag)
    {
label0:
        {
            int k = imagesize.getWidth();
            int l = imagesize.getHeight();
            int j = imagesize1.getWidth();
            int i = imagesize1.getHeight();
            float f = (float)k / (float)j;
            float f1 = (float)l / (float)i;
            if (viewscaletype == ViewScaleType.FIT_INSIDE && f >= f1 || viewscaletype == ViewScaleType.CROP && f < f1)
            {
                i = (int)((float)l / f);
            } else
            {
                j = (int)((float)k / f1);
            }
            f1 = 1.0F;
            if (flag || j >= k || i >= l)
            {
                f = f1;
                if (!flag)
                {
                    break label0;
                }
                f = f1;
                if (j == k)
                {
                    break label0;
                }
                f = f1;
                if (i == l)
                {
                    break label0;
                }
            }
            f = (float)j / (float)k;
        }
        return f;
    }

    public static ImageSize defineTargetSizeForView(ImageView imageview, int i, int j)
    {
        boolean flag = false;
        DisplayMetrics displaymetrics = imageview.getContext().getResources().getDisplayMetrics();
        android.view.ViewGroup.LayoutParams layoutparams = imageview.getLayoutParams();
        int k;
        int l;
        if (layoutparams.width == -2)
        {
            l = 0;
        } else
        {
            l = imageview.getWidth();
        }
        k = l;
        if (l <= 0)
        {
            k = layoutparams.width;
        }
        l = k;
        if (k <= 0)
        {
            l = getImageViewFieldValue(imageview, "mMaxWidth");
        }
        k = l;
        if (l <= 0)
        {
            k = i;
        }
        l = k;
        if (k <= 0)
        {
            l = displaymetrics.widthPixels;
        }
        if (layoutparams.height == -2)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = imageview.getHeight();
        }
        i = k;
        if (k <= 0)
        {
            i = layoutparams.height;
        }
        k = i;
        if (i <= 0)
        {
            k = getImageViewFieldValue(imageview, "mMaxHeight");
        }
        i = k;
        if (k <= 0)
        {
            i = j;
        }
        j = i;
        if (i <= 0)
        {
            j = displaymetrics.heightPixels;
        }
        return new ImageSize(l, j);
    }

    private static int getImageViewFieldValue(Object obj, String s)
    {
        boolean flag = false;
        int i;
        int j;
        try
        {
            s = android/widget/ImageView.getDeclaredField(s);
            s.setAccessible(true);
            j = ((Integer)s.get(obj)).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            L.e(((Throwable) (obj)));
            return 0;
        }
        i = ((flag) ? 1 : 0);
        if (j > 0)
        {
            i = ((flag) ? 1 : 0);
            if (j < 0x7fffffff)
            {
                i = j;
            }
        }
        return i;
    }
}
