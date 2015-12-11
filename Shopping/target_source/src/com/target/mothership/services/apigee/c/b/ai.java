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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.mothership.services.apigee.c.b:
//            j

public class ai
{
    public static class a
        implements k
    {

        static List a(o o1, j j1)
        {
            if (o1.a("orderItem"))
            {
                ArrayList arraylist = new ArrayList();
                b b1;
label0:
                for (o1 = o1.b("orderItem").n().iterator(); o1.hasNext(); arraylist.add(b1))
                {
                    Object obj = (l)o1.next();
                    b1 = (b)j1.a(((l) (obj)), com/target/mothership/services/apigee/c/b/ai$b);
                    obj = ((l) (obj)).m();
                    if (((o) (obj)).a("quantity"))
                    {
                        b1.mQuantity = Integer.valueOf(Double.valueOf(((o) (obj)).b("quantity").d()).intValue());
                    }
                    if (!((o) (obj)).a("itemAttributes"))
                    {
                        continue;
                    }
                    b1.mItemAttributes = new android.support.v4.f.a();
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
                        b1.mItemAttributes.put(o2.b("attrName").c(), o2.b("attrValue").c());
                    } while (true);
                }

                return arraylist;
            } else
            {
                return null;
            }
        }

        public ai a(l l1, Type type, j j1)
            throws p
        {
            type = new ai();
            l1 = l1.m();
            ai.a(type, (com.target.mothership.services.apigee.c.b.j)j1.a(l1, com/target/mothership/services/apigee/c/b/j));
            type.mOrderItem = a(((o) (l1)), j1);
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

    public static class b
    {

        private List mAttachments;
        private String mCurrency;
        private String mDescription;
        private Integer mInventoryStatus;
        Map mItemAttributes;
        private String mOrderItemId;
        private String mOrderItemPrice;
        Integer mQuantity;

        public b()
        {
        }
    }


    private com.target.mothership.services.apigee.c.b.j mCartPricesResponse;
    List mOrderItem;

    public ai()
    {
    }

    static com.target.mothership.services.apigee.c.b.j a(ai ai1, com.target.mothership.services.apigee.c.b.j j)
    {
        ai1.mCartPricesResponse = j;
        return j;
    }
}
