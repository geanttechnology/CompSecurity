// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.http.Http;
import com.groupon.models.GenericAmount;
import com.groupon.models.OrderDetails;
import com.groupon.models.ResignationReason;
import com.groupon.models.cancel.CancelOrderContainer;
import com.groupon.models.cancel.CancelResponse;
import com.groupon.models.cancel.Deal;
import com.groupon.models.cancel.Option;
import com.groupon.models.cancel.ResignationResponse;
import com.groupon.models.order.detail.DealOption;
import com.groupon.models.order.detail.Order;
import com.groupon.models.order.detail.OrderContainer;
import com.groupon.service.LoginService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.DialogManager;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.view.SpinnerButton;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity, IntentFactory

public class CancelOrder extends GrouponActivity
    implements GrouponDialogListener
{
    private class CancelOrderHttp extends Http
    {

        private OrderDetails details;
        final CancelOrder this$0;

        public void onException(Exception exception)
        {
            Ln.e("Cancel Order request failed", new Object[] {
                exception.getMessage()
            });
            stopSpinner();
            showRetryDialog("cancel_order_retry_cancel_order_dialog");
        }

        protected void onPreExecute()
            throws Exception
        {
            super.onPreExecute();
            startSpinner();
        }

        public void onSuccess(CancelOrderContainer cancelordercontainer)
        {
            stopSpinner();
            executor.execute(new com.groupon.service.LoginService.ClearMyGrouponsRunnable(daoMyGrouponItem, daoMyGrouponItemSummary, daoPagination));
            showOrderCancelledSuccessDialog(details.getTitle(), details.getPrice());
        }

        public volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((CancelOrderContainer)obj);
        }

        public CancelOrderHttp(OrderDetails orderdetails, Object aobj[])
        {
            this$0 = CancelOrder.this;
            super(CancelOrder.this, com/groupon/models/cancel/CancelOrderContainer, String.format("https:/users/%s/orders/%s", new Object[] {
                userId, orderdetails.getId()
            }), aobj);
            details = orderdetails;
        }
    }

    private class DealDetailsHttp extends Http
    {

        final CancelOrder this$0;

        public void onException(Exception exception)
        {
            Ln.e("GET deal details for Cancel Order failed", new Object[] {
                exception.getMessage()
            });
            stopSpinner();
            showRetryDialog("cancel_order_retry_load_details_dialog");
        }

        protected void onPreExecute()
            throws Exception
        {
            super.onPreExecute();
            startSpinner();
        }

        public void onSuccess(CancelResponse cancelresponse)
        {
            cancelresponse = cancelresponse.deal.options.iterator();
            do
            {
                if (!cancelresponse.hasNext())
                {
                    break;
                }
                Option option = (Option)cancelresponse.next();
                if (!option.id.equals(optionId))
                {
                    continue;
                }
                minimumPurchaseQuantity = option.minimumPurchaseQuantity;
                optionTitle = option.title;
                (new GetOrderDetailsHttp()).method("GET").execute();
                break;
            } while (true);
        }

        public volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((CancelResponse)obj);
        }

        public DealDetailsHttp(String s, Object aobj[])
        {
            this$0 = CancelOrder.this;
            super(CancelOrder.this, com/groupon/models/cancel/CancelResponse, String.format("https:/deals/%s", new Object[] {
                s
            }), aobj);
        }
    }

    private class GetCancelReasonsHttp extends Http
    {

        final CancelOrder this$0;

        public void onException(Exception exception)
        {
            Ln.e("GET request for Cancel Order Reasons failed", new Object[] {
                exception.getMessage()
            });
            stopSpinner();
            showErrorDialog();
        }

        public void onSuccess(ResignationResponse resignationresponse)
        {
            reasonListResponse = resignationresponse;
            populateReasonsList(resignationresponse);
        }

        public volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((ResignationResponse)obj);
        }

        public GetCancelReasonsHttp()
        {
            this$0 = CancelOrder.this;
            super(CancelOrder.this, com/groupon/models/cancel/ResignationResponse, "https:/resignation_reasons");
        }
    }

    private class GetOrderDetailsHttp extends Http
    {

        final CancelOrder this$0;

        public void onException(Exception exception)
        {
            Ln.e("GET order details for Cancel Order failed", new Object[] {
                exception.getMessage()
            });
            stopSpinner();
            showRetryDialog("cancel_order_retry_load_details_dialog");
        }

        protected void onPreExecute()
            throws Exception
        {
            super.onPreExecute();
            startSpinner();
        }

        public void onSuccess(OrderContainer ordercontainer)
        {
            ordercontainer = ordercontainer.order;
            GenericAmount genericamount = ((Order) (ordercontainer)).dealOption.price;
            currentOrderQuantity = ((Order) (ordercontainer)).quantity;
            formattedAmount = genericamount.getFormattedAmount();
            ordercontainer = CancelOrder.this;
            boolean flag;
            if (currentOrderQuantity <= minimumPurchaseQuantity)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ordercontainer.minimumQuantityReached = flag;
            if (currentOrderQuantity > 1 && minimumQuantityReached)
            {
                stopSpinner();
                showMinimumQuantityDialog();
                return;
            } else
            {
                cancelOrder();
                return;
            }
        }

        public volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((OrderContainer)obj);
        }

        public GetOrderDetailsHttp()
        {
            this$0 = CancelOrder.this;
            super(CancelOrder.this, com/groupon/models/order/detail/OrderContainer, String.format("https:/users/%s/orders/%s", new Object[] {
                userId, orderId
            }));
        }
    }

    private class OnConfirmCancellationListener
        implements android.view.View.OnClickListener
    {

        final CancelOrder this$0;

        public void onClick(View view)
        {
            int i = reasonsRadioGroup.getCheckedRadioButtonId();
            if (((RadioButton)reasonsRadioGroup.findViewById(i)).getText().equals("Other") && Strings.isEmpty(otherDescription.getText().toString()))
            {
                showEmptyOtherReasonDialog();
                return;
            } else
            {
                showConfirmDialog();
                return;
            }
        }

        private OnConfirmCancellationListener()
        {
            this$0 = CancelOrder.this;
            super();
        }

    }

    private class ShowCancelOrderButton
        implements android.widget.RadioGroup.OnCheckedChangeListener
    {

        final CancelOrder this$0;

        public void onCheckedChanged(RadioGroup radiogroup, int i)
        {
            cancelOrderButton.setVisibility(0);
        }

        private ShowCancelOrderButton()
        {
            this$0 = CancelOrder.this;
            super();
        }

    }

    private class ToggleOtherDesciptionVisibilityOnCheckedChangeListener
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final CancelOrder this$0;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            compoundbutton = (InputMethodManager)getSystemService("input_method");
            if (flag)
            {
                otherDescription.setVisibility(0);
                otherDescription.requestFocus();
                compoundbutton.showSoftInput(otherDescription, 0);
                return;
            } else
            {
                otherDescription.setVisibility(8);
                compoundbutton.hideSoftInputFromWindow(otherDescription.getWindowToken(), 0);
                return;
            }
        }

        private ToggleOtherDesciptionVisibilityOnCheckedChangeListener()
        {
            this$0 = CancelOrder.this;
            super();
        }

    }


    private static final String CANCEL_ORDER_CONFIRM_DIALOG = "cancel_order_confirm_dialog";
    private static final String CANCEL_ORDER_ERROR_DIALOG = "cancel_order_error_dialog";
    private static final String CANCEL_ORDER_MINIMUM_QUANTITY_DIALOG = "cancel_order_minimum_quantity_dialog";
    private static final String CANCEL_ORDER_OTHER_REASON_EMPTY_DIALOG = "cancel_order_other_reason_empty_dialog";
    private static final String CANCEL_ORDER_RETRY_CANCEL_ORDER_DIALOG = "cancel_order_retry_cancel_order_dialog";
    private static final String CANCEL_ORDER_RETRY_LOAD_DETAILS_DIALOG = "cancel_order_retry_load_details_dialog";
    private static final String CANCEL_ORDER_SUCCESS_DIALOG = "cancel_order_success_dialog";
    public static final int REQUEST_CODE = 10146;
    String CANCEL_ORDER_ACTION_BAR_TITLE;
    String CANCEL_ORDER_SUCCESS_DIALOG_TITLE;
    String CANCEL_ORDER_SUCCESS_MESSAGE_FORMAT;
    String CANCEL_ORDER_SUCCESS_QUANTITY_MESSAGE_FORMAT;
    String OK;
    String OTHER_REASON_EMPTY_DIALOG_BODY;
    String OTHER_REASON_EMPTY_DIALOG_TITLE;
    SpinnerButton cancelOrderButton;
    private int currentOrderQuantity;
    private DaoMyGrouponItem daoMyGrouponItem;
    private DaoMyGrouponItemSummary daoMyGrouponItemSummary;
    private DaoPagination daoPagination;
    String dealId;
    private DeviceInfoUtil deviceInfoUtil;
    private DialogManager dialogManager;
    private String formattedAmount;
    boolean fromThankYouScreen;
    private IntentFactory intentFactory;
    private Logger logger;
    private LoginService loginService;
    private int minimumPurchaseQuantity;
    private boolean minimumQuantityReached;
    private ObjectMapperWrapper objectMapper;
    String optionId;
    private String optionTitle;
    String orderId;
    EditText otherDescription;
    private List radioButtonsList;
    private int radioSelection;
    private ResignationResponse reasonListResponse;
    RadioGroup reasonsRadioGroup;
    private String userId;

    public CancelOrder()
    {
        radioSelection = -1;
        currentOrderQuantity = 0;
        minimumQuantityReached = false;
    }

    private void showConfirmDialog()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(Integer.valueOf(0x7f080087), Integer.valueOf(0x7f080086), Integer.valueOf(0x7f080426), Integer.valueOf(0x7f0802a6), false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "cancel_order_confirm_dialog");
    }

    private void showEmptyOtherReasonDialog()
    {
        GrouponDialogFragment groupondialogfragment = new GrouponDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("dialog_title", OTHER_REASON_EMPTY_DIALOG_TITLE);
        bundle.putString("dialog_message", OTHER_REASON_EMPTY_DIALOG_BODY);
        bundle.putString("dialog_positive_button_text", OK);
        groupondialogfragment.setArguments(bundle);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "cancel_order_other_reason_empty_dialog");
    }

    private void showErrorDialog()
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(Integer.valueOf(0x7f08008b), Integer.valueOf(0x7f08008a), Integer.valueOf(0x7f080420), Integer.valueOf(0x7f080084), false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, "cancel_order_error_dialog");
    }

    private void showMinimumQuantityDialog()
    {
        Object obj = getString(0x7f08008d, new Object[] {
            Integer.valueOf(minimumPurchaseQuantity)
        });
        String s = getString(0x7f08008c, new Object[] {
            Integer.valueOf(minimumPurchaseQuantity)
        });
        obj = dialogManager.getDialogFragment(obj, s, Integer.valueOf(0x7f080426), Integer.valueOf(0x7f0802a6), false);
        GrouponDialogFragment.show(getFragmentManager(), ((GrouponDialogFragment) (obj)), "cancel_order_minimum_quantity_dialog");
    }

    private void showOrderCancelledSuccessDialog(String s, String s1)
    {
        Bundle bundle;
        if (minimumPurchaseQuantity > 1 && minimumQuantityReached)
        {
            s = String.format(CANCEL_ORDER_SUCCESS_QUANTITY_MESSAGE_FORMAT, new Object[] {
                s1, s, Integer.valueOf(minimumPurchaseQuantity)
            });
        } else
        {
            s = String.format(CANCEL_ORDER_SUCCESS_MESSAGE_FORMAT, new Object[] {
                s1, s
            });
        }
        s1 = new GrouponDialogFragment();
        bundle = new Bundle();
        bundle.putString("dialog_title", CANCEL_ORDER_SUCCESS_DIALOG_TITLE);
        bundle.putString("dialog_message", s);
        bundle.putString("dialog_positive_button_text", OK);
        s1.setArguments(bundle);
        s1.setCancelable(false);
        GrouponDialogFragment.show(getFragmentManager(), s1, "cancel_order_success_dialog");
    }

    private void showRetryDialog(String s)
    {
        GrouponDialogFragment groupondialogfragment = dialogManager.getDialogFragment(Integer.valueOf(0x7f08008b), Integer.valueOf(0x7f08008a), Integer.valueOf(0x7f080420), Integer.valueOf(0x7f080084), false);
        GrouponDialogFragment.show(getFragmentManager(), groupondialogfragment, s);
    }

    private void startSpinner()
    {
        cancelOrderButton.startSpinning();
        for (int i = 0; i < reasonsRadioGroup.getChildCount(); i++)
        {
            reasonsRadioGroup.getChildAt(i).setEnabled(false);
        }

    }

    private void stopSpinner()
    {
        cancelOrderButton.stopSpinning();
        for (int i = 0; i < reasonsRadioGroup.getChildCount(); i++)
        {
            reasonsRadioGroup.getChildAt(i).setEnabled(true);
        }

    }

    protected void cancelOrder()
    {
        OrderDetails orderdetails = new OrderDetails(orderId, optionTitle, currentOrderQuantity, formattedAmount);
        ArrayList arraylist = getOrderDetailsRequestParams();
        String s;
        if (orderdetails.getQuantity() > 1 && !minimumQuantityReached)
        {
            int i = orderdetails.getQuantity() - 1;
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "quantity", Integer.valueOf(i)
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "update_reason", "Cancel order"
            }));
            arraylist.addAll(Arrays.asList(new String[] {
                "update_comments", (new StringBuilder()).append("Remaining quantity").append(i).toString()
            }));
            s = "PUT";
        } else
        {
            s = "DELETE";
        }
        (new CancelOrderHttp(orderdetails, arraylist.toArray())).method(s).execute();
    }

    protected ArrayList getOrderDetailsRequestParams()
    {
        if (radioButtonsList == null || radioButtonsList.size() == 0)
        {
            return null;
        }
        int i = reasonsRadioGroup.getCheckedRadioButtonId();
        Object obj = (RadioButton)reasonsRadioGroup.findViewById(i);
        String s = (String)((RadioButton) (obj)).getTag();
        boolean flag = Strings.equals(((RadioButton) (obj)).getText(), "Other");
        obj = new ArrayList();
        ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
            "deal_id", dealId
        }));
        ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
            "resignation_reason_id", s
        }));
        if (flag)
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                "other_comments", otherDescription.getText().toString()
            }));
        }
        if (flag)
        {
            logger.logClick("", "cancel_other_reason_done", "cancel_order", dealId);
            return ((ArrayList) (obj));
        } else
        {
            s = String.format("%s,%s", new Object[] {
                s, dealId
            });
            logger.logClick("", "cancel_order_cause_click", "cancel_order", s);
            return ((ArrayList) (obj));
        }
    }

    protected int getRadioSelectionIndex()
    {
        int i = reasonsRadioGroup.getCheckedRadioButtonId();
        RadioButton radiobutton = (RadioButton)reasonsRadioGroup.findViewById(i);
        return reasonsRadioGroup.indexOfChild(radiobutton);
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(CANCEL_ORDER_ACTION_BAR_TITLE);
    }

    protected void loadCancelOrderReasonsList()
    {
        (new GetCancelReasonsHttp()).method("GET").execute();
    }

    protected void loadRequiredDetails()
    {
        startSpinner();
        (new DealDetailsHttp(dealId, null)).method("GET").execute();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030058);
        userId = loginService.getUserId();
        cancelOrderButton.setOnClickListener(new OnConfirmCancellationListener());
        reasonsRadioGroup.setOnCheckedChangeListener(new ShowCancelOrderButton());
        if (bundle != null)
        {
            radioSelection = bundle.getInt("reason_selected_key");
            bundle = bundle.getString("reason_list_response", null);
            float f;
            int i;
            int j;
            int k;
            if (Strings.notEmpty(bundle))
            {
                try
                {
                    reasonListResponse = (ResignationResponse)objectMapper.readValue(bundle, com/groupon/models/cancel/ResignationResponse);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Ln.e(bundle, "Impossible to read saved reason list from previous instance.", new Object[0]);
                }
            }
        }
        if (reasonListResponse != null)
        {
            populateReasonsList(reasonListResponse);
        } else
        {
            loadCancelOrderReasonsList();
        }
        f = deviceInfoUtil.getDensity();
        i = (int)(5F * f + 0.5F);
        j = (int)(12F * f + 0.5F);
        k = (int)(15F * f + 0.5F);
        otherDescription.setPadding(j, i, j, k);
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
        if (Strings.equals(s, "cancel_order_error_dialog"))
        {
            finish();
        }
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
        if (s.equals("cancel_order_confirm_dialog"))
        {
            loadRequiredDetails();
            logger.logClick("", "confirm_cancellation_click", "cancel_order", dealId);
        } else
        {
            if (s.equals("cancel_order_success_dialog"))
            {
                if (fromThankYouScreen)
                {
                    startActivity(intentFactory.newDealIntentWithActivityClearTop(dealId, optionId));
                    return;
                } else
                {
                    startActivity(intentFactory.newMyGrouponIntentActivityClearTop(true));
                    return;
                }
            }
            if (s.equals("cancel_order_retry_cancel_order_dialog"))
            {
                cancelOrder();
                return;
            }
            if (s.equals("cancel_order_retry_load_details_dialog"))
            {
                loadRequiredDetails();
                return;
            }
            if (s.equals("cancel_order_error_dialog"))
            {
                loadCancelOrderReasonsList();
                return;
            }
            if (s.equals("cancel_order_minimum_quantity_dialog"))
            {
                cancelOrder();
                return;
            }
        }
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("reason_selected_key", getRadioSelectionIndex());
        if (reasonListResponse != null)
        {
            try
            {
                bundle.putString("reason_list_response", objectMapper.writeValueAsString(reasonListResponse));
            }
            catch (IOException ioexception)
            {
                Ln.e(ioexception, "Impossible to persist the reason list for future instance.", new Object[0]);
            }
        }
        super.onSaveInstanceState(bundle);
    }

    protected void populateReasonsList(ResignationResponse resignationresponse)
    {
        reasonListResponse = resignationresponse;
        radioButtonsList = new ArrayList();
        if (resignationresponse == null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = null;
        resignationresponse = resignationresponse.resignationReasons;
        if (resignationresponse != null && !resignationresponse.isEmpty()) goto _L4; else goto _L3
_L3:
        stopSpinner();
        showErrorDialog();
_L6:
        return;
_L4:
        LayoutInflater layoutinflater = getLayoutInflater();
        Iterator iterator = resignationresponse.iterator();
        resignationresponse = obj;
        while (iterator.hasNext()) 
        {
            ResignationReason resignationreason = (ResignationReason)iterator.next();
            RadioButton radiobutton = (RadioButton)layoutinflater.inflate(0x7f0301b9, null);
            radiobutton.setText(resignationreason.resignationReason);
            radiobutton.setTag(resignationreason.uuid);
            if (radiobutton.getText().equals("Other"))
            {
                resignationresponse = radiobutton;
            } else
            {
                reasonsRadioGroup.addView(radiobutton, -1, -2);
                radioButtonsList.add(radiobutton);
            }
        }
        if (resignationresponse != null)
        {
            resignationresponse.setOnCheckedChangeListener(new ToggleOtherDesciptionVisibilityOnCheckedChangeListener());
            reasonsRadioGroup.addView(resignationresponse, -1, -2);
            radioButtonsList.add(resignationresponse);
        }
_L2:
        if (radioSelection >= 0)
        {
            ((RadioButton)radioButtonsList.get(radioSelection)).setChecked(true);
            cancelOrderButton.setVisibility(0);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }


/*
    static String access$1002(CancelOrder cancelorder, String s)
    {
        cancelorder.optionTitle = s;
        return s;
    }

*/









/*
    static int access$1702(CancelOrder cancelorder, int i)
    {
        cancelorder.currentOrderQuantity = i;
        return i;
    }

*/


/*
    static String access$1802(CancelOrder cancelorder, String s)
    {
        cancelorder.formattedAmount = s;
        return s;
    }

*/



/*
    static boolean access$1902(CancelOrder cancelorder, boolean flag)
    {
        cancelorder.minimumQuantityReached = flag;
        return flag;
    }

*/





/*
    static ResignationResponse access$502(CancelOrder cancelorder, ResignationResponse resignationresponse)
    {
        cancelorder.reasonListResponse = resignationresponse;
        return resignationresponse;
    }

*/






/*
    static int access$902(CancelOrder cancelorder, int i)
    {
        cancelorder.minimumPurchaseQuantity = i;
        return i;
    }

*/
}
