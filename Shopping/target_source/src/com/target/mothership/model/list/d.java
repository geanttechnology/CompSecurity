// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.c;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.list.interfaces.a.a;
import com.target.mothership.util.i;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list:
//            a

class d extends c
    implements com.target.mothership.model.list.a
{

    private GuestBase mGuest;

    public d(GuestBase guestbase)
    {
        mGuest = guestbase;
    }

    public void a(com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a(3, false));
            return;
        }
    }

    public void a(ListSummary listsummary, int j, com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            listsummary = new ArrayList();
            listsummary.add(i.b("", 0, false));
            d1.a(listsummary);
            return;
        }
    }

    public void a(String s, String s1, String s2, String s3, com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a(s, s1, s2, s3, 0, false));
            return;
        }
    }

    public void b(com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.b(3, false));
            return;
        }
    }

    public void c(com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new a(com.target.mothership.model.list.interfaces.a.a.a.UNKNOWN));
            return;
        } else
        {
            d1.a(i.a("Default List", 3, true));
            return;
        }
    }
}
