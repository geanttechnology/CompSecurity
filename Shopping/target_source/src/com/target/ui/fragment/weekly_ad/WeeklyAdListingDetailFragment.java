// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.mothership.services.x;
import com.target.ui.c.b.b;
import com.target.ui.f.a;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.ad;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import com.target.ui.view.common.h;
import com.target.ui.view.weekly_ad.WeeklyAdListLayout;
import com.target.ui.view.weekly_ad.WeeklyAdListingDetailHeaderView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdPdpFragment, WeeklyAdListingDescriptionFragment

public class WeeklyAdListingDetailFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, c, com.target.ui.view.weekly_ad.WeeklyAdListLayout.a, com.target.ui.view.weekly_ad.WeeklyAdListingDetailHeaderView.a
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        WeeklyAdListingDetailHeaderView header;
        WeeklyAdListLayout list;
        View loader;

        Views(View view, Context context)
        {
            super(view);
            header = new WeeklyAdListingDetailHeaderView(context);
        }
    }

    protected class a extends com.target.ui.c.b.e
    {

        final WeeklyAdListingDetailFragment this$0;

        public void a(String s)
        {
            com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this).c(s);
        }

        public void a(String s, ListSummary listsummary)
        {
            ad.a(getActivity(), s, com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this), listsummary, m());
        }

        protected a()
        {
            this$0 = WeeklyAdListingDetailFragment.this;
            super();
        }
    }


    public static final String LISTING_ARG = "listing";
    public static final String PROMOTION_ARG = "promotion";
    public static final String STORE_SUMMARY_ARG = "storeSummary";
    private static final String THUMBNAIL_ARG = "thumbnail";
    private static final String THUMBNAIL_URL_ARG = "thumbnailUrl";
    public static final String TRANSITION_TAG = "weeklyAdCollectionTransition";
    private b mAddToListDelegate;
    private com.target.ui.helper.q.a mDataHelper;
    private Parcelable mHeaderSavedState;
    private WeeklyAdListingBase mListing;
    private WeeklyAdListingDetail mListingDetail;
    private PromotionRequest mPromotionRequest;
    private h mSnackbar;
    private StoreSummary mStoreSummary;
    private Views mViews;

    public WeeklyAdListingDetailFragment()
    {
        mAddToListDelegate = new b(this, new a());
    }

    static WeeklyAdListingDetail a(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment, WeeklyAdListingDetail weeklyadlistingdetail)
    {
        weeklyadlistingdetailfragment.mListingDetail = weeklyadlistingdetail;
        return weeklyadlistingdetail;
    }

    public static WeeklyAdListingDetailFragment a(WeeklyAdListingBase weeklyadlistingbase, PromotionRequest promotionrequest, StoreSummary storesummary)
    {
        WeeklyAdListingDetailFragment weeklyadlistingdetailfragment = new WeeklyAdListingDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("listing", weeklyadlistingbase);
        bundle.putParcelable("promotion", promotionrequest);
        bundle.putParcelable("storeSummary", storesummary);
        weeklyadlistingdetailfragment.setArguments(bundle);
        return weeklyadlistingdetailfragment;
    }

    static h a(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment)
    {
        return weeklyadlistingdetailfragment.mSnackbar;
    }

    private void a(WeeklyAdListingBase weeklyadlistingbase)
    {
        m().d(com.target.ui.fragment.weekly_ad.WeeklyAdPdpFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary));
    }

    private void a(WeeklyAdListingBase weeklyadlistingbase, BitmapImageView bitmapimageview)
    {
        if (j.b())
        {
            a(bitmapimageview, weeklyadlistingbase);
            return;
        } else
        {
            a(weeklyadlistingbase);
            return;
        }
    }

    private void a(WeeklyAdListingDetail weeklyadlistingdetail)
    {
        mViews.list.setWeeklyAdListingCollectionItemData(weeklyadlistingdetail.k());
        mViews.list.setOnCollectionItemClickedListener(this);
    }

    static void a(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment, boolean flag)
    {
        weeklyadlistingdetailfragment.a(flag);
    }

    private void a(BitmapImageView bitmapimageview, WeeklyAdListingBase weeklyadlistingbase)
    {
        String s = weeklyadlistingbase.e();
        weeklyadlistingbase = com.target.ui.fragment.weekly_ad.WeeklyAdPdpFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary);
        bitmapimageview = new com.target.ui.f.a(getActivity(), this, bitmapimageview, weeklyadlistingbase.a());
        bitmapimageview.a(s);
        (new com.target.ui.f.b(m())).a(weeklyadlistingbase, bitmapimageview);
    }

    private void a(boolean flag)
    {
        boolean flag1 = false;
        al.a(mViews.errorView, false);
        if (j.b())
        {
            mViews.loader.setVisibility(8);
            mViews.header.a(flag);
            return;
        }
        Object obj = mViews.list;
        int i;
        if (flag)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        ((WeeklyAdListLayout) (obj)).setVisibility(i);
        obj = mViews.loader;
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    static Views b(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment)
    {
        return weeklyadlistingdetailfragment.mViews;
    }

    static void b(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment, WeeklyAdListingDetail weeklyadlistingdetail)
    {
        weeklyadlistingdetailfragment.a(weeklyadlistingdetail);
    }

    static StoreSummary c(WeeklyAdListingDetailFragment weeklyadlistingdetailfragment)
    {
        return weeklyadlistingdetailfragment.mStoreSummary;
    }

    private void d()
    {
        Bitmap bitmap = (Bitmap)getArguments().getParcelable("thumbnail");
        String s = getArguments().getString("thumbnailUrl");
        mViews.header.a(bitmap, "weeklyAdCollectionTransition", s);
    }

    private void e()
    {
        if (mListingDetail != null)
        {
            mViews.header.a(mListingDetail, mStoreSummary);
            if (!mListingDetail.k().isEmpty())
            {
                a(mListingDetail);
            }
            return;
        }
        if (j.b())
        {
            d();
        }
        if (!com.target.mothership.util.b.a().b())
        {
            a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            return;
        } else
        {
            a(true);
            mDataHelper.a(mListing, mPromotionRequest, new com.target.ui.helper.q.a.b() {

                final WeeklyAdListingDetailFragment this$0;

                public void a(WeeklyAdListingDetail weeklyadlistingdetail)
                {
                    if (com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.b(WeeklyAdListingDetailFragment.this) != null && weeklyadlistingdetail != null)
                    {
                        com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this, weeklyadlistingdetail);
                        com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this, false);
                        com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.b(WeeklyAdListingDetailFragment.this).header.a(weeklyadlistingdetail, com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.c(WeeklyAdListingDetailFragment.this));
                        if (!weeklyadlistingdetail.k().isEmpty())
                        {
                            com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.b(WeeklyAdListingDetailFragment.this, weeklyadlistingdetail);
                            return;
                        }
                    }
                }

                public void a_(x x)
                {
                    if (com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.b(WeeklyAdListingDetailFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(WeeklyAdListingDetailFragment.this, false);
                        WeeklyAdListingDetailFragment.this.a(null, getString(0x7f09052e), true);
                        return;
                    }
                }

            
            {
                this$0 = WeeklyAdListingDetailFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void A_()
    {
        e();
    }

    public void a()
    {
        mAddToListDelegate.a(mListing);
    }

    public void a(Bitmap bitmap, String s)
    {
        if (getArguments() == null)
        {
            return;
        } else
        {
            getArguments().putParcelable("thumbnail", bitmap);
            getArguments().putString("thumbnailUrl", s);
            return;
        }
    }

    public void a(View view)
    {
        mViews = new Views(view, getActivity());
        mViews.list.addHeaderView(mViews.header, null, false);
        if (mHeaderSavedState != null)
        {
            mViews.header.onRestoreInstanceState(mHeaderSavedState);
            mHeaderSavedState = null;
        }
        mViews.header.setListener(this);
        mViews.errorView.setClickListener(this);
    }

    public void a(WeeklyAdListingCollectionItem weeklyadlistingcollectionitem, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$ui$adapter$weekly_ad$BaseWeeklyAdListItemAdapter$ActionType[];

            static 
            {
                $SwitchMap$com$target$ui$adapter$weekly_ad$BaseWeeklyAdListItemAdapter$ActionType = new int[com.target.ui.adapter.j.a.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$adapter$weekly_ad$BaseWeeklyAdListItemAdapter$ActionType[com.target.ui.adapter.j.a.a.ADD_TO_LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls2..SwitchMap.com.target.ui.adapter.weekly_ad.BaseWeeklyAdListItemAdapter.ActionType[a1.ordinal()])
        {
        default:
            if (weeklyadlistingcollectionitem.d().b())
            {
                a(((WeeklyAdListingBase) (weeklyadlistingcollectionitem)), bitmapimageview);
                return;
            } else
            {
                m().d(a(((WeeklyAdListingBase) (weeklyadlistingcollectionitem)), mPromotionRequest, mStoreSummary));
                return;
            }

        case 1: // '\001'
            mAddToListDelegate.a(weeklyadlistingcollectionitem);
            return;
        }
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        a(false);
        if (j.b())
        {
            mViews.header.a(a1, flag);
            return;
        } else
        {
            al.a(mViews.errorView, new View[] {
                mViews.list
            });
            mViews.errorView.a(a1, flag);
            return;
        }
    }

    public void a(String s, String s1, boolean flag)
    {
        a(false);
        if (j.b())
        {
            mViews.header.a(s, s1, flag);
            return;
        } else
        {
            al.a(mViews.errorView, new View[] {
                mViews.list
            });
            mViews.errorView.a(s, s1, flag);
            return;
        }
    }

    public void b()
    {
        e();
    }

    public void c()
    {
        if (mListingDetail == null)
        {
            q.a(TAG, "Listing detail unexpectedly null when clicking on product details button");
            return;
        } else
        {
            m().d(com.target.ui.fragment.weekly_ad.WeeklyAdListingDescriptionFragment.a(mListingDetail));
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(mAddToListDelegate);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mListing = (WeeklyAdListingBase)getArguments().get("listing");
        mPromotionRequest = (PromotionRequest)getArguments().get("promotion");
        mStoreSummary = (StoreSummary)getArguments().get("storeSummary");
        mDataHelper = new com.target.ui.helper.q.a();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        j("");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03008f, viewgroup, false);
        a(layoutinflater);
        e();
        mSnackbar = new h(getActivity());
        if (j.b())
        {
            com.target.ui.f.c.f(this);
            ((ViewGroup)layoutinflater).setTransitionGroup(true);
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mHeaderSavedState = mViews.header.onSaveInstanceState();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mAddToListDelegate = null;
    }

    public void onPause()
    {
        super.onPause();
        if (mSnackbar == null)
        {
            return;
        } else
        {
            mSnackbar.a();
            return;
        }
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mAddToListDelegate.s_();
    }
}
