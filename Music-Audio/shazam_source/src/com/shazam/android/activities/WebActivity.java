// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.h;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.shazam.android.activities.deeplink.b;
import com.shazam.android.analytics.TaggingOrigin;
import com.shazam.android.aspects.activities.MiniTaggingListener;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.TaggingDialogFragment;
import com.shazam.android.fragment.TransitionParams;
import com.shazam.android.k.f.i;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.q;
import com.shazam.android.v.p;
import com.shazam.android.v.s;
import com.shazam.android.web.bridge.b.c;
import com.shazam.i.b.ar.a.e;
import com.shazam.i.b.ax.a.a.a;
import java.util.Locale;

// Referenced classes of package com.shazam.android.activities:
//            MainActivity

public class WebActivity extends AutoToolbarBaseAppCompatActivity
    implements MiniTaggingListener
{

    private final c a;
    private final s b;
    private final com.shazam.android.ay.a.q c;
    private final j d;
    private final com.shazam.android.activities.deeplink.a e;
    private boolean f;

    public WebActivity()
    {
        this(com.shazam.i.b.ax.a.a.a.a(), ((s) (new p(new q(), new j()))));
    }

    public WebActivity(c c1, s s1)
    {
        c = com.shazam.i.b.ar.a.e.a();
        d = new j();
        e = new b();
        a = c1;
        b = s1;
    }

    public static Intent a(Activity activity, String s1, Uri uri, String s2, String s3, String s4)
    {
        activity = new Intent(activity, com/shazam/android/activities/WebActivity);
        activity.setData(Uri.parse(s1));
        activity.putExtra("useTimeOut", true);
        activity.putExtra("tagUri", uri);
        activity.putExtra("trackId", s2);
        activity.putExtra("beaconKey", s3);
        activity.putExtra("campaign", s4);
        return activity;
    }

    public void onBackPressed()
    {
        if (getIntent().getBooleanExtra("useTimeOut", false))
        {
            setResult(0);
            finish();
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            setContentView(0x7f030074);
            Object obj = getIntent().getStringExtra("overridingTitle");
            if (obj != null)
            {
                setTitle(((String) (obj)).toUpperCase(Locale.getDefault()));
            }
            obj = a.a(this, getIntent().getData().toString());
            if (bundle == null)
            {
                if (obj == null)
                {
                    break label0;
                }
                startActivity(((Intent) (obj)));
                finish();
            }
            return;
        }
        bundle = b.a(getIntent());
        m m1 = getSupportFragmentManager().a();
        m1.b(0x7f1101d7, bundle, "webFragment");
        m1.b();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f130007, menu);
        if (f)
        {
            menu = menu.findItem(0x7f110291);
            if (menu != null)
            {
                menu.setVisible(false);
            }
        }
        return true;
    }

    public void onMiniTaggingDisplayed()
    {
        f = true;
        invalidateOptionsMenu();
    }

    public void onMiniTaggingHidden()
    {
        f = false;
        invalidateOptionsMenu();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag = false;
        int l = menuitem.getItemId();
        if (l == 0x7f110291)
        {
            c.a(com.shazam.android.analytics.TaggedBeaconData.Builder.taggedBeaconData().withTaggingOrigin(TaggingOrigin.TOP_BAR).build());
            TaggingDialogFragment.a(TransitionParams.a(getToolbar().findViewById(0x7f110291))).a(getSupportFragmentManager(), TaggingDialogFragment.aj);
            return true;
        }
        if (l == 0x102002c)
        {
            if (j.a(getIntent()).b().a || e.a(new Uri[] {
    getIntent().getData(), (Uri)getIntent().getParcelableExtra("tagUri")
}))
            {
                flag = true;
            }
            if (flag)
            {
                startActivity(new Intent(this, com/shazam/android/activities/MainActivity));
                finish();
            } else
            {
                onBackPressed();
            }
            return true;
        } else
        {
            return false;
        }
    }
}
