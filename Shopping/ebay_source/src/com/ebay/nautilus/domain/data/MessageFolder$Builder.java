// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            MessageFolder

public static class totalMessageCount
{

    private long folderId;
    private String folderName;
    private int newMessageCount;
    private int totalMessageCount;

    public MessageFolder build()
    {
        return new MessageFolder(folderId, folderName, newMessageCount, totalMessageCount);
    }

    public totalMessageCount folderId(long l)
    {
        folderId = l;
        return this;
    }

    public folderId folderName(String s)
    {
        folderName = s;
        return this;
    }

    public folderName newMessageCount(int i)
    {
        newMessageCount = i;
        return this;
    }

    public newMessageCount totalMessageCount(int i)
    {
        totalMessageCount = i;
        return this;
    }

    public _cls9()
    {
        folderId = -1L;
    }

    public folderId(long l)
    {
        folderId = l;
    }

    public folderId(long l, String s, int i, int j)
    {
        folderId = l;
        folderName = s;
        newMessageCount = i;
        totalMessageCount = j;
    }
}
