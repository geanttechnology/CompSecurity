// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import com.target.mothership.common.store.StoreIdentifier;
import com.target.ui.f.c;
import com.target.ui.fragment.store.StoreChooserDialogFragment;
import com.target.ui.fragment.store.StoreDetailFragment;

// Referenced classes of package com.target.ui.fragment.common:
//            BaseNavigationFragment

public abstract class BaseStoreChooserFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.store.StoreChooserDialogFragment.c
{

    public BaseStoreChooserFragment()
    {
    }

    public void a(StoreIdentifier storeidentifier)
    {
        if (Z())
        {
            return;
        } else
        {
            m().d(StoreDetailFragment.a(storeidentifier));
            return;
        }
    }

    public abstract com.target.ui.fragment.store.StoreChooserDialogFragment.d g();

    protected void h()
    {
        if (Z())
        {
            return;
        } else
        {
            StoreChooserDialogFragment.a(g(), this).show(getFragmentManager(), StoreChooserDialogFragment.TAG);
            return;
        }
    }
}
