// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.store.StoreChooserEnableLocationServicesView;
import com.target.ui.view.store.StoreChooserNoLocationServicesView;
import com.target.ui.view.store.StoreChooserSelectionView;

// Referenced classes of package com.target.ui.fragment.store:
//            StoreChooserDialogFragment

private static class progressContainer
{

    public TextView dialogTitle;
    public StoreChooserEnableLocationServicesView enableLocationServicesWrapper;
    public StoreChooserNoLocationServicesView locationServicesOffWrapper;
    public View progressContainer;
    public StoreChooserSelectionView storeListWrapper;

    public w(View view)
    {
        enableLocationServicesWrapper = (StoreChooserEnableLocationServicesView)view.findViewById(0x7f10021c);
        locationServicesOffWrapper = (StoreChooserNoLocationServicesView)view.findViewById(0x7f10021d);
        storeListWrapper = (StoreChooserSelectionView)view.findViewById(0x7f10021e);
        dialogTitle = (TextView)view.findViewById(0x7f10021b);
        progressContainer = view.findViewById(0x7f1001fa);
    }
}
