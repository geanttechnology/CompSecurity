// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library;

import com.liverail.library.a.b;
import com.liverail.library.b.a;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.f.i;
import java.util.HashMap;

// Referenced classes of package com.liverail.library:
//            AdView

class c
    implements i
{

    final AdView a;

    c(AdView adview)
    {
        a = adview;
        super();
    }

    public void a()
    {
        com.liverail.library.b.a.b("linearAdListener.onStart()");
        a.dispatchEvent(new VPAIDEvent("AdVideoStart"));
    }

    public void a(b b1)
    {
        com.liverail.library.b.a.b("linearAdListener.onError()");
        AdView.d(a).a(b1);
        AdView.d(a).b(AdView.e(a), b1.a());
        AdView.f(a);
    }

    public void a(boolean flag, String s)
    {
        com.liverail.library.b.a.b("linearAdListener.onClickThrough()");
        AdView.d(a).a(AdView.e(a), "clickthru");
        HashMap hashmap = new HashMap(2);
        hashmap.put("playerHandles", Boolean.valueOf(flag));
        hashmap.put("url", s);
        a.dispatchEvent(new VPAIDEvent("AdClickThru", hashmap));
    }

    public void b()
    {
        com.liverail.library.b.a.c("linearAdListener.onImpression() / current inventory slot filled!");
        com.liverail.library.AdView.a(a, true);
        com.liverail.library.AdView.b(a, true);
        AdView adview = a;
        com.liverail.library.AdView.a(adview, AdView.c(adview) + 1);
        AdView.d(a).a(AdView.e(a), "impression");
        a.dispatchEvent(new VPAIDEvent("AdImpression"));
    }

    public void c()
    {
        com.liverail.library.b.a.b("linearAdListener.onPause()");
        AdView.d(a).a(AdView.e(a), "pause");
        a.dispatchEvent(new VPAIDEvent("AdPaused"));
    }

    public void d()
    {
        com.liverail.library.b.a.b("linearAdListener.onResume()");
        AdView.d(a).a(AdView.e(a), "resume");
        a.dispatchEvent(new VPAIDEvent("AdPlaying"));
    }

    public void e()
    {
        com.liverail.library.b.a.b("linearAdListener.onProgressFirstQuartile()");
        AdView.d(a).a(AdView.e(a), 25);
        a.dispatchEvent(new VPAIDEvent("AdVideoFirstQuartile"));
    }

    public void f()
    {
        com.liverail.library.b.a.b("linearAdListener.onProgressMidPoint()");
        AdView.d(a).a(AdView.e(a), 50);
        a.dispatchEvent(new VPAIDEvent("AdVideoMidpoint"));
    }

    public void g()
    {
        com.liverail.library.b.a.b("linearAdListener.onProgressThirdQuartile()");
        AdView.d(a).a(AdView.e(a), 75);
        a.dispatchEvent(new VPAIDEvent("AdVideoThirdQuartile"));
    }

    public void h()
    {
        com.liverail.library.b.a.b("linearAdListener.onProgressComplete()");
        AdView.d(a).a(AdView.e(a), 100);
        a.dispatchEvent(new VPAIDEvent("AdVideoComplete"));
    }

    public void i()
    {
        com.liverail.library.b.a.b("linearAdListener.onSkipped()");
        AdView.d(a).a(AdView.e(a), "skip");
        a.dispatchEvent(new VPAIDEvent("AdSkipped"));
    }

    public void j()
    {
        com.liverail.library.b.a.b("linearAdListener.onStopped()");
        AdView.f(a);
    }
}
