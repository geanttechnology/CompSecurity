// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.request.preferences;


public class NotificationWritePreference
{

    public static final NotificationWritePreference ACTIVE = new NotificationWritePreference(true);
    public static final NotificationWritePreference INACTIVE = new NotificationWritePreference(false);
    public final boolean active;

    private NotificationWritePreference(boolean flag)
    {
        active = flag;
    }

}
