// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            oi, oh

public class os extends om.a
{

    private final com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener a;

    public os(com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener oncustomtemplateadloadedlistener)
    {
        a = oncustomtemplateadloadedlistener;
    }

    public void a(oh oh)
    {
        a.onCustomTemplateAdLoaded(new oi(oh));
    }
}
