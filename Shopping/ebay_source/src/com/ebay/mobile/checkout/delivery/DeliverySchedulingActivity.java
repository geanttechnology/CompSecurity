// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.delivery;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import com.ebay.android.widget.SlidingTabLayout;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.local.EbayNowDeliveryTimeSlot;
import com.ebay.common.net.api.local.EbayNowMappedException;
import com.ebay.common.net.api.local.EbayNowTimeSlotDataManager;
import com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager;
import com.ebay.common.util.LogisticsUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.mobile.checkout.delivery:
//            DeliverySchedulingParams, DeliveryDateAdapter, DeliveryDate, TimeSlotAdapter, 
//            DeliveryDateFragment

public class DeliverySchedulingActivity extends ModalActivity
    implements android.view.View.OnClickListener, DialogFragmentCallback, com.ebay.common.net.api.local.EbayNowTimeSlotDataManager.Observer, com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.Observer
{

    private static final int DIALOG_ERROR_INVALID_PHONE_NUMBER = 2;
    private static final int DIALOG_ERROR_INVALID_TIME_SLOT = 1;
    public static final String EXTRA_CART = "cart";
    public static final String EXTRA_LINE_ITEM = "line_item";
    public static final String EXTRA_PARAMS = "params";
    private static final String LOG_TAG = "DeliveryScheduling";
    private View buttonBar;
    private Cart cart;
    private boolean completed;
    private DeliveryDateAdapter deliveryDateAdapter;
    private HashMap deliveryFees;
    private com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan eBayNowPlan;
    private int infoMenuId;
    private com.ebay.common.model.cart.Cart.LineItem lineItem;
    ArrayList lineItems;
    private DeliverySchedulingParams params;
    private ProgressDialog progressDialog;
    private SlidingTabLayout slidingTabLayout;
    private EbayNowTimeSlotDataManager timeSlotDataManager;
    private ViewPager viewPager;

    public DeliverySchedulingActivity()
    {
        completed = false;
    }

    private void dismissProgressDialog()
    {
        if (progressDialog != null)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private void fetchTimeSlots()
    {
        Object obj = new ArrayList();
        if (eBayNowPlan.planSteps != null)
        {
            for (Iterator iterator = eBayNowPlan.planSteps.iterator(); iterator.hasNext();)
            {
                Object obj2 = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)iterator.next();
                if (((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep) (obj2)).planOptionsList != null)
                {
                    obj2 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep) (obj2)).planOptionsList.iterator();
                    while (((Iterator) (obj2)).hasNext()) 
                    {
                        String s = getEbayNowServiceId((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)((Iterator) (obj2)).next());
                        if (s != null)
                        {
                            ((ArrayList) (obj)).add(s);
                        }
                    }
                }
            }

        }
        if (!((ArrayList) (obj)).isEmpty())
        {
            progressDialog = ProgressDialog.show(this, null, getString(0x7f070cad), true, false);
            Object obj1 = MyApp.getPrefs().getAuthentication();
            if (obj1 != null)
            {
                timeSlotDataManager = (EbayNowTimeSlotDataManager)getDataManagerContainer().initialize(new com.ebay.common.net.api.local.EbayNowTimeSlotDataManager.KeyParams(((Authentication) (obj1)).iafToken, cart, lineItems, params.zoneId, params.sellerId, params.storeId, ((ArrayList) (obj))), this);
            } else
            {
                Log.e("DeliveryScheduling", "No IAF token");
            }
            obj1 = new TrackingData("ScheduleDays", TrackingType.PAGE_IMPRESSION);
            ((TrackingData) (obj1)).addKeyValuePair("tabs", Integer.toString(((ArrayList) (obj)).size()));
            if (!TextUtils.isEmpty(params.deliveryInstructions))
            {
                obj = "1";
            } else
            {
                obj = "0";
            }
            ((TrackingData) (obj1)).addKeyValuePair("scheDI", ((String) (obj)));
            ((TrackingData) (obj1)).send(this);
            return;
        } else
        {
            finish("empty delivery service IDs");
            return;
        }
    }

    private void finish(String s)
    {
        if (s != null)
        {
            Log.e("DeliveryScheduling", s);
        }
        setCancelled();
        finish();
    }

    private EbayNowDeliveryTimeSlot getDefaultTimeSlot(EbayNowDeliveryTimeSlot aebaynowdeliverytimeslot[])
    {
        Date date = params.selectedTimeSlotStart;
        Date date1 = params.selectedTimeSlotEnd;
        if (date != null && date1 != null)
        {
            int j = aebaynowdeliverytimeslot.length;
            for (int i = 0; i < j; i++)
            {
                EbayNowDeliveryTimeSlot ebaynowdeliverytimeslot = aebaynowdeliverytimeslot[i];
                if (date.compareTo(ebaynowdeliverytimeslot.start) >= 0 && date1.compareTo(ebaynowdeliverytimeslot.end) <= 0)
                {
                    return ebaynowdeliverytimeslot;
                }
            }

        }
        return aebaynowdeliverytimeslot[0];
    }

    private String getEbayNowServiceId(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption)
    {
        String s = planoption.getEbayNowServiceId();
        if (s != null)
        {
            return s;
        } else
        {
            return (String)LogisticsUtil.sPlanOptionTokenMap.get(planoption.token);
        }
    }

    private void initContentView()
    {
        setContentView(0x7f0302bb);
        slidingTabLayout = (SlidingTabLayout)findViewById(0x7f100971);
        viewPager = (ViewPager)findViewById(0x7f1001f3);
        buttonBar = findViewById(0x7f100972);
        buttonBar.findViewById(0x7f100973).setOnClickListener(this);
        setTitle("");
        hideCloseButton();
        showBackButton();
    }

    private void initDeliveryFees()
    {
        deliveryFees = new HashMap();
        for (Iterator iterator = eBayNowPlan.planSteps.iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)iterator.next()).planOptionsList.iterator();
            while (iterator1.hasNext()) 
            {
                com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator1.next();
                String s = getEbayNowServiceId(planoption);
                if (s != null)
                {
                    deliveryFees.put(s, planoption.getBaseLogisticsCost());
                }
            }
        }

    }

    private com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption mapToLogisticsOptionPlan(String s)
    {
        Iterator iterator = eBayNowPlan.planSteps.iterator();
        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption;
label0:
        do
        {
            if (iterator.hasNext())
            {
                Iterator iterator1 = ((com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep)iterator.next()).planOptionsList.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    planoption = (com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption)iterator1.next();
                } while (!s.equals(getEbayNowServiceId(planoption)));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return planoption;
    }

    private void setCancelled()
    {
        Intent intent = new Intent();
        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Scheduler", "cancel"));
        setResult(0, intent);
    }

    private void showEmptyView()
    {
        View view = findViewById(0x7f100975);
        if (view == null)
        {
            ((ViewStub)findViewById(0x7f100974)).inflate();
            return;
        } else
        {
            view.setVisibility(0);
            return;
        }
    }

    private void showError(ResultStatus resultstatus)
    {
        dismissProgressDialog();
        String s = MyApp.getDisplayableServiceError(getEbayContext(), resultstatus);
        resultstatus = s;
        if (TextUtils.isEmpty(s))
        {
            resultstatus = getString(0x7f07024a);
        }
        showErrorToast(resultstatus);
    }

    private void showMultiDates()
    {
        setTitle(0x7f070c97);
        String s = params.selectedReservationToken;
        if (s != null)
        {
            List list = deliveryDateAdapter.deliveryDates;
label0:
            for (int i = list.size() - 1; i >= 0; i--)
            {
                Iterator iterator = ((DeliveryDate)list.get(i)).timeSlots.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                } while (!s.equals(((EbayNowDeliveryTimeSlot)iterator.next()).reservationToken));
                viewPager.setCurrentItem(i);
            }

        }
    }

    private void showSingleDate()
    {
        setTitle(deliveryDateAdapter.getPageTitle(0));
        slidingTabLayout.getChildAt(0).setVisibility(8);
    }

    private void updateParams(EbayNowDeliveryTimeSlot ebaynowdeliverytimeslot)
    {
        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.PlanStep.PlanOption planoption = mapToLogisticsOptionPlan(ebaynowdeliverytimeslot.serviceType);
        if (planoption != null)
        {
            params.selectedLogisticsPlanOptionToken = planoption.token;
            params.selectedLogisticsPlanOptionId = planoption.logisticsOptionIdentifier;
            params.selectedReservationToken = ebaynowdeliverytimeslot.reservationToken;
            params.selectedTimeSlotStart = ebaynowdeliverytimeslot.start;
            params.selectedTimeSlotEnd = ebaynowdeliverytimeslot.end;
            return;
        } else
        {
            params.selectedLogisticsPlanOptionToken = null;
            params.selectedLogisticsPlanOptionId = null;
            params.selectedReservationToken = null;
            params.selectedTimeSlotStart = null;
            params.selectedTimeSlotEnd = null;
            return;
        }
    }

    CurrencyAmount getDeliveryFee(String s)
    {
        return (CurrencyAmount)deliveryFees.get(s);
    }

    String getDeliveryInstructions()
    {
        return params.deliveryInstructions;
    }

    String getSelectedReservationToken()
    {
        return params.selectedReservationToken;
    }

    String getSellerName()
    {
        return params.sellerName;
    }

    public String getTrackingEventName()
    {
        return "Scheduler";
    }

    public void onBackPressed()
    {
        setCancelled();
        super.onBackPressed();
    }

    public void onClick(View view)
    {
        Object obj = null;
        String s;
        switch (view.getId())
        {
        default:
            return;

        case 2131757427: 
            s = params.selectedReservationToken;
            break;
        }
        if (s != null)
        {
            progressDialog = ProgressDialog.show(this, null, getString(0x7f070cb5), true, false);
            Authentication authentication = MyApp.getPrefs().getAuthentication();
            if (authentication != null)
            {
                view = obj;
                if (!TextUtils.isEmpty(params.deliveryInstructions))
                {
                    view = params.deliveryInstructions;
                }
                MyApp.getPrefs().setUserPref(cart.cartId, "lastSuccessfulScheduledCartId");
                getDataManagerContainer().initialize(new com.ebay.common.net.api.local.EbayNowValidateTimeSlotDataManager.KeyParams(authentication.iafToken, s, params.phoneNumber, view), this);
                return;
            } else
            {
                Log.e("DeliveryScheduling", "No IAF token");
                return;
            }
        } else
        {
            finish(null);
            return;
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        int i = viewPager.getCurrentItem();
        initContentView();
        timeSlotDataManager.loadData(this);
        if (i >= 0)
        {
            viewPager.setCurrentItem(i);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        useMenuHandler = false;
        initContentView();
        Intent intent = getIntent();
        if (bundle != null)
        {
            params = (DeliverySchedulingParams)bundle.getParcelable("params");
            cart = (Cart)bundle.getSerializable("cart");
            lineItem = (com.ebay.common.model.cart.Cart.LineItem)bundle.getSerializable("line_item");
        } else
        {
            params = (DeliverySchedulingParams)intent.getParcelableExtra("params");
            cart = (Cart)intent.getSerializableExtra("cart");
            lineItem = (com.ebay.common.model.cart.Cart.LineItem)intent.getSerializableExtra("line_item");
        }
        if (params == null)
        {
            finish("null params");
            return;
        }
        if (cart == null)
        {
            finish("null cart");
            return;
        }
        if (lineItem == null)
        {
            finish("null line item");
            return;
        }
        bundle = cart.getBuyerShippingAddress();
        if (bundle == null)
        {
            finish("null shipping address");
            return;
        }
        if (TextUtils.isEmpty(((Address) (bundle)).addressFields.phone))
        {
            finish("empty phone number");
            return;
        }
        bundle = params.sellerName;
        if (bundle == null)
        {
            finish("null seller name");
            return;
        }
        bundle = (com.ebay.common.model.cart.Cart.Seller)cart.sellers.get(bundle);
        if (bundle == null)
        {
            finish("null seller");
            return;
        }
        lineItems = new ArrayList();
        String s;
        for (bundle = ((com.ebay.common.model.cart.Cart.Seller) (bundle)).cartLineItemIds.iterator(); bundle.hasNext(); lineItems.add(cart.getLineItemByCartLineItemId(s)))
        {
            s = (String)bundle.next();
        }

        eBayNowPlan = lineItem.getLogisticsPlanOfType(com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.EBAY_NOW);
        initDeliveryFees();
        initDataManagers();
        bundle = MyApp.getPrefs().getUserPref("lastSuccessfulScheduledCartId", null);
        boolean flag;
        if (bundle != null && bundle.equals(cart.cartId))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        completed = flag;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        menu = menu.add(0x7f070ca5).setIcon(0x7f0201ac);
        menu.setShowAsAction(2);
        infoMenuId = menu.getItemId();
        return true;
    }

    void onDeliveryInstructionsChanged(String s)
    {
        params.deliveryInstructions = s;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        dismissProgressDialog();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            fetchTimeSlots();
            return;

        case 2: // '\002'
            finish(null);
            break;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        buttonBar.setVisibility(8);
        fetchTimeSlots();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == infoMenuId)
        {
            menuitem = getLayoutInflater().inflate(0x7f0302bc, null);
            menuitem = (new android.support.v7.app.AlertDialog.Builder(this)).setTitle(0x7f070c91).setView(menuitem).setPositiveButton(0x104000a, null).create();
            menuitem.setOnShowListener(new android.content.DialogInterface.OnShowListener() {

                final DeliverySchedulingActivity this$0;

                public void onShow(DialogInterface dialoginterface)
                {
                    ((AlertDialog)dialoginterface).getButton(-1).setTextSize(0, getResources().getDimension(0x7f090154));
                }

            
            {
                this$0 = DeliverySchedulingActivity.this;
                super();
            }
            });
            menuitem.show();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        TrackingData trackingdata = (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent());
        String s;
        if (completed)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("scheLoad", s);
        trackingdata.send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("params", params);
        bundle.putSerializable("cart", cart);
        bundle.putSerializable("line_item", lineItem);
    }

    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
    }

    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
        int i = ((Integer)tab.getTag()).intValue();
        viewPager.setCurrentItem(i);
    }

    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, FragmentTransaction fragmenttransaction)
    {
    }

    void onTimeSlotSelected(TimeSlotAdapter timeslotadapter, int i)
    {
        updateParams((EbayNowDeliveryTimeSlot)timeslotadapter.getItem(i));
        for (i = deliveryDateAdapter.getCount() - 1; i >= 0; i--)
        {
            Object obj = deliveryDateAdapter.getFragment(i);
            if (obj == null)
            {
                continue;
            }
            obj = ((DeliveryDateFragment) (obj)).timeSlotAdapter;
            if (obj != timeslotadapter)
            {
                ((TimeSlotAdapter) (obj)).notifyDataSetChanged();
            }
        }

    }

    public void onTimeSlotsChanged(EbayNowTimeSlotDataManager ebaynowtimeslotdatamanager, Content content)
    {
        dismissProgressDialog();
        ebaynowtimeslotdatamanager = content.getStatus();
        if (ebaynowtimeslotdatamanager.hasError())
        {
            showError(ebaynowtimeslotdatamanager);
            showEmptyView();
            return;
        }
        buttonBar.setVisibility(0);
        ebaynowtimeslotdatamanager = (EbayNowDeliveryTimeSlot[])content.getData();
        if (ebaynowtimeslotdatamanager == null || ebaynowtimeslotdatamanager.length == 0)
        {
            showEmptyView();
            viewPager.setAdapter(null);
            return;
        }
        content = findViewById(0x7f100975);
        if (content != null)
        {
            content.setVisibility(8);
        }
        updateParams(getDefaultTimeSlot(ebaynowtimeslotdatamanager));
        deliveryDateAdapter = new DeliveryDateAdapter(this, getFragmentManager(), ebaynowtimeslotdatamanager);
        viewPager.setAdapter(deliveryDateAdapter);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
        if (deliveryDateAdapter.getCount() == 1)
        {
            showSingleDate();
            return;
        } else
        {
            showMultiDates();
            return;
        }
    }

    public void onValidateTimeSlotComplete(EbayNowValidateTimeSlotDataManager ebaynowvalidatetimeslotdatamanager, Content content)
    {
        dismissProgressDialog();
        content = content.getStatus();
        if (content.hasError())
        {
            showError(content);
            return;
        }
        ebaynowvalidatetimeslotdatamanager = ebaynowvalidatetimeslotdatamanager.getMappedException();
        if (ebaynowvalidatetimeslotdatamanager != null)
        {
            if ("INVALID_PHONE".equals(((EbayNowMappedException) (ebaynowvalidatetimeslotdatamanager)).errorId))
            {
                content = new com.ebay.app.AlertDialogFragment.Builder();
                content.setMessage(0x7f070caa);
                content.setPositiveButton(getString(0x7f070738));
                content.createFromActivity(2).show(getFragmentManager(), null);
            } else
            {
                content = new com.ebay.app.AlertDialogFragment.Builder();
                content.setMessage(0x7f070cab);
                content.setPositiveButton(getString(0x7f070738));
                content.createFromActivity(1).show(getFragmentManager(), null);
            }
            Log.e("DeliveryScheduling", (new StringBuilder()).append("onValidateTimeSlotComplete: mappedException: ").append(((EbayNowMappedException) (ebaynowvalidatetimeslotdatamanager)).errorId).append(", ").append(((EbayNowMappedException) (ebaynowvalidatetimeslotdatamanager)).message).toString());
            return;
        } else
        {
            ebaynowvalidatetimeslotdatamanager = new Intent();
            ebaynowvalidatetimeslotdatamanager.putExtra("params", params);
            ebaynowvalidatetimeslotdatamanager.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("Scheduler", "done"));
            ebaynowvalidatetimeslotdatamanager.putExtra("line_item", lineItem);
            setResult(-1, ebaynowvalidatetimeslotdatamanager);
            finish();
            return;
        }
    }
}
