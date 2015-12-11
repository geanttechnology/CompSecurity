// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.home;

import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.cart.CartController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CartItems;
import com.amazon.rio.j2me.client.services.mShop.HomeRequest;
import com.amazon.rio.j2me.client.services.mShop.HomeResponseListener;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import com.amazon.rio.j2me.client.services.mShop.LoginData;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.PromoSlot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.amazon.mShop.control.home:
//            HomeSubscriber

public final class HomeController
    implements UserListener, HomeResponseListener
{

    private static long USER_SIGN_IN_PERIOD_TIME_MILLIS = 10000L;
    private static HomeController instance;
    private boolean applicationStarted;
    private boolean doPhoneHomeAfterCancelComplete;
    private boolean forcingUserSignOut;
    private long lastPhoneHomeTimeMillis;
    private long lastUserSigninInTimeMillis;
    private boolean loadingCart;
    private boolean loginDataReceived;
    private Exception mException;
    private boolean mNoNeedCountAppStart;
    private String mRequestId;
    private boolean mReturnHomeItems;
    private HomeShoveler mShoveler0;
    private HomeShoveler mShoveler1;
    private PromoSlot promoSlot0;
    private PromoSlot promoSlot1;
    private boolean returnCartItems;
    private ServiceCall serviceCall;
    private List subscribers;

    private HomeController()
    {
        mReturnHomeItems = true;
        subscribers = new ArrayList();
        applicationStarted = true;
        mNoNeedCountAppStart = false;
        doPhoneHomeAfterCancelComplete = false;
        forcingUserSignOut = false;
        lastUserSigninInTimeMillis = 0L;
        User.addUserListener(this);
    }

    public static HomeController getInstance()
    {
        com/amazon/mShop/control/home/HomeController;
        JVM INSTR monitorenter ;
        HomeController homecontroller;
        if (instance == null)
        {
            instance = new HomeController();
        }
        homecontroller = instance;
        com/amazon/mShop/control/home/HomeController;
        JVM INSTR monitorexit ;
        return homecontroller;
        Exception exception;
        exception;
        throw exception;
    }

    public static long getUserSignInPeriod()
    {
        return USER_SIGN_IN_PERIOD_TIME_MILLIS;
    }

    private void phoneHome()
    {
        doPhoneHomeAfterCancelComplete = false;
        HomeRequest homerequest = new HomeRequest();
        homerequest.setApplicationStarted(new Boolean(applicationStarted));
        Object obj = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        int k = ((DataStore) (obj)).getInt("applicationStartCount");
        int j = 1;
        boolean flag = true;
        int i = k;
        if (applicationStarted)
        {
            i = ((flag) ? 1 : 0);
            if (com.amazon.mShop.platform.Platform.Factory.getInstance().getAppStartCountForAllLocales() == 0)
            {
                i = 0;
            }
            k++;
            ((DataStore) (obj)).putInt("applicationStartCount", k);
            obj = ((DataStore) (obj)).getString("applicationExitReason");
            if (!Util.isEmpty(((String) (obj))))
            {
                homerequest.setCrashInfo(((String) (obj)));
            }
            applicationStarted = false;
            j = i;
            i = k;
        }
        boolean flag1;
        if (j == 0)
        {
            homerequest.setApplicationStartCount(new Integer(1));
            com.amazon.mShop.platform.Platform.Factory.getInstance().resetApplicationId();
            Logger.getLogger("Amazon").log(Level.WARNING, "Set first home call as first launch.");
        } else
        if (i != 1)
        {
            homerequest.setApplicationStartCount(new Integer(i));
        }
        if (isReturnCartItems() && !CartController.getInstance().cartIsLoading())
        {
            homerequest.setReturnCartItems(new Boolean(true));
        }
        if (isReturnHomeItems())
        {
            homerequest.setReturnPromoSlot0(Boolean.TRUE);
            homerequest.setReturnPromoSlot1(Boolean.TRUE);
            homerequest.setReturnShoveler0(Boolean.TRUE);
            homerequest.setReturnShoveler1(Boolean.TRUE);
        }
        if (homerequest.getReturnCartItems() == null)
        {
            flag1 = false;
        } else
        {
            flag1 = homerequest.getReturnCartItems().booleanValue();
        }
        loadingCart = flag1;
        loginDataReceived = false;
        forcingUserSignOut = false;
        promoSlot0 = null;
        promoSlot1 = null;
        mShoveler0 = null;
        mShoveler1 = null;
        obj = new ArrayList(subscribers);
        for (Iterator iterator1 = ((List) (obj)).iterator(); iterator1.hasNext(); ((HomeSubscriber)iterator1.next()).preHomeCallStarted()) { }
        mRequestId = CustomClientFields.getAmazonRequestId();
        CustomClientFields.setCustomHeaderFields("home_v38", false, mRequestId);
        serviceCall = ServiceController.getMShopService().home(homerequest, this);
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onHomeCallStarted()) { }
    }

    public static void setInstance(HomeController homecontroller)
    {
        com/amazon/mShop/control/home/HomeController;
        JVM INSTR monitorenter ;
        instance = homecontroller;
        com/amazon/mShop/control/home/HomeController;
        JVM INSTR monitorexit ;
        return;
        homecontroller;
        throw homecontroller;
    }

    private boolean shouldPhoneHomeAgain()
    {
        while (applicationStarted || isReturnHomeItems() && (mShoveler0 == null || Util.isEmpty(mShoveler0.getItems())) || System.currentTimeMillis() - lastPhoneHomeTimeMillis > 0x493e0L) 
        {
            return true;
        }
        return false;
    }

    public void addSubscriber(HomeSubscriber homesubscriber)
    {
        if (homesubscriber != null && !subscribers.contains(homesubscriber))
        {
            subscribers.add(homesubscriber);
        }
    }

    public void addSubscriberAtFirstPosition(HomeSubscriber homesubscriber)
    {
        if (homesubscriber != null && !subscribers.contains(homesubscriber))
        {
            subscribers.add(0, homesubscriber);
        }
    }

    public void cancelled(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;

            public void run()
            {
                serviceCall = null;
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onCancelled()) { }
                if (doPhoneHomeAfterCancelComplete)
                {
                    phoneHome();
                }
            }

            
            {
                this$0 = HomeController.this;
                super();
            }
        });
    }

    public void clearException()
    {
        mException = null;
    }

    public void completed(ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;

            public void run()
            {
                lastPhoneHomeTimeMillis = System.currentTimeMillis();
                serviceCall = null;
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("applicationExitReason");
                if (loadingCart)
                {
                    CartController.getInstance().onCartReceivedFromHomeCall(null);
                    loadingCart = false;
                }
                if (!loginDataReceived && User.getUser() != null)
                {
                    forcingUserSignOut = true;
                    User.userSignedOut();
                }
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onPageComplete()) { }
                if (doPhoneHomeAfterCancelComplete)
                {
                    phoneHome();
                }
            }

            
            {
                this$0 = HomeController.this;
                super();
            }
        });
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        mException = e;
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                serviceCall = null;
                if (loadingCart)
                {
                    CartController.getInstance().onCartReceivedFromHomeCall(null);
                    loadingCart = false;
                }
                for (Iterator iterator = subscribers.iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onError(e, sc)) { }
                if (doPhoneHomeAfterCancelComplete)
                {
                    phoneHome();
                }
            }

            
            {
                this$0 = HomeController.this;
                e = exception;
                sc = servicecall;
                super();
            }
        });
    }

    public Exception getException()
    {
        return mException;
    }

    public HomeShoveler getHomeShoveler0()
    {
        return mShoveler0;
    }

    public HomeShoveler getHomeShoveler1()
    {
        return mShoveler1;
    }

    public List getHomepageTokens()
    {
        ArrayList arraylist = new ArrayList();
        if (promoSlot0 != null && !Util.isEmpty(promoSlot0.getSlotToken()))
        {
            arraylist.add(promoSlot0.getSlotToken());
        }
        if (promoSlot1 != null && !Util.isEmpty(promoSlot1.getSlotToken()))
        {
            arraylist.add(promoSlot1.getSlotToken());
        }
        if (mShoveler0 != null && !Util.isEmpty(mShoveler0.getSlotToken()))
        {
            arraylist.add(mShoveler0.getSlotToken());
        }
        if (mShoveler1 != null && !Util.isEmpty(mShoveler1.getSlotToken()))
        {
            arraylist.add(mShoveler1.getSlotToken());
        }
        return arraylist;
    }

    public PromoSlot getPromoSlot0()
    {
        return promoSlot0;
    }

    public PromoSlot getPromoSlot1()
    {
        return promoSlot1;
    }

    public String getRequestId()
    {
        return mRequestId;
    }

    public boolean isLoadingCart()
    {
        return loadingCart && serviceCall != null;
    }

    public boolean isReturnCartItems()
    {
        return returnCartItems;
    }

    public boolean isReturnHomeItems()
    {
        return mReturnHomeItems;
    }

    public boolean phoneHome(boolean flag, boolean flag1)
    {
        if (applicationStarted || flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        applicationStarted = flag1;
        if (applicationStarted && !mNoNeedCountAppStart)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        applicationStarted = flag1;
        mNoNeedCountAppStart = false;
        if (serviceCall != null)
        {
            if (flag)
            {
                doPhoneHomeAfterCancelComplete = true;
                serviceCall.cancel();
            }
        } else
        if (flag || shouldPhoneHomeAgain())
        {
            phoneHome();
            return true;
        }
        return false;
    }

    public void receivedCartItems(final CartItems value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final CartItems val$value;

            public void run()
            {
                loadingCart = false;
                CartController.getInstance().onCartReceivedFromHomeCall(value);
            }

            
            {
                this$0 = HomeController.this;
                value = cartitems;
                super();
            }
        });
    }

    public void receivedCompletedRemembersItemIds(List list, ServiceCall servicecall)
    {
    }

    public void receivedLoginData(final LoginData value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final LoginData val$value;

            public void run()
            {
                loginDataReceived = true;
                User.userUpdated(value);
            }

            
            {
                this$0 = HomeController.this;
                value = logindata;
                super();
            }
        });
    }

    public void receivedNotification(final Notification value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final Notification val$value;

            public void run()
            {
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onNotificationReceived(value)) { }
            }

            
            {
                this$0 = HomeController.this;
                value = notification;
                super();
            }
        });
    }

    public void receivedPromoSlot0(final PromoSlot value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final PromoSlot val$value;

            public void run()
            {
                promoSlot0 = value;
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onPromoSlot0Received(value)) { }
            }

            
            {
                this$0 = HomeController.this;
                value = promoslot;
                super();
            }
        });
    }

    public void receivedPromoSlot1(final PromoSlot value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final PromoSlot val$value;

            public void run()
            {
                promoSlot1 = value;
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onPromoSlot1Received(value)) { }
            }

            
            {
                this$0 = HomeController.this;
                value = promoslot;
                super();
            }
        });
    }

    public void receivedShoveler0(final HomeShoveler value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final HomeShoveler val$value;

            public void run()
            {
                mShoveler0 = value;
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onHomeShoveler0Received(value)) { }
            }

            
            {
                this$0 = HomeController.this;
                value = homeshoveler;
                super();
            }
        });
    }

    public void receivedShoveler1(final HomeShoveler value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HomeController this$0;
            final HomeShoveler val$value;

            public void run()
            {
                mShoveler1 = value;
                for (Iterator iterator = (new ArrayList(subscribers)).iterator(); iterator.hasNext(); ((HomeSubscriber)iterator.next()).onHomeShoveler1Received(value)) { }
            }

            
            {
                this$0 = HomeController.this;
                value = homeshoveler;
                super();
            }
        });
    }

    public void removeSubscriber(HomeSubscriber homesubscriber)
    {
        if (homesubscriber != null)
        {
            subscribers.remove(homesubscriber);
        }
    }

    public void setApplicationStarted(boolean flag)
    {
        applicationStarted = flag;
    }

    public void setNoNeedCountAppStart(boolean flag)
    {
        mNoNeedCountAppStart = flag;
    }

    public void setReturnCartItems(boolean flag)
    {
        returnCartItems = flag;
    }

    public void setReturnHomeItems(boolean flag)
    {
        mReturnHomeItems = flag;
    }

    public void userSignedIn(User user)
    {
        long l = System.currentTimeMillis();
        if (l - lastUserSigninInTimeMillis > USER_SIGN_IN_PERIOD_TIME_MILLIS)
        {
            lastUserSigninInTimeMillis = l;
            phoneHome(true, false);
        }
    }

    public void userSignedOut()
    {
        lastUserSigninInTimeMillis = 0L;
        if (forcingUserSignOut)
        {
            forcingUserSignOut = false;
            return;
        } else
        {
            phoneHome(true, false);
            return;
        }
    }

    public void userUpdated(User user)
    {
    }




/*
    static boolean access$002(HomeController homecontroller, boolean flag)
    {
        homecontroller.loginDataReceived = flag;
        return flag;
    }

*/


/*
    static HomeShoveler access$1002(HomeController homecontroller, HomeShoveler homeshoveler)
    {
        homecontroller.mShoveler0 = homeshoveler;
        return homeshoveler;
    }

*/


/*
    static PromoSlot access$102(HomeController homecontroller, PromoSlot promoslot)
    {
        homecontroller.promoSlot0 = promoslot;
        return promoslot;
    }

*/


/*
    static HomeShoveler access$1102(HomeController homecontroller, HomeShoveler homeshoveler)
    {
        homecontroller.mShoveler1 = homeshoveler;
        return homeshoveler;
    }

*/



/*
    static PromoSlot access$302(HomeController homecontroller, PromoSlot promoslot)
    {
        homecontroller.promoSlot1 = promoslot;
        return promoslot;
    }

*/



/*
    static boolean access$402(HomeController homecontroller, boolean flag)
    {
        homecontroller.loadingCart = flag;
        return flag;
    }

*/


/*
    static long access$502(HomeController homecontroller, long l)
    {
        homecontroller.lastPhoneHomeTimeMillis = l;
        return l;
    }

*/


/*
    static ServiceCall access$602(HomeController homecontroller, ServiceCall servicecall)
    {
        homecontroller.serviceCall = servicecall;
        return servicecall;
    }

*/


/*
    static boolean access$702(HomeController homecontroller, boolean flag)
    {
        homecontroller.forcingUserSignOut = flag;
        return flag;
    }

*/


}
