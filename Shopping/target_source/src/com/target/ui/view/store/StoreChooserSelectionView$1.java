// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import com.target.mothership.services.g;
import com.target.mothership.services.x;
import com.target.ui.util.p;
import java.util.List;

// Referenced classes of package com.target.ui.view.store:
//            StoreChooserSelectionView

class this._cls0 extends com.target.ui.service.._cls1
{

    final StoreChooserSelectionView this$0;

    public void a(com.target.ui.service.._cls1 _pcls1, x x)
    {
        if (StoreChooserSelectionView.a(StoreChooserSelectionView.this) != null)
        {
            if (_pcls1 == com.target.ui.service.)
            {
                if (p.a(getContext()) && g.a().b() == null)
                {
                    StoreChooserSelectionView.a(StoreChooserSelectionView.this, true);
                    g.a().a(StoreChooserSelectionView.this);
                    return;
                }
            } else
            {
                StoreChooserSelectionView.b(StoreChooserSelectionView.this);
                return;
            }
        }
    }

    public void a(List list)
    {
        if (StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
        {
            return;
        } else
        {
            StoreChooserSelectionView.a(StoreChooserSelectionView.this, list);
            return;
        }
    }

    public void onResult(Object obj)
    {
        a((List)obj);
    }

    ()
    {
        this$0 = StoreChooserSelectionView.this;
        super();
    }
}
