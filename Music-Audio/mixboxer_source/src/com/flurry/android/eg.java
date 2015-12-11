// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            FlurryAppCloud, CacheSyncManager, az

final class eg
    implements Runnable
{

    private String ge;
    private String gf;
    private boolean gg;
    private String mCollectionName;
    private String mValue;

    public eg(String s, String s1, String s2, String s3)
    {
        ge = "";
        mValue = "";
        gf = "";
        mCollectionName = "";
        gg = true;
        ge = s;
        mValue = s1;
        gf = s2;
        mCollectionName = null;
    }

    public final void run()
    {
        if (gg)
        {
            FlurryAppCloud.D().getServerData().c(ge, mValue, gf, mCollectionName);
            return;
        } else
        {
            FlurryAppCloud.D().getServerData().b(ge, mValue, gf, mCollectionName);
            return;
        }
    }
}
