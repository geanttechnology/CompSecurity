// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.browser;


public interface BrowserControlsEventsListener
{

    public abstract boolean canGoBack();

    public abstract boolean canGoForward();

    public abstract void closeBrowser();

    public abstract String getCurrentURL();

    public abstract void onGoBack();

    public abstract void onGoForward();

    public abstract void onRelaod();

    public abstract void setCreatorOfView(Object obj);
}
