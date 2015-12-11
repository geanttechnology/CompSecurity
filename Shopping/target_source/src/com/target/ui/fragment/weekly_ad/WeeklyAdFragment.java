// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.weekly_ad;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.a.e;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListing;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingBase;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPage;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdPromotion;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.ba;
import com.target.ui.analytics.h;
import com.target.ui.c.b.b;
import com.target.ui.f.g;
import com.target.ui.fragment.common.BaseStoreChooserFragment;
import com.target.ui.fragment.common.SimpleDialogFragment;
import com.target.ui.helper.q.a;
import com.target.ui.model.weekly_ad.WeeklyAdHomepageData;
import com.target.ui.service.k;
import com.target.ui.util.ad;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import com.target.ui.view.weekly_ad.WeeklyAdHeaderView;
import com.target.ui.view.weekly_ad.WeeklyAdListLayout;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.weekly_ad:
//            WeeklyAdListingDetailFragment, WeeklyAdPdpFragment

public class WeeklyAdFragment extends BaseStoreChooserFragment
    implements com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.c, c, com.target.ui.view.weekly_ad.WeeklyAdHeaderView.a
{
    static class Views extends com.target.ui.view.a
    {

        TargetErrorView errorView;
        View progressContainer;
        WeeklyAdHeaderView weeklyAdHeaderView;
        WeeklyAdListLayout weeklyAdListLayout;

        Views(View view)
        {
            super(view);
        }
    }

    protected class a extends com.target.ui.c.b.e
    {

        final WeeklyAdFragment this$0;

        public void a(String s)
        {
            com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this).c(s);
        }

        public void a(String s, ListSummary listsummary)
        {
            ad.a(getActivity(), s, com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this), listsummary, m());
        }

        protected a()
        {
            this$0 = WeeklyAdFragment.this;
            super();
        }
    }


    private static final String ARG_PROMOTION_REQUEST = "promotionRequest";
    private static final String ARG_SAVED_DATA = "savedData";
    private static final String ARG_STORE_IDENTIFIER = "storeIdentifier";
    private static final String ARG_STORE_SUMMARY = "storeSummary";
    private static final String ARG_THUMBNAIL = "thumbnail";
    private static final String ARG_THUMBNAIL_URL = "thumbnailUrl";
    private static final String ARG_WEEKLY_AD_HOMEPAGE_DATA = "weeklyAdHomepageData";
    private static final int SCROLL_TO_TOP_DURATION = 300;
    public static final String TAG = com/target/ui/fragment/weekly_ad/WeeklyAdFragment.getSimpleName();
    public static final String TRANSITION_TAG = "weeklyAdFragmentTransitionTag";
    private static final String TRY_AGAIN_SPACER_FORMAT = "%s %s";
    private b mAddToListDelegate;
    private h mLoadingTimestamp;
    private Bitmap mPlaceholderBitmap;
    private String mPlaceholderImageUrl;
    private WeeklyAdHomepageData mPreviousData;
    private PromotionRequest mPromotionRequest;
    private WeeklyAdHomepageData mSavedData;
    private com.target.ui.view.common.h mSnackBar;
    private StoreIdentifier mStoreIdentifier;
    private com.target.mothership.model.store.c mStoreManager;
    private StoreSlug mStoreSlug;
    private StoreSummary mStoreSummary;
    private Views mViews;
    private int mWeeklyAdContainerHeight;
    private com.target.ui.helper.q.a mWeeklyAdDataHelper;
    private Parcelable mWeeklyAdHeaderSavedState;
    private WeeklyAdHomepage mWeeklyAdHomepage;
    private List mWeeklyAdPages;
    private WeeklyAdPromotion mWeeklyAdPromotion;

    public WeeklyAdFragment()
    {
        mAddToListDelegate = new b(this, new a());
        mLoadingTimestamp = new h();
    }

    static int a(WeeklyAdFragment weeklyadfragment, int i)
    {
        weeklyadfragment.mWeeklyAdContainerHeight = i;
        return i;
    }

    static StoreSummary a(WeeklyAdFragment weeklyadfragment, StoreSummary storesummary)
    {
        weeklyadfragment.mStoreSummary = storesummary;
        return storesummary;
    }

    public static WeeklyAdFragment a(StoreIdentifier storeidentifier, PromotionRequest promotionrequest)
    {
        WeeklyAdFragment weeklyadfragment = new WeeklyAdFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeIdentifier", storeidentifier);
        bundle.putParcelable("promotionRequest", promotionrequest);
        weeklyadfragment.setArguments(bundle);
        return weeklyadfragment;
    }

    public static WeeklyAdFragment a(WeeklyAdHomepageData weeklyadhomepagedata)
    {
        WeeklyAdFragment weeklyadfragment = new WeeklyAdFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("weeklyAdHomepageData", weeklyadhomepagedata);
        weeklyadfragment.setArguments(bundle);
        return weeklyadfragment;
    }

    static com.target.ui.view.common.h a(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mSnackBar;
    }

    static List a(WeeklyAdFragment weeklyadfragment, List list)
    {
        weeklyadfragment.mWeeklyAdPages = list;
        return list;
    }

    private void a(long l)
    {
        ba.a(l, this).e();
    }

    private void a(StoreSlug storeslug, WeeklyAdPromotion weeklyadpromotion, PromotionRequest promotionrequest)
    {
        mWeeklyAdDataHelper.a(storeslug, weeklyadpromotion, promotionrequest, new com.target.ui.helper.q.a.c() {

            final WeeklyAdFragment this$0;

            public void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, a1);
                    return;
                }
            }

            public void a(List list, WeeklyAdPromotion weeklyadpromotion1, StoreSlug storeslug1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) != null)
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, list);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, WeeklyAdFragment.d(WeeklyAdFragment.this), com.target.ui.fragment.weekly_ad.WeeklyAdFragment.c(WeeklyAdFragment.this));
                    if (j.b())
                    {
                        com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdHeaderView.a();
                        return;
                    }
                }
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
        });
        a(true);
    }

    private void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug, PromotionRequest promotionrequest)
    {
        if (mViews == null)
        {
            return;
        }
        a(false);
        mWeeklyAdHomepage = weeklyadhomepage;
        mStoreSlug = storeslug;
        mWeeklyAdPromotion = weeklyadhomepage.a();
        mPromotionRequest = promotionrequest;
        if (weeklyadhomepage.b().size() > 0)
        {
            q.a(TAG, "Weekly Ad selection is not yet implemented.Using default promotion");
            a(mStoreSlug, mWeeklyAdPromotion, mPromotionRequest);
            return;
        } else
        {
            a(mStoreSlug, mWeeklyAdPromotion, mPromotionRequest);
            return;
        }
    }

    private void a(WeeklyAdListingBase weeklyadlistingbase)
    {
        m().d(com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary));
    }

    private void a(WeeklyAdListingBase weeklyadlistingbase, BitmapImageView bitmapimageview)
    {
        if (j.b())
        {
            if (weeklyadlistingbase.d().b())
            {
                b(bitmapimageview, weeklyadlistingbase);
                return;
            } else
            {
                a(bitmapimageview, weeklyadlistingbase);
                return;
            }
        }
        if (weeklyadlistingbase.d().b())
        {
            b(weeklyadlistingbase);
            return;
        } else
        {
            a(weeklyadlistingbase);
            return;
        }
    }

    private void a(WeeklyAdPromotion weeklyadpromotion, List list)
    {
        if (list == null || list.size() == 0)
        {
            q.a(TAG, "No weekly ad pages");
            return;
        } else
        {
            mViews.weeklyAdHeaderView.a(weeklyadpromotion.b(), weeklyadpromotion.c());
            mViews.weeklyAdHeaderView.setPages(list);
            a(a(mLoadingTimestamp));
            return;
        }
    }

    private void a(com.target.mothership.model.weeklyad.interfaces.a.a a1)
    {
        a(getString(0x7f09052b), true);
    }

    private void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
    {
        String s = getString(0x7f09052b);
        com.target.mothership.model.weeklyad.interfaces.a.b.a a1 = (com.target.mothership.model.weeklyad.interfaces.a.b.a)b1.f().get(0);
        boolean flag;
        if (com.target.mothership.model.weeklyad.interfaces.a.b.a.ERR_STORE_NOT_FOUND.equals(a1))
        {
            b1 = null;
            if (mStoreSummary != null)
            {
                b1 = mStoreSummary.getName();
            }
            if (b1 != null)
            {
                b1 = String.format(getString(0x7f09052d), new Object[] {
                    b1
                });
            } else
            {
                b1 = getString(0x7f09052c);
            }
            flag = false;
        } else
        {
            if (b1.d() != null)
            {
                q.a(TAG, b1.d().getMessage());
            }
            flag = true;
            b1 = s;
        }
        a(((String) (b1)), flag);
    }

    private void a(x x1)
    {
        a(getString(0x7f09052b), true);
    }

    static void a(WeeklyAdFragment weeklyadfragment, WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug, PromotionRequest promotionrequest)
    {
        weeklyadfragment.a(weeklyadhomepage, storeslug, promotionrequest);
    }

    static void a(WeeklyAdFragment weeklyadfragment, WeeklyAdListingBase weeklyadlistingbase, BitmapImageView bitmapimageview)
    {
        weeklyadfragment.a(weeklyadlistingbase, bitmapimageview);
    }

    static void a(WeeklyAdFragment weeklyadfragment, WeeklyAdPromotion weeklyadpromotion, List list)
    {
        weeklyadfragment.a(weeklyadpromotion, list);
    }

    static void a(WeeklyAdFragment weeklyadfragment, com.target.mothership.model.weeklyad.interfaces.a.a a1)
    {
        weeklyadfragment.a(a1);
    }

    static void a(WeeklyAdFragment weeklyadfragment, com.target.mothership.model.weeklyad.interfaces.a.b b1)
    {
        weeklyadfragment.a(b1);
    }

    static void a(WeeklyAdFragment weeklyadfragment, x x1)
    {
        weeklyadfragment.a(x1);
    }

    static void a(WeeklyAdFragment weeklyadfragment, boolean flag)
    {
        weeklyadfragment.a(flag);
    }

    private void a(BitmapImageView bitmapimageview, WeeklyAdListingBase weeklyadlistingbase)
    {
        String s = weeklyadlistingbase.e();
        weeklyadlistingbase = com.target.ui.fragment.weekly_ad.WeeklyAdListingDetailFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary);
        bitmapimageview = new com.target.ui.f.a(getActivity(), this, bitmapimageview, "weeklyAdCollectionTransition");
        bitmapimageview.a(s);
        (new com.target.ui.f.b(m())).a(weeklyadlistingbase, bitmapimageview);
    }

    private void a(String s, boolean flag)
    {
        if (mPreviousData == null)
        {
            a(((String) (null)), s, flag);
            return;
        }
        c(mPreviousData);
        mPreviousData = null;
        String s1 = s;
        if (flag)
        {
            s1 = String.format("%s %s", new Object[] {
                s, getString(0x7f09052f)
            });
        }
        SimpleDialogFragment.a(getString(0x7f090529), s1).show(getFragmentManager(), SimpleDialogFragment.TAG);
    }

    private void a(boolean flag)
    {
        boolean flag1 = false;
        if (a())
        {
            c(flag);
            return;
        }
        al.a(mViews.errorView, false);
        al.a(mViews.progressContainer, flag);
        WeeklyAdListLayout weeklyadlistlayout = mViews.weeklyAdListLayout;
        if (!flag)
        {
            flag1 = true;
        }
        al.a(weeklyadlistlayout, flag1);
    }

    private boolean a()
    {
        return mPlaceholderBitmap != null && mSavedData == null && mPreviousData == null && j.b();
    }

    static Views b(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mViews;
    }

    public static WeeklyAdFragment b(StoreSummary storesummary)
    {
        WeeklyAdFragment weeklyadfragment = new WeeklyAdFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeSummary", storesummary);
        weeklyadfragment.setArguments(bundle);
        return weeklyadfragment;
    }

    private WeeklyAdHomepageData b()
    {
        if (mWeeklyAdHomepage == null || mWeeklyAdPromotion == null || mPromotionRequest == null || mWeeklyAdPages == null || mStoreIdentifier == null || mStoreSlug == null)
        {
            return null;
        } else
        {
            return new WeeklyAdHomepageData(mWeeklyAdHomepage, mWeeklyAdPromotion, mPromotionRequest, mWeeklyAdPages, mStoreIdentifier, mStoreSlug, mStoreSummary);
        }
    }

    private void b(int i, int l)
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < l && i1 < mWeeklyAdPages.size(); i1++)
        {
            arraylist.addAll(((WeeklyAdPage)mWeeklyAdPages.get(i + i1)).b());
        }

        mViews.weeklyAdListLayout.setWeeklyAdListingData(arraylist);
        mViews.weeklyAdListLayout.setOnListingClickedListener(new com.target.ui.view.weekly_ad.WeeklyAdListLayout.b() {

            final WeeklyAdFragment this$0;

            public void a(WeeklyAdListing weeklyadlisting, BitmapImageView bitmapimageview, com.target.ui.adapter.j.a.a a1)
            {
                static class _cls8
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

                switch (_cls8..SwitchMap.com.target.ui.adapter.weekly_ad.BaseWeeklyAdListItemAdapter.ActionType[a1.ordinal()])
                {
                default:
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, weeklyadlisting, bitmapimageview);
                    return;

                case 1: // '\001'
                    WeeklyAdFragment.f(WeeklyAdFragment.this).a(weeklyadlisting);
                    break;
                }
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
        });
    }

    private void b(StoreIdentifier storeidentifier)
    {
        mLoadingTimestamp = new h();
        if (mWeeklyAdPages != null)
        {
            a(mWeeklyAdPromotion, mWeeklyAdPages);
            return;
        }
        if (!com.target.mothership.util.b.a().b())
        {
            a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            return;
        }
        if (mPromotionRequest != null)
        {
            b(storeidentifier, mPromotionRequest);
            return;
        } else
        {
            c(storeidentifier);
            return;
        }
    }

    private void b(StoreIdentifier storeidentifier, final PromotionRequest promotionRequest)
    {
        mWeeklyAdDataHelper.a(storeidentifier, promotionRequest, new com.target.ui.helper.q.a.a() {

            final WeeklyAdFragment this$0;
            final PromotionRequest val$promotionRequest;

            public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug)
            {
                com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, weeklyadhomepage, storeslug, promotionRequest);
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, b1);
                    return;
                }
            }

            public void a(x x1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, x1);
                    return;
                }
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                promotionRequest = promotionrequest;
                super();
            }
        });
        a(true);
    }

    private void b(WeeklyAdListingBase weeklyadlistingbase)
    {
        m().d(com.target.ui.fragment.weekly_ad.WeeklyAdPdpFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary));
    }

    private void b(WeeklyAdHomepageData weeklyadhomepagedata)
    {
        if (weeklyadhomepagedata == null)
        {
            q.a(TAG, "Tried to restore weekly ad state from null previous data");
            return;
        } else
        {
            mPromotionRequest = weeklyadhomepagedata.a();
            mStoreIdentifier = weeklyadhomepagedata.b();
            mStoreSlug = weeklyadhomepagedata.c();
            mStoreSummary = (StoreSummary)weeklyadhomepagedata.d().d();
            mWeeklyAdHomepage = weeklyadhomepagedata.e();
            mWeeklyAdPages = weeklyadhomepagedata.f();
            mWeeklyAdPromotion = weeklyadhomepagedata.g();
            return;
        }
    }

    private void b(BitmapImageView bitmapimageview, WeeklyAdListingBase weeklyadlistingbase)
    {
        String s = weeklyadlistingbase.e();
        weeklyadlistingbase = com.target.ui.fragment.weekly_ad.WeeklyAdPdpFragment.a(weeklyadlistingbase, mPromotionRequest, mStoreSummary);
        bitmapimageview = new com.target.ui.f.a(getActivity(), this, bitmapimageview, weeklyadlistingbase.a());
        bitmapimageview.a(s);
        (new com.target.ui.f.b(m())).a(weeklyadlistingbase, bitmapimageview);
    }

    static List c(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mWeeklyAdPages;
    }

    private void c()
    {
        View view = mViews.weeklyAdListLayout.getChildAt(mViews.weeklyAdListLayout.getFirstVisiblePosition());
        if (view == null)
        {
            return;
        } else
        {
            int i = view.getTop();
            int l = mViews.weeklyAdListLayout.getTop();
            mViews.weeklyAdListLayout.smoothScrollBy(i - l, 300);
            return;
        }
    }

    private void c(StoreIdentifier storeidentifier)
    {
        mWeeklyAdDataHelper.a(storeidentifier, new com.target.ui.helper.q.a.a() {

            final WeeklyAdFragment this$0;

            public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug)
            {
                com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, weeklyadhomepage, storeslug, new PromotionRequest(weeklyadhomepage.a().a()));
            }

            public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, b1);
                    return;
                }
            }

            public void a(x x1)
            {
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, false);
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, x1);
                    return;
                }
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
        });
        a(true);
    }

    private void c(WeeklyAdHomepageData weeklyadhomepagedata)
    {
        if (weeklyadhomepagedata == null)
        {
            q.a(TAG, "Tried to restore weekly ad state from null previous data");
            return;
        }
        b(weeklyadhomepagedata);
        if (mStoreSummary != null)
        {
            j(mStoreSummary.getName());
        }
        a(mWeeklyAdPromotion, mWeeklyAdPages);
    }

    private void c(boolean flag)
    {
        al.a(mViews.errorView, false);
        al.a(mViews.progressContainer, flag);
        al.a(mViews.weeklyAdListLayout, true);
        mViews.weeklyAdHeaderView.a(flag);
    }

    static WeeklyAdPromotion d(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mWeeklyAdPromotion;
    }

    private void d()
    {
        if (mStoreSummary == null)
        {
            return;
        } else
        {
            j(mStoreSummary.getName());
            return;
        }
    }

    private void d(StoreIdentifier storeidentifier)
    {
        if (mStoreSummary != null)
        {
            return;
        } else
        {
            k.a().a(storeidentifier, new com.target.mothership.model.h() {

                final WeeklyAdFragment this$0;

                public String a()
                {
                    return WeeklyAdFragment.TAG;
                }

                public void a(RelevantStoreSummary relevantstoresummary)
                {
                    if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, relevantstoresummary);
                        com.target.ui.fragment.weekly_ad.WeeklyAdFragment.e(WeeklyAdFragment.this);
                        return;
                    }
                }

                public void a(x x1)
                {
                    if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        q.a(WeeklyAdFragment.TAG, "Error when retrieving the store summary");
                        return;
                    }
                }

                public volatile void a(Object obj)
                {
                    a((RelevantStoreSummary)obj);
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void e()
    {
        mViews.errorView.setClickListener(this);
        mViews.weeklyAdHeaderView = (WeeklyAdHeaderView)mViews.weeklyAdListLayout.a(0x7f030209);
        mViews.weeklyAdHeaderView.setOnImageEventListener(this);
        if (mWeeklyAdHeaderSavedState != null)
        {
            mViews.weeklyAdHeaderView.onRestoreInstanceState(mWeeklyAdHeaderSavedState);
            mWeeklyAdHeaderSavedState = null;
        }
        if (j.b())
        {
            mViews.weeklyAdHeaderView.a(mPlaceholderBitmap, mPlaceholderImageUrl, "weeklyAdFragmentTransitionTag");
        }
        mViews.weeklyAdListLayout.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

            final WeeklyAdFragment this$0;

            public void onLayoutChange(View view, int i, int l, int i1, int j1, int k1, int l1, 
                    int i2, int j2)
            {
                com.target.ui.fragment.weekly_ad.WeeklyAdFragment.a(WeeklyAdFragment.this, com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdListLayout.getHeight());
                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.g(WeeklyAdFragment.this) == 0)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdHeaderView.b(com.target.ui.fragment.weekly_ad.WeeklyAdFragment.g(WeeklyAdFragment.this));
                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(WeeklyAdFragment.this).weeklyAdListLayout.removeOnLayoutChangeListener(this);
                    return;
                }
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
        });
    }

    static void e(WeeklyAdFragment weeklyadfragment)
    {
        weeklyadfragment.d();
    }

    static b f(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mAddToListDelegate;
    }

    static int g(WeeklyAdFragment weeklyadfragment)
    {
        return weeklyadfragment.mWeeklyAdContainerHeight;
    }

    public void A_()
    {
        b(mStoreIdentifier);
    }

    public void J()
    {
        while (mViews == null || mStoreIdentifier != null || getFragmentManager() == null) 
        {
            return;
        }
        getFragmentManager().d();
    }

    public e W()
    {
        return com.google.a.a.e.b(new g() {

            final WeeklyAdFragment this$0;

            public e a()
            {
                return com.google.a.a.e.b(new com.target.ui.f.e() {

                    final _cls1 this$1;

                    public void onTransitionEnd(Transition transition)
                    {
                        (new Handler(Looper.getMainLooper())).post(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0) != null)
                                {
                                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0).weeklyAdListLayout.setEnabled(true);
                                    if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.c(_fld0) != null)
                                    {
                                        com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0).weeklyAdHeaderView.a(false);
                                        com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0).weeklyAdHeaderView.a();
                                        return;
                                    }
                                }
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

                    public void onTransitionStart(Transition transition)
                    {
                        (new Handler(Looper.getMainLooper())).post(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                if (com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0) == null)
                                {
                                    return;
                                } else
                                {
                                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0).weeklyAdListLayout.setEnabled(false);
                                    com.target.ui.fragment.weekly_ad.WeeklyAdFragment.b(_fld0).weeklyAdHeaderView.c();
                                    return;
                                }
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = WeeklyAdFragment.this;
                super();
            }
        });
    }

    public void a(int i)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            c();
            return;
        }
    }

    public void a(int i, int l)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            b(i, l);
            return;
        }
    }

    public void a(Bitmap bitmap, String s)
    {
        if (getArguments() == null)
        {
            setArguments(new Bundle());
        }
        getArguments().putParcelable("thumbnail", bitmap);
        getArguments().putString("thumbnailUrl", s);
    }

    public void a(StoreSummary storesummary)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mPreviousData = b();
            mStoreSummary = storesummary;
            mStoreIdentifier = storesummary.getStoreId();
            mStoreSlug = null;
            mWeeklyAdPages = null;
            mWeeklyAdHomepage = null;
            mViews.weeklyAdHeaderView.b();
            mViews.weeklyAdHeaderView.d();
            j(mStoreSummary.getName());
            b(mStoreIdentifier);
            return;
        }
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        al.a(mViews.errorView, true);
        mViews.errorView.a(a1, flag);
    }

    public void a(String s, String s1, boolean flag)
    {
        al.a(mViews.errorView, true);
        mViews.errorView.a(s, s1, flag);
    }

    public com.target.ui.fragment.store.StoreChooserDialogFragment.d g()
    {
        return com.target.ui.fragment.store.StoreChooserDialogFragment.d.WEEKLY_AD;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(mAddToListDelegate);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mWeeklyAdDataHelper = new com.target.ui.helper.q.a();
        mStoreManager = new com.target.mothership.model.store.c();
        mPlaceholderBitmap = (Bitmap)getArguments().getParcelable("thumbnail");
        mPlaceholderImageUrl = getArguments().getString("thumbnailUrl");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        mSavedData = (WeeklyAdHomepageData)bundle.getParcelable("savedData");
        if (mSavedData == null) goto _L2; else goto _L3
_L3:
        b(mSavedData);
_L5:
        return;
_L2:
        mStoreIdentifier = (StoreIdentifier)getArguments().getParcelable("storeIdentifier");
        mStoreSummary = (StoreSummary)getArguments().getParcelable("storeSummary");
        mPromotionRequest = (PromotionRequest)getArguments().getParcelable("promotionRequest");
        if (mStoreIdentifier == null && mStoreSummary != null)
        {
            mStoreIdentifier = mStoreSummary.getStoreId();
        }
        bundle = (WeeklyAdHomepageData)getArguments().getParcelable("weeklyAdHomepageData");
        if (bundle != null)
        {
            b(bundle);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            d();
            menuinflater.inflate(0x7f120018, menu);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03008d, viewgroup, false);
        mViews = new Views(layoutinflater);
        e();
        if (mStoreIdentifier != null)
        {
            d(mStoreIdentifier);
            b(mStoreIdentifier);
        } else
        {
            h();
        }
        mSnackBar = new com.target.ui.view.common.h(getActivity());
        if (j.b())
        {
            com.target.ui.f.c.f(this);
            ((ViewGroup)layoutinflater).setTransitionGroup(true);
            if (mSavedData == null)
            {
                viewgroup = mViews.weeklyAdHeaderView;
                boolean flag;
                if (mPlaceholderBitmap != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                viewgroup.a(flag);
            }
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
        mWeeklyAdHeaderSavedState = mViews.weeklyAdHeaderView.onSaveInstanceState();
        mSavedData = b();
        mViews = null;
        mWeeklyAdDataHelper.a();
        mStoreManager.a(TAG);
    }

    public void onDetach()
    {
        super.onDetach();
        mAddToListDelegate = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756566: 
            h();
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        if (mSnackBar == null)
        {
            return;
        } else
        {
            mSnackBar.a();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (mWeeklyAdPages != null)
        {
            a(0L);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mSavedData = b();
        bundle.putParcelable("savedData", mSavedData);
    }

    public com.target.ui.fragment.product.dialog.ProductAddToListDialogFragment.b s_()
    {
        return mAddToListDelegate.s_();
    }

}
