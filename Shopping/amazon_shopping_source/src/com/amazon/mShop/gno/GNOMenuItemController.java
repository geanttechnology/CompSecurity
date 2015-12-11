// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.clouddrive.CloudDriveAvailability;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.locale.LocaleController;
import com.amazon.mShop.control.locale.LocaleSwitchSubscriber;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.CollectionsUtil;
import com.amazon.mShop.util.MShopPushNotificationUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.NavMenuItem;
import com.amazon.rio.j2me.client.services.mShop.NavigationMenuRequest;
import com.amazon.rio.j2me.client.services.mShop.NavigationMenuResponse;
import com.amazon.rio.j2me.client.services.mShop.NavigationMenuResponseListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemProviderDefault, GNOMenuItemProviderDebug, GNODrawerItemSimple, GNODrawerItemAppstoreHeader, 
//            GNODrawerItemGroup, GNODrawerItemSubHeader, GNODrawerItemSubHeaderHideable, GNODrawerItemHideable, 
//            GNODrawer, GNOItemAdapter, GNODrawerItemSBD, GNOMenuItemProviderBase, 
//            GNOMenuItemProvider, GNODrawerItem, GNODebugSettingsActivity

public class GNOMenuItemController
{
    private abstract class CustomRunnable
    {

        final GNOMenuItemController this$0;

        public abstract void run(AmazonActivity amazonactivity);

        private CustomRunnable()
        {
            this$0 = GNOMenuItemController.this;
            super();
        }

    }


    private static final String PROVIDER_DEBUG = com/amazon/mShop/gno/GNOMenuItemProviderDebug.getSimpleName();
    private static final String PROVIDER_DEFAULT = com/amazon/mShop/gno/GNOMenuItemProviderDefault.getSimpleName();
    private static final String TAG = com/amazon/mShop/gno/GNOMenuItemController.getSimpleName();
    private static GNOMenuItemController sInstance;
    private Context mContext;
    private boolean mIsCallingMShopServer;
    private Map mItemProviders;
    private long mLastUpdateTime;
    private ServiceCall mServiceCall;

    private GNOMenuItemController(Context context)
    {
        mLastUpdateTime = 0xfffffffffad9a400L;
        mIsCallingMShopServer = false;
        mContext = context;
        mItemProviders = new HashMap();
        buildProviders(context);
    }

    private GNODrawerItem buildGNODrawerItem(Context context, NavMenuItem navmenuitem)
    {
        final String targetUrl;
        final Object target;
        boolean flag;
        Object obj = null;
        if (!isSupportedItem(navmenuitem))
        {
            return null;
        }
        targetUrl = navmenuitem.getTargetUrl();
        target = com.amazon.mShop.navigation.AppNavigator.Target.from(navmenuitem.getTarget());
        Object obj1;
        GNODrawerItem gnodraweritem;
        final boolean isIdContainingAIV;
        final boolean isAIVGateway;
        if (!Util.isEmpty(navmenuitem.getParentId()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isIdContainingAIV = navmenuitem.getItemId().contains("aiv");
        isAIVGateway = navmenuitem.getItemId().equals("mshop:aiv");
        if (!Util.isEmpty(targetUrl))
        {
            target = new CustomRunnable() {

                final GNOMenuItemController this$0;
                final boolean val$isAIVGateway;
                final boolean val$isIdContainingAIV;
                final String val$targetUrl;

                public void run(AmazonActivity amazonactivity)
                {
                    String s;
                    if (DebugSettings.isDebugEnabled())
                    {
                        String s1 = GNODebugSettingsActivity.getTargetUrlOverride(targetUrl);
                        s = s1;
                        if (GNODebugSettingsActivity.isUrlToastEnabled().booleanValue())
                        {
                            Toast.makeText(amazonactivity, s1, 0).show();
                            s = s1;
                        }
                    } else
                    {
                        s = targetUrl;
                    }
                    if (isIdContainingAIV)
                    {
                        if (isAIVGateway)
                        {
                            AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.aiv_gateway, Maps.of("url", targetUrl));
                            return;
                        } else
                        {
                            AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", s, "forceClearHistory", Boolean.valueOf(false)));
                            return;
                        }
                    } else
                    {
                        AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.webview, Maps.of("url", s));
                        return;
                    }
                }

            
            {
                this$0 = GNOMenuItemController.this;
                targetUrl = s;
                isIdContainingAIV = flag;
                isAIVGateway = flag1;
                super();
            }
            };
        } else
        if (target != null)
        {
            target = new CustomRunnable() {

                final GNOMenuItemController this$0;
                final com.amazon.mShop.navigation.AppNavigator.Target val$target;

                public void run(AmazonActivity amazonactivity)
                {
                    AppNavigator.navigate(amazonactivity, target);
                }

            
            {
                this$0 = GNOMenuItemController.this;
                target = target1;
                super();
            }
            };
        } else
        {
            target = null;
        }
        gnodraweritem = getCustomItem(navmenuitem.getItemId());
        obj1 = null;
        targetUrl = obj1;
        if (gnodraweritem != null)
        {
            targetUrl = obj1;
            if (gnodraweritem instanceof GNOItemAdapter.HideableItem)
            {
                targetUrl = ((GNOItemAdapter.HideableItem)gnodraweritem).getIsHiddenCallable();
            }
        }
        navmenuitem.getType();
        JVM INSTR tableswitch 0 3: default 160
    //                   0 349
    //                   1 243
    //                   2 302
    //                   3 234;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break MISSING_BLOCK_LABEL_349;
_L1:
        context = GNODrawerItemSimple.builder(context, navmenuitem.getItemId());
_L6:
        navmenuitem = context.withText(navmenuitem.getTitle()).withRefMarker(navmenuitem.getRefMarker());
        if (target == null)
        {
            context = obj;
        } else
        {
            context = new GNODrawerItemSimple.GNOItemOnClickListener() {

                final GNOMenuItemController this$0;
                final CustomRunnable val$onClickRunnable;

                public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
                {
                    onClickRunnable.run(amazonactivity);
                }

            
            {
                this$0 = GNOMenuItemController.this;
                onClickRunnable = customrunnable;
                super();
            }
            };
        }
        return navmenuitem.withListener(context).build();
_L5:
        return getCustomItem(navmenuitem.getItemId());
_L3:
        if ("mshop:appstore".equals(navmenuitem.getItemId()))
        {
            targetUrl = GNODrawerItemAppstoreHeader.builder(context, navmenuitem.getItemId()).withIsHiddenCallable(targetUrl);
        } else
        {
            targetUrl = GNODrawerItemGroup.builder(context, navmenuitem.getItemId()).withIsHiddenCallable(targetUrl);
        }
        context = targetUrl;
        if (flag)
        {
            context = targetUrl.withType(GNODrawerItem.Type.SUB_ITEM);
        }
          goto _L6
_L4:
        if (targetUrl == null)
        {
            targetUrl = GNODrawerItemSubHeader.builder(context, navmenuitem.getItemId());
        } else
        {
            targetUrl = GNODrawerItemSubHeaderHideable.builder(context, navmenuitem.getItemId()).withIsHiddenCallable(targetUrl);
        }
        context = targetUrl;
        if (flag)
        {
            context = targetUrl.withType(GNODrawerItem.Type.SUB_SUB_HEADER);
        }
          goto _L6
        if ("mshop:appstore/coins".equals(navmenuitem.getItemId()))
        {
            targetUrl = GNODrawerItemHideable.builder(context, navmenuitem.getItemId()).withIsHiddenCallable(GNODrawer.getGNOItemAdapter().createAppstoreCoinTabCallable());
        } else
        if ("mshop:shop_by_department".equals(navmenuitem.getItemId()))
        {
            targetUrl = GNODrawerItemSBD.builder(context, navmenuitem.getItemId());
        } else
        if (targetUrl == null)
        {
            targetUrl = GNODrawerItemSimple.builder(context, navmenuitem.getItemId());
        } else
        {
            targetUrl = GNODrawerItemHideable.builder(context, navmenuitem.getItemId()).withIsHiddenCallable(targetUrl);
        }
        context = targetUrl;
        if (flag)
        {
            context = targetUrl.withType(GNODrawerItem.Type.SUB_ITEM);
        }
          goto _L6
    }

    private void buildProviders(Context context)
    {
        mItemProviders.put(PROVIDER_DEFAULT, new GNOMenuItemProviderDefault(context));
        mItemProviders.put(PROVIDER_DEBUG, new GNOMenuItemProviderDebug(context));
        mItemProviders.put("GNOMenuItemProviderEmpty", new GNOMenuItemProviderBase());
    }

    private void fetchMenuItems(String s, final GNOItemAdapter itemAdapter)
    {
        mIsCallingMShopServer = true;
        NavigationMenuRequest navigationmenurequest = new NavigationMenuRequest();
        navigationmenurequest.setMenuId(s);
        s = new NavigationMenuResponseListener() {

            final GNOMenuItemController this$0;
            final GNOItemAdapter val$itemAdapter;

            public void cancelled(ServiceCall servicecall)
            {
                mIsCallingMShopServer = false;
                Log.e(GNOMenuItemController.TAG, "Failed to get menu items : call cancelled");
            }

            public void completed(NavigationMenuResponse navigationmenuresponse, ServiceCall servicecall)
            {
                mLastUpdateTime = SystemClock.elapsedRealtime();
                mIsCallingMShopServer = false;
                navigationmenuresponse = parseResponse(navigationmenuresponse);
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(navigationmenuresponse. new Runnable() {

                    final _cls2 this$1;
                    final Collection val$responseItems;

                    public void run()
                    {
                        if (!Util.isEmpty(responseItems))
                        {
                            Collection collection;
                            if (DebugSettings.isDebugEnabled())
                            {
                                collection = CollectionsUtil.sum(responseItems, getProvider(GNOMenuItemController.PROVIDER_DEBUG).getItems());
                            } else
                            {
                                collection = responseItems;
                            }
                            itemAdapter.setItems(collection);
                            Log.i(GNOMenuItemController.TAG, "updated menu");
                        }
                    }

            
            {
                this$1 = final__pcls2;
                responseItems = Collection.this;
                super();
            }
                });
            }

            public void error(Exception exception, ServiceCall servicecall)
            {
                mIsCallingMShopServer = false;
                Log.e(GNOMenuItemController.TAG, "Failed to get menu items", exception);
            }

            
            {
                this$0 = GNOMenuItemController.this;
                itemAdapter = gnoitemadapter;
                super();
            }
        };
        mServiceCall = ServiceController.getMShopService().navigationMenu(navigationmenurequest, s);
    }

    private static GNODrawerItem findDrawerItem(String s, Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext();)
        {
            GNODrawerItem gnodraweritem = ((GNOMenuItemProvider)collection.next()).getItem(s);
            if (gnodraweritem != null)
            {
                return gnodraweritem;
            }
        }

        return null;
    }

    private GNODrawerItem getCustomItem(String s)
    {
        return getProvider(PROVIDER_DEFAULT).getItem(s);
    }

    public static GNOMenuItemController getInstance()
    {
        return sInstance;
    }

    private GNOMenuItemProvider getProvider(String s)
    {
        GNOMenuItemProvider gnomenuitemprovider = (GNOMenuItemProvider)mItemProviders.get(s);
        s = gnomenuitemprovider;
        if (gnomenuitemprovider == null)
        {
            s = (GNOMenuItemProvider)mItemProviders.get("GNOMenuItemProviderEmpty");
        }
        return s;
    }

    public static void init(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new GNOMenuItemController(context);
        }
    }

    private boolean isSupportedItem(NavMenuItem navmenuitem)
    {
        if ("mshop:notifications".equals(navmenuitem.getItemId()))
        {
            return MShopPushNotificationUtils.isPushNotificationAvailable();
        }
        if ("mshop:cloud_drive".equals(navmenuitem.getItemId()))
        {
            return CloudDriveAvailability.getInstance().isCloudDriveAvailable();
        } else
        {
            return true;
        }
    }

    private Collection parseResponse(NavigationMenuResponse navigationmenuresponse)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        GNOMenuItemProviderBase gnomenuitemproviderbase1 = new GNOMenuItemProviderBase();
        linkedhashmap.put("mshop", gnomenuitemproviderbase1);
        Iterator iterator = navigationmenuresponse.getMenuItems().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            navigationmenuresponse = (NavMenuItem)iterator.next();
            GNODrawerItem gnodraweritem = buildGNODrawerItem(mContext, navigationmenuresponse);
            if (gnodraweritem != null)
            {
                String s1 = navigationmenuresponse.getParentId();
                if (Util.isEmpty(s1))
                {
                    gnomenuitemproviderbase1.addItem(gnodraweritem);
                } else
                {
                    GNOMenuItemProviderBase gnomenuitemproviderbase = (GNOMenuItemProviderBase)linkedhashmap.get(s1);
                    navigationmenuresponse = gnomenuitemproviderbase;
                    if (gnomenuitemproviderbase == null)
                    {
                        navigationmenuresponse = new GNOMenuItemProviderBase();
                        linkedhashmap.put(s1, navigationmenuresponse);
                    }
                    navigationmenuresponse.addItem(gnodraweritem);
                }
            }
        } while (true);
        navigationmenuresponse = linkedhashmap.entrySet().iterator();
        do
        {
            if (!navigationmenuresponse.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)navigationmenuresponse.next();
            String s = (String)entry.getKey();
            if (!s.equals("mshop"))
            {
                findDrawerItem(s, linkedhashmap.values()).setChildren(((GNOMenuItemProviderBase)entry.getValue()).getItems());
            }
        } while (true);
        return gnomenuitemproviderbase1.getItems();
    }

    private void switchLanguageAndFetchMenu(final String menuId, final GNOItemAdapter itemAdapter)
    {
        String s = AppLocale.getInstance().getCurrentLocaleName();
        if (com.amazon.mShop.platform.Platform.Factory.getInstance().getAppStartCountForAllLocales() == 0 && "fr_CA".equals(s))
        {
            mIsCallingMShopServer = true;
            (new LocaleController(new LocaleSwitchSubscriber() {

                final GNOMenuItemController this$0;
                final GNOItemAdapter val$itemAdapter;
                final String val$menuId;

                public void onError(Exception exception, ServiceCall servicecall)
                {
                    UIUtils.info(mContext, com.amazon.mShop.android.lib.R.string.error_message_switching_language);
                    mIsCallingMShopServer = false;
                    fetchMenuItems(menuId, itemAdapter);
                }

                public void onLocaleSwitchCompleted(String s1)
                {
                    mIsCallingMShopServer = false;
                    fetchMenuItems(menuId, itemAdapter);
                }

            
            {
                this$0 = GNOMenuItemController.this;
                menuId = s;
                itemAdapter = gnoitemadapter;
                super();
            }
            })).switchLanguage(s, null);
            return;
        } else
        {
            fetchMenuItems(menuId, itemAdapter);
            return;
        }
    }

    public void resetUpdate()
    {
        if (mServiceCall != null)
        {
            mServiceCall.cancel();
        }
        mLastUpdateTime = 0xfffffffffad9a400L;
    }

    public void updateMenuItems(GNOItemAdapter gnoitemadapter, boolean flag)
    {
        if (gnoitemadapter.isEmpty())
        {
            gnoitemadapter.setItems(CollectionsUtil.sum(getProvider(PROVIDER_DEFAULT).getItems(), getProvider(PROVIDER_DEBUG).getItems()));
        }
        if (flag && !mIsCallingMShopServer && SystemClock.elapsedRealtime() - mLastUpdateTime > 0x5265c00L)
        {
            switchLanguageAndFetchMenu("mshop", gnoitemadapter);
        }
    }




/*
    static boolean access$102(GNOMenuItemController gnomenuitemcontroller, boolean flag)
    {
        gnomenuitemcontroller.mIsCallingMShopServer = flag;
        return flag;
    }

*/




/*
    static long access$402(GNOMenuItemController gnomenuitemcontroller, long l)
    {
        gnomenuitemcontroller.mLastUpdateTime = l;
        return l;
    }

*/



}
