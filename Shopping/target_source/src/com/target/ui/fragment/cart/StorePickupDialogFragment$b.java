// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.view.View;
import android.widget.ListView;
import com.target.ui.view.ZipCodeChooserView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.cart:
//            StorePickupDialogFragment

private static class zipCodeChooserView
{

    private TargetErrorView errorContainer;
    private ListView listView;
    private View noStoresContainer;
    private View progressContainer;
    private ZipCodeChooserView zipCodeChooserView;

    static ZipCodeChooserView a(zipCodeChooserView zipcodechooserview)
    {
        return zipcodechooserview.zipCodeChooserView;
    }

    static TargetErrorView b(zipCodeChooserView zipcodechooserview)
    {
        return zipcodechooserview.errorContainer;
    }

    static View c(errorContainer errorcontainer)
    {
        return errorcontainer.noStoresContainer;
    }

    static View d(noStoresContainer nostorescontainer)
    {
        return nostorescontainer.progressContainer;
    }

    static ListView e(progressContainer progresscontainer)
    {
        return progresscontainer.listView;
    }

    public (View view)
    {
        progressContainer = view.findViewById(0x7f1001fa);
        noStoresContainer = view.findViewById(0x7f10031e);
        errorContainer = (TargetErrorView)view.findViewById(0x7f10031f);
        listView = (ListView)view.findViewById(0x7f100320);
        zipCodeChooserView = (ZipCodeChooserView)view.findViewById(0x7f100321);
    }
}
