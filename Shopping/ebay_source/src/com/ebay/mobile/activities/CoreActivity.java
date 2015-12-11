// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.MainSearchActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.user.symban.SymbanUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwContext;
import com.ebay.nautilus.shell.app.TrackingSupport;
import java.util.List;

public abstract class CoreActivity extends BaseActivity
    implements android.support.v4.app.TaskStackBuilder.SupportParentable, android.support.v7.app.ActionBarDrawerToggle.DelegateProvider, AppCompatCallback, com.ebay.nautilus.domain.content.dm.SymbanDataManager.Observer
{
    static abstract class MessageHelper
    {

        private static final String MESSAGE_DIALOG_FRAGMENT_TAG = "messageDialog";
        private boolean showWarnings;

        public final void setShowWarnings(boolean flag)
        {
            showWarnings = flag;
        }

        public final void showMessage(Activity activity, Fragment fragment, int i, ResultStatus resultstatus)
        {
            NautilusKernel.verifyMain();
            if (!((FwActivity)activity).isStateSaved()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Object obj1 = resultstatus.getFirstError();
            Object obj;
            com.ebay.nautilus.kernel.content.EbayContext ebaycontext;
            String s;
            boolean flag;
            int j;
            if (obj1 != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = obj1;
            if (obj1 == null)
            {
                obj = obj1;
                if (showWarnings)
                {
                    obj = resultstatus.getFirstWarning();
                }
            }
            if (obj == null) goto _L1; else goto _L3
_L3:
            ebaycontext = ((FwContext)activity).getEbayContext();
            s = ResultStatus.getSafeLongMessage(ebaycontext, ((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj)));
            obj1 = new Bundle();
            ((Bundle) (obj1)).putString("message", s);
            j = ((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj)).getId();
            if (j != 0)
            {
                ((Bundle) (obj1)).putInt("errorCode", j);
            }
            if (flag)
            {
                ((Bundle) (obj1)).putBoolean("isError", true);
            }
            if (i >= 0)
            {
                ((Bundle) (obj1)).putInt("id", i);
            }
            if (resultstatus.canRetry())
            {
                ((Bundle) (obj1)).putBoolean("allowRetry", true);
            }
            if (!((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj)).isLongMessageHtml(ebaycontext) && showMessageAsBar(((com.ebay.nautilus.kernel.content.ResultStatus.Message) (obj))))
            {
                ((Bundle) (obj1)).putBoolean("asMessageBar", true);
            }
            if (fragment != null)
            {
                activity = fragment.getFragmentManager();
            } else
            {
                activity = activity.getFragmentManager();
            }
            resultstatus = activity.findFragmentByTag("messageDialog");
            if (!(resultstatus instanceof DialogFragment)) goto _L5; else goto _L4
_L4:
            ((DialogFragment)resultstatus).dismiss();
_L7:
            resultstatus = activity.beginTransaction();
            resultstatus.addToBackStack(null);
            obj = new ErrorDialogFragment();
            ((ErrorDialogFragment) (obj)).setArguments(((Bundle) (obj1)));
            if (fragment != null)
            {
                ((ErrorDialogFragment) (obj)).setTargetFragment(fragment, 0);
            }
            ((ErrorDialogFragment) (obj)).show(resultstatus, "messageDialog");
            activity.executePendingTransactions();
            return;
_L5:
            if (resultstatus != null)
            {
                activity.beginTransaction().remove(resultstatus).commit();
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        protected abstract boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message);

        MessageHelper()
        {
        }
    }


    protected ActionBarDrawerToggle drawerToggle;
    private AppCompatDelegate mDelegate;
    private final MessageHelper messageHelper = new MessageHelper() {

        final CoreActivity this$0;

        protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
        {
            return CoreActivity.this.showMessageAsBar(message);
        }

            
            {
                this$0 = CoreActivity.this;
                super();
            }
    };
    private SymbanDataManager symbanDm;

    public CoreActivity()
    {
    }

    static void setActionBar(ActionBar actionbar, boolean flag, boolean flag1)
    {
        actionbar.setHomeButtonEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(false);
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setDisplayShowCustomEnabled(flag);
        actionbar.setDisplayUseLogoEnabled(flag1);
    }

    static ActionBarDrawerToggle setupDrawerToggle(Activity activity, DrawerLayout drawerlayout)
    {
        Toolbar toolbar = (Toolbar)activity.findViewById(0x7f10016e);
        if (toolbar != null)
        {
            toolbar.findViewById(0x7f10016f).setOnClickListener(new android.view.View.OnClickListener(drawerlayout) {

                final DrawerLayout val$drawer;

                public void onClick(View view)
                {
                    drawer.openDrawer(3);
                }

            
            {
                drawer = drawerlayout;
                super();
            }
            });
        }
        return new ActionBarDrawerToggle(activity, drawerlayout, toolbar, 0x7f07073c, 0x7f07023e, activity) {

            final Activity val$a;

            public void onDrawerOpened(View view)
            {
                super.onDrawerOpened(view);
                if (a instanceof TrackingSupport)
                {
                    view = ((TrackingSupport)a).getTrackingEventName();
                    TrackingData trackingdata = new TrackingData("Menu", TrackingType.EVENT);
                    if (view != null)
                    {
                        trackingdata.addSourceIdentification(new SourceIdentification(view));
                    }
                    trackingdata.send(a);
                }
            }

            public void onDrawerSlide(View view, float f)
            {
                super.onDrawerSlide(view, f);
                a.findViewById(0x7f10016d).setTranslationX((float)view.getWidth() * f);
            }

            public void onDrawerStateChanged(int i)
            {
                super.onDrawerStateChanged(i);
            }

            
            {
                a = activity1;
                super(activity, drawerlayout, toolbar, i, j);
            }
        };
    }

    static void setupNavigationMenuButtonBadge(Activity activity, int i)
    {
        TextView textview = (TextView)activity.findViewById(0x7f100170);
        if (textview != null && i > 0)
        {
            textview.setText(Util.countAsString(activity, i));
            textview.setVisibility(0);
        } else
        if (textview != null)
        {
            textview.setVisibility(4);
            return;
        }
    }

    static void setupToolbar(Activity activity, AppCompatDelegate appcompatdelegate, DrawerLayout drawerlayout, ActionBarDrawerToggle actionbardrawertoggle, boolean flag, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        Toolbar toolbar = (Toolbar)activity.findViewById(0x7f10016e);
        if (toolbar != null && drawerlayout != null)
        {
            drawerlayout.setDrawerListener(actionbardrawertoggle);
            appcompatdelegate.setSupportActionBar(toolbar);
            setActionBar(appcompatdelegate.getSupportActionBar(), true, false);
        }
        if (flag && toolbar != null)
        {
            activity.findViewById(0x7f100171).setOnClickListener(onclicklistener);
        }
        if (onclicklistener1 != null)
        {
            activity = (Button)activity.findViewById(0x7f100172);
            if (activity != null)
            {
                activity.setVisibility(0);
                activity.setOnClickListener(onclicklistener1);
            }
        }
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

            final CoreActivity this$0;

            public void onClick(View view)
            {
                view = new Intent(CoreActivity.this, com/ebay/mobile/search/MainSearchActivity);
                startActivity(view);
            }

            
            {
                this$0 = CoreActivity.this;
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
        AppCompatDelegate appcompatdelegate = getDelegate();
        appcompatdelegate.onPostCreate(bundle);
        bundle = getNavigationDrawer();
        drawerToggle = setupDrawerToggle(this, bundle);
        setupToolbar(this, appcompatdelegate, bundle, drawerToggle, showSearchInToolbar(), getSearchViewClickListener(), getFollowButtonClickListener());
    }

    protected void onPostResume()
    {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskstackbuilder)
    {
    }

    protected void onResume()
    {
        super.onResume();
        SymbanDataManager symbandatamanager = getSymbanDm();
        Integer integer = null;
        if (symbandatamanager != null)
        {
            integer = getSymbanDm().getCountIfExists();
        }
        int i;
        if (integer != null)
        {
            i = integer.intValue();
        } else
        {
            i = 0;
        }
        setupNavigationMenuButtonBadge(this, i);
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
        setupNavigationMenuButtonBadge(this, i);
    }

    public void onSymbanListChanged(SymbanDataManager symbandatamanager, Content content)
    {
        if (ResultStatus.SUCCESS.equals(content.getStatus()))
        {
            setupNavigationMenuButtonBadge(this, ((List)content.getData()).size());
            return;
        } else
        {
            setupNavigationMenuButtonBadge(this, 0);
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
        setupNavigationMenuButtonBadge(this, i);
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
            Object obj = getLayoutInflater();
            ViewGroup viewgroup;
            if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Search.B.boxShaded))
            {
                obj = ((LayoutInflater) (obj)).inflate(0x7f03008c, null);
            } else
            {
                obj = ((LayoutInflater) (obj)).inflate(0x7f03008b, null);
            }
            viewgroup = (ViewGroup)((View) (obj)).findViewById(0x7f100173);
            viewgroup.removeAllViews();
            viewgroup.addView(view);
            getDelegate().setContentView(((View) (obj)));
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

    public final void showMessage(int i, ResultStatus resultstatus)
    {
        showMessage(null, i, resultstatus);
    }

    public void showMessage(Fragment fragment, int i, ResultStatus resultstatus)
    {
        messageHelper.showMessage(this, fragment, i, resultstatus);
    }

    protected boolean showMessageAsBar(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return "network".equals(message.getCategory());
    }

    public boolean showSearchInToolbar()
    {
        return true;
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
