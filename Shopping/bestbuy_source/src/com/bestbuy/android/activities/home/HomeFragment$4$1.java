// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.content.Intent;
import android.os.Handler;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment, WebViewActivity

class a
    implements Runnable
{

    final tActivity a;

    public void run()
    {
        Intent intent = new Intent(a.a.getActivity(), com/bestbuy/android/activities/home/WebViewActivity);
        intent.putExtra("com.bestbuy.android.URL_TOBE_LOADED", "https://secure.opinionlab.com/ccc01/o.asp?id=UdgWGjJa");
        a.a.startActivity(intent);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/bestbuy/android/activities/home/HomeFragment$4

/* anonymous class */
    class HomeFragment._cls4
        implements Runnable
    {

        final HomeFragment a;

        public void run()
        {
            (new Handler()).postDelayed(new HomeFragment._cls4._cls1(this), 3000L);
        }

            
            {
                a = homefragment;
                super();
            }
    }

}
