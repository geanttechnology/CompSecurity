// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            BrowseFilterCategoriesPanel, DibicProgramFilter

public class NetworkBrowseFilterCategoriesPanel extends BrowseFilterCategoriesPanel
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/NetworkBrowseFilterCategoriesPanel);

    public NetworkBrowseFilterCategoriesPanel()
    {
    }

    public static NetworkBrowseFilterCategoriesPanel newInstance(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDualPanel", flag);
        NetworkBrowseFilterCategoriesPanel networkbrowsefiltercategoriespanel = new NetworkBrowseFilterCategoriesPanel();
        networkbrowsefiltercategoriespanel.setArguments(bundle);
        return networkbrowsefiltercategoriespanel;
    }

    protected void addNetworkCategoryView(DibicProgramFilter dibicprogramfilter)
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater.findViewById(com.xfinity.playerlib.R.id.subscription_only_checkbox_container).setVisibility(8);
        return layoutinflater;
    }

}
