// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserSubscriber;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.amazon.rio.j2me.client.services.mShop.DisableOneClickResponseListener;
import com.amazon.rio.j2me.client.services.mShop.EnableOneClickResponseListener;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickAddressesResponseListener;
import com.amazon.rio.j2me.client.services.mShop.GetOneClickConfigResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Notification;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.OneClickAddress;
import com.amazon.rio.j2me.client.services.mShop.OneClickConfigResponse;
import com.amazon.rio.j2me.client.services.mShop.PaymentMethod;
import com.amazon.rio.j2me.client.services.mShop.SetOneClickConfigRequest;
import com.amazon.rio.j2me.client.services.mShop.SetOneClickConfigResponseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.account:
//            OneClickListener

public class OneClickController extends BaseController
    implements DisableOneClickResponseListener, EnableOneClickResponseListener, GetOneClickAddressesResponseListener, GetOneClickConfigResponseListener, SetOneClickConfigResponseListener
{
    public static interface OneClickSubscriber
        extends UserSubscriber
    {

        public abstract void onReceiveOneClickAddresses(List list);

        public abstract void onReceiveOneClickConfig(OneClickConfigResponse oneclickconfigresponse);

        public abstract void onSaveOneClickStatus(boolean flag);
    }


    private static int oneClickAutoActivationState = -1;
    private static final List sOneClickListeners = new ArrayList();
    private String mRequestId;
    private List oneClickAddresses;
    private OneClickConfigResponse oneClickConfigResponse;
    private OneClickAddress selectedOneClickAddress;
    private PaymentMethod selectedPaymentMethod;
    private final OneClickSubscriber subscriber;
    private String userSelectedDeviceName;

    public OneClickController(OneClickSubscriber oneclicksubscriber)
    {
        subscriber = oneclicksubscriber;
    }

    public static String getDefaultDeviceName()
    {
        return com.amazon.mShop.platform.Platform.Factory.getInstance().getDeviceName();
    }

    private static int getOneClickAutoActivationState()
    {
        if (-1 == oneClickAutoActivationState)
        {
            oneClickAutoActivationState = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getInt("oneClickAutoSetupState");
        }
        return oneClickAutoActivationState;
    }

    public static boolean isOneClickNotification(Notification notification)
    {
        int i = notification.getType();
        return 3 == i || 4 == i;
    }

    public static void setDidAttemptAutoActivationOnFirstSignIn(boolean flag)
    {
        if (flag)
        {
            setOneClickAutoActivationState(2);
            return;
        } else
        {
            setOneClickAutoActivationState(1);
            return;
        }
    }

    private void setOneClickAddresses(List list)
    {
        this;
        JVM INSTR monitorenter ;
        oneClickAddresses = list;
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    private static void setOneClickAutoActivationState(int i)
    {
        if (i != oneClickAutoActivationState)
        {
            oneClickAutoActivationState = i;
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putInt("oneClickAutoSetupState", oneClickAutoActivationState);
        }
    }

    private void setOneClickConfigResponse(OneClickConfigResponse oneclickconfigresponse)
    {
        this;
        JVM INSTR monitorenter ;
        oneClickConfigResponse = oneclickconfigresponse;
        if (oneclickconfigresponse == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        User.setOneClickEnabled(oneclickconfigresponse.getOneClickStatus());
        this;
        JVM INSTR monitorexit ;
        return;
        oneclickconfigresponse;
        throw oneclickconfigresponse;
    }

    private void setOneClickStatusEnabled(Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        if (oneClickConfigResponse != null)
        {
            oneClickConfigResponse.setOneClickStatus(boolean1.booleanValue());
        }
        User.setOneClickEnabled(boolean1.booleanValue());
        this;
        JVM INSTR monitorexit ;
        return;
        boolean1;
        throw boolean1;
    }

    public static boolean shouldAttempAutoActivationOnSignIn()
    {
        for (User user = User.getUser(); user != null && user.isOneClick() || getOneClickAutoActivationState() != 0;)
        {
            return false;
        }

        return true;
    }

    public void completed(final OneClickConfigResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final OneClickController this$0;
            final ServiceCall val$sc;
            final OneClickConfigResponse val$value;

            public void run()
            {
label0:
                {
                    if (isRunningServiceCall(sc))
                    {
                        serviceCallCompleted();
                        setOneClickConfigResponse(value);
                        if (!"set_one_click_config_v21".equals(sc.getMethod()))
                        {
                            break label0;
                        }
                        subscriber.onSaveOneClickStatus(value.getOneClickStatus());
                    }
                    return;
                }
                subscriber.onReceiveOneClickConfig(value);
            }

            
            {
                this$0 = OneClickController.this;
                sc = servicecall;
                value = oneclickconfigresponse;
                super();
            }
        });
    }

    public void completed(final Boolean value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final OneClickController this$0;
            final ServiceCall val$sc;
            final Boolean val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    setOneClickStatusEnabled(value);
                    subscriber.onSaveOneClickStatus(value.booleanValue());
                    for (Iterator iterator = (new ArrayList(OneClickController.sOneClickListeners)).iterator(); iterator.hasNext(); ((OneClickListener)iterator.next()).oneClickStatusChanged(value.booleanValue())) { }
                }
            }

            
            {
                this$0 = OneClickController.this;
                sc = servicecall;
                value = boolean1;
                super();
            }
        });
    }

    public void completed(final List value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final OneClickController this$0;
            final ServiceCall val$sc;
            final List val$value;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    setOneClickAddresses(value);
                    subscriber.onReceiveOneClickAddresses(value);
                }
            }

            
            {
                this$0 = OneClickController.this;
                sc = servicecall;
                value = list;
                super();
            }
        });
    }

    public void doGetOneClickAddresses(TaskCallback taskcallback)
    {
        this;
        JVM INSTR monitorenter ;
        List list = getOneClickAddresses();
        if (list == null) goto _L2; else goto _L1
_L1:
        subscriber.onReceiveOneClickAddresses(list);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        CustomClientFields.setCustomHeaderFields("get_one_click_addresses_v21", true, mRequestId);
        serviceCallStarted(ServiceController.getMShopService().getOneClickAddresses(new Null(), this), taskcallback);
        if (true) goto _L4; else goto _L3
_L3:
        taskcallback;
        throw taskcallback;
    }

    public void doGetOneClickConfig(TaskCallback taskcallback)
    {
        this;
        JVM INSTR monitorenter ;
        mRequestId = CustomClientFields.getAmazonRequestId();
        CustomClientFields.setCustomHeaderFields("get_one_click_config_v21", false, mRequestId);
        serviceCallStarted(ServiceController.getMShopService().getOneClickConfig(new Null(), this), taskcallback);
        this;
        JVM INSTR monitorexit ;
        return;
        taskcallback;
        throw taskcallback;
    }

    public void doSetOneClickConfig(TaskCallback taskcallback)
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        setOneClickAutoActivationState(2);
        s1 = getDeviceName();
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = getDefaultDeviceName();
        }
        s1 = getSelectedOneClickAddress().getAddress().getAddressId();
        String s2 = getSelectedPaymentMethod().getCardId();
        Boolean boolean1 = Boolean.TRUE;
        SetOneClickConfigRequest setoneclickconfigrequest = new SetOneClickConfigRequest();
        setoneclickconfigrequest.setDeviceName(s);
        setoneclickconfigrequest.setAddressId(s1);
        setoneclickconfigrequest.setPaymentId(s2);
        setoneclickconfigrequest.setOneClickStatus(boolean1);
        mRequestId = CustomClientFields.getAmazonRequestId();
        CustomClientFields.setCustomHeaderFields("set_one_click_config_v21", false, mRequestId);
        serviceCallStarted(ServiceController.getMShopService().setOneClickConfig(setoneclickconfigrequest, this), taskcallback);
        this;
        JVM INSTR monitorexit ;
        return;
        taskcallback;
        throw taskcallback;
    }

    public void doSetOneClickEnabled(boolean flag, TaskCallback taskcallback)
    {
        this;
        JVM INSTR monitorenter ;
        setOneClickAutoActivationState(2);
        if (!flag) goto _L2; else goto _L1
_L1:
        String s = getDeviceName();
        CustomClientFields.setCustomHeaderFields("enable_one_click_v1", true, mRequestId);
        serviceCallStarted(ServiceController.getMShopService().enableOneClick(s, this), taskcallback);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        CustomClientFields.setCustomHeaderFields("disable_one_click_v1", true, mRequestId);
        serviceCallStarted(ServiceController.getMShopService().disableOneClick(new Null(), this), taskcallback);
        if (true) goto _L4; else goto _L3
_L3:
        taskcallback;
        throw taskcallback;
    }

    public String getDeviceName()
    {
        this;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(userSelectedDeviceName)) goto _L2; else goto _L1
_L1:
        String s = userSelectedDeviceName;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        if (oneClickConfigResponse != null && oneClickConfigResponse.getDeviceName() != null)
        {
            s = oneClickConfigResponse.getDeviceName();
            continue; /* Loop/switch isn't completed */
        }
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public List getOneClickAddresses()
    {
        this;
        JVM INSTR monitorenter ;
        List list = oneClickAddresses;
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public OneClickConfigResponse getOneClickConfigResponse()
    {
        this;
        JVM INSTR monitorenter ;
        OneClickConfigResponse oneclickconfigresponse = oneClickConfigResponse;
        this;
        JVM INSTR monitorexit ;
        return oneclickconfigresponse;
        Exception exception;
        exception;
        throw exception;
    }

    public OneClickAddress getSelectedOneClickAddress()
    {
label0:
        {
            if (selectedOneClickAddress != null)
            {
                return selectedOneClickAddress;
            }
            if (oneClickConfigResponse == null || oneClickAddresses == null)
            {
                break label0;
            }
            Address address = oneClickConfigResponse.getAddress();
            if (address == null)
            {
                return null;
            }
            Iterator iterator = oneClickAddresses.iterator();
            OneClickAddress oneclickaddress;
            Address address1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                oneclickaddress = (OneClickAddress)iterator.next();
                address1 = oneclickaddress.getAddress();
            } while (!address.getAddressId().equals(address1.getAddressId()));
            selectedOneClickAddress = oneclickaddress;
        }
        return selectedOneClickAddress;
    }

    public PaymentMethod getSelectedPaymentMethod()
    {
label0:
        {
            if (selectedPaymentMethod != null)
            {
                return selectedPaymentMethod;
            }
            if (oneClickConfigResponse == null)
            {
                break label0;
            }
            Object obj = getSelectedOneClickAddress();
            if (obj == null || oneClickConfigResponse.getAddress() == null || !((OneClickAddress) (obj)).getAddress().getAddressId().equals(oneClickConfigResponse.getAddress().getAddressId()))
            {
                break label0;
            }
            PaymentMethod paymentmethod = oneClickConfigResponse.getPaymentMethod();
            if (paymentmethod == null)
            {
                break label0;
            }
            obj = ((OneClickAddress) (obj)).getPaymentMethod().iterator();
            PaymentMethod paymentmethod1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                paymentmethod1 = (PaymentMethod)((Iterator) (obj)).next();
            } while (!paymentmethod1.getCardId().equals(paymentmethod.getCardId()));
            selectedPaymentMethod = paymentmethod1;
        }
        return selectedPaymentMethod;
    }

    protected GenericSubscriber getSubscriber()
    {
        return subscriber;
    }

    public boolean isDeviceNameSet()
    {
        return !Util.isEmpty(getDeviceName());
    }

    public boolean isOneClickStatusEnabled()
    {
        this;
        JVM INSTR monitorenter ;
        if (oneClickConfigResponse == null) goto _L2; else goto _L1
_L1:
        boolean flag = oneClickConfigResponse.getOneClickStatus();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (User.getUser() == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        flag = User.getUser().isOneClick();
        if (flag)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void setDeviceName(String s)
    {
        if (Util.isEmpty(s))
        {
            return;
        } else
        {
            userSelectedDeviceName = s;
            return;
        }
    }

    public void setSelectedOneClickAddress(OneClickAddress oneclickaddress)
    {
        List list = oneclickaddress.getPaymentMethod();
        if (1 == list.size())
        {
            selectedPaymentMethod = (PaymentMethod)list.get(0);
        } else
        {
            selectedPaymentMethod = null;
        }
        selectedOneClickAddress = oneclickaddress;
    }

    public void setSelectedPaymentMethod(PaymentMethod paymentmethod)
    {
        selectedPaymentMethod = paymentmethod;
    }












}
