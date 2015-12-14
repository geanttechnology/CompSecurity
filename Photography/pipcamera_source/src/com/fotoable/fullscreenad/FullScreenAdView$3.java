// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fullscreenad;

import android.view.View;
import com.flurry.android.FlurryAgent;

// Referenced classes of package com.fotoable.fullscreenad:
//            FullScreenAdView

class a
    implements android.view.r
{

    final FullScreenAdView a;

    public void onClick(View view)
    {
        FlurryAgent.logEvent(FullScreenAdView.access$700(a));
        FullScreenAdView.access$500(a);
    }

    (FullScreenAdView fullscreenadview)
    {
        a = fullscreenadview;
        super();
    }
}
