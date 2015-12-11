// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;


public class HistoryEntity
{

    public static final String HISTORY_PROJECTION[] = {
        "_id", "asin", "visit_date"
    };
    public static final String HISTORY_VISION_PROJECTION[] = {
        "asin", "visit_date", "original_scanned_history"
    };

    public HistoryEntity()
    {
    }

}
