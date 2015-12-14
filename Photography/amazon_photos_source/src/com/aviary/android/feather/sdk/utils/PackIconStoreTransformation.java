// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import com.aviary.android.feather.library.utils.BitmapUtils;
import it.sephiroth.android.library.picasso.Transformation;
import java.lang.ref.SoftReference;

public class PackIconStoreTransformation
    implements Transformation
{
    public static class Builder
    {

        String identifier;
        String packType;
        Resources resources;

        public PackIconStoreTransformation build()
            throws IllegalArgumentException
        {
            PackIconStoreTransformation packiconstoretransformation = new PackIconStoreTransformation();
            if (packType == null)
            {
                throw new IllegalArgumentException("packType cannot be null");
            }
            if (resources == null)
            {
                throw new IllegalArgumentException("resources cannot be null");
            } else
            {
                packiconstoretransformation.identifier = identifier;
                packiconstoretransformation.packType = packType;
                packiconstoretransformation.resourcesRef = new SoftReference(resources);
                return packiconstoretransformation;
            }
        }

        public Builder withIdentifier(String s)
        {
            identifier = s;
            return this;
        }

        public Builder withPackType(String s)
        {
            packType = s;
            return this;
        }

        public Builder withResources(Resources resources1)
        {
            resources = resources1;
            return this;
        }

        public Builder()
        {
        }
    }


    private int backgroundColor;
    private float ellipseSize;
    private String identifier;
    private String packType;
    SoftReference resourcesRef;
    private int shadowColor;
    private float shadowOffset;
    private int strokeColor;
    private float strokeSize;

    PackIconStoreTransformation()
    {
        shadowColor = 0x55000000;
        strokeColor = -1;
        backgroundColor = 0xff8d8f93;
    }

    private float dp2px(DisplayMetrics displaymetrics, int i)
    {
        return displaymetrics.density * (float)i;
    }

    Bitmap generate(Resources resources, Bitmap bitmap)
    {
        Object obj;
        for (obj = null; resources == null || bitmap == null;)
        {
            return bitmap;
        }

        resources = resources.getDisplayMetrics();
        strokeSize = dp2px(resources, 4);
        shadowOffset = dp2px(resources, 1);
        ellipseSize = dp2px(resources, 3);
        if (!"effect".equals(packType)) goto _L2; else goto _L1
_L1:
        obj = BitmapUtils.circleMask(bitmap, bitmap.getWidth() / 2);
        resources = Bitmap.createBitmap(((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), ((Bitmap) (obj)).getConfig());
        Canvas canvas = new Canvas(resources);
        Paint paint1 = new Paint(1);
        paint1.setColor(shadowColor);
        int i = resources.getWidth() / 2;
        canvas.drawCircle(resources.getWidth() / 2, resources.getHeight() / 2, i, paint1);
        paint1.setColor(-1);
        canvas.drawCircle(resources.getWidth() / 2, resources.getHeight() / 2, (float)i - shadowOffset / 2.0F, paint1);
        canvas.drawBitmap(((Bitmap) (obj)), null, new RectF(strokeSize + shadowOffset, strokeSize + shadowOffset, (float)resources.getWidth() - (strokeSize + shadowOffset), (float)resources.getHeight() - (strokeSize + shadowOffset)), paint1);
        ((Bitmap) (obj)).recycle();
_L4:
        if (resources != null && !resources.equals(bitmap))
        {
            bitmap.recycle();
        }
        return resources;
_L2:
        if ("sticker".equals(packType))
        {
            obj = BitmapUtils.circleMask(bitmap, bitmap.getWidth() / 2);
            resources = Bitmap.createBitmap(((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), ((Bitmap) (obj)).getConfig());
            Canvas canvas1 = new Canvas(resources);
            Paint paint2 = new Paint(1);
            paint2.setColor(shadowColor);
            int j = resources.getWidth() / 2;
            canvas1.drawCircle(resources.getWidth() / 2, resources.getHeight() / 2, j, paint2);
            paint2.setColor(-1);
            canvas1.drawCircle(resources.getWidth() / 2, resources.getHeight() / 2, (float)j - shadowOffset / 2.0F, paint2);
            RectF rectf1 = new RectF(strokeSize + shadowOffset, strokeSize + shadowOffset, (float)resources.getWidth() - (strokeSize + shadowOffset), (float)resources.getHeight() - (strokeSize + shadowOffset));
            paint2.setColor(backgroundColor);
            canvas1.drawCircle(resources.getWidth() / 2, resources.getHeight() / 2, (float)j - (shadowOffset + strokeSize) / 2.0F, paint2);
            canvas1.drawBitmap(((Bitmap) (obj)), null, rectf1, paint2);
            ((Bitmap) (obj)).recycle();
            continue; /* Loop/switch isn't completed */
        }
        if (!"frame".equals(packType))
        {
            resources = ((Resources) (obj));
            if (!"overlay".equals(packType))
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        resources = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        obj = new Canvas(resources);
        Paint paint = new Paint(1);
        paint.setColor(shadowColor);
        RectF rectf = new RectF(0.0F, 0.0F, resources.getWidth(), resources.getHeight());
        ((Canvas) (obj)).drawRoundRect(rectf, 12F, 12F, paint);
        paint.setColor(strokeColor);
        rectf.set(1.0F, 1.0F, (float)resources.getWidth() - shadowOffset, (float)resources.getHeight() - shadowOffset);
        ((Canvas) (obj)).drawRoundRect(rectf, ellipseSize, ellipseSize, paint);
        ((Canvas) (obj)).drawBitmap(bitmap, null, new RectF(1.0F + strokeSize, 1.0F + strokeSize, (float)resources.getWidth() - (strokeSize + shadowOffset), (float)resources.getHeight() - (strokeSize + shadowOffset)), paint);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String key()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("_").append(identifier).append("_").append(packType).append("_").toString();
    }

    public Bitmap transform(Bitmap bitmap)
    {
        Object obj = (Resources)resourcesRef.get();
        if (obj == null)
        {
            return null;
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap != null)
        {
            obj = generate(((Resources) (obj)), bitmap);
            bitmap1 = bitmap;
            if (obj != null)
            {
                bitmap1 = bitmap;
                if (obj != bitmap)
                {
                    bitmap.recycle();
                    bitmap1 = ((Bitmap) (obj));
                }
            }
        }
        return bitmap1;
    }


/*
    static String access$002(PackIconStoreTransformation packiconstoretransformation, String s)
    {
        packiconstoretransformation.identifier = s;
        return s;
    }

*/


/*
    static String access$102(PackIconStoreTransformation packiconstoretransformation, String s)
    {
        packiconstoretransformation.packType = s;
        return s;
    }

*/
}
