// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.common;

import android.os.Bundle;
import com.google.a.a.e;
import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.common.product.EndecaId;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.dialog.SearchHistoryClearDialog;
import com.target.ui.fragment.product.plp.ProductSummaryPageFragment;
import com.target.ui.fragment.product.search.SearchRecentHistoryFragment;
import com.target.ui.helper.o.c;
import com.target.ui.service.k;
import com.target.ui.util.e.a;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseProductSearchFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.product.dialog.SearchHistoryClearDialog.b
{
    private class a
        implements com.target.ui.fragment.product.search.a.a
    {

        final BaseProductSearchFragment this$0;

        public void a()
        {
            if (getView() == null)
            {
                return;
            } else
            {
                BaseProductSearchFragment.this.b();
                return;
            }
        }

        public void a(String s)
        {
            if (getView() == null)
            {
                return;
            } else
            {
                BaseProductSearchFragment.this.a(s);
                return;
            }
        }

        public void b(String s)
        {
        }

        public void c(String s)
        {
        }

        private a()
        {
            this$0 = BaseProductSearchFragment.this;
            super();
        }

    }


    private static final int MAX_RECENT_HISTORY = 2;
    public static final String TAG = com/target/ui/fragment/product/common/BaseProductSearchFragment.getSimpleName();
    private com.target.ui.fragment.product.search.a.b mSearchBroadcastReceiverInstanceWrapper;
    private c mSearchDataHelper;

    public BaseProductSearchFragment()
    {
    }

    private Store i()
    {
        if (k.a().c().b())
        {
            return (Store)k.a().c().c();
        } else
        {
            return null;
        }
    }

    public abstract void a();

    protected void a(com.target.ui.model.search.a a1)
    {
        if (a1 == null)
        {
            return;
        }
        com.target.ui.util.e.a.a(this);
        Object obj = a1.a();
        if (a1.f().b())
        {
            a1 = (EndecaId)a1.f().c();
        } else
        {
            a1 = null;
        }
        mSearchDataHelper.a(((String) (obj)));
        obj = new ProductSummaryParam(i(), null, null, ((String) (obj)));
        if (a1 != null)
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(a1);
            ((ProductSummaryParam) (obj)).a(arraylist);
        }
        m().d(ProductSummaryPageFragment.a(((ProductSummaryParam) (obj)), com.target.ui.util.g.a.a(false)));
    }

    public abstract void a(String s);

    public abstract void a(List list);

    public abstract void b();

    protected void b(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            com.target.ui.util.e.a.a(this);
            mSearchDataHelper.a(s);
            s = new ProductSummaryParam(i(), null, null, s);
            m().d(ProductSummaryPageFragment.a(s, com.target.ui.util.g.a.a(false)));
            return;
        }
    }

    public void c()
    {
    }

    protected void d()
    {
        mSearchDataHelper.a(2, new com.target.ui.helper.o.c.b() {

            final BaseProductSearchFragment this$0;

            public void a()
            {
                BaseProductSearchFragment.this.a();
            }

            public void a(List list)
            {
                if (list.isEmpty())
                {
                    BaseProductSearchFragment.this.a();
                    return;
                } else
                {
                    BaseProductSearchFragment.this.a(list);
                    return;
                }
            }

            
            {
                this$0 = BaseProductSearchFragment.this;
                super();
            }
        });
    }

    protected void e()
    {
        mSearchDataHelper.a(-1, new com.target.ui.helper.o.c.b() {

            final BaseProductSearchFragment this$0;

            public void a()
            {
                BaseProductSearchFragment.this.a();
            }

            public void a(List list)
            {
                if (list.isEmpty())
                {
                    BaseProductSearchFragment.this.a();
                    return;
                } else
                {
                    BaseProductSearchFragment.this.a(list);
                    return;
                }
            }

            
            {
                this$0 = BaseProductSearchFragment.this;
                super();
            }
        });
    }

    protected final void f()
    {
        if (Z())
        {
            return;
        } else
        {
            SearchHistoryClearDialog.a(this).show(getFragmentManager(), SearchHistoryClearDialog.TAG);
            return;
        }
    }

    protected void g()
    {
        com.target.ui.util.e.a.a(this);
        m().d(SearchRecentHistoryFragment.i());
    }

    protected String h()
    {
        String s = null;
        if (k.a().c().b())
        {
            s = ((RelevantStoreSummary)k.a().c().c()).getName();
        }
        return s;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(false);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSearchDataHelper = new c();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSearchDataHelper = null;
    }

    public void onStart()
    {
        super.onStart();
        mSearchBroadcastReceiverInstanceWrapper = com.target.ui.fragment.product.search.a.a(getActivity(), new a());
    }

    public void onStop()
    {
        super.onStop();
        com.target.ui.fragment.product.search.a.a(getActivity(), mSearchBroadcastReceiverInstanceWrapper);
    }

}
