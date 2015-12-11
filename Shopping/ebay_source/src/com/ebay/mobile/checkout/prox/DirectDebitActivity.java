// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.checkout.CheckoutError;
import java.io.IOException;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitTabFragmentAdapter, DirectDebitTabFragment

public final class DirectDebitActivity extends BaseCheckoutActivity
    implements android.widget.TabHost.OnTabChangeListener, DirectDebitTabFragment.EditDataListener
{

    private static final int ACTIVITY_RESULT_SEPA_CONFIRMATION = 1;
    public static final String EXTRA_FUNDING_INSTRUMENT_ID = "fundingInstrumentId";
    private static final String STATE_KEY_TAB = "tab";
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private boolean loadEditingDataWhenReady;
    private DirectDebitTabFragmentAdapter tabFragmentAdapter;
    private ViewPager tabFragmentPager;
    private TabHost tabHost;

    public DirectDebitActivity()
    {
        loadEditingDataWhenReady = false;
    }

    public String getTrackingEventName()
    {
        if (tabFragmentPager != null && tabFragmentPager.getCurrentItem() == 1)
        {
            return "DirectDebitIBAN";
        } else
        {
            return "DirectDebit";
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            setCheckoutResult(-1, null);
            finish();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onClearMaskedFields()
    {
        if (temporaryFundingInstrumentId != null)
        {
            DirectDebitTabFragment directdebittabfragment = (DirectDebitTabFragment)tabFragmentAdapter.getRegisteredFragment(0);
            if (directdebittabfragment != null)
            {
                directdebittabfragment.clearMaskedFields();
            }
            directdebittabfragment = (DirectDebitTabFragment)tabFragmentAdapter.getRegisteredFragment(0);
            if (directdebittabfragment != null)
            {
                directdebittabfragment.clearMaskedFields();
            }
            temporaryFundingInstrumentId = null;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301b1);
        tabHost = (TabHost)findViewById(0x1020012);
        tabHost.setup();
        Object obj = tabHost.getTabWidget();
        ((TabWidget) (obj)).setStripEnabled(false);
        tabFragmentAdapter = new DirectDebitTabFragmentAdapter(getFragmentManager());
        tabFragmentPager = (ViewPager)findViewById(0x7f1001f3);
        tabFragmentPager.setAdapter(tabFragmentAdapter);
        tabFragmentPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            final DirectDebitActivity this$0;

            public void onPageSelected(int j)
            {
                tabHost.setCurrentTab(j);
                tabFragmentPager.setCurrentItem(j, true);
            }

            
            {
                this$0 = DirectDebitActivity.this;
                super();
            }
        });
        LayoutInflater layoutinflater = LayoutInflater.from(this);
        View view = layoutinflater.inflate(0x7f030268, ((android.view.ViewGroup) (obj)), false);
        ((TextView)view.findViewById(0x7f10005f)).setText(0x7f0707f9);
        tabHost.addTab(tabHost.newTabSpec("tab0").setIndicator(view).setContent(0x1020004));
        tabHost.setOnTabChangedListener(this);
        obj = layoutinflater.inflate(0x7f030268, ((android.view.ViewGroup) (obj)), false);
        ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(0x7f070800);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(((View) (obj))).setContent(0x1020004));
        tabHost.setOnTabChangedListener(this);
        int i;
        if (bundle == null)
        {
            i = 0;
        } else
        {
            i = bundle.getInt("tab");
        }
        tabFragmentPager.setCurrentItem(i);
    }

    public void onError(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        boolean flag1 = false;
        if (isFinishing())
        {
            return;
        }
        enableProgressDialog(false, false);
        operation = dialogManager;
        String s = getString(0x7f070130);
        ioexception = CheckoutError.getConnectionError(getResources(), flag, ioexception);
        if (flag)
        {
            flag = flag1;
        } else
        {
            flag = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag);
    }

    public void onPartialFailure(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        String s = jsonmodel.getErrorId();
        operation = CheckoutError.mapCheckoutError(operation, s);
        if (operation == null)
        {
            jsonmodel = jsonmodel.getErrorMessage();
            if (jsonmodel != null)
            {
                operation = jsonmodel;
                if (!TextUtils.isEmpty(s))
                {
                    operation = (new StringBuilder()).append(jsonmodel).append(" (").append(s).append(")").toString();
                }
            } else
            {
                operation = getString(0x7f0707e2);
            }
            dialogManager.showDynamicAlertDialog(null, operation, false);
        } else
        {
            boolean flag = operation.shouldAbortOnError();
            if (flag)
            {
                setResult(503);
            }
            dialogManager.showDynamicAlertDialog(null, operation.getErrorString(this), flag);
        }
        enableProgressDialog(false, false);
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        setDoneButtonOnClickListener(new android.view.View.OnClickListener() {

            final DirectDebitActivity this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                ((DirectDebitTabFragment)tabFragmentAdapter.getRegisteredFragment(tabFragmentPager.getCurrentItem())).addOrUpdateFundingInstrumentFromFormData();
            }

            
            {
                this$0 = DirectDebitActivity.this;
                super();
            }
        });
        if (bundle == null)
        {
            bundle = getIntent().getStringExtra("fundingInstrumentId");
            if (bundle != null && !bundle.startsWith("TD_"))
            {
                apiGetFundingInstrument(bundle);
            }
        }
    }

    public void onReadyToReceiveEditData()
    {
        if (loadEditingDataWhenReady)
        {
            DirectDebitTabFragment directdebittabfragment = (DirectDebitTabFragment)tabFragmentAdapter.getRegisteredFragment(tabFragmentPager.getCurrentItem());
            if (directdebittabfragment != null)
            {
                directdebittabfragment.updateFormWithDirectDebit(directDebit);
            }
            enableProgressDialog(false, false);
            loadEditingDataWhenReady = false;
        }
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab", tabFragmentPager.getCurrentItem());
    }

    public void onSuccess(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation)
    {
        if (isFinishing())
        {
            return;
        }
        static class _cls3
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.ADD_DIRECT_DEBIT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.UPDATE_DIRECT_DEBIT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.GET_FUNDING_INSTRUMENT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            setCheckoutResult(-1, (new Intent()).putExtra("fundingInstrumentId", temporaryFundingInstrumentId));
            finish();
            return;

        case 3: // '\003'
            loadEditingDataWhenReady = true;
            break;
        }
        enableProgressDialog(false, false);
    }

    public void onTabChanged(String s)
    {
        int i = tabHost.getCurrentTab();
        tabFragmentPager.setCurrentItem(i);
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }



}
