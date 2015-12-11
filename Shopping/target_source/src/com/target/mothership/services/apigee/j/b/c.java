// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class com.target.mothership.services.apigee.j.b.c
{
    public static class a
    {

        private List mAddressLines;
        private String mBillingAddressId;
        private String mCity;
        private String mCountry;
        private String mFirstName;
        private String mLastName;
        private String mMiddleName;
        private String mMobilePhone1;
        private String mOtherPhone;
        private String mPhone1;
        private String mPhone2;
        private String mPostalCode;
        private String mStateOrProvinceName;

        public String a()
        {
            return mFirstName;
        }

        public String b()
        {
            return mLastName;
        }

        public String c()
        {
            return mMiddleName;
        }

        public String d()
        {
            return mBillingAddressId;
        }

        public List e()
        {
            return mAddressLines;
        }

        public String f()
        {
            return mCity;
        }

        public String g()
        {
            return mStateOrProvinceName;
        }

        public String h()
        {
            return mCountry;
        }

        public String i()
        {
            return mPostalCode;
        }

        public String j()
        {
            return mPhone1;
        }

        public String k()
        {
            return mPhone2;
        }

        public String l()
        {
            return mMobilePhone1;
        }

        public String m()
        {
            return mOtherPhone;
        }

        public a()
        {
        }
    }

    public class b
    {

        private static final String CARD_AMOUNT = "cardAmount";
        private static final String CARD_NUMBER = "CardNumber";
        private static final String PAYMENT_METHOD = "PaymentMethod";
        private Map mProtocolDataMap;
        final com.target.mothership.services.apigee.j.b.c this$0;

        public String a()
        {
            return (String)mProtocolDataMap.get("CardNumber");
        }

        public String b()
        {
            return (String)mProtocolDataMap.get("PaymentMethod");
        }

        public String c()
        {
            return (String)mProtocolDataMap.get("cardAmount");
        }

        b(Map map)
        {
            this$0 = com.target.mothership.services.apigee.j.b.c.this;
            super();
            mProtocolDataMap = map;
        }
    }

    public static class c
        implements k
    {

        public com.target.mothership.services.apigee.j.b.c a(l l1, Type type, j j)
            throws p
        {
            j = new f();
            type = (com.target.mothership.services.apigee.j.b.c)j.a(l1, type);
            com.target.mothership.services.apigee.j.b.c.a(type, (a)j.a(l1, com/target/mothership/services/apigee/j/b/c$a));
            l1 = l1.m();
            com.target.mothership.services.apigee.j.b.c.a(type, new android.support.v4.f.a());
            if (l1.a("protocolData"))
            {
                l1 = l1.b("protocolData").n().iterator();
                do
                {
                    if (!l1.hasNext())
                    {
                        break;
                    }
                    j = ((l)l1.next()).m();
                    if (j.a("name") && j.a("value"))
                    {
                        com.target.mothership.services.apigee.j.b.c.a(type).put(j.b("name").c(), j.b("value").c());
                    }
                } while (true);
            }
            return type;
        }

        public Object deserialize(l l1, Type type, j j)
            throws p
        {
            return a(l1, type, j);
        }

        public c()
        {
        }
    }


    private a mAddress;
    private Map mProtocolDataMap;

    public com.target.mothership.services.apigee.j.b.c()
    {
    }

    static a a(com.target.mothership.services.apigee.j.b.c c1, a a1)
    {
        c1.mAddress = a1;
        return a1;
    }

    static Map a(com.target.mothership.services.apigee.j.b.c c1)
    {
        return c1.mProtocolDataMap;
    }

    static Map a(com.target.mothership.services.apigee.j.b.c c1, Map map)
    {
        c1.mProtocolDataMap = map;
        return map;
    }

    public a a()
    {
        return mAddress;
    }

    public b b()
    {
        return new b(mProtocolDataMap);
    }
}
