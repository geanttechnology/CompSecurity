// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion.handler;

import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.e.b.a.b;
import com.target.mothership.services.e.e.b.a.i;
import com.target.mothership.services.e.e.b.a.p;
import com.target.mothership.services.e.e.b.a.s;
import com.target.mothership.services.e.e.b.a.v;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.promotion.handler:
//            TGTPromotionDetail

public class a extends f
{

    private static final String PERCENT_OFF = "% off";
    private aa mTransformer;

    public a(h h)
    {
        super(h);
        mTransformer = new aa() {

            final a this$0;

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.e.f.b.a)obj);
            }

            public List a(com.target.mothership.services.e.f.b.a a1)
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = a1.a().iterator();
                while (iterator.hasNext()) 
                {
                    Object obj = (s)iterator.next();
                    TGTPromotionDetail tgtpromotiondetail = new TGTPromotionDetail();
                    tgtpromotiondetail.a(((s) (obj)).i());
                    if (((s) (obj)).D() != null && ((s) (obj)).D().a() != null)
                    {
                        tgtpromotiondetail.c(((s) (obj)).D().a().toString());
                    }
                    obj = ((s) (obj)).K().h();
                    int j;
                    if (((p) (obj)).f() != 0)
                    {
                        j = ((p) (obj)).f();
                    } else
                    {
                        j = (int)Math.round((100D * ((p) (obj)).a().subtract(((p) (obj)).c()).doubleValue()) / ((p) (obj)).a().doubleValue());
                    }
                    tgtpromotiondetail.d((new StringBuilder()).append(j).append("% off").toString());
                    arraylist.add(tgtpromotiondetail);
                }
                TGTPromotionDetail tgtpromotiondetail1;
                for (a1 = a1.b().iterator(); a1.hasNext(); arraylist.add(tgtpromotiondetail1))
                {
                    b b1 = (b)a1.next();
                    tgtpromotiondetail1 = new TGTPromotionDetail();
                    tgtpromotiondetail1.a(b1.d());
                    tgtpromotiondetail1.b(b1.e());
                    tgtpromotiondetail1.c(b1.f());
                    tgtpromotiondetail1.e(b1.c());
                    tgtpromotiondetail1.d(b1.g());
                }

                return arraylist;
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.e.f.b.a)obj);
    }

    protected List a(com.target.mothership.services.e.f.b.a a1)
    {
        return (List)mTransformer.a(a1);
    }
}
