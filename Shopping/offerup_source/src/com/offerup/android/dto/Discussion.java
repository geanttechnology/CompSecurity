// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            Person, BuyRequest, Item, Message

public class Discussion
{

    Person buyer;
    BuyRequest currentBuyRequest;
    String dateCreated;
    String dateCreatedAgo;
    long id;
    Item item;
    Message lastMessage;
    String lastPostDate;
    String lastPostDateAgo;
    int messageCount;
    Person seller;

    public Discussion()
    {
    }

    public Person getBuyer()
    {
        return buyer;
    }

    public BuyRequest getCurrentBuyRequest()
    {
        return currentBuyRequest;
    }

    public String getDateCreated()
    {
        return dateCreated;
    }

    public String getDateCreatedAgo()
    {
        return dateCreatedAgo;
    }

    public long getId()
    {
        return id;
    }

    public Item getItem()
    {
        return item;
    }

    public Message getLastMessage()
    {
        return lastMessage;
    }

    public String getLastPostDate()
    {
        return lastPostDate;
    }

    public String getLastPostDateAgo()
    {
        return lastPostDateAgo;
    }

    public int getMessageCount()
    {
        return messageCount;
    }

    public Person getSeller()
    {
        return seller;
    }

    public void setBuyer(Person person)
    {
        buyer = person;
    }

    public void setCurrentBuyRequest(BuyRequest buyrequest)
    {
        currentBuyRequest = buyrequest;
    }

    public void setDateCreated(String s)
    {
        dateCreated = s;
    }

    public void setDateCreatedAgo(String s)
    {
        dateCreatedAgo = s;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setItem(Item item1)
    {
        item = item1;
    }

    public void setLastMessage(Message message)
    {
        lastMessage = message;
    }

    public void setLastPostDate(String s)
    {
        lastPostDate = s;
    }

    public void setLastPostDateAgo(String s)
    {
        lastPostDateAgo = s;
    }

    public void setSeller(Person person)
    {
        seller = person;
    }

    public String toString()
    {
        return (new StringBuilder("Discussion [lastMessage=")).append(lastMessage).append(", seller=").append(seller).append(", message_count=").append(messageCount).append(", item=").append(item).append(", buyer=").append(buyer).append(", lastPostDate=").append(lastPostDate).append(", dateCreatedAgo=").append(dateCreatedAgo).append(", currentBuyRequest=").append(currentBuyRequest).append(", lastPostDateAgo=").append(lastPostDateAgo).append(", dateCreated=").append(dateCreated).append(", id=").append(id).append("]").toString();
    }
}
