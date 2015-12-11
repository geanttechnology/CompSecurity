// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.appevents;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.io.Serializable;

// Referenced classes of package com.facebook.appevents:
//            AppEventsLogger

private static class applicationId
    implements Serializable
{

    private final String accessTokenString;
    private final String applicationId;

    public boolean equals(Object obj)
    {
        if (obj instanceof applicationId)
        {
            if (Utility.areObjectsEqual(((applicationId) (obj = (applicationId)obj)).accessTokenString, accessTokenString) && Utility.areObjectsEqual(((accessTokenString) (obj)).applicationId, applicationId))
            {
                return true;
            }
        }
        return false;
    }

    String getAccessTokenString()
    {
        return accessTokenString;
    }

    String getApplicationId()
    {
        return applicationId;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (accessTokenString == null)
        {
            i = 0;
        } else
        {
            i = accessTokenString.hashCode();
        }
        if (applicationId != null)
        {
            j = applicationId.hashCode();
        }
        return i ^ j;
    }

    A(AccessToken accesstoken)
    {
        this(accesstoken.getToken(), FacebookSdk.getApplicationId());
    }

    <init>(String s, String s1)
    {
        String s2 = s;
        if (Utility.isNullOrEmpty(s))
        {
            s2 = null;
        }
        accessTokenString = s2;
        applicationId = s1;
    }
}
