// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            UniversalLink

public class RichMessage
{

    private Integer backgroundColor;
    private Integer borderColor;
    private UniversalLink imageLink;
    private String imageUrl;
    private List messages;

    public RichMessage()
    {
    }

    public Integer getBackgroundColor()
    {
        return backgroundColor;
    }

    public UniversalLink getImageLink()
    {
        return imageLink;
    }

    public List getMessages()
    {
        return messages;
    }

    public void setBackgroundColor(Integer integer)
    {
        backgroundColor = integer;
    }

    public void setBorderColor(Integer integer)
    {
        borderColor = integer;
    }

    public void setImageLink(UniversalLink universallink)
    {
        imageLink = universallink;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setMessages(List list)
    {
        messages = list;
    }
}
