// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            RichMessage, HyperText

public class InterstitialCartItemsInfo
{

    private RichMessage alertMessage;
    private HyperText invalidThresholdItemMessage;
    private HyperText savedForLaterHeader;
    private RichMessage savedForLaterMessage;
    private String thresholdDeficit;
    private String validCartSubtotal;

    public InterstitialCartItemsInfo()
    {
    }

    public void setAlertMessage(RichMessage richmessage)
    {
        alertMessage = richmessage;
    }

    public void setInvalidThresholdItemMessage(HyperText hypertext)
    {
        invalidThresholdItemMessage = hypertext;
    }

    public void setSavedForLaterHeader(HyperText hypertext)
    {
        savedForLaterHeader = hypertext;
    }

    public void setSavedForLaterMessage(RichMessage richmessage)
    {
        savedForLaterMessage = richmessage;
    }

    public void setThresholdDeficit(String s)
    {
        thresholdDeficit = s;
    }

    public void setValidCartSubtotal(String s)
    {
        validCartSubtotal = s;
    }
}
