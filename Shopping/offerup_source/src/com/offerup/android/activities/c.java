// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.offerup.android.dto.NoticeType;
import com.offerup.android.dto.Notification;
import com.offerup.android.dto.NotificationData;
import com.offerup.android.utils.a;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            AlertsActivity, a, RatingActivity, ChatActivity

final class c
    implements android.widget.AdapterView.OnItemClickListener
{

    private List a;
    private AlertsActivity b;

    c(AlertsActivity alertsactivity, List list)
    {
        b = alertsactivity;
        a = list;
        super();
    }

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Notification)a.get(i);
        if (adapterview != null && adapterview.getData() != null)
        {
            view = adapterview.getData().getActionPath();
            if (StringUtils.isNotEmpty(view))
            {
                (new a(b.f, false)).a(view);
            } else
            if (adapterview.getData().getObjectId() > 0L)
            {
                if (adapterview.getNoticeType().getId() == 7)
                {
                    view = b.f;
                    l = adapterview.getData().getObjectId();
                    adapterview = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/RatingActivity);
                    adapterview.putExtra("itemId", l);
                    ((com.offerup.android.activities.a) (view)).a.startActivityForResult(adapterview, 12);
                    return;
                } else
                {
                    view = b.f;
                    i = adapterview.getNoticeType().getId();
                    l = adapterview.getData().getObjectId();
                    adapterview = new Intent(((com.offerup.android.activities.a) (view)).a, com/offerup/android/activities/ChatActivity);
                    adapterview.putExtra("noticeType", i);
                    adapterview.putExtra("discussionId", l);
                    ((com.offerup.android.activities.a) (view)).a.startActivity(adapterview);
                    return;
                }
            }
        }
    }
}
