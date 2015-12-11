// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            oe, od

public class oo extends oj.a
{

    private final com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener a;

    public oo(com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener onappinstalladloadedlistener)
    {
        a = onappinstalladloadedlistener;
    }

    public void a(od od)
    {
        a.onAppInstallAdLoaded(b(od));
    }

    oe b(od od)
    {
        return new oe(od);
    }
}
