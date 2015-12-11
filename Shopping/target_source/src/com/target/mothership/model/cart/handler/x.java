// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.model.b;
import com.target.mothership.model.cart.a.p;
import com.target.mothership.model.cart.interfaces.CartProductShippingModeDetails;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.a.k;
import com.target.mothership.model.d;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.q;
import com.target.mothership.util.c;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            TGTUsableShipMode, n, TGTCartProductShippingModeDetails, TGTUsableShippingModeDetails

public class x extends b
{

    private static final int AMOUNT_START_INDEX = 1;
    private static final String CLOSE_PARENTHESIS = ")";
    private static final String DATE_FORMAT = "EEE MM/dd";
    private static final String DOLLAR = "$";
    private static final String HYPHEN = "-";
    private static final String OPEN_PARENTHESIS = "(";
    private final aa mTransformer = new aa() {

        final x this$0;

        private UsableShipMode a(com.target.mothership.services.apigee.c.b.o.a a1, com.target.mothership.model.common.b b1)
        {
            Object obj1 = null;
            TGTUsableShipMode tgtusableshipmode = new TGTUsableShipMode();
            tgtusableshipmode.a(Integer.parseInt(a1.b()));
            tgtusableshipmode.a(b(a1.c()));
            Object obj;
            String s;
            if (a1.d() != null)
            {
                obj = Currency.getInstance(a1.d());
            } else
            {
                obj = c.USD;
            }
            tgtusableshipmode.a(((Currency) (obj)));
            s = a1.a();
            if (o.g(s) && s.contains("(") && s.endsWith(")"))
            {
                int i = s.indexOf("(");
                obj = s.substring(0, i);
                a1 = s.substring(i);
            } else
            {
                a1 = "";
                obj = s;
            }
            tgtusableshipmode.a(b1.a(((String) (obj))));
            if (o.g(a1) && a1.startsWith("(") && a1.endsWith(")"))
            {
                if (a1.contains("-"))
                {
                    int j = a1.indexOf("-");
                    obj = a(a1.substring(1, j));
                    b1 = a(a1.substring(j + 1, a1.length() - 1));
                    a1 = ((com.target.mothership.services.apigee.c.b.o.a) (obj));
                } else
                {
                    b1 = a(a1.substring(1, a1.length() - 1));
                    a1 = null;
                }
            } else
            {
                a1 = null;
                b1 = obj1;
            }
            tgtusableshipmode.a(b1);
            tgtusableshipmode.b(a1);
            return tgtusableshipmode;
        }

        private Date a(String s)
        {
            SimpleDateFormat simpledateformat = new SimpleDateFormat("EEE MM/dd", Locale.US);
            try
            {
                s = simpledateformat.parse(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            return s;
        }

        private BigDecimal b(String s)
        {
            if (o.g(s) && s.startsWith("$"))
            {
                s = s.substring(1);
                if (o.g(s))
                {
                    return new BigDecimal(s);
                } else
                {
                    return c.ZERO;
                }
            } else
            {
                return c.ZERO;
            }
        }

        public CartProductShippingModeDetails a(q q1)
        {
            if (q1 == null || q1.a() == null || q1.a().isEmpty())
            {
                return null;
            }
            n n1 = new n();
            com.target.mothership.model.common.b b1 = new com.target.mothership.model.common.b();
            TGTCartProductShippingModeDetails tgtcartproductshippingmodedetails = new TGTCartProductShippingModeDetails();
            Object obj = (com.target.mothership.services.apigee.c.b.q.a)q1.a().get(0);
            tgtcartproductshippingmodedetails.a(((com.target.mothership.services.apigee.c.b.q.a) (obj)).a());
            tgtcartproductshippingmodedetails.a(b1.a(((com.target.mothership.services.apigee.c.b.q.a) (obj)).c()));
            tgtcartproductshippingmodedetails.a(n1.a(((com.target.mothership.services.apigee.c.b.q.a) (obj)).b()));
            q1 = new ArrayList();
            TGTUsableShippingModeDetails tgtusableshippingmodedetails;
            for (obj = ((com.target.mothership.services.apigee.c.b.q.a) (obj)).d().iterator(); ((Iterator) (obj)).hasNext(); q1.add(tgtusableshippingmodedetails))
            {
                Object obj1 = (com.target.mothership.services.apigee.c.b.o)((Iterator) (obj)).next();
                tgtusableshippingmodedetails = new TGTUsableShippingModeDetails();
                tgtusableshippingmodedetails.a(n1.a(((com.target.mothership.services.apigee.c.b.o) (obj1)).a()));
                ArrayList arraylist = new ArrayList();
                obj1 = ((com.target.mothership.services.apigee.c.b.o) (obj1)).b().iterator();
                do
                {
                    if (!((Iterator) (obj1)).hasNext())
                    {
                        break;
                    }
                    UsableShipMode usableshipmode = a((com.target.mothership.services.apigee.c.b.o.a)((Iterator) (obj1)).next(), b1);
                    if (usableshipmode.a() != com.target.mothership.common.a.b.Rush)
                    {
                        arraylist.add(usableshipmode);
                    }
                } while (true);
                tgtusableshippingmodedetails.a(arraylist);
            }

            tgtcartproductshippingmodedetails.a(q1);
            return tgtcartproductshippingmodedetails;
        }

        public volatile Object a(Object obj)
        {
            return a((q)obj);
        }

            
            {
                this$0 = x.this;
                super();
            }
    };

    public x(d d)
    {
        super(d);
    }

    protected CartProductShippingModeDetails a(q q1)
    {
        return (CartProductShippingModeDetails)mTransformer.a(q1);
    }

    protected Object a(com.target.mothership.services.x x1)
    {
        return b(x1);
    }

    protected volatile Object a(Object obj)
    {
        return a((q)obj);
    }

    protected k b(com.target.mothership.services.x x1)
    {
        return (new p()).a(x1);
    }
}
