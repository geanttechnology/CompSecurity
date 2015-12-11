// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import com.shazam.android.advert.AdBinderStrategyType;
import com.shazam.android.analytics.session.SessionStrategyType;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.chart.ChartsListFragment;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class ChartsListActivity extends AutoToolbarBaseAppCompatActivity
{

    private final j a = new j();

    public ChartsListActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setDefaultContentView();
        setTitle(0x7f090055);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public void onResume()
    {
        super.onResume();
        k k1 = getSupportFragmentManager();
        if (k1.a("tag_charts_list_fragment") == null)
        {
            Object obj = j.a(getIntent()).a();
            obj = ChartsListFragment.a(((AnalyticsInfo) (obj)).a(DefinedEventParameterKey.SCREEN_ORIGIN), ((AnalyticsInfo) (obj)).a(DefinedEventParameterKey.EVENT_ID), SessionStrategyType.START_STOP_FOCUSED_UNFOCUSED, AdBinderStrategyType.RESUMING);
            k1.a().a(0x7f1100c3, ((android.support.v4.app.Fragment) (obj)), "tag_charts_list_fragment").a();
        }
    }
}
