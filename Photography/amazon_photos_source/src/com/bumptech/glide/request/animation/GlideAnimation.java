// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface GlideAnimation
{
    public static interface ViewAdapter
    {

        public abstract Drawable getCurrentDrawable();

        public abstract View getView();

        public abstract void setDrawable(Drawable drawable);
    }


    public abstract boolean animate(Object obj, ViewAdapter viewadapter);
}
