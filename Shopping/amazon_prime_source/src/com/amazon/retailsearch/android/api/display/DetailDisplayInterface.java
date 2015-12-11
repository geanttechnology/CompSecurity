// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display;


public interface DetailDisplayInterface
{

    public abstract boolean canGoBack();

    public abstract void clearBackstack();

    public abstract void goBack();

    public abstract void hide();

    public abstract void loadUrl(String s);

    public abstract void show();
}
