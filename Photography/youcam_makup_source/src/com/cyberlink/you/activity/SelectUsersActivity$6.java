// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.util.LongSparseArray;
import android.util.Log;
import android.view.View;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.utility.d;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity, q

class a
    implements android.view.ersActivity._cls6
{

    final SelectUsersActivity a;

    public void onClick(View view)
    {
        d.a(SelectUsersActivity.m(a), false);
        view = SelectUsersActivity.o(a).iterator();
        do
        {
            if (!view.hasNext())
            {
                break;
            }
            Friend friend = (Friend)view.next();
            if ((SelectUsersActivity.a(a) == null || !SelectUsersActivity.a(a).contains(friend)) && !SelectUsersActivity.h(a).contains(friend))
            {
                com.cyberlink.you.activity.SelectUsersActivity.d(a).put(friend.a, Boolean.valueOf(true));
                SelectUsersActivity.i(a);
                SelectUsersActivity.j(a);
                SelectUsersActivity.h(a).add(friend);
            }
        } while (true);
        Log.d("SelectUsersActivity", (new StringBuilder()).append("------------- mTotalSelectedCount = ").append(SelectUsersActivity.p(a)).toString());
        SelectUsersActivity.c(a).notifyDataSetChanged();
        SelectUsersActivity.k(a);
        SelectUsersActivity.l(a);
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
