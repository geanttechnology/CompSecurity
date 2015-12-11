// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import com.ebay.nautilus.domain.app.Authentication;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationUtil

public static class type
{

    public final Authentication auth;
    public final String clientId;
    public final String metaCategories;
    public final ationType type;

    public type asSubscriptionArgs(Context context)
    {
        return NotificationUtil.checkAndGetArgs(context, auth, clientId, metaCategories, type);
    }

    public ationType(String s, Authentication authentication, String s1, ationType ationtype)
    {
        clientId = s;
        auth = authentication;
        metaCategories = s1;
        type = ationtype;
    }
}
