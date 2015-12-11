// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;


// Referenced classes of package com.shazam.model.rdio:
//            RdioCredentials

public static class 
{

    public String accessToken;
    public Long expirationTime;
    public String refreshToken;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.accessToken;
    }

    static String b(accessToken accesstoken)
    {
        return accesstoken.refreshToken;
    }

    static Long c(refreshToken refreshtoken)
    {
        return refreshtoken.expirationTime;
    }

    public final RdioCredentials b()
    {
        return new RdioCredentials(this, null);
    }

    public ()
    {
    }
}
