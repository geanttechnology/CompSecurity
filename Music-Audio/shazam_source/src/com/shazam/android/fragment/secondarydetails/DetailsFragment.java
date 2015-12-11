// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.secondarydetails;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.advert.h.a;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.DetailsPage;
import com.shazam.android.analytics.session.page.Page;
import com.shazam.android.aspects.fragments.advert.FragmentAdBinderAspect;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.fragment.musicdetails.k;
import com.shazam.android.k.b.c;
import com.shazam.android.k.e.p;
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.f;
import com.shazam.android.k.f.o;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.t;
import com.shazam.android.k.f.z;
import com.shazam.android.util.s;
import com.shazam.android.widget.EnhancedOverScrollView;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.android.widget.album.TrackContainerView;
import com.shazam.android.widget.h;
import com.shazam.android.widget.musicdetails.InteractiveInfoView;
import com.shazam.android.widget.musicdetails.MusicDetailsContentAnchorView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtGradientView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtSizeCapturingView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtSnapshotView;
import com.shazam.android.widget.musicdetails.MusicDetailsCoverArtView;
import com.shazam.android.widget.musicdetails.g;
import com.shazam.g.e;
import com.shazam.i.b.au.d;
import com.shazam.i.b.o.c.b;
import com.shazam.model.Track;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.details.BasicInfo;
import com.shazam.model.details.Blurb;
import com.shazam.model.details.InteractiveInfo;
import com.shazam.model.follow.FollowData;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.preview.PreviewViewDataUrlDecorator;
import com.shazam.model.rdio.RdioConnectionState;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import com.xrigau.syncscrolling.view.SynchronizedRelativeLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DetailsFragment extends BaseFragment
    implements a, SessionConfigurable, com.shazam.p.e.a
{

    public View a;
    private MusicDetailsCoverArtSizeCapturingView aj;
    private SynchronizedRelativeLayout ak;
    private com.shazam.android.fragment.musicdetails.a al;
    private TextView am;
    private InteractiveInfoView an;
    private View ao;
    private ShazamAdView ap;
    private MusicDetailsContentAnchorView aq;
    private TrackContainerView ar;
    private boolean as;
    private final ac at = new f();
    private final com.shazam.android.ak.a.b au = com.shazam.i.b.l.a.a();
    private final s av = com.shazam.i.b.au.d.a();
    private final o aw = com.shazam.i.b.o.c.b.a();
    private String ax;
    private AdvertSiteIdKey ay;
    private com.shazam.l.e.a c;
    private TextView d;
    private TextView e;
    private MusicDetailsCoverArtView f;
    private EnhancedOverScrollView g;
    private MusicDetailsCoverArtSnapshotView h;
    private MusicDetailsCoverArtGradientView i;

    public DetailsFragment()
    {
        al = com.shazam.android.fragment.musicdetails.a.a;
        ax = null;
    }

    public static DetailsFragment a(Uri uri, r r1)
    {
        DetailsFragment detailsfragment = new DetailsFragment();
        detailsfragment.setArguments(new Bundle());
        if (r1 != null)
        {
            detailsfragment.getArguments().putParcelable("shazamUri", r1.a);
        }
        detailsfragment.getArguments().putParcelable("dataUri", uri);
        return detailsfragment;
    }

    private Uri g()
    {
        return (Uri)getArguments().getParcelable("dataUri");
    }

    public final void a()
    {
        f.setVisibility(8);
        i.setVisibility(8);
        g.setVisibility(8);
        ao.setVisibility(0);
    }

    public final void a(AdvertSiteIdKey advertsiteidkey)
    {
        ay = advertsiteidkey;
        if (ap != null)
        {
            ap.h();
            FragmentAdBinderAspect.notifyFabOfAdVisibility(this, FragmentAdBinderAspect.isAdVisible(getView()));
        }
    }

    public final void a(BasicInfo basicinfo)
    {
        d.setText(basicinfo.title);
        if (com.shazam.b.e.a.a(basicinfo.artist))
        {
            e.setVisibility(8);
        } else
        {
            e.setText(com.shazam.b.e.a.d(basicinfo.artist));
        }
        i.setEnabled(true);
        h.setGradientEnabled(true);
        f.setVisibility(0);
        f.setImageResource(0x7f0201ac);
        basicinfo = f.a(basicinfo.coverArt);
        basicinfo.g = 0x7f0201ac;
        basicinfo.f = com.shazam.android.widget.image.d.b;
        basicinfo.e = 0x7f0200c3;
        basicinfo.c();
    }

    public final void a(Blurb blurb)
    {
        am.setText(blurb.text);
        am.setVisibility(0);
        ar.setVisibility(8);
    }

    public final void a(InteractiveInfo interactiveinfo)
    {
        boolean flag3;
        boolean flag4;
        flag3 = true;
        InteractiveInfoView interactiveinfoview = an;
        if (interactiveinfo == null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        flag4 = interactiveinfoview.a.a();
        if (interactiveinfo.previewViewData == null) goto _L2; else goto _L1
_L1:
        Object obj = interactiveinfo.previewViewData;
        if (((PreviewViewData) (obj)).playlistItem == null) goto _L4; else goto _L3
_L3:
        if (com.shazam.b.e.a.c(((PreviewViewData) (obj)).playlistItem.a().a(PlaybackProvider.PREVIEW))) goto _L6; else goto _L5
_L5:
        boolean flag;
        boolean flag1;
        if (flag4 && com.shazam.b.e.a.c(((PreviewViewData) (obj)).playlistItem.a().a(PlaybackProvider.RDIO)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L6
_L6:
        flag = true;
_L18:
        if (flag) goto _L8; else goto _L7
_L7:
        if (((PreviewViewData) (obj)).playDataInfo != null && !((PreviewViewData) (obj)).playDataInfo.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L9; else goto _L8
_L8:
        flag = true;
_L19:
        if (!flag) goto _L2; else goto _L10
_L10:
        flag = true;
_L20:
        if (interactiveinfo.stores == null) goto _L12; else goto _L11
_L11:
        obj = interactiveinfo.stores.stores.iterator();
_L16:
        if (!((Iterator) (obj)).hasNext()) goto _L14; else goto _L13
_L13:
        if ((Store)((Iterator) (obj)).next() == null) goto _L16; else goto _L15
_L15:
        flag1 = true;
_L21:
        if (!flag1) goto _L12; else goto _L17
_L17:
        flag1 = true;
_L22:
        boolean flag2;
        if (interactiveinfo.followData != null && com.shazam.b.e.a.c(interactiveinfo.followData.followKey))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag || flag1 || flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        flag = flag3;
_L23:
        if (flag)
        {
            an.a(interactiveinfo, null);
            an.setVisibility(0);
            return;
        } else
        {
            an.setVisibility(8);
            return;
        }
_L4:
        flag = false;
          goto _L18
_L9:
        flag = false;
          goto _L19
_L2:
        flag = false;
          goto _L20
_L14:
        flag1 = false;
          goto _L21
_L12:
        flag1 = false;
          goto _L22
        flag = false;
          goto _L23
    }

    public final void a(String s1)
    {
        getActivity().setTitle(s1);
    }

    public final void a(List list)
    {
        TrackContainerView trackcontainerview = ar;
        android.support.v4.app.o o1 = getLoaderManager();
        if (list != null && trackcontainerview.getChildCount() <= 0)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                Track track = (Track)list.next();
                com.shazam.android.widget.album.a a1 = new com.shazam.android.widget.album.a(trackcontainerview.getContext(), o1);
                a1.e.setText(track.title);
                a1.d = new c(a1.c.a(track), a1.a, a1.b, Integer.valueOf(track.id).intValue());
                a1.d.a(a1);
                a1.d.a();
                a1.setOnClickListener(new com.shazam.android.widget.album.TrackContainerView.a(trackcontainerview, track));
                trackcontainerview.addView(a1);
            }
        }
        ar.setVisibility(0);
        am.setVisibility(8);
    }

    public final void b(String s1)
    {
        ax = s1;
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        page.populateFromShazamUri(r.a((Uri)getArguments().getParcelable("shazamUri")));
        page.populateFromDataUri(g());
        if (ax != null)
        {
            page.setPageName(ax);
            return;
        } else
        {
            page.setPageName("detailspage");
            return;
        }
    }

    public final void d()
    {
        ao.setVisibility(8);
        f.setVisibility(0);
        i.setVisibility(0);
        g.setVisibility(0);
        as = true;
    }

    public final void e()
    {
        i j = getActivity();
        if (av != null)
        {
            s s1 = av;
            com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
            a1.a = 0x7f090077;
            a1.c = 1;
            s1.a(a1.a());
        }
        if (j != null)
        {
            j.finish();
        }
    }

    public final AdvertSiteIdKey f()
    {
        return ay;
    }

    public void onActivityCreated(Bundle bundle)
    {
        boolean flag1;
        flag1 = false;
        super.onActivityCreated(bundle);
        bundle = g();
        if (!bundle.getScheme().equals("details")) goto _L2; else goto _L1
_L1:
        bundle = at.a(bundle);
        c = new com.shazam.l.e.a(this, new com.shazam.android.k.b.d(getActivity().getSupportLoaderManager(), 3567, getActivity(), com.shazam.android.k.c.a(new com.shazam.android.k.e.h.b(com.shazam.i.c.b.a(), bundle), new com.shazam.c.d.d(new com.shazam.c.d.a(), new com.shazam.c.d.c(new com.shazam.android.l.e.a(com.shazam.i.d.d.u(), com.shazam.i.k.c.b.a(new com.shazam.c.o.d()), new PreviewViewDataUrlDecorator()), com.shazam.i.d.d.u(), com.shazam.i.k.c.b.a(new com.shazam.c.o.d())), new com.shazam.c.d.b()))), new com.shazam.g.a.b(this));
_L4:
        setHasOptionsMenu(true);
        bundle = getView();
        if (bundle != null)
        {
            ap = (ShazamAdView)bundle.findViewById(0x7f110004);
            if (ap != null && ay != null && com.shazam.b.e.a.c(ay.siteIdKey))
            {
                ap.h();
                FragmentAdBinderAspect.notifyFabOfAdVisibility(this, FragmentAdBinderAspect.isAdVisible(bundle));
            }
        }
        return;
_L2:
        if (!"product".equals(bundle.getScheme()))
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = bundle.getPath().replace("/", "");
_L5:
        bundle = au.a("product", bundle);
        c = new com.shazam.l.e.a(this, new com.shazam.android.k.b.d(getActivity().getSupportLoaderManager(), 3567, getActivity(), com.shazam.android.k.c.a(new p(com.shazam.i.c.b.a(), bundle), new com.shazam.c.e.c(com.shazam.i.d.d.m(), com.shazam.i.d.d.u(), com.shazam.i.k.c.b.a(new com.shazam.c.o.d()))), com.shazam.android.k.b.i.b), new com.shazam.g.a.a(this));
        getActivity().setTitle(0x7f0900ab);
        if (true) goto _L4; else goto _L3
_L3:
        List list;
        boolean flag;
        try
        {
            list = bundle.getPathSegments();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            getActivity().finish();
            return;
        }
        flag = flag1;
        if (list.size() <= 3)
        {
            break MISSING_BLOCK_LABEL_470;
        }
        flag = flag1;
        if (!o.b.contains(bundle.getScheme()))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        flag = flag1;
        if (!"discover".equals(list.get(0)))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        flag = flag1;
        if (!"artist".equals(list.get(1)))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        flag = flag1;
        if ("album".equals(list.get(3)))
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_491;
        }
        bundle = (String)bundle.getPathSegments().get(4);
          goto _L5
        throw new z((new StringBuilder("URI '")).append(bundle.toString()).append("' is not of a product. Cannot find product ID.").toString());
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof com.shazam.android.fragment.musicdetails.a)
        {
            al = (com.shazam.android.fragment.musicdetails.a)activity;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030057, viewgroup, false));
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        g.a = h.a;
        if (ap != null)
        {
            getActivity();
            ShazamAdView.e();
        }
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        aj = null;
        ak = null;
        al = null;
        am = null;
        an = null;
        ao = null;
        a = null;
        ap = null;
        aq = null;
        ar = null;
    }

    public void onPause()
    {
        super.onPause();
        c.b.b();
        an.a();
    }

    public void onResume()
    {
        super.onResume();
        if (!as)
        {
            com.shazam.l.e.a a1 = c;
            a1.a.a();
            a1.b.a(a1.c);
            a1.b.a();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        a = view.findViewById(0x7f110161);
        aq = (MusicDetailsContentAnchorView)view.findViewById(0x7f110168);
        d = (TextView)a.findViewById(0x7f1100e9);
        e = (TextView)a.findViewById(0x7f1100ea);
        am = (TextView)a.findViewById(0x7f110194);
        f = (MusicDetailsCoverArtView)a.findViewById(0x7f1100e8);
        i = (MusicDetailsCoverArtGradientView)a.findViewById(0x7f110162);
        h = (MusicDetailsCoverArtSnapshotView)a.findViewById(0x7f11016a);
        an = (InteractiveInfoView)a.findViewById(0x7f1100e6);
        aj = (MusicDetailsCoverArtSizeCapturingView)a.findViewById(0x7f110167);
        g = (EnhancedOverScrollView)a.findViewById(0x7f1100e3);
        ak = (SynchronizedRelativeLayout)a.findViewById(0x7f110164);
        ao = a.findViewById(0x7f110141);
        ar = (TrackContainerView)a.findViewById(0x7f110195);
        view = new com.shazam.android.fragment.musicdetails.b(al);
        bundle = new com.shazam.android.fragment.musicdetails.i(new View[] {
            f, i, aj
        });
        k k1 = k.a(new View[] {
            f, i
        });
        ak.setPositionFixedThreshold(com.shazam.android.util.o.a(getActivity()));
        ak.setViewPositionFixedListener(com.shazam.android.fragment.musicdetails.e.a(new com.xrigau.syncscrolling.view.SynchronizedRelativeLayout.a[] {
            view, f
        }));
        g.setOverScrollListener(com.shazam.android.fragment.musicdetails.d.a(new h[] {
            view, k1, f, i, com.shazam.android.widget.musicdetails.g.a(new View[] {
                i, d, e
            }), com.shazam.android.widget.musicdetails.a.a(a)
        }));
        f.setSnapshotView(h);
        f.setCoverArtSizeListener(com.shazam.android.widget.musicdetails.b.a(new com.shazam.android.widget.musicdetails.c[] {
            h, aj, i, aq, bundle, k1
        }));
        i.setEnabled(false);
        f.setImageDrawable(getResources().getDrawable(0x7f0201ac));
    }
}
