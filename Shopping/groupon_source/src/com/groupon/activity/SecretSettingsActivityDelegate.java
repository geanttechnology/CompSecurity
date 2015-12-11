// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.ConfigurationChangedService;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.SecretAdminSettingsMenuHelper;
import com.groupon.util.SecretSettingsActionBarUtil;
import com.groupon.util.Tracking;
import java.util.HashSet;
import java.util.WeakHashMap;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractActivityDelegate, DontRestartOnConfigurationChange, IntentFactory

public class SecretSettingsActivityDelegate extends AbstractActivityDelegate
{

    private static WeakHashMap residentContexts = new WeakHashMap();
    private AbTestService abTestService;
    private Activity activity;
    private NewCartAbTestHelper cartAbTestHelper;
    private ConfigurationChangedService configurationChangedService;
    private IntentFactory intentFactory;
    private Logger logger;
    private SecretAdminSettingsMenuHelper menuHelper;
    private HashSet restoredConfiguration;
    private ShoppingCartService shoppingCartService;
    private Tracking tracking;

    public SecretSettingsActivityDelegate()
    {
        restoredConfiguration = null;
    }

    protected void addStandaloneShoppingCartIcon(ActionBar actionbar, boolean flag)
    {
        if (cartAbTestHelper.isShoppingCartEnabled() && flag)
        {
            SecretSettingsActionBarUtil.setCustomView(actionbar, 0x7f0301f8);
        }
    }

    protected void finalize()
        throws Throwable
    {
        super.finalize();
        if (!Ln.isVerboseEnabled())
        {
            break MISSING_BLOCK_LABEL_47;
        }
        com/groupon/activity/SecretSettingsActivityDelegate;
        JVM INSTR monitorenter ;
        Ln.v("Contexts: %s", new Object[] {
            Strings.join(", ", residentContexts.keySet())
        });
        com/groupon/activity/SecretSettingsActivityDelegate;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/groupon/activity/SecretSettingsActivityDelegate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected boolean layoutContainsShoppingCartIcon(ActionBar actionbar)
    {
        actionbar = actionbar.getCustomView();
        return actionbar != null && actionbar.findViewById(0x7f10023a) != null;
    }

    protected void logFirstImpression()
    {
        if (!activity.getIntent().getBooleanExtra("isLogged", false))
        {
            String s = shoppingCartService.getLastCachedCartUuid();
            int i = shoppingCartService.getCartItemsCount();
            logger.logImpression("", "cart", logger.encodeAsCSV(new String[] {
                s, String.valueOf(i)
            }), activity.getClass().getSimpleName(), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            activity.getIntent().putExtra("isLogged", true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menuHelper.createMenu(menu, activity);
        if (abTestService.isVariantEnabledAndUSCA("reportABug1409USCA", "on"))
        {
            menu.add(0, 0x7f10001b, 0, activity.getResources().getString(0x7f08031b));
        }
        return true;
    }

    protected void onDestroy()
    {
        Ln.d("onDestroy %s", new Object[] {
            activity
        });
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return menuHelper.handleMenuItem(activity, menuitem);

        case 16908332: 
            activity.onBackPressed();
            break;
        }
        return true;
    }

    protected void onPause()
    {
        Ln.d("onPause %s", new Object[] {
            activity
        });
        activity.getIntent().removeExtra("isLogged");
    }

    public void onPostCreate(Bundle bundle, ActionBar actionbar)
    {
        Ln.d("onCreate %s", new Object[] {
            activity
        });
        actionbar = activity.getClass().getSimpleName();
        logger.logGeneralEvent("android_events", "activity_on_create", actionbar, 0, Logger.NULL_NST_FIELD);
        tracking.trackPageView(actionbar);
        if (bundle != null)
        {
            restoredConfiguration = (HashSet)bundle.getSerializable("configuration");
            if (restoredConfiguration != null && Strings.equals(restoredConfiguration, configurationChangedService.getInstanceState()))
            {
                restoredConfiguration = null;
            }
        }
    }

    protected void onPostResume(ActionBar actionbar)
    {
        if (actionbar != null)
        {
            if (layoutContainsShoppingCartIcon(actionbar))
            {
                logFirstImpression();
            }
            SecretSettingsActionBarUtil.updateShoppingCartCounter(actionbar, shoppingCartService.getCartItemsCount());
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menuHelper.prepareMenu(menu, activity);
        return true;
    }

    protected void onResume()
    {
        Ln.d("onResume %s", new Object[] {
            activity
        });
        Class class1 = activity.getClass();
        logger.logPageView("", class1.getSimpleName(), Logger.NULL_NST_FIELD);
        if (!(activity instanceof DontRestartOnConfigurationChange) && configurationChangedService.hasConfigurationChanged(restoredConfiguration))
        {
            Ln.d("Reloading activity because of configuration change.", new Object[0]);
            activity.finish();
            activity.startActivity(intentFactory.newSplashIntent(activity.getIntent()));
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        Ln.d("onSaveInstanceState %s", new Object[] {
            activity
        });
        bundle.putSerializable("configuration", configurationChangedService.getInstanceState());
    }

    protected void onStart()
    {
        Ln.d("onStart %s", new Object[] {
            activity
        });
    }

    protected void onStop()
    {
        Ln.d("onStop %s", new Object[] {
            activity
        });
    }

}
