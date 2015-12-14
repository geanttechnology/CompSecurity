// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.c;

import android.widget.Filter;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.widgetpool.tokenautocomplete.e;
import java.util.Timer;

// Referenced classes of package com.cyberlink.you.c:
//            e, k, f

class a
    implements e
{

    final com.cyberlink.you.c.e a;

    public void a(Friend friend)
    {
    }

    public void a(Object obj)
    {
        b((Friend)obj);
    }

    public void a(String s)
    {
        if (s.length() > 2)
        {
            e.b(a).schedule(new k(a, s), 800L);
        } else
        if (e.a(a) != null)
        {
            e.a(a).getFilter().filter(s.toString());
            return;
        }
    }

    public void b(Friend friend)
    {
        e.a(a).a(friend.a, false);
        e.a(a).notifyDataSetChanged();
        a.a();
    }

    public void b(Object obj)
    {
        a((Friend)obj);
    }

    s.Friend(com.cyberlink.you.c.e e1)
    {
        a = e1;
        super();
    }
}
