// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.streaming;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shazam.android.activities.streaming.b;
import com.shazam.android.an.b.p;
import com.shazam.android.an.f;
import com.shazam.android.an.g;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ConfigurablePage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.RetryFragment;
import com.shazam.android.fragment.e;
import com.shazam.android.widget.playlist.StreamingPlaylistContainerView;
import com.shazam.android.widget.text.CustomFontTextView;
import com.shazam.i.b.ai.d;
import com.shazam.i.b.c;
import com.shazam.model.Factory;
import com.shazam.model.playlist.CategorisedStreamingPlaylists;
import com.shazam.model.playlist.StreamingPlaylistType;
import com.shazam.p.o.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamingPlaylistsFragment extends BaseFragment
    implements SessionConfigurable, e, a
{

    private final EventAnalytics b = com.shazam.i.b.g.b.a.a();
    private final LayoutInflater c = LayoutInflater.from(com.shazam.i.b.c.a());
    private final Map d;
    private com.shazam.g.e e;
    private g f;
    private com.shazam.l.q.a g;
    private View h;
    private ViewGroup i;

    public StreamingPlaylistsFragment()
    {
        d = com.shazam.b.b.d.a(b.a, new f(com.shazam.i.b.ai.d.a(), new com.shazam.android.v.g.c(com.shazam.i.b.ai.a.b.a(), new com.shazam.c.m.b(new com.shazam.c.m.a(), com.shazam.i.b.c.a().getResources().getString(0x7f0900ee), com.shazam.i.b.c.a().getResources().getString(0x7f0900f1)))), b.b, new f(com.shazam.i.b.ai.d.b(), new com.shazam.android.v.g.e(com.shazam.i.b.c.a(), com.shazam.android.k.c.a(com.shazam.i.b.ai.b.d.a(), new p(com.shazam.i.b.c.a().getResources().getString(0x7f0900ee))))));
    }

    public static Fragment a(b b1, String s)
    {
        StreamingPlaylistsFragment streamingplaylistsfragment = new StreamingPlaylistsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("param_streaming_provider", b1);
        bundle.putString("param_playback_key", s);
        streamingplaylistsfragment.setArguments(bundle);
        return streamingplaylistsfragment;
    }

    static b a(StreamingPlaylistsFragment streamingplaylistsfragment)
    {
        return streamingplaylistsfragment.d();
    }

    static String b(StreamingPlaylistsFragment streamingplaylistsfragment)
    {
        return streamingplaylistsfragment.getArguments().getString("param_playback_key");
    }

    static g c(StreamingPlaylistsFragment streamingplaylistsfragment)
    {
        return streamingplaylistsfragment.f;
    }

    private b d()
    {
        return (b)getArguments().getSerializable("param_streaming_provider");
    }

    static EventAnalytics d(StreamingPlaylistsFragment streamingplaylistsfragment)
    {
        return streamingplaylistsfragment.b;
    }

    private String e()
    {
        return (new StringBuilder()).append(getString(d().d).toLowerCase()).append("playlist").toString();
    }

    public final void a()
    {
        for (int j = 0; j < i.getChildCount(); j++)
        {
            i.getChildAt(j).setVisibility(8);
        }

        h.setVisibility(8);
        getChildFragmentManager().a().b(0x7f11019d, RetryFragment.a(e()), "retry_fragment_tag").a();
    }

    public final void a(CategorisedStreamingPlaylists categorisedstreamingplaylists)
    {
        h.setVisibility(4);
        categorisedstreamingplaylists = categorisedstreamingplaylists.streamingPlaylistsMap.entrySet().iterator();
        while (categorisedstreamingplaylists.hasNext()) 
        {
            Object obj = (java.util.Map.Entry)categorisedstreamingplaylists.next();
            StreamingPlaylistType streamingplaylisttype = (StreamingPlaylistType)((java.util.Map.Entry) (obj)).getKey();
            obj = (List)((java.util.Map.Entry) (obj)).getValue();
            StreamingPlaylistContainerView streamingplaylistcontainerview = (StreamingPlaylistContainerView)c.inflate(0x7f0300b3, i, false);
    /* block-local class not found */
    class a {}

            streamingplaylistcontainerview.setOnItemClickListener(new a(((List) (obj))));
            if (com.shazam.o.b.a(((java.util.Collection) (obj))))
            {
                streamingplaylistcontainerview.setVisibility(8);
            } else
            {
                if (streamingplaylistcontainerview.getHeaderViewsCount() == 0 && com.shazam.b.e.a.c(streamingplaylisttype.value))
                {
                    CustomFontTextView customfonttextview = new CustomFontTextView(streamingplaylistcontainerview.getContext());
                    customfonttextview.setText(streamingplaylisttype.value);
                    customfonttextview.setAllCaps(true);
                    customfonttextview.setTextSize(14F);
                    customfonttextview.setPadding(streamingplaylistcontainerview.getResources().getDimensionPixelSize(0x7f0a00cc), 0, 0, 0);
                    customfonttextview.setHeight(streamingplaylistcontainerview.getResources().getDimensionPixelSize(0x7f0a00cb));
                    customfonttextview.setGravity(16);
                    customfonttextview.setTextColor(streamingplaylistcontainerview.getResources().getColor(0x7f0f0061));
                    customfonttextview.a(0x7f090247);
                    streamingplaylistcontainerview.addHeaderView(customfonttextview);
                }
                streamingplaylistcontainerview.setAdapter(new com.shazam.android.widget.k.b(streamingplaylistcontainerview.getContext(), ((List) (obj))));
                streamingplaylistcontainerview.setVisibility(0);
            }
            i.addView(streamingplaylistcontainerview);
        }
    }

    public void configureWith(Page page)
    {
        ((ConfigurablePage)page).setPageName(e());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        g = new com.shazam.l.q.a(this, e);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = (f)d.get(d());
        e = (com.shazam.g.e)((f) (bundle)).b.create(getLoaderManager());
        f = ((f) (bundle)).a;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        i = (ViewGroup)layoutinflater.inflate(0x7f03005a, viewgroup, false);
        h = i.findViewById(0x7f11019e);
        return i;
    }

    public void onResume()
    {
        super.onResume();
        g.a();
    }

    public final void t_()
    {
        Fragment fragment = getChildFragmentManager().a("retry_fragment_tag");
        if (fragment != null)
        {
            getChildFragmentManager().a().a(fragment).a();
        }
        h.setVisibility(0);
        g.a();
    }
}
