// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.flurry.android.FlurryAds;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class a
    implements Runnable
{

    final ProductListActivity a;

    public void run()
    {
        if (!a.isFinishing())
        {
            FlurryAds.displayAd(a, "PIANDROID_Songbook_Banner", ProductListActivity.g(a));
        }
    }

    (ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}
