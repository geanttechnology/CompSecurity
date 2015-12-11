// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.listener;


public interface MdotMAdActionListener
{

    public abstract void adClicked();

    public abstract void leaveApplication();

    public abstract void onDismissScreen();

    public abstract void onLoadError();

    public abstract void onPlayError();

    public abstract void onPlayStop();
}
