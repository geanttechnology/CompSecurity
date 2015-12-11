// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cart:
//            StorePickupDialogFragment

class this._cls0 extends com.target.ui.service.ent._cls2
{

    final StorePickupDialogFragment this$0;

    public void a(com.target.ui.service.ent._cls2 _pcls2, x x)
    {
        if (StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
        {
            return;
        } else
        {
            StorePickupDialogFragment.a(StorePickupDialogFragment.this, true);
            return;
        }
    }

    public void a(List list)
    {
        if (StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
        {
            return;
        } else
        {
            StorePickupDialogFragment.a(StorePickupDialogFragment.this, list, true);
            return;
        }
    }

    public void onResult(Object obj)
    {
        a((List)obj);
    }

    ()
    {
        this$0 = StorePickupDialogFragment.this;
        super();
    }
}
