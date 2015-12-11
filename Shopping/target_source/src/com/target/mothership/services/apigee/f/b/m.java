// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.b;

import android.support.v4.f.a;
import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import com.target.mothership.util.o;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.f.b:
//            f

public class m
{
    public static class a
        implements k
    {

        public m a(l l1, Type type, j j1)
            throws p
        {
            j1 = new f();
            type = new m();
            l1 = l1.m();
            com.target.mothership.services.apigee.f.b.m.a(type, (com.target.mothership.services.apigee.f.b.f)j1.a(l1, com/target/mothership/services/apigee/f/b/f));
            if (l1.a("protocolData"))
            {
                l1 = l1.b("protocolData").n().iterator();
                do
                {
                    if (!l1.hasNext())
                    {
                        break;
                    }
                    j1 = ((l)l1.next()).m();
                    if (j1.a("name") && j1.a("value"))
                    {
                        com.target.mothership.services.apigee.f.b.m.a(type).put(j1.b("name").c(), j1.b("value").c());
                    }
                } while (true);
            }
            return type;
        }

        public Object deserialize(l l1, Type type, j j1)
            throws p
        {
            return a(l1, type, j1);
        }

        public a()
        {
        }
    }


    private static final String INVALID_EXPIRY = "0";
    private static final int NULL_INT = -1;
    private static final String YES = "Y";
    private com.target.mothership.services.apigee.f.b.f mBillingAddress;
    private Map mProtocolDataMap;

    public m()
    {
        mProtocolDataMap = new android.support.v4.f.a();
    }

    static com.target.mothership.services.apigee.f.b.f a(m m1, com.target.mothership.services.apigee.f.b.f f1)
    {
        m1.mBillingAddress = f1;
        return f1;
    }

    static Map a(m m1)
    {
        return m1.mProtocolDataMap;
    }

    public com.target.mothership.services.apigee.f.b.f a()
    {
        return mBillingAddress;
    }

    public String b()
    {
        return (String)mProtocolDataMap.get("memberCardInfoId");
    }

    public String c()
    {
        return (String)mProtocolDataMap.get("cardNumber");
    }

    public boolean d()
    {
        if (mProtocolDataMap.containsKey("authenticated"))
        {
            return ((String)mProtocolDataMap.get("authenticated")).equalsIgnoreCase("Y");
        } else
        {
            return false;
        }
    }

    public boolean e()
    {
        if (mProtocolDataMap.containsKey("isPrimary"))
        {
            String s = (String)mProtocolDataMap.get("isPrimary");
            if (o.g(s) && Integer.parseInt(s) > 0)
            {
                return true;
            }
        }
        return false;
    }

    public com.target.mothership.common.tender.a f()
    {
        if (mProtocolDataMap.containsKey("cardType"))
        {
            return com.target.mothership.common.tender.a.a((String)mProtocolDataMap.get("cardType"));
        } else
        {
            return com.target.mothership.common.tender.a.UNKNOWN;
        }
    }

    public String g()
    {
        if (mProtocolDataMap.containsKey("cardName"))
        {
            return (String)mProtocolDataMap.get("cardName");
        } else
        {
            return null;
        }
    }

    public String h()
    {
        if (mProtocolDataMap.containsKey("cardNickName"))
        {
            return (String)mProtocolDataMap.get("cardNickName");
        } else
        {
            return null;
        }
    }

    public int i()
    {
        if (mProtocolDataMap.containsKey("cardExpMonth") && o.g((String)mProtocolDataMap.get("cardExpMonth")) && !"0".equalsIgnoreCase((String)mProtocolDataMap.get("cardExpMonth")))
        {
            return Integer.parseInt((String)mProtocolDataMap.get("cardExpMonth"));
        } else
        {
            return -1;
        }
    }

    public int j()
    {
        if (mProtocolDataMap.containsKey("cardExpYear") && o.g((String)mProtocolDataMap.get("cardExpYear")) && !"0".equalsIgnoreCase((String)mProtocolDataMap.get("cardExpYear")))
        {
            return Integer.parseInt((String)mProtocolDataMap.get("cardExpYear"));
        } else
        {
            return -1;
        }
    }
}
