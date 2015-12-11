// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.map.b;

import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.pointinside.maps.Location;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.mothership.common.weeklyad.PromotionSlug;
import com.target.mothership.common.weeklyad.StoreSlug;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductGuestReview;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdHomepage;
import com.target.ui.c.d.d;
import com.target.ui.e.i;
import com.target.ui.helper.j.b;
import com.target.ui.helper.product.h;
import com.target.ui.model.BlackFridayDealDetails;
import com.target.ui.model.MapDisplayableItem;
import com.target.ui.model.list.ListDetailItem;
import com.target.ui.model.pi_blackfriday_deals.PiBaseProduct;
import com.target.ui.model.pi_blackfriday_deals.PiBlackFridayDeal;
import com.target.ui.service.j;
import com.target.ui.service.provider.m;
import com.target.ui.service.provider.r;
import com.target.ui.util.x;
import com.target.ui.view.BitmapImageView;
import com.target.ui.vlc.c;
import com.target.ui.vlc.model.VlcPositionInfo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class a
    implements com.pointinside.maps.PIMap.OnZoneLoadCallback, com.target.ui.fragment.map.a.b.b, com.target.ui.g.a, com.target.ui.helper.j.b.k, com.target.ui.helper.k.a, com.target.ui.helper.product.h.a, com.target.ui.helper.q.a, com.target.ui.service.i.a, com.target.ui.util.x.a, com.target.ui.view.map.ZoneSelectionView.c, c
{

    private static final float BLE_ACCURACY_METERS = 3F;
    static final int CENTERED_ON_SELECTED_MARKER = 0;
    private static final int DEALS = 3;
    static final int FOLLOW_ME = 1;
    static final int FREE = 2;
    private static final long INITIAL_ZOOM_TO_PIN_DELAY_MILLISECONDS = 3000L;
    private static final int LAST_KNOWN_POSITION_TIMEOUT = 5000;
    private static final int LIST_ITEM = 0;
    private static final float MAX_BLUE_DOT_SIZE_METERS = 10F;
    private static final float MIN_BLUE_DOT_SIZE_METERS = 3F;
    static final int POSITION_NOT_AVAILABLE = -1;
    private static final int SINGLE_GENERIC_PRODUCT = 2;
    private static final int SINGLE_PRODUCT = 1;
    static final int TIME_NOT_AVAILABLE = -1;
    private static final float ZOOMED_IN_LEVEL = 2F;
    private static final float ZOOMED_NORMAL_LEVEL = 1F;
    private List mBlackFridayDealList;
    private boolean mCameraMovingToBlueDot;
    private String mDealType;
    private List mDetailItems;
    private final int mDisplayType;
    private m mGuestProvider;
    private boolean mIsUsingNoProductsMode;
    private float mLastKnownPixelX;
    private float mLastKnownPixelY;
    private long mLastKnownTime;
    private b mListDetailDataHelper;
    private com.target.ui.fragment.map.StoreMapFragment.a mListItemCompletedListener;
    private boolean mMapLoaded;
    private int mMode;
    private x mPIMapLoader;
    private List mPendingMapDisplayableItems;
    private com.target.ui.vlc.a mPositionSmoother;
    private ProductDetails mProduct;
    private String mProductTitle;
    private ListDetailItem mSelectedListDetailItem;
    private com.target.ui.fragment.map.a.b.h mShowZoneFinishedListener = new com.target.ui.fragment.map.a.b.h() {

        final a this$0;

        public void a()
        {
            a.a(a.this, 1.0F);
        }

            
            {
                this$0 = a.this;
                super();
            }
    };
    private Store mStore;
    private h mStoreDataHelper;
    private com.target.ui.fragment.map.a.a mStoreMapContainerPresentation;
    private StoreSummary mStoreSummary;
    private Venue mVenue;
    private com.target.ui.helper.k.a mVenueDataHelper;
    private boolean mVlcFeatureEnabled;
    private boolean mVlcLoaded;
    private i mVlcManagerWrapper;
    private com.target.ui.e.j mVlcManagerWrapperProvider;
    private boolean mVlcPreferenceEnabled;
    private String mWeeklyAdCode;
    private Zone mZone;
    private boolean mZoneCurrentlyLoading;

    public a(r r1, m m1, ProductDetails productdetails, com.target.ui.helper.k.a a1, h h1, x x1, com.target.ui.e.j j1, 
            boolean flag, boolean flag1, com.target.ui.vlc.a a2)
    {
        mLastKnownPixelX = -1F;
        mLastKnownPixelY = -1F;
        mLastKnownTime = -1L;
        mPendingMapDisplayableItems = new ArrayList();
        mMode = 2;
        a(r1, m1, a1, h1, x1, j1, flag1, flag, a2);
        mProduct = productdetails;
        mDisplayType = 1;
    }

    public a(r r1, m m1, String s1, com.target.ui.helper.k.a a1, h h1, x x1, com.target.ui.e.j j1, 
            boolean flag, boolean flag1, com.target.ui.vlc.a a2)
    {
        mLastKnownPixelX = -1F;
        mLastKnownPixelY = -1F;
        mLastKnownTime = -1L;
        mPendingMapDisplayableItems = new ArrayList();
        mMode = 2;
        a(r1, m1, a1, h1, x1, j1, flag1, flag, a2);
        mProductTitle = s1;
        mDisplayType = 2;
    }

    public a(r r1, m m1, List list, int i1, com.target.ui.helper.k.a a1, h h1, x x1, 
            b b1, com.target.ui.fragment.map.StoreMapFragment.a a2, com.target.ui.e.j j1, boolean flag, boolean flag1, com.target.ui.vlc.a a3)
    {
        mLastKnownPixelX = -1F;
        mLastKnownPixelY = -1F;
        mLastKnownTime = -1L;
        mPendingMapDisplayableItems = new ArrayList();
        mMode = 2;
        a(r1, m1, a1, h1, x1, j1, flag1, flag, a3);
        mDetailItems = list;
        mSelectedListDetailItem = (ListDetailItem)list.get(i1);
        mListDetailDataHelper = b1;
        mListItemCompletedListener = a2;
        mDisplayType = 0;
    }

    public a(r r1, String s1, String s2, m m1, com.target.ui.helper.k.a a1, h h1, x x1, 
            boolean flag, boolean flag1, com.target.ui.e.j j1, com.target.ui.vlc.a a2)
    {
        mLastKnownPixelX = -1F;
        mLastKnownPixelY = -1F;
        mLastKnownTime = -1L;
        mPendingMapDisplayableItems = new ArrayList();
        mMode = 2;
        a(r1, m1, a1, h1, x1, j1, flag1, flag, a2);
        mDealType = s1;
        mWeeklyAdCode = s2;
        mDisplayType = 3;
    }

    private void A()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.d(true);
            mVenueDataHelper.a(this, mStore.getStoreId().a());
            return;
        }
    }

    private void C()
    {
        com.target.ui.fragment.map.a.a a1 = mStoreMapContainerPresentation;
        boolean flag;
        if (!mIsUsingNoProductsMode)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1.a(flag);
        mStoreMapContainerPresentation.d(true);
        mPIMapLoader.a(this);
    }

    private void D()
    {
        z();
        E();
    }

    private void E()
    {
        (new Handler()).postDelayed(new Runnable() {

            final a this$0;

            public void run()
            {
                Object obj = a.a(a.this, com.target.ui.fragment.map.b.a.e(a.this));
                if (((e) (obj)).b())
                {
                    obj = (MapDisplayableItem)((e) (obj)).c();
                    a.a(a.this, ((MapDisplayableItem) (obj)));
                }
            }

            
            {
                this$0 = a.this;
                super();
            }
        }, 3000L);
    }

    private void F()
    {
        mStoreMapContainerPresentation.z();
        mStoreMapContainerPresentation.o();
    }

    static int a(a a1, int i1)
    {
        a1.mMode = i1;
        return i1;
    }

    static e a(a a1, ListDetailItem listdetailitem)
    {
        return a1.b(listdetailitem);
    }

    static Zone a(a a1, Zone zone)
    {
        a1.mZone = zone;
        return zone;
    }

    static com.target.ui.fragment.map.StoreMapFragment.a a(a a1)
    {
        return a1.mListItemCompletedListener;
    }

    private void a(float f1)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.a(f1);
            return;
        }
    }

    private void a(int i1, boolean flag)
    {
        Object obj1;
label0:
        {
            int j1 = mDetailItems.size();
            mSelectedListDetailItem = (ListDetailItem)mDetailItems.get(i1 % j1);
            Object obj = b(mSelectedListDetailItem);
            if (((e) (obj)).b())
            {
                obj1 = (MapDisplayableItem)((e) (obj)).c();
                mSelectedListDetailItem.d(false);
                obj = ((MapDisplayableItem) (obj1)).b();
                mStoreMapContainerPresentation.setSelectedMarker(((MapDisplayableItem) (obj1)));
                mStoreMapContainerPresentation.a(mSelectedListDetailItem);
                if (obj != null && mZone != null && mVenue != null && flag)
                {
                    obj1 = mVenue.findZoneByUUID(((Location) (obj)).zone);
                    mMode = 2;
                    if (mZoneCurrentlyLoading || !mZone.getUUID().equals(((Location) (obj)).zone))
                    {
                        break label0;
                    }
                    a(2.0F);
                }
            }
            return;
        }
        a(((Zone) (obj1)), mShowZoneFinishedListener);
    }

    private void a(final Zone zone, final com.target.ui.fragment.map.a.b.h listener)
    {
        if (mZoneCurrentlyLoading)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.i(false);
            mZoneCurrentlyLoading = true;
            mStoreMapContainerPresentation.a(zone, new com.target.ui.fragment.map.a.b.h() {

                final a this$0;
                final com.target.ui.fragment.map.a.b.h val$listener;
                final Zone val$zone;

                public void a()
                {
                    a.a(a.this, false);
                    if (com.target.ui.fragment.map.b.a.b(a.this) != null)
                    {
                        com.target.ui.fragment.map.b.a.b(a.this).i(true);
                        a.a(a.this, zone);
                        com.target.ui.fragment.map.b.a.b(a.this).a(a.f(a.this), a.g(a.this));
                        if (listener != null)
                        {
                            listener.a();
                            return;
                        }
                    }
                }

            
            {
                this$0 = a.this;
                zone = zone1;
                listener = h1;
                super();
            }
            });
            return;
        }
    }

    private void a(ProductDetails productdetails)
    {
        mStoreMapContainerPresentation.a(productdetails);
        mStoreMapContainerPresentation.b(productdetails);
        mStoreMapContainerPresentation.d(productdetails.g());
        productdetails = productdetails.j();
        if (productdetails.b())
        {
            mStoreMapContainerPresentation.a(((ProductGuestReview)productdetails.c()).a().multiply(new BigDecimal(2)).intValue());
        }
    }

    private void a(Store store, String s1)
    {
        mStoreMapContainerPresentation.d(true);
        (new j()).a(store, s1, this);
        store = new PromotionRequest(new PromotionSlug(mWeeklyAdCode));
        (new com.target.ui.helper.q.a()).a(mStore.getStoreId(), store, this);
    }

    static void a(a a1, float f1)
    {
        a1.a(f1);
    }

    static void a(a a1, int i1, boolean flag)
    {
        a1.a(i1, flag);
    }

    static void a(a a1, MapDisplayableItem mapdisplayableitem)
    {
        a1.f(mapdisplayableitem);
    }

    private void a(r r1, m m1, com.target.ui.helper.k.a a1, h h1, x x1, com.target.ui.e.j j1, boolean flag, 
            boolean flag1, com.target.ui.vlc.a a2)
    {
        mStore = r1.a();
        mGuestProvider = m1;
        mVenueDataHelper = a1;
        mPIMapLoader = x1;
        mVlcManagerWrapperProvider = j1;
        mStoreDataHelper = h1;
        mVlcPreferenceEnabled = flag;
        mVlcFeatureEnabled = flag1;
        mPositionSmoother = a2;
    }

    private void a(String s1)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mPIMapLoader.a(Arrays.asList(new String[] {
                s1
            }));
            C();
            return;
        }
    }

    private boolean a(Guest guest, RelevantStoreSummary relevantstoresummary)
    {
        return guest != null && !guest.isAnonymous() && relevantstoresummary.hasRequestATeamMember() && relevantstoresummary.a();
    }

    static boolean a(a a1, boolean flag)
    {
        a1.mZoneCurrentlyLoading = flag;
        return flag;
    }

    private boolean a(com.target.ui.util.f.a.a a1)
    {
        return a1 != null && a1.mAisle != null && com.target.ui.util.f.a.a.FOUND_AISLE.equals(a1.mLocationLookupStatus);
    }

    private boolean a(com.target.ui.view.DepartmentBadgeView.a a1)
    {
        return com.target.ui.view.DepartmentBadgeView.a.UNKNOWN != a1;
    }

    private e b(ListDetailItem listdetailitem)
    {
        if (listdetailitem == null)
        {
            return com.google.a.a.e.e();
        }
        Location location = listdetailitem.f();
        if (location == null)
        {
            return com.google.a.a.e.e();
        } else
        {
            MapDisplayableItem mapdisplayableitem = new MapDisplayableItem();
            mapdisplayableitem.a(listdetailitem);
            mapdisplayableitem.a(location);
            return com.google.a.a.e.c(mapdisplayableitem);
        }
    }

    static com.target.ui.fragment.map.a.a b(a a1)
    {
        return a1.mStoreMapContainerPresentation;
    }

    private void b(ProductDetails productdetails)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mPIMapLoader.b(Arrays.asList(new ProductDetails[] {
                productdetails
            }));
            C();
            return;
        }
    }

    private boolean b(com.target.ui.util.f.a.a a1)
    {
        if (a1 != null && a1.mDepartment != null)
        {
            com.target.ui.view.DepartmentBadgeView.a a2 = com.target.ui.util.f.a.a(a1.mDepartment);
            if (com.target.ui.util.f.a.a.FOUND_KNOWN_DEPARTMENT.equals(a1.mLocationLookupStatus) && !com.target.ui.view.DepartmentBadgeView.a.UNKNOWN.equals(a2))
            {
                return true;
            }
        }
        return false;
    }

    static List c(a a1)
    {
        return a1.mDetailItems;
    }

    private void c(MapDisplayableItem mapdisplayableitem)
    {
        if (mapdisplayableitem.e().b())
        {
            d(mapdisplayableitem);
            return;
        }
        Location location = mapdisplayableitem.b();
        Object obj = e(mapdisplayableitem);
        com.target.ui.view.DepartmentBadgeView.a a1;
        e e1;
        boolean flag;
        if (mSelectedListDetailItem != null && mapdisplayableitem.d().b() && mSelectedListDetailItem.equals(mapdisplayableitem.d().c()) || mProduct != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a1 = com.target.ui.util.f.a.c(location);
        e1 = com.target.ui.util.f.a.b(location);
        if (e1.b())
        {
            mStoreMapContainerPresentation.a(location, (String)e1.c(), mapdisplayableitem, flag);
            return;
        }
        if (a(((com.target.ui.util.f.a.a) (obj))))
        {
            mStoreMapContainerPresentation.a(location, ((com.target.ui.util.f.a.a) (obj)).mAisle, mapdisplayableitem, flag);
            return;
        }
        if (b(((com.target.ui.util.f.a.a) (obj))))
        {
            obj = com.target.ui.util.f.a.a(((com.target.ui.util.f.a.a) (obj)).mDepartment);
            mStoreMapContainerPresentation.a(location, ((com.target.ui.view.DepartmentBadgeView.a) (obj)), mapdisplayableitem, flag);
            return;
        }
        if (a(a1))
        {
            mStoreMapContainerPresentation.a(location, a1, mapdisplayableitem, flag);
            return;
        } else
        {
            mStoreMapContainerPresentation.a(location, mapdisplayableitem, flag);
            return;
        }
    }

    private void c(List list)
    {
        if (mStoreMapContainerPresentation != null)
        {
            A();
            if (list.isEmpty() || ((MapDisplayableItem)list.get(0)).b() == null)
            {
                if (!mIsUsingNoProductsMode)
                {
                    mStoreMapContainerPresentation.v();
                    return;
                }
            } else
            {
                MapDisplayableItem mapdisplayableitem = (MapDisplayableItem)list.get(0);
                if (mapdisplayableitem.c().b() && mDisplayType != 0)
                {
                    a((ProductDetails)mapdisplayableitem.c().c());
                }
                e(list);
                return;
            }
        }
    }

    static void d(a a1)
    {
        a1.F();
    }

    private void d(MapDisplayableItem mapdisplayableitem)
    {
        Location location = mapdisplayableitem.b();
        mStoreMapContainerPresentation.b(location, mapdisplayableitem, false);
    }

    private void d(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (int i1 = 0; i1 < list.size(); i1++)
        {
            e e1 = b((ListDetailItem)list.get(i1));
            if (e1.b())
            {
                arraylist.add(e1.c());
            }
        }

        mPendingMapDisplayableItems.addAll(arraylist);
        list = b(mSelectedListDetailItem);
        if (mMapLoaded && list.b())
        {
            D();
        }
    }

    static ListDetailItem e(a a1)
    {
        return a1.mSelectedListDetailItem;
    }

    private com.target.ui.util.f.a.a e(MapDisplayableItem mapdisplayableitem)
    {
        if (!com.target.ui.util.f.a.b(mapdisplayableitem.b()).b() && mapdisplayableitem.c().b())
        {
            return com.target.ui.util.f.a.a((ProductDetails)mapdisplayableitem.c().c());
        } else
        {
            return null;
        }
    }

    private void e(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            MapDisplayableItem mapdisplayableitem = (MapDisplayableItem)list.next();
            if (mapdisplayableitem.b() != null)
            {
                mPendingMapDisplayableItems.add(mapdisplayableitem);
            }
        } while (true);
        list = b(mSelectedListDetailItem);
        if (mMapLoaded && list.b())
        {
            D();
        } else
        if (mPendingMapDisplayableItems != null && !mPendingMapDisplayableItems.isEmpty())
        {
            E();
            return;
        }
    }

    static Venue f(a a1)
    {
        return a1.mVenue;
    }

    private void f(MapDisplayableItem mapdisplayableitem)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        }
        mStoreMapContainerPresentation.setSelectedMarker(mapdisplayableitem);
        if (mDisplayType != 0) goto _L2; else goto _L1
_L1:
        if (mapdisplayableitem.d().b())
        {
            mSelectedListDetailItem = (ListDetailItem)mapdisplayableitem.d().c();
            mStoreMapContainerPresentation.a(mSelectedListDetailItem);
            mStoreMapContainerPresentation.j();
            mStoreMapContainerPresentation.e();
        }
_L4:
        a(2.0F);
        return;
_L2:
        if (mDisplayType == 3)
        {
            h(mapdisplayableitem);
        } else
        if (mapdisplayableitem.c().b())
        {
            a((ProductDetails)mapdisplayableitem.c().c());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static Zone g(a a1)
    {
        return a1.mZone;
    }

    private void g(MapDisplayableItem mapdisplayableitem)
    {
        while (mStoreMapContainerPresentation == null || mDisplayType != 3) 
        {
            return;
        }
        mStoreMapContainerPresentation.c(((RelevantStoreSummary)mStore).getName());
        mStoreMapContainerPresentation.a(mZone, 1.0F);
        mStoreMapContainerPresentation.b(mapdisplayableitem);
        mStoreMapContainerPresentation.a(mBlackFridayDealList);
    }

    private void h(MapDisplayableItem mapdisplayableitem)
    {
        if (mapdisplayableitem.e().b())
        {
            BlackFridayDealDetails blackfridaydealdetails = (BlackFridayDealDetails)mapdisplayableitem.e().c();
            mStoreMapContainerPresentation.c(mapdisplayableitem.a());
            mStoreMapContainerPresentation.b(blackfridaydealdetails.b());
            mStoreMapContainerPresentation.e(mapdisplayableitem.a());
        }
    }

    private void z()
    {
        mStoreMapContainerPresentation.A();
        for (Iterator iterator = mPendingMapDisplayableItems.iterator(); iterator.hasNext(); c((MapDisplayableItem)iterator.next())) { }
        mPendingMapDisplayableItems.clear();
        mStoreMapContainerPresentation.u();
    }

    public void B()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.j(true);
            return;
        }
    }

    public void a(int i1)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        }
        if (mMode == 1)
        {
            mStoreMapContainerPresentation.b(i1);
            return;
        } else
        {
            mStoreMapContainerPresentation.b(4);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mStoreMapContainerPresentation.c("");
        mStoreDataHelper.a(mStore, this);
        if (mVlcManagerWrapper != null && mVlcManagerWrapper.b())
        {
            mStoreMapContainerPresentation.f(mVlcPreferenceEnabled);
        }
    }

    public void a(Venue venue)
    {
        if (mStoreMapContainerPresentation != null)
        {
            mVenue = venue;
            mZone = (Zone)mVenue.getAllZones().get(0);
            e e1 = b(mSelectedListDetailItem);
            venue = null;
            if (e1.b())
            {
                venue = ((MapDisplayableItem)e1.c()).b();
            } else
            if (!mPendingMapDisplayableItems.isEmpty())
            {
                venue = ((MapDisplayableItem)mPendingMapDisplayableItems.get(0)).b();
            }
            if (venue != null && ((Location) (venue)).zone != null)
            {
                venue = mVenue.findZoneByUUID(((Location) (venue)).zone);
                if (venue != null)
                {
                    mZone = venue;
                }
            }
            mStoreMapContainerPresentation.d(false);
            mStoreMapContainerPresentation.a(mVenue, mZone, this);
            mStoreMapContainerPresentation.a(mVenue, mZone);
            mStoreMapContainerPresentation.k();
            if (mPendingMapDisplayableItems != null && !mPendingMapDisplayableItems.isEmpty() && e1.b())
            {
                D();
                return;
            }
        }
    }

    public void a(ListItem listitem)
    {
    }

    public void a(RelevantStoreSummary relevantstoresummary)
    {
        if (mStoreMapContainerPresentation == null || relevantstoresummary == null)
        {
            return;
        } else
        {
            mStoreSummary = relevantstoresummary;
            mStoreMapContainerPresentation.c(relevantstoresummary.getName());
            mStoreMapContainerPresentation.e(a(mGuestProvider.a(), relevantstoresummary));
            return;
        }
    }

    public void a(StoreSummary storesummary)
    {
        mStore = storesummary;
        mStoreDataHelper.a(storesummary, this);
        mStoreMapContainerPresentation.h(false);
        mPIMapLoader = new x(mStore);
        if (mDisplayType == 3)
        {
            a(mStore, mDealType);
        }
    }

    public void a(WeeklyAdHomepage weeklyadhomepage, StoreSlug storeslug)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.a(weeklyadhomepage);
            return;
        }
    }

    public void a(com.target.mothership.model.weeklyad.interfaces.a.b b1)
    {
    }

    public void a(com.target.mothership.services.x x1)
    {
    }

    public void a(com.target.ui.fragment.map.a.a a1)
    {
        mStoreMapContainerPresentation = a1;
        switch (mDisplayType)
        {
        default:
            return;

        case 3: // '\003'
            mStoreMapContainerPresentation.b();
            mStoreMapContainerPresentation.r();
            if (mStore == null)
            {
                mStoreMapContainerPresentation.d(false);
                mStoreMapContainerPresentation.h();
                return;
            } else
            {
                a(mStore, mDealType);
                return;
            }

        case 0: // '\0'
            d(mDetailItems);
            mStoreMapContainerPresentation.setMarkersSelectable(true);
            mStoreMapContainerPresentation.a(mSelectedListDetailItem);
            A();
            return;

        case 1: // '\001'
            b(mProduct);
            return;

        case 2: // '\002'
            a(mProductTitle);
            mStoreMapContainerPresentation.i();
            return;
        }
    }

    public void a(com.target.ui.helper.j.b.n n1, String s1)
    {
    }

    public void a(MapDisplayableItem mapdisplayableitem)
    {
        f(mapdisplayableitem);
    }

    public void a(final ListDetailItem listDetailItem)
    {
        if (!mMapLoaded)
        {
            listDetailItem.d(false);
            if (mStoreMapContainerPresentation != null)
            {
                mStoreMapContainerPresentation.a(listDetailItem);
            }
            return;
        } else
        {
            mListDetailDataHelper.a(listDetailItem, new com.target.ui.helper.j.b.j() {

                final a this$0;
                final ListDetailItem val$listDetailItem;

                public void a(com.target.ui.helper.j.b.n n1, String s1)
                {
                    if (com.target.ui.fragment.map.b.a.b(a.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.map.b.a.b(a.this).f();
                        return;
                    }
                }

                public void a(List list, ListSummary listsummary)
                {
                    if (a.a(a.this) != null)
                    {
                        a.a(a.this).d();
                    }
                    if (com.target.ui.fragment.map.b.a.b(a.this) == null)
                    {
                        return;
                    }
                    list = a.a(a.this, listDetailItem);
                    if (list.b())
                    {
                        com.target.ui.fragment.map.b.a.b(a.this).a((MapDisplayableItem)list.c());
                    }
                    int i1 = com.target.ui.fragment.map.b.a.c(a.this).indexOf(listDetailItem);
                    com.target.ui.fragment.map.b.a.c(a.this).remove(listDetailItem);
                    a.a(a.this, 2);
                    if (com.target.ui.fragment.map.b.a.c(a.this).isEmpty())
                    {
                        com.target.ui.fragment.map.b.a.d(a.this);
                        return;
                    } else
                    {
                        a.a(a.this, i1, true);
                        return;
                    }
                }

            
            {
                this$0 = a.this;
                listDetailItem = listdetailitem;
                super();
            }
            });
            return;
        }
    }

    public void a(PiBaseProduct pibaseproduct, BitmapImageView bitmapimageview)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            pibaseproduct = new d(pibaseproduct.b(), pibaseproduct.c());
            pibaseproduct.a(bitmapimageview);
            pibaseproduct.a(mStore);
            mStoreMapContainerPresentation.a(pibaseproduct);
            return;
        }
    }

    public void a(PiBlackFridayDeal piblackfridaydeal)
    {
        a((new com.target.ui.util.r()).a(piblackfridaydeal));
        mStoreMapContainerPresentation.b(piblackfridaydeal.f());
        mStoreMapContainerPresentation.e(piblackfridaydeal.b());
    }

    public void a(com.target.ui.view.map.ZoneSelectionView.b b1, Zone zone)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        }
        mZone = zone;
        if (!com.target.ui.view.map.ZoneSelectionView.b.NO_CHANGE.equals(b1))
        {
            a(zone, ((com.target.ui.fragment.map.a.b.h) (null)));
        }
        mStoreMapContainerPresentation.j(false);
    }

    public void a(VlcPositionInfo vlcpositioninfo)
    {
        float f1;
        boolean flag1;
        f1 = 3F;
        flag1 = false;
        break MISSING_BLOCK_LABEL_6;
        if (mMapLoaded && !mCameraMovingToBlueDot && mStoreMapContainerPresentation != null && mVenue != null && mZone != null)
        {
            if (!mZone.getUUID().equals(vlcpositioninfo.g()))
            {
                mStoreMapContainerPresentation.c(false);
                mVlcLoaded = false;
                mMode = 2;
                return;
            }
            float f2 = vlcpositioninfo.a();
            float f3 = vlcpositioninfo.b();
            float f4;
            float f5;
            float f6;
            Object obj;
            String s1;
            String s2;
            boolean flag;
            if (vlcpositioninfo.e() < 3F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                f1 = 10F;
            }
            obj = mZone.getMetersPerMapUnit();
            f2 /= ((PointF) (obj)).x;
            f3 /= ((PointF) (obj)).y;
            mLastKnownPixelX = f2;
            mLastKnownPixelY = f3;
            mLastKnownTime = vlcpositioninfo.f().longValue();
            f4 = f1 / Math.min(((PointF) (obj)).x, ((PointF) (obj)).y);
            if (flag)
            {
                f1 = 2.0F;
            } else
            {
                f1 = 1.0F;
            }
            if (mMode != 1)
            {
                f1 = 1.0F;
            } else
            {
                mCameraMovingToBlueDot = true;
            }
            obj = mStoreMapContainerPresentation;
            s1 = mVenue.getUUID();
            s2 = mZone.getUUID();
            f5 = vlcpositioninfo.c();
            f6 = -vlcpositioninfo.d();
            if (mMode == 1)
            {
                flag1 = true;
            }
            ((com.target.ui.fragment.map.a.a) (obj)).a(s1, s2, f2, f3, f5, f4, f6, flag1, f1);
            if (!mVlcLoaded)
            {
                mStoreMapContainerPresentation.c(true);
                mVlcLoaded = true;
                return;
            }
        }
        return;
    }

    public void a(Exception exception)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            A();
            mStoreMapContainerPresentation.w();
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.map.a.a)obj);
    }

    public void a(String s1, String s2)
    {
        if (mVlcManagerWrapper == null)
        {
            return;
        } else
        {
            s1 = new com.target.ui.vlc.model.a(s1, s2);
            mVlcManagerWrapper.a(this);
            mVlcManagerWrapper.a(new com.target.ui.vlc.d(Build.DEVICE, s1));
            return;
        }
    }

    public void a(Throwable throwable)
    {
        if (mStoreMapContainerPresentation != null)
        {
            mStoreMapContainerPresentation.d(false);
            mPendingMapDisplayableItems.clear();
            if (!mIsUsingNoProductsMode)
            {
                mStoreMapContainerPresentation.v();
                return;
            }
        }
    }

    public void a(List list)
    {
        c(list);
    }

    public void a(boolean flag)
    {
        mIsUsingNoProductsMode = flag;
    }

    public void b(MapDisplayableItem mapdisplayableitem)
    {
        g(mapdisplayableitem);
    }

    public void b(List list)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mBlackFridayDealList = list;
            mStoreMapContainerPresentation.setMarkersSelectable(true);
            c((new com.target.ui.util.r()).a(list));
            mStoreMapContainerPresentation.a(list);
            mStoreMapContainerPresentation.t();
            return;
        }
    }

    public void c()
    {
        mVlcManagerWrapper = mVlcManagerWrapperProvider.o();
    }

    public void d()
    {
        if (mVlcManagerWrapper != null)
        {
            mVlcManagerWrapper.a(this);
        }
    }

    public void e()
    {
        if (mVlcManagerWrapper != null)
        {
            mVlcManagerWrapper.b(this);
        }
    }

    public void f()
    {
        while (mStoreMapContainerPresentation == null || mMode == 1) 
        {
            return;
        }
        mMode = 1;
        mStoreMapContainerPresentation.b(2.0F);
    }

    public void g()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mMode = 2;
            mStoreMapContainerPresentation.b(4);
            return;
        }
    }

    public void h()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.b(4);
            return;
        }
    }

    public void i()
    {
        mMode = 2;
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            a(2.0F);
            return;
        }
    }

    public void j()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.p();
            return;
        }
    }

    public void k()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.z();
            return;
        }
    }

    public void l()
    {
        if (mStoreMapContainerPresentation != null)
        {
            boolean flag;
            if (!mVlcPreferenceEnabled)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mVlcPreferenceEnabled = flag;
            mStoreMapContainerPresentation.g(mVlcPreferenceEnabled);
            mStoreMapContainerPresentation.f(mVlcPreferenceEnabled);
            if (mVlcPreferenceEnabled)
            {
                if (mStore != null)
                {
                    a(mStore.getStoreId().a(), mZone.getUUID());
                    return;
                }
            } else
            {
                y();
                return;
            }
        }
    }

    public void m()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        }
        mMode = 2;
        long l1 = System.currentTimeMillis();
        long l2 = mLastKnownTime;
        if (mLastKnownTime != -1L && l1 - l2 < 5000L)
        {
            mStoreMapContainerPresentation.a(mLastKnownPixelX, mLastKnownPixelY);
            return;
        } else
        {
            mStoreMapContainerPresentation.a(-1F, -1F);
            return;
        }
    }

    public void n()
    {
        mStoreMapContainerPresentation.h(true);
    }

    public void o()
    {
        mStoreMapContainerPresentation.h();
    }

    public void p()
    {
    }

    public void p_()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.d(false);
            mStoreMapContainerPresentation.v();
            return;
        }
    }

    public void postZoneLoad(String s1, int i1, int j1)
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.f(s1);
            return;
        }
    }

    public void preZoneLoad(String s1, int i1, int j1)
    {
    }

    public void q()
    {
        if (mStoreMapContainerPresentation != null)
        {
            mStoreMapContainerPresentation.f(mVlcPreferenceEnabled);
            if (!mVlcPreferenceEnabled)
            {
                y();
                return;
            }
        }
    }

    public void r()
    {
    }

    public void s()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mVlcLoaded = false;
            mStoreMapContainerPresentation.c(false);
            mStoreMapContainerPresentation.b(4);
            mStoreMapContainerPresentation.q();
            return;
        }
    }

    public void t()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.d(true);
            mStoreMapContainerPresentation.s();
            return;
        }
    }

    public void u()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.d(false);
            mStoreMapContainerPresentation.y();
            z();
            mMapLoaded = true;
            return;
        }
    }

    public void v()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.b(4);
            mMode = 0;
            return;
        }
    }

    public void v_()
    {
        mVenueDataHelper = null;
        mStoreDataHelper = null;
        mVlcManagerWrapper = null;
        mListDetailDataHelper = null;
        mPIMapLoader = null;
        mPositionSmoother = null;
    }

    public void w()
    {
        if (mStoreMapContainerPresentation == null)
        {
            return;
        } else
        {
            mStoreMapContainerPresentation.x();
            return;
        }
    }

    public void x()
    {
        mCameraMovingToBlueDot = false;
    }

    public void y()
    {
        if (mVlcManagerWrapper == null)
        {
            return;
        } else
        {
            mVlcManagerWrapper.a();
            return;
        }
    }

    public void z_()
    {
        mVenueDataHelper.a();
        if (mListDetailDataHelper != null)
        {
            mListDetailDataHelper.a();
        }
        mStoreDataHelper.a();
        mStoreMapContainerPresentation = null;
        mMapLoaded = false;
        mVlcLoaded = false;
    }
}
