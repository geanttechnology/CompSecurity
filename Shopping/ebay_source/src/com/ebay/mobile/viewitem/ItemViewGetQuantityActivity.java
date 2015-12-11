// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.util.Debug;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.ItemViewPayPalable;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.ErrorDialogActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.ui_stuff.ErrorHandling;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ItemViewActivity, ItemViewCommonProgressAndError, ViewItemDataManager, 
//            ViewItemConfirmActivity, ViewItemViewData, PpaUpgradeConfirmDialog

public class ItemViewGetQuantityActivity extends ItemViewBaseActivity
    implements TextWatcher, android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener, ViewItemDataManager.Observer
{

    private static final String PARAM_QUANTITY = "quantity";
    private static final String PARAM_USE_LONG_THRESHOLD = "useLongThreshold";
    private String bidSource;
    private int quantity;
    private String referrer;
    private Bundle savedInstanceState;
    private boolean useLongThreshold;

    public ItemViewGetQuantityActivity()
    {
        quantity = 0;
    }

    public static void StartActivity(Activity activity, ViewItemViewData viewitemviewdata, String s, String s1, boolean flag, int i)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/viewitem/ItemViewGetQuantityActivity);
        intent.putExtra("view_item_view_data", viewitemviewdata);
        intent.putExtra("com.ebay.mobile.tracking.Referrer", s);
        intent.putExtra("com.ebay.mobile.tracking.BidSource", s1);
        intent.putExtra("useLongThreshold", flag);
        activity.startActivityForResult(intent, i);
    }

    private void findTextViews(ViewGroup viewgroup, List list)
    {
        int j = viewgroup.getChildCount();
        int i = 0;
        while (i < j) 
        {
            View view = viewgroup.getChildAt(i);
            if (view instanceof ViewGroup)
            {
                findTextViews((ViewGroup)view, list);
            } else
            if (view instanceof TextView)
            {
                list.add((TextView)view);
            }
            i++;
        }
    }

    private void review()
    {
        Util.hideSoftInput(this, findViewById(0x7f10032b));
        if (validQuantity())
        {
            if (ItemViewPayPalable.canUseImmediatePayment(item))
            {
                if (ItemViewPayPalable.canUsePaypal(this, item))
                {
                    (new TrackingData("Autopay", TrackingType.EVENT)).send(this);
                    if (ItemViewActivity.payForItems(this, item, viewData, quantity, Boolean.valueOf(true), bidSource, referrer))
                    {
                        finish();
                    }
                    return;
                } else
                {
                    ErrorDialogActivity.StartActivity(this, getString(0x7f070130), getString(0x7f07017f), false);
                    return;
                }
            } else
            {
                startConfirmActivityStage1();
                return;
            }
        } else
        {
            ErrorHandling.invalid_quantity(this);
            return;
        }
    }

    private void setupButton(int i)
    {
        ((Button)findViewById(i)).setOnClickListener(this);
    }

    private void startConfirmActivityStage1()
    {
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        boolean flag1 = true;
        boolean flag = flag1;
        if (!item.isLocalPickupOnly)
        {
            com.ebay.nautilus.domain.data.PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
            flag = flag1;
            if (postalcodespecification != null)
            {
                flag = flag1;
                if (viewItemDataManager != null)
                {
                    viewItemDataManager.getShippingCosts(postalcodespecification, quantity, item.buyItNowPrice);
                    flag = false;
                }
            }
        }
        if (flag)
        {
            startConfirmActivityStage2();
        }
    }

    private void startConfirmActivityStage2()
    {
        com.ebay.nautilus.domain.data.ItemCurrency itemcurrency = item.currentPriceForType(getEbayContext(), viewData);
        ViewItemConfirmActivity.StartActivity(this, null, false, viewData, quantity, new CurrencyAmount(itemcurrency), true, referrer, bidSource, false, useLongThreshold, 12);
    }

    private boolean validQuantity()
    {
label0:
        {
            int i;
            int j;
            try
            {
                quantity = Integer.parseInt(getQuantity());
                if (quantity <= 0)
                {
                    break label0;
                }
                i = item.getQuantityAvailable(viewData.nameValueList);
                j = quantity;
            }
            catch (NumberFormatException numberformatexception)
            {
                return false;
            }
            if (i >= j)
            {
                return true;
            }
        }
        return false;
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    String getQuantity()
    {
        Object obj = findViewById(0x7f10032b);
        Class class1 = obj.getClass();
        try
        {
            class1.getMethod("clearFocus", new Class[0]).invoke(obj, new Object[0]);
            obj = class1.getMethod("getValue", new Class[0]).invoke(obj, new Object[0]).toString();
        }
        catch (Exception exception)
        {
            return null;
        }
        return ((String) (obj));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 12 12: default 20
    //                   12 45;
           goto _L1 _L2
_L1:
        if (503 == j || 504 == j)
        {
            setResult(j, intent);
            finish();
        }
        return;
_L2:
        if (-1 == j)
        {
            getWindow().setSoftInputMode(3);
            setResult(-1, intent);
            finish();
        } else
        if (502 == j)
        {
            setResult(0, intent);
            showDialog(0x7f0707aa);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClick(View view)
    {
        int i = view.getId();
        if (0x7f10013f == i)
        {
            startConfirmActivityStage1();
        } else
        {
            if (0x7f10015c == i)
            {
                finish();
                return;
            }
            if (0x7f10030a == i)
            {
                review();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        savedInstanceState = bundle;
        setContentView(0x7f03013c);
        setTitle(0x7f070055);
        setupButton(0x7f10013f);
        bundle = getIntent();
        viewData = (ViewItemViewData)bundle.getParcelableExtra("view_item_view_data");
        referrer = bundle.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = bundle.getStringExtra("com.ebay.mobile.tracking.BidSource");
        useLongThreshold = bundle.getBooleanExtra("useLongThreshold", false);
        initDataManagers();
    }

    protected Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 2131167146: 
            return PpaUpgradeConfirmDialog.create(this, false);
        }
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.SHIPPING_COSTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        if (!content.getStatus().hasError())
        {
            switch (_cls1..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                if (savedInstanceState == null)
                {
                    viewitemdatamanager = null;
                } else
                {
                    viewitemdatamanager = savedInstanceState.getString("quantity");
                }
                setupQuantityButton(viewitemdatamanager, item.getQuantityAvailable(viewData.nameValueList));
                headerStart(0x7f03012e);
                ((TextView)findViewById(0x7f100326)).setText(Item.getObfuscatedQuantityAvailable(this, item, viewData.kind, viewData.nameValueList));
                viewitemdatamanager = findViewById(0x7f10030a);
                viewitemdatamanager.setEnabled(validQuantity());
                viewitemdatamanager.setOnClickListener(this);
                return;

            case 2: // '\002'
                startConfirmActivityStage2();
                return;
            }
        } else
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
            setTakeActionButtonEnabled(this, false);
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
            return;
        }
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return false;

        case 6: // '\006'
            review();
            return false;

        case 5: // '\005'
            Util.hideSoftInput(this, findViewById(0x7f10032b));
            return false;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        if (Debug.logBidTracking.isLoggable)
        {
            FwLog.println(Debug.logBidTracking, (new StringBuilder()).append(com/ebay/mobile/viewitem/ItemViewGetQuantityActivity.getSimpleName()).append(" referrer:").append(referrer).append(" bidSource:").append(bidSource).toString());
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("quantity", getQuantity());
    }

    protected void onStop()
    {
        Util.hideSoftInput(this, findViewById(0x7f10032b));
        super.onStop();
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        boolean flag = validQuantity();
        findViewById(0x7f10030a).setEnabled(flag);
    }

    void setupQuantityButton(String s, int i)
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f10032b);
        Class class1 = viewgroup.getClass();
        ArrayList arraylist = new ArrayList();
        findTextViews(viewgroup, arraylist);
        for (int j = 0; j < arraylist.size(); j++)
        {
            ((TextView)arraylist.get(j)).setOnEditorActionListener(this);
        }

        try
        {
            class1.getMethod("setMinValue", new Class[] {
                Integer.TYPE
            }).invoke(viewgroup, new Object[] {
                Integer.valueOf(1)
            });
            class1.getMethod("setMaxValue", new Class[] {
                Integer.TYPE
            }).invoke(viewgroup, new Object[] {
                Integer.valueOf(i)
            });
            if (!TextUtils.isEmpty(s))
            {
                class1.getMethod("setValue", new Class[] {
                    Integer.TYPE
                }).invoke(viewgroup, new Object[] {
                    Integer.valueOf(Integer.parseInt(s))
                });
            }
            class1.getMethod("setWrapSelectorWheel", new Class[] {
                Boolean.TYPE
            }).invoke(viewgroup, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }
}
