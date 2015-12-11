// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;


public interface FastBrowseItemClickListener
{

    public abstract void onAIVItemClick();

    public abstract void onAppStoreItemClick();

    public abstract void onBackButtonClick();

    public abstract boolean onItemClick(String s);
}
