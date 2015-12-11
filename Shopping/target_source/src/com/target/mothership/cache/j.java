// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.target.mothership.cache:
//            i

public class j
{
    public static interface a
    {

        public abstract void onStoreDatabaseUpdateFailed();

        public abstract void onStoreDatabaseUpdated();
    }


    private static final long ONE_MONTH_MS = 0x9a7ec800L;
    private static final String STORE_LAST_UPDATED_NETWORK = "com.target.mothership.cache.StoreLocationCacheManager.STORE_LAST_UPDATED_NETWORK";
    private static j mInstance;
    private Context mContext;
    private boolean mLastUpdateSucceeded;
    private CopyOnWriteArrayList mListeners;
    private boolean mUpdated;

    private j(Context context)
    {
        mContext = context;
        mListeners = new CopyOnWriteArrayList();
    }

    public static j getInstance()
    {
        if (mInstance == null)
        {
            throw new IllegalStateException("StoreLocationCacheManager was not initialized. Have you called StoreLocationCacheManager.init()?");
        } else
        {
            return mInstance;
        }
    }

    public static void init(Context context)
    {
        mInstance = new j(context);
    }

    private void notifyFailure()
    {
        mUpdated = true;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((a)iterator.next()).onStoreDatabaseUpdateFailed()) { }
    }

    private void notifyListeners()
    {
        mUpdated = true;
        for (Iterator iterator = mListeners.iterator(); iterator.hasNext(); ((a)iterator.next()).onStoreDatabaseUpdated()) { }
    }

    private void updateStoreCacheRemote()
    {
        i.updateStoreCache(new i.b() {

            final j this$0;

            public void onFailure(Throwable throwable)
            {
                notifyFailure();
            }

            public void onUpdateComplete()
            {
                mLastUpdateSucceeded = true;
                notifyListeners();
                PreferenceManager.getDefaultSharedPreferences(mContext).edit().putLong("com.target.mothership.cache.StoreLocationCacheManager.STORE_LAST_UPDATED_NETWORK", System.currentTimeMillis()).apply();
            }

            
            {
                this$0 = j.this;
                super();
            }
        });
    }

    public void addListener(a a1)
    {
label0:
        {
            mListeners.add(a1);
            if (mUpdated)
            {
                if (!mLastUpdateSucceeded)
                {
                    break label0;
                }
                a1.onStoreDatabaseUpdated();
            }
            return;
        }
        a1.onStoreDatabaseUpdateFailed();
    }

    public boolean isUpdated()
    {
        return mUpdated;
    }

    public void purgeStoreCache(i.b b)
    {
        i.rebuildStoreCache(b);
    }

    public void removeListener(a a1)
    {
        mListeners.remove(a1);
    }

    public void updateStoreCache()
    {
        mUpdated = false;
        mLastUpdateSucceeded = false;
        long l = PreferenceManager.getDefaultSharedPreferences(mContext).getLong("com.target.mothership.cache.StoreLocationCacheManager.STORE_LAST_UPDATED_NETWORK", 0L);
        int k = i.getStoreLocationsVersion();
        if (l + 0x9a7ec800L < System.currentTimeMillis() || k == 0)
        {
            if (k == 0)
            {
                i.initializeStoresFromFile(mContext.getAssets(), new i.b() {

                    final j this$0;

                    public void onFailure(Throwable throwable)
                    {
                        notifyFailure();
                    }

                    public void onUpdateComplete()
                    {
                        updateStoreCacheRemote();
                    }

            
            {
                this$0 = j.this;
                super();
            }
                });
                return;
            } else
            {
                updateStoreCacheRemote();
                return;
            }
        } else
        {
            mLastUpdateSucceeded = true;
            notifyListeners();
            return;
        }
    }




/*
    static boolean access$202(j j1, boolean flag)
    {
        j1.mLastUpdateSucceeded = flag;
        return flag;
    }

*/


}
