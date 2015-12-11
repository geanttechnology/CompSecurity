// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreChooserDialogFragment

private class <init>
    implements com.target.ui.view.store.t.e
{

    final StoreChooserDialogFragment this$0;

    public void a()
    {
        dismiss();
    }

    public void a(StoreIdentifier storeidentifier)
    {
        dismiss();
        if (StoreChooserDialogFragment.c(StoreChooserDialogFragment.this) != null)
        {
            StoreChooserDialogFragment.c(StoreChooserDialogFragment.this).a(storeidentifier);
        }
    }

    public void a(StoreSummary storesummary)
    {
        dismiss();
        if (StoreChooserDialogFragment.c(StoreChooserDialogFragment.this) != null)
        {
            StoreChooserDialogFragment.c(StoreChooserDialogFragment.this).a(storesummary);
        }
        StoreChooserDialogFragment.a(StoreChooserDialogFragment.this, true);
    }

    public void b()
    {
        if (StoreChooserDialogFragment.d(StoreChooserDialogFragment.this) == null)
        {
            return;
        } else
        {
            al.b(StoreChooserDialogFragment.d(StoreChooserDialogFragment.this).progressContainer);
            return;
        }
    }

    public void c()
    {
        if (StoreChooserDialogFragment.d(StoreChooserDialogFragment.this) == null)
        {
            return;
        } else
        {
            al.c(StoreChooserDialogFragment.d(StoreChooserDialogFragment.this).progressContainer);
            return;
        }
    }

    private ()
    {
        this$0 = StoreChooserDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
