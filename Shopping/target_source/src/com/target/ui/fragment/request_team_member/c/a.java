// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member.c;

import com.target.ui.service.RequestTeamMemberAlarmManager;
import com.target.ui.service.l;

// Referenced classes of package com.target.ui.fragment.request_team_member.c:
//            b

public class a
    implements b
{

    private RequestTeamMemberAlarmManager mAlarmManager;

    public a(RequestTeamMemberAlarmManager requestteammemberalarmmanager)
    {
        mAlarmManager = requestteammemberalarmmanager;
    }

    public com.target.ui.service.l.a a()
    {
        return l.a(mAlarmManager).a();
    }

    public void a(com.target.ui.service.l.a a1)
    {
        l.a(mAlarmManager).a(a1);
    }
}
