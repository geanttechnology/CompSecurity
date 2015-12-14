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
//            SearchFragment, console, App

public class SearchActivity extends BaseActivity
{

    public SearchActivity()
    {
    }

    public void onBackPressed()
    {
        if (getFragmentManager().findFragmentByTag("MIXTAPE") != null)
        {
            getFragmentManager().popBackStack();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f030038);
        getFragmentManager().beginTransaction().add(0x7f0800cc, new SearchFragment()).commit();
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
            "LOGGING SEARCH ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~SearchActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }
}
