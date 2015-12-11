// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.t;
import java.util.List;

public class ai extends t
{

    public Integer mNext;
    public List notificationListItems;

    public String toString()
    {
        return (new StringBuilder()).append("LookupNotificationsResponse [mResponse=").append(a).append(", mNext=").append(mNext).append(", notificationItems=").append(notificationListItems).append("]").toString();
    }
}
