// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.ui.BaseActivity;

// Referenced classes of package com.livemixtapes:
//            WorldFragment, console, App

public class WorldActivity extends BaseActivity
{

    public WorldActivity()
    {
    }

    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() != 0)
        {
            getFragmentManager().popBackStack();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030042);
        getFragmentManager().beginTransaction().add(0x7f0800cc, new WorldFragment()).commit();
    }

    public volatile View onCreateView(View view, String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(view, s, context, attributeset);
    }

    public volatile View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        return super.onCreateView(s, context, attributeset);
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING WORLD ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~WorldActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }
}
