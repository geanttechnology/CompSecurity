// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.di.BeanFactory;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.ftue.FixedViewPager;
import com.amazon.gallery.framework.gallery.ftue.PagedFragmentActivity;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.ftue.AccountDetailsListener;
import com.amazon.gallery.framework.kindle.ftue.ContactInfoListener;
import com.amazon.gallery.framework.kindle.ftue.FTUEAddPhotosFragment;
import com.amazon.gallery.framework.kindle.ftue.FTUEScreen;
import com.amazon.gallery.framework.kindle.metrics.customer.AddPhotosMetrics;
import com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;
import com.amazon.gallery.framework.kindle.util.KindleSearch;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.AccountDetails;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            AdLaunchHelper, LaunchSourceMetrics

public class FTUEFragmentActivity extends PagedFragmentActivity
    implements AccountChangeListener
{

    private static final String TAG = com/amazon/gallery/framework/kindle/activity/FTUEFragmentActivity.getName();
    protected final Set accountDetailsListeners = new HashSet();
    private AddPhotosMetrics addPhotosProfiler;
    private Future contactInfoFuture;
    protected Set contactInfoListeners;
    private DialogManager dialogManager;
    protected Endpoint endpoint;
    private FTUEMetrics ftueProfiler;
    private final Runnable hideNotificationBarRunnable = new Runnable() {

        final FTUEFragmentActivity this$0;

        public void run()
        {
            notificationBarAnimator.hide();
        }

            
            {
                this$0 = FTUEFragmentActivity.this;
                super();
            }
    };
    private boolean instant;
    protected NetworkConnectivity networkConnectivity;
    private View notificationBar;
    private final VisibilityAnimator notificationBarAnimator = new VisibilityAnimator() {

        final FTUEFragmentActivity this$0;

        protected long getDuration()
        {
            return !instant ? 375L : 0L;
        }

        protected ObjectAnimator getHideAnimator()
        {
            float f1 = notificationBar.getHeight();
            float f = f1;
            if (f1 == 0.0F)
            {
                notificationBar.measure(0, 0);
                f = notificationBar.getMeasuredHeight();
            }
            View view = notificationBar;
            if (f != 0.0F)
            {
                f = -f;
            } else
            {
                f = -100F;
            }
            return ObjectAnimator.ofFloat(view, "translationY", new float[] {
                f
            });
        }

        protected volatile ValueAnimator getHideAnimator()
        {
            return getHideAnimator();
        }

        protected ObjectAnimator getShowAnimator()
        {
            scheduleNotificationBarDismissal();
            return ObjectAnimator.ofFloat(notificationBar, "translationY", new float[] {
                0.0F
            });
        }

        protected volatile ValueAnimator getShowAnimator()
        {
            return getShowAnimator();
        }

        protected void onShown()
        {
            notificationBar.postDelayed(hideNotificationBarRunnable, 5000L);
        }

            
            {
                this$0 = FTUEFragmentActivity.this;
                super();
            }
    };
    protected final ArrayList orderedFragments = new ArrayList();
    protected RestClient restClient;
    protected boolean returnedFromRegistration;

    public FTUEFragmentActivity()
    {
        super(new BeanFactory() {

        });
        instant = false;
        contactInfoListeners = new HashSet();
        returnedFromRegistration = false;
    }

    private void clearAllAccountCaches()
    {
        clearContactInfo();
        clearEndpoint();
        clearAccountDetails();
    }

    private void clearContactInfo()
    {
        contactInfoFuture = null;
        for (Iterator iterator = contactInfoListeners.iterator(); iterator.hasNext(); ((ContactInfoListener)iterator.next()).setContactInfo(null)) { }
    }

    private void clearEndpoint()
    {
        endpoint = null;
        restClient.getEndpointManager().removeEndpoint();
    }

    private void finishAddPhotos()
    {
        postFinish();
        setResult(-1, getResult());
        finish();
    }

    private Intent getResult()
    {
        Intent intent = new Intent();
        Object obj = (TextView)notificationBar.findViewById(0x7f0c015c);
        if (obj != null)
        {
            obj = ((TextView) (obj)).getText();
            if (obj != null && ((CharSequence) (obj)).length() != 0)
            {
                intent.putExtra("ftue_notification_key", ((CharSequence) (obj)).toString());
            }
        }
        return intent;
    }

    private void postFinish()
    {
        if (AdLaunchHelper.isAdLaunch(getIntent()))
        {
            startActivity(new Intent("com.amazon.photos.LAUNCH_PHOTOS"));
        }
    }

    private void scheduleNotificationBarDismissal()
    {
        this;
        JVM INSTR monitorenter ;
        notificationBar.removeCallbacks(hideNotificationBarRunnable);
        notificationBar.postDelayed(hideNotificationBarRunnable, 3000L);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public List addFragments()
    {
        return null;
    }

    protected void clearAccountDetails()
    {
        notifyAccountDetailsListeners(null);
    }

    public void finishFlow()
    {
        getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putBoolean(getStartedFtueFlag(), true).apply();
        postFinish();
        setResult(1, getResult());
        finish();
    }

    public ContactInfo getContactDetailsBlocking()
    {
        ContactInfo contactinfo;
        if (contactInfoFuture == null)
        {
            updateContactDetails();
        }
        contactinfo = (ContactInfo)contactInfoFuture.get();
        return contactinfo;
        Object obj;
        obj;
        GLogger.wx(TAG, "InterruptedException - ", ((Throwable) (obj)));
_L2:
        return null;
        obj;
        GLogger.wx(TAG, "ExecutionException - ", ((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public DialogManager getDialogManager()
    {
        return dialogManager;
    }

    public Endpoint getEndpoint()
    {
        return endpoint;
    }

    public ComponentProfiler getProfiler()
    {
        if (isAddPhotosMode())
        {
            return addPhotosProfiler;
        } else
        {
            return ftueProfiler;
        }
    }

    protected int getStartPageIndex()
    {
        return 0;
    }

    public String getStartedFtueFlag()
    {
        if (isAccountRegistered())
        {
            return "started_ftue_flag";
        } else
        {
            return "unregistered_started_ftue_flag";
        }
    }

    public void hideNotifications()
    {
        notificationBarAnimator.hide();
    }

    public boolean isAccountRegistered()
    {
        return ((AuthenticationManager)getApplicationBean(Keys.AUTHENTICATING_MANAGER)).hasActiveAccount();
    }

    public boolean isAddPhotosMode()
    {
        return getIntent().getBooleanExtra("START_AT_END", false);
    }

    protected void launchRegisterSettingsPage()
    {
        this;
        JVM INSTR monitorenter ;
        startActivityForResult(new Intent("com.amazon.dcp.sso.AddAccount"), 974);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void moveToNext()
    {
        int i = viewPager.getCurrentItem() + 1;
        if (i == fragments.size())
        {
            finishFlow();
            return;
        } else
        {
            viewPager.setCurrentItem(i, true);
            showScreenEvent(i);
            return;
        }
    }

    public void moveToSpecific(int i, boolean flag, boolean flag1)
    {
        super.moveToSpecific(i, flag, flag1);
        showScreenEvent(i);
    }

    protected void notifyAccountDetailsListeners(AccountDetails accountdetails)
    {
        for (Iterator iterator = accountDetailsListeners.iterator(); iterator.hasNext(); ((AccountDetailsListener)iterator.next()).onAccountDetailsReceived(accountdetails)) { }
    }

    public void onAccountDeregistered()
    {
        clearAllAccountCaches();
    }

    public void onAccountRegistered()
    {
        clearAllAccountCaches();
        updateContactDetails();
    }

    public void onBackPressed()
    {
        if (isAddPhotosMode())
        {
            if (!AdLaunchHelper.isAdLaunch(getIntent()))
            {
                if (viewPager.getCurrentItem() != 0)
                {
                    proceedToNext((Fragment)fragments.get(viewPager.getCurrentItem()), false);
                    return;
                }
                if (((FTUEAddPhotosFragment)fragments.get(viewPager.getCurrentItem())).isInUSBMode())
                {
                    ((FTUEAddPhotosFragment)fragments.get(viewPager.getCurrentItem())).usbInstructionsMode(false);
                    return;
                }
            }
        } else
        if (viewPager.getCurrentItem() != 0)
        {
            moveToSpecific(viewPager.getCurrentItem() - 1, false, true);
            return;
        }
        setResult(2);
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        restClient = (RestClient)getApplicationBean(Keys.REST_CLIENT);
        networkConnectivity = (NetworkConnectivity)getApplicationBean(Keys.NETWORK_CONNECTIVITY);
        setContentView(0x7f0300c3);
        fragments = addFragments();
        notificationBar = findViewById(0x7f0c01a0);
        notificationBarAnimator.setView(notificationBar);
        dialogManager = new DialogManager();
        bundle = (Profiler)getApplicationBean(Keys.PROFILER);
        ftueProfiler = new FTUEMetrics(bundle);
        addPhotosProfiler = new AddPhotosMetrics(bundle);
        instant = true;
        hideNotifications();
        instant = false;
        bundle = (FixedViewPager)findViewById(0x7f0c01ad);
        setViewPager(bundle);
        bundle.setOnTouchListener(this);
        if (!isAddPhotosMode())
        {
            getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.StartFTUE, CustomerMetricsHelper.getExtraDateTime(System.currentTimeMillis()));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuinflater = getMenuInflater();
        if (DebugAssert.isDebugBuild)
        {
            menuinflater.inflate(0x7f10000d, menu);
            return true;
        } else
        {
            return false;
        }
    }

    protected void onDestroy()
    {
        if (!isAddPhotosMode())
        {
            getProfiler().trackEvent(com.amazon.gallery.framework.kindle.metrics.customer.FTUEMetrics.MetricsEvent.EndFTUE, CustomerMetricsHelper.getExtraDateTime(System.currentTimeMillis()));
        }
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0c0276)
        {
            viewPager.toggleSwipe();
            return true;
        } else
        {
            return false;
        }
    }

    public void onPause()
    {
        super.onPause();
        dialogManager.dismissActiveAndPendingDialogs();
        if (isAddPhotosMode())
        {
            return;
        } else
        {
            getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putInt("last_ftue_position", viewPager.getCurrentItem()).apply();
            getApplicationBeanFactory().putBean(Keys.CURRENT_FTUE_ACTIVITY, null);
            return;
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        MenuItem menuitem = menu.findItem(0x7f0c0276);
        if (viewPager.isSwipeEnabled())
        {
            menu = "Debug: Disable Swipe";
        } else
        {
            menu = "Debug: Enable Swipe";
        }
        menuitem.setTitle(menu);
        return true;
    }

    public void onResume()
    {
        Object obj;
        super.onResume();
        clearContactInfo();
        if (networkConnectivity.isNetworkConnected())
        {
            updateContactDetails();
        }
        obj = getIntent();
        if (AdLaunchHelper.isAdLaunch(((Intent) (obj))))
        {
            AdLaunchHelper.process(((Intent) (obj)));
            AdLaunchHelper.logLaunchMetric((LaunchSourceMetrics)getApplicationBean(Keys.LAUNCH_SOURCE_PROFILER), ((Intent) (obj)));
        }
        if (!((Intent) (obj)).hasExtra("single_page_index")) goto _L2; else goto _L1
_L1:
        int i = ((Intent) (obj)).getIntExtra("single_page_index", 0);
        if (i > 0 && i < fragments.size())
        {
            viewPager.setCurrentItem(i);
        }
_L4:
        getApplicationBeanFactory().putBean(Keys.CURRENT_FTUE_ACTIVITY, this);
        return;
_L2:
        if (((Intent) (obj)).hasExtra("fragment_class_name"))
        {
            try
            {
                obj = Class.forName(((Intent) (obj)).getStringExtra("fragment_class_name"));
                viewPager.setCurrentItem(getPositionForFragment(((Class) (obj))));
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                GLogger.ex(TAG, "Couldn't find FTUE fragment class for name", classnotfoundexception);
            }
        } else
        if (!isAddPhotosMode())
        {
            int j = 0;
            if (!AdLaunchHelper.isAdLaunch(getIntent()))
            {
                j = getSharedPreferences("galleryKindleSharedPrefs", 0).getInt("last_ftue_position", -1);
            }
            getSharedPreferences("galleryKindleSharedPrefs", 0).edit().remove("last_ftue_position").apply();
            if (j > 0 && j < fragments.size())
            {
                viewPager.setCurrentItem(j);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onSearchRequested()
    {
        return KindleSearch.launchSearch(this);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        View view1 = view.findViewById(0x7f0c016c);
        if (view1 != null)
        {
            ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view1.getWindowToken(), 0);
        }
        return super.onTouch(view, motionevent);
    }

    public void proceedToNext(Fragment fragment, boolean flag)
    {
        if (!isAccountRegistered())
        {
            launchRegisterSettingsPage();
            return;
        }
        if (flag && isAddPhotosMode() || getIntent().hasExtra("single_page_index") || getIntent().hasExtra("fragment_class_name"))
        {
            finishAddPhotos();
            return;
        } else
        {
            super.proceedToNext(fragment, flag);
            return;
        }
    }

    public void setNotification(String s)
    {
        notificationBar.removeCallbacks(hideNotificationBarRunnable);
        ((TextView)notificationBar.findViewById(0x7f0c015c)).setText(s);
        notificationBar.findViewById(0x7f0c015c).setVisibility(0);
        notificationBar.findViewById(0x7f0c015b).setVisibility(8);
        if (!isAddPhotosMode())
        {
            notificationBarAnimator.show();
        }
    }

    public void showErrorNotification(String s)
    {
        notificationBar.removeCallbacks(hideNotificationBarRunnable);
        ((TextView)notificationBar.findViewById(0x7f0c015b)).setText(s);
        notificationBar.findViewById(0x7f0c015c).setVisibility(8);
        notificationBar.findViewById(0x7f0c015b).setVisibility(0);
        notificationBarAnimator.show();
    }

    protected void showScreenEvent(int i)
    {
        if (fragments.get(i) instanceof FTUEScreen)
        {
            ((FTUEScreen)fragments.get(i)).onShowView(this);
        }
    }

    public void updateContactDetails()
    {
        com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler resulthandler = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final FTUEFragmentActivity this$0;

            public void onFailure(TerminalException terminalexception1)
            {
            }

            public void onSuccess(ContactInfo contactinfo)
            {
                for (Iterator iterator = contactInfoListeners.iterator(); iterator.hasNext(); ((ContactInfoListener)iterator.next()).setContactInfo(contactinfo)) { }
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((ContactInfo)obj);
            }

            
            {
                this$0 = FTUEFragmentActivity.this;
                super();
            }
        };
        if (contactInfoFuture == null || !contactInfoFuture.isDone() || resulthandler == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        resulthandler.onSuccess(getContactDetailsBlocking());
        if (isAccountRegistered())
        {
            com.amazon.gallery.framework.network.http.rest.RestClient.Operation operation = restClient.getContactInfo();
            contactInfoFuture = NetworkExecutor.getInstance().executeForeground(operation, resulthandler);
        }
        return;
        TerminalException terminalexception;
        terminalexception;
        GLogger.ex(TAG, "Failed to get contact info", terminalexception);
        return;
    }






}
