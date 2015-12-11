// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home:
//            PrimaryMessageContentPM

public class PrimaryMessageContent
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x8c66af5dc312624bL;
    private PrimaryMessageContentPM PM;
    private String bodyCopy;
    private String callToActionButton;
    private String callToActionText;
    private String categoryCode;
    private String disclaimer;
    private String eventCode;
    private String headline;
    private String landingPageHREF;
    private String name;
    private String pageConfigHREF;
    private String subhead;

    public PrimaryMessageContent()
    {
    }

    public String getBodyCopy()
    {
        return bodyCopy;
    }

    public String getCallToActionButton()
    {
        return callToActionButton;
    }

    public String getCallToActionText()
    {
        return callToActionText;
    }

    public String getCategoryCode()
    {
        return categoryCode;
    }

    public String getDisclaimer()
    {
        return disclaimer;
    }

    public String getEventCode()
    {
        return eventCode;
    }

    public String getHeadline()
    {
        return headline;
    }

    public String getLandingPageHREF()
    {
        return landingPageHREF;
    }

    public String getName()
    {
        return name;
    }

    public PrimaryMessageContentPM getPM()
    {
        return PM;
    }

    public String getPageConfigHREF()
    {
        return pageConfigHREF;
    }

    public String getSubhead()
    {
        return subhead;
    }

    public void setBodyCopy(String s)
    {
        bodyCopy = s;
    }

    public void setCallToActionButton(String s)
    {
        callToActionButton = s;
    }

    public void setCallToActionText(String s)
    {
        callToActionText = s;
    }

    public void setCategoryCode(String s)
    {
        categoryCode = s;
    }

    public void setDisclaimer(String s)
    {
        disclaimer = s;
    }

    public void setEventCode(String s)
    {
        eventCode = s;
    }

    public void setHeadline(String s)
    {
        headline = s;
    }

    public void setLandingPageHREF(String s)
    {
        landingPageHREF = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPM(PrimaryMessageContentPM primarymessagecontentpm)
    {
        PM = primarymessagecontentpm;
    }

    public void setPageConfigHREF(String s)
    {
        pageConfigHREF = s;
    }

    public void setSubhead(String s)
    {
        subhead = s;
    }
}
