// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Affiliates, User

public class GeoLocation
    implements Serializable
{

    private Affiliates affiliates;
    private User user;

    public GeoLocation()
    {
    }

    public Affiliates getAffiliates()
    {
        return affiliates;
    }

    public User getUser()
    {
        return user;
    }
}
