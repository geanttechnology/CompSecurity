// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.database;

import android.net.Uri;
import android.provider.BaseColumns;

public final class b
    implements BaseColumns
{

    public static final Uri a = Uri.parse("content://com.picsart.studio.provider/notifications");

    static 
    {
        Uri.parse("content://com.picsart.studio.provider/notifications/#");
        Uri.parse("content://com.picsart.studio.provider/notifications/notification_id");
    }
}
