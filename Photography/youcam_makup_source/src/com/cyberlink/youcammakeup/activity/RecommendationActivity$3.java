// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.utility.o;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            RecommendationActivity

class a
    implements Runnable
{

    final RecommendationActivity a;

    public void run()
    {
        Globals.d().i().h(a);
        RecommendationActivity.d(a).setText(0x7f07051d);
        RecommendationActivity.d(a).setTextColor(0xff000000);
    }

    (RecommendationActivity recommendationactivity)
    {
        a = recommendationactivity;
        super();
    }
}
