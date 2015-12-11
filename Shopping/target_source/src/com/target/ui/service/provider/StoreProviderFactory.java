// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service.provider;

import android.content.Context;
import android.os.Parcel;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;

// Referenced classes of package com.target.ui.service.provider:
//            r

public class StoreProviderFactory
{

    private Context mContext;

    public StoreProviderFactory(Context context)
    {
        mContext = context;
    }

    public r a(final Store store)
    {
        return new r() {

            final StoreProviderFactory this$0;
            final Store val$store;

            public Store a()
            {
                return store;
            }

            
            {
                this$0 = StoreProviderFactory.this;
                store = store1;
                super();
            }
        };
    }

    // Unreferenced inner class com/target/ui/service/provider/StoreProviderFactory$3

/* anonymous class */
    class _cls3
        implements Store
    {

        final StoreProviderFactory this$0;
        final String val$storeId;

        public int describeContents()
        {
            return 0;
        }

        public StoreIdentifier getStoreId()
        {
            return new StoreIdentifier(storeId);
        }

        public void writeToParcel(Parcel parcel, int i)
        {
        }
    }

}
