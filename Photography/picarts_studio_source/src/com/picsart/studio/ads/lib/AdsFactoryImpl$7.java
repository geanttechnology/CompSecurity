// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.view.View;
import com.mopub.mobileads.MoPubView;
import com.picsart.studio.ads.i;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class a
    implements i
{

    private MoPubView a;

    public final View a()
    {
        return a;
    }

    public final void b()
    {
        a.destroy();
    }

    (MoPubView mopubview)
    {
        a = mopubview;
        super();
    }
}
