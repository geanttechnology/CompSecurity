// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.c.a.b;
import com.pointinside.maps.Location;
import com.pointinside.model.Venue;
import com.pointinside.model.VenueFactory;
import com.pointinside.model.Zone;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.mothership.util.o;
import com.target.ui.adapter.map.BlackFridayDealProductAdapter;
import com.target.ui.analytics.a.ag;
import com.target.ui.analytics.a.ax;
import com.target.ui.analytics.a.ba;
import com.target.ui.c.d.d;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.common.BaseStoreChooserFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.map.a.a;
import com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment;
import com.target.ui.fragment.weekly_ad.WeeklyAdFragment;
import com.target.ui.helper.product.h;
import com.target.ui.model.MapDisplayableItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.model.pi_blackfriday_deals.PiBaseProduct;
import com.target.ui.model.pi_blackfriday_deals.PiBlackFridayDeal;
import com.target.ui.service.k;
import com.target.ui.service.provider.StoreProviderFactory;
import com.target.ui.service.provider.c;
import com.target.ui.service.provider.f;
import com.target.ui.service.provider.r;
import com.target.ui.util.ai;
import com.target.ui.util.aj;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.x;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.StarRatingView;
import com.target.ui.view.TargetFloatingActionButton;
import com.target.ui.view.list.ListItemMapView;
import com.target.ui.view.map.SingleGenericItemView;
import com.target.ui.view.map.StoreMapView;
import com.target.ui.view.product.ProductEyebrowView;
import com.target.ui.view.product.ProductPriceView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoreMapFragment extends BaseStoreChooserFragment
    implements com.pointinside.maps.PIMap.CameraCallback, com.pointinside.maps.PIMap.OnZoneLoadCallback, com.target.ui.adapter.map.BlackFridayDealProductAdapter.a, com.target.ui.adapter.map.a.a, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, com.target.ui.fragment.account.BaseAccountDialog.c, com.target.ui.fragment.map.a.a, com.target.ui.fragment.map.a.b.a, com.target.ui.fragment.map.a.b.c, com.target.ui.fragment.map.a.b.d, com.target.ui.fragment.map.a.b.e, com.target.ui.fragment.map.a.b.f, com.target.ui.fragment.map.a.b.g, com.target.ui.fragment.request_team_member.RequestTeamMemberDialogFragment.a, com.target.ui.view.list.ListItemMapView.a, com.target.ui.view.map.StoreMapView.b, com.target.ui.view.map.ZoneSelectionView.c
{
    static class Views extends com.target.ui.view.a
    {

        ListView blackFridayDealProductListView;
        RecyclerView blackFridayDealRecyclerView;
        View divider;
        ProductEyebrowView eyebrow;
        BitmapImageView image;
        ListItemMapView mListItemView;
        View mapContent;
        ProductPriceView price;
        View productDetailArea;
        View productDetailView;
        StarRatingView rating;
        Button selectStoreButton;
        View selectStoreView;
        SingleGenericItemView singleGenericItemView;
        StoreMapView storeMapView;
        TargetFloatingActionButton targetFloatingLocationButton;
        TextView title;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void d();
    }


    public static final String ARG_DEAL_TYPE = "dealType";
    public static final String ARG_DISPLAY_GENERIC_PRODUCT = "displayGenericProduct";
    public static final String ARG_DISPLAY_PRODUCT = "displayProduct";
    public static final String ARG_LIST_DETAIL_ITEM = "listDetailItem";
    public static final String ARG_LIST_DETAIL_ITEMS = "listDetailItems";
    public static final String ARG_LIST_SUMMARY = "listSummary";
    public static final String ARG_NO_PRODUCTS_MODE = "noProductMode";
    public static final String ARG_STORE = "store";
    public static final String ARG_WEEKLY_AD_CODE = "weeklyAdCode";
    public static final String TRANSITION_TAG = "findMapFragmentTransition";
    private String mDealType;
    private com.target.ui.adapter.map.a mDealsAdapter;
    private List mDetailItems;
    private boolean mIsBackPressing;
    private ListSummary mListSummary;
    private a mListener;
    private Menu mMenu;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private boolean mNoProductsMode;
    private com.target.ui.l.a mPreferenceManager;
    private ProductDetails mProduct;
    private String mProductTitle;
    private int mSelectedDetailItemPosition;
    private com.target.ui.view.common.h mSnackBar;
    private Store mStore;
    private com.target.ui.fragment.map.b.a mStoreMapPresenter;
    private Views mViews;
    private String mWeeklyAdCode;

    public StoreMapFragment()
    {
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
    }

    public static Fragment a(ListSummary listsummary, List list, Store store, ListDetailItem listdetailitem, Fragment fragment)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("listSummary", listsummary);
        bundle.putParcelableArrayList("listDetailItems", new ArrayList(list));
        bundle.putParcelable("store", store);
        bundle.putParcelable("listDetailItem", listdetailitem);
        listsummary = new StoreMapFragment();
        if (fragment != null)
        {
            listsummary.setTargetFragment(fragment, 0);
        }
        listsummary.setArguments(bundle);
        return listsummary;
    }

    public static Fragment a(Store store)
    {
        return com.c.a.b.a(new StoreMapFragment()).a("store", store).a("noProductMode", true).a();
    }

    public static StoreMapFragment a(ProductDetails productdetails, Store store)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("displayProduct", productdetails);
        bundle.putParcelable("store", store);
        productdetails = new StoreMapFragment();
        productdetails.setArguments(bundle);
        return productdetails;
    }

    public static StoreMapFragment a(String s1, Store store)
    {
        Bundle bundle = new Bundle();
        bundle.putString("displayGenericProduct", s1);
        bundle.putParcelable("store", store);
        s1 = new StoreMapFragment();
        s1.setArguments(bundle);
        return s1;
    }

    public static StoreMapFragment a(String s1, String s2, Store store)
    {
        Bundle bundle = new Bundle();
        bundle.putString("dealType", s1);
        bundle.putString("weeklyAdCode", s2);
        bundle.putParcelable("store", store);
        s1 = new StoreMapFragment();
        s1.setArguments(bundle);
        return s1;
    }

    static com.target.ui.fragment.map.b.a a(StoreMapFragment storemapfragment)
    {
        return storemapfragment.mStoreMapPresenter;
    }

    private void a(r r1, ProductDetails productdetails, String s1, ListSummary listsummary, List list, int i1, String s2, 
            String s3, a a1, com.target.ui.e.j j1, boolean flag)
    {
        com.target.ui.helper.k.a a2 = new com.target.ui.helper.k.a(new VenueFactory(getActivity()));
        listsummary = new com.target.ui.helper.j.b(listsummary);
        h h1 = new h();
        x x1 = new x(r1.a());
        f f1;
        boolean flag1;
        if (!(new c()).a().g())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        f1 = new f();
        if (s1 == null)
        {
            s1 = "";
        }
        if (list != null)
        {
            mStoreMapPresenter = new com.target.ui.fragment.map.b.a(r1, f1, list, i1, a2, h1, x1, listsummary, a1, j1, flag1, flag, null);
            return;
        }
        if (productdetails != null)
        {
            mStoreMapPresenter = new com.target.ui.fragment.map.b.a(r1, f1, productdetails, a2, h1, x1, j1, flag1, flag, null);
            return;
        }
        if (com.target.mothership.util.o.g(s2) && com.target.mothership.util.o.g(s3))
        {
            mStoreMapPresenter = new com.target.ui.fragment.map.b.a(r1, s2, s3, f1, a2, h1, x1, flag1, flag, j1, null);
            mDealsAdapter = new com.target.ui.adapter.map.a(this);
            return;
        } else
        {
            mStoreMapPresenter = new com.target.ui.fragment.map.b.a(r1, f1, s1, a2, h1, x1, j1, flag1, flag, null);
            return;
        }
    }

    private void a(List list, ListDetailItem listdetailitem)
    {
        mDetailItems = new ArrayList();
        list = list.iterator();
        int i1 = 0;
        int j1 = 0;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            ListDetailItem listdetailitem1 = (ListDetailItem)list.next();
            if (listdetailitem1.f() != null)
            {
                if (listdetailitem1.equals(listdetailitem))
                {
                    j1 = i1;
                }
                mDetailItems.add(listdetailitem1);
                i1++;
            }
        } while (true);
        mSelectedDetailItemPosition = j1;
    }

    public void A()
    {
        mViews.storeMapView.A();
    }

    public void B()
    {
        mStoreMapPresenter.B();
    }

    public void C()
    {
        mStoreMapPresenter.x();
    }

    public void D()
    {
        mStoreMapPresenter.v();
    }

    public void E()
    {
        mStoreMapPresenter.g();
    }

    public void F()
    {
        mStoreMapPresenter.h();
    }

    public void G()
    {
        mStoreMapPresenter.i();
    }

    public void H()
    {
        mStoreMapPresenter.j();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a I()
    {
        return this;
    }

    public void J()
    {
        mStoreMapPresenter.n();
    }

    public boolean R()
    {
        if (!mIsBackPressing)
        {
            mStoreMapPresenter.k();
            mIsBackPressing = true;
            mViews.storeMapView.postDelayed(new Runnable() {

                final StoreMapFragment this$0;

                public void run()
                {
                    if (getActivity() != null && !Z())
                    {
                        getActivity().onBackPressed();
                    }
                }

            
            {
                this$0 = StoreMapFragment.this;
                super();
            }
            }, 0L);
            return true;
        } else
        {
            return false;
        }
    }

    public void a()
    {
        mStoreMapPresenter.t();
    }

    public void a(float f1)
    {
        mViews.storeMapView.a(f1);
    }

    public void a(float f1, float f2)
    {
        RequestTeamMemberDialogFragment.a(this, mStore, (int)f1, (int)f2).show(getFragmentManager(), TAG);
    }

    public void a(int i1)
    {
        mViews.rating.setHalfStars(i1);
    }

    public void a(Location location, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        mViews.storeMapView.a(location, mapdisplayableitem, flag);
    }

    public void a(Location location, com.target.ui.view.DepartmentBadgeView.a a1, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        mViews.storeMapView.a(location, a1, mapdisplayableitem, flag);
    }

    public void a(Location location, String s1, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        mViews.storeMapView.a(location, s1, mapdisplayableitem, flag);
    }

    public void a(Venue venue, Zone zone)
    {
        mViews.storeMapView.a(venue, zone);
    }

    public void a(Venue venue, Zone zone, com.target.ui.fragment.map.a.b.b b1)
    {
        mViews.storeMapView.a(venue, zone, b1);
    }

    public void a(Zone zone, float f1)
    {
        mViews.storeMapView.a(zone, f1);
    }

    public void a(Zone zone, com.target.ui.fragment.map.a.b.h h1)
    {
        mViews.storeMapView.a(zone, h1);
    }

    public void a(Guest guest)
    {
    }

    public void a(ProductDetails productdetails)
    {
        com.target.ui.adapter.product.c.a(mViews.image, mViews.image.getMeasuredHeight(), productdetails);
    }

    public void a(StoreSummary storesummary)
    {
        mStore = storesummary;
        com.target.ui.service.k.a().a(storesummary.getStoreId());
        mStoreMapPresenter.a(storesummary);
    }

    public void a(WeeklyAdHomepage weeklyadhomepage)
    {
        mDealsAdapter.a(weeklyadhomepage);
    }

    public void a(d d1)
    {
        mNavigateToPdpDelegate.a(d1);
    }

    public void a(MapDisplayableItem mapdisplayableitem)
    {
        mViews.storeMapView.a(mapdisplayableitem);
    }

    public void a(ListDetailItem listdetailitem)
    {
        al.a(mViews.mListItemView, new View[] {
            mViews.productDetailView
        });
        mViews.mListItemView.a(listdetailitem, this);
        if (com.target.ui.util.j.b())
        {
            mViews.mListItemView.setTransitionName("findMapFragmentTransition");
        }
    }

    public void a(PiBaseProduct pibaseproduct, BitmapImageView bitmapimageview)
    {
        mStoreMapPresenter.a(pibaseproduct, bitmapimageview);
    }

    public void a(PiBlackFridayDeal piblackfridaydeal)
    {
        mStoreMapPresenter.a(piblackfridaydeal);
    }

    public void a(com.target.ui.view.map.ZoneSelectionView.b b1, Zone zone)
    {
        mStoreMapPresenter.a(b1, zone);
    }

    public void a(String s1)
    {
    }

    public void a(String s1, String s2, float f1, float f2, float f3, float f4, float f5, 
            boolean flag, float f6)
    {
        mViews.storeMapView.a(s1, s2, f1, f2, f3, f4, f5, flag, f6);
    }

    public void a(List list)
    {
        mDealsAdapter.a(list);
        mViews.blackFridayDealRecyclerView.setAdapter(mDealsAdapter);
        al.a(mViews.blackFridayDealRecyclerView, new View[] {
            mViews.blackFridayDealProductListView, mViews.productDetailView, mViews.mListItemView, mViews.singleGenericItemView
        });
    }

    public void a(boolean flag)
    {
        al.a(mViews.productDetailArea, flag);
    }

    public void b()
    {
        al.c(mViews.divider);
    }

    public void b(float f1)
    {
        mViews.storeMapView.b(f1);
    }

    public void b(int i1)
    {
        mViews.storeMapView.a(i1);
    }

    public void b(Location location, MapDisplayableItem mapdisplayableitem, boolean flag)
    {
        mViews.storeMapView.b(location, mapdisplayableitem, flag);
    }

    public void b(Guest guest)
    {
        if (Z())
        {
            return;
        } else
        {
            AuthenticateDialog.a(guest, this).show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void b(ProductDetails productdetails)
    {
        com.target.ui.adapter.product.c.a(mViews.price, mViews.eyebrow, productdetails);
    }

    public void b(MapDisplayableItem mapdisplayableitem)
    {
        mViews.storeMapView.b(mapdisplayableitem);
    }

    public void b(ListDetailItem listdetailitem)
    {
        mStoreMapPresenter.a(listdetailitem);
    }

    public void b(Object obj)
    {
    }

    public void b(String s1)
    {
    }

    public void b(List list)
    {
        list = new BlackFridayDealProductAdapter(getActivity(), list, this);
        mViews.blackFridayDealProductListView.setAdapter(list);
        al.a(mViews.blackFridayDealProductListView, new View[] {
            mViews.blackFridayDealRecyclerView, mViews.productDetailView, mViews.mListItemView, mViews.singleGenericItemView
        });
    }

    public void c()
    {
    }

    public void c(int i1)
    {
        mStoreMapPresenter.a(i1);
    }

    public void c(MapDisplayableItem mapdisplayableitem)
    {
        mStoreMapPresenter.a(mapdisplayableitem);
    }

    public void c(String s1)
    {
        j(s1);
    }

    public void c(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.targetFloatingLocationButton);
            mViews.targetFloatingLocationButton.setIcon(0x7f020153);
            mViews.targetFloatingLocationButton.setOnClickListener(new android.view.View.OnClickListener() {

                final StoreMapFragment this$0;

                public void onClick(View view)
                {
                    com.target.ui.fragment.map.StoreMapFragment.a(StoreMapFragment.this).f();
                }

            
            {
                this$0 = StoreMapFragment.this;
                super();
            }
            });
            return;
        } else
        {
            al.c(mViews.targetFloatingLocationButton);
            return;
        }
    }

    public void d(MapDisplayableItem mapdisplayableitem)
    {
        mStoreMapPresenter.b(mapdisplayableitem);
    }

    public void d(String s1)
    {
        mViews.title.setText(s1);
    }

    public void d(boolean flag)
    {
        mViews.storeMapView.d(flag);
    }

    public void e()
    {
        al.d(mViews.rating);
    }

    public void e(String s1)
    {
        ag.a(s1).e();
    }

    public void e(boolean flag)
    {
        MenuItem menuitem;
label0:
        {
            if (mMenu != null)
            {
                menuitem = mMenu.findItem(0x7f10060d);
                if (menuitem != null)
                {
                    break label0;
                }
            }
            return;
        }
        menuitem.setVisible(flag);
    }

    public void f()
    {
        ai.b(this, 0x7f090513);
    }

    public void f(String s1)
    {
        mViews.storeMapView.f(s1);
    }

    public void f(boolean flag)
    {
        MenuItem menuitem;
label0:
        {
            if (mMenu != null)
            {
                menuitem = mMenu.findItem(0x7f10060e);
                if (menuitem != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (flag)
        {
            menuitem.setTitle(0x7f0902ef);
        } else
        {
            menuitem.setTitle(0x7f0902f3);
        }
        menuitem.setVisible(true);
    }

    public com.target.ui.fragment.store.StoreChooserDialogFragment.d g()
    {
        return com.target.ui.fragment.store.StoreChooserDialogFragment.d.NEARBY_STORES;
    }

    public void g(boolean flag)
    {
        if (getActivity() == null || mPreferenceManager == null)
        {
            return;
        } else
        {
            mPreferenceManager.a(Boolean.valueOf(flag));
            return;
        }
    }

    public void h()
    {
        super.h();
    }

    public void h(boolean flag)
    {
        if (flag)
        {
            mViews.selectStoreButton.setOnClickListener(new android.view.View.OnClickListener() {

                final StoreMapFragment this$0;

                public void onClick(View view)
                {
                    com.target.ui.fragment.map.StoreMapFragment.a(StoreMapFragment.this).o();
                }

            
            {
                this$0 = StoreMapFragment.this;
                super();
            }
            });
            al.a(mViews.selectStoreView, new View[] {
                mViews.mapContent
            });
            return;
        } else
        {
            al.a(mViews.mapContent, new View[] {
                mViews.selectStoreView
            });
            return;
        }
    }

    public void i()
    {
        al.a(mViews.singleGenericItemView, new View[] {
            mViews.productDetailView
        });
        mViews.singleGenericItemView.setItemTitle(mProductTitle);
    }

    public void i(boolean flag)
    {
        mViews.storeMapView.a(flag);
    }

    public void j()
    {
        al.d(mViews.image);
    }

    public void j(boolean flag)
    {
        float f1;
        if (flag)
        {
            f1 = 0.5F;
        } else
        {
            f1 = 1.0F;
        }
        aj.a(mViews.productDetailView, f1);
        mViews.storeMapView.j(flag);
    }

    public void k()
    {
        ba.a(a(V()), this);
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return I();
    }

    public void n_()
    {
    }

    public void o()
    {
        R();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mStoreMapPresenter.c();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
        a(mNavigateToPdpDelegate);
    }

    public void onCameraSet()
    {
        mStoreMapPresenter.u();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getArguments() != null)
        {
            mProduct = (ProductDetails)getArguments().getParcelable("displayProduct");
            mListSummary = (ListSummary)getArguments().getParcelable("listSummary");
            mProductTitle = getArguments().getString("displayGenericProduct");
            mStore = (Store)getArguments().getParcelable("store");
            bundle = getArguments().getParcelableArrayList("listDetailItems");
            ListDetailItem listdetailitem = (ListDetailItem)getArguments().getParcelable("listDetailItem");
            mDealType = getArguments().getString("dealType");
            mWeeklyAdCode = getArguments().getString("weeklyAdCode");
            mNoProductsMode = getArguments().getBoolean("noProductMode");
            if (bundle != null && listdetailitem != null)
            {
                a(bundle, listdetailitem);
            }
        }
        try
        {
            bundle = (com.target.ui.e.j)getActivity();
            mPreferenceManager = com.target.ui.l.a.a();
            r r1 = (new StoreProviderFactory(getActivity())).a(mStore);
            boolean flag = mPreferenceManager.c();
            a(r1, mProduct, mProductTitle, mListSummary, mDetailItems, mSelectedDetailItemPosition, mDealType, mWeeklyAdCode, mListener, bundle, flag);
            mStoreMapPresenter.a(mNoProductsMode);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new ClassCastException((new StringBuilder()).append("Activity must implement ").append(com/target/ui/e/j.getSimpleName()).toString());
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            b(false);
            menuinflater.inflate(0x7f120010, menu);
            mMenu = menu;
            mStoreMapPresenter.a(menu, menuinflater);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030063, viewgroup, false);
        mViews = new Views(layoutinflater);
        mSnackBar = new com.target.ui.view.common.h(getActivity());
        mViews.storeMapView.setOnZoneLoadCallback(this);
        mViews.storeMapView.setOnMapProductClickListener(this);
        mViews.storeMapView.setCameraCallback(this);
        mViews.storeMapView.setOnMapDragListener(this);
        mViews.storeMapView.setOnMarkerOffScreenListener(this);
        mViews.storeMapView.setZoneSelectorStateListener(this);
        mViews.storeMapView.setOnDirectionArrowClickListener(this);
        mViews.storeMapView.setOnGuestLocationNotAvailableListener(this);
        mViews.storeMapView.setOnZoomedToMarkerListener(this);
        mViews.storeMapView.setOnCameraMoveListener(this);
        mStoreMapPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mStoreMapPresenter.z_();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mNavigateToPdpDelegate = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756558: 
            mStoreMapPresenter.l();
            return true;

        case 2131756557: 
            mStoreMapPresenter.m();
            return true;
        }
    }

    public void onPause()
    {
        super.onPause();
        mStoreMapPresenter.e();
        if (mViews != null)
        {
            mViews.storeMapView.a();
            mSnackBar.a();
        }
    }

    public void onResume()
    {
        super.onResume();
        mStoreMapPresenter.d();
        if (mViews != null)
        {
            mViews.storeMapView.b();
        }
    }

    public void p()
    {
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(0x7f090525), getString(0x7f090526)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void postZoneLoad(String s1, int i1, int j1)
    {
        mStoreMapPresenter.postZoneLoad(s1, i1, j1);
    }

    public void preZoneLoad(String s1, int i1, int j1)
    {
        mStoreMapPresenter.preZoneLoad(s1, i1, j1);
    }

    public void q()
    {
        mViews.storeMapView.q();
    }

    public void r()
    {
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(getActivity(), 0, false);
        mViews.blackFridayDealRecyclerView.setLayoutManager(linearlayoutmanager);
        mViews.blackFridayDealRecyclerView.setHasFixedSize(true);
    }

    public void s()
    {
        if (Z())
        {
            return;
        } else
        {
            Object obj = new PromotionRequest(new PromotionSlug(mWeeklyAdCode));
            obj = WeeklyAdFragment.a(mStore.getStoreId(), ((PromotionRequest) (obj)));
            m().d(((Fragment) (obj)));
            return;
        }
    }

    public void setMarkersSelectable(boolean flag)
    {
        mViews.storeMapView.setMarkersSelectable(flag);
    }

    public void setSelectedMarker(MapDisplayableItem mapdisplayableitem)
    {
        mViews.storeMapView.setSelectedMarker(mapdisplayableitem);
    }

    public void t()
    {
        ax.j().e();
    }

    public void u()
    {
        mViews.storeMapView.u();
    }

    public void v()
    {
        ai.b(this, 0x7f0903b7);
    }

    public void w()
    {
        ai.b(this, 0x7f090507);
    }

    public void x()
    {
        mViews.storeMapView.x();
    }

    public void y()
    {
        mViews.storeMapView.y();
    }

    public void z()
    {
        mViews.storeMapView.z();
    }
}
