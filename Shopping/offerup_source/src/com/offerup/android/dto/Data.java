// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.offerup.android.dto:
//            Blocked, Message, Item, Profile

public class Data
{

    private Blocked blocked;
    private List categories;
    private List discussions;
    private List filters;
    private List follows;
    private List itemLists;
    private List items;
    private Message message;
    private List messages;
    private List notifications;
    private Item postedItem;
    private Profile profile;
    private List sorts;
    private int total;

    public Data()
    {
    }

    public Blocked getBlocked()
    {
        return blocked;
    }

    public ArrayList getCategories()
    {
        return new ArrayList(categories);
    }

    public List getDiscussions()
    {
        return discussions;
    }

    public ArrayList getFilters()
    {
        return new ArrayList(filters);
    }

    public List getFollows()
    {
        return follows;
    }

    public ArrayList getItemLists()
    {
        return new ArrayList(itemLists);
    }

    public ArrayList getItems()
    {
        if (items != null)
        {
            return new ArrayList(items);
        } else
        {
            return null;
        }
    }

    public Message getMessage()
    {
        return message;
    }

    public List getMessages()
    {
        return messages;
    }

    public List getNotifications()
    {
        return notifications;
    }

    public Item getPostedItem()
    {
        return postedItem;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public ArrayList getSorts()
    {
        return new ArrayList(sorts);
    }

    public int getTotal()
    {
        return total;
    }

    public void setDiscussions(List list)
    {
        discussions = list;
    }

    public void setItem(Item item)
    {
        postedItem = item;
    }

    public void setItems(ArrayList arraylist)
    {
        items = arraylist;
    }

    public void setMessage(Message message1)
    {
        message = message1;
    }

    public void setMessages(List list)
    {
        messages = list;
    }

    public void setNotifications(List list)
    {
        notifications = list;
    }

    public void setProfile(Profile profile1)
    {
        profile = profile1;
    }

    public String toString()
    {
        return (new StringBuilder("Data [profile=")).append(profile).append(", notifications=").append(notifications).append(", items=").append(items).append(", itemLists=").append(itemLists).append(", categories=").append(categories).append(", follows=").append(follows).append(", total=").append(total).append(", postedItem=").append(postedItem).append(", message=").append(message).append(", messages=").append(messages).append(", discussions=").append(discussions).append("]").toString();
    }
}
