// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.text.TextUtils;
import java.security.InvalidParameterException;

// Referenced classes of package com.millennialmedia.internal:
//            PlayList

public static class spaceId extends spaceId
{

    final String networkId;
    final String siteId;
    final String spaceId;

    public (String s, String s1, String s2, String s3)
    {
        super(s);
        if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(s3))
        {
            throw new InvalidParameterException("networkId, siteId and spaceId are required");
        } else
        {
            networkId = s1;
            siteId = s2;
            spaceId = s3;
            return;
        }
    }
}
