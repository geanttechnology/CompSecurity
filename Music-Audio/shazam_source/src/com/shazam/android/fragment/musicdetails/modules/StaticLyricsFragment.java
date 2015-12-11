// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.musicdetails.modules;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.shazam.android.advert.h.a;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.c.r;
import com.shazam.g.e;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.lyrics.StaticLyricsData;
import com.shazam.p.l.c;

public class StaticLyricsFragment extends BaseFragment
    implements a, c
{

    private com.shazam.l.j.c a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ScrollView e;

    public StaticLyricsFragment()
    {
    }

    public static Fragment a(Uri uri)
    {
        StaticLyricsFragment staticlyricsfragment = new StaticLyricsFragment();
        staticlyricsfragment.setArguments(new Bundle());
        staticlyricsfragment.getArguments().putParcelable("shazamUri", uri);
        return staticlyricsfragment;
    }

    public final void a(StaticLyricsData staticlyricsdata)
    {
        b.setText(staticlyricsdata.lyrics);
        Resources resources = getResources();
        String s = String.format("%s%s", new Object[] {
            resources.getString(0x7f09019c), staticlyricsdata.copyright
        });
        c.setText(s);
        staticlyricsdata = (new StringBuilder()).append(resources.getString(0x7f090290)).append(staticlyricsdata.writers).toString();
        d.setText(staticlyricsdata);
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.LYRICS);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a = new com.shazam.l.j.c(this, new com.shazam.android.k.b.c((Uri)getArguments().getParcelable("shazamUri"), new r(), getLoaderManager(), 1));
        if (bundle != null)
        {
            e.scrollTo(0, bundle.getInt("SCROLL_POSITION", 0));
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030059, viewgroup, false));
    }

    public void onPause()
    {
        super.onPause();
        a.a.b();
    }

    public void onResume()
    {
        super.onResume();
        com.shazam.l.j.c c1 = a;
        c1.a.a(c1);
        c1.a.a();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SCROLL_POSITION", e.getScrollY());
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b = (TextView)view.findViewById(0x7f110199);
        c = (TextView)view.findViewById(0x7f11019b);
        d = (TextView)view.findViewById(0x7f11019a);
        e = (ScrollView)view.findViewById(0x7f110198);
    }
}
