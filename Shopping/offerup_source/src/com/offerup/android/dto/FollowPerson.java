// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            FollowProfile

public class FollowPerson
{

    private String firstName;
    private int id;
    private FollowProfile profile;

    public FollowPerson()
    {
    }

    public String getFirstName()
    {
        return firstName;
    }

    public int getId()
    {
        return id;
    }

    public FollowProfile getProfile()
    {
        return profile;
    }

    public void setFirstName(String s)
    {
        firstName = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setProfile(FollowProfile followprofile)
    {
        profile = followprofile;
    }

    public String toString()
    {
        return (new StringBuilder("FollowPerson [firstName=")).append(firstName).append(", id=").append(id).append(", profile=").append(profile).append("]").toString();
    }
}
