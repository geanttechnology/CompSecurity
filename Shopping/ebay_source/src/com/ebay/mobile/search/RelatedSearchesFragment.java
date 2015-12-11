// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.shell.app.HeaderViewListFragment;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.ArrayList;

public class RelatedSearchesFragment extends HeaderViewListFragment
{

    public static final String ARG_TEXT = "header";
    private ArrayList relatedSearches;

    public RelatedSearchesFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setListAdapter(new ArrayAdapter(getActivity(), 0x7f03007a, 0x1020014, relatedSearches));
        setListShown(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        relatedSearches = getArguments().getStringArrayList("related_searches");
    }

    protected View[] onCreateHeaderViews(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Object obj = getArguments();
        if (obj != null)
        {
            obj = ((Bundle) (obj)).getString("header");
        } else
        {
            obj = null;
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            layoutinflater = (TextView)layoutinflater.inflate(0x7f030024, viewgroup, false);
            layoutinflater.setText(((CharSequence) (obj)));
            return (new View[] {
                layoutinflater
            });
        } else
        {
            return super.onCreateHeaderViews(layoutinflater, viewgroup, bundle);
        }
    }

    public void onListItemClick(ListView listview, View view, int i, long l)
    {
        listview = getActivity();
        view = new TrackingData("RelatedSearchAvailable", TrackingType.EVENT);
        view.addKeyValuePair("mfls", "srs");
        view.send(listview);
        Object obj = listview.getIntent();
        view = ((Intent) (obj)).getStringExtra("com.ebay.mobile.tracking.BidSource");
        String s = ((Intent) (obj)).getStringExtra("com.ebay.mobile.tracking.Referrer");
        obj = (SearchParameters)((Intent) (obj)).getParcelableExtra("search_param");
        obj.keywords = (String)getListView().getItemAtPosition(i);
        Intent intent = new Intent(listview, com/ebay/mobile/search/SearchResultFragmentActivity$RelatedSearchesResultsActivity);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", view);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", s);
        intent.putExtra("search_param", ((android.os.Parcelable) (obj)));
        if (listview instanceof TrackingSupport)
        {
            intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(((TrackingSupport)listview).getTrackingEventName()));
        }
        startActivity(intent);
    }

    protected void setListMargins(Context context, android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
    {
        int i = (int)context.getResources().getDimension(0x7f090007);
        marginlayoutparams.setMargins(i, 0, i, 0);
    }
}
