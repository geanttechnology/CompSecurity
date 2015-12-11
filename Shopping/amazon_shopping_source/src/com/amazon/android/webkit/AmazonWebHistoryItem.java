// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.graphics.Bitmap;

public class AmazonWebHistoryItem
{

    private final Bitmap favicon;
    private final byte flattenedData[];
    private final int id;
    private final String originalUrl;
    private final String title;
    private final String url;

    public AmazonWebHistoryItem(Bitmap bitmap, int i, String s, String s1, String s2, byte abyte0[])
    {
        favicon = bitmap;
        id = i;
        originalUrl = s;
        title = s1;
        url = s2;
        flattenedData = abyte0;
    }
}
