// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import java.util.List;

public class NotificationResponseData
{

    private List notifications;

    public NotificationResponseData()
    {
    }

    public List getNotifications()
    {
        return notifications;
    }

    public boolean isNotEmpty()
    {
        return notifications != null && notifications.size() > 0;
    }
}
