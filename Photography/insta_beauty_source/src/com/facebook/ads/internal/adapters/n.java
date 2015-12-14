// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

// Referenced classes of package com.facebook.ads.internal.adapters:
//            AdAdapter, o

public abstract class n
    implements AdAdapter
{

    public n()
    {
    }

    public abstract void a(int i1);

    public abstract void a(Context context, o o1, Map map);

    public abstract void a(Map map);

    public abstract void b(Map map);

    public abstract boolean d();

    public abstract boolean e();

    public abstract boolean f();

    public abstract boolean g();

    public final AdPlacementType getPlacementType()
    {
        return AdPlacementType.NATIVE;
    }

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract com.facebook.ads.NativeAd.Image k();

    public abstract com.facebook.ads.NativeAd.Image l();

    public abstract NativeAdViewAttributes m();

    public abstract String n();

    public abstract String o();

    public abstract String p();

    public abstract String q();

    public abstract String r();

    public abstract com.facebook.ads.NativeAd.Rating s();

    public abstract com.facebook.ads.NativeAd.Image t();

    public abstract String u();

    public abstract String v();

    public abstract String w();

    public abstract String x();

    public abstract AdExtras y();

    public abstract boolean z();
}
