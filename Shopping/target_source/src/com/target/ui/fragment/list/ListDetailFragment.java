// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.promotion.interfaces.PromotionDetail;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.af;
import com.target.ui.analytics.a.bb;
import com.target.ui.analytics.b.g;
import com.target.ui.f.c;
import com.target.ui.f.d;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.list.a.a;
import com.target.ui.fragment.list.presenter.ListDetailPresenter;
import com.target.ui.fragment.map.StoreMapFragment;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.scan.ScanUpcFragment;
import com.target.ui.googlenow.GoogleNowSendCardHelper;
import com.target.ui.helper.j.b;
import com.target.ui.model.list.ListCollectionItem;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.service.k;
import com.target.ui.service.m;
import com.target.ui.util.ad;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.n;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.h;
import com.target.ui.view.list.ListDetailView;
import com.target.ui.view.list.PromotionsCarouselView;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.list:
//            ListClearDialogFragment

public class ListDetailFragment extends BaseNavigationFragment
    implements ListClearDialogFragment.a, com.target.ui.fragment.list.a.a, com.target.ui.fragment.map.StoreMapFragment.a, com.target.ui.fragment.scan.ScanUpcFragment.a, com.target.ui.service.k.c, com.target.ui.view.list.ListDetailView.b, com.target.ui.view.list.PromotionsCarouselView.b
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        ListDetailView listDetailView;
        PromotionsCarouselView promotionsCarouselView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a extends AnimatorListenerAdapter
    {

        final ListDetailFragment this$0;

        public void onAnimationEnd(Animator animator)
        {
            if (com.target.ui.fragment.list.ListDetailFragment.b(ListDetailFragment.this) != null)
            {
                com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this, false);
                if (com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this) != null && !com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this).d())
                {
                    com.target.ui.fragment.list.ListDetailFragment.b(ListDetailFragment.this).listDetailView.setPromotionsOpen(false);
                    com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this).a(false);
                    return;
                }
            }
        }

        public void onAnimationStart(Animator animator)
        {
            com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this, true);
        }

        private a()
        {
            this$0 = ListDetailFragment.this;
            super();
        }

    }


    private static final String ARG_SAVED_STATE_PRESENTER = "ARG_SAVED_STATE_LIST_DETAIL_PRESENTER";
    public static final String LIST_COLLECTION_ITEM_KEY_ID = "LIST_COLLECTION_ITEM_KEY_ID";
    private static final int SLIDE_DURATION_MS = 500;
    public static final String TAG = com/target/ui/fragment/list/ListDetailFragment.getSimpleName();
    private boolean mIsAnimating;
    private ListDetailPresenter mPresenter;
    private k mRelevantStoreService;
    private h mSnackBar;
    private Views mViews;

    public ListDetailFragment()
    {
    }

    public static ListDetailFragment a()
    {
        return a(((ListCollectionItem) (null)));
    }

    public static ListDetailFragment a(ListCollectionItem listcollectionitem)
    {
        ListDetailFragment listdetailfragment = new ListDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("LIST_COLLECTION_ITEM_KEY_ID", listcollectionitem);
        listdetailfragment.setArguments(bundle);
        return listdetailfragment;
    }

    static ListDetailPresenter a(ListDetailFragment listdetailfragment)
    {
        return listdetailfragment.mPresenter;
    }

    static boolean a(ListDetailFragment listdetailfragment, boolean flag)
    {
        listdetailfragment.mIsAnimating = flag;
        return flag;
    }

    static Views b(ListDetailFragment listdetailfragment)
    {
        return listdetailfragment.mViews;
    }

    private void d(int i1)
    {
        mViews.promotionsCarouselView.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, i1));
        mViews.promotionsCarouselView.setTop(-i1);
        mViews.promotionsCarouselView.setVisibility(0);
        mViews.promotionsCarouselView.requestLayout();
    }

    private void s()
    {
        mViews.errorView.setClickListener(new com.target.ui.view.common.c() {

            final ListDetailFragment this$0;

            public void A_()
            {
                com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this).c();
            }

            
            {
                this$0 = ListDetailFragment.this;
                super();
            }
        });
        mViews.listDetailView.setListDetailViewListener(this);
        mViews.promotionsCarouselView.setPromotionsListener(this);
    }

    private int t()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)mViews.listDetailView.findViewById(0x7f100456).getLayoutParams();
        return getView().getMeasuredHeight() - mViews.listDetailView.findViewById(0x7f100456).getMeasuredHeight() - layoutparams.topMargin - layoutparams.bottomMargin;
    }

    public boolean R()
    {
        return mPresenter.g();
    }

    public void a(int i1)
    {
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            mPresenter.k();
            return;

        case 2: // '\002'
            mPresenter.n();
            break;
        }
    }

    public void a(int i1, String s1, String s2)
    {
        com.target.ui.util.n.a(getActivity(), s1, s2, getString(i1));
    }

    public void a(Menu menu, boolean flag)
    {
        menu = menu.findItem(0x7f10060b);
        if (menu != null)
        {
            menu.setVisible(flag);
        }
    }

    public void a(e e1)
    {
        mPresenter.a(e1);
    }

    public void a(Tcin tcin, Store store)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(ProductDetailsPageFragment.a(tcin, store));
            return;
        }
    }

    public void a(ListItem listitem)
    {
        listitem = String.format(getString(0x7f09039e), new Object[] {
            listitem.getTitle()
        });
        com.target.ui.util.a.a(getActivity(), mViews.listDetailView, listitem);
    }

    public void a(ListItem listitem, int i1)
    {
        com.target.ui.analytics.b.g.a(com.target.ui.analytics.b.g.a.Remove, listitem.getTitle(), i1).a();
    }

    public void a(ListItem listitem, ListSummary listsummary)
    {
        com.target.ui.analytics.b.g.a(com.target.ui.analytics.b.g.a.Add, listitem.getTitle(), listsummary.getItemCount()).a();
    }

    public void a(ProductDetails productdetails)
    {
        mPresenter.a(productdetails);
    }

    public void a(PromotionDetail promotiondetail, int i1)
    {
        mPresenter.a(promotiondetail, i1);
    }

    public void a(Store store, ListSummary listsummary, List list, ListDetailItem listdetailitem)
    {
        if (Z())
        {
            return;
        } else
        {
            store = StoreMapFragment.a(listsummary, list, store, listdetailitem, this);
            m().d(store);
            return;
        }
    }

    public void a(Store store, ListSummary listsummary, List list, ListDetailItem listdetailitem, View view)
    {
        if (Z())
        {
            return;
        } else
        {
            store = StoreMapFragment.a(listsummary, list, store, listdetailitem, this);
            m().a(store, new d(getActivity(), this, view, "findMapFragmentTransition"));
            return;
        }
    }

    public void a(ListDetailCompletedItem listdetailcompleteditem)
    {
        mPresenter.a(listdetailcompleteditem);
    }

    public void a(ListDetailItem listdetailitem)
    {
        mPresenter.d(listdetailitem);
    }

    public void a(ListDetailItem listdetailitem, int i1)
    {
        mPresenter.d(listdetailitem, i1);
    }

    public void a(ListDetailItem listdetailitem, View view)
    {
        mPresenter.a(listdetailitem, view);
    }

    public void a(String s1)
    {
        mPresenter.b(s1);
    }

    public void a(List list)
    {
        mViews.promotionsCarouselView.setData(list);
    }

    public void a(List list, List list1)
    {
        mViews.listDetailView.e();
        ListDetailItem listdetailitem;
        for (list = list.iterator(); list.hasNext(); mViews.listDetailView.e(listdetailitem))
        {
            listdetailitem = (ListDetailItem)list.next();
        }

        mViews.listDetailView.setCompletedItems(list1);
        mViews.listDetailView.a(0);
    }

    public void a(boolean flag)
    {
        mPresenter.b(flag);
    }

    public void a(boolean flag, boolean flag1)
    {
        com.target.ui.fragment.list.ListClearDialogFragment.a(this, flag, flag1).show(getFragmentManager(), TAG);
    }

    public void b()
    {
        mPresenter.l();
    }

    public void b(int i1)
    {
        ai.b(this, i1);
    }

    public void b(Menu menu, boolean flag)
    {
        menu = menu.findItem(0x7f10060c);
        if (menu != null)
        {
            menu.setVisible(flag);
        }
    }

    public void b(ListCollectionItem listcollectionitem)
    {
        bb.a(listcollectionitem.d().getItemCount()).e();
    }

    public void b(ListDetailCompletedItem listdetailcompleteditem)
    {
        mViews.listDetailView.b(listdetailcompleteditem);
    }

    public void b(ListDetailItem listdetailitem)
    {
        mPresenter.c(listdetailitem);
    }

    public void b(ListDetailItem listdetailitem, int i1)
    {
        mPresenter.c(listdetailitem, i1);
    }

    public void b(String s1)
    {
        mPresenter.a(s1);
    }

    public void b(List list)
    {
        mViews.listDetailView.a(list);
    }

    public void c()
    {
        mPresenter.e();
    }

    public void c(int i1)
    {
        mViews.promotionsCarouselView.setPosition(i1);
    }

    public void c(ListDetailItem listdetailitem)
    {
        mPresenter.b(listdetailitem);
    }

    public void c(ListDetailItem listdetailitem, int i1)
    {
        mPresenter.a(listdetailitem, i1);
    }

    public void c(String s1)
    {
        j(s1);
    }

    public void c(boolean flag)
    {
        b(flag);
    }

    public void d()
    {
        mPresenter.h();
    }

    public void d(ListDetailItem listdetailitem)
    {
        mPresenter.a(listdetailitem);
    }

    public void d(ListDetailItem listdetailitem, int i1)
    {
        mViews.listDetailView.e(listdetailitem, i1);
        if (mViews.listDetailView.getListItems().size() == 2)
        {
            mViews.listDetailView.c();
        }
    }

    public void d(String s1)
    {
        mViews.listDetailView.setListName(s1);
    }

    public void d(boolean flag)
    {
        o(flag);
    }

    public void e()
    {
        al.a(mViews.errorView, new View[] {
            mViews.listDetailView, mViews.promotionsCarouselView
        });
        mViews.errorView.a("", getResources().getString(0x7f090397), true);
    }

    public void e(ListDetailItem listdetailitem)
    {
        listdetailitem = String.format(getString(0x7f09039c), new Object[] {
            listdetailitem.b()
        });
        com.target.ui.util.a.a(getActivity(), mViews.listDetailView, listdetailitem);
    }

    public void e(final ListDetailItem detailItem, final int position)
    {
        String s1 = getString(0x7f0903b2, new Object[] {
            detailItem.b()
        });
        mSnackBar.a(s1, getString(0x7f09051e), new com.target.ui.view.common.h.b() {

            final ListDetailFragment this$0;
            final ListDetailItem val$detailItem;
            final int val$position;

            public void a()
            {
                com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this).b(detailItem, position);
            }

            public void b()
            {
            }

            
            {
                this$0 = ListDetailFragment.this;
                detailItem = listdetailitem;
                position = i1;
                super();
            }
        });
    }

    public void e(String s1)
    {
        s1 = String.format(getActivity().getResources().getString(0x7f090386), new Object[] {
            s1
        });
        com.target.ui.util.a.a(getActivity(), getView(), s1);
    }

    public void e(boolean flag)
    {
        mViews.promotionsCarouselView.a(flag);
    }

    public void f()
    {
        al.a(mViews.listDetailView, new View[] {
            mViews.errorView
        });
    }

    public void f(ListDetailItem listdetailitem)
    {
        mViews.listDetailView.f(listdetailitem);
    }

    public void f(ListDetailItem listdetailitem, int i1)
    {
        d(listdetailitem, i1);
    }

    public void f(String s1)
    {
        mViews.promotionsCarouselView.setReferenceProductName(s1);
    }

    public void g()
    {
        mViews.listDetailView.e();
    }

    public void g(ListDetailItem listdetailitem)
    {
        af.a(listdetailitem).e();
    }

    public void h()
    {
        mViews.listDetailView.f();
    }

    public void i()
    {
        m().d(ScanUpcFragment.b(this));
    }

    public void j()
    {
        mViews.listDetailView.c();
    }

    public void k()
    {
        mViews.promotionsCarouselView.a();
    }

    public void l()
    {
        com.target.ui.util.e.a.a(this);
    }

    public void n()
    {
        if (mIsAnimating)
        {
            return;
        } else
        {
            int i1 = t();
            d(i1);
            mViews.listDetailView.g();
            mViews.listDetailView.setPromotionsOpen(true);
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(mViews.promotionsCarouselView, View.TRANSLATION_Y, new float[] {
                    (float)(-i1), 0.0F
                }), ObjectAnimator.ofFloat(mViews.listDetailView, View.TRANSLATION_Y, new float[] {
                    0.0F, (float)i1
                })
            });
            animatorset.setDuration(500L);
            animatorset.addListener(new a());
            animatorset.start();
            mPresenter.a(true);
            return;
        }
    }

    public void o()
    {
        if (mIsAnimating)
        {
            return;
        } else
        {
            mViews.listDetailView.h();
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(mViews.promotionsCarouselView, View.TRANSLATION_Y, new float[] {
                    0.0F, (float)(-mViews.promotionsCarouselView.getMeasuredHeight())
                }), ObjectAnimator.ofFloat(mViews.listDetailView, View.TRANSLATION_Y, new float[] {
                    (float)mViews.promotionsCarouselView.getMeasuredHeight(), 0.0F
                })
            });
            animatorset.setDuration(500L);
            animatorset.addListener(new a());
            animatorset.start();
            mPresenter.a(false);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ListCollectionItem listcollectionitem = (ListCollectionItem)getArguments().getParcelable("LIST_COLLECTION_ITEM_KEY_ID");
        b b1;
        android.os.Parcelable parcelable;
        if (listcollectionitem == null)
        {
            b1 = new b();
        } else
        {
            b1 = new b(listcollectionitem.d());
        }
        parcelable = null;
        if (bundle != null)
        {
            parcelable = bundle.getParcelable("ARG_SAVED_STATE_LIST_DETAIL_PRESENTER");
        }
        mRelevantStoreService = com.target.ui.service.k.a();
        mPresenter = (new com.target.ui.fragment.list.presenter.ListDetailPresenter.a()).a(b1).a(listcollectionitem).a(m.a()).a(com.target.ui.service.g.a()).a(new com.target.ui.helper.promotions.a()).a((Store)mRelevantStoreService.c().d()).a(new com.target.ui.service.provider.d()).a(new com.target.ui.service.provider.e()).a(parcelable).a(getActivity()).a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            menuinflater.inflate(0x7f12000f, menu);
            mPresenter.a(menu, menuinflater);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (com.target.ui.util.j.b())
        {
            com.target.ui.f.c.f(this);
        }
        layoutinflater = layoutinflater.inflate(0x7f030061, viewgroup, false);
        mViews = new Views(layoutinflater);
        s();
        mSnackBar = new h(getActivity());
        mPresenter.a(this);
        mRelevantStoreService.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mRelevantStoreService = null;
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mRelevantStoreService.b(this);
        mPresenter.z_();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756556: 
            mPresenter.i();
            return true;

        case 2131756555: 
            mPresenter.j();
            return true;
        }
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        mPresenter.a(menu);
    }

    public void onResume()
    {
        super.onResume();
        mViews.listDetailView.d();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putParcelable("ARG_SAVED_STATE_LIST_DETAIL_PRESENTER", mPresenter.m());
        super.onSaveInstanceState(bundle);
    }

    public void p()
    {
        ad.a(getActivity(), mSnackBar, new com.target.ui.view.common.h.b() {

            final ListDetailFragment this$0;

            public void a()
            {
                com.target.ui.fragment.list.ListDetailFragment.a(ListDetailFragment.this).f();
            }

            public void b()
            {
            }

            
            {
                this$0 = ListDetailFragment.this;
                super();
            }
        });
    }

    public void q()
    {
        f f1 = getActivity();
        if (f1 != null)
        {
            f1.d();
        }
    }

    public void r()
    {
        if (!com.target.ui.googlenow.b.b(getActivity()).booleanValue())
        {
            com.target.ui.googlenow.a.a(getActivity());
            GoogleNowSendCardHelper googlenowsendcardhelper = new GoogleNowSendCardHelper(getActivity());
            com.target.ui.googlenow.a.a(getActivity(), googlenowsendcardhelper.c());
            com.target.ui.googlenow.b.b(getActivity(), Boolean.valueOf(true));
        }
    }

}
