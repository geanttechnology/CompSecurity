// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

// Referenced classes of package android.support.v7:
//            nv, nw

public final class ny extends nx.a
{

    private final OnCustomRenderedAdLoadedListener a;

    public ny(OnCustomRenderedAdLoadedListener oncustomrenderedadloadedlistener)
    {
        a = oncustomrenderedadloadedlistener;
    }

    public void a(nw nw)
    {
        a.onCustomRenderedAdLoaded(new nv(nw));
    }
}
