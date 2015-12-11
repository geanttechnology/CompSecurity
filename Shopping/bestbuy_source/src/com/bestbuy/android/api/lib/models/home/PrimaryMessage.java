// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            PrimaryMessageContent

public class PrimaryMessage
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x96a515135d00787aL;
    private String analyticsContext;
    private String colorTheme;
    private PrimaryMessageContent content;
    private String displayDisclaimer;
    private String placement;
    private String primaryMessageStyle;
    private String primaryMessageType;
    private String smallPlacement;
    private String widgetType;

    public PrimaryMessage()
    {
    }

    public String getAnalyticsContext()
    {
        return analyticsContext;
    }

    public String getColorTheme()
    {
        return colorTheme;
    }

    public PrimaryMessageContent getContent()
    {
        return content;
    }

    public String getDisplayDisclaimer()
    {
        return displayDisclaimer;
    }

    public String getPlacement()
    {
        return placement;
    }

    public String getPrimaryMessageStyle()
    {
        return primaryMessageStyle;
    }

    public String getPrimaryMessageType()
    {
        return primaryMessageType;
    }

    public String getSmallPlacement()
    {
        return smallPlacement;
    }

    public String getWidgetType()
    {
        return widgetType;
    }

    public void setAnalyticsContext(String s)
    {
        analyticsContext = s;
    }

    public void setColorTheme(String s)
    {
        colorTheme = s;
    }

    public void setContent(PrimaryMessageContent primarymessagecontent)
    {
        content = primarymessagecontent;
    }

    public void setDisplayDisclaimer(String s)
    {
        displayDisclaimer = s;
    }

    public void setPlacement(String s)
    {
        placement = s;
    }

    public void setPrimaryMessageStyle(String s)
    {
        primaryMessageStyle = s;
    }

    public void setPrimaryMessageType(String s)
    {
        primaryMessageType = s;
    }

    public void setSmallPlacement(String s)
    {
        smallPlacement = s;
    }

    public void setWidgetType(String s)
    {
        widgetType = s;
    }
}
