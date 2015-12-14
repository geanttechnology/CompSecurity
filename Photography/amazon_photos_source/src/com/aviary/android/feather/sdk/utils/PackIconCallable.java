// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import com.aviary.android.feather.library.utils.BitmapUtils;
import it.sephiroth.android.library.picasso.Transformation;
import java.lang.ref.SoftReference;
import java.util.concurrent.Callable;

public class PackIconCallable
    implements Transformation, Callable
{
    public static class Builder
    {

        int alpha;
        private boolean isnew;
        boolean noBackground;
        com.aviary.android.feather.cds.AviaryCds.PackType packType;
        String path;
        Resources resources;
        boolean roundedCorners;

        public PackIconCallable build()
        {
            PackIconCallable packiconcallable = new PackIconCallable();
            if (path == null)
            {
                throw new IllegalArgumentException("path cannot be null");
            }
            if (packType == null)
            {
                throw new IllegalArgumentException("packType cannot be null");
            }
            if (resources == null)
            {
                throw new IllegalArgumentException("resources cannot be null");
            } else
            {
                packiconcallable.imagePath = path;
                packiconcallable.packType = packType;
                packiconcallable.resourcesRef = new SoftReference(resources);
                packiconcallable.roundedCorners = roundedCorners;
                packiconcallable.noBackground = noBackground;
                packiconcallable.alpha = alpha;
                packiconcallable.isnew = isnew;
                return packiconcallable;
            }
        }

        public Builder isNew(boolean flag)
        {
            isnew = flag;
            return this;
        }

        public Builder noBackground()
        {
            noBackground = true;
            return this;
        }

        public Builder roundedCorners()
        {
            roundedCorners = true;
            return this;
        }

        public Builder withAlpha(int i)
        {
            alpha = i;
            return this;
        }

        public Builder withPackType(com.aviary.android.feather.cds.AviaryCds.PackType packtype)
        {
            packType = packtype;
            return this;
        }

        public Builder withPath(String s)
        {
            path = s;
            return this;
        }

        public Builder withResources(Resources resources1)
        {
            resources = resources1;
            return this;
        }

        public Builder()
        {
            alpha = 255;
        }
    }


    private int alpha;
    int fallbackResId;
    private String imagePath;
    private boolean isnew;
    int maxSize;
    private boolean noBackground;
    private com.aviary.android.feather.cds.AviaryCds.PackType packType;
    SoftReference resourcesRef;
    private boolean roundedCorners;

    PackIconCallable()
    {
        fallbackResId = -1;
        maxSize = -1;
    }

    public Bitmap call()
        throws Exception
    {
        Bitmap bitmap1 = null;
        Resources resources = (Resources)resourcesRef.get();
        if (resources == null)
        {
            return null;
        }
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        Bitmap bitmap = bitmap1;
        if (imagePath != null)
        {
            bitmap = bitmap1;
            if (imagePath.length() > 0)
            {
                bitmap = BitmapFactory.decodeFile(imagePath, options);
            }
        }
        bitmap1 = bitmap;
        if (bitmap == null)
        {
            bitmap1 = BitmapFactory.decodeResource(resources, fallbackResId);
        }
        bitmap1 = transform(bitmap1);
        bitmap = bitmap1;
        if (maxSize > 0)
        {
            bitmap = bitmap1;
            if (bitmap1 != null)
            {
                Bitmap bitmap2 = BitmapUtils.resizeBitmap(bitmap1, maxSize, maxSize);
                bitmap = bitmap1;
                if (bitmap2 != null)
                {
                    bitmap = bitmap1;
                    if (bitmap1 != bitmap2)
                    {
                        bitmap1.recycle();
                        bitmap = bitmap2;
                    }
                }
            }
        }
        return bitmap;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    Bitmap generate(Resources resources, Bitmap bitmap)
    {
        Bitmap bitmap1 = null;
        Object obj = null;
        Object obj1 = null;
        if (resources != null)
        {
            if (com.aviary.android.feather.cds.AviaryCds.PackType.EFFECT.equals(packType))
            {
                if (!noBackground)
                {
                    obj = BitmapFactory.decodeResource(resources, com.aviary.android.feather.sdk.R.drawable.aviary_effects_pack_background);
                }
                if (obj != null)
                {
                    bitmap1 = BitmapUtils.roundedCorners(bitmap, 10F, 10F);
                    resources = BitmapUtils.flattenDrawables(new BitmapDrawable(resources, ((Bitmap) (obj))), new BitmapDrawable(resources, bitmap1), 0.76F, 0.0F);
                    obj = resources;
                    if (resources != null)
                    {
                        obj = resources;
                        if (!bitmap1.equals(resources))
                        {
                            bitmap1.recycle();
                            obj = resources;
                        }
                    }
                } else
                {
                    obj = obj1;
                    if (roundedCorners)
                    {
                        obj = BitmapUtils.roundedCorners(bitmap, 12F, 12F);
                    }
                }
            } else
            {
                obj = obj1;
                if (com.aviary.android.feather.cds.AviaryCds.PackType.STICKER.equals(packType))
                {
                    if (!noBackground)
                    {
                        int i;
                        if (isnew)
                        {
                            i = com.aviary.android.feather.sdk.R.drawable.aviary_sticker_pack_background_glow;
                        } else
                        {
                            i = com.aviary.android.feather.sdk.R.drawable.aviary_sticker_pack_background;
                        }
                        bitmap1 = BitmapFactory.decodeResource(resources, i);
                    }
                    obj = obj1;
                    if (bitmap1 != null)
                    {
                        obj = BitmapUtils.flattenDrawables(new BitmapDrawable(resources, bitmap1), new BitmapDrawable(resources, bitmap), 0.58F, 0.05F);
                    }
                }
            }
            while (obj != null) 
            {
                if (alpha == 255)
                {
                    return ((Bitmap) (obj));
                }
                resources = BitmapUtils.copy(((Bitmap) (obj)), alpha);
                if (!obj.equals(resources))
                {
                    ((Bitmap) (obj)).recycle();
                }
                return resources;
            }
        }
        return bitmap;
    }

    Bitmap generate(Resources resources, Bitmap bitmap, int i)
    {
        resources = generate(resources, bitmap);
        Bitmap bitmap1 = BitmapUtils.resizeBitmap(resources, i, i);
        if (bitmap1 != null && bitmap1 != resources && resources != bitmap)
        {
            resources.recycle();
        }
        return bitmap1;
    }

    public String key()
    {
        return (new StringBuilder()).append(imagePath).append("_").append(packType.name()).append("_").append(roundedCorners).append("_").append(noBackground).append("_").append(alpha).append("_").append(isnew).toString();
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
    static String access$002(PackIconCallable packiconcallable, String s)
    {
        packiconcallable.imagePath = s;
        return s;
    }

*/


/*
    static com.aviary.android.feather.cds.AviaryCds.PackType access$102(PackIconCallable packiconcallable, com.aviary.android.feather.cds.AviaryCds.PackType packtype)
    {
        packiconcallable.packType = packtype;
        return packtype;
    }

*/


/*
    static boolean access$202(PackIconCallable packiconcallable, boolean flag)
    {
        packiconcallable.roundedCorners = flag;
        return flag;
    }

*/


/*
    static boolean access$302(PackIconCallable packiconcallable, boolean flag)
    {
        packiconcallable.noBackground = flag;
        return flag;
    }

*/


/*
    static int access$402(PackIconCallable packiconcallable, int i)
    {
        packiconcallable.alpha = i;
        return i;
    }

*/


/*
    static boolean access$502(PackIconCallable packiconcallable, boolean flag)
    {
        packiconcallable.isnew = flag;
        return flag;
    }

*/
}
