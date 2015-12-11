// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.k;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.ad.a.h;
import com.shazam.android.af.a.a;
import com.shazam.android.aj.b;
import com.shazam.android.aspects.activities.MiniTaggingController;
import com.shazam.android.aspects.activities.MiniTaggingControllerReceiver;
import com.shazam.android.aspects.activities.MiniTaggingListener;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.android.fragment.g.c;
import com.shazam.android.fragment.musicdetails.MusicDetailsFragment;
import com.shazam.android.fragment.musicdetails.m;
import com.shazam.android.k.f.j;
import com.shazam.android.k.f.l;
import com.shazam.android.k.f.r;
import com.shazam.android.k.f.s;
import com.shazam.android.k.f.z;
import com.shazam.android.view.tagging.e;
import com.shazam.android.widget.n;
import com.shazam.android.widget.tagging.i;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.activities:
//            g

public class MusicDetailsActivity extends BaseAppCompatActivity
    implements h, a, MiniTaggingControllerReceiver, MiniTaggingListener, c, com.shazam.android.fragment.musicdetails.a, e, i
{

    private final m b;
    private final b c;
    private final com.shazam.android.c d;
    private final l e;
    private final n f;
    private final j g;
    private r h;
    private View i;
    private View j;
    private com.shazam.android.fragment.musicdetails.a k;
    private boolean l;
    private boolean m;
    private Bundle n;
    private com.shazam.android.widget.tagging.a o;
    private MiniTaggingController p;

    public MusicDetailsActivity()
    {
        this(((m) (com.shazam.i.b.w.a.a())), com.shazam.i.b.af.a.a(), new com.shazam.android.c());
    }

    public MusicDetailsActivity(m m1, b b1, com.shazam.android.c c1)
    {
        e = com.shazam.i.b.o.c.a.a();
        f = com.shazam.i.b.ay.a.a();
        g = new j();
        l = true;
        o = com.shazam.android.widget.tagging.a.a;
        p = MiniTaggingController.NO_OP;
        b = m1;
        c = b1;
        d = c1;
    }

    private void a(Configuration configuration)
    {
        if (configuration.orientation == 2)
        {
            f.a(i, getResources().getDrawable(0x7f0f0083));
            return;
        } else
        {
            f.a(i);
            return;
        }
    }

    private MusicDetailsFragment g()
    {
        return (MusicDetailsFragment)getSupportFragmentManager().a("music_details_fragment");
    }

    private r h()
    {
        return r.b(e.a(getIntent().getData()));
    }

    public final View a(View view)
    {
        View view1 = view.findViewById(0x7f1100f0);
        if (view1 == null)
        {
            return view;
        } else
        {
            return view1;
        }
    }

    public final void a()
    {
        k.a();
    }

    public final void a(View view, int i1)
    {
        g().b.a(i1);
    }

    public final void a(com.shazam.android.widget.tagging.a a1)
    {
        o = a1;
    }

    public final void b()
    {
        k.b();
    }

    public final String c()
    {
        String s1;
        try
        {
            s1 = h().c.h;
        }
        catch (z z1)
        {
            return null;
        }
        return s1;
    }

    public final void d()
    {
        g().b.f();
    }

    public final boolean e()
    {
        return m;
    }

    public final void f()
    {
        p.disableCancelingOfTaggingWhenStopped();
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroidMatch";
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 10001 && (j1 == -1 || j1 == 0))
        {
            finish();
        } else
        if (i1 == 10001 && j1 == 400)
        {
            l = false;
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030034);
        setDisplayShowTitle(false);
        k = new g(this);
        i = findViewById(0x7f1100e2);
        j = findViewById(0x7f1100c4);
        try
        {
            h = h();
            setTitle((String)b.create(h));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            (new StringBuilder("unable to convert uri to ShazamUri: ")).append(getIntent().getData());
        }
        finish();
    }

    public void onMiniTaggingDisplayed()
    {
        m = true;
    }

    public void onMiniTaggingHidden()
    {
        m = false;
        o.a();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            startActivity(c.a(h, this));
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        n = bundle.getBundle("bundle_music_details_fragment");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (n != null)
        {
            bundle.putBundle("bundle_music_details_fragment", n);
        }
    }

    protected void onStart()
    {
        Object obj = com.shazam.android.k.f.j.a(getIntent());
        obj = MusicDetailsFragment.a(getIntent().getData(), h, com.shazam.android.c.a(this), ((com.shazam.android.k.f.i) (obj)).a().a(DefinedEventParameterKey.EVENT_ID), ((com.shazam.android.k.f.i) (obj)).a().a(DefinedEventParameterKey.SCREEN_ORIGIN));
        if (n != null)
        {
            ((MusicDetailsFragment) (obj)).getArguments().putAll(n);
        }
        boolean flag = l;
        ((MusicDetailsFragment) (obj)).getArguments().putBoolean("displayFullscreen", flag);
        getSupportFragmentManager().a().b(0x7f1100c5, ((android.support.v4.app.Fragment) (obj)), "music_details_fragment").b();
        j.setVisibility(8);
        a(getResources().getConfiguration());
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
        i.setBackgroundResource(0x7f0f0083);
        j.setVisibility(0);
        MusicDetailsFragment musicdetailsfragment = g();
        n = musicdetailsfragment.getArguments();
        getSupportFragmentManager().a().a(musicdetailsfragment).b();
        com.shazam.android.util.h.h.a(musicdetailsfragment.a);
    }

    public void receiveMiniTaggingController(MiniTaggingController minitaggingcontroller)
    {
        p = minitaggingcontroller;
    }
}
