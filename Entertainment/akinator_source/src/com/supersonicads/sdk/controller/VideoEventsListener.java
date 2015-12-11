// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;


public interface VideoEventsListener
{

    public abstract void onVideoEnded();

    public abstract void onVideoPaused();

    public abstract void onVideoResumed();

    public abstract void onVideoStarted();

    public abstract void onVideoStopped();
}
