// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.user;


// Referenced classes of package com.shazam.server.response.user:
//            UserProfile, Promode, ThirdPartyServices

public class User
{

    public static final User EMPTY = new User(null, null, null);
    public final UserProfile profile;
    public final Promode promode;
    public final ThirdPartyServices thirdPartyServices;

    private User(UserProfile userprofile, ThirdPartyServices thirdpartyservices, Promode promode1)
    {
        profile = userprofile;
        thirdPartyServices = thirdpartyservices;
        promode = promode1;
    }

}
