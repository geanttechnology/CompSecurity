// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import com.target.mothership.model.h;
import com.target.mothership.services.x;
import java.util.List;

// Referenced classes of package com.target.ui.view.store:
//            StoreChooserSelectionView

class this._cls0 extends h
{

    final StoreChooserSelectionView this$0;

    public void a(x x1)
    {
        if (StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
        {
            return;
        } else
        {
            StoreChooserSelectionView.b(StoreChooserSelectionView.this);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((List)obj);
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

    public void b(Object obj)
    {
        a((x)obj);
    }

    ()
    {
        this$0 = StoreChooserSelectionView.this;
        super();
    }
}
