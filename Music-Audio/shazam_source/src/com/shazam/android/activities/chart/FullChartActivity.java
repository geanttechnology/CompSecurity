// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.chart;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.chart.FullChartFragment;
import com.shazam.android.k.f.ac;
import com.shazam.android.k.f.af;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

public class FullChartActivity extends AutoToolbarBaseAppCompatActivity
{

    private final ac a = new af("charttitle");
    private final j b = new j();

    public FullChartActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setDefaultContentView();
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

    protected void onResume()
    {
        super.onResume();
        if (getSupportFragmentManager().a("tag_full_chart_fragment") == null)
        {
            Uri uri = getIntent().getData();
            String s = uri.getQueryParameter("charttitle");
            Object obj = j.a(getIntent());
            uri = a.a(uri);
            Object obj1 = ((i) (obj)).a();
            String s1 = ((AnalyticsInfo) (obj1)).a(DefinedEventParameterKey.SCREEN_NAME);
            String s2 = ((AnalyticsInfo) (obj1)).a(DefinedEventParameterKey.SCREEN_ORIGIN);
            obj1 = ((AnalyticsInfo) (obj1)).a(DefinedEventParameterKey.EVENT_ID);
            if (((i) (obj)).a != null)
            {
                obj = ((i) (obj)).a;
            } else
            {
                obj = com.shazam.model.advert.AdvertInfo.Builder.a().b();
            }
            obj = FullChartFragment.a(s, uri, s1, s2, ((String) (obj1)), ((com.shazam.model.advert.AdvertInfo) (obj)));
            getSupportFragmentManager().a().a(0x7f1100c3, ((android.support.v4.app.Fragment) (obj)), "tag_full_chart_fragment").a();
        }
    }
}
