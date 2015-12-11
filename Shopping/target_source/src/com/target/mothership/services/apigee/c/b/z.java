// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import android.support.v4.f.a;
import com.google.b.f;
import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.p;
import com.target.mothership.model.common.c;
import com.target.mothership.util.o;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            h, b

public class z
{
    public class a
    {

        private static final String CARD_NUMBER = "card_number";
        private static final String CC_NAME_ON_CARD = "cc_nameoncard";
        private static final String CC_TYPE = "cc_type";
        private static final String EXPIRE_MONTH = "expire_month";
        private static final String EXPIRE_YEAR = "expire_year";
        private static final String GC_BALANCE = "gcBalance";
        private static final int NULL_INT = -1;
        private static final String PAYMENT_METHOD = "payment_method";
        private Map mProtocolDataMap;
        final z this$0;

        public String a()
        {
            if (mProtocolDataMap.containsKey("card_number"))
            {
                return (String)mProtocolDataMap.get("card_number");
            } else
            {
                return null;
            }
        }

        public String b()
        {
            if (mProtocolDataMap.containsKey("cc_nameoncard"))
            {
                return (String)mProtocolDataMap.get("cc_nameoncard");
            } else
            {
                return null;
            }
        }

        public com.target.mothership.common.tender.a c()
        {
            if (mProtocolDataMap.containsKey("cc_type"))
            {
                return com.target.mothership.common.tender.a.a((String)mProtocolDataMap.get("cc_type"));
            } else
            {
                return com.target.mothership.common.tender.a.UNKNOWN;
            }
        }

        public int d()
        {
            if (mProtocolDataMap.containsKey("expire_month") && o.g((String)mProtocolDataMap.get("expire_month")))
            {
                return Integer.parseInt((String)mProtocolDataMap.get("expire_month"));
            } else
            {
                return -1;
            }
        }

        public int e()
        {
            if (mProtocolDataMap.containsKey("expire_year") && o.g((String)mProtocolDataMap.get("expire_year")))
            {
                return Integer.parseInt((String)mProtocolDataMap.get("expire_year"));
            } else
            {
                return -1;
            }
        }

        public BigDecimal f()
        {
            if (mProtocolDataMap.containsKey("gcBalance") && o.g((String)mProtocolDataMap.get("gcBalance")))
            {
                return new BigDecimal((String)mProtocolDataMap.get("gcBalance"));
            } else
            {
                return com.target.mothership.util.c.ZERO;
            }
        }

        a(Map map)
        {
            this$0 = z.this;
            super();
            mProtocolDataMap = map;
        }
    }

    public static class b
        implements k
    {

        public z a(l l1, Type type, j j1)
            throws p
        {
            j1 = new f();
            type = (z)j1.a(l1, type);
            com.target.mothership.services.apigee.c.b.z.a(type, (com.target.mothership.services.apigee.c.b.b)j1.a(l1, com/target/mothership/services/apigee/c/b/b));
            l1 = l1.m();
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
                    if (j1.a("name"))
                    {
                        com.target.mothership.services.apigee.c.b.z.a(type).put(j1.b("name").c(), j1.b("value").c());
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

        public b()
        {
        }
    }


    private final String SUCCESS = "success";
    private com.target.mothership.services.apigee.c.b.b mAddress;
    private String mEmail1;
    private String mEmail2;
    private String mFax1;
    private String mFax2;
    private String mMemberCardInfoId;
    private String mNickName;
    private String mPayMethodId;
    private String mPersonTitle;
    private String mPhone1;
    private String mPhone1Publish;
    private c mPhone1Type;
    private String mPhone1TypeString;
    private String mPhone2;
    private String mPhone2Publish;
    private String mPiAmountString;
    private String mPiCurrencyString;
    private String mPiDescription;
    private String mPiId;
    private String mPiStatusString;
    private Map mProtocolDataMap;

    public z()
    {
        mProtocolDataMap = new android.support.v4.f.a();
    }

    static com.target.mothership.services.apigee.c.b.b a(z z1, com.target.mothership.services.apigee.c.b.b b1)
    {
        z1.mAddress = b1;
        return b1;
    }

    static Map a(z z1)
    {
        return z1.mProtocolDataMap;
    }

    public String a()
    {
        return mMemberCardInfoId;
    }

    public String b()
    {
        return mNickName;
    }

    public com.target.mothership.common.tender.a c()
    {
        return com.target.mothership.common.tender.a.a(mPayMethodId);
    }

    public String d()
    {
        return mPhone1;
    }

    public c e()
    {
        if (mPhone1Type == null)
        {
            mPhone1Type = (new h()).a(mPhone1TypeString);
        }
        return mPhone1Type;
    }

    public String f()
    {
        return mPiAmountString;
    }

    public String g()
    {
        return mPiCurrencyString;
    }

    public String h()
    {
        return mPiId;
    }

    public a i()
    {
        return new a(mProtocolDataMap);
    }

    public com.target.mothership.services.apigee.c.b.b j()
    {
        return mAddress;
    }
}
