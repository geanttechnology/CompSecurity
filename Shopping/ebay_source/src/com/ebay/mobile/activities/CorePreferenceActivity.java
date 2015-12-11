// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BasePreferenceActivity;

public abstract class CorePreferenceActivity extends BasePreferenceActivity
    implements android.support.v4.app.TaskStackBuilder.SupportParentable, android.support.v7.app.ActionBarDrawerToggle.DelegateProvider, AppCompatCallback
{

    private AppCompatDelegate appCompatDelegate;
    private final CoreActivity.MessageHelper messageHelper = new CoreActivity.MessageHelper() {

        final CorePreferenceActivity this$0;

        protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
        {
            return CorePreferenceActivity.this.showMessageAsBar(message);
        }

            
            {
                this$0 = CorePreferenceActivity.this;
                super();
            }
    };

    public CorePreferenceActivity()
    {
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().addContentView(view, layoutparams);
    }

    public final AppCompatDelegate getDelegate()
    {
        if (appCompatDelegate == null)
        {
            appCompatDelegate = AppCompatDelegate.create(this, this);
        }
        return appCompatDelegate;
    }

    public android.support.v7.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
    {
        return getDelegate().getDrawerToggleDelegate();
    }

    public MenuInflater getMenuInflater()
    {
        return getDelegate().getMenuInflater();
    }

    public ActionBar getSupportActionBar()
    {
        return getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent()
    {
        return NavUtils.getParentActivityIntent(this);
    }

    public void invalidateOptionsMenu()
    {
        getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        AppCompatDelegate appcompatdelegate = getDelegate();
        appcompatdelegate.installViewFactory();
        appcompatdelegate.onCreate(bundle);
        super.onCreate(bundle);
        if (MyApp.getDeviceConfiguration().isLockedPortraitOnPhone(getResources()))
        {
            setRequestedOrientation(1);
        }
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
        taskstackbuilder.addParentStack(this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (!super.onMenuItemSelected(i, menuitem))
        {
            ActionBar actionbar = getSupportActionBar();
            if (menuitem.getItemId() != 0x102002c || actionbar == null || (actionbar.getDisplayOptions() & 4) == 0 || !onSupportNavigateUp())
            {
                return false;
            }
        }
        return true;
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

    protected void onPostCreate(Bundle bundle)
    {
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null)
        {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
    }

    protected void onStop()
    {
        super.onStop();
        getDelegate().onStop();
    }

    public void onSupportActionModeFinished(ActionMode actionmode)
    {
    }

    public void onSupportActionModeStarted(ActionMode actionmode)
    {
    }

    public boolean onSupportNavigateUp()
    {
        Object obj = getSupportParentActivityIntent();
        if (obj != null)
        {
            if (supportShouldUpRecreateTask(((Intent) (obj))))
            {
                obj = TaskStackBuilder.create(this);
                onCreateSupportNavigateUpTaskStack(((TaskStackBuilder) (obj)));
                onPrepareSupportNavigateUpTaskStack(((TaskStackBuilder) (obj)));
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
                supportNavigateUpTo(((Intent) (obj)));
            }
            return true;
        } else
        {
            return false;
        }
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        getDelegate().setTitle(charsequence);
    }

    public void setContentView(int i)
    {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view)
    {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().setContentView(view, layoutparams);
    }

    protected final void setShowWarnings(boolean flag)
    {
        messageHelper.setShowWarnings(flag);
    }

    public void setSupportActionBar(Toolbar toolbar)
    {
        getDelegate().setSupportActionBar(toolbar);
    }

    public void showMessage(Fragment fragment, int i, ResultStatus resultstatus)
    {
        messageHelper.showMessage(this, fragment, i, resultstatus);
    }

    protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return "network".equals(message.getCategory());
    }

    public ActionMode startSupportActionMode(android.support.v7.view.ActionMode.Callback callback)
    {
        return getDelegate().startSupportActionMode(callback);
    }

    public void supportNavigateUpTo(Intent intent)
    {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int i)
    {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent)
    {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }
}
