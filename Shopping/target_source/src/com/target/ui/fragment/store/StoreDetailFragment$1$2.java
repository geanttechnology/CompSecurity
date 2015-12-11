// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.StoreCapability;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.services.x;
import com.target.ui.view.store.StoreDetailView;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreDetailFragment, StoreHoursDialogFragment

class this._cls1
    implements com.target.ui.view.store._cls1._cls2
{

    final .TAG this$1;

    public void a(StoreCapability storecapability)
    {
        while (Z() || storecapability.b().isEmpty() && storecapability.c().isEmpty()) 
        {
            return;
        }
        StoreHoursDialogFragment.a(storecapability).show(getFragmentManager(), StoreHoursDialogFragment.TAG);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/fragment/store/StoreDetailFragment$1

/* anonymous class */
    class StoreDetailFragment._cls1 extends h
    {

        final StoreDetailFragment this$0;

        public void a(final StoreDetail response)
        {
            if (StoreDetailFragment.a(StoreDetailFragment.this) == null)
            {
                return;
            } else
            {
                StoreDetailFragment.a(StoreDetailFragment.this, false);
                StoreDetailFragment.a(StoreDetailFragment.this).a(response);
                StoreDetailFragment.a(StoreDetailFragment.this).setDetailsClickedListener(new StoreDetailFragment._cls1._cls1());
                StoreDetailFragment.a(StoreDetailFragment.this).setStoreCapabilityClickedListener(new StoreDetailFragment._cls1._cls2());
                return;
            }
        }

        public void a(x x1)
        {
        }

        public volatile void a(Object obj)
        {
            a((StoreDetail)obj);
        }

        public void b(Object obj)
        {
            a((x)obj);
        }

            
            {
                this$0 = StoreDetailFragment.this;
                super();
            }

        // Unreferenced inner class com/target/ui/fragment/store/StoreDetailFragment$1$1

/* anonymous class */
        class StoreDetailFragment._cls1._cls1
            implements com.target.ui.view.store.StoreDetailHeaderView.a
        {

            final StoreDetailFragment._cls1 this$1;
            final StoreDetail val$response;

            public void a()
            {
                if (Z())
                {
                    return;
                } else
                {
                    StoreHoursDialogFragment.a(response).show(getFragmentManager(), StoreHoursDialogFragment.TAG);
                    return;
                }
            }

                    
                    {
                        this$1 = StoreDetailFragment._cls1.this;
                        response = storedetail;
                        super();
                    }
        }

    }

}
