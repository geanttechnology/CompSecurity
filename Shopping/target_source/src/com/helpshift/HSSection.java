// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.h;
import android.support.v4.app.l;
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
//            HSSectionFragment

public final class HSSection extends com.helpshift.h
{

    private com.helpshift.l a;
    private s b;
    private HSSectionFragment c;
    private String d;
    private b e;

    public HSSection()
    {
    }

    public volatile void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        com.helpshift.j.a = true;
        bundle = getIntent().getExtras();
        if (bundle != null)
        {
            d = (String)bundle.get("sectionPublishId");
        }
        a = new com.helpshift.l(this);
        b = a.a;
        if (Boolean.valueOf(bundle.getBoolean("showInFullScreen")).booleanValue())
        {
            getWindow().setFlags(1024, 1024);
        }
        setContentView(b.d.k);
        e = i();
        e.a(true);
        if (!b.Z())
        {
            ImageView imageview = (ImageView)findViewById(b.c.F);
            imageview.setImageDrawable(com.helpshift.g.a.a.a(this, (String)com.helpshift.g.a.b.a.get("newHSLogo")));
            imageview.setBackgroundResource(0x106000c);
        }
        l l1 = f().a();
        c = new HSSectionFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("sectionPublishId", d);
        bundle1.putBoolean("decomp", true);
        bundle1.putAll(bundle);
        c.setArguments(bundle1);
        l1.a(b.c.G, c);
        l1.a();
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

    public volatile void onStart()
    {
        super.onStart();
    }

    public volatile void onStop()
    {
        super.onStop();
    }
}
