// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mftd;

import java.util.ArrayList;
import java.util.List;

public class NotificationListResult
{

    public List list;
    public int pageNumber;
    public int totalEntries;
    public int totalPages;

    public NotificationListResult()
    {
        list = new ArrayList();
    }
}
