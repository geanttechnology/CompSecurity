// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.a.b;
import com.target.mothership.model.guest.interfaces.a.d;
import com.target.mothership.model.guest.interfaces.a.e;
import com.target.mothership.model.guest.interfaces.a.f;
import com.target.mothership.model.guest.interfaces.a.k;
import com.target.mothership.model.guest.interfaces.a.l;
import com.target.mothership.model.guest.interfaces.a.m;
import com.target.mothership.services.x;
import com.target.mothership.util.g;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.guest:
//            GuestDataSource, a

class c extends GuestDataSource
{

    c()
    {
    }

    public void a(Guest guest, int i, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_guest_order_history.json");
        } else
        {
            a("order_history.json");
        }
        (new a()).a(guest, i, d1);
    }

    public void a(Guest guest, AddressParams addressparams, boolean flag, com.target.mothership.model.d d1)
    {
        a(d1, java/lang/String, com/target/mothership/model/guest/interfaces/a/e);
    }

    public void a(Guest guest, com.target.mothership.common.params.b b1, com.target.mothership.model.d d1)
    {
        a(d1, com/target/mothership/common/tender/PaymentTender, com/target/mothership/model/guest/interfaces/a/b);
    }

    public void a(Guest guest, PaymentTender paymenttender, com.target.mothership.model.d d1)
    {
        a(d1, ((Class) (null)), com/target/mothership/model/guest/interfaces/a/k);
    }

    public void a(Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, com.target.mothership.model.d d1)
    {
        a(d1, com/target/mothership/common/tender/PaymentTender, com/target/mothership/model/guest/interfaces/a/m);
    }

    public void a(Guest guest, GuestAddress guestaddress, AddressParams addressparams, boolean flag, com.target.mothership.model.d d1)
    {
        a(d1, java/lang/String, com/target/mothership/model/guest/interfaces/a/l);
    }

    public void a(Guest guest, GuestAddress guestaddress, com.target.mothership.model.d d1)
    {
        a(d1, java/lang/String, com/target/mothership/model/guest/interfaces/a/f);
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("get_guest_addressess_error_auth.json");
        } else
        {
            a("get_guest_addressess.json");
        }
        (new a()).a(guest, d1);
    }

    public void a(Guest guest, com.target.mothership.model.h h1)
    {
        a(((com.target.mothership.model.d) (h1)), com/target/mothership/model/guest/interfaces/Guest, com/target/mothership/services/x);
    }

    public void a(Guest guest, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_guest_order_details.json");
        } else
        {
            a("order_details.json");
        }
        (new a()).a(guest, s, d1);
    }

    public void a(Guest guest, String s, String s1, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_guest_add_gift_card.json");
        } else
        {
            a("add_update_payment_tender.json");
        }
        (new a()).a(guest, s, s1, d1);
    }

    public void a(com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            h1.a(com.google.a.a.e.b(g.FAKE_GUEST));
            return;
        }
    }

    public void a(String s, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            h1.a(null);
            return;
        }
    }

    public void a(String s, String s1, com.target.mothership.model.d d1)
    {
        a(d1, com/target/mothership/model/guest/interfaces/Guest, com/target/mothership/model/guest/interfaces/a/c);
    }

    public void a(String s, String s1, String s2, String s3, String s4, String s5, boolean flag, 
            com.target.mothership.model.d d1)
    {
        a(d1, com/target/mothership/model/guest/interfaces/Guest, com/target/mothership/model/guest/interfaces/a/d);
    }

    public void b(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_auth_invalid_token.json");
        } else
        {
            a("get_giftcard_payment_tenders.json");
        }
        (new a()).b(guest, d1);
    }

    public void b(Guest guest, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            h1.a(null);
            return;
        }
    }

    public void b(com.target.mothership.model.h h1)
    {
        a(h1, com/target/mothership/model/guest/interfaces/Guest, com/target/mothership/services/x);
    }

    public void c(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_auth_invalid_token.json");
        } else
        {
            a("get_payment_card_tenders.json");
        }
        (new a()).c(guest, d1);
    }
}
