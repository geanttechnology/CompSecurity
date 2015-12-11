// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.promotion.handler;

import com.target.mothership.model.f;
import com.target.mothership.model.h;
import com.target.mothership.model.promotion.interfaces.PromotionStatus;
import com.target.mothership.services.aa;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.target.mothership.model.promotion.handler:
//            TGTPromotionStatus

public class b extends f
{

    private aa mTransformer;

    public b(h h)
    {
        super(h);
        mTransformer = new aa() {

            final b this$0;

            public PromotionStatus a(List list)
            {
                TGTPromotionStatus tgtpromotionstatus = new TGTPromotionStatus();
                list = list.iterator();
                do
                {
                    if (!list.hasNext())
                    {
                        break;
                    }
                    com.target.mothership.services.e.f.b.b b1 = (com.target.mothership.services.e.f.b.b)list.next();
                    if (b1.c())
                    {
                        if (b1.a() != null)
                        {
                            tgtpromotionstatus.a().add(b1.a());
                        } else
                        if (b1.b() != null)
                        {
                            tgtpromotionstatus.b().add(b1.b());
                        }
                    }
                } while (true);
                return tgtpromotionstatus;
            }

            public volatile Object a(Object obj)
            {
                return a((List)obj);
            }

            
            {
                this$0 = b.this;
                super();
            }
        };
    }

    public PromotionStatus a(List list)
    {
        return (PromotionStatus)mTransformer.a(list);
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }
}
