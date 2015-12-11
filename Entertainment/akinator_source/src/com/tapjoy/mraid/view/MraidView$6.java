// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tapjoy.mraid.listener.Player;

// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

final class a
    implements Player
{

    final MraidView a;

    public final void onComplete()
    {
        FrameLayout framelayout = (FrameLayout)a.getRootView().findViewById(101);
        ((ViewGroup)framelayout.getParent()).removeView(framelayout);
        a.setVisibility(0);
    }

    public final void onError()
    {
        onComplete();
    }

    public final void onPrepared()
    {
    }

    (MraidView mraidview)
    {
        a = mraidview;
        super();
    }
}
