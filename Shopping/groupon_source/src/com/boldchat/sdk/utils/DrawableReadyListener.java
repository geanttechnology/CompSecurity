// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk.utils;

import android.graphics.drawable.Drawable;

public interface DrawableReadyListener
{

    public abstract void onDrawableLoadFailed(String s);

    public abstract void onDrawableReady(String s, Drawable drawable);
}
