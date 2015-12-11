// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;


// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsRequest

public static final class minEntries
{

    public final int entriesPerPage;
    public final int minEntries;
    public final int pageNumber;

    public (int i, int j, int k)
    {
        entriesPerPage = i;
        pageNumber = j;
        minEntries = k;
    }
}
