// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.fotoable.ads.FotoNativeAbroadIcon;
import com.fotoable.ads.FotoNativeAbroadWall;
import com.fotoable.ads.GADFotoAdBanner;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;
import com.fotoable.fotovariant.nativeAds.FotoNativeBaseWall;
import com.fotoable.fotovariant.nativeAds.FotoNativeIcon;

public class gf
    implements iw
{

    public gf()
    {
    }

    public FotoAdBanner a(Context context)
    {
        context = new GADFotoAdBanner(context);
        context.refreshBanner();
        return context;
    }

    public FotoNativeBaseWall a(Context context, iz iz)
    {
        FotoNativeAbroadWall fotonativeabroadwall = new FotoNativeAbroadWall(context);
        fotonativeabroadwall.loadAd(context, iz, null);
        return fotonativeabroadwall;
    }

    public je a(jd jd)
    {
        return new kx(jd);
    }

    public FotoNativeIcon b(Context context)
    {
        return new FotoNativeAbroadIcon(context);
    }

    public jb c(Context context)
    {
        return null;
    }

    public iy d(Context context)
    {
        return new ef();
    }
}
