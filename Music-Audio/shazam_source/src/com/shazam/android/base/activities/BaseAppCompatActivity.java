// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.base.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.k;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.shazam.android.aspects.c.a.a;
import com.shazam.android.fragment.c;
import java.util.List;

// Referenced classes of package com.shazam.android.base.activities:
//            AutoToolbarBaseAppCompatActivity

public abstract class BaseAppCompatActivity extends a
    implements com.shazam.android.aq.a
{

    private boolean displayHomeAsUp;
    private boolean displayShowTitle;

    public BaseAppCompatActivity()
    {
        displayHomeAsUp = true;
        displayShowTitle = true;
    }

    private void setupToolbarIfNotAuto()
    {
        if (!(this instanceof AutoToolbarBaseAppCompatActivity))
        {
            setupToolbar(getToolbar());
        }
    }

    public String getAgofViewKey()
    {
        return "ShazamAndroid";
    }

    public Toolbar getToolbar()
    {
        return (Toolbar)findViewById(0x7f1100b0);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        CharSequence charsequence = menuitem.getTitle();
        if (charsequence != null)
        {
            menuitem.setTitleCondensed(charsequence.toString());
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        List list = getSupportFragmentManager().f();
        if (list != null)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Fragment fragment = (Fragment)list.get(i);
                if (fragment instanceof c)
                {
                    ((c)fragment).onWindowFocusChanged(flag);
                }
            }

        }
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        setupToolbarIfNotAuto();
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        setupToolbarIfNotAuto();
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        setupToolbarIfNotAuto();
    }

    public void setDisplayHomeAsUp(boolean flag)
    {
        displayHomeAsUp = flag;
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().a(flag);
        }
    }

    public void setDisplayShowTitle(boolean flag)
    {
        displayShowTitle = flag;
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().b(flag);
        }
    }

    public void setupToolbar(Toolbar toolbar)
    {
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().a(displayHomeAsUp);
            getSupportActionBar().b(displayShowTitle);
        }
    }
}
