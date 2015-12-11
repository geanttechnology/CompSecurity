// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.preference.PreferenceManager;
import com.google.a.a.e;
import com.google.android.gms.common.ConnectionResult;
import com.target.a.a.a;
import com.target.mothership.cache.j;
import com.target.mothership.common.product.Dpci;
import com.target.mothership.common.product.i;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.guest.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.h;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductAvailability;
import com.target.mothership.model.product.interfaces.ProductAvailabilityStore;
import com.target.mothership.model.store.c;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.g;
import com.target.mothership.services.w;
import com.target.mothership.services.x;
import com.target.ui.analytics.a.n;
import com.target.ui.analytics.a.o;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.target.ui.service:
//            a

public class k
    implements com.target.mothership.cache.j.a, com.target.mothership.services.g.d, a.b
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a AVAILABILITY_ERROR;
        public static final a GEOCODE_FAILURE;
        public static final a NETWORK;
        public static final a NO_NEARBY_STORES;
        public static final a NO_PRODUCT_DPCI_ERROR;
        public static final a NO_RELEVANT_STORES;
        public static final a NO_STORES_ZIP;
        public static final a RELEVANT_STORE_ERROR;
        public static final a STORE_LOOKUP_ERROR;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/service/k$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            NO_PRODUCT_DPCI_ERROR = new a("NO_PRODUCT_DPCI_ERROR", 0);
            AVAILABILITY_ERROR = new a("AVAILABILITY_ERROR", 1);
            STORE_LOOKUP_ERROR = new a("STORE_LOOKUP_ERROR", 2);
            NO_STORES_ZIP = new a("NO_STORES_ZIP", 3);
            RELEVANT_STORE_ERROR = new a("RELEVANT_STORE_ERROR", 4);
            NO_RELEVANT_STORES = new a("NO_RELEVANT_STORES", 5);
            NO_NEARBY_STORES = new a("NO_NEARBY_STORES", 6);
            GEOCODE_FAILURE = new a("GEOCODE_FAILURE", 7);
            NETWORK = new a("NETWORK", 8);
            $VALUES = (new a[] {
                NO_PRODUCT_DPCI_ERROR, AVAILABILITY_ERROR, STORE_LOOKUP_ERROR, NO_STORES_ZIP, RELEVANT_STORE_ERROR, NO_RELEVANT_STORES, NO_NEARBY_STORES, GEOCODE_FAILURE, NETWORK
            });
        }

        private a(String s, int l)
        {
            super(s, l);
        }
    }

    public static abstract class b extends w
    {

        public abstract void a(a a1, x x);

        public void onError(x x)
        {
            a(a.NETWORK, x);
        }

        public b()
        {
        }
    }

    public static interface c
    {

        public abstract void a(com.google.a.a.e e1);
    }

    public static abstract class d extends w
    {

        public abstract void a(a a1, x x);

        public void onError(x x)
        {
            a(a.NETWORK, x);
        }

        public d()
        {
        }
    }

    private static final class e extends Enum
    {

        private static final e $VALUES[];
        public static final e CHANGED;
        public static final e ENTERED_GEOFENCE;
        public static final e EXITED_GEOFENCE;
        public static final e NOT_CHANGED;

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(com/target/ui/service/k$e, s);
        }

        public static e[] values()
        {
            return (e[])$VALUES.clone();
        }

        static 
        {
            NOT_CHANGED = new e("NOT_CHANGED", 0);
            CHANGED = new e("CHANGED", 1);
            ENTERED_GEOFENCE = new e("ENTERED_GEOFENCE", 2);
            EXITED_GEOFENCE = new e("EXITED_GEOFENCE", 3);
            $VALUES = (new e[] {
                NOT_CHANGED, CHANGED, ENTERED_GEOFENCE, EXITED_GEOFENCE
            });
        }

        private e(String s, int l)
        {
            super(s, l);
        }
    }


    private static final boolean DEBUG = true;
    public static final String KEY_LAST_STORE_ID = "com.target.ui.service.RelevantStoreService.LAST_STORE_ID";
    private static final String LOG_TAG = com/target/ui/service/k.getSimpleName();
    private static final int MAX_STORES_FOR_PRODUCT = 7;
    private static k sInstance;
    private com.google.a.a.e mCachedStore;
    private Guest mGuest;
    private boolean mIsAnyActivityStarted;
    private CopyOnWriteArrayList mListeners;
    private boolean mLocationUpdatesActive;
    private Location mPendingLocationUpdate;
    private SharedPreferences mSharedPreferences;
    private com.target.mothership.model.store.c mStoreManager;
    private boolean mStoreUpdateCompleted;
    private boolean mUpdatingStore;

    private k(com.target.a.a.a a1)
    {
        mUpdatingStore = false;
        mStoreUpdateCompleted = false;
        mLocationUpdatesActive = false;
        mIsAnyActivityStarted = false;
        mStoreManager = new com.target.mothership.model.store.c();
        mListeners = new CopyOnWriteArrayList();
        mCachedStore = com.google.a.a.e.e();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a1.a());
        com.target.ui.service.a.a().a(new h() {

            final k this$0;

            public String a()
            {
                return com/target/ui/service/k.getSimpleName();
            }

            public void a(Guest guest)
            {
                com.target.ui.service.k.a(k.this, guest);
                com.target.ui.service.k.a(k.this);
            }

            public void a(x x1)
            {
                com.target.ui.service.k.a(k.this);
            }

            public volatile void a(Object obj)
            {
                a((Guest)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = k.this;
                super();
            }
        });
    }

    static Guest a(k k1, Guest guest)
    {
        k1.mGuest = guest;
        return guest;
    }

    private e a(com.google.a.a.e e1)
    {
        e e3 = e.NOT_CHANGED;
        if (mCachedStore.b() || e1.b()) goto _L2; else goto _L1
_L1:
        e e2 = e.NOT_CHANGED;
_L4:
        if (e2 != e.NOT_CHANGED)
        {
            mCachedStore = e1;
            if (!mCachedStore.b())
            {
                break; /* Loop/switch isn't completed */
            }
            mSharedPreferences.edit().putString("com.target.ui.service.RelevantStoreService.LAST_STORE_ID", ((RelevantStoreSummary)mCachedStore.c()).getStoreId().a()).apply();
        }
        return e2;
_L2:
        if (mCachedStore.b() && !e1.b() || !mCachedStore.b())
        {
            e2 = e.CHANGED;
            continue; /* Loop/switch isn't completed */
        }
        if (((RelevantStoreSummary)mCachedStore.c()).getStoreId().equals(((RelevantStoreSummary)e1.c()).getStoreId()) && (!((RelevantStoreSummary)mCachedStore.c()).a() || ((RelevantStoreSummary)e1.c()).a()))
        {
            e2 = e3;
            if (((RelevantStoreSummary)mCachedStore.c()).a())
            {
                continue; /* Loop/switch isn't completed */
            }
            e2 = e3;
            if (!((RelevantStoreSummary)e1.c()).a())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        e3 = e.CHANGED;
        if (((RelevantStoreSummary)e1.c()).a())
        {
            e2 = e.ENTERED_GEOFENCE;
        } else
        {
            e2 = e3;
            if (((RelevantStoreSummary)mCachedStore.c()).a())
            {
                e2 = e3;
                if (!((RelevantStoreSummary)e1.c()).a())
                {
                    e2 = e.EXITED_GEOFENCE;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        mSharedPreferences.edit().remove("com.target.ui.service.RelevantStoreService.LAST_STORE_ID").apply();
        return e2;
    }

    static e a(k k1, com.google.a.a.e e1)
    {
        return k1.a(e1);
    }

    public static k a()
    {
        if (sInstance == null)
        {
            throw new IllegalStateException("Initialize must be called before getInstance");
        } else
        {
            return sInstance;
        }
    }

    public static void a(com.target.a.a.a a1)
    {
        if (sInstance != null)
        {
            return;
        } else
        {
            q.d(LOG_TAG, "initializing instance");
            sInstance = new k(a1);
            return;
        }
    }

    private void a(e e1)
    {
        if (e1 == e.ENTERED_GEOFENCE)
        {
            q.d(LOG_TAG, (new StringBuilder()).append("incrementing frequency for store id ").append(((RelevantStoreSummary)mCachedStore.c()).getStoreId().a()).toString());
            mStoreManager.a(k(), ((RelevantStoreSummary)mCachedStore.c()).getStoreId(), null);
        }
    }

    static void a(k k1)
    {
        k1.e();
    }

    static void a(k k1, e e1)
    {
        k1.a(e1);
    }

    static GuestBase b(k k1)
    {
        return k1.k();
    }

    private void b(Location location)
    {
        mUpdatingStore = true;
        mStoreManager.a(k(), location, new h() {

            final k this$0;

            public void a(com.google.a.a.e e1)
            {
                Object obj = com.target.ui.service.k.a(k.this, e1);
                com.target.ui.service.k.a(k.this, ((e) (obj)));
                com.target.ui.service.k.b(k.this, ((e) (obj)));
                com.target.ui.service.k.c(k.this, ((e) (obj)));
                k.d(k.this, ((e) (obj)));
                obj = k.d();
                StringBuilder stringbuilder = (new StringBuilder()).append("Set most relevant store to ");
                if (e1.b())
                {
                    e1 = (new StringBuilder()).append(((RelevantStoreSummary)e1.c()).getStoreId().a()).append(" (").append(((RelevantStoreSummary)e1.c()).getName()).append("), inside: ").append(((RelevantStoreSummary)e1.c()).a()).toString();
                } else
                {
                    e1 = "none";
                }
                q.d(((String) (obj)), stringbuilder.append(e1).toString());
                com.target.ui.service.k.e(k.this);
            }

            public void a(x x1)
            {
                q.a(k.d(), (new StringBuilder()).append("Error getting most relevant store! ").append(x1).toString());
                com.target.ui.service.k.e(k.this);
            }

            public volatile void a(Object obj)
            {
                a((com.google.a.a.e)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = k.this;
                super();
            }
        });
    }

    private void b(e e1)
    {
        if (e1 != e.NOT_CHANGED)
        {
            for (e1 = mListeners.iterator(); e1.hasNext(); ((c)e1.next()).a(mCachedStore)) { }
        }
    }

    static void b(k k1, e e1)
    {
        k1.b(e1);
    }

    static com.target.mothership.model.store.c c(k k1)
    {
        return k1.mStoreManager;
    }

    private void c(e e1)
    {
        if (e1 != e.NOT_CHANGED && mCachedStore.b())
        {
            mStoreManager.a(k(), ((RelevantStoreSummary)mCachedStore.c()).getStoreId(), ((RelevantStoreSummary)mCachedStore.c()).a(), null);
        }
    }

    static void c(k k1, e e1)
    {
        k1.c(e1);
    }

    static String d()
    {
        return LOG_TAG;
    }

    private void d(e e1)
    {
        static class _cls8
        {

            static final int $SwitchMap$com$target$ui$service$RelevantStoreService$UpdateState[];

            static 
            {
                $SwitchMap$com$target$ui$service$RelevantStoreService$UpdateState = new int[e.values().length];
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$UpdateState[e.ENTERED_GEOFENCE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$service$RelevantStoreService$UpdateState[e.EXITED_GEOFENCE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls8..SwitchMap.com.target.ui.service.RelevantStoreService.UpdateState[e1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            o.a(com.target.ui.analytics.a.o.a.EnteredGeofence).e();
            return;

        case 2: // '\002'
            o.a(com.target.ui.analytics.a.o.a.ExitedGeofence).e();
            break;
        }
    }

    static void d(k k1)
    {
        k1.i();
    }

    static void d(k k1, e e1)
    {
        k1.d(e1);
    }

    private void e()
    {
        com.target.mothership.cache.j.getInstance().addListener(this);
        com.target.ui.service.a.a().a(this);
    }

    static void e(k k1)
    {
        k1.j();
    }

    private void f()
    {
        com.target.mothership.cache.j.getInstance().removeListener(this);
        mStoreUpdateCompleted = true;
        h();
        i();
    }

    private void g()
    {
        com.target.mothership.services.g.a().b(this);
        mLocationUpdatesActive = false;
    }

    private void h()
    {
        if (!mLocationUpdatesActive && mIsAnyActivityStarted)
        {
            com.target.mothership.services.g.a().a(this);
            mLocationUpdatesActive = true;
        }
    }

    private void i()
    {
        b(com.target.mothership.services.g.a().b());
    }

    private void j()
    {
        mUpdatingStore = false;
        if (mPendingLocationUpdate != null)
        {
            b(mPendingLocationUpdate);
            mPendingLocationUpdate = null;
        }
    }

    private GuestBase k()
    {
        if (mGuest != null)
        {
            return mGuest;
        } else
        {
            return com.target.mothership.model.guest.b.a();
        }
    }

    public com.google.a.a.e a(c c1)
    {
        mListeners.add(c1);
        return c();
    }

    public void a(double d1, double d2, int l, h h1)
    {
        mStoreManager.a(k(), d1, d2, l, h1);
    }

    public void a(int l, final d listener)
    {
        mStoreManager.a(k(), com.target.mothership.services.g.a().b(), l, new h() {

            final k this$0;
            final d val$listener;

            public void a(x x1)
            {
                listener.a(a.RELEVANT_STORE_ERROR, x1);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list.isEmpty())
                {
                    listener.a(a.NO_RELEVANT_STORES, null);
                    return;
                } else
                {
                    listener.onResult(list);
                    return;
                }
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = k.this;
                listener = d1;
                super();
            }
        });
    }

    public void a(Activity activity)
    {
        q.d(LOG_TAG, (new StringBuilder()).append("onActivityStarted(").append(activity).append(")").toString());
        mIsAnyActivityStarted = true;
        if (mStoreUpdateCompleted)
        {
            h();
        }
    }

    public void a(Location location)
    {
        String s1 = LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("location changed: ");
        String s;
        if (location != null)
        {
            s = (new StringBuilder()).append(location.getLatitude()).append(" ").append(location.getLongitude()).toString();
        } else
        {
            s = "null";
        }
        q.d(s1, stringbuilder.append(s).toString());
        if (mUpdatingStore)
        {
            mPendingLocationUpdate = location;
            return;
        } else
        {
            b(location);
            return;
        }
    }

    public void a(ConnectionResult connectionresult)
    {
        q.d(LOG_TAG, (new StringBuilder()).append("onConnectionFailed (location services): ").append(connectionresult.c()).append(" ").append(connectionresult.a()).toString());
        i();
    }

    public void a(final StoreIdentifier storeIdentifier)
    {
        mStoreManager.b(k(), storeIdentifier, new com.target.mothership.cache.i.a() {

            final k this$0;
            final StoreIdentifier val$storeIdentifier;

            public void onFailure(Throwable throwable)
            {
                q.a(k.d(), (new StringBuilder()).append("Error setting override store to ").append(storeIdentifier.a()).toString());
            }

            public void onStoreUpdated()
            {
                k.d(k.this);
            }

            
            {
                this$0 = k.this;
                storeIdentifier = storeidentifier;
                super();
            }
        });
    }

    public void a(StoreIdentifier storeidentifier, h h1)
    {
        mStoreManager.a(k(), storeidentifier, h1);
    }

    public void a(Guest guest)
    {
        mGuest = guest;
        if (mCachedStore.b())
        {
            c(e.CHANGED);
            if (((RelevantStoreSummary)mCachedStore.c()).c())
            {
                a(((RelevantStoreSummary)mCachedStore.c()).getStoreId());
            }
        }
    }

    public void a(h h1)
    {
        mStoreManager.a(k(), h1);
    }

    public void a(Product product, int l, final b callback)
    {
        if (!product.e().b())
        {
            callback.a(a.NO_PRODUCT_DPCI_ERROR, null);
            return;
        } else
        {
            product = new h() {

                final k this$0;
                final b val$callback;
                final Product val$product;
                final int val$requestedQuantity;
                final boolean val$useAtpForStoreAvailability;

                public String a()
                {
                    return callback.getTag();
                }

                public void a(x x1)
                {
                    callback.a(a.RELEVANT_STORE_ERROR, x1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(final List relevantStores)
                {
                    if (relevantStores.isEmpty())
                    {
                        callback.a(a.NO_RELEVANT_STORES, null);
                        return;
                    }
                    ArrayList arraylist1 = new ArrayList();
                    com.target.mothership.model.product.c c1 = new com.target.mothership.model.product.c();
                    ArrayList arraylist = new ArrayList();
                    for (Iterator iterator = relevantStores.iterator(); iterator.hasNext(); arraylist.add(((RelevantStoreSummary)iterator.next()).getStoreId())) { }
                    relevantStores = arraylist1. new h() {

                        final _cls3 this$1;
                        final List val$relevantStores;
                        final List val$relevantStoresForProduct;

                        public String a()
                        {
                            return callback.getTag();
                        }

                        public void a(ProductAvailability productavailability)
                        {
                            android.support.v4.f.a a1 = new android.support.v4.f.a();
                            ProductAvailabilityStore productavailabilitystore;
                            for (productavailability = productavailability.a().iterator(); productavailability.hasNext(); a1.put(productavailabilitystore.a(), productavailabilitystore))
                            {
                                productavailabilitystore = (ProductAvailabilityStore)productavailability.next();
                            }

                            for (productavailability = relevantStores.iterator(); productavailability.hasNext();)
                            {
                                RelevantStoreSummary relevantstoresummary = (RelevantStoreSummary)productavailability.next();
                                ProductAvailabilityStore productavailabilitystore1 = (ProductAvailabilityStore)a1.get(relevantstoresummary.getStoreId());
                                if (productavailabilitystore1 != null)
                                {
                                    relevantStoresForProduct.add(new com.target.ui.model.a(relevantstoresummary, productavailabilitystore1.c(), productavailabilitystore1.b(), productavailabilitystore1.d()));
                                } else
                                {
                                    relevantStoresForProduct.add(new com.target.ui.model.a(relevantstoresummary, 0, i.UNKNOWN, Collections.emptyList()));
                                }
                            }

                            callback.onResult(relevantStoresForProduct);
                        }

                        public void a(x x1)
                        {
                            callback.a(a.AVAILABILITY_ERROR, x1);
                            n.a(x1).e();
                        }

                        public volatile void a(Object obj)
                        {
                            a((ProductAvailability)obj);
                        }

                        public void b(Object obj)
                        {
                            a((x)obj);
                        }

            
            {
                this$1 = final__pcls3;
                relevantStores = list;
                relevantStoresForProduct = List.this;
                super();
            }
                    };
                    if (useAtpForStoreAvailability)
                    {
                        c1.a((Dpci)product.e().c(), requestedQuantity, arraylist, relevantStores);
                        return;
                    } else
                    {
                        c1.a((Dpci)product.e().c(), arraylist, com.target.mothership.common.product.o.ANY, relevantStores);
                        return;
                    }
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = k.this;
                callback = b1;
                useAtpForStoreAvailability = flag;
                product = product1;
                requestedQuantity = l;
                super();
            }
            };
            mStoreManager.a(k(), com.target.mothership.services.g.a().b(), 7, product);
            return;
        }
    }

    public void a(Product product, int l, String s, final b callback)
    {
        if (!product.e().b())
        {
            callback.a(a.NO_PRODUCT_DPCI_ERROR, null);
            return;
        }
        callback = new h() {

            final k this$0;
            final b val$callback;

            public void a(ProductAvailability productavailability)
            {
                if (productavailability.a().isEmpty())
                {
                    callback.a(a.NO_STORES_ZIP, null);
                    return;
                }
                ArrayList arraylist = new ArrayList();
                Iterator iterator = productavailability.a().iterator();
                int i1 = 0;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    arraylist.add(((ProductAvailabilityStore)iterator.next()).a());
                    i1++;
                } while (i1 < 7);
                com.target.ui.service.k.c(k.this).a(com.target.ui.service.k.b(k.this), arraylist, productavailability. new h() {

                    final _cls4 this$1;
                    final ProductAvailability val$productAvailability;

                    public void a(x x1)
                    {
                        callback.a(a.STORE_LOOKUP_ERROR, x1);
                    }

                    public volatile void a(Object obj)
                    {
                        a((List)obj);
                    }

                    public void a(List list)
                    {
                        android.support.v4.f.a a1 = new android.support.v4.f.a();
                        RelevantStoreSummary relevantstoresummary;
                        for (list = list.iterator(); list.hasNext(); a1.put(relevantstoresummary.getStoreId(), relevantstoresummary))
                        {
                            relevantstoresummary = (RelevantStoreSummary)list.next();
                        }

                        list = new ArrayList();
                        Iterator iterator = productAvailability.a().iterator();
                        int l = 0;
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break;
                            }
                            ProductAvailabilityStore productavailabilitystore = (ProductAvailabilityStore)iterator.next();
                            if (a1.get(productavailabilitystore.a()) != null)
                            {
                                list.add(new com.target.ui.model.a((RelevantStoreSummary)a1.get(productavailabilitystore.a()), productavailabilitystore.c(), productavailabilitystore.b(), productavailabilitystore.d()));
                                l++;
                            }
                        } while (l < 7);
                        if (list.isEmpty())
                        {
                            callback.a(a.STORE_LOOKUP_ERROR, null);
                            return;
                        } else
                        {
                            callback.onResult(list);
                            return;
                        }
                    }

                    public void b(Object obj)
                    {
                        a((x)obj);
                    }

            
            {
                this$1 = final__pcls4;
                productAvailability = ProductAvailability.this;
                super();
            }
                });
            }

            public void a(x x1)
            {
                callback.a(a.AVAILABILITY_ERROR, x1);
                n.a(x1).e();
            }

            public volatile void a(Object obj)
            {
                a((ProductAvailability)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = k.this;
                callback = b1;
                super();
            }
        };
        com.target.mothership.model.product.c c1 = new com.target.mothership.model.product.c();
        if ((new com.target.ui.service.provider.c()).a().f())
        {
            c1.a((Dpci)product.e().c(), l, s, 7, callback);
            return;
        } else
        {
            c1.a((Dpci)product.e().c(), s, com.target.mothership.common.product.o.ANY, callback);
            return;
        }
    }

    public void a(String s)
    {
        mStoreManager.a(s);
    }

    public void a(String s, int l, int i1, h h1)
    {
        mStoreManager.a(s, l, i1, h1);
    }

    public void b()
    {
        mGuest = null;
    }

    public void b(Activity activity)
    {
        q.d(LOG_TAG, (new StringBuilder()).append("onActivityStopped(").append(activity).append(")").toString());
        mIsAnyActivityStarted = false;
        g();
    }

    public void b(final h callback)
    {
        a(new h() {

            final k this$0;
            final h val$callback;

            public void a(com.google.a.a.e e1)
            {
                callback.a(Boolean.valueOf(e1.b()));
            }

            public void a(x x1)
            {
                callback.a(x1);
            }

            public volatile void a(Object obj)
            {
                a((com.google.a.a.e)obj);
            }

            public void b(Object obj)
            {
                a((x)obj);
            }

            
            {
                this$0 = k.this;
                callback = h1;
                super();
            }
        });
    }

    public void b(c c1)
    {
        mListeners.remove(c1);
    }

    public com.google.a.a.e c()
    {
        return mCachedStore;
    }

    public void onStoreDatabaseUpdateFailed()
    {
        f();
    }

    public void onStoreDatabaseUpdated()
    {
        f();
    }

    public String toString()
    {
        return (new StringBuilder()).append("RelevantStoreService{mUpdatingStore=").append(mUpdatingStore).append(", mLocationUpdatesActive=").append(mLocationUpdatesActive).append(", mGuest=").append(mGuest).append(", mIsAnyActivityStarted=").append(mIsAnyActivityStarted).append(", mStoreUpdateCompleted=").append(mStoreUpdateCompleted).append('}').toString();
    }

}
