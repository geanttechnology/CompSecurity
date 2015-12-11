// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.poshmark.application.PMApplication;
import com.poshmark.data_model.adapters.AllBrandsAdapter;
import com.poshmark.db.PMDbContentProvider;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class AllBrandsFragment extends PMFragment
    implements android.support.v4.app.LoaderManager.LoaderCallbacks
{

    AllBrandsAdapter adapter;
    ListView brandsListView;

    public AllBrandsFragment()
    {
    }

    private void test(View view)
    {
        ((Button)view).setOnClickListener(new android.view.View.OnClickListener() {

            final AllBrandsFragment this$0;

            public void onClick(View view1)
            {
                PMApplication.getContext().getContentResolver().delete(PMDbContentProvider.CONTENT_URI_BRANDS, null, null);
            }

            
            {
                this$0 = AllBrandsFragment.this;
                super();
            }
        });
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        adapter = new AllBrandsAdapter(getActivity(), this, null, 0x80000000);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new CursorLoader(getActivity(), PMDbContentProvider.CONTENT_URI_BRANDS, null, "select * from brands", null, null);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f03000b, viewgroup, false);
        brandsListView = (ListView)layoutinflater.findViewById(0x7f0c0054);
        brandsListView.setAdapter(adapter);
        test(layoutinflater.findViewById(0x7f0c0055));
        getLoaderManager().initLoader(0, null, this);
        return layoutinflater;
    }

    public void onLoadFinished(Loader loader, Cursor cursor)
    {
        adapter.changeCursor(cursor);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Cursor)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        adapter.changeCursor(null);
    }

    public void setViewNameForAnalytics()
    {
    }
}
