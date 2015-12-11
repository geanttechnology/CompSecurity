// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;


public class ItemPosition
{

    public final long itemId;
    public final int offset;
    public final int position;

    public ItemPosition(int i, long l, int j)
    {
        position = i;
        itemId = l;
        offset = j;
    }
}
