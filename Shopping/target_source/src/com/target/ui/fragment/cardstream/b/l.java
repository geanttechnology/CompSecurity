// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.b;

import com.google.a.a.e;
import com.target.a.a.b;
import com.target.b.a;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import com.target.mothership.services.x;
import com.target.ui.fragment.cardstream.CardStreamOnClickHandler;
import com.target.ui.service.k;
import com.target.ui.service.provider.s;
import java.text.SimpleDateFormat;
import java.util.Locale;

// Referenced classes of package com.target.ui.fragment.cardstream.b:
//            b, a

public class l
    implements com.target.ui.fragment.cardstream.b.b
{
    static class a extends com.target.ui.fragment.cardstream.c.a
    {

        private final k mRelevantStoreService;
        private final com.target.ui.helper.q.a mWeeklyAdDataHelper;

        protected void a(final com.target.ui.fragment.cardstream.c.a.a onLoadedCallback)
        {
            Object obj = mRelevantStoreService.c();
            e e1 = com.google.a.a.e.e();
            if (!((e) (obj)).b())
            {
                onLoadedCallback.a(e1);
                return;
            } else
            {
                obj = ((RelevantStoreSummary)((e) (obj)).c()).getStoreId();
                mWeeklyAdDataHelper.a(((com.target.mothership.common.store.StoreIdentifier) (obj)), e1. new com.target.ui.helper.q.a.a() {

                    final a this$0;
                    final e val$absent;
                    final com.target.ui.fragment.cardstream.c.a.a val$onLoadedCallback;

                    public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug)
                    {
                        onLoadedCallback.a(com.google.a.a.e.c(weeklyadhomepage));
                    }

                    public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
                    {
                    }

                    public void a(x x)
                    {
                        onLoadedCallback.a(absent);
                    }

            
            {
                this$0 = final_a1;
                onLoadedCallback = a2;
                absent = e.this;
                super();
            }
                });
                return;
            }
        }

        protected boolean a(WeeklyAdHomepage weeklyadhomepage)
        {
            return true;
        }

        protected volatile boolean a(Object obj)
        {
            return a((WeeklyAdHomepage)obj);
        }

        public a(com.target.ui.fragment.cardstream.c.j.c c1, com.target.ui.fragment.cardstream.c.a.a a1, k k1, com.target.ui.helper.q.a a2)
        {
            super(c1, a1, "WeeklyAdDataSource");
            mRelevantStoreService = k1;
            mWeeklyAdDataHelper = a2;
        }
    }


    private static final String LOG_TAG = "WeeklyAdCardManager";
    private final a mDataSource;
    private final SimpleDateFormat mDateFormat;
    private final com.target.b.a mStoreSummaryProvider;
    private final s mStringProvider;

    public l(s s1, a a1, com.target.b.a a2)
    {
        mDateFormat = new SimpleDateFormat("MMM d", Locale.US);
        mStringProvider = s1;
        mDataSource = a1;
        mStoreSummaryProvider = a2;
    }

    private com.target.ui.fragment.cardstream.f.e d()
    {
        Object obj = (e)mStoreSummaryProvider.b();
        if (!((e) (obj)).b())
        {
            return null;
        } else
        {
            obj = CardStreamOnClickHandler.a((StoreSummary)((e) (obj)).c());
            return com.target.ui.fragment.cardstream.b.a.sHideActionsList.a(com.target.ui.fragment.cardstream.b.a.a(0x7f020056, 0x7f0900eb)).b(0x7f100006).a(((com.target.ui.fragment.cardstream.f.b.e) (obj))).a();
        }
    }

    private com.target.ui.fragment.cardstream.f.e e()
    {
        Object obj = mDataSource.f();
        if (!((e) (obj)).b())
        {
            return null;
        } else
        {
            obj = (WeeklyAdHomepage)((e) (obj)).c();
            Object obj1 = ((WeeklyAdHomepage) (obj)).a();
            String s1 = mDateFormat.format(((WeeklyAdPromotion) (obj1)).b());
            obj1 = mDateFormat.format(((WeeklyAdPromotion) (obj1)).c());
            s1 = mStringProvider.a(0x7f0900f0, new Object[] {
                s1, obj1
            });
            return com.target.ui.fragment.cardstream.f.e.a(0x7f100011).a(s1).e(0x7f10000e).a(((WeeklyAdHomepage) (obj)).c()).a();
        }
    }

    public boolean a()
    {
        return mDataSource.g() && ((e)mStoreSummaryProvider.b()).b();
    }

    public e b()
    {
        e e1 = mDataSource.f();
        com.target.ui.fragment.cardstream.f.e e2 = d();
        com.target.ui.fragment.cardstream.f.e e3 = e();
        if (!e1.b() || e3 == null || e2 == null)
        {
            com.target.a.a.b.d("WeeklyAdCardManager", "Could not build card data");
            return com.google.a.a.e.e();
        } else
        {
            return com.google.a.a.e.b(new com.target.ui.fragment.cardstream.b(0x7f03002b, e2, e3, c()));
        }
    }

    public com.target.ui.fragment.cardstream.e c()
    {
        return com.target.ui.fragment.cardstream.e.WEEKLY_AD;
    }
}
