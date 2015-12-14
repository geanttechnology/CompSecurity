// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.account;

import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.account:
//            AccountDetails

public static class expiration
{

    public boolean active;
    public boolean available;
    public String benefitID;
    public long expiration;

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof expiration))
        {
            if (available == ((available) (obj = (available)obj)).available && active == ((active) (obj)).active && benefitID.equals(((benefitID) (obj)).benefitID) && expiration == ((expiration) (obj)).expiration)
            {
                return true;
            }
        }
        return false;
    }

    (JSONObject jsonobject)
    {
        active = jsonobject.optBoolean("active");
        available = jsonobject.optBoolean("available");
        benefitID = jsonobject.optString("benefitId");
        expiration = jsonobject.optLong("expiration");
    }
}
