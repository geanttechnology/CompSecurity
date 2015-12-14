// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.widgetpool.tokenautocomplete.PeopleCompleteView;

// Referenced classes of package com.cyberlink.you.c:
//            e, h, f

class a
    implements android.widget.terView.OnItemClickListener
{

    final e a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (h)view.getTag();
        view = e.a(a).a(i);
        Long long1 = Long.valueOf(((Friend) (view)).a);
        boolean flag;
        if (!e.a(a).a(long1.longValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e.a(a).a(long1.longValue(), flag);
        ((h) (adapterview)).c.setChecked(flag);
        if (!flag)
        {
            e.g(a).d(view);
        } else
        {
            e.g(a).c(view);
        }
        a.a();
    }

    ew(e e1)
    {
        a = e1;
        super();
    }
}
