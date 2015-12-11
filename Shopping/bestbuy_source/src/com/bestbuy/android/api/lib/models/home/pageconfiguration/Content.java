// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.pageconfiguration;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.home.pageconfiguration:
//            VisualPageTitle

public class Content
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private VisualPageTitle VisualPageTitle;
    private String bodyCopy;
    private String disclaimer;
    private String disclaimerCallToActionLinkTo;
    private String disclaimerCallToActionText;
    private String headline;
    private String name;
    private String permission;

    public Content()
    {
    }

    public String getBodyCopy()
    {
        return bodyCopy;
    }

    public String getDisclaimer()
    {
        return disclaimer;
    }

    public String getDisclaimerCallToActionLinkTo()
    {
        return disclaimerCallToActionLinkTo;
    }

    public String getDisclaimerCallToActionText()
    {
        return disclaimerCallToActionText;
    }

    public String getHeadline()
    {
        return headline;
    }

    public String getName()
    {
        return name;
    }

    public String getPermission()
    {
        return permission;
    }

    public VisualPageTitle getVisualPageTitle()
    {
        return VisualPageTitle;
    }

    public void setBodyCopy(String s)
    {
        bodyCopy = s;
    }

    public void setDisclaimer(String s)
    {
        disclaimer = s;
    }

    public void setDisclaimerCallToActionLinkTo(String s)
    {
        disclaimerCallToActionLinkTo = s;
    }

    public void setDisclaimerCallToActionText(String s)
    {
        disclaimerCallToActionText = s;
    }

    public void setHeadline(String s)
    {
        headline = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPermission(String s)
    {
        permission = s;
    }

    public void setVisualPageTitle(VisualPageTitle visualpagetitle)
    {
        VisualPageTitle = visualpagetitle;
    }
}
