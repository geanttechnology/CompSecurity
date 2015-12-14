// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.glide;

import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.framework.model.Persistable;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.bumptech.glide.GenericRequestBuilder;

public class BitmapResizer
{

    private static final String TAG = com/amazon/gallery/framework/glide/BitmapResizer.getName();

    public BitmapResizer()
    {
    }

    private static float floatDivide(float f, float f1)
    {
        return f / f1;
    }

    public static boolean isOversizeImage(Persistable persistable)
    {
        boolean flag1 = true;
        boolean flag2 = false;
        if (persistable instanceof MediaItem)
        {
            persistable = (MediaItem)persistable;
            boolean flag;
            if (persistable.getWidth() >= 4096)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (persistable.getHeight() < 4096)
            {
                flag1 = false;
            }
            flag2 = flag | flag1;
        }
        return flag2;
    }

    private static void overrideCenterCrop(int i, int j, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        if (mediaitem == null)
        {
            overrideWithCap(i, j, null, genericrequestbuilder);
            return;
        }
        float f = floatDivide(i, j);
        float f1 = floatDivide(mediaitem.getWidth(), mediaitem.getHeight());
        int k;
        int l;
        if (f1 > f)
        {
            l = (int)((float)j * f1);
            k = j;
        } else
        {
            l = i;
            k = (int)floatDivide(i, f1);
        }
        if (l <= 0 || k <= 0)
        {
            GLogger.warnStackTrace(TAG, "viewWidth: %d, viewHeight: %d, itemWidth: %d, itemHeight: %d, viewAspectRatio: %f, imageAspectRatio: %f, overrideWidth: %d, overrideHeight: %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(mediaitem.getWidth()), Integer.valueOf(mediaitem.getHeight()), Float.valueOf(f), Float.valueOf(f1), Integer.valueOf(l), Integer.valueOf(k)
            });
        }
        overrideWithCap(l, k, mediaitem, genericrequestbuilder);
    }

    private static void overrideFitCenter(int i, int j, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
        overrideWithCap(i, j, mediaitem, genericrequestbuilder);
    }

    public static void overrideSizeToGlideBuilder(int i, int j, MediaItem mediaitem, android.widget.ImageView.ScaleType scaletype, GenericRequestBuilder genericrequestbuilder)
    {
        if (i == 0 || j == 0)
        {
            GLogger.w(TAG, "Invalid thumbnail size lookup, width: %d, height: %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
            return;
        }
        if (scaletype == android.widget.ImageView.ScaleType.FIT_CENTER)
        {
            overrideFitCenter(i, j, mediaitem, genericrequestbuilder);
            return;
        }
        if (scaletype == android.widget.ImageView.ScaleType.CENTER_CROP)
        {
            overrideCenterCrop(i, j, mediaitem, genericrequestbuilder);
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Scale type not supported: ").append(scaletype).toString());
        }
    }

    private static void overrideWithCap(int i, int j, MediaItem mediaitem, GenericRequestBuilder genericrequestbuilder)
    {
label0:
        {
            if (i <= 0 || j <= 0)
            {
                GLogger.w(TAG, "overrideWithCap: Invalid dimensions of %dx%d for %s", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j), mediaitem
                });
                if (BuildFlavors.isDebug())
                {
                    throw new AssertionError("Invalid dimensions requested. See PHOTOS-8790.");
                }
            } else
            {
                if (i >= 4096 || j >= 4096 || mediaitem != null)
                {
                    break label0;
                }
                genericrequestbuilder.override(i, j);
            }
            return;
        }
        if (mediaitem == null)
        {
            int i1 = i;
            int k = j;
            if (i > 4096)
            {
                k = (int)(floatDivide(4096F, i) * (float)j);
                i1 = 4096;
            }
            j = i1;
            i = k;
            if (k > 4096)
            {
                j = (int)(floatDivide(4096F, k) * (float)i1);
                i = 4096;
            }
            GLogger.i(TAG, "Overriding bitmap image to final size: %dx%d, we don't know the original image size", new Object[] {
                Integer.valueOf(j), Integer.valueOf(i)
            });
            genericrequestbuilder.override(j, i);
            return;
        }
        int l = mediaitem.getWidth();
        int j1 = mediaitem.getHeight();
        int k1 = Math.max(1, Integer.highestOneBit(Math.max(l / i, j1 / j)));
        if (l / k1 >= 4096 || j1 / k1 >= 4096)
        {
            int i2 = MathUtils.roundPower2((int)Math.ceil(Math.max((1.0F * (float)l) / 4096F, (1.0F * (float)j1) / 4096F)));
            int l1 = l / i2;
            i2 = j1 / i2;
            GLogger.i(TAG, "Overriding bitmap image to final size due to larger than %d: %dx%d, origin size:%dx%d, request size: %dx%d", new Object[] {
                Integer.valueOf(4096), Integer.valueOf(l1), Integer.valueOf(i2), Integer.valueOf(l), Integer.valueOf(j1), Integer.valueOf(i), Integer.valueOf(j)
            });
            genericrequestbuilder.override(l1, i2);
            return;
        } else
        {
            genericrequestbuilder.override(i, j);
            return;
        }
    }

}
