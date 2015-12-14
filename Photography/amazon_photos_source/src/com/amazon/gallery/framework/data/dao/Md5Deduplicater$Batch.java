// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            Md5Deduplicater

private static class batchFileSize
{

    public long batchFileSize;
    public final List batchList = new ArrayList();
    public int itemCount;

    public void clear()
    {
        batchList.clear();
        itemCount = 0;
        batchFileSize = 0L;
    }

    public A()
    {
        itemCount = 0;
        batchFileSize = 0L;
    }
}
