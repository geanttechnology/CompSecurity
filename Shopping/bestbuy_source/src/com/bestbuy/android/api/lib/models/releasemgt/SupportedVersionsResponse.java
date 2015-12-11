// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.releasemgt;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.releasemgt:
//            SupportedVersionsParent

public class SupportedVersionsResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xe1ac64dbcad0904aL;
    private String cancelButtonTitle;
    private String feedbackButtonTitle;
    private SupportedVersionsParent si;
    private String storeButtonTitle;
    private String storeLink;
    private int type;
    private String updateButtonTitle;

    public SupportedVersionsResponse()
    {
    }

    public String getCancelButtonTitle()
    {
        return cancelButtonTitle;
    }

    public String getFeedbackButtonTitle()
    {
        return feedbackButtonTitle;
    }

    public SupportedVersionsParent getSi()
    {
        return si;
    }

    public String getStoreButtonTitle()
    {
        return storeButtonTitle;
    }

    public String getStoreLink()
    {
        return storeLink;
    }

    public int getType()
    {
        return type;
    }

    public String getUpdateButtonTitle()
    {
        return updateButtonTitle;
    }

    public void setCancelButtonTitle(String s)
    {
        cancelButtonTitle = s;
    }

    public void setFeedbackButtonTitle(String s)
    {
        feedbackButtonTitle = s;
    }

    public void setSi(SupportedVersionsParent supportedversionsparent)
    {
        si = supportedversionsparent;
    }

    public void setStoreButtonTitle(String s)
    {
        storeButtonTitle = s;
    }

    public void setStoreLink(String s)
    {
        storeLink = s;
    }

    public void setType(int i)
    {
        type = i;
    }

    public void setUpdateButtonTitle(String s)
    {
        updateButtonTitle = s;
    }
}
