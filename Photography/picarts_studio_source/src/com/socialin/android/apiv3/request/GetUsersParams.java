// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.request;


// Referenced classes of package com.socialin.android.apiv3.request:
//            ParamWithPageLimit

public class GetUsersParams extends ParamWithPageLimit
{

    public String fbIds;
    public String instagramIds;
    public String isFollowing;
    public String near;
    public String query;
    public String twitterIds;
    public String username;

    public GetUsersParams()
    {
    }

    public GetUsersParams clearParams()
    {
        query = "";
        fbIds = "";
        twitterIds = "";
        instagramIds = "";
        username = "";
        near = "";
        isFollowing = "0";
        return this;
    }
}
