// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public interface SearchInterfaceListener
{

    public abstract void onBackButtonPress();

    public abstract void onClearSearch();

    public abstract void onFinishedWithResults();

    public abstract void onSearchBarClicked();

    public abstract void onSearchBarFocusChanged(boolean flag);

    public abstract void onSearchExecuted(String s);

    public abstract void onTextChanged(CharSequence charsequence);
}
