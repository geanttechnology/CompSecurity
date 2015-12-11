// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.a;

// Referenced classes of package com.smule.android.network.managers:
//            RecommendationManager

class b
    implements Runnable
{

    final tRecommendedSingersCallback a;
    final String b;
    final RecommendationManager c;

    public void run()
    {
        com.smule.android.network.core.a.a(a, c.c(b));
    }

    tRecommendedSingersCallback(RecommendationManager recommendationmanager, tRecommendedSingersCallback trecommendedsingerscallback, String s)
    {
        c = recommendationmanager;
        a = trecommendedsingerscallback;
        b = s;
        super();
    }
}
