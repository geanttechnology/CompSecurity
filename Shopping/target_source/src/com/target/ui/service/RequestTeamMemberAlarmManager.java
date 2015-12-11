// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class RequestTeamMemberAlarmManager
{

    public static final String REQUEST_TEAM_MEMBER_ALARM_INTENT = "com.target.ui.request_team_member.REQUEST_TEAM_MEMBER_ALARM_INTENT";
    private static final long REQUEST_TEAM_MEMBER_MINIMUM_TIME = 60000L;
    private Context mContext;

    public RequestTeamMemberAlarmManager(Context context)
    {
        mContext = context;
    }

    public void a()
    {
        long l = System.currentTimeMillis();
        Object obj = new Intent("com.target.ui.request_team_member.REQUEST_TEAM_MEMBER_ALARM_INTENT");
        obj = PendingIntent.getBroadcast(mContext, 2, ((Intent) (obj)), 0x10000000);
        ((AlarmManager)mContext.getSystemService("alarm")).set(1, 60000L + l, ((PendingIntent) (obj)));
    }
}
