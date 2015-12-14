// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.ui.BaseActivity;

// Referenced classes of package com.livemixtapes:
//            Mixtapes, console, App

public class MixtapesActivity extends BaseActivity
{

    public int day_mixtapes;
    public DBHelper dbHelper;
    public int unreleased_mixtapes;
    public int week_mixtapes;

    public MixtapesActivity()
    {
    }

    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() != 0)
        {
            getFragmentManager().popBackStack();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle, 0x7f03002a);
        dbHelper = DBHelper.sharedInstance(this);
        week_mixtapes = dbHelper.mixtapeCount("week_mixtapes");
        day_mixtapes = dbHelper.mixtapeCount("day_mixtapes");
        unreleased_mixtapes = dbHelper.mixtapeCount("unreleased_mixtapes");
        if (bundle == null)
        {
            getFragmentManager().beginTransaction().add(0x7f0800cc, new Mixtapes()).commit();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
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
            "LOGGING MIXTAPES ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~MixtapesActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }
}
