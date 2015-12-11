// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.target.mothership.cache.guest.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.c;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.guest:
//            a

class this._cls2 extends h
{

    final a this$2;

    public void a(x x1)
    {
        com.target.mothership.model.guest.a.a(_fld0, ._mth0(_fld1), com.target.mothership.model.guest.is._mth1(_fld1), com.target.mothership.model.guest.is._mth1(_fld1));
    }

    public volatile void a(Object obj)
    {
        a((Void)obj);
    }

    public void a(Void void1)
    {
        com.target.mothership.model.guest.a.a(_fld0, ._mth0(_fld1), com.target.mothership.model.guest.is._mth1(_fld1), com.target.mothership.model.guest.is._mth1(_fld1));
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    es.Guest()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/target/mothership/model/guest/a$e$1

/* anonymous class */
    class a.e._cls1 extends d
    {

        final a.e this$1;
        final Guest val$cachedSession;

        public void a(Guest guest)
        {
            com.target.mothership.model.guest.a.e.a(a.e.this).a(guest);
        }

        public void a(c c1)
        {
            switch (a._cls2.$SwitchMap$com$target$mothership$model$guest$interfaces$error$AuthFailure$AuthFailureReason[((com.target.mothership.model.guest.interfaces.a.c.a)c1.e()).ordinal()])
            {
            default:
                com.target.mothership.model.guest.a.a(this$0).clearGuest(cachedSession, new a.e._cls1._cls1());
                return;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
                com.target.mothership.model.guest.a.e.a(a.e.this).b(c1);
                break;
            }
        }

        public volatile void a(Object obj)
        {
            a((Guest)obj);
        }

        public void b(Object obj)
        {
            a((c)obj);
        }

            
            {
                this$1 = final_e1;
                cachedSession = Guest.this;
                super();
            }
    }

}
