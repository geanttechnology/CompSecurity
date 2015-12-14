// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.util.LongSparseArray;
import android.view.View;
import com.cyberlink.you.utility.d;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity, q

class a
    implements android.view.ersActivity._cls5
{

    final SelectUsersActivity a;

    public void onClick(View view)
    {
        d.a(SelectUsersActivity.m(a), false);
        com.cyberlink.you.activity.SelectUsersActivity.d(a).clear();
        SelectUsersActivity.h(a).clear();
        SelectUsersActivity.a(a, 0);
        SelectUsersActivity.b(a, 0);
        SelectUsersActivity.n(a);
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
