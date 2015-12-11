// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.api;

import java.util.ArrayList;

public class VineNotification
{

    public String comment;
    public long createdAt;
    public ArrayList entities;
    public long notificationId;

    public VineNotification()
    {
        createdAt = 0L;
        comment = null;
        notificationId = 0L;
    }
}
