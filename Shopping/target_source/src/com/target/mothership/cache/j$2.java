// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

// Referenced classes of package com.target.mothership.cache:
//            j

class this._cls0
    implements this._cls0
{

    final j this$0;

    public void onFailure(Throwable throwable)
    {
        j.access$100(j.this);
    }

    public void onUpdateComplete()
    {
        j.access$202(j.this, true);
        j.access$300(j.this);
        PreferenceManager.getDefaultSharedPreferences(j.access$400(j.this)).edit().putLong("com.target.mothership.cache.StoreLocationCacheManager.STORE_LAST_UPDATED_NETWORK", System.currentTimeMillis()).apply();
    }

    s.Editor()
    {
        this$0 = j.this;
        super();
    }
}
