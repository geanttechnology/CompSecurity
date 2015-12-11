// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;


// Referenced classes of package com.xfinity.playerlib.authorization:
//            VideoAuthorization

public class GoldenTicket
{

    private final VideoAuthorization authorization;

    public String getToken()
    {
        return authorization.getDevicePlaybackToken();
    }
}
