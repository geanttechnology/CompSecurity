// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ajl
{

    public rx a;
    private final bje b;
    private final amd c;
    private final chq d;

    public ajl(bje bje1, amd amd1, chq chq1)
    {
        b = (bje)b.a(bje1);
        c = (amd)b.a(amd1);
        d = (chq)b.a(chq1);
    }

    private void a(ajr ajr1)
    {
        Object obj = d;
        obj = String.valueOf(ajr1);
        (new StringBuilder(String.valueOf(obj).length() + 52)).append("LocalPlaybackControl: broadcast second screen mode: ").append(((String) (obj)));
        b.d(ajr1);
    }

    public final void handleMdxPlaybackChangedEvent(alv alv1)
    {
        b.a(a);
        if (c.i().a())
        {
            if ((alv1 = alv1.a).a())
            {
                alv1 = new cto(((alw) (alv1)).a, ((alw) (alv1)).d, ((alw) (alv1)).e, ((alw) (alv1)).b);
                d.a("LocalControl on playback changed videoId: %s, playlistId: %s", new Object[] {
                    ((cto) (alv1)).a.a, ((cto) (alv1)).a.c
                });
                a.a(alv1);
                a(ajr.a);
                return;
            }
        }
    }

    public final void handleMdxPlaylistChangedEvent(amc amc1)
    {
        b.a(a);
        if (!c.i().a())
        {
            return;
        }
        amc1 = amc1.a;
        if (amc1.a())
        {
            if (((alw) (amc1)).a.equals(a.d()))
            {
                amc1 = d;
                a.k();
                return;
            } else
            {
                amc1 = new cto(((alw) (amc1)).a, ((alw) (amc1)).d, ((alw) (amc1)).e, 0);
                d.a("LocalControl on TV queue changed videoId: %s, playlistId: %s", new Object[] {
                    ((cto) (amc1)).a.a, ((cto) (amc1)).a.c
                });
                a.a(amc1);
                a(ajr.b);
                return;
            }
        } else
        {
            amc1 = d;
            a.b();
            a(ajr.c);
            return;
        }
    }

    public final void handleMdxStateChangedEvent(amk amk1)
    {
        cxu cxu;
        cxu = null;
        b.a(a);
        amk1 = amk1.a;
        ajn.a[amk1.ordinal()];
        JVM INSTR tableswitch 1 2: default 44
    //                   1 45
    //                   2 53;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        a.a();
        return;
_L3:
        if (a.f.f() || a.f.e())
        {
            if (chv.a(a.c()))
            {
                amk1 = new cto(a.d(), "", -1, a.f());
            } else
            {
                amk1 = new cto(a.d(), a.c(), a.e(), a.f());
            }
            cxu = a.r();
        } else
        {
            amk1 = null;
        }
        a.a();
        if (amk1 != null)
        {
            d.a("LocalPlaybackControl, reload video %s: ", new Object[] {
                ((cto) (amk1)).a.a
            });
            ((cto) (amk1)).a.d(true);
            a.a(amk1);
            if (cxu != null)
            {
                a.a(cxu);
                return;
            }
        } else
        {
            amk1 = d;
            a(ajr.c);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }
}
