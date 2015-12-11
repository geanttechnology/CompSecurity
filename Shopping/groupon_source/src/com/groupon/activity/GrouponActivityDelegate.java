// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.events.activity.OnDestroyEvent;
import com.groupon.events.activity.OnResumeEvent;
import com.groupon.goods.shoppingcart.model.CartIconClickExtraInfo;
import com.groupon.models.nst.CollectionCard;
import com.groupon.models.nst.CollectionCardExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.ConfigurationChangedService;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CacheUtils;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.SecretAdminSettingsMenuHelper;
import com.groupon.util.Tracking;
import com.squareup.otto.Bus;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractActivityDelegate, Purchase, EditCreditCard, DeliveryAddresses, 
//            DontRestartOnConfigurationChange, IntentFactory

public class GrouponActivityDelegate extends AbstractActivityDelegate
{

    public static final String COLLECTION_CARD_DETAILS = "collectionCardDetails";
    private AbTestService abTestService;
    private Activity activity;
    private Bus bus;
    private NewCartAbTestHelper cartAbTestHelper;
    private Context context;
    private Lazy intentFactory;
    private boolean isReportABugUSCA1409;
    private Logger logger;
    private SecretAdminSettingsMenuHelper menuHelper;
    private SharedPreferences prefs;
    private HashSet restoredConfiguration;
    private final Lazy shoppingCartService;
    private Tracking tracking;

    public GrouponActivityDelegate(Context context1)
    {
        restoredConfiguration = null;
        intentFactory = new Lazy(context1) {

            final GrouponActivityDelegate this$0;

            
            {
                this$0 = GrouponActivityDelegate.this;
                super(context1);
            }
        };
        shoppingCartService = new Lazy(context1) {

            final GrouponActivityDelegate this$0;

            
            {
                this$0 = GrouponActivityDelegate.this;
                super(context1);
            }
        };
        context = context1;
    }

    public static void onPreCreate(Activity activity1)
    {
        Field field;
        try
        {
            activity1 = ViewConfiguration.get(activity1.getApplicationContext());
            field = android/view/ViewConfiguration.getDeclaredField("sHasPermanentMenuKey");
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity1)
        {
            return;
        }
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        field.setAccessible(true);
        field.setBoolean(activity1, false);
    }

    public static boolean startDeepLinkedUpButtonIntent(Activity activity1, Intent intent)
    {
        if (intent != null)
        {
            intent.setFlags(intent.getFlags() | 0x10000000 | 0x8000);
            activity1.startActivity(intent);
            return true;
        } else
        {
            return false;
        }
    }

    protected void addStandaloneShoppingCartIcon(ActionBar actionbar, boolean flag)
    {
        if (cartAbTestHelper.isShoppingCartEnabled() && flag)
        {
            ActionBarUtil.setCustomView(actionbar, 0x7f0301f8);
            configureShoppingCartIcon(actionbar);
        }
    }

    protected void configureShoppingCartIcon(ActionBar actionbar)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            configureShoppingCartIcon(actionbar.findViewById(0x7f10023a), null);
        }
    }

    protected void configureShoppingCartIcon(Toolbar toolbar)
    {
        configureShoppingCartIcon(toolbar.findViewById(0x7f10023a), null);
    }

    protected void configureShoppingCartIcon(View view, final android.view.View.OnClickListener carouselShoppingCartClickCallback)
    {
label0:
        {
label1:
            {
                if (view != null)
                {
                    if (!cartAbTestHelper.isShoppingCartEnabled())
                    {
                        break label0;
                    }
                    view.setVisibility(0);
                    view.setOnClickListener(new android.view.View.OnClickListener() {

                        final GrouponActivityDelegate this$0;
                        final android.view.View.OnClickListener val$carouselShoppingCartClickCallback;

                        public void onClick(View view1)
                        {
                            CartIconClickExtraInfo carticonclickextrainfo = new CartIconClickExtraInfo();
                            carticonclickextrainfo.cartSize = ((ShoppingCartService)shoppingCartService.get()).getCartItemsCount();
                            logger.logClick("", "cart", context.getClass().getSimpleName(), Logger.NULL_NST_FIELD, carticonclickextrainfo);
                            activity.startActivity(((ShoppingCartService)shoppingCartService.get()).getOpenCartIntent());
                            if (carouselShoppingCartClickCallback != null)
                            {
                                carouselShoppingCartClickCallback.onClick(view1);
                            }
                        }

            
            {
                this$0 = GrouponActivityDelegate.this;
                carouselShoppingCartClickCallback = onclicklistener;
                super();
            }
                    });
                    logFirstImpression();
                    if (!((ShoppingCartService)shoppingCartService.get()).getCartInAppMessageViewed())
                    {
                        break label1;
                    }
                    ActionBarUtil.updateShoppingCartCounter(view, ((ShoppingCartService)shoppingCartService.get()).getCartItemsCount());
                }
                return;
            }
            ActionBarUtil.showShoppingCartNewBadge(view);
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(null);
    }

    protected void configureShoppingCartIconWithIndicator(ActionBar actionbar, android.view.View.OnClickListener onclicklistener)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            configureShoppingCartIconWithIndicator(actionbar.findViewById(0x7f10051e), onclicklistener);
        }
    }

    protected void configureShoppingCartIconWithIndicator(Toolbar toolbar, android.view.View.OnClickListener onclicklistener)
    {
        configureShoppingCartIconWithIndicator(toolbar.findViewById(0x7f10051e), onclicklistener);
    }

    protected void configureShoppingCartIconWithIndicator(View view, android.view.View.OnClickListener onclicklistener)
    {
label0:
        {
            if (view != null)
            {
                View view1 = view.findViewById(0x7f10023a);
                configureShoppingCartIcon(view1, onclicklistener);
                if (!cartAbTestHelper.isShoppingCartEnabled() || !isShoppingCartVisible(view1))
                {
                    break label0;
                }
                view.setVisibility(0);
            }
            return;
        }
        view.setVisibility(8);
    }

    public View getDialogCustomView(String s)
    {
        if (Strings.equals(s, "report_a_bug_dialog"))
        {
            s = new ListView(activity);
            s.setAdapter(new SimpleAdapter(activity, getTitleSubTitlePairs(), 0x7f030046, new String[] {
                "key_title", "key_sub_title"
            }, new int[] {
                0x7f10007a, 0x7f10011a
            }));
            s.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final GrouponActivityDelegate this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    view = (GrouponDialogFragment)activity.getFragmentManager().findFragmentByTag("report_a_bug_dialog");
                    if (view != null)
                    {
                        adapterview = view.getArguments().getString("dialog_screen_shot");
                        Activity activity1 = activity;
                        if (i == 0)
                        {
                            adapterview = ((IntentFactory)intentFactory.get()).newCustomerServiceIntent();
                        } else
                        {
                            adapterview = ((IntentFactory)intentFactory.get()).newBugReportIntent(activity.getClass().getSimpleName(), adapterview);
                        }
                        activity1.startActivity(adapterview);
                        view.dismiss();
                    }
                }

            
            {
                this$0 = GrouponActivityDelegate.this;
                super();
            }
            });
            return s;
        } else
        {
            return null;
        }
    }

    protected String getPageViewId()
    {
        return activity.getClass().getSimpleName();
    }

    protected File getScreenShot()
    {
        Bitmap bitmap = null;
        Object obj = bitmap;
        if (activity instanceof Purchase)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = bitmap;
        if (activity instanceof EditCreditCard)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = bitmap;
        if (activity instanceof DeliveryAddresses)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        Object obj1;
        Bitmap bitmap1;
        int i;
        boolean flag;
        try
        {
            obj1 = activity.findViewById(0x1020002).getRootView();
            flag = ((View) (obj1)).isDrawingCacheEnabled();
            ((View) (obj1)).setDrawingCacheEnabled(true);
            bitmap1 = ((View) (obj1)).getDrawingCache();
        }
        catch (Exception exception)
        {
            Ln.e(exception, "Report a Bug Problem", new Object[0]);
            return null;
        }
        obj = bitmap;
        if (bitmap1 == null)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        obj = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(((Rect) (obj)));
        i = ((Rect) (obj)).top;
        bitmap = Bitmap.createBitmap(bitmap1, 0, i, bitmap1.getWidth(), bitmap1.getHeight() - i);
        ((View) (obj1)).setDrawingCacheEnabled(flag);
        obj = File.createTempFile("screenshot", ".jpg", CacheUtils.getScreenshotCacheDir(activity.getApplicationContext()));
        obj1 = new FileOutputStream(((File) (obj)));
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 20, ((java.io.OutputStream) (obj1)));
        return ((File) (obj));
    }

    public List getTitleSubTitlePairs()
    {
        Resources resources = context.getResources();
        String as[] = resources.getStringArray(0x7f0f000f);
        String as1[] = resources.getStringArray(0x7f0f0010);
        ArrayList arraylist = new ArrayList(as.length);
        for (int i = 0; i < as.length; i++)
        {
            HashMap hashmap = new HashMap(2);
            hashmap.put("key_title", as[i]);
            hashmap.put("key_sub_title", as1[i]);
            arraylist.add(hashmap);
        }

        return arraylist;
    }

    protected boolean isShoppingCartIconVisible(ActionBar actionbar)
    {
        boolean flag1 = false;
        actionbar = actionbar.getCustomView();
        boolean flag = flag1;
        if (actionbar != null)
        {
            actionbar = actionbar.findViewById(0x7f10023a);
            flag = flag1;
            if (actionbar != null)
            {
                flag = flag1;
                if (actionbar.getVisibility() == 0)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    protected boolean isShoppingCartVisible(ActionBar actionbar)
    {
        actionbar = actionbar.getCustomView();
        if (actionbar != null)
        {
            View view = actionbar.findViewById(0x7f10051e);
            if (view != null)
            {
                actionbar = view.findViewById(0x7f10023a);
            } else
            {
                actionbar = actionbar.findViewById(0x7f10023a);
            }
            return isShoppingCartVisible(((View) (actionbar)));
        } else
        {
            return false;
        }
    }

    protected boolean isShoppingCartVisible(Toolbar toolbar)
    {
        View view = toolbar.findViewById(0x7f10051e);
        if (view != null)
        {
            toolbar = view.findViewById(0x7f10023a);
        } else
        {
            toolbar = toolbar.findViewById(0x7f10023a);
        }
        return isShoppingCartVisible(((View) (toolbar)));
    }

    protected boolean isShoppingCartVisible(View view)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (view != null)
        {
            flag = flag1;
            if (view.getVisibility() == 0)
            {
                flag = true;
            }
        }
        return flag;
    }

    protected void logFirstImpression()
    {
        if (!activity.getIntent().getBooleanExtra("isLogged", false))
        {
            String s = ((ShoppingCartService)shoppingCartService.get()).getLastCachedCartUuid();
            int i = ((ShoppingCartService)shoppingCartService.get()).getCartItemsCount();
            logger.logImpression("", "cart", logger.encodeAsCSV(new String[] {
                s, String.valueOf(i)
            }), activity.getClass().getSimpleName(), JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            activity.getIntent().putExtra("isLogged", true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menuHelper.createMenu(menu, activity);
        isReportABugUSCA1409 = abTestService.isVariantEnabledAndUSCA("reportABug1409USCA", "on");
        if (prefs.getBoolean("pref_key_report_a_bug", false) && isReportABugUSCA1409)
        {
            menu.add(0, 0x7f10001b, 0, activity.getResources().getString(0x7f08031b)).setIcon(0x7f0201f3).setShowAsAction(1);
        }
        return true;
    }

    protected void onDestroy()
    {
        Ln.d("onDestroy %s", new Object[] {
            activity
        });
        bus.post(new OnDestroyEvent(activity));
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

    public void onPostCreate(Bundle bundle)
    {
        Ln.d("onCreate %s", new Object[] {
            activity
        });
        String s = activity.getClass().getSimpleName();
        logger.logGeneralEvent("android_events", "activity_on_create", s, 0, Logger.NULL_NST_FIELD);
        tracking.trackPageView(s);
        if (bundle != null)
        {
            restoredConfiguration = (HashSet)bundle.getSerializable("configuration");
            if (restoredConfiguration != null && Strings.equals(restoredConfiguration, ((ConfigurationChangedService)RoboGuice.getInjector(activity).getInstance(com/groupon/service/ConfigurationChangedService)).getInstanceState()))
            {
                restoredConfiguration = null;
            }
        }
    }

    protected void onPostResume(ActionBar actionbar)
    {
label0:
        {
            if (actionbar != null)
            {
                if (isShoppingCartIconVisible(actionbar))
                {
                    logFirstImpression();
                }
                if (!((ShoppingCartService)shoppingCartService.get()).getCartInAppMessageViewed())
                {
                    break label0;
                }
                ActionBarUtil.updateShoppingCartCounter(actionbar, ((ShoppingCartService)shoppingCartService.get()).getCartItemsCount());
            }
            return;
        }
        ActionBarUtil.showShoppingCartNewBadge(actionbar);
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
        boolean flag = true;
        if (activity instanceof CustomPageViewEvent)
        {
            ((CustomPageViewEvent)activity).logPageViewEvent();
            flag = false;
        }
        if (activity.getIntent().hasExtra("collectionCardDetails"))
        {
            logger.logPageView("", class1.getSimpleName(), new CollectionCardExtraInfo((CollectionCard)activity.getIntent().getParcelableExtra("collectionCardDetails")));
            flag = false;
        }
        if (flag)
        {
            logger.logPageView("", class1.getSimpleName(), Logger.NULL_NST_FIELD);
        }
        if (!(activity instanceof DontRestartOnConfigurationChange) && ((ConfigurationChangedService)RoboGuice.getInjector(activity).getInstance(com/groupon/service/ConfigurationChangedService)).hasConfigurationChanged(restoredConfiguration))
        {
            Ln.d("Reloading activity because of configuration change.", new Object[0]);
            activity.finish();
            Intent intent = activity.getIntent();
            intent.putExtra("restarted_due_to_configuration_change", true);
            activity.startActivity(((IntentFactory)intentFactory.get()).newSplashIntent(intent));
        }
        bus.post(new OnResumeEvent(activity));
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        Ln.d("onSaveInstanceState %s", new Object[] {
            activity
        });
        bundle.putSerializable("configuration", ((ConfigurationChangedService)RoboGuice.getInjector(activity).getInstance(com/groupon/service/ConfigurationChangedService)).getInstanceState());
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

    protected void reportABugDialog(FragmentManager fragmentmanager)
    {
        showReportABugDialog(fragmentmanager, getScreenShot());
    }

    protected void showReportABugDialog(FragmentManager fragmentmanager, File file)
    {
        if (fragmentmanager.findFragmentByTag("report_a_bug_dialog") != null)
        {
            return;
        }
        String s = context.getString(0x7f080222);
        if (file != null)
        {
            file = file.getName();
        } else
        {
            file = null;
        }
        GrouponDialogFragment.show(fragmentmanager, new GrouponDialogFragment(s, file), "report_a_bug_dialog");
    }





}
