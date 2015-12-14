// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.support.v4.util.LongSparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.cyberlink.you.database.o;
import com.cyberlink.you.e;
import com.cyberlink.you.friends.Friend;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectUsersActivity, s, q

class a
    implements android.widget.kListener
{

    final SelectUsersActivity a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        boolean flag1 = true;
        view = (s)view.getTag();
        if (!((s) (view)).c.isEnabled())
        {
            return;
        }
        adapterview = Long.valueOf(SelectUsersActivity.c(a).a(i).a);
        boolean flag2 = SelectUsersActivity.a(a, adapterview.longValue());
        LongSparseArray longsparsearray = SelectUsersActivity.d(a);
        l = adapterview.longValue();
        boolean flag;
        if (!flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        longsparsearray.put(l, Boolean.valueOf(flag));
        view = ((s) (view)).c;
        if (!flag2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.setChecked(flag);
        adapterview = e.g().a(String.valueOf(adapterview));
        if (!flag2) goto _L2; else goto _L1
_L1:
        if (com.cyberlink.you.activity.SelectUsersActivity.e(a) > 0)
        {
            SelectUsersActivity.f(a);
        }
        SelectUsersActivity.g(a);
        SelectUsersActivity.h(a).remove(adapterview);
_L4:
        SelectUsersActivity.k(a);
        SelectUsersActivity.l(a);
        return;
_L2:
        if (SelectUsersActivity.a(a) == null || !SelectUsersActivity.a(a).contains(adapterview))
        {
            SelectUsersActivity.i(a);
            SelectUsersActivity.j(a);
            SelectUsersActivity.h(a).add(adapterview);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (SelectUsersActivity selectusersactivity)
    {
        a = selectusersactivity;
        super();
    }
}
