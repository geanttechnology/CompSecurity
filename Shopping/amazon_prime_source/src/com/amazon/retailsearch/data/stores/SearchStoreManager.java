// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.stores;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.data.stores:
//            StoreManager, SearchStore

public class SearchStoreManager
    implements StoreManager
{

    private static final String TAG = com/amazon/retailsearch/data/stores/SearchStoreManager.getSimpleName();
    private final String AMAZON_STORE_NAME = "Amazon";
    private boolean invalidated;
    private boolean isMultiStoreOffersEnabled;
    private Map storeMap;

    public SearchStoreManager()
    {
        invalidated = true;
        isMultiStoreOffersEnabled = false;
    }

    private SearchStore getSearchStore(String s)
    {
        if (TextUtils.isEmpty(s) || storeMap == null)
        {
            return null;
        } else
        {
            return (SearchStore)storeMap.get(s);
        }
    }

    public String getStoreBadgeUrl(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = getSearchStore(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        boolean flag = TextUtils.isEmpty(s.getBadgeUrl());
        if (!flag) goto _L3; else goto _L2
_L2:
        s = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return s;
_L3:
        s = s.getBadgeUrl();
        if (true) goto _L5; else goto _L4
_L4:
        s;
        throw s;
    }

    public String getStoreColor(String s)
    {
        s = getSearchStore(s);
        if (s == null || TextUtils.isEmpty(s.getStoreColor()))
        {
            return null;
        } else
        {
            return s.getStoreColor();
        }
    }

    public int getStoreCount()
    {
        if (storeMap == null)
        {
            return 0;
        } else
        {
            return storeMap.size();
        }
    }

    public String getStoreName(String s)
    {
        s = getSearchStore(s);
        if (s == null || TextUtils.isEmpty(s.getStoreName()))
        {
            return null;
        } else
        {
            return s.getStoreName();
        }
    }

    public boolean isMultiStoreOffersEnabled()
    {
        this;
        JVM INSTR monitorenter ;
        if (!invalidated) goto _L2; else goto _L1
_L1:
        if (storeMap != null && !storeMap.isEmpty()) goto _L4; else goto _L3
_L3:
        isMultiStoreOffersEnabled = false;
_L5:
        invalidated = false;
_L2:
        boolean flag = isMultiStoreOffersEnabled;
        this;
        JVM INSTR monitorexit ;
        return flag;
_L4:
        if (storeMap.size() != 1 || !"Amazon".equalsIgnoreCase(((SearchStore)storeMap.values().toArray()[0]).getStoreName()))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        isMultiStoreOffersEnabled = false;
          goto _L5
        Exception exception;
        exception;
        throw exception;
        isMultiStoreOffersEnabled = true;
          goto _L5
    }

    public void updateStoreMap(Map map)
    {
        this;
        JVM INSTR monitorenter ;
        storeMap = map;
        invalidated = true;
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

}
