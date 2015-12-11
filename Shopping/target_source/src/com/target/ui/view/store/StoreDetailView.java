// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.ui.adapter.i.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.store:
//            StoreDetailHeaderView

public class StoreDetailView extends ListView
{
    public static interface a
    {

        public abstract void a(StoreCapability storecapability);
    }


    private b mAdapter;
    private List mCapabilities;
    private StoreDetailHeaderView mHeaderView;
    private a mStoreCapabilityClickedListener;

    public StoreDetailView(Context context)
    {
        super(context);
        a();
    }

    public StoreDetailView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public StoreDetailView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static a a(StoreDetailView storedetailview)
    {
        return storedetailview.mStoreCapabilityClickedListener;
    }

    public void a()
    {
        mHeaderView = new StoreDetailHeaderView(getContext());
        addHeaderView(mHeaderView, null, false);
        mCapabilities = new ArrayList();
        mAdapter = new b(getContext(), mCapabilities);
        mAdapter.a(new com.target.ui.adapter.i.b.a() {

            final StoreDetailView this$0;

            public void a(StoreCapability storecapability)
            {
                if (StoreDetailView.a(StoreDetailView.this) == null)
                {
                    return;
                } else
                {
                    StoreDetailView.a(StoreDetailView.this).a(storecapability);
                    return;
                }
            }

            
            {
                this$0 = StoreDetailView.this;
                super();
            }
        });
        setAdapter(mAdapter);
    }

    public void a(StoreDetail storedetail)
    {
        mHeaderView.a(storedetail);
        mCapabilities.clear();
        mCapabilities.addAll(storedetail.f());
        mAdapter.notifyDataSetChanged();
    }

    public void setDetailsClickedListener(StoreDetailHeaderView.a a1)
    {
        mHeaderView.setDetailsClickedListener(a1);
    }

    public void setStoreCapabilityClickedListener(a a1)
    {
        mStoreCapabilityClickedListener = a1;
    }
}
