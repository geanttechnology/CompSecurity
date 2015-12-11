// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import com.helpshift.app.b;
import com.helpshift.g.a.a;
import com.helpshift.i.e;
import com.helpshift.i.w;
import java.util.Map;

// Referenced classes of package com.helpshift:
//            h, HSQuestionFragment, l, s

public final class HSQuestion extends h
{

    Bundle a;
    b b;
    private HSQuestionFragment c;
    private ImageView d;
    private l e;

    public HSQuestion()
    {
        c = null;
    }

    public void a(Fragment fragment)
    {
        super.a(fragment);
        if (fragment instanceof HSQuestionFragment)
        {
            c = (HSQuestionFragment)fragment;
        }
    }

    protected boolean h()
    {
        String s1 = a.getString("questionFlow");
        return !TextUtils.isEmpty(s1) && s1.equals("showSearchOnNewConversationFlow");
    }

    public volatile void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a(5);
        i().a(getString(b.g.ad));
        a = getIntent().getExtras();
        if (Boolean.valueOf(a.getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        e = new l(this);
        setContentView(b.d.h);
        b = i();
        b.a(true);
        if (!e.a.Z())
        {
            d = (ImageView)findViewById(b.c.l);
            d.setImageDrawable(com.helpshift.g.a.a.a(this, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
            d.setBackgroundResource(0x106000c);
        }
        d(true);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (h())
        {
            getMenuInflater().inflate(com.helpshift.b.e.e, menu);
            w.a(this, menu.findItem(b.c.ag).getIcon());
        }
        if (b == null)
        {
            b = i();
        }
        b.a(menu, getMenuInflater());
        return super.onCreateOptionsMenu(menu);
    }

    public void onPause()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && Boolean.valueOf(bundle.getBoolean("isRoot")).booleanValue() && isFinishing())
        {
            com.helpshift.i.e.a();
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }

    public volatile void onStart()
    {
        super.onStart();
    }

    public volatile void onStop()
    {
        super.onStop();
    }
}
