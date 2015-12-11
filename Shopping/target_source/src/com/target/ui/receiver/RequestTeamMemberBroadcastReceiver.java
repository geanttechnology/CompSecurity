// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.h;
import com.target.ui.service.RequestTeamMemberAlarmManager;
import com.target.ui.service.l;

public class RequestTeamMemberBroadcastReceiver extends BroadcastReceiver
{

    public static final String REQUEST_TEAM_MEMBER_MINIMUM_TIME_EVENT = "request_team_member_minimum_time_event";

    public RequestTeamMemberBroadcastReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        l.a(new RequestTeamMemberAlarmManager(context)).a(new com.target.ui.service.l.a(false, null));
        h.a(context).a(new Intent("request_team_member_minimum_time_event"));
    }
}
