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
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.MainSearchActivity;
import com.ebay.mobile.user.symban.SymbanUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseListActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

public abstract class CoreListActivity extends BaseListActivity
    implements android.support.v4.app.TaskStackBuilder.SupportParentable, android.support.v7.app.ActionBarDrawerToggle.DelegateProvider, AppCompatCallback, com.ebay.nautilus.domain.content.dm.SymbanDataManager.Observer
{

    protected ActionBarDrawerToggle drawerToggle;
    private AppCompatDelegate mDelegate;
    private final CoreActivity.MessageHelper messageHelper = new CoreActivity.MessageHelper() {

        final CoreListActivity this$0;

        protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
        {
            return CoreListActivity.this.showMessageAsBar(message);
        }

            
            {
                this$0 = CoreListActivity.this;
                super();
            }
    };
    protected SymbanDataManager symbanDm;

    public CoreListActivity()
    {
    }

    public void addContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().addContentView(view, layoutparams);
    }

    public AppCompatDelegate getDelegate()
    {
        if (mDelegate == null)
        {
            mDelegate = AppCompatDelegate.create(this, this);
        }
        return mDelegate;
    }

    public android.support.v7.app.ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
    {
        return getDelegate().getDrawerToggleDelegate();
    }

    protected android.view.View.OnClickListener getFollowButtonClickListener()
    {
        return null;
    }

    public MenuInflater getMenuInflater()
    {
        return getDelegate().getMenuInflater();
    }

    protected DrawerLayout getNavigationDrawer()
    {
        return (DrawerLayout)findViewById(0x7f10016c);
    }

    protected android.view.View.OnClickListener getSearchViewClickListener()
    {
        return new android.view.View.OnClickListener() {

            final CoreListActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(CoreListActivity.this, com/ebay/mobile/search/MainSearchActivity);
                startActivity(view);
            }

            
            {
                this$0 = CoreListActivity.this;
                super();
            }
        };
    }

    public ActionBar getSupportActionBar()
    {
        return getDelegate().getSupportActionBar();
    }

    public Intent getSupportParentActivityIntent()
    {
        return NavUtils.getParentActivityIntent(this);
    }

    protected SymbanDataManager getSymbanDm()
    {
        return symbanDm;
    }

    public void invalidateOptionsMenu()
    {
        getDelegate().invalidateOptionsMenu();
    }

    public void onBackPressed()
    {
        DrawerLayout drawerlayout = getNavigationDrawer();
        if (drawerlayout != null && drawerlayout.isDrawerOpen(3))
        {
            drawerlayout.closeDrawer(3);
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        getDelegate().installViewFactory();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
        initDataManagers();
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

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        symbanDm = SymbanUtils.initalizeDataManager(datamanagercontainer);
        datamanagercontainer.initialize(SymbanDataManager.KEY, this);
    }

    public void onMarkAllReadCompleted(SymbanDataManager symbandatamanager, ResultStatus resultstatus)
    {
    }

    public boolean onMenuItemSelected(int i, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i, menuitem))
        {
            return true;
        }
        ActionBar actionbar = getSupportActionBar();
        if (menuitem.getItemId() == 0x102002c && actionbar != null && (actionbar.getDisplayOptions() & 4) != 0)
        {
            return onSupportNavigateUp();
        } else
        {
            return false;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (drawerToggle != null && drawerToggle.onOptionsItemSelected(menuitem))
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        getDelegate().onPostCreate(bundle);
        bundle = getNavigationDrawer();
        drawerToggle = CoreActivity.setupDrawerToggle(this, bundle);
        CoreActivity.setupToolbar(this, getDelegate(), bundle, drawerToggle, true, getSearchViewClickListener(), getFollowButtonClickListener());
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

    public void onSymbanCountChanged(SymbanDataManager symbandatamanager, int i)
    {
        CoreActivity.setupNavigationMenuButtonBadge(this, i);
    }

    public void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content)
    {
        if (ResultStatus.SUCCESS.equals(content.getStatus()))
        {
            CoreActivity.setupNavigationMenuButtonBadge(this, ((List)content.getData()).size());
            return;
        } else
        {
            CoreActivity.setupNavigationMenuButtonBadge(this, 0);
            return;
        }
    }

    public void onSymbanUpdatedCompleted(SymbanDataManager symbandatamanager, SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum)
    {
        symbandatamanager = symbandatamanager.getCountIfExists();
        int i;
        if (symbandatamanager != null)
        {
            i = symbandatamanager.intValue();
        } else
        {
            i = 0;
        }
        CoreActivity.setupNavigationMenuButtonBadge(this, i);
    }

    protected void onTitleChanged(CharSequence charsequence, int i)
    {
        super.onTitleChanged(charsequence, i);
        getDelegate().setTitle(charsequence);
    }

    public void setContentView(int i)
    {
        if (shouldShowNavigationDrawer())
        {
            LayoutInflater layoutinflater = getLayoutInflater();
            View view;
            if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.boxShaded))
            {
                view = layoutinflater.inflate(0x7f03008c, null);
            } else
            {
                view = layoutinflater.inflate(0x7f03008b, null);
            }
            layoutinflater.inflate(i, (ViewGroup)view.findViewById(0x7f100173), true);
            getDelegate().setContentView(view);
            return;
        } else
        {
            getDelegate().setContentView(i);
            return;
        }
    }

    public void setContentView(View view)
    {
        if (shouldShowNavigationDrawer())
        {
            View view1 = getLayoutInflater().inflate(0x7f03008b, null);
            ((ViewGroup)view1.findViewById(0x7f100173)).addView(view);
            getDelegate().setContentView(view1);
            return;
        } else
        {
            getDelegate().setContentView(view);
            return;
        }
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        getDelegate().setContentView(view, layoutparams);
    }

    public void setFollowButtonText(String s)
    {
        Button button = (Button)findViewById(0x7f100172);
        if (button != null)
        {
            button.setText(s);
        }
    }

    public void setSearchViewText(String s)
    {
        TextView textview1 = (TextView)findViewById(0x7f100176);
        TextView textview = textview1;
        if (textview1 == null)
        {
            textview = (TextView)findViewById(0x7f100171);
        }
        if (textview != null)
        {
            textview.setText(s);
        }
    }

    protected final void setShowWarnings(boolean flag)
    {
        messageHelper.setShowWarnings(flag);
    }

    public void setSupportActionBar(Toolbar toolbar)
    {
        getDelegate().setSupportActionBar(toolbar);
    }

    protected boolean shouldShowNavigationDrawer()
    {
        boolean flag1 = false;
        TypedValue typedvalue = new TypedValue();
        getTheme().resolveAttribute(0x7f010047, typedvalue, false);
        boolean flag = flag1;
        if (typedvalue.type == 18)
        {
            flag = flag1;
            if (typedvalue.data != 0)
            {
                flag = true;
            }
        }
        return flag;
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
