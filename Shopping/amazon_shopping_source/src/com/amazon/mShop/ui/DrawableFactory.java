// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.ui:
//            WeakReferenceBitmapDrawableFactory

public abstract class DrawableFactory
{
    public static interface DrawableFactoryInterface
    {

        public abstract Drawable createDrawable(Resources resources, Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params);

        public abstract Drawable getDefaultDrawable(Resources resources);

        public abstract void resetDefaultImage();
    }


    private static String DEFAULT_DRAWABLE_FACTORY_KEY;
    private static Map sFactoryMap = new HashMap();

    public DrawableFactory()
    {
    }

    public static DrawableFactoryInterface getInstance()
    {
        return getInstance(DEFAULT_DRAWABLE_FACTORY_KEY);
    }

    public static DrawableFactoryInterface getInstance(String s)
    {
        return (DrawableFactoryInterface)sFactoryMap.get(s);
    }

    public static DrawableFactoryInterface registerFactory(String s, DrawableFactoryInterface drawablefactoryinterface)
    {
        return (DrawableFactoryInterface)sFactoryMap.put(s, drawablefactoryinterface);
    }

    static 
    {
        DEFAULT_DRAWABLE_FACTORY_KEY = "default_factory";
        registerFactory(DEFAULT_DRAWABLE_FACTORY_KEY, new WeakReferenceBitmapDrawableFactory());
    }
}
