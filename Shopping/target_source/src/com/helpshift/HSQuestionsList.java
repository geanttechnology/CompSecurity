// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.helpshift.app.b;
import com.helpshift.g.a.a;
import com.helpshift.i.w;
import java.util.Map;

// Referenced classes of package com.helpshift:
//            h, l, r, s

public final class HSQuestionsList extends h
{

    private r a;
    private ViewPager b;
    private ImageView c;
    private l d;

    public HSQuestionsList()
    {
    }

    static r a(HSQuestionsList hsquestionslist)
    {
        return hsquestionslist.a;
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    public volatile void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (Boolean.valueOf(getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        d = new l(this);
        setContentView(b.d.j);
        bundle = getIntent().getExtras().getString("sectionPublishId");
        a = new r(f(), this, bundle);
        b = (ViewPager)findViewById(b.c.D);
        b.setAdapter(a);
        b.setOnPageChangeListener(new android.support.v4.view.ViewPager.i() {

            final HSQuestionsList a;

            public void a(int j)
            {
                com.helpshift.HSQuestionsList.a(a).b(j);
            }

            
            {
                a = HSQuestionsList.this;
                super();
            }
        });
        b.setCurrentItem(a.d());
        bundle = (PagerTabStrip)findViewById(b.c.E);
        for (int i = 0; i < bundle.getChildCount(); i++)
        {
            Object obj = bundle.getChildAt(i);
            if (obj instanceof TextView)
            {
                obj = (TextView)obj;
                ((TextView) (obj)).setSingleLine();
                ((TextView) (obj)).setEllipsize(android.text.TextUtils.TruncateAt.END);
            }
        }

        bundle.setTabIndicatorColor(w.a(this, b.a.d));
        bundle = i();
        bundle.a(true);
        bundle.a(getResources().getString(b.g.l));
        if (!d.a.Z())
        {
            c = (ImageView)findViewById(b.c.l);
            c.setImageDrawable(com.helpshift.g.a.a.a(this, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
            c.setBackgroundResource(0x106000c);
        }
    }

    public volatile boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
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
