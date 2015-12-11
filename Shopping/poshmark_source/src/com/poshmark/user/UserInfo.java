// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.user;


// Referenced classes of package com.poshmark.user:
//            UserInfoDetails

public class UserInfo
{

    String access_token;
    int created_at;
    String expires_at;
    int generation;
    public UserInfoDetails user;
    String user_status;

    public UserInfo()
    {
    }

    public String getAccessToken()
    {
        return access_token;
    }

    public UserInfoDetails getInfoDetails()
    {
        return user;
    }

    public String getUserCreatedApiVersion()
    {
        return null;
    }

    public String getUserCreatedAppVersion()
    {
        return null;
    }
}
