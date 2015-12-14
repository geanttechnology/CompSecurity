// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;


public interface FeatureChecker
{

    public abstract boolean alwaysTransparentHAB();

    public abstract int getContextMenuResource();

    public abstract int getScreenOrientation();

    public abstract boolean hasCloudSync();

    public abstract boolean hasFTUE();

    public abstract boolean hasFreetimeActionBar();

    public abstract boolean hasLeftPanel();

    public abstract boolean hasSingleLayout();

    public abstract boolean hasWhisperplay();
}
