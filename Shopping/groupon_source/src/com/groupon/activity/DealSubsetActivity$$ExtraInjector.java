// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            DealSubsetActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, DealSubsetActivity dealsubsetactivity, Object obj)
    {
        Object obj1 = r.r(obj, "partial_deal_subset_url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'partial_deal_subset_url' for field 'partialDealSubsetUrl' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.partialDealSubsetUrl = (String)obj1;
        obj1 = r.bsetUrl(obj, "subset_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'subset_id' for field 'subsetId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.subsetId = (String)obj1;
        obj1 = r.bsetUrl(obj, "title");
        if (obj1 != null)
        {
            dealsubsetactivity.title = (String)obj1;
        }
        obj1 = r.bsetUrl(obj, "widget_campaign");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'widget_campaign' for field 'widgetCampaign' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.widgetCampaign = (String)obj1;
        obj1 = r.n(obj, "widget_request_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'widget_request_id' for field 'widgetRequestId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.widgetRequestId = (String)obj1;
        obj1 = r.Id(obj, "widget_treatment");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'widget_treatment' for field 'widgetTreatment' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.widgetTreatment = (String)obj1;
        obj1 = r.nt(obj, "widget_scenario_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'widget_scenario_id' for field 'widgetScenarioId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.widgetScenarioId = (String)obj1;
        obj1 = r.oId(obj, "originating_channel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'originating_channel' for field 'originatingChannel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        dealsubsetactivity.originatingChannel = (Channel)obj1;
        obj1 = r.annel(obj, "slot_id");
        if (obj1 != null)
        {
            dealsubsetactivity.slotId = (String)obj1;
        }
        r = ((com.f2prateek.dart.annel) (r.annel(obj, "num_deal_subset_activities_on_stack")));
        if (r != null)
        {
            dealsubsetactivity.numDealSubsetActivitiesOnStack = ((Integer)r).intValue();
        }
    }

    public ()
    {
    }
}
