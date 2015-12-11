// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvAdView

public interface CvAdViewCallback
{

    public abstract String getCategories(CvAdView cvadview);

    public abstract String getKeywords(CvAdView cvadview);

    public abstract void onError(CvAdView cvadview, String s, int i);

    public abstract void onFirstTap();

    public abstract void onLoad(CvAdView cvadview);
}
