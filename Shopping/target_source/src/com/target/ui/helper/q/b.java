// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.q;

import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import com.target.mothership.services.x;
import com.target.ui.helper.d.a;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.helper.q:
//            a

public class com.target.ui.helper.q.b extends com.target.ui.helper.q.a
{
    public class a
    {

        private List mGetPagesFailure;
        private List mTargetNetworkErrors;
        final com.target.ui.helper.q.b this$0;

        public List a()
        {
            return mGetPagesFailure;
        }

        public void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
        {
            mGetPagesFailure.add(a1);
        }

        public void a(x x)
        {
            mTargetNetworkErrors.add(x);
        }

        public List b()
        {
            return mTargetNetworkErrors;
        }

        public int c()
        {
            return mGetPagesFailure.size() + mTargetNetworkErrors.size();
        }

        public a()
        {
            this$0 = com.target.ui.helper.q.b.this;
            super();
            mGetPagesFailure = new ArrayList();
            mTargetNetworkErrors = new ArrayList();
        }
    }

    public static interface b
    {

        public abstract void a(com.target.mothership.model.weeklyad.interfaces.a.b b1);

        public abstract void a(a a1, List list);

        public abstract void a(List list);
    }


    public com.target.ui.helper.q.b()
    {
    }

    private void a(final StoreIdentifier storeIdentifier, StoreSlug storeslug, final WeeklyAdHomepage homePage, WeeklyAdPromotion weeklyadpromotion, final PromotionRequest promotionRequest, final com.target.ui.helper.d.a pendingResult, final b listener)
    {
        a(storeslug, weeklyadpromotion, promotionRequest, new a.c() {

            final com.target.ui.helper.q.b this$0;
            final WeeklyAdHomepage val$homePage;
            final b val$listener;
            final com.target.ui.helper.d.a val$pendingResult;
            final PromotionRequest val$promotionRequest;
            final StoreIdentifier val$storeIdentifier;

            public void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
            {
                ((a)pendingResult.b()).a(a1);
                com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, pendingResult, listener);
            }

            public void a(List list, WeeklyAdPromotion weeklyadpromotion1, StoreSlug storeslug1)
            {
                list = new WeeklyAdHomepageData(homePage, weeklyadpromotion1, promotionRequest, list, storeIdentifier, storeslug1, null);
                ((List)pendingResult.c()).add(list);
                com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, pendingResult, listener);
            }

            
            {
                this$0 = com.target.ui.helper.q.b.this;
                homePage = weeklyadhomepage;
                promotionRequest = promotionrequest;
                storeIdentifier = storeidentifier;
                pendingResult = a1;
                listener = b2;
                super();
            }
        });
    }

    private void a(final StoreIdentifier storeIdentifier, StoreSlug storeslug, final WeeklyAdPromotion promotion, final PromotionRequest promotionRequest, final com.target.ui.helper.d.a pendingResult, final b listener)
    {
        a(storeslug, promotionRequest, new a.a() {

            final com.target.ui.helper.q.b this$0;
            final b val$listener;
            final com.target.ui.helper.d.a val$pendingResult;
            final WeeklyAdPromotion val$promotion;
            final PromotionRequest val$promotionRequest;
            final StoreIdentifier val$storeIdentifier;

            public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug1)
            {
                com.target.ui.helper.q.b.this.a(storeslug1, promotion, promotionRequest, weeklyadhomepage. new a.c() {

                    final _cls3 this$1;
                    final WeeklyAdHomepage val$weeklyAdHomePage;

                    public void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
                    {
                        ((a)pendingResult.b()).a(a1);
                        com.target.ui.helper.q.b.a(_fld0, pendingResult, listener);
                    }

                    public void a(List list, WeeklyAdPromotion weeklyadpromotion, StoreSlug storeslug)
                    {
                        list = new WeeklyAdHomepageData(weeklyAdHomePage, weeklyadpromotion, promotionRequest, list, storeIdentifier, storeslug, null);
                        ((List)pendingResult.c()).add(list);
                        com.target.ui.helper.q.b.a(_fld0, pendingResult, listener);
                    }

            
            {
                this$1 = final__pcls3;
                weeklyAdHomePage = WeeklyAdHomepage.this;
                super();
            }
                });
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, pendingResult, listener);
            }

            public void a(x x)
            {
                ((a)pendingResult.b()).a(x);
                com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, pendingResult, listener);
            }

            
            {
                this$0 = com.target.ui.helper.q.b.this;
                promotion = weeklyadpromotion;
                promotionRequest = promotionrequest;
                storeIdentifier = storeidentifier;
                pendingResult = a1;
                listener = b2;
                super();
            }
        });
    }

    private void a(com.target.ui.helper.d.a a1, b b1)
    {
        if (a1.a() > 0)
        {
            return;
        }
        if (((a)a1.b()).c() > 0)
        {
            b1.a((a)a1.b(), (List)a1.c());
            return;
        } else
        {
            b1.a((List)a1.c());
            return;
        }
    }

    static void a(com.target.ui.helper.q.b b1, StoreIdentifier storeidentifier, StoreSlug storeslug, WeeklyAdHomepage weeklyadhomepage, WeeklyAdPromotion weeklyadpromotion, PromotionRequest promotionrequest, com.target.ui.helper.d.a a1, b b2)
    {
        b1.a(storeidentifier, storeslug, weeklyadhomepage, weeklyadpromotion, promotionrequest, a1, b2);
    }

    static void a(com.target.ui.helper.q.b b1, StoreIdentifier storeidentifier, StoreSlug storeslug, WeeklyAdPromotion weeklyadpromotion, PromotionRequest promotionrequest, com.target.ui.helper.d.a a1, b b2)
    {
        b1.a(storeidentifier, storeslug, weeklyadpromotion, promotionrequest, a1, b2);
    }

    static void a(com.target.ui.helper.q.b b1, com.target.ui.helper.d.a a1, b b2)
    {
        b1.a(a1, b2);
    }

    public void a(final StoreIdentifier storeIdentifier, PromotionRequest promotionrequest, final b listener)
    {
        final com.target.ui.helper.d.a pendingResult = new com.target.ui.helper.d.a(new ArrayList(), new a());
        final String previewDate;
        if (promotionrequest != null)
        {
            previewDate = (String)promotionrequest.b().d();
        } else
        {
            previewDate = null;
        }
        a(storeIdentifier, promotionrequest, new a.a() {

            final com.target.ui.helper.q.b this$0;
            final b val$listener;
            final com.target.ui.helper.d.a val$pendingResult;
            final String val$previewDate;
            final StoreIdentifier val$storeIdentifier;

            public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug)
            {
                WeeklyAdPromotion weeklyadpromotion = weeklyadhomepage.a();
                Object obj = weeklyadhomepage.b();
                pendingResult.a(((List) (obj)).size() + 1);
                PromotionRequest promotionrequest1 = new PromotionRequest(weeklyadpromotion.a());
                promotionrequest1.a(previewDate);
                com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, storeIdentifier, storeslug, weeklyadhomepage, weeklyadpromotion, promotionrequest1, pendingResult, listener);
                WeeklyAdPromotion weeklyadpromotion1;
                for (weeklyadhomepage = ((List) (obj)).iterator(); weeklyadhomepage.hasNext(); com.target.ui.helper.q.b.a(com.target.ui.helper.q.b.this, storeIdentifier, storeslug, weeklyadpromotion1, ((PromotionRequest) (obj)), pendingResult, listener))
                {
                    weeklyadpromotion1 = (WeeklyAdPromotion)weeklyadhomepage.next();
                    obj = new PromotionRequest(weeklyadpromotion1.a());
                    ((PromotionRequest) (obj)).a(previewDate);
                }

            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                listener.a(b1);
            }

            public void a(x x)
            {
                ((a)pendingResult.b()).a(x);
                listener.a((a)pendingResult.b(), (List)pendingResult.c());
            }

            
            {
                this$0 = com.target.ui.helper.q.b.this;
                pendingResult = a1;
                previewDate = s;
                storeIdentifier = storeidentifier;
                listener = b2;
                super();
            }
        });
    }
}
