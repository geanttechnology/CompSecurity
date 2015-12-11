// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.startup;

import com.groupon.service.countryanddivision.CountryAndDivisionInitializer;
import com.groupon.service.countryanddivision.listener.CountryAndDivisionInitializerListener;

// Referenced classes of package com.groupon.service.startup:
//            StartupDirector, CountryAndDivisionEventSource

private class <init>
    implements CountryAndDivisionInitializerListener
{

    final StartupDirector this$0;

    public void onCountryAndDivisionSet()
    {
        StartupDirector.access$900(StartupDirector.this);
    }

    public void onException(Exception exception)
    {
        StartupDirector.access$802(StartupDirector.this, false);
        StartupDirector.access$500(StartupDirector.this).fireOnCountryAndDivisionException(exception);
        StartupDirector.access$700(StartupDirector.this).removeCountryAndDivisionInitializerListener(StartupDirector.access$600(StartupDirector.this));
    }

    public void onManualCountrySelectionNeeded()
    {
        StartupDirector.access$500(StartupDirector.this).fireOnManualCountrySelectionNeeded();
        StartupDirector.access$700(StartupDirector.this).removeCountryAndDivisionInitializerListener(StartupDirector.access$600(StartupDirector.this));
        StartupDirector.access$802(StartupDirector.this, false);
    }

    public void onManualDivisionSelectionNeeded()
    {
        StartupDirector.access$500(StartupDirector.this).fireOnManualDivisionSelectionNeeded();
        StartupDirector.access$700(StartupDirector.this).removeCountryAndDivisionInitializerListener(StartupDirector.access$600(StartupDirector.this));
        StartupDirector.access$802(StartupDirector.this, false);
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
