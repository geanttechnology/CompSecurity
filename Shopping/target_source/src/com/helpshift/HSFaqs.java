// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;
import com.helpshift.app.b;
import com.helpshift.g.a.a;
import com.helpshift.i.e;
import java.util.Map;

// Referenced classes of package com.helpshift:
//            h, j, l, s, 
//            o

public final class HSFaqs extends h
{

    private l a;
    private s b;
    private int c;
    private Boolean d;
    private ImageView e;

    public HSFaqs()
    {
        c = 1;
    }

    public volatile void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i().a(getString(b.g.ac));
        com.helpshift.j.a = false;
        d = Boolean.valueOf(getIntent().getExtras().getBoolean("showConvOnReportIssue"));
        if (Boolean.valueOf(getIntent().getExtras().getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        a = new l(this);
        b = a.a;
        setContentView(com.helpshift.b.d.a);
        i().a(true);
        e = (ImageView)findViewById(b.c.l);
        if (!b.Z())
        {
            e.setImageDrawable(com.helpshift.g.a.a.a(this, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
            e.setBackgroundResource(0x106000c);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(b.e.c, menu);
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
        com.helpshift.o.a("l");
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
