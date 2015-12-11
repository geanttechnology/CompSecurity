// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.advert;


// Referenced classes of package com.shazam.model.advert:
//            AdData, AdType

public class Ad
{

    public final AdData adData;
    public final AdType adType;

    private Ad(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        adData = Builder.a(builder);
        adType = Builder.b(builder);
    }

    Ad(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
