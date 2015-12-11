// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.e;

import android.os.Build;
import com.google.a.a.e;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.service.k;
import com.target.ui.service.provider.StoreProviderFactory;
import com.target.ui.service.provider.r;
import com.target.ui.vlc.VlcManager;
import com.target.ui.vlc.c;
import com.target.ui.vlc.d;
import com.target.ui.vlc.model.a;
import java.util.List;

public class i
    implements com.target.ui.service.k.c
{
    private class a
        implements com.target.ui.helper.k.a.a
    {

        private String mStoreId;
        final i this$0;

        public void a(Venue venue)
        {
            venue = (Zone)venue.getAllZones().get(0);
            com.target.ui.e.i.a(i.this, new com.target.ui.vlc.model.a(mStoreId, venue.getUUID()));
            i.this.a(new d(Build.DEVICE, com.target.ui.e.i.a(i.this)));
        }

        public void p_()
        {
        }

        public a(String s)
        {
            this$0 = i.this;
            super();
            mStoreId = s;
        }
    }


    private boolean mCameraAvailable;
    private boolean mInForeground;
    private com.target.ui.vlc.model.a mSiteInfo;
    private StoreProviderFactory mStoreProviderFactory;
    private com.target.ui.l.a mUserPreferenceService;
    private com.target.ui.helper.k.a mVenueDataHelper;
    private VlcManager mVlcManager;

    public i(StoreProviderFactory storeproviderfactory, com.target.ui.helper.k.a a1, VlcManager vlcmanager, com.target.ui.l.a a2)
    {
        mCameraAvailable = true;
        mStoreProviderFactory = storeproviderfactory;
        mVenueDataHelper = a1;
        mVlcManager = vlcmanager;
        mUserPreferenceService = a2;
    }

    static com.target.ui.vlc.model.a a(i j)
    {
        return j.mSiteInfo;
    }

    static com.target.ui.vlc.model.a a(i j, com.target.ui.vlc.model.a a1)
    {
        j.mSiteInfo = a1;
        return a1;
    }

    private void b(Store store)
    {
        store = mStoreProviderFactory.a(store).a().getStoreId().a();
        boolean flag;
        if (mSiteInfo == null || !store.equals(mSiteInfo.a()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!mVlcManager.b() || flag)
        {
            mVenueDataHelper.a(new a(store), store);
        }
    }

    private void g()
    {
        e e1 = k.a().a(this);
        if (e1.b())
        {
            a((Store)e1.c());
        }
    }

    private void h()
    {
        k.a().b(this);
        a();
    }

    public void a()
    {
        mVlcManager.a();
    }

    public void a(e e1)
    {
        if (e1.b())
        {
            b((Store)e1.c());
        }
    }

    public void a(Store store)
    {
        b(store);
    }

    public void a(c c1)
    {
        mVlcManager.a(c1);
    }

    public void a(d d1)
    {
        if (mInForeground && mCameraAvailable && mUserPreferenceService.c())
        {
            mSiteInfo = d1.siteInfo;
            mVlcManager.a(d1);
        }
    }

    public void b(c c1)
    {
        mVlcManager.b(c1);
    }

    public boolean b()
    {
        return mVlcManager.c();
    }

    public void c()
    {
        mInForeground = false;
        h();
    }

    public void d()
    {
        mInForeground = true;
        g();
    }

    public void e()
    {
        mCameraAvailable = true;
        g();
    }

    public void f()
    {
        mCameraAvailable = false;
        h();
    }
}
