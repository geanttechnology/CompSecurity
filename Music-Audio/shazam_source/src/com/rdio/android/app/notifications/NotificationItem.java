// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.app.notifications;

import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.generated.BaseSimpleComment;
import com.rdio.android.api.models.generated.BaseUser;

public class NotificationItem
{

    public BaseSimpleComment comment;
    public String message;
    public BaseUser notifier;
    public ApiModel source;
    public String timestamp;
    public BaseUser user;

    public NotificationItem()
    {
    }
}
