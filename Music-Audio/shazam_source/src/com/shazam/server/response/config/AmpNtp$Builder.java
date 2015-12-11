// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.List;

// Referenced classes of package com.shazam.server.response.config:
//            AmpNtp

public static class 
{

    private List servers;

    public static  ampNtp()
    {
        return new <init>();
    }

    public AmpNtp build()
    {
        return new AmpNtp(this, null);
    }

    public <init> withServers(List list)
    {
        servers = list;
        return this;
    }


    public ()
    {
    }
}
