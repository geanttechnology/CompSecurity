// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdType;
import com.flurry.android.FlurryAds;
import com.smule.android.network.managers.d;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

final class b
    implements FlurryAdListener
{

    final Context a;
    final ViewGroup b;

    public void onAdClicked(String s)
    {
        d.a().a(4);
    }

    public void onAdClosed(String s)
    {
        d.a().a(2);
    }

    public void onAdOpened(String s)
    {
        d.a().a(5);
    }

    public void onApplicationExit(String s)
    {
    }

    public void onRenderFailed(String s)
    {
        ap.e();
    }

    public void onRendered(String s)
    {
        d.a().a(3);
    }

    public void onVideoCompleted(String s)
    {
        d.a().a(6);
    }

    public boolean shouldDisplayAd(String s, FlurryAdType flurryadtype)
    {
        return true;
    }

    public void spaceDidFailToReceiveAd(String s)
    {
        ap.e();
    }

    public void spaceDidReceiveAd(String s)
    {
        FlurryAds.displayAd(a, "PIANDROID_BUYSMOOLA_RWD", b);
    }

    (Context context, ViewGroup viewgroup)
    {
        a = context;
        b = viewgroup;
        super();
    }
}
