// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.nav;


public class MASHWebHistoryItem
{

    private String mBookmark;
    private String mUrl;

    public MASHWebHistoryItem(String s, String s1)
    {
        mUrl = s;
        mBookmark = s1;
    }

    public String getBookmark()
    {
        return mBookmark;
    }

    public void setBookmark(String s)
    {
        mBookmark = s;
    }
}
