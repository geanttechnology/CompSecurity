// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.mothership.common.product.Barcode;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.analytics.a.m;
import com.target.ui.f.c;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.fragment.scan:
//            BaseScanFragment

public class SearchScanUpcFragment extends BaseScanFragment
    implements b.a.a.b.c.a
{
    private class a
    {

        final ViewGroup rootView;
        final SearchScanUpcFragment this$0;

        a(View view)
        {
            this$0 = SearchScanUpcFragment.this;
            super();
            rootView = (ViewGroup)view.findViewById(0x7f10020f);
        }
    }


    private static final String STORE_ARG = "storeArg";
    private static final String TAG = com/target/ui/fragment/scan/SearchScanUpcFragment.getSimpleName();
    private a mViews;

    public SearchScanUpcFragment()
    {
    }

    public static SearchScanUpcFragment a(Store store)
    {
        SearchScanUpcFragment searchscanupcfragment = new SearchScanUpcFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("storeArg", store);
        searchscanupcfragment.setArguments(bundle);
        return searchscanupcfragment;
    }

    private void a(Barcode barcode)
    {
        com.target.ui.util.e.a.a(this);
        m().i(ProductDetailsPageFragment.a(barcode, d()));
    }

    private void c()
    {
        mViews.rootView.addView(b());
        a(new b.a.a.b.a[] {
            b.a.a.b.a.f, b.a.a.b.a.g
        });
    }

    private Store d()
    {
        return (Store)getArguments().getParcelable("storeArg");
    }

    public void a(String s)
    {
        Object obj = RingtoneManager.getDefaultUri(2);
        obj = RingtoneManager.getRingtone(getActivity().getApplicationContext(), ((android.net.Uri) (obj)));
        if (obj != null)
        {
            ((Ringtone) (obj)).play();
        }
        a(new Barcode(s));
        m.a(s).e();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            j(getString(0x7f0904de));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        j(getActivity().getApplicationContext().getString(0x7f0904dd));
        layoutinflater = layoutinflater.inflate(0x7f030081, viewgroup, false);
        mViews = new a(layoutinflater);
        c();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews.rootView.removeAllViews();
        mViews = null;
    }

}
