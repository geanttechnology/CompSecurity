// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.shoppingcart;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.data.ShoppingCart;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.shoppingcart:
//            ShoppingCartActivity, CartAdapter

public class ShoppingCartTabFragment extends BaseFragment
{
    public static interface CheckoutListener
    {

        public abstract void onEnableCheckout(boolean flag);
    }

    public final class ShoppingCartDataHandler extends com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.SimpleObserver
    {

        final ShoppingCartTabFragment this$0;

        public void onShoppingCartChanged(ShoppingCartDataManagerBase shoppingcartdatamanagerbase, com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action, Content content)
        {
label0:
            {
                if (!content.getStatus().hasError() && action.needsAdditionalData)
                {
                    shoppingcartdatamanagerbase = (ShoppingCart)content.getData();
                    if (tabIndex != 0)
                    {
                        break label0;
                    }
                    refreshCart(shoppingcartdatamanagerbase);
                }
                return;
            }
            refreshSaved(shoppingcartdatamanagerbase);
        }

        public ShoppingCartDataHandler()
        {
            this$0 = ShoppingCartTabFragment.this;
            super();
        }
    }


    private static final int ALL_PURCHASABLE_ITEMS = 0;
    public static final String EXTRA_TAB_INDEX = "com.ebay.mobile.shoppingcart.ShoppingCartTabFragment.tabIndex";
    private static final int NO_PURCHASABLE_ITEMS = 3;
    private static final int ONE_PURCHASABLE_ITEM = 2;
    private static final int SOME_PURCHASABLE_ITEMS = 1;
    private CheckoutListener checkoutListener;
    private ShoppingCartDataHandler shoppingCartDataHandler;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int tabIndex;

    public ShoppingCartTabFragment()
    {
    }

    private List flattenCart(ShoppingCart shoppingcart)
    {
        LinkedList linkedlist = new LinkedList();
        if (shoppingcart != null)
        {
            LinkedList linkedlist1;
label0:
            for (Iterator iterator = shoppingcart.itemsBySeller.keySet().iterator(); iterator.hasNext(); linkedlist.addAll(linkedlist1))
            {
                Object obj = (com.ebay.nautilus.domain.data.ShoppingCart.Seller)iterator.next();
                linkedlist1 = new LinkedList();
                linkedlist.add(obj);
                obj = (com.ebay.nautilus.domain.data.ShoppingCart.Orders)shoppingcart.itemsBySeller.get(obj);
                Iterator iterator1 = ((com.ebay.nautilus.domain.data.ShoppingCart.Orders) (obj)).itemsByOffer.keySet().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    com.ebay.nautilus.domain.data.ShoppingCart.Promotion promotion = (com.ebay.nautilus.domain.data.ShoppingCart.Promotion)iterator1.next();
                    for (Iterator iterator2 = ((List)((com.ebay.nautilus.domain.data.ShoppingCart.Orders) (obj)).itemsByOffer.get(promotion)).iterator(); iterator2.hasNext();)
                    {
                        Object obj1 = (com.ebay.nautilus.domain.data.ShoppingCart.Item)iterator2.next();
                        if (!((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).transactions.isEmpty())
                        {
                            obj1 = ((com.ebay.nautilus.domain.data.ShoppingCart.Item) (obj1)).transactions.iterator();
                            while (((Iterator) (obj1)).hasNext()) 
                            {
                                linkedlist.add((com.ebay.nautilus.domain.data.ShoppingCart.Transaction)((Iterator) (obj1)).next());
                            }
                        } else
                        {
                            linkedlist.add(obj1);
                        }
                    }

                    if (promotion.status == com.ebay.nautilus.domain.data.ShoppingCart.Promotion.Status.APPLIED)
                    {
                        linkedlist1.add(promotion);
                    } else
                    if (promotion != com.ebay.nautilus.domain.data.ShoppingCart.Promotion.UNKNOWN && promotion.promotionType.isSellerPromotion)
                    {
                        linkedlist.add(promotion);
                    }
                } while (true);
            }

            if (shoppingcart.summary.totalBuyableItems > 0)
            {
                linkedlist.add(shoppingcart.summary);
            }
        }
        return new ArrayList(linkedlist);
    }

    private static int getItemPurchasableState(ShoppingCart shoppingcart, int i)
    {
        if (i > 0)
        {
            boolean flag = shoppingcart.isMultipleCurrencyCart();
            int j;
            if (flag)
            {
                j = getPurchasableCurrenciesCount(shoppingcart);
            } else
            {
                j = getPurchasableItemCount(shoppingcart.getItemsByCurrency((String)(new ArrayList(shoppingcart.getItemsByCurrency().keySet())).get(0)));
            }
            if (j == i && !flag)
            {
                return 0;
            }
            if (j > 1)
            {
                return 1;
            }
            if (j == 1)
            {
                return 2;
            }
        }
        return 3;
    }

    private String getNotificationHeader(int i, int j)
    {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 31
    //                   2 38
    //                   3 45;
           goto _L1 _L2 _L3 _L4
_L1:
        return "";
_L2:
        return getString(0x7f070a97);
_L3:
        return getString(0x7f070a9e);
_L4:
        if (j > 0)
        {
            return getString(0x7f070a98);
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static int getPurchasableCurrenciesCount(ShoppingCart shoppingcart)
    {
        int i = 0;
        shoppingcart = shoppingcart.getItemsByCurrency().values().iterator();
        do
        {
            if (!shoppingcart.hasNext())
            {
                break;
            }
            Object obj = (List)shoppingcart.next();
            boolean flag1 = false;
            obj = ((List) (obj)).iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (!((com.ebay.nautilus.domain.data.ShoppingCart.Item)((Iterator) (obj)).next()).hasPaymentMethod("PayPal"))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (flag)
            {
                i++;
            }
        } while (true);
        return i;
    }

    private static int getPurchasableItemCount(List list)
    {
        int i = 0;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            if (((com.ebay.nautilus.domain.data.ShoppingCart.Item)list.next()).hasPaymentMethod("PayPal"))
            {
                i++;
            }
        } while (true);
        return i;
    }

    private void refreshCart(ShoppingCart shoppingcart)
    {
label0:
        {
            Object obj;
label1:
            {
                obj = (ListView)getView().findViewById(0x7f1007d5);
                ShoppingCartActivity shoppingcartactivity = (ShoppingCartActivity)getActivity();
                if (obj == null || shoppingcart == null || shoppingcartactivity == null)
                {
                    break label0;
                }
                int k = shoppingcart.getAllItems().size();
                int i;
                int j;
                if (k > 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                ((ListView) (obj)).setAdapter(new CartAdapter(shoppingcartactivity, flattenCart(shoppingcart)));
                if (i != 0)
                {
                    j = 0;
                } else
                {
                    j = 8;
                }
                ((ListView) (obj)).setVisibility(j);
                obj = getView().findViewById(0x7f1007d6);
                if (i != 0)
                {
                    i = 8;
                } else
                {
                    i = 0;
                }
                ((View) (obj)).setVisibility(i);
                if (MyApp.getDeviceConfiguration().getConfig().get(DcsBoolean.UseShoppingCartMultipleCurrency))
                {
                    i = getItemPurchasableState(shoppingcart, k);
                    boolean flag;
                    if (k <= 0 || i == 3)
                    {
                        flag = false;
                    } else
                    {
                        flag = true;
                    }
                    if (checkoutListener != null)
                    {
                        checkoutListener.onEnableCheckout(flag);
                    }
                    shoppingcart = getNotificationHeader(i, k);
                    obj = getView().findViewById(0x7f1007d1);
                    if (TextUtils.isEmpty(shoppingcart))
                    {
                        break label1;
                    }
                    ((TextView)((View) (obj)).findViewById(0x7f1007d3)).setText(shoppingcart);
                    ((View) (obj)).setVisibility(0);
                }
                return;
            }
            ((View) (obj)).setVisibility(8);
            return;
        }
        getView().findViewById(0x7f1007d6).setVisibility(0);
    }

    private void refreshSaved(ShoppingCart shoppingcart)
    {
        ListView listview = (ListView)getView().findViewById(0x7f1007d5);
        ShoppingCartActivity shoppingcartactivity = (ShoppingCartActivity)getActivity();
        if (listview != null && shoppingcart != null && shoppingcartactivity != null)
        {
            com.ebay.nautilus.domain.data.ShoppingCart.Item item;
            LinkedList linkedlist;
            Iterator iterator;
            boolean flag;
            if (shoppingcart.savedForLater.size() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            item = null;
            linkedlist = new LinkedList();
            iterator = shoppingcart.savedForLater.iterator();
            for (shoppingcart = item; iterator.hasNext(); shoppingcart = item.sellerUserId)
            {
                item = (com.ebay.nautilus.domain.data.ShoppingCart.Item)iterator.next();
                if (!TextUtils.equals(shoppingcart, item.sellerUserId))
                {
                    linkedlist.add(new com.ebay.nautilus.domain.data.ShoppingCart.Seller(item.sellerUserId, item.sellerFeedbackScore.intValue(), false, null));
                }
                linkedlist.add(item);
            }

            listview.setAdapter(new CartAdapter(shoppingcartactivity, linkedlist));
            byte byte0;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            listview.setVisibility(i);
            shoppingcart = getView().findViewById(0x7f1007d6);
            if (flag)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            shoppingcart.setVisibility(byte0);
            return;
        } else
        {
            getView().findViewById(0x7f1007d6).setVisibility(0);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof CheckoutListener)
        {
            checkoutListener = (CheckoutListener)getActivity();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        tabIndex = getArguments().getInt("com.ebay.mobile.shoppingcart.ShoppingCartTabFragment.tabIndex");
        setRetainInstance(false);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030249, viewgroup, false);
        layoutinflater.findViewById(0x7f1007d5).setVisibility(8);
        viewgroup = (TextView)layoutinflater.findViewById(0x7f1007d6);
        if (viewgroup != null)
        {
            viewgroup.setVisibility(8);
            int i;
            if (tabIndex == 0)
            {
                i = 0x7f070a8e;
            } else
            {
                i = 0x7f070aa9;
            }
            viewgroup.setText(i);
        }
        return layoutinflater;
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        shoppingCartDataHandler = new ShoppingCartDataHandler();
        com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi serviceapi;
        if (DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Payments.B.shopCaseCart))
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.SHOPCASE;
        } else
        {
            serviceapi = com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.ServiceApi.ECAS;
        }
        datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.KeyParams(serviceapi), shoppingCartDataHandler);
    }

    protected void onRefresh()
    {
        if (swipeRefreshLayout != null)
        {
            swipeRefreshLayout.setRefreshing(false);
        }
        ShoppingCartActivity shoppingcartactivity = (ShoppingCartActivity)getActivity();
        if (shoppingcartactivity != null)
        {
            shoppingcartactivity.refresh();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        swipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(0x7f1007d4);
        if (swipeRefreshLayout != null)
        {
            swipeRefreshLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

                final ShoppingCartTabFragment this$0;

                public void onRefresh()
                {
                    ShoppingCartTabFragment.this.onRefresh();
                }

            
            {
                this$0 = ShoppingCartTabFragment.this;
                super();
            }
            });
        }
    }



}
