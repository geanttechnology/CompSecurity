// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.target.mothership.services.f.a.a;
import com.target.mothership.services.f.a.c;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            c, e, g, i, 
//            a, b, j, l

public class f extends a
{

    private static final com.target.mothership.services.f.a.b.a ADDRESS_ID = new com.target.mothership.services.f.a.b.a("addressId");
    private static c ADD_PAYMENT_TENDER;
    private static c AUTH;
    private static final com.target.mothership.services.f.a.b.a CARD_TYPE = new com.target.mothership.services.f.a.b.a("cardType");
    private static c CHANGE_EMAIL;
    private static c CHANGE_PASSWORD;
    private static c CREATE;
    private static c CREATE_SHIPPING_ADDRESS;
    private static c DELETE_SHIPPING_ADDRESS;
    private static c GET_PAYMENT_TENDERS;
    private static c LOGOUT;
    private static final com.target.mothership.services.f.a.b.a MEMBER_CARD_INFO_ID = new com.target.mothership.services.f.a.b.a("memberCardInfoId");
    private static c PASSWORD_RESET;
    private static c PROFILE;
    private static c REMOVE_PAYMENT_TENDER;
    private static c SHIPPING_ADDRESSES;
    private static c UPDATE_PAYMENT_TENDER;
    private static c UPDATE_PROFILE;
    private static c UPDATE_PUBLIC_PROFILE;
    private static c UPDATE_SHIPPING_ADDRESS;

    public f(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a()
    {
        return a(AUTH, null, null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(com.target.mothership.services.apigee.f.a.c c1)
    {
        return a(AUTH, ((com.target.mothership.services.n) (c1)), null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(e e1)
    {
        return a(CREATE, ((com.target.mothership.services.n) (e1)), null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(g g)
    {
        return a(AUTH, ((com.target.mothership.services.n) (g)), null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(i i)
    {
        return a(PASSWORD_RESET, ((com.target.mothership.services.n) (i)), null, null, null);
    }

    public com.target.mothership.services.f.a.b.b a(String s)
    {
        return a(AUTH, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, com.target.mothership.services.apigee.f.a.a a1)
    {
        c c1 = ADD_PAYMENT_TENDER;
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a2.put(CARD_TYPE.b(), com.target.mothership.common.tender.c.GIFT_CARD.toString());
        return a(c1, ((com.target.mothership.services.n) (a1)), ((Map) (a2)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, b b1)
    {
        c c1 = ADD_PAYMENT_TENDER;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(CARD_TYPE.b(), com.target.mothership.common.tender.c.PAYMENT_CARD.toString());
        return a(c1, ((com.target.mothership.services.n) (b1)), ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, g g)
    {
        return a(AUTH, ((com.target.mothership.services.n) (g)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, j j)
    {
        return a(CREATE_SHIPPING_ADDRESS, ((com.target.mothership.services.n) (j)), null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1)
    {
        c c1 = DELETE_SHIPPING_ADDRESS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ADDRESS_ID.b(), s1);
        return a(c1, null, ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1, j j)
    {
        c c1 = UPDATE_SHIPPING_ADDRESS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ADDRESS_ID.b(), s1);
        return a(c1, ((com.target.mothership.services.n) (j)), ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1, l l)
    {
        c c1 = UPDATE_PAYMENT_TENDER;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(MEMBER_CARD_INFO_ID.b(), s1);
        a1.put(CARD_TYPE.b(), com.target.mothership.common.tender.c.PAYMENT_CARD.toString());
        return a(c1, ((com.target.mothership.services.n) (l)), ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1, String s2)
    {
        c c1 = REMOVE_PAYMENT_TENDER;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(MEMBER_CARD_INFO_ID.b(), s1);
        a1.put(CARD_TYPE.b(), s2);
        return a(c1, null, ((Map) (a1)), null, null, s);
    }

    public com.target.mothership.services.f.a.b.b b(String s)
    {
        return a(LOGOUT, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b c(String s)
    {
        c c1 = GET_PAYMENT_TENDERS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(CARD_TYPE.b(), com.target.mothership.common.tender.c.GIFT_CARD.toString());
        return a(c1, null, a1, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b d(String s)
    {
        c c1 = GET_PAYMENT_TENDERS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(CARD_TYPE.b(), com.target.mothership.common.tender.c.PAYMENT_CARD.toString());
        return a(c1, null, a1, null, null, s);
    }

    public com.target.mothership.services.f.a.b.b e(String s)
    {
        return a(SHIPPING_ADDRESSES, null, null, null, null, s);
    }

    static 
    {
        AUTH = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/auth");
        LOGOUT = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/logout");
        CREATE = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3");
        SHIPPING_ADDRESSES = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/addresses");
        CREATE_SHIPPING_ADDRESS = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/addresses");
        UPDATE_SHIPPING_ADDRESS = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/addresses/{addressId}");
        DELETE_SHIPPING_ADDRESS = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/addresses/{addressId}");
        GET_PAYMENT_TENDERS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/tenders?type={cardType}");
        ADD_PAYMENT_TENDER = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/tenders?type={cardType}");
        UPDATE_PAYMENT_TENDER = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/tenders/{memberCardInfoId}?type={cardType}");
        REMOVE_PAYMENT_TENDER = new c(com.target.mothership.services.f.a.d.a.DELETE, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/tenders/{memberCardInfoId}?type={cardType}");
        PROFILE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/profile");
        UPDATE_PROFILE = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/profile");
        UPDATE_PUBLIC_PROFILE = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/public_profile");
        PASSWORD_RESET = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/password");
        CHANGE_PASSWORD = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/password");
        CHANGE_EMAIL = new c(com.target.mothership.services.f.a.d.a.PUT, com.target.mothership.services.f.b.a.a.ApigeePciSecure, "/guests/v3/email_address");
    }
}
