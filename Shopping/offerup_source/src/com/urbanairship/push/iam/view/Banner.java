// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam.view;

import com.urbanairship.push.notifications.NotificationActionButtonGroup;

public interface Banner
{

    public abstract void setNotificationActionButtonGroup(NotificationActionButtonGroup notificationactionbuttongroup);

    public abstract void setOnActionClickListener(OnActionClickListener onactionclicklistener);

    public abstract void setOnDismissClickListener(OnDismissClickListener ondismissclicklistener);

    public abstract void setPrimaryColor(int i);

    public abstract void setSecondaryColor(int i);

    public abstract void setText(CharSequence charsequence);
}
