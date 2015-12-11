// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            og, of

public class op extends ok.a
{

    private final com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener a;

    public op(com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener oncontentadloadedlistener)
    {
        a = oncontentadloadedlistener;
    }

    public void a(of of)
    {
        a.onContentAdLoaded(b(of));
    }

    og b(of of)
    {
        return new og(of);
    }
}
