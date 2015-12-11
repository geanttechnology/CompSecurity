// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.promotions;

import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.h;
import com.target.mothership.model.promotion.c;
import com.target.mothership.model.promotion.interfaces.PromotionStatus;
import com.target.mothership.services.x;
import com.target.mothership.util.o;
import java.util.List;

// Referenced classes of package com.target.ui.helper.promotions:
//            PromotionDetailRequestParams, PromotionStatusRequestParams

public class com.target.ui.helper.promotions.a
{
    public static interface a
    {

        public abstract void a(x x1, PromotionDetailRequestParams promotiondetailrequestparams);

        public abstract void a(List list, PromotionDetailRequestParams promotiondetailrequestparams);
    }

    private static class b extends h
    {

        private a mListener;
        private PromotionDetailRequestParams mPromotionDetailRequestParams;
        private String mRequestTag;

        public String a()
        {
            return mRequestTag;
        }

        public void a(x x1)
        {
            mListener.a(x1, mPromotionDetailRequestParams);
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            mListener.a(list, mPromotionDetailRequestParams);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public b(PromotionDetailRequestParams promotiondetailrequestparams, String s, a a1)
        {
            mPromotionDetailRequestParams = promotiondetailrequestparams;
            mRequestTag = s;
            mListener = a1;
        }
    }

    public static interface c
    {

        public abstract void a(PromotionStatus promotionstatus, PromotionStatusRequestParams promotionstatusrequestparams);

        public abstract void a(x x1, PromotionStatusRequestParams promotionstatusrequestparams);
    }


    public static final String TAG = com/target/ui/helper/promotions/a.getSimpleName();
    private com.target.mothership.model.promotion.c mPromotionManager;
    private final String mRequestTag;

    public com.target.ui.helper.promotions.a()
    {
        this(new com.target.mothership.model.promotion.c());
    }

    public com.target.ui.helper.promotions.a(com.target.mothership.model.promotion.c c1)
    {
        mPromotionManager = c1;
        mRequestTag = String.valueOf(hashCode());
    }

    static String a(com.target.ui.helper.promotions.a a1)
    {
        return a1.mRequestTag;
    }

    public void a(PromotionDetailRequestParams promotiondetailrequestparams, a a1)
    {
        com.target.mothership.common.store.StoreIdentifier storeidentifier = promotiondetailrequestparams.a();
        String s = (String)promotiondetailrequestparams.b().d();
        Tcin tcin = (Tcin)promotiondetailrequestparams.c().d();
        b b1 = new b(promotiondetailrequestparams, mRequestTag, a1);
        if (!o.e(s))
        {
            mPromotionManager.a(storeidentifier, s, b1);
            return;
        }
        if (tcin != null)
        {
            mPromotionManager.a(storeidentifier, tcin, b1);
            return;
        } else
        {
            a1.a(x.a("PromotionDetailRequestParam missing product information").a(), promotiondetailrequestparams);
            return;
        }
    }

    public void a(final PromotionStatusRequestParams promotionStatusRequestParams, final c listener)
    {
        mPromotionManager.a(promotionStatusRequestParams.a(), promotionStatusRequestParams.b(), promotionStatusRequestParams.c(), new h() {

            final com.target.ui.helper.promotions.a this$0;
            final c val$listener;
            final PromotionStatusRequestParams val$promotionStatusRequestParams;

            public String a()
            {
                return com.target.ui.helper.promotions.a.a(com.target.ui.helper.promotions.a.this);
            }

            public void a(PromotionStatus promotionstatus)
            {
                listener.a(promotionstatus, promotionStatusRequestParams);
            }

            public void a(x x1)
            {
                listener.a(x1, promotionStatusRequestParams);
            }

            public volatile void a(Object obj)
            {
                a((PromotionStatus)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = com.target.ui.helper.promotions.a.this;
                listener = c1;
                promotionStatusRequestParams = promotionstatusrequestparams;
                super();
            }
        });
    }

}
