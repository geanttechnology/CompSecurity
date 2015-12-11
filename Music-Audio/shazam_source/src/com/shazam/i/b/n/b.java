// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.n;

import android.content.Context;
import android.content.res.Resources;
import com.shazam.android.ShazamApplication;
import com.shazam.android.j.af.e;
import com.shazam.android.j.g.h;
import com.shazam.android.j.g.i;
import com.shazam.android.j.g.j;
import com.shazam.android.j.g.k;
import com.shazam.android.j.l;
import com.shazam.android.j.n;
import com.shazam.android.j.o.d;
import com.shazam.android.j.p;
import com.shazam.android.j.v.a;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.c;
import com.shazam.model.configuration.AuthConfiguration;
import com.shazam.model.configuration.ChartsConfiguration;
import com.shazam.model.configuration.EmailRegistrationConfiguration;
import com.shazam.model.configuration.EmailRegistrationStyleConfiguration;
import com.shazam.model.configuration.ExploreConfiguration;
import com.shazam.model.configuration.FacebookConfiguration;
import com.shazam.model.configuration.GimbalConfiguration;
import com.shazam.model.configuration.MoodstocksConfiguration;
import com.shazam.model.configuration.NcmConfiguration;
import com.shazam.model.configuration.PlayWithConfiguration;
import com.shazam.model.configuration.ProModeConfiguration;
import com.shazam.model.configuration.RdioConfiguration;
import com.shazam.model.configuration.SearchConfiguration;
import com.shazam.model.configuration.ShareConfiguration;
import com.shazam.model.configuration.ShareTagConfiguration;
import com.shazam.model.configuration.SignUpConfiguration;
import com.shazam.model.configuration.SpotifyConfiguration;
import com.shazam.model.configuration.StoresConfiguration;
import com.shazam.model.configuration.TagCountConfiguration;
import com.shazam.model.configuration.WearConfiguration;
import com.shazam.model.configuration.location.LocationConfiguration;
import com.shazam.model.configuration.visual.VisualShazamConfiguration;
import com.shazam.model.store.AvailableProviders;
import java.util.Arrays;

// Referenced classes of package com.shazam.i.b.n:
//            c

public final class b
{

    private static final d a = new d(com.shazam.i.b.al.b.a(), com.shazam.i.b.ah.f.a());
    private static com.shazam.android.j.ad.a b;
    private static final a c = new a(com.shazam.i.b.m.a.a());

    public static com.shazam.android.j.a.a A()
    {
        return new com.shazam.android.j.a.b(com.shazam.i.d.d.i(), com.shazam.i.b.al.d.a().facebook);
    }

    public static com.shazam.android.j.a.a B()
    {
        return new com.shazam.android.j.a.b(com.shazam.i.d.d.j(), com.shazam.i.b.al.d.a().adColony);
    }

    public static com.shazam.android.j.u.b C()
    {
        return new com.shazam.android.j.u.a(com.shazam.i.b.m.a.a());
    }

    public static ProModeConfiguration D()
    {
        return new com.shazam.android.j.w.a(com.shazam.i.b.m.a.a());
    }

    public static com.shazam.android.j.w.c E()
    {
        return new com.shazam.android.j.w.b(com.shazam.i.b.m.a.a(), com.shazam.i.b.n.c.a());
    }

    public static ChartsConfiguration F()
    {
        return new com.shazam.android.j.f.a(com.shazam.i.b.m.a.a());
    }

    public static SpotifyConfiguration G()
    {
        return new com.shazam.android.j.ac.a(c);
    }

    public static n H()
    {
        return new n(G(), h(), x());
    }

    public static WearConfiguration I()
    {
        return new com.shazam.android.j.aj.a(com.shazam.i.b.m.a.a());
    }

    public static com.shazam.android.j.s.a J()
    {
        return new com.shazam.android.j.s.a(com.shazam.i.b.m.a.a());
    }

    public static EmailRegistrationConfiguration K()
    {
        return new com.shazam.android.j.y.a(com.shazam.i.b.al.b.a());
    }

    public static EmailRegistrationStyleConfiguration L()
    {
        return new com.shazam.android.j.ab.b(com.shazam.i.b.al.b.a());
    }

    public static GimbalConfiguration M()
    {
        return new com.shazam.android.j.k.a(com.shazam.i.b.m.a.a());
    }

    public static VisualShazamConfiguration N()
    {
        java.util.List list = Arrays.asList(new String[] {
            com.shazam.i.b.c.a().getResources().getString(0x7f090162), com.shazam.i.b.c.a().getResources().getString(0x7f090163), com.shazam.i.b.c.a().getResources().getString(0x7f090164)
        });
        return new com.shazam.android.j.ai.b(com.shazam.i.b.m.a.a(), list);
    }

    public static MoodstocksConfiguration O()
    {
        return new com.shazam.android.j.ai.a(com.shazam.i.b.m.a.a());
    }

    public static SignUpConfiguration P()
    {
        return new com.shazam.android.j.ab.a(com.shazam.i.b.m.a.a());
    }

    public static LocationConfiguration Q()
    {
        return new com.shazam.android.j.p.a(com.shazam.i.b.ah.f.a(), D());
    }

    public static TagCountConfiguration R()
    {
        return new com.shazam.android.j.ah.a(com.shazam.i.b.m.a.a());
    }

    public static ShareTagConfiguration S()
    {
        return new com.shazam.android.j.aa.b(com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.g.l T()
    {
        return new i(com.shazam.i.b.c.a(), com.shazam.i.b.ah.f.a());
    }

    public static SearchConfiguration U()
    {
        return new com.shazam.android.j.z.a(com.shazam.i.b.m.a.a());
    }

    public static ShareConfiguration V()
    {
        return new com.shazam.android.j.aa.a(com.shazam.i.b.m.a.a());
    }

    public static com.shazam.android.j.g.f a(com.shazam.android.j.g.d d1)
    {
        return new com.shazam.android.j.g.f(d1);
    }

    public static AuthConfiguration a()
    {
        return new com.shazam.android.j.c.a(com.shazam.i.b.m.a.a(), com.shazam.i.b.ah.f.a(), com.shazam.i.b.n.c.a());
    }

    public static ExploreConfiguration b()
    {
        return new com.shazam.android.j.h.a(com.shazam.i.b.al.b.a());
    }

    public static FacebookConfiguration c()
    {
        return new com.shazam.android.j.i.a(com.shazam.i.b.al.b.a(), new com.shazam.android.ax.a(com.shazam.i.b.aq.a.a()), com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.m.a d()
    {
        return new com.shazam.android.j.m.b(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.l.a e()
    {
        return new com.shazam.android.j.l.b(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.e.b f()
    {
        return new com.shazam.android.j.e.a(com.shazam.i.b.m.a.a(), com.shazam.i.b.n.c.b());
    }

    public static com.shazam.android.j.s.b g()
    {
        return new com.shazam.android.j.s.c(com.shazam.i.b.al.b.a());
    }

    public static RdioConfiguration h()
    {
        return new com.shazam.android.j.x.a(c, com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.af.f i()
    {
        return new e(com.shazam.i.b.al.b.a(), com.shazam.i.b.d.a());
    }

    public static com.shazam.android.j.ak.b j()
    {
        return new com.shazam.android.j.ak.a(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.ag.b k()
    {
        return new com.shazam.android.j.ag.a(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.g.e l()
    {
        return new com.shazam.android.j.g.e(com.shazam.i.b.c.a().getResources());
    }

    public static com.shazam.android.j.g.d m()
    {
        h h1 = new h((new com.shazam.android.e()).a());
        String s1 = com.shazam.i.b.c.a().getResources().getString(0x7f090266);
        return new k(h1, (new com.shazam.android.e()).a().getSharedPreferences("testmode", 0), s1);
    }

    public static j n()
    {
        return new j(com.shazam.i.b.ah.f.a(), com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.r.a o()
    {
        return new com.shazam.android.j.r.b(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.n.a p()
    {
        return new com.shazam.android.j.n.b(com.shazam.i.b.al.b.a());
    }

    public static com.shazam.android.j.d.a q()
    {
        return new com.shazam.android.j.d.b(com.shazam.i.b.al.b.a(), new com.shazam.a.a.e(), com.shazam.i.b.ah.c.d.a(), com.shazam.i.b.d.a(), com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.o.a r()
    {
        return new com.shazam.android.j.o.c(com.shazam.i.b.al.b.a(), com.shazam.i.b.ah.c.d.a(), com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.o.b s()
    {
        return a;
    }

    public static com.shazam.android.j.j.a t()
    {
        return new com.shazam.android.j.j.b(com.shazam.i.b.al.b.a());
    }

    public static p u()
    {
        return new l(com.shazam.i.b.al.b.a(), com.shazam.i.b.ah.f.a());
    }

    public static com.shazam.android.j.t.a v()
    {
        return new com.shazam.android.j.t.b(com.shazam.i.b.al.b.a());
    }

    public static NcmConfiguration w()
    {
        return new com.shazam.android.j.af.a(com.shazam.i.b.m.a.a(), com.shazam.c.j.a(com.shazam.i.d.d.r()));
    }

    public static StoresConfiguration x()
    {
        if (b == null)
        {
            b = new com.shazam.android.j.ad.a(com.shazam.i.b.m.a.a(), com.shazam.c.j.a(com.shazam.i.d.d.s()));
        }
        return b;
    }

    public static PlayWithConfiguration y()
    {
        return c;
    }

    public static com.shazam.android.j.a.a z()
    {
        return new com.shazam.android.j.a.b(com.shazam.i.d.d.h(), com.shazam.i.b.al.d.a().primary);
    }

}
