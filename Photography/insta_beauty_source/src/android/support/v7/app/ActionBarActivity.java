// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import c;
import ee;

// Referenced classes of package android.support.v7.app:
//            ActionBar

public class ActionBarActivity extends FragmentActivity
    implements android.support.v4.app.ActionBarDrawerToggle.DelegateProvider, android.support.v4.app.TaskStackBuilder.SupportParentable
{

    private c a;

    public ActionBarActivity()
    {
    }

    private c d()
    {
        if (a == null)
        {
            a = c.a(this);
        }
        return a;
    }

    public ActionBar a()
    {
        return d().b();
    }

    public void a(TaskStackBuilder taskstackbuilder)
    {
        taskstackbuilder.addParentStack(this);
    }

    void a(View view)
    {
        super.setContentView(view);
    }

    public void a(ee ee)
    {
    }

    public boolean a(int i, Menu menu)
    {
        return super.onCreatePanelMenu(i, menu);
    }

    public boolean a(int i, View view, Menu menu)
    {
        return super.onPreparePanel(i, view, menu);
    }

    public boolean a(Intent intent)
    {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    public boolean a(View view, Menu menu)
    {
        return super.onPrepareOptionsPanel(view, menu);
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        d().b(view, layoutparams);
    }

    void b(int i, Menu menu)
    {
        super.onPanelClosed(i, menu);
    }

    public void b(Intent intent)
    {
        NavUtils.navigateUpTo(this, intent);
    }

    public void b(TaskStackBuilder taskstackbuilder)
    {
    }

    public void b(ee ee)
    {
    }

    public boolean b()
    {
        Object obj = getSupportParentActivityIntent();
        if (obj != null)
        {
            if (a(((Intent) (obj))))
            {
                obj = TaskStackBuilder.create(this);
                a(((TaskStackBuilder) (obj)));
                b(((TaskStackBuilder) (obj)));
                ((TaskStackBuilder) (obj)).startActivities();
                try
                {
                    ActivityCompat.finishAffinity(this);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    finish();
                }
            } else
            {
                b(((Intent) (obj)));
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void c()
    {
    }

    boolean c(int i, Menu menu)
    {
        return super.onMenuOpened(i, menu);
    }

    public final android.support.v4.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
    {
        return d().i();
    }

    public MenuInflater getMenuInflater()
    {
        return d().d();
    }

    public Intent getSupportParentActivityIntent()
    {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu()
    {
        d().g();
    }

    public void onBackPressed()
    {
        if (!d().h())
        {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        d().a(configuration);
    }

    public final void onContentChanged()
    {
        d().k();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        d().a(bundle);
    }

    public boolean onCreatePanelMenu(int i, Menu menu)
    {
        return d().c(i, menu);
    }

    public View onCreatePanelView(int i)
    {
        if (i == 0)
        {
            return d().b(i);
        } else
        {
            return super.onCreatePanelView(i);
        }
    }

    public View onCreateView(String s, Context context, AttributeSet attributeset)
    {
        View view = super.onCreateView(s, context, attributeset);
        if (view != null)
        {
            return view;
        } else
        {
            return d().a(s, context, attributeset);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        d().n();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (super.onKeyDown(i, keyevent))
        {
            return true;
        } else
        {
            return d().a(i, keyevent);
        }
    }

    public boolean onKeyShortcut(int i, KeyEvent keyevent)
    {
        return d().b(i, keyevent);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i, menuitem))
        {
            return true;
        }
        ActionBar actionbar = a();
        if (menuitem.getItemId() == 0x102002c && actionbar != null && (actionbar.a() & 4) != 0)
        {
            return b();
        } else
        {
            return false;
        }
    }

    public boolean onMenuOpened(int i, Menu menu)
    {
        return d().b(i, menu);
    }

    public void onPanelClosed(int i, Menu menu)
    {
        d().a(i, menu);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        d().f();
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu)
    {
        return d().a(view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu)
    {
        return d().a(i, view, menu);
    }

    protected void onStop()
    {
        super.onStop();
        d().e();
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        d().a(charsequence);
    }

    public void setContentView(int i)
    {
        d().a(i);
    }

    public void setContentView(View view)
    {
        d().a(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        d().a(view, layoutparams);
    }

    public void supportInvalidateOptionsMenu()
    {
        d().g();
    }
}
