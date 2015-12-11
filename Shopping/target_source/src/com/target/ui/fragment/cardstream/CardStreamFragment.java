// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.a.a.e;
import com.google.a.b.h;
import com.google.a.b.k;
import com.target.a.a.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.e.f;
import com.target.ui.f.c;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.cardstream.d.a;
import com.target.ui.fragment.cardstream.f.d;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.fragment.list.ListDetailFragment;
import com.target.ui.fragment.map.StoreMapFragment;
import com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.service.m;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream:
//            CardStreamOnClickHandler, d, CardStreamAdapter, c, 
//            j, SingleShoppingListData, e

public class CardStreamFragment extends BaseNavigationFragment
    implements android.support.v4.widget.SwipeRefreshLayout.a, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, com.target.ui.fragment.account.BaseAccountDialog.c, com.target.ui.fragment.cardstream.d.a, com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a
{
    static class Views extends com.target.ui.view.a
    {

        TextView emptyMsg;
        RecyclerView recyclerView;
        SwipeRefreshLayout swipeRefreshLayout;

        protected Views(View view)
        {
            super(view);
        }
    }

    private class a extends android.support.v7.widget.RecyclerView.k
    {

        final CardStreamFragment this$0;

        public void a(RecyclerView recyclerview, int i)
        {
            super.a(recyclerview, i);
            switch (i)
            {
            default:
                if (com.target.ui.fragment.cardstream.CardStreamFragment.a(CardStreamFragment.this) != null)
                {
                    com.target.ui.fragment.cardstream.CardStreamFragment.a(CardStreamFragment.this).f();
                }
                break;

            case 2: // '\002'
                break;
            }
        }

        public void a(RecyclerView recyclerview, int i, int i1)
        {
            super.a(recyclerview, i, i1);
            if (com.target.ui.fragment.cardstream.CardStreamFragment.a(CardStreamFragment.this) == null)
            {
                return;
            } else
            {
                com.target.ui.fragment.cardstream.CardStreamFragment.a(CardStreamFragment.this).b(i1);
                return;
            }
        }

        private a()
        {
            this$0 = CardStreamFragment.this;
            super();
        }

    }


    private static final int CARD_ANIMATOR_DURATION = 250;
    private static final String LOG_TAG = "CardStreamFragment";
    private static final int TAB_BAR_MAX_HEIGHT_DIPS = 64;
    private CardStreamAdapter mAdapter;
    private com.target.ui.fragment.cardstream.e.a mPresenter;
    private f mScrollingTabCoordinator;
    private Views mViews;

    public CardStreamFragment()
    {
    }

    static f a(CardStreamFragment cardstreamfragment)
    {
        return cardstreamfragment.mScrollingTabCoordinator;
    }

    private CardStreamOnClickHandler a(final com.target.ui.fragment.cardstream.c cardDataSource, final com.target.ui.fragment.cardstream.b.c.a dependencies)
    {
        return new CardStreamOnClickHandler(new CardStreamOnClickHandler.a() {

            final CardStreamFragment this$0;
            final com.target.ui.fragment.cardstream.c val$cardDataSource;
            final com.target.ui.fragment.cardstream.b.c.a val$dependencies;

            public void a()
            {
                ListDetailFragment listdetailfragment = ListDetailFragment.a((ListCollectionItem)dependencies.singleListService.b().d());
                CardStreamFragment.this.m().d(listdetailfragment);
            }

            public void a(Uri uri, String s)
            {
                CardStreamFragment.this.m().d(TargetWebFragment.a(true, uri.toString(), s));
            }

            public void a(Store store, SingleShoppingListData singleshoppinglistdata)
            {
                if (singleshoppinglistdata == null || singleshoppinglistdata.listItems.isEmpty())
                {
                    store = StoreMapFragment.a(store);
                } else
                {
                    ListDetailItem listdetailitem = (ListDetailItem)singleshoppinglistdata.listItems.get(0);
                    store = StoreMapFragment.a(singleshoppinglistdata.listSummary, singleshoppinglistdata.listItems, store, listdetailitem, null);
                }
                CardStreamFragment.this.m().d(store);
            }

            public void a(StoreSummary storesummary)
            {
                CardStreamFragment.this.m().d(WeeklyAdFragment.b(storesummary));
            }

            public void a(com.target.ui.fragment.cardstream.e e1)
            {
                dependencies.simpleStorage.a(e1);
                cardDataSource.a();
            }

            public void a(String s)
            {
                ai.a(getActivity(), s);
            }

            public void b()
            {
                e e1 = com.target.ui.service.k.a().c();
                if (!e1.b())
                {
                    ai.a(getActivity(), "Can't request team member: No relevant store.");
                    return;
                } else
                {
                    RequestTeamMemberDialogFragment.a(CardStreamFragment.this, (Store)e1.c(), -1, -1).show(getFragmentManager(), BaseNavigationFragment.TAG);
                    return;
                }
            }

            
            {
                this$0 = CardStreamFragment.this;
                dependencies = a1;
                cardDataSource = c1;
                super();
            }
        });
    }

    private void a(f f1)
    {
        mScrollingTabCoordinator = f1;
        if (mScrollingTabCoordinator != null)
        {
            mViews.recyclerView.setClipToPadding(false);
            mViews.recyclerView.setPadding(mViews.recyclerView.getPaddingLeft(), mViews.recyclerView.getPaddingTop() + mScrollingTabCoordinator.e(), mViews.recyclerView.getPaddingRight(), mViews.recyclerView.getPaddingBottom());
            mViews.swipeRefreshLayout.setColorSchemeColors(new int[] {
                getResources().getColor(0x7f0f00eb)
            });
            f1 = getResources().getDisplayMetrics();
            int i = mScrollingTabCoordinator.e();
            int i1 = (int)(((DisplayMetrics) (f1)).density * 24F);
            mViews.swipeRefreshLayout.a(false, 0, i1 + i);
        }
    }

    public static CardStreamFragment b()
    {
        return new CardStreamFragment();
    }

    private d b(com.target.ui.fragment.cardstream.d d1)
    {
        return new d(a(d1.b(), d1.()));
    }

    public void a()
    {
        mPresenter.f();
    }

    public void a(h h)
    {
        if (mAdapter.a(h))
        {
            mScrollingTabCoordinator.h();
        }
    }

    public void a(Guest guest)
    {
    }

    public void a(com.target.ui.fragment.cardstream.d d1)
    {
        mViews.recyclerView.setHasFixedSize(true);
        mViews.recyclerView.setOnScrollListener(new a());
        mViews.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Object obj = d1.b();
        java.util.ArrayList arraylist = k.a();
        if (((com.target.ui.fragment.cardstream.c) (obj)).g())
        {
            obj = ((com.target.ui.fragment.cardstream.c) (obj)).f();
            if (((e) (obj)).b())
            {
                arraylist.addAll((Collection)((e) (obj)).c());
            }
        }
        mAdapter = new CardStreamAdapter(b(d1), arraylist);
        mViews.recyclerView.setAdapter(mAdapter);
        d1 = getParentFragment();
        if (d1 instanceof f)
        {
            a((f)d1);
        }
        mViews.swipeRefreshLayout.setOnRefreshListener(this);
        d1 = new j(mViews.recyclerView);
        d1.b(250L);
        d1.c(250L);
        mViews.recyclerView.setItemAnimator(d1);
    }

    public void a(String s)
    {
    }

    public void a(boolean flag)
    {
        com.target.a.a.b.d("CardStreamFragment", (new StringBuilder()).append("showLoadingIndicator(): ").append(flag).toString());
        mViews.swipeRefreshLayout.setRefreshing(flag);
    }

    public void b(Guest guest)
    {
        AuthenticateDialog.a(guest, this).show(getFragmentManager(), AuthenticateDialog.TAG);
    }

    public void b(Object obj)
    {
    }

    public void b(String s)
    {
    }

    public void c()
    {
    }

    public void c(boolean flag)
    {
        al.a(mViews.emptyMsg, flag);
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a e()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return e();
    }

    public void n_()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = com.target.ui.fragment.cardstream.e.a.a(new com.target.a.a.a(getActivity()));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030048, viewgroup, false);
        mViews = new Views(layoutinflater);
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mPresenter.z_();
        mViews = null;
    }

    public void onStart()
    {
        super.onStart();
        mPresenter.d();
    }

    public void onStop()
    {
        super.onStop();
        mPresenter.e();
    }
}
