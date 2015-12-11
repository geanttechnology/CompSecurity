// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.request_team_member;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.target.ui.fragment.request_team_member.b.a;

// Referenced classes of package com.target.ui.fragment.request_team_member:
//            RequestTeamMemberDialogFragment

class this._cls0 extends BroadcastReceiver
{

    final RequestTeamMemberDialogFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        if (com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this) == null)
        {
            return;
        } else
        {
            com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a(RequestTeamMemberDialogFragment.this).j();
            return;
        }
    }

    ()
    {
        this$0 = RequestTeamMemberDialogFragment.this;
        super();
    }
}
