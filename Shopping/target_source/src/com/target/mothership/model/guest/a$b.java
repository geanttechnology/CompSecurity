// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest:
//            a

private final class mReceiver extends h
{

    private h mReceiver;
    final a this$0;

    static h a(mReceiver mreceiver)
    {
        return mreceiver.mReceiver;
    }

    public String a()
    {
        return mReceiver.a();
    }

    public void a(Guest guest)
    {
        com.target.mothership.model.guest.a.a(a.this, guest, new h() {

            final a.b this$1;

            public void a(Guest guest1)
            {
                a.b.a(a.b.this).a(guest1);
            }

            public void a(x x1)
            {
                a.b.a(a.b.this).a(x1);
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$1 = a.b.this;
                super();
            }
        });
    }

    public void a(x x1)
    {
        mReceiver.a(x1);
    }

    public volatile void a(Object obj)
    {
        a((Guest)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    public _cls1.this._cls1(h h1)
    {
        this$0 = a.this;
        super();
        mReceiver = h1;
    }
}
