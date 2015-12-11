// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.widget.VideoView;

// Referenced classes of package com.flurry.android:
//            FlurryFullscreenTakeoverActivity, cf, FlurryAds, j

final class h
{

    final FlurryFullscreenTakeoverActivity u;

    h(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity)
    {
        this(flurryfullscreentakeoveractivity, (byte)0);
    }

    private h(FlurryFullscreenTakeoverActivity flurryfullscreentakeoveractivity, byte byte0)
    {
        u = flurryfullscreentakeoveractivity;
        super();
    }

    public final boolean a(cf cf1, String s, boolean flag)
    {
        boolean flag1 = false;
        if (!FlurryFullscreenTakeoverActivity.v(s)) goto _L2; else goto _L1
_L1:
        FlurryFullscreenTakeoverActivity.a(u, new VideoView(u));
        FlurryFullscreenTakeoverActivity.a(u).setFocusable(true);
        FlurryFullscreenTakeoverActivity.a(u).setFocusableInTouchMode(true);
        FlurryFullscreenTakeoverActivity.a(u, flag);
        FlurryFullscreenTakeoverActivity.a(u, s);
_L6:
        flag1 = true;
_L4:
        return flag1;
_L2:
        if (!FlurryFullscreenTakeoverActivity.b(u, s)) goto _L4; else goto _L3
_L3:
        boolean flag2 = flag;
        if (!flag)
        {
            flag2 = FlurryFullscreenTakeoverActivity.a(u, s, cf1.getUrl());
        }
        FlurryAds.getInstance().d(u, s, FlurryFullscreenTakeoverActivity.b(u));
        if (flag2)
        {
            cf1.post(new j(this, cf1));
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
