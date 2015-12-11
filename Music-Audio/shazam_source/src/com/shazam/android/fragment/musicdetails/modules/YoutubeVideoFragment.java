// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.musicdetails.modules;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.a.a.c;
import com.google.android.a.a.d;
import com.shazam.android.activities.modules.VideoActivity;
import com.shazam.android.advert.h.a;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.DetailsPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.RetryFragment;
import com.shazam.android.fragment.e;
import com.shazam.android.k.e.ac;
import com.shazam.android.k.f.r;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.video.YoutubePlaylistListView;
import com.shazam.i.d.h;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.share.ShareData;
import com.shazam.model.video.RelatedVideo;
import com.shazam.model.video.Video;
import com.shazam.model.video.VideoData;
import com.shazam.o.b;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class YoutubeVideoFragment extends BaseFragment
    implements com.google.android.a.a.c.b, a, SessionConfigurable, e, com.shazam.android.widget.video.a, com.shazam.p.r.a
{

    public c a;
    private YoutubePlaylistListView aj;
    private View ak;
    private View al;
    private View am;
    private ShareData an;
    private View c;
    private String d;
    private com.shazam.l.r.a e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;

    public YoutubeVideoFragment()
    {
        an = com.shazam.model.share.ShareData.Builder.a().b();
    }

    public static Fragment a(Uri uri, String s)
    {
        YoutubeVideoFragment youtubevideofragment = new YoutubeVideoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("shazamUri", uri);
        bundle.putString("videoUrl", s);
        youtubevideofragment.setArguments(bundle);
        return youtubevideofragment;
    }

    private Uri e()
    {
        return (Uri)getArguments().getParcelable("shazamUri");
    }

    public final void a()
    {
        if (isAdded())
        {
            d();
        }
    }

    public final void a(c c1, boolean flag)
    {
        a = c1;
        c1.a(2);
        c1.a(1);
        if (!flag && com.shazam.b.e.a.c(d) && isAdded())
        {
            c1.a(new _cls1());
            c1.a(d);
        }
    }

    public final void a(ShareData sharedata)
    {
        an = sharedata;
        getActivity().supportInvalidateOptionsMenu();
    }

    public final void a(RelatedVideo relatedvideo)
    {
        startActivity(VideoActivity.a(getActivity(), relatedvideo.videoUrl, e()));
    }

    public final void a(VideoData videodata)
    {
        ak.setVisibility(8);
        al.setVisibility(0);
        Video video;
        d d1;
        d d2;
        if (b.b(videodata.videos))
        {
            video = (Video)videodata.videos.get(0);
        } else
        {
            video = com.shazam.model.video.Video.Builder.a().b();
        }
        d = video.videoId;
        d2 = (d)getFragmentManager().a("tag_youtube_fragment");
        d1 = d2;
        if (d2 == null)
        {
            d1 = new d();
            d1.a = com.google.android.a.a.a.b.a(getString(0x7f0901c4), "Developer key cannot be null or empty");
            d1.b = this;
            d1.a();
        }
        getFragmentManager().a().b(0x7f1101af, d1, "tag_youtube_fragment").b();
        am.setVisibility(0);
        f.setText(video.title);
        g.setText(video.author);
        h.setText(getString(0x7f09015c, new Object[] {
            NumberFormat.getInstance().format(video.viewCount)
        }));
        if (videodata.relatedVideos != null)
        {
            videodata = videodata.relatedVideos;
        } else
        {
            videodata = new ArrayList();
        }
        if (!videodata.isEmpty())
        {
            aj.a(videodata);
            i.setText(getString(0x7f0900fb).replace("%@", String.valueOf(videodata.size())));
            i.setVisibility(0);
        }
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        page.populateFromShazamUri(r.a(e()));
        page.setPageName("Video");
    }

    public final void d()
    {
        ak.setVisibility(8);
        al.setVisibility(8);
        getChildFragmentManager().a().b(0x7f1101ae, RetryFragment.a("Video"), "tag_retry_fragment").a();
    }

    public final AdvertSiteIdKey f()
    {
        boolean flag = true;
        if (getResources().getConfiguration().orientation != 1)
        {
            flag = false;
        }
        if (flag)
        {
            return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.VIDEOS);
        } else
        {
            return null;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = com.shazam.i.d.d.l();
        e = new com.shazam.l.r.a(this, new com.shazam.android.k.b.a(getLoaderManager(), 107, getActivity(), com.shazam.android.k.c.a(new ac(com.shazam.i.c.b.a(), getArguments().getString("videoUrl")), com.shazam.i.d.h.a()), com.shazam.android.k.b.i.b), new com.shazam.android.k.b.c(e(), bundle, getLoaderManager(), 1), new com.shazam.android.l.j.d());
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menuinflater.inflate(0x7f130006, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = BannerAdLayout.a(layoutinflater.inflate(0x7f03005e, viewgroup, false));
        c = layoutinflater;
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131821200: 
            menuitem = com.shazam.model.share.ShareData.Builder.a(an);
            break;
        }
        menuitem.screenName = "video";
        menuitem = menuitem.b();
        (new com.shazam.android.widget.share.d()).a(menuitem, r.a(e()), c);
        return true;
    }

    public void onPause()
    {
        super.onPause();
        com.shazam.l.r.a a1 = e;
        a1.b.b();
        a1.c.b();
        aj.a = com.shazam.android.widget.video.a.b;
        if (a != null)
        {
            a.a();
        }
    }

    public void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(0x7f110290).setVisible(an.b());
    }

    public void onResume()
    {
        super.onResume();
        k k1 = getFragmentManager();
        Fragment fragment = k1.a("tag_youtube_fragment");
        if (fragment != null)
        {
            k1.a().a(fragment).a();
        }
        e.a();
        aj.setRelatedVideoClickedListener(this);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        i = (TextView)view.findViewById(0x7f1101b5);
        aj = (YoutubePlaylistListView)view.findViewById(0x7f1101b6);
        f = (TextView)view.findViewById(0x7f1101b2);
        g = (TextView)view.findViewById(0x7f1101b3);
        h = (TextView)view.findViewById(0x7f1101b4);
        ak = view.findViewById(0x7f110120);
        al = view.findViewById(0x7f1101b0);
        am = view.findViewById(0x7f1101b1);
    }

    public final void t_()
    {
        Fragment fragment = getChildFragmentManager().a("tag_retry_fragment");
        if (fragment != null)
        {
            getChildFragmentManager().a().a(fragment).a();
        }
        ak.setVisibility(0);
        e.a();
    }

    /* member class not found */
    class _cls1 {}

}
