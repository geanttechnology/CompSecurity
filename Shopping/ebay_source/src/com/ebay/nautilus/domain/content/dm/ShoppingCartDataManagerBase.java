// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DcsNautilusLong;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.cachemanager.JsonPersistenceMapper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager, EcasShoppingCartDataManager, ShopcaseShoppingCartDataManager

public abstract class ShoppingCartDataManagerBase extends UserContextObservingDataManager
{
    public static final class Action extends Enum
    {

        private static final Action $VALUES[];
        public static final Action ADD_TO_CART;
        public static final Action CREATE_CHECKOUT_SESSION;
        public static final Action GET_AND_VALIDATE_CART;
        public static final Action GET_CART;
        public static final Action MOVE_TO_CART;
        public static final Action MOVE_TO_SAVE_FOR_LATER;
        public static final Action REMOVE_FROM_CART;
        public static final Action REMOVE_FROM_SAVE_FOR_LATER;
        public static final Action SET_ITEM_QUANTITY;
        public static final Action SET_SHIPPING_ADDRESS;
        public static final Action UNKNOWN;
        public final boolean hasValidation;
        public final boolean isCacheable;
        public final boolean needsAdditionalData;

        public static Action valueOf(String s)
        {
            return (Action)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$Action, s);
        }

        public static Action[] values()
        {
            return (Action[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new Action("UNKNOWN", 0, false, false, false);
            GET_CART = new Action("GET_CART", 1, false, true, false);
            GET_AND_VALIDATE_CART = new Action("GET_AND_VALIDATE_CART", 2, true, true, true);
            ADD_TO_CART = new Action("ADD_TO_CART", 3, false, true, false);
            MOVE_TO_SAVE_FOR_LATER = new Action("MOVE_TO_SAVE_FOR_LATER", 4, false, true, true);
            MOVE_TO_CART = new Action("MOVE_TO_CART", 5, false, true, true);
            REMOVE_FROM_SAVE_FOR_LATER = new Action("REMOVE_FROM_SAVE_FOR_LATER", 6, false, true, true);
            REMOVE_FROM_CART = new Action("REMOVE_FROM_CART", 7, false, true, true);
            SET_ITEM_QUANTITY = new Action("SET_ITEM_QUANTITY", 8, false, true, true);
            SET_SHIPPING_ADDRESS = new Action("SET_SHIPPING_ADDRESS", 9, false, false, false);
            CREATE_CHECKOUT_SESSION = new Action("CREATE_CHECKOUT_SESSION", 10, false, false, false);
            $VALUES = (new Action[] {
                UNKNOWN, GET_CART, GET_AND_VALIDATE_CART, ADD_TO_CART, MOVE_TO_SAVE_FOR_LATER, MOVE_TO_CART, REMOVE_FROM_SAVE_FOR_LATER, REMOVE_FROM_CART, SET_ITEM_QUANTITY, SET_SHIPPING_ADDRESS, 
                CREATE_CHECKOUT_SESSION
            });
        }

        private Action(String s, int i, boolean flag, boolean flag1, boolean flag2)
        {
            super(s, i);
            hasValidation = flag;
            isCacheable = flag1;
            needsAdditionalData = flag2;
        }
    }

    public static interface Configuration
    {

        public abstract boolean isBopisEnabled();

        public abstract boolean isShoppingCartEnabled();
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
    {

        protected final ServiceApi serviceApi;

        protected ShoppingCartDataManagerBase create(EbayContext ebaycontext)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$ServiceApi[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$ServiceApi = new int[ServiceApi.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$ServiceApi[ServiceApi.SHOPCASE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$content$dm$ShoppingCartDataManagerBase$ServiceApi[ServiceApi.ECAS.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi[serviceApi.ordinal()])
            {
            default:
                return new EcasShoppingCartDataManager(ebaycontext, this);

            case 1: // '\001'
                return new ShopcaseShoppingCartDataManager(ebaycontext, this);
            }
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (KeyParams)obj;
                if (serviceApi != ((KeyParams) (obj)).serviceApi)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return hashCode() * 31 + serviceApi.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("ShoppingCart [serviceApi=").append(serviceApi.name()).append("]").toString();
        }

        public KeyParams(ServiceApi serviceapi)
        {
            serviceApi = serviceapi;
        }
    }

    public static interface Observer
    {

        public abstract void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content);

        public abstract void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Action action, Content content);

        public abstract void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Action action);
    }

    public static final class ServiceApi extends Enum
    {

        private static final ServiceApi $VALUES[];
        public static final ServiceApi ECAS;
        public static final ServiceApi SHOPCASE;

        public static ServiceApi valueOf(String s)
        {
            return (ServiceApi)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$ServiceApi, s);
        }

        public static ServiceApi[] values()
        {
            return (ServiceApi[])$VALUES.clone();
        }

        static 
        {
            ECAS = new ServiceApi("ECAS", 0);
            SHOPCASE = new ServiceApi("SHOPCASE", 1);
            $VALUES = (new ServiceApi[] {
                ECAS, SHOPCASE
            });
        }

        private ServiceApi(String s, int i)
        {
            super(s, i);
        }
    }

    public static class SimpleObserver
        implements Observer
    {

        public void onCheckoutSessionComplete(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Content content)
        {
        }

        public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Action action, Content content)
        {
        }

        public void onShoppingCartLoading(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, Action action)
        {
        }

        public SimpleObserver()
        {
        }
    }


    private static int buyableItemCount;
    protected static volatile CacheManager cacheManager;
    protected static volatile Configuration config;
    private static final Object configLock = new Object();
    private static final Object itemCountLock = new Object();
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new LogInfo("ShoppingCartDataManager", 3, "Log shopping cart data manager");
    protected String iafToken;
    protected final List outstandingTasks;
    protected EbaySite site;
    protected String userId;

    protected ShoppingCartDataManagerBase(EbayContext ebaycontext, KeyParams keyparams)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$Observer, keyparams);
        outstandingTasks = new ArrayList();
        ebaycontext = DeviceConfiguration.getAsync();
        initialize(new CacheManager(getContext(), JsonPersistenceMapper.create(DataMapperFactory.getDefaultMapper()), com/ebay/nautilus/domain/data/ShoppingCart, "shoppingCartCache", 1, 1, 1L, ebaycontext.get(DcsNautilusLong.ShoppingCartDataManagerCacheAge), true), NautilusDomain.getShoppingCartDataManagerConfiguration(getContext()));
    }

    ShoppingCartDataManagerBase(EbayContext ebaycontext, KeyParams keyparams, CacheManager cachemanager, Configuration configuration)
    {
        UserContextObservingDataManager(ebaycontext, com/ebay/nautilus/domain/content/dm/ShoppingCartDataManagerBase$Observer, keyparams);
        outstandingTasks = new ArrayList();
        initialize(cachemanager, configuration);
    }

    public static int getBuyableItemCount()
    {
        int i;
        synchronized (itemCountLock)
        {
            i = buyableItemCount;
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected static String getCacheKey(String s, String s1, boolean flag)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        if (flag)
        {
            s1 = "1";
        } else
        {
            s1 = "0";
        }
        return TextUtils.join("-", new String[] {
            "shoppingCart", s, s2, s1
        });
    }

    public static ServiceApi getShoppingCartServiceApi()
    {
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            return ServiceApi.SHOPCASE;
        } else
        {
            return ServiceApi.ECAS;
        }
    }

    private static void initialize(CacheManager cachemanager, Configuration configuration)
    {
        Object obj = configLock;
        obj;
        JVM INSTR monitorenter ;
        if (config == null)
        {
            config = configuration;
            if (config == null)
            {
                throw new IllegalStateException("App returned a null ShoppingCartDataManager.Configuration.");
            }
        }
        break MISSING_BLOCK_LABEL_37;
        cachemanager;
        obj;
        JVM INSTR monitorexit ;
        throw cachemanager;
        if (cacheManager == null)
        {
            cacheManager = cachemanager;
        }
        obj;
        JVM INSTR monitorexit ;
    }

    protected static void setBuyableItemCount(int i)
    {
        synchronized (itemCountLock)
        {
            buyableItemCount = i;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract void addItemToCart(Long long1, String s, String s1, int i, Observer observer);

    protected boolean canRequestCart()
    {
        return true;
    }

    protected void cancelOutstandingTasks()
    {
        for (Iterator iterator = outstandingTasks.iterator(); iterator.hasNext(); ((AsyncTask)iterator.next()).cancel(true)) { }
    }

    public abstract void createCheckoutSession(Long long1, List list, Observer observer, String s);

    public abstract void getCartAsync(boolean flag);

    protected void invalidateCache()
    {
        NautilusKernel.verifyNotMain();
        cacheManager.clear();
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadData(boolean flag, Observer observer)
    {
        NautilusKernel.verifyMain();
        observer = (Observer)getSafeCallback(observer);
        if (!canRequestCart())
        {
            return;
        } else
        {
            executeOnThreadPool(new GetCachedShoppingCartTask(site.idString, userId, flag, observer), new Void[0]);
            return;
        }
    }

    public abstract void moveToCart(long l, Observer observer);

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        setBuyableItemCount(0);
        cancelOutstandingTasks();
        if (ebaycountry != null)
        {
            site = ebaycountry.getSite();
        } else
        {
            site = null;
        }
        if (canRequestCart())
        {
            getCartAsync(false);
        }
    }

    public final void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (!flag)
        {
            setBuyableItemCount(0);
            cancelOutstandingTasks();
            userId = s;
            iafToken = s1;
            if (canRequestCart())
            {
                getCartAsync(false);
            }
            return;
        } else
        {
            iafToken = s1;
            return;
        }
    }

    public abstract void removeItemFromCart(long l, Observer observer);

    public abstract void removeItemFromSaveForLater(long l, Observer observer);

    public abstract void saveForLater(long l, Observer observer);

    public abstract void setItemQuantity(Long long1, int i, Observer observer);




}
