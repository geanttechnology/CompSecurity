// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store;

import android.location.Location;
import com.target.mothership.cache.i;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.h;
import com.target.mothership.model.store.handler.c;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.mothership.services.e.h.c.a;
import com.target.mothership.services.x;
import com.target.mothership.services.z;
import com.target.mothership.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.store:
//            a

class com.target.mothership.model.store.b
    implements com.target.mothership.model.store.a
{
    private class a extends h
    {

        private h mCallback;
        private RelevantStoreSummary mClosestStore;
        final com.target.mothership.model.store.b this$0;

        public void a(x x1)
        {
            mCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (!list.isEmpty())
            {
                mCallback.a(com.google.a.a.e.b(com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, (RelevantStoreSummary)list.get(0), false)));
                return;
            }
            if (mClosestStore != null)
            {
                mCallback.a(com.google.a.a.e.b(mClosestStore));
                return;
            } else
            {
                mCallback.a(com.google.a.a.e.e());
                return;
            }
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public a(h h1, RelevantStoreSummary relevantstoresummary)
        {
            this$0 = com.target.mothership.model.store.b.this;
            super();
            mCallback = h1;
            mClosestStore = relevantstoresummary;
        }
    }

    private class b extends h
    {

        private h mCallback;
        private int mMaxStores;
        private List mNearestStores;
        private RelevantStoreSummary mOverrideStore;
        final com.target.mothership.model.store.b this$0;

        public void a(x x1)
        {
            mCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            ArrayList arraylist = new ArrayList();
            if (mNearestStores == null) goto _L2; else goto _L1
_L1:
            Iterator iterator;
            if (mOverrideStore != null)
            {
                list = mOverrideStore;
            } else
            if (!list.isEmpty())
            {
                list = (RelevantStoreSummary)list.get(0);
            } else
            {
                list = null;
            }
            if (list != null)
            {
                arraylist.add(list);
            }
            iterator = mNearestStores.iterator();
label0:
            do
            {
                RelevantStoreSummary relevantstoresummary1;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    relevantstoresummary1 = (RelevantStoreSummary)iterator.next();
                } while (list != null && relevantstoresummary1.getStoreId().equals(list.getStoreId()));
                arraylist.add(relevantstoresummary1);
            } while (arraylist.size() < mMaxStores);
_L4:
            mCallback.a(arraylist);
            return;
_L2:
            if (mOverrideStore != null)
            {
                arraylist.add(mOverrideStore);
            }
            list = list.iterator();
_L6:
            if (!list.hasNext()) goto _L4; else goto _L3
_L3:
            RelevantStoreSummary relevantstoresummary = (RelevantStoreSummary)list.next();
            if (arraylist.size() >= mMaxStores) goto _L4; else goto _L5
_L5:
            if (mOverrideStore == null || !relevantstoresummary.getStoreId().equals(mOverrideStore.getStoreId()))
            {
                arraylist.add(relevantstoresummary);
            }
              goto _L6
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        private b(h h1, List list, RelevantStoreSummary relevantstoresummary, int j)
        {
            this$0 = com.target.mothership.model.store.b.this;
            super();
            mCallback = h1;
            mNearestStores = list;
            mMaxStores = j;
            mOverrideStore = relevantstoresummary;
        }

    }

    private class c extends h
    {

        private h mCallback;
        private GuestBase mGuest;
        private int mMaxStores;
        private List mNearestStores;
        final com.target.mothership.model.store.b this$0;

        public void a(com.google.a.a.e e1)
        {
            com.target.mothership.model.store.b.this.b(mGuest, new b(mCallback, mNearestStores, (RelevantStoreSummary)e1.d(), mMaxStores));
        }

        public void a(x x1)
        {
            mCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((com.google.a.a.e)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        private c(GuestBase guestbase, h h1, List list, int j)
        {
            this$0 = com.target.mothership.model.store.b.this;
            super();
            mGuest = guestbase;
            mCallback = h1;
            mNearestStores = list;
            mMaxStores = j;
        }

    }

    private class d extends h
    {

        private h mCallback;
        private GuestBase mGuest;
        private RelevantStoreSummary mNearestStore;
        final com.target.mothership.model.store.b this$0;

        public void a(com.google.a.a.e e1)
        {
            if (e1.b())
            {
                mCallback.a(com.google.a.a.e.b(com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, (RelevantStoreSummary)e1.c(), false)));
                return;
            } else
            {
                com.target.mothership.model.store.b.this.b(mGuest, new a(mCallback, mNearestStore));
                return;
            }
        }

        public void a(x x1)
        {
            mCallback.a(x1);
        }

        public volatile void a(Object obj)
        {
            a((com.google.a.a.e)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

        public d(GuestBase guestbase, h h1, RelevantStoreSummary relevantstoresummary)
        {
            this$0 = com.target.mothership.model.store.b.this;
            super();
            mGuest = guestbase;
            mCallback = h1;
            mNearestStore = relevantstoresummary;
        }
    }


    private static final boolean DEBUG = false;
    private static final String LOG_TAG = com/target/mothership/model/store/b.getSimpleName();
    private com.target.mothership.services.e.h.c.a mServices;

    public com.target.mothership.model.store.b()
    {
        mServices = new com.target.mothership.services.e.h.c.a();
    }

    static RelevantStoreSummary a(com.target.mothership.model.store.b b1, RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        return b1.a(relevantstoresummary, flag);
    }

    private RelevantStoreSummary a(RelevantStoreSummary relevantstoresummary, boolean flag)
    {
        return (new com.target.mothership.model.store.handler.a()).a(relevantstoresummary, flag, relevantstoresummary.b(), relevantstoresummary.c(), relevantstoresummary.hasRequestATeamMember());
    }

    private void a(GuestBase guestbase, double d1, double d2, h h1)
    {
        h1.a(x.a("Cannot find nearby stores.  The cache data may have been corrupted, or need rebuilding.").a(z.INTERNAL_SERVER_ERROR).a());
    }

    static void a(com.target.mothership.model.store.b b1, GuestBase guestbase, double d1, double d2, h h1)
    {
        b1.a(guestbase, d1, d2, h1);
    }

    static boolean a(com.target.mothership.model.store.b b1, StoreSummary storesummary, Location location)
    {
        return b1.a(storesummary, location);
    }

    private boolean a(StoreSummary storesummary, Location location)
    {
        if (storesummary == null || location == null)
        {
            return false;
        }
        return e.a(location.getLatitude(), location.getLongitude(), storesummary.getGeofence().getCenter().getLatitude(), storesummary.getGeofence().getCenter().getLongitude()) * 1609.3440000000001D < storesummary.getGeofence().getRadius();
    }

    public void a(StoreIdentifier storeidentifier, h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.store.handler.c(h1));
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(storeidentifier.a());
        mServices.a(arraylist, h1);
    }

    public void a(GuestBase guestbase, double d1, double d2, int j, h h1)
    {
        i.getNearestStores(guestbase, d1, d2, j, h1);
    }

    public void a(final GuestBase guest, Location location, final int stores, final h callback)
    {
        if (stores < 2)
        {
            throw new IllegalArgumentException("Number of relevant stores must be at least 2.");
        }
        if (location != null)
        {
            a(guest, location.getLatitude(), location.getLongitude(), stores, ((h) (new h() {

                final com.target.mothership.model.store.b this$0;
                final h val$callback;
                final GuestBase val$guest;
                final int val$stores;

                public void a(x x1)
                {
                    callback.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    com.target.mothership.model.store.b.this.a(guest, new c(guest, callback, list, stores));
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.mothership.model.store.b.this;
                guest = guestbase;
                callback = h1;
                stores = j;
                super();
            }
            })));
            return;
        } else
        {
            a(guest, ((h) (new h() {

                final com.target.mothership.model.store.b this$0;
                final h val$callback;
                final GuestBase val$guest;
                final int val$stores;

                public void a(com.google.a.a.e e1)
                {
                    if (e1.b())
                    {
                        RelevantStoreSummary relevantstoresummary = (RelevantStoreSummary)e1.c();
                        com.target.mothership.model.store.b.this.a(guest, ((RelevantStoreSummary)e1.c()).getGeofence().getCenter().getLatitude(), ((RelevantStoreSummary)e1.c()).getGeofence().getCenter().getLongitude(), stores, relevantstoresummary. new h() {

                            final _cls4 this$1;
                            final RelevantStoreSummary val$overrideStore;

                            public void a(x x1)
                            {
                                callback.a(x1);
                            }

                            public volatile void a(Object obj)
                            {
                                a((List)obj);
                            }

                            public void a(List list)
                            {
                                com.target.mothership.model.store.b.this.b(guest, new b(callback, list, overrideStore, stores));
                            }

                            public void b(Object obj)
                            {
                                a((x)obj);
                            }

            
            {
                this$1 = final__pcls4;
                overrideStore = RelevantStoreSummary.this;
                super();
            }
                        });
                        return;
                    } else
                    {
                        com.target.mothership.model.store.b.this.b(guest, new b(callback, null, null, stores));
                        return;
                    }
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
                this$0 = com.target.mothership.model.store.b.this;
                guest = guestbase;
                stores = j;
                callback = h1;
                super();
            }
            })));
            return;
        }
    }

    public void a(final GuestBase guest, final Location location, final h callback)
    {
        if (location != null)
        {
            a(guest, location.getLatitude(), location.getLongitude(), 1, ((h) (new h() {

                final com.target.mothership.model.store.b this$0;
                final h val$callback;
                final GuestBase val$guest;
                final Location val$location;

                public void a(x x1)
                {
                    callback.a(x1);
                }

                public volatile void a(Object obj)
                {
                    a((List)obj);
                }

                public void a(List list)
                {
                    Object obj;
                    if (!list.isEmpty())
                    {
                        list = (RelevantStoreSummary)list.get(0);
                    } else
                    {
                        list = null;
                    }
                    obj = list;
                    if (list != null)
                    {
                        if (com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, list, location))
                        {
                            callback.a(com.google.a.a.e.b(com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, list, true)));
                            return;
                        }
                        obj = com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, list, false);
                    }
                    com.target.mothership.model.store.b.this.a(guest, new d(guest, callback, ((RelevantStoreSummary) (obj))));
                }

                public void b(Object obj)
                {
                    a((x)obj);
                }

            
            {
                this$0 = com.target.mothership.model.store.b.this;
                location = location1;
                callback = h1;
                guest = guestbase;
                super();
            }
            })));
            return;
        } else
        {
            a(guest, ((h) (new d(guest, callback, null))));
            return;
        }
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        i.incrementFrequentedStore(guestbase, storeidentifier, a1);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, h h1)
    {
        i.getStoreSummary(guestbase, storeidentifier, h1);
    }

    public void a(GuestBase guestbase, StoreIdentifier storeidentifier, boolean flag, com.target.mothership.cache.i.a a1)
    {
        i.setLastRelevantStore(guestbase, storeidentifier, flag, a1);
    }

    public void a(GuestBase guestbase, h h1)
    {
        i.getOverrideStore(guestbase, h1);
    }

    public void a(GuestBase guestbase, List list, h h1)
    {
        i.getStoreSummaries(guestbase, list, h1);
    }

    public void a(String s, int j, int k, h h1)
    {
        h1 = new com.target.mothership.model.e(new com.target.mothership.model.store.handler.b(h1));
        mServices.a(s, j, k, h1);
    }

    public void b(GuestBase guestbase, StoreIdentifier storeidentifier, com.target.mothership.cache.i.a a1)
    {
        i.setOverrideStore(guestbase, storeidentifier, a1);
    }

    public void b(GuestBase guestbase, h h1)
    {
        i.getFrequentedStores(guestbase, h1);
    }


    // Unreferenced inner class com/target/mothership/model/store/b$1

/* anonymous class */
    class _cls1 extends h
    {

        final com.target.mothership.model.store.b this$0;
        final h val$callback;
        final GuestBase val$guest;
        final double val$lat;
        final double val$lon;

        public void a(x x1)
        {
            com.target.mothership.model.store.b.a(com.target.mothership.model.store.b.this, guest, lat, lon, callback);
        }

        public volatile void a(Object obj)
        {
            a((List)obj);
        }

        public void a(List list)
        {
            if (!list.isEmpty())
            {
                callback.a(list.get(0));
                return;
            } else
            {
                callback.a(null);
                return;
            }
        }

        public void b(Object obj)
        {
            a((x)obj);
        }
    }

}
