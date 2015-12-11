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
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            h, b

public class aj
{
    public class a
    {

        private static final String CARD_CC_TYPE = "card_cctype";
        private static final String CARD_NICK_NAME = "card_nickname";
        private static final String CARD_NUMBER = "card_number";
        private static final String CARD_TYPE = "card_type";
        private static final String CC_NAME_ON_CARD = "cc_nameoncard";
        private static final String EXPIRE_MONTH = "expire_month";
        private static final String EXPIRE_YEAR = "expire_year";
        private static final String IS_APPLIED_TO_ORDER = "isAppliedToOrder";
        private static final String IS_AUTHENTICATED = "isAuthenticated";
        private static final String IS_PRIMARY = "isPrimary";
        private static final int NULL_INT = -1;
        private static final String YES = "Y";
        private Map mProtocolDataMap;
        final aj this$0;

        public boolean a()
        {
            if (mProtocolDataMap.containsKey("isAuthenticated"))
            {
                return ((String)mProtocolDataMap.get("isAuthenticated")).equalsIgnoreCase("Y");
            } else
            {
                return false;
            }
        }

        public boolean b()
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

        public boolean c()
        {
            if (mProtocolDataMap.containsKey("isAppliedToOrder"))
            {
                return Boolean.parseBoolean((String)mProtocolDataMap.get("isAppliedToOrder"));
            } else
            {
                return false;
            }
        }

        public String d()
        {
            if (mProtocolDataMap.containsKey("card_number"))
            {
                return (String)mProtocolDataMap.get("card_number");
            } else
            {
                return null;
            }
        }

        public String e()
        {
            if (mProtocolDataMap.containsKey("cc_nameoncard"))
            {
                return (String)mProtocolDataMap.get("cc_nameoncard");
            } else
            {
                return null;
            }
        }

        public String f()
        {
            if (mProtocolDataMap.containsKey("card_nickname"))
            {
                return (String)mProtocolDataMap.get("card_nickname");
            } else
            {
                return null;
            }
        }

        public com.target.mothership.common.tender.a g()
        {
            if (mProtocolDataMap.containsKey("card_type"))
            {
                return com.target.mothership.common.tender.a.a((String)mProtocolDataMap.get("card_type"));
            } else
            {
                return com.target.mothership.common.tender.a.UNKNOWN;
            }
        }

        public int h()
        {
            if (mProtocolDataMap.containsKey("expire_month") && o.g((String)mProtocolDataMap.get("expire_month")) && !"0".equalsIgnoreCase((String)mProtocolDataMap.get("expire_month")))
            {
                return Integer.parseInt((String)mProtocolDataMap.get("expire_month"));
            } else
            {
                return -1;
            }
        }

        public int i()
        {
            if (mProtocolDataMap.containsKey("expire_year") && o.g((String)mProtocolDataMap.get("expire_year")) && !"0".equalsIgnoreCase((String)mProtocolDataMap.get("expire_year")))
            {
                return Integer.parseInt((String)mProtocolDataMap.get("expire_year"));
            } else
            {
                return -1;
            }
        }

        a(Map map)
        {
            this$0 = aj.this;
            super();
            mProtocolDataMap = map;
        }
    }

    public static class b
        implements k
    {

        public aj a(l l1, Type type, j j)
            throws p
        {
            j = new f();
            type = (aj)j.a(l1, type);
            com.target.mothership.services.apigee.c.b.aj.a(type, (com.target.mothership.services.apigee.c.b.b)j.a(l1, com/target/mothership/services/apigee/c/b/b));
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
                    j = ((l)l1.next()).m();
                    if (j.a("name") && j.a("value"))
                    {
                        com.target.mothership.services.apigee.c.b.aj.a(type).put(j.b("name").c(), j.b("value").c());
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


    private static final String INVALID_EXPIRY = "0";
    private com.target.mothership.services.apigee.c.b.b mAddress;
    private a mCardData;
    private String mMemberCardInfoId;
    private String mPhone1;
    private c mPhone1Type;
    private String mPhone1TypeString;
    private Map mProtocolDataMap;

    public aj()
    {
        mProtocolDataMap = new android.support.v4.f.a();
    }

    static com.target.mothership.services.apigee.c.b.b a(aj aj1, com.target.mothership.services.apigee.c.b.b b1)
    {
        aj1.mAddress = b1;
        return b1;
    }

    static Map a(aj aj1)
    {
        return aj1.mProtocolDataMap;
    }

    public String a()
    {
        return mPhone1;
    }

    public c b()
    {
        if (mPhone1Type == null)
        {
            mPhone1Type = (new h()).a(mPhone1TypeString);
        }
        return mPhone1Type;
    }

    public String c()
    {
        return mMemberCardInfoId;
    }

    public com.target.mothership.services.apigee.c.b.b d()
    {
        return mAddress;
    }

    public a e()
    {
        return new a(mProtocolDataMap);
    }
}
