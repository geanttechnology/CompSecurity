// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            FollowPerson

public class Follow
{

    String created;
    FollowPerson follows;
    long id;
    int notification_preference;

    public Follow()
    {
    }

    public String getCreated()
    {
        return created;
    }

    public FollowPerson getFollows()
    {
        return follows;
    }

    public long getId()
    {
        return id;
    }

    public int getNotification_preference()
    {
        return notification_preference;
    }

    public void setCreated(String s)
    {
        created = s;
    }

    public void setFollows(FollowPerson followperson)
    {
        follows = followperson;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setNotification_preference(int i)
    {
        notification_preference = i;
    }

    public String toString()
    {
        return (new StringBuilder("Follow [follows=")).append(follows).append(", id=").append(id).append(", notification_preference=").append(notification_preference).append(", created=").append(created).append("]").toString();
    }
}
