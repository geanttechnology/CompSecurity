// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.weeklyad.handler;

import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.n.b.a.g;
import com.target.mothership.services.apigee.n.b.a.j;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.target.mothership.model.weeklyad.handler:
//            TGTWeeklyAdPromotion, TGTWeeklyAdHomepage

public class a extends f
{

    public static final String DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ssZ";
    private aa mTransformer;

    public a(h h)
    {
        super(h);
        mTransformer = new aa() {

            final a this$0;

            private TGTWeeklyAdPromotion a(g g1)
            {
                TGTWeeklyAdPromotion tgtweeklyadpromotion = new TGTWeeklyAdPromotion();
                tgtweeklyadpromotion.a(new PromotionSlug(g1.a()));
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
                simpledateformat.setTimeZone(TimeZone.getDefault());
                tgtweeklyadpromotion.a(simpledateformat.parse(g1.b().a(), new ParsePosition(0)));
                tgtweeklyadpromotion.b(simpledateformat.parse(g1.b().b(), new ParsePosition(0)));
                return tgtweeklyadpromotion;
            }

            public WeeklyAdHomepage a(com.target.mothership.services.apigee.n.b.a a1)
            {
                TGTWeeklyAdHomepage tgtweeklyadhomepage = new TGTWeeklyAdHomepage();
                tgtweeklyadhomepage.a(a1.a());
                String s;
                ArrayList arraylist;
                if (a1.b() != null)
                {
                    tgtweeklyadhomepage.a(a(a1.b()));
                    s = a1.b().a();
                } else
                {
                    s = null;
                }
                arraylist = new ArrayList();
                if (a1.c() != null)
                {
                    for (a1 = a1.c().iterator(); a1.hasNext();)
                    {
                        Object obj = (j)a1.next();
                        if (((j) (obj)).a() != null)
                        {
                            obj = ((j) (obj)).a().iterator();
                            while (((Iterator) (obj)).hasNext()) 
                            {
                                g g1 = (g)((Iterator) (obj)).next();
                                if (!g1.a().equals(s))
                                {
                                    arraylist.add(a(g1));
                                }
                            }
                        }
                    }

                }
                tgtweeklyadhomepage.a(arraylist);
                return tgtweeklyadhomepage;
            }

            public volatile Object a(Object obj)
            {
                return a((com.target.mothership.services.apigee.n.b.a)obj);
            }

            
            {
                this$0 = a.this;
                super();
            }
        };
    }

    public WeeklyAdHomepage a(com.target.mothership.services.apigee.n.b.a a1)
    {
        return (WeeklyAdHomepage)mTransformer.a(a1);
    }

    public volatile Object a(Object obj)
    {
        return a((com.target.mothership.services.apigee.n.b.a)obj);
    }
}
