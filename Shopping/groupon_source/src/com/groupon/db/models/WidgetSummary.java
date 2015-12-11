// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

// Referenced classes of package com.groupon.db.models:
//            AttrsContainer

public class WidgetSummary extends AttrsContainer
{

    public String campaign;
    public String channel;
    public Collection dealSummaries;
    public String displayName;
    public Date modificationDate;
    public int moreAssetsDealsCount;
    public String moreAssetsDealsUrl;
    public Long primaryKey;
    public String relevanceServiceContext;
    public String relevanceServiceTreatment;
    public String requestId;
    public String scenarioId;
    public String scenarioTreatment;
    public String slotId;
    public String treatment;
    public String type;
    public String viewLayout;

    public WidgetSummary()
    {
        type = "";
        displayName = "";
        scenarioId = "";
        scenarioTreatment = "";
        requestId = "";
        slotId = "";
        relevanceServiceTreatment = "";
        relevanceServiceContext = "";
        treatment = "";
        campaign = "";
        moreAssetsDealsUrl = "";
        moreAssetsDealsCount = -1;
        viewLayout = "";
        dealSummaries = Collections.emptyList();
    }
}
