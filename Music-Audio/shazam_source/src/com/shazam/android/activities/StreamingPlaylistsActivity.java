// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.shazam.android.activities.streaming.b;
import com.shazam.android.activities.streaming.c;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.StreamingEventFactory;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.streaming.StreamingPlaylistsFragment;
import com.shazam.b.b.d;
import com.shazam.i.b.g.b.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.social.ConnectionState;
import java.util.List;
import java.util.Map;

public class StreamingPlaylistsActivity extends AutoToolbarBaseAppCompatActivity
{

    private final EventAnalytics a = com.shazam.i.b.g.b.a.a();
    private final Map b;
    private ConnectionState c;
    private b d;
    private String e;

    public StreamingPlaylistsActivity()
    {
        b = com.shazam.b.b.d.a(b.a, com.shazam.i.b.ap.a.a(), b.b, com.shazam.i.b.ap.a.b());
    }

    private void a()
    {
        android.support.v4.app.Fragment fragment1 = getSupportFragmentManager().a("StreamingProviderPlaylistsFragment");
        android.support.v4.app.Fragment fragment = fragment1;
        if (fragment1 == null)
        {
            fragment = StreamingPlaylistsFragment.a(d, e);
        }
        getSupportFragmentManager().a().b(0x7f1100c3, fragment, "StreamingProviderPlaylistsFragment").b();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
            super.onActivityResult(i, j, intent);
            if (i == 1111)
            {
                if (c.a())
                {
                    break label0;
                }
                finish();
            }
            return;
        }
        a();
    }

    public void onBackPressed()
    {
        a.logEvent(StreamingEventFactory.createStreamingPlaylistTappedEvent(d, null));
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setDefaultContentView();
        if (com.shazam.android.util.f.a.a(getIntent(), 2))
        {
            bundle = getIntent().getData().getPathSegments();
            d = com.shazam.android.activities.streaming.b.a((String)bundle.get(0));
            e = (String)bundle.get(1);
        }
        c = (ConnectionState)b.get(d);
        setTitle(getString(0x7f09012f, new Object[] {
            getString(d.d)
        }));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(0x7f130007, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i = menuitem.getItemId();
        if (i == 0x102002c)
        {
            onBackPressed();
            return true;
        }
        if (i == 0x7f110291)
        {
            com.shazam.android.activities.b.a.a(this, TaggingOrigin.TOP_BAR);
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (c.a())
        {
            a();
            return;
        }
        b b1 = d;
        if (b1 == b.a || b1 == b.b)
        {
            startActivityForResult(com.shazam.android.activities.streaming.c.a(b1, this, ScreenOrigin.PLUS_BUTTON), 1111);
            return;
        } else
        {
            finish();
            return;
        }
    }
}
