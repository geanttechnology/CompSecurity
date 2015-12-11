// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.s;
import com.target.mothership.model.cart.interfaces.UsableTenders;
import com.target.mothership.model.cart.interfaces.a.n;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.common.TGTPaymentCardTender;
import com.target.mothership.model.common.a;
import com.target.mothership.model.common.c;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.aj;
import com.target.mothership.services.apigee.c.b.am;
import com.target.mothership.services.x;
import com.target.mothership.util.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            t, f, TGTAppliedPaymentCardTender, c, 
//            TGTCartGuestAddress, TGTCartPhoneNumber, TGTPaymentCardExpiration, d, 
//            TGTUsableTenders

public class z extends b
{

    private static final int NULL_INT = -1;
    private final aa mTransformer = new aa() {

        final z this$0;

        private AppliedPaymentCardTender a(List list, List list1)
        {
            if (list != null)
            {
                if ((list = (new t()).a(list)) != null)
                {
                    list = (new f()).a(list);
                    list1 = list1.iterator();
                    do
                    {
                        if (!list1.hasNext())
                        {
                            break;
                        }
                        aj aj1 = (aj)list1.next();
                        if (!list.a().equalsIgnoreCase(aj1.c()))
                        {
                            continue;
                        }
                        list.a(aj1.e().b());
                        break;
                    } while (true);
                    return list;
                }
            }
            return null;
        }

        private List a(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            com.target.mothership.model.cart.handler.c c1 = new com.target.mothership.model.cart.handler.c();
            ArrayList arraylist = new ArrayList();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                aj aj1 = (aj)list.next();
                if (!aj1.e().c())
                {
                    TGTPaymentCardTender tgtpaymentcardtender = new TGTPaymentCardTender();
                    tgtpaymentcardtender.b(aj1.c());
                    com.target.mothership.services.apigee.c.b.aj.a a1 = aj1.e();
                    tgtpaymentcardtender.b(a1.a());
                    tgtpaymentcardtender.a(a1.b());
                    TGTCartGuestAddress tgtcartguestaddress = c1.a(aj1.d());
                    tgtcartguestaddress.a(a.Billing);
                    TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
                    tgtcartphonenumber.a(aj1.a());
                    tgtcartphonenumber.a(aj1.b());
                    tgtcartguestaddress.a(tgtcartphonenumber);
                    tgtpaymentcardtender.a(tgtcartguestaddress);
                    tgtpaymentcardtender.c(l.c(a1.d()));
                    tgtpaymentcardtender.e(a1.f());
                    tgtpaymentcardtender.a(a1.g());
                    tgtpaymentcardtender.d(a1.e());
                    if (a1.h() != -1)
                    {
                        tgtpaymentcardtender.a(new TGTPaymentCardExpiration(com.target.mothership.common.tender.b.a(String.valueOf(a1.h())), a1.i()));
                    } else
                    {
                        tgtpaymentcardtender.a(null);
                    }
                    arraylist.add(tgtpaymentcardtender);
                }
            } while (true);
            return arraylist;
        }

        private List b(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            ArrayList arraylist = new ArrayList();
            com.target.mothership.model.cart.handler.d d1 = new com.target.mothership.model.cart.handler.d();
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.target.mothership.services.apigee.c.b.z z1 = (com.target.mothership.services.apigee.c.b.z)list.next();
                if (z1.i().c() == com.target.mothership.common.tender.a.TARGET_GIFT_CARD)
                {
                    arraylist.add(d1.a(z1));
                }
            } while (true);
            return arraylist;
        }

        private List c(List list)
        {
            if (list == null)
            {
                return Collections.emptyList();
            }
            com.target.mothership.model.cart.handler.c c1 = new com.target.mothership.model.cart.handler.c();
            ArrayList arraylist = new ArrayList();
            TGTCartGuestAddress tgtcartguestaddress;
            for (list = list.iterator(); list.hasNext(); arraylist.add(tgtcartguestaddress))
            {
                com.target.mothership.services.apigee.c.b.b b1 = (com.target.mothership.services.apigee.c.b.b)list.next();
                tgtcartguestaddress = c1.a(b1);
                TGTCartPhoneNumber tgtcartphonenumber = new TGTCartPhoneNumber();
                tgtcartphonenumber.a(b1.k());
                tgtcartphonenumber.a(c.Other);
                tgtcartguestaddress.a(tgtcartphonenumber);
            }

            return arraylist;
        }

        public UsableTenders a(am am1)
        {
            TGTUsableTenders tgtusabletenders = new TGTUsableTenders();
            tgtusabletenders.b(am1.a());
            tgtusabletenders.a(am1.b());
            tgtusabletenders.c(am1.c());
            tgtusabletenders.a(a(am1.d(), am1.e()));
            tgtusabletenders.b(b(am1.d()));
            tgtusabletenders.a(a(am1.e()));
            tgtusabletenders.c(c(am1.f()));
            return tgtusabletenders;
        }

        public volatile Object a(Object obj)
        {
            return a((am)obj);
        }

            
            {
                this$0 = z.this;
                super();
            }
    };

    public z(d d)
    {
        super(d);
    }

    protected UsableTenders a(am am1)
    {
        return (UsableTenders)mTransformer.a(am1);
    }

    protected Object a(x x)
    {
        return b(x);
    }

    protected volatile Object a(Object obj)
    {
        return a((am)obj);
    }

    protected n b(x x)
    {
        return (new s()).a(x);
    }
}
