// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;

import com.groupon.db.models.Relevance;
import com.groupon.db.models.WidgetSummary;

// Referenced classes of package com.groupon.models:
//            Assets, MoreAssets, View

public class Widget
{

    public Assets assets;
    public String displayName;
    public MoreAssets moreAssets;
    public Relevance relevanceService;
    public String treatment;
    public String type;
    public View view;
    public WidgetSummary widgetSummary;

    public Widget()
    {
        type = "";
        displayName = "";
    }
}
