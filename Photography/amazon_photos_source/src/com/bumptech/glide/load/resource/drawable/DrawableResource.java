// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

public abstract class DrawableResource
    implements Resource
{

    protected final Drawable drawable;

    public DrawableResource(Drawable drawable1)
    {
        if (drawable1 == null)
        {
            throw new NullPointerException("Drawable must not be null!");
        } else
        {
            drawable = drawable1;
            return;
        }
    }

    public final Drawable get()
    {
        return drawable.getConstantState().newDrawable();
    }

    public volatile Object get()
    {
        return get();
    }
}
