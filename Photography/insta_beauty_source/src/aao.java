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

public class aao
    implements anp
{

    public aao()
    {
    }

    public ant a(anu anu)
    {
        return null;
    }

    public aoa a(anz anz)
    {
        return new aqq(anz);
    }

    public FotoAdBanner a(Context context)
    {
        context = new GADFotoAdBanner(context);
        context.refreshBanner();
        return context;
    }

    public FotoNativeBaseWall a(Context context, anv anv)
    {
        FotoNativeAbroadWall fotonativeabroadwall = new FotoNativeAbroadWall(context);
        fotonativeabroadwall.loadAd(context, anv, null);
        return fotonativeabroadwall;
    }

    public FotoNativeIcon b(Context context)
    {
        return new FotoNativeAbroadIcon(context);
    }

    public anx c(Context context)
    {
        return null;
    }

    public ans d(Context context)
    {
        return new gt();
    }
}
