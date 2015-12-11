// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            NonSecure, Secure

public class WebService
    implements Serializable
{

    private String name;
    private NonSecure nonsecure;
    private Secure secure;

    public WebService()
    {
    }

    public String getName()
    {
        return name;
    }

    public NonSecure getNonsecure()
    {
        return nonsecure;
    }

    public Secure getSecure()
    {
        return secure;
    }
}
