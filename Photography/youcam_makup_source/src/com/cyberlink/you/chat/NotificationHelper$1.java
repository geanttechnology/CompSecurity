// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.cyberlink.you.activity.ChatDialogActivity;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.friends.p;
import com.cyberlink.you.g;
import com.cyberlink.you.r;
import com.cyberlink.you.utility.ULogUtility;
import com.cyberlink.you.utility.h;

// Referenced classes of package com.cyberlink.you.chat:
//            NotificationHelper, b

final class f
    implements p
{

    final String a;
    final Context b;
    final Group c;
    final String d;
    final boolean e;
    final b f;

    public void a(String s, String s1, String s2, String s3)
    {
        if (s2 == null)
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server. statuscode = null").toString());
            ULogUtility.d(a, "stop query userInfo from server. statuscode = null");
            return;
        }
        if (!s2.equals("200"))
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server. statuscode = ").append(s2).toString());
            ULogUtility.d(a, (new StringBuilder()).append("stop query userInfo from server. statuscode = ").append(s2).toString());
            return;
        }
        Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] stop query userInfo from server.").toString());
        ULogUtility.d(a, "stop query userInfo from server.");
        s2 = new Intent(b, com/cyberlink/you/activity/ChatDialogActivity);
        s = new Bundle();
        s.putParcelable("Group", c);
        s.putString("debugPrefix", d);
        s2.putExtras(s);
        Friend friend = h.a(h.c(s3));
        if (friend != null)
        {
            s = "U";
            s1 = b.getResources().getString(r.u_notification_default_string);
            if (e)
            {
                s = c.f;
                s1 = NotificationHelper.a(b, f, c, friend);
            }
            if (g.a().b() && (d.equals("(HB)") || d.equals("(GCM)")))
            {
                s1 = (new StringBuilder()).append(d).append(s1).toString();
                s = (new StringBuilder()).append(d).append(s).toString();
            }
            NotificationHelper.a(c, s, s1, s1, s2, friend.b, d);
            return;
        } else
        {
            Log.d("NotificationHelper", (new StringBuilder()).append("[").append(a).append("] get userInfo from server fail. jsonstr = ").append(s3).toString());
            ULogUtility.d(a, (new StringBuilder()).append("get userInfo from server fail. jsonstr = ").append(s3).toString());
            return;
        }
    }

    y(String s, Context context, Group group, String s1, boolean flag, b b1)
    {
        a = s;
        b = context;
        c = group;
        d = s1;
        e = flag;
        f = b1;
        super();
    }
}
