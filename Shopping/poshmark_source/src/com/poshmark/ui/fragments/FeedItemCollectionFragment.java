// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.poshmark.data_model.adapters.ListingSummaryAdapter;
import com.poshmark.data_model.models.FeedItemCollection;
import com.poshmark.ui.customviews.PMListView;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class FeedItemCollectionFragment extends PMFragment
{

    private ListingSummaryAdapter adapter;
    private FeedItemCollection collection;
    private PMListView collectionListView;
    private String title;

    public FeedItemCollectionFragment()
    {
        adapter = null;
        title = new String("");
    }

    private void setupClosetList()
    {
        collectionListView = (PMListView)getView().findViewById(0x7f0c0118);
        collectionListView.setup(adapter, null, null, null);
        collectionListView.setListData(collection);
        collectionListView.updateList();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setupClosetList();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new ListingSummaryAdapter(getActivity(), this, null, 0x80000000);
        title = getArguments().getString("TITLE");
        collection = new FeedItemCollection();
        bundle = (List)getFragmentDataOfType(java/util/List);
        collection.setData(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030040, viewgroup, false);
    }

    public void onPMResume()
    {
        super.onPMResume();
        collectionListView.updateList();
    }

    public void onStop()
    {
        super.onStop();
        adapter.clearImageList();
    }

    public void setViewNameForAnalytics()
    {
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(title);
    }
}
