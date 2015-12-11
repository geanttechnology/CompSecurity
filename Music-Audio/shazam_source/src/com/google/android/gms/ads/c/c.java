// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.d;

// Referenced classes of package com.google.android.gms.ads.c:
//            b, d, a

public interface c
    extends b
{

    public abstract View getBannerView();

    public abstract void requestBannerAd(Context context, com.google.android.gms.ads.c.d d, Bundle bundle, d d1, a a, Bundle bundle1);
}
