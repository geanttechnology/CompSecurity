// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;


// Referenced classes of package com.millennialmedia.internal.adadapters:
//            InterstitialAdapter

public static interface 
{

    public abstract void initFailed();

    public abstract void initSucceeded();

    public abstract void onAdLeftApplication();

    public abstract void onClicked();

    public abstract void onClosed();

    public abstract void onExpired();

    public abstract void showFailed(com.millennialmedia.tialAdapterListener tialadapterlistener);

    public abstract void shown();
}
