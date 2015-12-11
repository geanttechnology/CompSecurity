// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.cast;

import android.content.Intent;
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
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.d;
import com.shazam.android.k.f.r;
import com.shazam.android.util.s;
import com.shazam.android.widget.advert.BannerAdLayout;
import com.shazam.g.f;
import com.shazam.h.x;
import com.shazam.i.b.n.b;
import com.shazam.i.i.c;
import com.shazam.i.i.e;
import com.shazam.i.i.h;
import com.shazam.model.advert.AdvertSiteIdKey;
import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;
import com.shazam.model.cast.Cast;
import com.shazam.model.cast.CastMember;
import com.shazam.server.response.imdb.IMDBActorSearchResults;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.shazam.android.fragment.cast:
//            f, d, c

public class CastFragment extends BaseFragment
    implements a, SessionConfigurable, f, com.shazam.p.c.a
{

    private final ac a;
    private final com.shazam.android.j.m.a b;
    private final s c;
    private ListView d;
    private com.shazam.l.c.a e;

    public CastFragment()
    {
        this(((ac) (new d())), com.shazam.i.b.n.b.d(), com.shazam.i.b.au.d.a());
    }

    private CastFragment(ac ac1, com.shazam.android.j.m.a a1, s s1)
    {
        a = ac1;
        b = a1;
        c = s1;
    }

    public static CastFragment a(Bundle bundle, Uri uri)
    {
        CastFragment castfragment = new CastFragment();
        bundle.putParcelable("shazamUri", uri);
        castfragment.setArguments(bundle);
        return castfragment;
    }

    static void a(CastFragment castfragment)
    {
        castfragment.d();
    }

    static void a(CastFragment castfragment, CastMember castmember)
    {
        Object obj;
        castmember = castmember.actorName;
        obj = castfragment.b.a();
        String s1 = URLEncoder.encode(castmember, "UTF-8");
        castmember = s1;
_L2:
        if (obj != null && ((URL) (obj)).toString() != null && castmember != null)
        {
            String s2 = ((URL) (obj)).toString().replace("{actorname}", castmember);
            obj = castfragment.getLoaderManager();
            android.content.Context context = castfragment.getActivity().getBaseContext();
            x x1 = com.shazam.i.i.c.a(new x[] {
                h.a()
            });
            com.shazam.h.h.a a1 = com.shazam.i.i.c.c();
            a1.d = x1;
            a1.b = com.shazam.i.i.e.b();
            castmember = new com.shazam.android.k.b.d(((android.support.v4.app.o) (obj)), 2, context, new com.shazam.android.k.e.i.b(new com.shazam.a.e(a1.a(), new com.shazam.a.h(), com.shazam.i.j.a.b()), s2, castmember), com.shazam.android.k.b.i.b);
            castmember.a(castfragment);
            castmember.a();
        }
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(boolean flag)
    {
        d.setEnabled(flag);
    }

    static void b(CastFragment castfragment)
    {
        castfragment.a(false);
    }

    private void d()
    {
        if (d != null)
        {
            int k = d.getChildCount();
            for (int j = 0; j < k; j++)
            {
                View view = d.getChildAt(j).findViewById(0x7f1100d9);
                if (view != null && view.getVisibility() == 0)
                {
                    view.setVisibility(8);
                }
            }

        }
    }

    public final void a()
    {
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090077;
        a1.c = 1;
        s1.a(a1.a());
        getActivity().finish();
    }

    public final void a(Cast cast)
    {
        d.setAdapter(new com.shazam.android.a.a.a(getActivity().getBaseContext(), cast.castMemberList));
    }

    public void configureWith(Page page)
    {
        page = (DetailsPage)page;
        page.populateFromShazamUri(r.a((Uri)getArguments().getParcelable("shazamUri")));
        page.setPageName("Cast");
    }

    public final AdvertSiteIdKey f()
    {
        return AdvertSiteIdKey.a(HardCodedAdvertSiteIdKeys.TV_CAST);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getActivity().getIntent();
        bundle = a.a(bundle.getData());
        e = new com.shazam.l.c.a(this, new com.shazam.android.k.b.d(getLoaderManager(), 1, getActivity().getBaseContext(), com.shazam.android.k.c.a(new com.shazam.android.k.e.i.a(com.shazam.i.c.b.a(), bundle), new com.shazam.c.s.a(new com.shazam.c.s.b()))));
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return BannerAdLayout.a(layoutinflater.inflate(0x7f030041, viewgroup, false));
    }

    public void onDataFailedToLoad()
    {
        s s1 = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f090077;
        a1.c = 1;
        s1.a(a1.a());
        a(true);
        d();
    }

    public void onDataFetched(Object obj)
    {
        Object obj1;
        obj = (IMDBActorSearchResults)obj;
        obj1 = new com.shazam.android.fragment.cast.d(getActivity().getBaseContext(), b);
        for (obj1 = ((com.shazam.android.fragment.cast.d) (obj1)).a.entrySet().iterator(); ((Iterator) (obj1)).hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            if (((com.shazam.b.a.e)entry.getKey()).apply(obj))
            {
                ((com.shazam.android.fragment.cast.c)entry.getValue()).a(((IMDBActorSearchResults) (obj)));
                return;
            }
        }

        try
        {
            throw new com.shazam.android.fragment.cast.f("Could not find IMDB search strategy for these search results.");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        com.shazam.l.c.a a1 = e;
        a1.b.a(new com.shazam.l.c.a.a(a1, (byte)0));
        a1.b.a();
        a(true);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        d = (ListView)view.findViewById(0x7f110145);
        d.setOnItemClickListener(new _cls1());
    }

    /* member class not found */
    class _cls1 {}

}
