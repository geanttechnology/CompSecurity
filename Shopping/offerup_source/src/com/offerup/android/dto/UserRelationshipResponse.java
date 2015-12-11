// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


// Referenced classes of package com.offerup.android.dto:
//            Following, Blocked

public class UserRelationshipResponse
{

    private Blocked blocked;
    private Following following;

    public UserRelationshipResponse()
    {
    }

    private Following getFollowing()
    {
        return following;
    }

    public Blocked getBlocked()
    {
        return blocked;
    }

    public boolean isFollowing()
    {
        return following != null && following.isFollowing();
    }
}
