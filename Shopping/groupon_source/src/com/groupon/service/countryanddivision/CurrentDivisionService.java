// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.countryanddivision;

import android.app.Application;
import com.groupon.models.division.Division;
import roboguice.inject.ContextScopedProvider;

// Referenced classes of package com.groupon.service.countryanddivision:
//            DivisionsService

public class CurrentDivisionService
{

    private Application application;
    private DivisionsService divisionsService;
    private ContextScopedProvider divisionsServiceProvider;

    public CurrentDivisionService()
    {
    }

    private DivisionsService getDivisionsService()
    {
        if (divisionsService == null)
        {
            divisionsService = (DivisionsService)divisionsServiceProvider.get(application);
        }
        return divisionsService;
    }

    public Division getDivisionFromServer(String s)
        throws Exception
    {
        this;
        JVM INSTR monitorenter ;
        s = getDivisionsService().getDivisionFromServerById(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }
}
