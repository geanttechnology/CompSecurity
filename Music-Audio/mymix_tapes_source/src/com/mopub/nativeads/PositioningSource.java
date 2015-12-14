// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


interface PositioningSource
{
    public static interface PositioningListener
    {

        public abstract void onFailed();

        public abstract void onLoad(MoPubNativeAdPositioning.MoPubClientPositioning mopubclientpositioning);
    }


    public abstract void loadPositions(String s, PositioningListener positioninglistener);
}
