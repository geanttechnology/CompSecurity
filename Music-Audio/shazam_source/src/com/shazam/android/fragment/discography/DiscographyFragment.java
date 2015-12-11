// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.discography;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.shazam.android.advert.h.a;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.DetailsPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.k.c;
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.g;
import com.shazam.android.k.f.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.g.e;
import com.shazam.i.b.au.d;
import com.shazam.i.c.b;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.discography.Discography;

public class DiscographyFragment extends BaseFragment
    implements a, SessionConfigurable, com.shazam.p.f.a
{

    private ListView a;
    private com.shazam.l.f.a b;
    private final s c;
    private final ac d;

    public DiscographyFragment()
    {
        this(((ac) (new g(com.shazam.i.b.l.a.a()))), com.shazam.i.b.au.d.a());
    }

    private DiscographyFragment(ac ac1, s s1)
    {
        d = ac1;
        c = s1;
    }

    public static DiscographyFragment a(Bundle bundle, Uri uri, r r1)
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle = new DiscographyFragment();
        bundle.setArguments(bundle1);
        if (r1 != null)
        {
            bundle.getArguments().putParcelable("shazamUri", r1.a);
        }
        bundle.getArguments().putParcelable("dataUri", uri);
        return bundle;
    }

    static r a(DiscographyFragment discographyfragment)
    {
        return discographyfragment.d();
    }

    private r d()
    {
        return r.a((Uri)getArguments().getParcelable("shazamUri"));
    }

    private Uri e()
    {
        return (Uri)getArguments().getParcelable("dataUri");
    }

    public final void a()
    {
        if (c != null)
        {
            s s1 = c;
            com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
            a1.a = 0x7f090077;
            a1.c = 1;
            s1.a(a1.a());
        }
        i j = getActivity();
        if (j != null)
        {
            j.finish();
        }
    }

    public final void a(Discography discography)
    {
        a.setAdapter(new com.shazam.android.a.c.a(getActivity(), discography.discographyItemList));
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        page.populateFromShazamUri(d());
        page.populateFromDataUri(e());
        page.setPageName("ShazamDiscography");
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.DISCOGRAPHY);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = d.a(e());
        b = new com.shazam.l.f.a(this, new com.shazam.android.k.b.d(getActivity().getSupportLoaderManager(), 11, getActivity().getBaseContext(), com.shazam.android.k.c.a(new com.shazam.android.k.e.h.a(com.shazam.i.c.b.a(), bundle), new com.shazam.c.e.a(new com.shazam.c.e.b()))));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030044, viewgroup, false));
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        a = null;
    }

    public void onPause()
    {
        super.onPause();
        b.b.b();
    }

    public void onResume()
    {
        super.onResume();
        com.shazam.l.f.a a1 = b;
        a1.b.a(new com.shazam.l.f.a.a(a1, (byte)0));
        a1.b.a();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a = (ListView)view.findViewById(0x7f11014c);
        a.setOnItemClickListener(new _cls1());
    }

    /* member class not found */
    class _cls1 {}

}
