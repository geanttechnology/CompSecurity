// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class NotificationData
{

    String actionPath;
    String notice;
    String notificationText;
    long objectId;

    public NotificationData()
    {
    }

    public String getActionPath()
    {
        return actionPath;
    }

    public String getNotice()
    {
        return notice;
    }

    public String getNotificationText()
    {
        return notificationText;
    }

    public long getObjectId()
    {
        return objectId;
    }

    public String toString()
    {
        return (new StringBuilder("NotificationData [notice=")).append(notice).append(", notificationtext=").append(notificationText).append(", objectId=").append(objectId).append("]").toString();
    }
}
