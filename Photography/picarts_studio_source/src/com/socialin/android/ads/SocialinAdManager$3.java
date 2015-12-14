// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;


// Referenced classes of package com.socialin.android.ads:
//            SocialinAdManager, AdProviders

final class csArtInterstitialType
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[csArtInterstitialType.values().length];
        try
        {
            b[csArtInterstitialType.DRAW.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            b[csArtInterstitialType.EXPORT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        a = new int[AdProviders.values().length];
        try
        {
            a[AdProviders.MOPUB2.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[AdProviders.ADMOB.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
