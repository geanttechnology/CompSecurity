// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import b.a.a;

// Referenced classes of package com.offerup.android.dto:
//            NotificationData, NoticeType, Person

public class Notification
{

    a added;
    int archived;
    NotificationData data;
    long id;
    NoticeType noticeType;
    Person recipient;
    Person sender;
    int unseen;

    public Notification()
    {
    }

    public a getAdded()
    {
        return added;
    }

    public int getArchived()
    {
        return archived;
    }

    public NotificationData getData()
    {
        return data;
    }

    public long getId()
    {
        return id;
    }

    public NoticeType getNoticeType()
    {
        return noticeType;
    }

    public Person getRecipient()
    {
        return recipient;
    }

    public Person getSender()
    {
        return sender;
    }

    public int getUnseen()
    {
        return unseen;
    }

    public void setAdded(a a)
    {
        added = a;
    }

    public void setArchived(int i)
    {
        archived = i;
    }

    public void setData(NotificationData notificationdata)
    {
        data = notificationdata;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setNoticeType(NoticeType noticetype)
    {
        noticeType = noticetype;
    }

    public void setRecipient(Person person)
    {
        recipient = person;
    }

    public void setSender(Person person)
    {
        sender = person;
    }

    public void setUnseen(int i)
    {
        unseen = i;
    }

    public String toString()
    {
        return (new StringBuilder("Notification [archived=")).append(archived).append(", added=").append(added).append(", sender=").append(sender).append(", data=").append(data).append(", noticeType=").append(noticeType).append(", unseen=").append(unseen).append(", recipient=").append(recipient).append(", id=").append(id).append("]").toString();
    }
}
