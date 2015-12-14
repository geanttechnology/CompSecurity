// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.model.NotificationSetting;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            EditNotificationActivity

class a extends m
{

    final EditNotificationActivity a;

    protected void a(NotificationSetting notificationsetting)
    {
        if (notificationsetting != null && notificationsetting.nonNotifyType != null && notificationsetting.nonNotifyType.size() > 0)
        {
            notificationsetting = notificationsetting.nonNotifyType.iterator();
            do
            {
                if (!notificationsetting.hasNext())
                {
                    break;
                }
                String s = (String)notificationsetting.next();
                if (s != null)
                {
                    if ("CommentPost".equals(s))
                    {
                        a.e.setSelected(false);
                    } else
                    if ("FollowUser".equals(s))
                    {
                        a.f.setSelected(false);
                    } else
                    if ("FollowCircle".equals(s))
                    {
                        a.g.setSelected(false);
                    } else
                    if ("JoinBCFromFB".equals(s) || "JoinBCFromWeibo".equals(s))
                    {
                        a.h.setSelected(false);
                    } else
                    if ("AddPost".equals(s))
                    {
                        a.i.setSelected(false);
                    } else
                    if ("CreateCircle".equals(s))
                    {
                        a.j.setSelected(false);
                    } else
                    if ("LikePost".equals(s))
                    {
                        a.k.setSelected(false);
                    } else
                    if ("CircleInPost".equals(s))
                    {
                        a.l.setSelected(false);
                    }
                }
            } while (true);
        }
        a.l();
    }

    protected void b(Object obj)
    {
        a((NotificationSetting)obj);
    }

    (EditNotificationActivity editnotificationactivity)
    {
        a = editnotificationactivity;
        super();
    }
}
