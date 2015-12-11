// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.f;

import android.support.v4.app.Fragment;
import com.shazam.android.advert.ShazamAdView;
import com.shazam.android.aspects.fragments.advert.FragmentAdBinderAspect;

// Referenced classes of package com.shazam.android.advert.f:
//            b

public final class c extends b
{

    private final ShazamAdView a;

    public c(ShazamAdView shazamadview)
    {
        a = shazamadview;
    }

    public final void a(Fragment fragment)
    {
        ShazamAdView shazamadview = a;
        fragment.getActivity();
        shazamadview.b();
        FragmentAdBinderAspect.notifyFabOfAdVisibility(fragment, FragmentAdBinderAspect.isAdVisible(fragment.getView()));
    }

    public final void b(Fragment fragment)
    {
        ShazamAdView shazamadview = a;
        fragment.getActivity();
        shazamadview.d();
    }
}
