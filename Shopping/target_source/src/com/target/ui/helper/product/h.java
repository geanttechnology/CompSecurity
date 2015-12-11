// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.product;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.c;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.x;
import com.target.ui.service.k;
import com.target.ui.util.q;

public class h
{
    public static interface a
    {

        public abstract void a(RelevantStoreSummary relevantstoresummary);

        public abstract void w();
    }


    private static final String TAG = com/target/ui/helper/product/h.getSimpleName();
    private final String mRequestTag = String.valueOf(hashCode());
    private final c mStoreManger = new c();

    public h()
    {
    }

    static String a(h h1)
    {
        return h1.mRequestTag;
    }

    static String b()
    {
        return TAG;
    }

    public void a()
    {
        q.c(TAG, "StoreDataHelper : Cancel Requested");
        mStoreManger.a(mRequestTag);
    }

    public void a(Store store, final a listener)
    {
        if (store == null)
        {
            listener.w();
            return;
        } else
        {
            store = new StoreIdentifier(store.getStoreId().a());
            k.a().a(store, new com.target.mothership.model.h() {

                final h this$0;
                final a val$listener;

                public String a()
                {
                    return h.a(h.this);
                }

                public void a(RelevantStoreSummary relevantstoresummary)
                {
                    listener.a(relevantstoresummary);
                }

                public void a(x x1)
                {
                    if (x1 == null)
                    {
                        x1 = "";
                    } else
                    {
                        x1 = x1.getMessage();
                    }
                    q.a(h.b(), (new StringBuilder()).append("Error getting product details: ").append(x1).toString());
                    listener.w();
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
                this$0 = h.this;
                listener = a1;
                super();
            }
            });
            return;
        }
    }

}
