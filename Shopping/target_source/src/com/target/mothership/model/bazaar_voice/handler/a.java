// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice.handler;

import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReviewWrapper;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.services.a.a.b.a.b;
import com.target.mothership.services.a.a.b.a.c;
import com.target.mothership.services.a.a.b.a.d;
import com.target.mothership.services.a.a.b.a.e;
import com.target.mothership.services.a.a.b.a.g;
import com.target.mothership.services.aa;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.mothership.model.bazaar_voice.handler:
//            TGTProductReview, TGTProductSecondaryReview, TGTProductReviewWrapper

public class a extends f
{

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss";
    private final aa mTransformer = new aa() {

        final a this$0;

        public ProductReviewWrapper a(com.target.mothership.services.a.a.b.a a1)
        {
            TGTProductReviewWrapper tgtproductreviewwrapper = new TGTProductReviewWrapper();
            tgtproductreviewwrapper.b(a.a(a.this, a1));
            tgtproductreviewwrapper.a(com.target.mothership.model.bazaar_voice.handler.a.b(a.this, a1));
            tgtproductreviewwrapper.a(a1.());
            int j = a1.();
            int k = a1.a();
            int i = 0;
            if (j > 0)
            {
                i = k / j;
            }
            tgtproductreviewwrapper.b(i);
            tgtproductreviewwrapper.c(a1.());
            return tgtproductreviewwrapper;
        }

        public volatile Object a(Object obj)
        {
            return a((com.target.mothership.services.a.a.b.a)obj);
        }

            
            {
                this$0 = a.this;
                super();
            }
    };

    public a(h h)
    {
        super(h);
    }

    private Date a(String s)
    {
        return (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)).parse(s, new ParsePosition(0));
    }

    static List a(a a1, com.target.mothership.services.a.a.b.a a2)
    {
        return a1.c(a2);
    }

    static List b(a a1, com.target.mothership.services.a.a.b.a a2)
    {
        return a1.b(a2);
    }

    private List b(com.target.mothership.services.a.a.b.a a1)
    {
        ArrayList arraylist = new ArrayList();
        TGTProductReview tgtproductreview;
        for (a1 = a1.().iterator(); a1.hasNext(); arraylist.add(tgtproductreview))
        {
            d d1 = (d)a1.next();
            tgtproductreview = new TGTProductReview();
            tgtproductreview.e(d1.l());
            tgtproductreview.f(d1.e());
            tgtproductreview.a(new Tcin(d1.g()));
            tgtproductreview.g(d1.b());
            tgtproductreview.a(d1.f());
            tgtproductreview.b(d1.k());
            tgtproductreview.c(d1.a());
            tgtproductreview.d(d1.d());
            tgtproductreview.a(d1.i());
            tgtproductreview.b(d1.j());
            tgtproductreview.a(a(d1.m()));
            tgtproductreview.c(a(d1.c()));
            tgtproductreview.b(a(d1.h()));
        }

        return arraylist;
    }

    private List c(com.target.mothership.services.a.a.b.a a1)
    {
        boolean flag1 = true;
        boolean flag;
        if (a1.() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && a1.().a() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && a1.().a().a() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && a1.().a().a().a() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            return Collections.emptyList();
        }
        Object obj = a1.().a().a().a().a();
        if (flag && obj != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a1 = new ArrayList();
        if (flag)
        {
            TGTProductSecondaryReview tgtproductsecondaryreview;
            for (obj = ((com.target.mothership.services.a.a.b.a.f) (obj)).a().iterator(); ((Iterator) (obj)).hasNext(); a1.add(tgtproductsecondaryreview))
            {
                e e1 = (e)((Iterator) (obj)).next();
                tgtproductsecondaryreview = new TGTProductSecondaryReview();
                tgtproductsecondaryreview.b(e1.a());
                tgtproductsecondaryreview.a(e1.b());
            }

        }
        return a1;
    }

    protected ProductReviewWrapper a(com.target.mothership.services.a.a.b.a a1)
    {
        return (ProductReviewWrapper)mTransformer.a(a1);
    }

    protected volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.a.a.b.a)obj);
    }
}
