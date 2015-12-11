// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.KindleUnlimited;
import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.StyledText;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class KindleUnlimitedEntity extends RetailSearchEntity
    implements KindleUnlimited
{

    private StyledText badge;
    private boolean isSubscribed;
    private Link link;
    private List messages;
    private String price;

    public KindleUnlimitedEntity()
    {
    }

    public StyledText getBadge()
    {
        return badge;
    }

    public boolean getIsSubscribed()
    {
        return isSubscribed;
    }

    public Link getLink()
    {
        return link;
    }

    public List getMessages()
    {
        return messages;
    }

    public String getPrice()
    {
        return price;
    }

    public void setBadge(StyledText styledtext)
    {
        badge = styledtext;
    }

    public void setIsSubscribed(boolean flag)
    {
        isSubscribed = flag;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setMessages(List list)
    {
        messages = list;
    }

    public void setPrice(String s)
    {
        price = s;
    }
}
