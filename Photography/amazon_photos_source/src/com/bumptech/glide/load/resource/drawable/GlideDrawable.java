// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

public abstract class GlideDrawable extends Drawable
    implements Animatable
{

    public GlideDrawable()
    {
    }

    public abstract boolean isAnimated();

    public abstract void setLoopCount(int i);
}
