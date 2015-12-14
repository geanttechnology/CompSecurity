// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.widget;

import android.graphics.Bitmap;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.utils.Dimension;
import java.math.BigInteger;

// Referenced classes of package com.amazon.gallery.thor.widget:
//            FrameProcessor

public class RangeSeekBarFrameProcessor extends FrameProcessor
{

    private static final int FRAME_GCD;
    private static final String TAG = com/amazon/gallery/thor/widget/RangeSeekBarFrameProcessor.getName();
    private static final Dimension expectedAspectRatio;
    private static final Dimension expectedDimension = new Dimension(54, 100);

    public RangeSeekBarFrameProcessor()
    {
    }

    private Dimension computeAspectRatio(int i, int j)
    {
        int k = BigInteger.valueOf(i).gcd(BigInteger.valueOf(j)).intValue();
        return new Dimension(j / k, i / k);
    }

    private Dimension computeAspectRatio(Bitmap bitmap)
    {
        return computeAspectRatio(bitmap.getHeight(), bitmap.getWidth());
    }

    private Bitmap cut(Bitmap bitmap, Dimension dimension)
    {
        GLogger.v(TAG, "Cutting to dimension: %s", new Object[] {
            dimension
        });
        int i = bitmap.getWidth();
        int j = bitmap.getHeight();
        if (dimension.w > i || dimension.h > j)
        {
            throw new IllegalArgumentException("Cut dimension does not fit within frame.");
        } else
        {
            int k = (i - dimension.w) / 2;
            int l = (j - dimension.h) / 2;
            GLogger.v(TAG, "Cutting at [left: %d; top: %d; width: %d; height: %d]", new Object[] {
                Integer.valueOf(k), Integer.valueOf(l), Integer.valueOf(i), Integer.valueOf(j)
            });
            return Bitmap.createBitmap(bitmap, k, l, dimension.w, dimension.h);
        }
    }

    private Bitmap cutAndScale(Bitmap bitmap)
    {
        Dimension dimension = new Dimension(bitmap.getWidth(), bitmap.getHeight());
        GLogger.v(TAG, "Cutting and scaling frame: %s", new Object[] {
            dimension
        });
        if ((float)dimension.h / (float)dimension.w < (float)expectedDimension.h / (float)expectedDimension.w)
        {
            GLogger.v(TAG, "Skinny cut.", new Object[0]);
            float f = (float)dimension.h / (float)expectedDimension.h;
            return Bitmap.createScaledBitmap(cut(bitmap, new Dimension(expectedDimension, f)), expectedDimension.w, expectedDimension.h, true);
        } else
        {
            GLogger.v(TAG, "Fat cut.", new Object[0]);
            float f1 = (float)dimension.w / (float)expectedDimension.w;
            return Bitmap.createScaledBitmap(cut(bitmap, new Dimension(expectedDimension, f1)), expectedDimension.w, expectedDimension.h, true);
        }
    }

    private Bitmap processLandscape(Bitmap bitmap)
    {
        Dimension dimension = new Dimension(bitmap.getWidth(), bitmap.getHeight());
        GLogger.v(TAG, "Processing landscape: %s", new Object[] {
            dimension
        });
        return cutAndScale(bitmap);
    }

    private Bitmap processPortrait(Bitmap bitmap)
    {
        Dimension dimension = new Dimension(bitmap.getWidth(), bitmap.getHeight());
        GLogger.v(TAG, "Processing portrait: %s", new Object[] {
            dimension
        });
        if (expectedDimension.equals(dimension))
        {
            GLogger.v(TAG, "Portrait had expected dimension. Returning original", new Object[0]);
            return bitmap;
        }
        Dimension dimension1 = computeAspectRatio(bitmap);
        if (expectedAspectRatio.equals(dimension1))
        {
            GLogger.v(TAG, "Portrait had expected aspect ratio and just needs scaling.", new Object[0]);
            dimension = new Dimension(dimension1, (float)expectedDimension.h / (float)dimension.h);
            return Bitmap.createScaledBitmap(bitmap, dimension.w, dimension.h, true);
        } else
        {
            GLogger.v(TAG, "Portrait did not have expected aspect ratio -- needs cut and scaling.", new Object[0]);
            return cutAndScale(bitmap);
        }
    }

    public Bitmap process(Bitmap bitmap)
    {
        if (bitmap.getHeight() >= bitmap.getWidth())
        {
            return processPortrait(bitmap);
        } else
        {
            return processLandscape(bitmap);
        }
    }

    static 
    {
        FRAME_GCD = BigInteger.valueOf(100L).gcd(BigInteger.valueOf(54L)).intValue();
        expectedAspectRatio = new Dimension(54 / FRAME_GCD, 100 / FRAME_GCD);
    }
}
