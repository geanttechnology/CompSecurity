// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import com.google.a.a.e;
import com.target.mothership.model.c.c.a;
import com.target.mothership.model.d;

// Referenced classes of package com.target.ui.view.store:
//            StoreChooserSelectionView

class this._cls0 extends d
{

    final StoreChooserSelectionView this$0;

    public void a(com.target.mothership.model.c.c.a.a a1)
    {
        if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
        {
            return;
        }
        if (StoreChooserSelectionView.c(StoreChooserSelectionView.this) != null)
        {
            StoreChooserSelectionView.c(StoreChooserSelectionView.this).c();
        }
        com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, 0x7f090518);
    }

    public void a(a a1)
    {
        if (com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this) == null)
        {
            return;
        }
        if (a1.d().b() && a1.e().b())
        {
            com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, ((Double)a1.d().c()).doubleValue(), ((Double)a1.e().c()).doubleValue());
            return;
        }
        if (StoreChooserSelectionView.c(StoreChooserSelectionView.this) != null)
        {
            StoreChooserSelectionView.c(StoreChooserSelectionView.this).c();
        }
        com.target.ui.view.store.StoreChooserSelectionView.a(StoreChooserSelectionView.this, 0x7f090518);
    }

    public volatile void a(Object obj)
    {
        a((a)obj);
    }

    public void b(Object obj)
    {
        a((com.target.mothership.model.c.c.a.a)obj);
    }

    ()
    {
        this$0 = StoreChooserSelectionView.this;
        super();
    }
}
