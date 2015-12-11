// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.cvsd;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Address;
import com.amazon.rio.j2me.client.services.mShop.Coordinates;
import com.amazon.rio.j2me.client.services.mShop.DeliveryLocationsSearchRequest;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.SearchDeliveryLocationsResponseListener;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.cvsd:
//            CVSDSubscriber, CVSDReceivedResult

public class CVSDController extends BaseController
    implements SearchDeliveryLocationsResponseListener
{

    private String receivedMessage;
    private int receivedTypeVaule;
    private List resultAddressList;
    private CVSDSubscriber subscriber;

    public CVSDController()
    {
        receivedTypeVaule = -1;
        resultAddressList = new ArrayList();
    }

    private void reset()
    {
        receivedTypeVaule = -1;
        resultAddressList.clear();
        receivedMessage = null;
    }

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
    }

    public void cancel()
    {
        reset();
        super.cancel();
    }

    public void completed(final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final CVSDController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (!isRunningServiceCall(sc)) goto _L2; else goto _L1
_L1:
                serviceCallCompleted();
                if (receivedTypeVaule != 0) goto _L4; else goto _L3
_L3:
                if (resultAddressList.size() != 0 || Util.isEmpty(receivedMessage)) goto _L6; else goto _L5
_L5:
                if (subscriber != null)
                {
                    subscriber.onOnlyMessageReceived(receivedMessage);
                }
_L2:
                return;
_L6:
                if (subscriber != null)
                {
                    subscriber.onDeliveryLocationsReceived(resultAddressList);
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L4:
                if (receivedTypeVaule == 1)
                {
                    CVSDReceivedResult.reset();
                    CVSDReceivedResult.receivedType = 1;
                    CVSDReceivedResult.message = receivedMessage;
                    CVSDReceivedResult.receivedAddresss = resultAddressList;
                    if (subscriber != null)
                    {
                        subscriber.onRefinementsReceived();
                        return;
                    }
                }
                if (true) goto _L2; else goto _L7
_L7:
            }

            
            {
                this$0 = CVSDController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public List getResultAddressList()
    {
        return resultAddressList;
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected CVSDSubscriber getSubscriber()
    {
        return subscriber;
    }

    public void receivedAddress(Address address, int i, ServiceCall servicecall)
    {
        resultAddressList.add(address);
    }

    public void receivedMessage(String s, ServiceCall servicecall)
    {
        receivedMessage = s;
    }

    public void receivedTotalCount(Integer integer, ServiceCall servicecall)
    {
    }

    public void receivedType(Integer integer, ServiceCall servicecall)
    {
        receivedTypeVaule = integer.intValue();
    }

    public void searchDeliveryLoationByLandmark(String s, String s1, TaskCallback taskcallback)
    {
        cancel();
        DeliveryLocationsSearchRequest deliverylocationssearchrequest = new DeliveryLocationsSearchRequest();
        deliverylocationssearchrequest.setType(3);
        deliverylocationssearchrequest.setQuery(s);
        if (!Util.isEmpty(s1))
        {
            deliverylocationssearchrequest.setState(s1);
        }
        deliverylocationssearchrequest.setPage(new Integer(1));
        deliverylocationssearchrequest.setSize(new Integer(10));
        serviceCallStarted(ServiceController.getMShopService().searchDeliveryLocations(deliverylocationssearchrequest, this), taskcallback);
    }

    public void searchDeliveryLocationByAddress(Address address, TaskCallback taskcallback)
    {
        cancel();
        DeliveryLocationsSearchRequest deliverylocationssearchrequest = new DeliveryLocationsSearchRequest();
        deliverylocationssearchrequest.setType(0);
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(address.getLocation().getLatitude());
        coordinates.setLongitude(address.getLocation().getLongitude());
        deliverylocationssearchrequest.setCoordinates(coordinates);
        deliverylocationssearchrequest.setPage(new Integer(1));
        deliverylocationssearchrequest.setSize(new Integer(10));
        serviceCallStarted(ServiceController.getMShopService().searchDeliveryLocations(deliverylocationssearchrequest, this), taskcallback);
    }

    public void searchDeliveryLocationByAddress(String s, String s1, TaskCallback taskcallback)
    {
        cancel();
        DeliveryLocationsSearchRequest deliverylocationssearchrequest = new DeliveryLocationsSearchRequest();
        deliverylocationssearchrequest.setType(1);
        if (!Util.isEmpty(s))
        {
            deliverylocationssearchrequest.setState(s);
        }
        deliverylocationssearchrequest.setQuery(s1);
        deliverylocationssearchrequest.setPage(new Integer(1));
        deliverylocationssearchrequest.setSize(new Integer(10));
        serviceCallStarted(ServiceController.getMShopService().searchDeliveryLocations(deliverylocationssearchrequest, this), taskcallback);
    }

    public void searchDeliveryLocationByCurrentLocation(String s, String s1)
    {
        cancel();
        DeliveryLocationsSearchRequest deliverylocationssearchrequest = new DeliveryLocationsSearchRequest();
        deliverylocationssearchrequest.setType(0);
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(s);
        coordinates.setLongitude(s1);
        deliverylocationssearchrequest.setCoordinates(coordinates);
        deliverylocationssearchrequest.setPage(new Integer(1));
        deliverylocationssearchrequest.setSize(new Integer(10));
        serviceCallStarted(ServiceController.getMShopService().searchDeliveryLocations(deliverylocationssearchrequest, this), null);
    }

    public void searchDeliveryLocationByZipcode(String s, TaskCallback taskcallback)
    {
        cancel();
        DeliveryLocationsSearchRequest deliverylocationssearchrequest = new DeliveryLocationsSearchRequest();
        deliverylocationssearchrequest.setType(2);
        deliverylocationssearchrequest.setQuery(s);
        deliverylocationssearchrequest.setPage(new Integer(1));
        deliverylocationssearchrequest.setSize(new Integer(10));
        serviceCallStarted(ServiceController.getMShopService().searchDeliveryLocations(deliverylocationssearchrequest, this), taskcallback);
    }

    public void setSubscriber(CVSDSubscriber cvsdsubscriber)
    {
        subscriber = cvsdsubscriber;
    }






}
