// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            b

public class m
{
    public class a
    {

        private static final String CARD_NUMBER = "CardNumber";
        private static final String PAYMENT_METHOD = "PaymentMethod";
        private Map mProtocolDataMap;
        final m this$0;

        public String a()
        {
            if (mProtocolDataMap.containsKey("CardNumber"))
            {
                return (String)mProtocolDataMap.get("CardNumber");
            } else
            {
                return null;
            }
        }

        public com.target.mothership.common.tender.a b()
        {
            if (mProtocolDataMap.containsKey("PaymentMethod"))
            {
                return com.target.mothership.common.tender.a.a((String)mProtocolDataMap.get("PaymentMethod"));
            } else
            {
                return com.target.mothership.common.tender.a.UNKNOWN;
            }
        }

        a(Map map)
        {
            this$0 = m.this;
            super();
            mProtocolDataMap = map;
        }
    }

    public static class b
        implements k
    {

        public m a(l l1, Type type, j j)
            throws p
        {
            j = new f();
            type = (m)j.a(l1, type);
            m.a(type, (com.target.mothership.services.apigee.c.b.b)j.a(l1, com/target/mothership/services/apigee/c/b/b));
            l1 = l1.m();
            if (l1.a("protocolData"))
            {
                m.a(type, new android.support.v4.f.a());
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
                        m.a(type).put(j.b("name").c(), j.b("value").c());
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

        public b()
        {
        }
    }


    private com.target.mothership.services.apigee.c.b.b mAddress;
    private Map mProtocolDataMap;

    public m()
    {
    }

    static com.target.mothership.services.apigee.c.b.b a(m m1, com.target.mothership.services.apigee.c.b.b b1)
    {
        m1.mAddress = b1;
        return b1;
    }

    static Map a(m m1)
    {
        return m1.mProtocolDataMap;
    }

    static Map a(m m1, Map map)
    {
        m1.mProtocolDataMap = map;
        return map;
    }

    public com.target.mothership.services.apigee.c.b.b a()
    {
        return mAddress;
    }

    public a b()
    {
        return new a(mProtocolDataMap);
    }
}
