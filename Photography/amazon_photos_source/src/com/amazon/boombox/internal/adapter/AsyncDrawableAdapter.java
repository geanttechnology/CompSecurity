// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.internal.adapter;

import android.graphics.drawable.Drawable;

public interface AsyncDrawableAdapter
{
    public static interface Listener
    {

        public abstract void onCountReady(int i);

        public abstract void onDrawableReady(int i, Drawable drawable);
    }


    public abstract void dispose(Drawable drawable);

    public abstract void getCount(Listener listener);

    public abstract void getDrawable(int i, int j, int k, Listener listener);
}
