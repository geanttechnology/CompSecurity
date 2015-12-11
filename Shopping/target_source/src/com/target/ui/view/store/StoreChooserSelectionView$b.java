// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.target.ui.view.ZipCodeChooserView;

// Referenced classes of package com.target.ui.view.store:
//            StoreChooserSelectionView

private static class zipCodeChooser
{

    TextView errorMessage;
    ListView listView;
    View locationPendingWarning;
    View storesUpdatingWarning;
    ZipCodeChooserView zipCodeChooser;

    public (View view)
    {
        listView = (ListView)view.findViewById(0x7f100320);
        errorMessage = (TextView)view.findViewById(0x7f1005bd);
        locationPendingWarning = view.findViewById(0x7f1005bb);
        storesUpdatingWarning = view.findViewById(0x7f1005bc);
        zipCodeChooser = (ZipCodeChooserView)view.findViewById(0x7f100321);
    }
}
