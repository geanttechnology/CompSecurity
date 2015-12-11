// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.wishlist;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.TaskCallback;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsRequest;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponse;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.GetListListsRequest;
import com.amazon.rio.j2me.client.services.mShop.GetListListsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.MoveListItemsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.RemoveListItemsRequest;
import com.amazon.rio.j2me.client.services.mShop.RemoveListItemsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.RequestListItem;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.wishlist:
//            WishListSubscriber

public class WishListController extends BaseController
    implements AddListItemsResponseListener, MoveListItemsResponseListener, RemoveListItemsResponseListener
{

    private AddListItemsRequest addListItemsRequest;
    private RemoveListItemsRequest removeListItemsRequest;
    private final WishListSubscriber subscriber;

    public WishListController(WishListSubscriber wishlistsubscriber)
    {
        subscriber = wishlistsubscriber;
        addListItemsRequest = new AddListItemsRequest();
        removeListItemsRequest = new RemoveListItemsRequest();
    }

    public void addToWishList(String s, String s1, TaskCallback taskcallback)
    {
        RequestListItem requestlistitem = new RequestListItem();
        requestlistitem.setListItemId("");
        requestlistitem.setListId(s1);
        requestlistitem.setAsin(s);
        requestlistitem.setListType("wishlist");
        s = new Vector(1);
        s.addElement(requestlistitem);
        addListItemsRequest.setItems(s);
        serviceCallStarted(ServiceController.getMShopService().addListItems(addListItemsRequest, this), taskcallback);
    }

    public void completed(AddListItemsResponse addlistitemsresponse, final ServiceCall sc)
    {
        this;
        JVM INSTR monitorenter ;
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final WishListController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    subscriber.onWishListItemAdded();
                }
            }

            
            {
                this$0 = WishListController.this;
                sc = servicecall;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return;
        addlistitemsresponse;
        throw addlistitemsresponse;
    }

    public void dismissProgressDialog()
    {
        getTaskCallback().endTask();
    }

    public void getListList(String s, TaskCallback taskcallback)
    {
        GetListListsRequest getlistlistsrequest = new GetListListsRequest();
        getlistlistsrequest.setRegType(s);
        serviceCallStarted(ServiceController.getMShopService().getListLists(getlistlistsrequest, new GetListListsResponseListener() {

            final WishListController this$0;

            public void cancelled(ServiceCall servicecall)
            {
                WishListController.this.cancelled(servicecall);
            }

            public void completed(List list, final ServiceCall sc)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(list. new Runnable() {

                    final _cls1 this$1;
                    final ServiceCall val$sc;
                    final List val$value;

                    public void run()
                    {
                        if (isRunningServiceCall(sc))
                        {
                            serviceCallCompleted();
                            subscriber.onListLists(value);
                        }
                    }

            
            {
                this$1 = final__pcls1;
                sc = servicecall;
                value = List.this;
                super();
            }
                });
            }

            public void error(Exception exception, ServiceCall servicecall)
            {
                WishListController.this.error(exception, servicecall);
            }

            
            {
                this$0 = WishListController.this;
                super();
            }
        }), taskcallback);
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected WishListSubscriber getSubscriber()
    {
        return subscriber;
    }





}
