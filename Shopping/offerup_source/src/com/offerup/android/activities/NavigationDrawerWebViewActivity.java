// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

// Referenced classes of package com.offerup.android.activities:
//            OfferUpWebViewActivity

public class NavigationDrawerWebViewActivity extends OfferUpWebViewActivity
{

    private Toolbar d;

    public NavigationDrawerWebViewActivity()
    {
    }

    public final int a()
    {
        return 0x7f04002d;
    }

    protected final void a(ActionBar actionbar)
    {
        super.a(actionbar);
        if (actionbar != null)
        {
            actionbar.setHomeAsUpIndicator(0x7f020015);
            actionbar.setTitle(getString(0x7f0900b4));
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setDisplayShowTitleEnabled(true);
        }
    }

    public final int c()
    {
        return 4;
    }

    public final boolean d()
    {
        return true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d = (Toolbar)findViewById(0x7f100094);
        setSupportActionBar(d);
        a(getSupportActionBar());
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        if (a)
        {
            getMenuInflater().inflate(0x7f110003, menu);
            return true;
        } else
        {
            return super.onCreateOptionsMenu(menu);
        }
    }
}
