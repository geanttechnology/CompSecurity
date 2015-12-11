// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper;

import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.mothership.util.f;

// Referenced classes of package com.target.ui.helper:
//            c, b

public class a
{

    public a()
    {
    }

    protected boolean a(int i, c c1, j j, Guest guest, o o)
    {
        if (a(j))
        {
            c1.a(i, guest, o);
            return true;
        }
        if (b(j))
        {
            c1.a(i);
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean a(j j)
    {
        return f.a(j);
    }

    protected boolean a(b b1, j j, Guest guest, o o)
    {
        if (a(j))
        {
            b1.a(guest, o);
            return true;
        }
        if (b(j))
        {
            b1.q_();
            return true;
        } else
        {
            return false;
        }
    }

    protected boolean b(j j)
    {
        return f.b(j);
    }
}
