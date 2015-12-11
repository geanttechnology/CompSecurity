// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.countryanddivision.CountryAndDivisionInitializer;
import com.groupon.util.GrouponSafeAsyncTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.groupon.service.startup:
//            StartupDirector, CountryAndDivisionEventSource

private class <init> extends GrouponSafeAsyncTask
{

    final StartupDirector this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        if (StartupDirector.access$1700(StartupDirector.this).await(5L, TimeUnit.MINUTES))
        {
            StartupDirector.access$700(StartupDirector.this).findCountryAndDivision();
        } else
        {
            StartupDirector.access$500(StartupDirector.this).fireOnCountryAndDivisionException(new RuntimeException("The update of country and division failed as upgrade timeout was reached."));
        }
        return null;
    }

    private ()
    {
        this$0 = StartupDirector.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
