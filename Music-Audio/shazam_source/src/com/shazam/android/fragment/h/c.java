// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.h;

import android.os.Bundle;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shazam.android.ag.g.d;
import com.shazam.android.ap.a;
import com.shazam.android.ay.a.q;
import com.shazam.android.ay.c.j;
import com.shazam.android.base.fragments.BaseFragment;
import com.shazam.android.view.tagging.TaggingButtonView;
import com.shazam.android.view.tagging.TaggingShardsView;
import com.shazam.android.view.tagging.f;
import com.shazam.android.widget.AnimatorViewFlipper;
import com.shazam.android.widget.image.UrlCachingImageView;
import com.shazam.android.widget.tagging.MiniTagResultView;
import com.shazam.i.b.am.b;
import com.shazam.i.b.ar.a.e;
import com.shazam.model.tag.MiniTagResultItem;

// Referenced classes of package com.shazam.android.fragment.h:
//            a, b

public final class c extends BaseFragment
    implements f
{

    public boolean a;
    private final com.shazam.android.receiver.d aj = com.shazam.i.b.am.b.a();
    private TaggingShardsView b;
    private AnimatorViewFlipper c;
    private AnimatorViewFlipper d;
    private MiniTagResultView e;
    private a f;
    private TaggingButtonView g;
    private com.shazam.android.fragment.h.a h;
    private final q i = com.shazam.i.b.ar.a.e.a();

    public c()
    {
        a = true;
    }

    public static c a(Bundle bundle, boolean flag)
    {
        c c1 = new c();
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        c1.setArguments(bundle);
        c1.getArguments().putBoolean("PARAM_SHOULD_ANIMATE_OUT", flag);
        return c1;
    }

    static void a(c c1)
    {
        c1.d();
    }

    static void a(c c1, boolean flag)
    {
        c1.a(flag);
    }

    private void a(boolean flag)
    {
        Object obj = f;
        ((a) (obj)).a(com.shazam.android.ag.h.b.g);
        ((a) (obj)).b.b();
        obj = (com.shazam.android.widget.b)getActivity().findViewById(0x7f110014);
        if (flag)
        {
            ((com.shazam.android.widget.b) (obj)).hideBottomBar(new _cls1());
            return;
        } else
        {
            d();
            ((com.shazam.android.widget.b) (obj)).hideBottomBarNoAnimation();
            return;
        }
    }

    static boolean b(c c1)
    {
        return c1.getArguments().getBoolean("PARAM_SHOULD_ANIMATE_OUT");
    }

    static com.shazam.android.receiver.d c(c c1)
    {
        return c1.aj;
    }

    static q d(c c1)
    {
        return c1.i;
    }

    private void d()
    {
        getFragmentManager().a().a(this).b();
    }

    static android.support.v7.a.a e(c c1)
    {
        return c1.getSupportActionBar();
    }

    static TaggingButtonView f(c c1)
    {
        return c1.g;
    }

    public final void a()
    {
        a(false);
    }

    public final void a(com.shazam.android.ag.h.b b1)
    {
        d.setDisplayedChildById(b1.i);
    /* block-local class not found */
    class c {}

        if (b1.j)
        {
            g.setOnClickListener(new c((byte)0));
        }
    }

    public final void a(MiniTagResultItem minitagresultitem)
    {
        MiniTagResultView minitagresultview = e;
        com.shazam.android.widget.image.UrlCachingImageView.a a1 = minitagresultview.b.a(minitagresultitem.coverArtUrl);
        a1.g = 0x7f0201ac;
        a1.i = true;
        a1.j = true;
        a1.c();
        minitagresultview.c.setText(minitagresultitem.title);
        minitagresultview.d.setText(minitagresultitem.artist);
        minitagresultview.a.a(minitagresultitem.store, minitagresultview.e, com.shazam.android.widget.image.c.c.a);
        minitagresultview.f = minitagresultitem.tagId;
    /* block-local class not found */
    class b {}

        e.setOnClickListener(new b((byte)0));
        c.setDisplayedChild(1);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        h = new com.shazam.android.fragment.h.a(android.support.v4.a.e.a(com.shazam.i.b.c.a()), i);
        f = new a(this, com.shazam.i.b.d.a.a(com.shazam.server.request.tag.RequestTag.Type.CONTEXT), com.shazam.i.r.a.a(), com.shazam.i.d.d.M(), com.shazam.i.d.d.N(), new com.shazam.android.fragment.h.b(getArguments()), h, com.shazam.i.a.a.a());
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03004b, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        b.c.a();
        if (a)
        {
            h.b();
        }
    }

    public final void onResume()
    {
        super.onResume();
        b.c.b();
    }

    public final void onStart()
    {
        a a1;
        com.shazam.android.ag.h.b b1;
        super.onStart();
        a1 = f;
        a1.b.a(new com.shazam.android.ap.a.d(a1, (byte)0), new com.shazam.android.ap.a.b(a1, (byte)0), new com.shazam.android.ap.a.c(a1, (byte)0), new com.shazam.android.ap.a.a(a1, (byte)0));
        b1 = a1.a.b();
        com.shazam.android.ap.a._cls1.a[b1.ordinal()];
        JVM INSTR tableswitch 1 2: default 96
    //                   1 102
    //                   2 116;
           goto _L1 _L2 _L3
_L1:
        a1.b(b1);
        return;
_L2:
        a1.a(a1.a.a());
        return;
_L3:
        a1.a(com.shazam.android.ag.h.b.b);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void onStop()
    {
        super.onStop();
        f.b.a();
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        b = (TaggingShardsView)view.findViewById(0x7f110159);
        c = (AnimatorViewFlipper)view.findViewById(0x7f110158);
        d = (AnimatorViewFlipper)view.findViewById(0x7f11015b);
        e = (MiniTagResultView)view.findViewById(0x7f110160);
        g = (TaggingButtonView)view.findViewById(0x7f11015a);
    /* block-local class not found */
    class a {}

        view.findViewById(0x7f110045).setOnClickListener(new a((byte)0));
        view = (com.shazam.android.view.tagging.c)view.findViewById(0x7f110035);
        view.i = true;
        view.setTaggingButtonView(g);
        view.a(com.shazam.android.view.tagging.k.b);
    }

    /* member class not found */
    class _cls1 {}

}
