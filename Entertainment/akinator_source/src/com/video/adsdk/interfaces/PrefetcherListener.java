// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;

import com.video.adsdk.internal.ADVideoFile;

public interface PrefetcherListener
{

    public abstract void onPrefetchedFile(ADVideoFile advideofile);

    public abstract void onPrefetchingDidComplete();

    public abstract void onPrefetchingFailed();

    public abstract void onPrefetchingStarted();

    public abstract void onProgress(double d);
}
