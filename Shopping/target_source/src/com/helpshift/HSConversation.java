// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.h;
import android.support.v4.app.l;
import android.text.TextUtils;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.helpshift.app.b;
import com.helpshift.g.a.a;
import com.helpshift.i.e;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.helpshift:
//            h, l, s, HSAddIssueFragment, 
//            HSMessagesFragment, j

public final class HSConversation extends com.helpshift.h
{

    public static boolean a = false;
    private com.helpshift.l b;
    private s c;
    private Bundle d;
    private l e;
    private Locale f;

    public HSConversation()
    {
    }

    public static void c(boolean flag)
    {
        a = flag;
    }

    public static boolean h()
    {
        return a;
    }

    private void j()
    {
        String s1 = c.f(b.B());
        String s2 = c.h(b.B());
        if (!TextUtils.isEmpty(s2))
        {
            d.putString("issueId", s2);
            l();
            return;
        }
        if (!TextUtils.isEmpty(s1))
        {
            d.putString("issueId", s1);
            l();
            return;
        } else
        {
            k();
            return;
        }
    }

    private void k()
    {
        e.a(b.c.k, Fragment.instantiate(this, com/helpshift/HSAddIssueFragment.getName(), d));
        e.a();
        super.g();
    }

    private void l()
    {
        e.a(b.c.k, Fragment.instantiate(this, com/helpshift/HSMessagesFragment.getName(), d));
        e.a();
    }

    private void m()
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void onBackPressed()
    {
        setResult(-1, new Intent());
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (!f.equals(configuration.locale))
        {
            m();
        }
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
label0:
        {
            super.onCreate(bundle);
            f = getResources().getConfiguration().locale;
            b = new com.helpshift.l(this);
            c = b.a;
            Bundle bundle1 = getIntent().getExtras();
            obj = i();
            ((b) (obj)).a(5);
            ((b) (obj)).a(true);
            ((b) (obj)).a(getString(b.g.ae));
            setContentView(b.d.c);
            if (!c.Z())
            {
                obj = (LinearLayout)findViewById(b.c.j);
                ImageView imageview = new ImageView(this);
                imageview.setImageDrawable(com.helpshift.g.a.a.a(this, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
                imageview.setBackgroundResource(0x106000c);
                ((LinearLayout) (obj)).addView(imageview);
            }
            d = new Bundle(bundle1);
            obj = bundle1.getString("chatLaunchSource");
            com.helpshift.j.a = bundle1.getBoolean("decomp", false);
            e = f().a();
            if (bundle == null)
            {
                if (!bundle1.getBoolean("newConversation"))
                {
                    break label0;
                }
                k();
            }
            return;
        }
        if ("push".equals(obj) || "inapp".equals(obj))
        {
            l();
            return;
        } else
        {
            j();
            return;
        }
    }

    public volatile boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    public void onDestroy()
    {
        c.c(Boolean.valueOf(false));
        super.onDestroy();
    }

    protected void onPause()
    {
        Bundle bundle = getIntent().getExtras();
        String s1 = c.f(b.B());
        String s2 = c.h(b.B());
        if ((bundle.getBoolean("newConversation") || TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2)) && !h())
        {
            setResult(-1, new Intent());
            finish();
        }
        com.helpshift.i.e.c(this);
        if (bundle != null && Boolean.valueOf(bundle.getBoolean("isRoot")).booleanValue() && isFinishing())
        {
            com.helpshift.i.e.a();
        }
        super.onPause();
    }

    protected void onResume()
    {
        Bundle bundle = getIntent().getExtras();
        String s1 = c.f(b.B());
        String s2 = c.h(b.B());
        if (bundle.getBoolean("newConversation") || TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2))
        {
            com.helpshift.i.e.c(this);
        } else
        {
            com.helpshift.i.e.b(this);
        }
        c.c(Boolean.valueOf(true));
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
