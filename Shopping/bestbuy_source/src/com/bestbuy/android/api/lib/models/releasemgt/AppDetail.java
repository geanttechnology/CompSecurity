// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.releasemgt;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.releasemgt:
//            ReleaseDialog

public class AppDetail
    implements gu, Serializable
{

    public static final int HARD_UPDATE = 100;
    private static final long serialVersionUID = 1L;
    private String cancelButtonTitle;
    private ReleaseDialog dialog;
    private String feedbackButtonTitle;
    private String storeButtonTitle;
    private String storeLink;
    private int type;
    private String updateButtonTitle;
    private String version;

    public AppDetail()
    {
    }

    public String getCancelButtonTitle()
    {
        return cancelButtonTitle;
    }

    public ReleaseDialog getDialog()
    {
        return dialog;
    }

    public String getFeedbackButtonTitle()
    {
        return feedbackButtonTitle;
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

    public String getVersion()
    {
        return version;
    }

    public void setCancelButtonTitle(String s)
    {
        cancelButtonTitle = s;
    }

    public void setDialog(ReleaseDialog releasedialog)
    {
        dialog = releasedialog;
    }

    public void setFeedbackButtonTitle(String s)
    {
        feedbackButtonTitle = s;
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

    public void setVersion(String s)
    {
        version = s;
    }
}
