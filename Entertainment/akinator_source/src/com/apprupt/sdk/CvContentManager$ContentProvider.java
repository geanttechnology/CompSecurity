// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;

// Referenced classes of package com.apprupt.sdk:
//            CvContentManager, CvContentOptions

public static interface r
{

    public abstract void checkAdsAvailable(Context context, CvContentOptions cvcontentoptions, r r);

    public abstract boolean hasContent(String s);

    public abstract r loadAd(Context context, CvContentOptions cvcontentoptions, r r);

    public abstract void prefetchAd(Context context, CvContentOptions cvcontentoptions, r r);
}
