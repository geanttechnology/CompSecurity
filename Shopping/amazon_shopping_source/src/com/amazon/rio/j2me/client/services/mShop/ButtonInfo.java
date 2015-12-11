// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            UniversalLink, HyperText

public class ButtonInfo
{

    private UniversalLink buttonAction;
    private HyperText buttonText;

    public ButtonInfo()
    {
    }

    public void setButtonAction(UniversalLink universallink)
    {
        buttonAction = universallink;
    }

    public void setButtonText(HyperText hypertext)
    {
        buttonText = hypertext;
    }
}
