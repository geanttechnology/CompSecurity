// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

class a
    implements android.view.ngeListener
{

    final HomeActivity a;

    public void onFocusChange(View view, boolean flag)
    {
        HomeActivity.access$200(a).postDelayed(new Runnable() {

            final HomeActivity._cls3 a;

            public void run()
            {
                ((InputMethodManager)a.a.getSystemService("input_method")).showSoftInput(HomeActivity.access$200(a.a), 2);
            }

            
            {
                a = HomeActivity._cls3.this;
                super();
            }
        }, 1000L);
    }

    _cls1.a(HomeActivity homeactivity)
    {
        a = homeactivity;
        super();
    }
}
