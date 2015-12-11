// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import com.google.b.i;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.google.b.p;
import com.target.mothership.common.a.d;
import com.target.mothership.common.product.CatEntryId;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.Tcin;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class com.target.mothership.services.apigee.c.b.a
{
    public static class a
        implements k
    {

        public com.target.mothership.services.apigee.c.b.a a(l l1, Type type, j j1)
            throws p
        {
            type = null;
            com.target.mothership.services.apigee.c.b.a a1 = new com.target.mothership.services.apigee.c.b.a();
            o o1 = l1.m();
            if (o1.a("orderId"))
            {
                l1 = o1.b("orderId").c();
            } else
            {
                l1 = null;
            }
            com.target.mothership.services.apigee.c.b.a.a(a1, l1);
            if (o1.a("totalQuantity"))
            {
                l1 = o1.b("totalQuantity").c();
            } else
            {
                l1 = null;
            }
            com.target.mothership.services.apigee.c.b.a.b(a1, l1);
            l1 = type;
            if (o1.a("totalAmount"))
            {
                l1 = o1.b("totalAmount").c();
            }
            com.target.mothership.services.apigee.c.b.a.c(a1, l1);
            if (o1.a("orderItem"))
            {
                com.target.mothership.services.apigee.c.b.a.a(a1, new ArrayList());
label0:
                for (l1 = o1.b("orderItem").n().iterator(); l1.hasNext(); com.target.mothership.services.apigee.c.b.a.a(a1).add(type))
                {
                    type = (l)l1.next();
                    Object obj = type.m();
                    type = (b)j1.a(type, com/target/mothership/services/apigee/c/b/a$b);
                    if (((o) (obj)).a("espOrderItem") && ((o) (obj)).b("espOrderItem").i() && ((o) (obj)).b("espOrderItem").n().a() > 0 && ((o)((o) (obj)).b("espOrderItem").n().a(0)).a("espAddedFlag") && "Y".equals(((o)((o) (obj)).b("espOrderItem").n().a(0)).b("espAddedFlag").c()))
                    {
                        b.a(type, true);
                    }
                    if (!((o) (obj)).a("itemAttributes"))
                    {
                        continue;
                    }
                    b.a(type, new android.support.v4.f.a());
                    obj = ((o) (obj)).b("itemAttributes").n().iterator();
                    do
                    {
                        o o2;
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                continue label0;
                            }
                            o2 = ((l)((Iterator) (obj)).next()).m();
                        } while (!o2.a("attrName"));
                        b.a(type).put(o2.b("attrName").c(), o2.b("attrValue").c());
                    } while (true);
                }

            }
            return a1;
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

    public static class b
    {

        private List mAttachments;
        private String mCatalogEntryId;
        private String mDpci;
        private boolean mEspAdded;
        private String mEyebrow;
        private com.target.mothership.common.product.i mInventoryStatus;
        private String mInventoryStatusString;
        private Map mItemAttributes;
        private String mName;
        private String mOrderItemId;
        private String mOrderItemPrice;
        private String mOrderItemPriceCurrency;
        private String mPartNumber;
        private String mQuantity;
        private String mRegistryId;
        private String mRegistryName;
        private String mRegistryType;
        private String mSignatureRequiredString;
        private String mStoreId;
        private String mStoreName;

        static Map a(b b1)
        {
            return b1.mItemAttributes;
        }

        static Map a(b b1, Map map)
        {
            b1.mItemAttributes = map;
            return map;
        }

        static boolean a(b b1, boolean flag)
        {
            b1.mEspAdded = flag;
            return flag;
        }

        public Dpci a()
        {
            return new Dpci(mDpci);
        }

        public List b()
        {
            return mAttachments;
        }

        public CatEntryId c()
        {
            return new CatEntryId(mCatalogEntryId);
        }

        public com.target.mothership.common.product.i d()
        {
            if (mInventoryStatus == null)
            {
                mInventoryStatus = (new com.target.mothership.services.apigee.d.a()).a(mInventoryStatusString);
            }
            return mInventoryStatus;
        }

        public String e()
        {
            return mName;
        }

        public String f()
        {
            return mOrderItemId;
        }

        public String g()
        {
            return mOrderItemPrice;
        }

        public Tcin h()
        {
            return new Tcin(mPartNumber);
        }

        public String i()
        {
            return mQuantity;
        }

        public d j()
        {
            if (com.target.mothership.util.o.g(mEyebrow))
            {
                return com.target.mothership.common.a.d.a(mEyebrow);
            } else
            {
                return d.NONE;
            }
        }

        public Map k()
        {
            return mItemAttributes;
        }

        public String l()
        {
            return mStoreId;
        }

        public String m()
        {
            return mRegistryName;
        }

        public String n()
        {
            return mRegistryId;
        }

        public String o()
        {
            return mRegistryType;
        }

        public b()
        {
        }
    }


    private String mOrderId;
    private List mOrderItem;
    private String mTotalAmount;
    private String mTotalQuantity;

    public com.target.mothership.services.apigee.c.b.a()
    {
    }

    static String a(com.target.mothership.services.apigee.c.b.a a1, String s)
    {
        a1.mOrderId = s;
        return s;
    }

    static List a(com.target.mothership.services.apigee.c.b.a a1)
    {
        return a1.mOrderItem;
    }

    static List a(com.target.mothership.services.apigee.c.b.a a1, List list)
    {
        a1.mOrderItem = list;
        return list;
    }

    static String b(com.target.mothership.services.apigee.c.b.a a1, String s)
    {
        a1.mTotalQuantity = s;
        return s;
    }

    static String c(com.target.mothership.services.apigee.c.b.a a1, String s)
    {
        a1.mTotalAmount = s;
        return s;
    }

    public String a()
    {
        return mOrderId;
    }

    public String b()
    {
        return mTotalQuantity;
    }

    public String c()
    {
        return mTotalAmount;
    }

    public List d()
    {
        return mOrderItem;
    }
}
