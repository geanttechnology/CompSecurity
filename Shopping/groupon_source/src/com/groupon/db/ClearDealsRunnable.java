// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db;

import com.groupon.db.dao.DaoDealSummary;
import roboguice.util.Ln;

public class ClearDealsRunnable
    implements Runnable
{

    private DaoDealSummary daoDealSummary;

    public ClearDealsRunnable(DaoDealSummary daodealsummary)
    {
        daoDealSummary = daodealsummary;
    }

    public void run()
    {
        try
        {
            daoDealSummary.clearDeals();
            return;
        }
        catch (Exception exception)
        {
            Ln.w(exception);
        }
    }
}
