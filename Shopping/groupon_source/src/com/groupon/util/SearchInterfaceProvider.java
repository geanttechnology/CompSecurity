// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


public interface SearchInterfaceProvider
{

    public abstract void clearFocus();

    public abstract int getMeasuredWidth();

    public abstract String getQueryText();

    public abstract boolean hasFocus();

    public abstract void hideKeyboard(boolean flag);

    public abstract boolean isInitialized();

    public abstract void requestTextFocus();

    public abstract void setQueryHint(String s);

    public abstract void setQueryText(String s);

    public abstract void setSearchBarVisibility(int i);

    public abstract void setSelection(int i);

    public abstract void showClearSearchButton(boolean flag);
}
