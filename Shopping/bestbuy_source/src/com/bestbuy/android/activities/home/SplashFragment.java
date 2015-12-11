// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import it;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeActivity

public class SplashFragment extends BBYBaseFragment
{

    Activity a;
    private View b;

    public SplashFragment()
    {
    }

    private void a(Activity activity)
    {
        (new it(activity, this)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void b()
    {
        (new Handler()).postDelayed(new Runnable() {

            final SplashFragment a;

            public void run()
            {
                Intent intent = new Intent(a.a, com/bestbuy/android/activities/home/HomeActivity);
                a.f.a(false);
                intent.setFlags(0x4000000);
                a.a.startActivity(intent);
                a.a.finish();
            }

            
            {
                a = SplashFragment.this;
                super();
            }
        }, 3000L);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = layoutinflater.inflate(0x7f0300f5, viewgroup, false);
        return b;
    }

    public void onResume()
    {
        super.onResume();
        a(a);
    }
}
