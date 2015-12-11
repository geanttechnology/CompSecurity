// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.target.mothership.cache.guest.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest:
//            a

class val.callback extends h
{

    final com.target.mothership.model.guest.a this$0;
    final h val$callback;
    final Guest val$guest;

    public void a(x x1)
    {
        com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this).clearGuest(val$guest, val$callback);
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        com.target.mothership.model.guest.a.a(com.target.mothership.model.guest.a.this).clearGuest(val$guest, val$callback);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    rfaces.Guest()
    {
        this$0 = final_a1;
        val$guest = guest1;
        val$callback = h.this;
        super();
    }
}
