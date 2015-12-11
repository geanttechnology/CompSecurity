// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.PendingIntent;
import android.content.Context;

public interface NotificationAction
{

    public abstract int getCaptionResourceId();

    public abstract int getIconResourceId();

    public abstract PendingIntent getPendingIntent(Context context, int i, int j);
}
