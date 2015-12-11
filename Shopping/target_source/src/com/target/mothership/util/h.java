// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.util;

import com.target.mothership.model.common.a.j;
import com.target.mothership.model.guest.interfaces.a.b;
import com.target.mothership.model.guest.interfaces.a.d;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import java.util.Arrays;
import java.util.List;

public class h
{

    public static final b ADD_PAYMENT_TENDER_FAILURE;
    public static final d CREATE_ACCOUNT_FAILURE;
    public static final Object Errors[];
    public static final x NETWORK_ERROR;

    static 
    {
        NETWORK_ERROR = x.a("").b("").a(z.SERVICE_UNAVAILABLE).a();
        CREATE_ACCOUNT_FAILURE = new d() {

            public com.target.mothership.model.guest.interfaces.a.d.a[] a()
            {
                return com.target.mothership.model.guest.interfaces.a.d.a.values();
            }

            public j[] c()
            {
                return a();
            }

            public x d()
            {
                return h.NETWORK_ERROR;
            }

            public List f()
            {
                return Arrays.asList(com.target.mothership.model.guest.interfaces.a.d.a.values());
            }

        };
        ADD_PAYMENT_TENDER_FAILURE = new b() {

            public com.target.mothership.model.guest.interfaces.a.b.a b()
            {
                return com.target.mothership.model.guest.interfaces.a.b.a.ERR_CARD_NUMBER_INVALID;
            }

            public x d()
            {
                return h.NETWORK_ERROR;
            }

            public j e()
            {
                return b();
            }

            public List f()
            {
                return Arrays.asList(com.target.mothership.model.guest.interfaces.a.b.a.values());
            }

        };
        Errors = (new Object[] {
            NETWORK_ERROR, CREATE_ACCOUNT_FAILURE, ADD_PAYMENT_TENDER_FAILURE
        });
    }
}
