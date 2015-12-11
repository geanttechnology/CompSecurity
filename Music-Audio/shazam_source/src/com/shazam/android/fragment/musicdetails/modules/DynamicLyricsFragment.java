// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.musicdetails.modules;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.advert.h.a;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.k.b.c;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.lyrics.DynamicLyricsScrollView;
import com.shazam.c.p;
import com.shazam.g.e;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.lyrics.DynamicLyricsData;
import com.shazam.model.lyrics.LyricPlay;
import java.util.List;

public class DynamicLyricsFragment extends BaseFragment
    implements a, com.shazam.p.l.a
{

    private com.shazam.l.j.a a;
    private DynamicLyricsScrollView b;
    private com.shazam.android.r.a c;

    public DynamicLyricsFragment()
    {
    }

    public static Fragment a(Uri uri)
    {
        DynamicLyricsFragment dynamiclyricsfragment = new DynamicLyricsFragment();
        dynamiclyricsfragment.setArguments(new Bundle());
        dynamiclyricsfragment.getArguments().putParcelable("shazamUri", uri);
        return dynamiclyricsfragment;
    }

    public final void a(DynamicLyricsData dynamiclyricsdata)
    {
        b.a(dynamiclyricsdata, 0, dynamiclyricsdata.lyricPlay.payload.size() - 1);
        c = new com.shazam.android.r.a(dynamiclyricsdata.tagTimestamp, dynamiclyricsdata.lyricPlay);
        c.a(b);
        (new Thread(c, "Dynamic Lyrics Position Notifier")).start();
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.LYRIC_PLAY);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a = new com.shazam.l.j.a(this, new c((Uri)getArguments().getParcelable("shazamUri"), new p(), getLoaderManager(), 1));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030045, viewgroup, false));
    }

    public void onPause()
    {
        super.onPause();
        a.a.b();
        if (c != null)
        {
            c.a();
        }
    }

    public void onResume()
    {
        super.onResume();
        com.shazam.l.j.a a1 = a;
        a1.a.a(a1);
        a1.a.a();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b = (DynamicLyricsScrollView)view.findViewById(0x7f11014d);
    }
}
