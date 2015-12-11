// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            oi, oh

public class or extends ol.a
{

    private final com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener a;

    public or(com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener oncustomclicklistener)
    {
        a = oncustomclicklistener;
    }

    public void a(oh oh, String s)
    {
        a.onCustomClick(new oi(oh), s);
    }
}
