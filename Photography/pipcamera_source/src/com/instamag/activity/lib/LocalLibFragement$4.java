// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.util.Log;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;
import ja;

// Referenced classes of package com.instamag.activity.lib:
//            LocalLibFragement

class a
    implements ja
{

    final LocalLibFragement a;

    public void adIconFailed()
    {
        FlurryAgent.logEvent("FBNatice_PIPMagResIcon_Failed");
    }

    public void adIconLoaded(FotoNativeIcon fotonativeicon)
    {
        Log.e(LocalLibFragement.a(a), (new StringBuilder()).append(LocalLibFragement.a(a)).append(" fbnative ad loaded").toString());
        LocalLibFragement.a(a, fotonativeicon);
        FlurryAgent.logEvent("FBNatice_PIPMagResIcon_Loaded");
    }

    con(LocalLibFragement locallibfragement)
    {
        a = locallibfragement;
        super();
    }
}
