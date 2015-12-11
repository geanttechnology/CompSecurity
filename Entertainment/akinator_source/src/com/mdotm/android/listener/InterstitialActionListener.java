// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.listener;


public interface InterstitialActionListener
{

    public abstract void loadPendingCompanion();

    public abstract void onClick();

    public abstract void onDismiss();

    public abstract void onFailed();

    public abstract void onLeave();

    public abstract void onRewardedVideoComplete(boolean flag, String s);
}
