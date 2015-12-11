// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.Map;
import java.util.WeakHashMap;

public class PlaceholderImageCache
{

    private Map placeHolderMapping;
    private Resources resources;

    public PlaceholderImageCache()
    {
        placeHolderMapping = new WeakHashMap();
    }

    protected Drawable create(int i)
    {
        Drawable drawable1 = resources.getDrawable(i);
        Drawable drawable = drawable1;
        if (drawable1 == null)
        {
            drawable = resources.getDrawable(0x7f0201a3);
        }
        drawable.setCallback(null);
        return drawable;
    }

    public Drawable get(String s, int i)
    {
        Object obj = (android.graphics.drawable.Drawable.ConstantState)placeHolderMapping.get(s);
        if (obj == null)
        {
            obj = create(i);
            placeHolderMapping.put(s, ((Drawable) (obj)).getConstantState());
            return ((Drawable) (obj));
        } else
        {
            return ((android.graphics.drawable.Drawable.ConstantState) (obj)).newDrawable(resources);
        }
    }
}
