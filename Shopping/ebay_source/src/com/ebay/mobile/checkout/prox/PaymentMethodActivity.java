// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.CartPaymentMethods;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.checkout.BaseCheckoutActivity;
import com.ebay.mobile.checkout.CheckoutError;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public final class PaymentMethodActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener
{

    private static final String EXTRA_FINISH_AFTER_UPDATE = "finishAfterUpdate";
    public static final String EXTRA_SELECTED_METHOD = "paymentMethodSelected";
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private boolean finishAfterUpdate;
    private View selectedMenuItem;

    public PaymentMethodActivity()
    {
    }

    private void addOtherPaymentOptionRow(ViewGroup viewgroup, boolean flag, String s)
    {
        View view = LayoutInflater.from(this).inflate(0x7f0302ce, viewgroup, false);
        TextView textview = (TextView)view.findViewById(0x7f10053a);
        textview.setText(getSelectorNameForPaymentMethod(s));
        view.findViewById(0x7f1009a0).setVisibility(8);
        view.setTag(s);
        viewgroup.addView(view);
        if (flag)
        {
            textview.setEnabled(false);
            view.setEnabled(false);
            return;
        } else
        {
            textview.setEnabled(true);
            view.setEnabled(true);
            view.setOnClickListener(this);
            return;
        }
    }

    private boolean hasIneligibleEbayPlusPaymentMethods()
    {
        return isEftAvailable() || isCopAvailable();
    }

    private void renderPaymentMethodChoices()
    {
        boolean flag1 = true;
        boolean flag2 = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
        boolean flag3 = cart.hasEbayPlusItem();
        boolean flag;
        if (flag3 && flag2 && hasIneligibleEbayPlusPaymentMethods())
        {
            findViewById(0x7f100528).setVisibility(0);
        } else
        {
            findViewById(0x7f100528).setVisibility(8);
        }
        findViewById(0x7f100529).setVisibility(0);
        findViewById(0x7f100531).setVisibility(8);
        setStateForClickableView(0x7f10052b, false, isPayPalAvailable());
        setStateForClickableView(0x7f10052c, false, isPuiAvailable());
        setStateForClickableView(0x7f10052d, false, isDirectDebitAvailable());
        setStateForClickableView(0x7f10052e, false, isCreditCardAvailable());
        if (flag3 && flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setStateForClickableView(0x7f10052f, flag, isEftAvailable());
        if (flag3 && flag2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setStateForClickableView(0x7f100530, flag, isCopAvailable());
    }

    private void renderPaymentMethodOptions()
    {
        boolean flag = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
        boolean flag1 = cart.hasEbayPlusItem();
        Object obj;
        ViewGroup viewgroup;
        Object obj1;
        TextView textview;
        if (flag1 && flag && hasIneligibleEbayPlusPaymentMethods())
        {
            findViewById(0x7f100528).setVisibility(0);
        } else
        {
            findViewById(0x7f100528).setVisibility(8);
        }
        findViewById(0x7f100529).setVisibility(8);
        findViewById(0x7f100531).setVisibility(0);
        obj1 = (ImageView)findViewById(0x7f100533);
        textview = (TextView)findViewById(0x7f100532);
        viewgroup = (ViewGroup)findViewById(0x7f100534);
        obj = cart.cartPaymentMethods.getSelectedPaymentMethod();
        viewgroup.removeAllViews();
        if (((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).isPayPal())
        {
            ((ImageView) (obj1)).setVisibility(0);
            textview.setVisibility(8);
            setupPayPalSelectedOptionRows(viewgroup, ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)));
        } else
        {
            ((ImageView) (obj1)).setVisibility(8);
            textview.setVisibility(0);
            textview.setText(getSelectorNameForPaymentMethod(selectedPaymentMethod));
            obj1 = (ViewGroup)LayoutInflater.from(this).inflate(0x7f0301b7, viewgroup, false);
            if (((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).isCreditCard() || ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).isDirectDebit())
            {
                obj = getDisplayStringForPaymentInstrument(((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).getPaymentInstrument()).toString();
            } else
            {
                obj = getSelectorNameForPaymentMethod(selectedPaymentMethod);
            }
            setupOptionRow(((ViewGroup) (obj1)), formatFundingSourceDetailText(((String) (obj)), EbayCurrencyUtil.formatDisplay(cart.total, 2), true), null, null);
            viewgroup.addView(((View) (obj1)));
            if ("CreditCard".equals(selectedPaymentMethod) || "DirectDebit".equals(selectedPaymentMethod) || "PayUponInvoice".equals(selectedPaymentMethod))
            {
                ((ViewGroup) (obj1)).setOnClickListener(this);
            }
        }
        obj = (ViewGroup)findViewById(0x7f100536);
        if (paymentMethodCount == 1)
        {
            ((ViewGroup) (obj)).setVisibility(8);
            return;
        } else
        {
            View view = LayoutInflater.from(this).inflate(0x7f0302cd, ((ViewGroup) (obj)), false);
            ((TextView)view.findViewById(0x7f10099d)).setText(getString(0x7f070c4b));
            view.setTag(Boolean.FALSE);
            ((ViewGroup) (obj)).removeAllViews();
            ((ViewGroup) (obj)).addView(view);
            view.setOnClickListener(this);
            view.setTag(Boolean.TRUE);
            toggleExpandOrCollapseOfOtherMethods(flag1, flag);
            return;
        }
    }

    private void setResultStatus()
    {
        Intent intent = new Intent();
        intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName()));
        setCheckoutResult(-1, intent);
    }

    private void setStateForClickableView(int i, boolean flag, boolean flag1)
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(i);
        if (flag1)
        {
            viewgroup.setVisibility(0);
            if (flag)
            {
                ((TextView)viewgroup.getChildAt(0)).setEnabled(false);
                viewgroup.setEnabled(false);
                return;
            } else
            {
                viewgroup.setOnClickListener(this);
                return;
            }
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    private void setupOptionRow(ViewGroup viewgroup, CharSequence charsequence, Boolean boolean1, String s)
    {
        ((TextView)viewgroup.findViewById(0x7f10053a)).setText(charsequence);
        charsequence = (CheckBox)viewgroup.findViewById(0x7f10053b);
        if (boolean1 != null)
        {
            charsequence.setChecked(boolean1.booleanValue());
            charsequence.setVisibility(0);
        } else
        {
            charsequence.setVisibility(4);
        }
        viewgroup = (TextView)viewgroup.findViewById(0x7f10053c);
        if (s != null)
        {
            viewgroup.setText(s);
            viewgroup.setVisibility(0);
            return;
        } else
        {
            viewgroup.setVisibility(8);
            return;
        }
    }

    private void setupPayPalSelectedOptionRows(ViewGroup viewgroup, com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod paymentmethod)
    {
        Object obj;
        LayoutInflater layoutinflater;
        layoutinflater = LayoutInflater.from(this);
        obj = paymentmethod.getFixedFundingComponents();
        if (!((List) (obj)).isEmpty() && obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj2 = (com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice)((Iterator) (obj)).next();
                if (obj2 != null)
                {
                    obj2 = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice) (obj2)).getFundingSource();
                    if (obj2 != null)
                    {
                        ViewGroup viewgroup1 = (ViewGroup)layoutinflater.inflate(0x7f0301b7, viewgroup, false);
                        setupOptionRow(viewgroup1, formatFundingSourceDetailText(getDisplayStringForPayPalFundingSource(((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource) (obj2))), EbayCurrencyUtil.formatDisplay(((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource) (obj2)).getAmount(), 2), true), null, getString(0x7f07080e));
                        viewgroup.addView(viewgroup1);
                    }
                }
            } while (true);
        }
        obj = paymentmethod.getStrategyChoices();
        if (obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = ((List) (obj)).iterator();
_L4:
        if (iterator.hasNext())
        {
            com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice strategychoice = (com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice)iterator.next();
            ViewGroup viewgroup2 = (ViewGroup)layoutinflater.inflate(0x7f0301b7, viewgroup, false);
            com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.FundingStrategy.StrategyChoice.FundingSource fundingsource = strategychoice.getFundingSource();
            if (strategychoice.isSelected())
            {
                CharSequence charsequence = formatFundingSourceDetailText(getDisplayStringForPayPalFundingSource(fundingsource), EbayCurrencyUtil.formatDisplay(fundingsource.getAmount(), 2), true);
                if (paymentmethod.paidCompletelyByPayPalBalance())
                {
                    setupOptionRow(viewgroup2, charsequence, null, getString(0x7f07080f));
                } else
                {
                    setupOptionRow(viewgroup2, charsequence, Boolean.valueOf(true), null);
                }
            } else
            {
                String s = getDisplayStringForPayPalFundingSource(fundingsource);
                Object obj1 = s;
                if (fundingsource != null)
                {
                    obj1 = s;
                    if (fundingsource.getAmount() != null)
                    {
                        obj1 = formatFundingSourceDetailText(s.toString(), null, true);
                    }
                }
                setupOptionRow(viewgroup2, ((CharSequence) (obj1)), Boolean.valueOf(false), null);
            }
            viewgroup2.setTag(strategychoice.getStrategyChoiceId());
            viewgroup.addView(viewgroup2);
            if (!strategychoice.isSelected())
            {
                viewgroup2.setOnClickListener(this);
            }
            continue; /* Loop/switch isn't completed */
        }
_L2:
        paymentmethod = (ViewGroup)layoutinflater.inflate(0x7f0301b6, viewgroup, false);
        viewgroup.addView(paymentmethod);
        paymentmethod.setOnClickListener(this);
        registerForContextMenu(paymentmethod);
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showIncentivesRequirePayPalAlert()
    {
        String s;
        int i;
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            i = 0x7f070c38;
        } else
        {
            i = 0x7f0700ea;
        }
        s = getString(i);
        dialogManager.showDynamicAlertDialog(getString(0x7f070c39), s, false);
    }

    private void toggleExpandOrCollapseOfOtherMethods(boolean flag, boolean flag1)
    {
        boolean flag3 = true;
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100536);
        View view = findViewById(0x7f10099c);
        Object obj = (Boolean)view.getTag();
        Boolean boolean1 = ((Boolean) (obj));
        if (obj == null)
        {
            boolean1 = Boolean.FALSE;
        }
        obj = (ImageView)view.findViewById(0x7f10099e);
        int i;
        if (boolean1.booleanValue())
        {
            i = 0x7f020252;
        } else
        {
            i = 0x7f020256;
        }
        ((ImageView) (obj)).setImageResource(i);
        if (boolean1.booleanValue())
        {
            obj = Boolean.FALSE;
        } else
        {
            obj = Boolean.TRUE;
        }
        view.setTag(obj);
        if (!boolean1.booleanValue())
        {
            if (isPayPalAvailable() && !"PayPal".equals(selectedPaymentMethod))
            {
                addOtherPaymentOptionRow(viewgroup, false, "PayPal");
            }
            if (isDirectDebitAvailable() && !"DirectDebit".equals(selectedPaymentMethod))
            {
                addOtherPaymentOptionRow(viewgroup, false, "DirectDebit");
            }
            if (isCreditCardAvailable() && !"CreditCard".equals(selectedPaymentMethod))
            {
                addOtherPaymentOptionRow(viewgroup, false, "CreditCard");
            }
            if (isPuiAvailable() && !"PayUponInvoice".equals(selectedPaymentMethod))
            {
                addOtherPaymentOptionRow(viewgroup, false, "PayUponInvoice");
            }
            if (isEftAvailable() && !"MoneyXferAcceptedInCheckout".equals(selectedPaymentMethod))
            {
                final ScrollView scroll;
                boolean flag2;
                if (flag && flag1)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                addOtherPaymentOptionRow(viewgroup, flag2, "MoneyXferAcceptedInCheckout");
            }
            if (isCopAvailable() && !"CashOnPickup".equals(selectedPaymentMethod))
            {
                if (flag && flag1)
                {
                    flag = flag3;
                } else
                {
                    flag = false;
                }
                addOtherPaymentOptionRow(viewgroup, flag, "CashOnPickup");
            }
            scroll = (ScrollView)findViewById(0x7f100527);
            scroll.postDelayed(new Runnable() {

                final PaymentMethodActivity this$0;
                final ScrollView val$scroll;

                public void run()
                {
                    scroll.smoothScrollTo(0, scroll.getBottom());
                }

            
            {
                this$0 = PaymentMethodActivity.this;
                scroll = scrollview;
                super();
            }
            }, 250L);
        } else
        {
            int j = viewgroup.getChildCount();
            while (j > 1) 
            {
                viewgroup.removeViewAt(1);
                j--;
            }
        }
    }

    private boolean triggerSepaMandateFlow()
    {
        if ("DirectDebit".equals(selectedPaymentMethod))
        {
            Object obj = cart.cartPaymentMethods.getSelectedPaymentMethod();
            if (obj != null)
            {
                obj = ((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod) (obj)).getPaymentAgreement();
                if (obj != null && !((com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument.PaymentAgreement) (obj)).isAccepted())
                {
                    startProxFlowForPaymentType(selectedPaymentMethod, "PaymentAgreementMandate");
                    setResultStatus();
                    return true;
                }
            }
        }
        return false;
    }

    private void updateUi()
    {
        enableProgressDialog(false, false);
        if (!cart.isPaymentInstrumentSelected() || selectedPaymentMethod == null)
        {
            renderPaymentMethodChoices();
            return;
        } else
        {
            renderPaymentMethodOptions();
            return;
        }
    }

    private boolean userHasIncentivesAndDisplayAlert()
    {
        List list = cart.getIncentives();
        if (list != null && list.size() > 0)
        {
            showIncentivesRequirePayPalAlert();
            return true;
        } else
        {
            return false;
        }
    }

    protected String getSelectorNameForPaymentMethod(String s)
    {
        if ("MoneyXferAcceptedInCheckout".equals(s))
        {
            return getString(0x7f070c51);
        }
        if ("CashOnPickup".equals(s))
        {
            return getString(0x7f070c4d);
        }
        if ("DirectDebit".equals(s))
        {
            return getString(0x7f070c50);
        }
        if ("CreditCard".equals(s))
        {
            return getString(0x7f070c4f);
        }
        if ("PayPal".equals(s))
        {
            return getString(0x7f070c52);
        }
        if ("PayUponInvoice".equals(s))
        {
            return getString(0x7f070c53);
        } else
        {
            return null;
        }
    }

    public String getTrackingEventName()
    {
        return "PaymentMethod";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 7821746 7821751: default 48
    //                   7821746 49
    //                   7821747 182
    //                   7821748 204
    //                   7821749 278
    //                   7821750 48
    //                   7821751 230;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6
_L6:
        break MISSING_BLOCK_LABEL_230;
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_278;
_L7:
        return;
_L2:
        if (j == -1)
        {
            finishAfterUpdate = true;
            if (intent == null)
            {
                intent = null;
            } else
            {
                intent = intent.getStringExtra("payPalLinkId");
            }
            if (intent != null)
            {
                apiSetPaymentInstrument("PayPal", intent, null);
                return;
            } else
            {
                finishAfterUpdate = false;
                apiResetPaymentInstrument();
                return;
            }
        }
        if (j == 1)
        {
            MyApp.signOutForIafTokenFailure(this);
            finish();
            return;
        }
        if (j == 2)
        {
            enableProgressDialog(false, false);
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070c07), false);
            return;
        }
        if (j == 3)
        {
            enableProgressDialog(false, false);
            dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070814), false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            finishAfterUpdate = true;
            apiSetPaymentInstrument("CreditCard", temporaryFundingInstrumentId, null);
            return;
        }
        if (true) goto _L7; else goto _L4
_L4:
        if (j == -1)
        {
            finishAfterUpdate = true;
            apiSetPaymentInstrument("DirectDebit", temporaryFundingInstrumentId, null);
        }
        updateUi();
        return;
        if (j == -1 && intent != null)
        {
            Calendar calendar = (Calendar)intent.getSerializableExtra("dob");
            intent = intent.getStringExtra("addressId");
            finishAfterUpdate = true;
            apiSetPayUponInvoice("PayUponInvoice", calendar, intent);
        }
        updateUi();
        return;
        if (j == -1)
        {
            finishAfterUpdate = true;
            apiAgreeToPaymentAgreement();
            return;
        } else
        {
            startProxFlowForPaymentType("DirectDebit", null);
            return;
        }
    }

    public void onBackPressed()
    {
        setResultStatus();
        finish();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 10: default 96
    //                   2131756331: 97
    //                   2131756332: 124
    //                   2131756333: 108
    //                   2131756334: 116
    //                   2131756335: 132
    //                   2131756336: 147
    //                   2131756343: 293
    //                   2131756344: 162
    //                   2131757468: 299
    //                   2131757471: 322;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        return;
_L2:
        startProxFlowForPaymentType("PayPal", "SelectPaymentInstrument");
        return;
_L4:
        startProxFlowForPaymentType("DirectDebit", null);
        return;
_L5:
        startProxFlowForPaymentType("CreditCard", null);
        return;
_L3:
        startProxFlowForPaymentType("PayUponInvoice", null);
        return;
_L6:
        finishAfterUpdate = true;
        apiSetPaymentInstrument("MoneyXferAcceptedInCheckout", null, null);
        return;
_L7:
        finishAfterUpdate = true;
        apiSetPaymentInstrument("CashOnPickup", null, null);
        return;
_L9:
        com.ebay.common.model.cart.CartPaymentMethods.PaymentMethod.PaymentInstrument paymentinstrument;
        paymentinstrument = cart.cartPaymentMethods.getSelectedPaymentMethod().getPaymentInstrument();
        if (!"PayPal".equals(selectedPaymentMethod))
        {
            break; /* Loop/switch isn't completed */
        }
        view = (String)view.getTag();
        if (view != null)
        {
            finishAfterUpdate = false;
            apiSetPaymentInstrument(selectedPaymentMethod, paymentinstrument.getPaymentInstrumentRefId(), view);
            return;
        }
        if (true) goto _L1; else goto _L12
_L12:
        if ("CreditCard".equals(selectedPaymentMethod))
        {
            startProxFlowForPaymentType("CreditCard", paymentinstrument.getPaymentInstrumentRefId());
            return;
        }
        if (!"DirectDebit".equals(selectedPaymentMethod))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!triggerSepaMandateFlow())
        {
            startProxFlowForPaymentType("DirectDebit", paymentinstrument.getPaymentInstrumentRefId());
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!"PayUponInvoice".equals(selectedPaymentMethod)) goto _L1; else goto _L13
_L13:
        startProxFlowForPaymentType("PayUponInvoice", null);
        return;
_L8:
        view.showContextMenu();
        return;
_L10:
        boolean flag = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
        toggleExpandOrCollapseOfOtherMethods(cart.hasEbayPlusItem(), flag);
        return;
_L11:
        view = (String)view.getTag();
        if (view != null)
        {
            if ("PayPal".equals(view))
            {
                startProxFlowForPaymentType("PayPal", "SelectPaymentInstrument");
                return;
            }
            if ("CreditCard".equals(view))
            {
                startProxFlowForPaymentType("CreditCard", null);
                return;
            }
            if ("DirectDebit".equals(view))
            {
                startProxFlowForPaymentType("DirectDebit", null);
                return;
            }
            if ("PayUponInvoice".equals(view))
            {
                startProxFlowForPaymentType("PayUponInvoice", null);
                return;
            }
            if (!"CashOnPickup".equals(view) && !"MoneyXferAcceptedInCheckout".equals(view) || !userHasIncentivesAndDisplayAlert())
            {
                finishAfterUpdate = true;
                apiSetPaymentInstrument(view, null, null);
                return;
            }
        }
        if (true) goto _L1; else goto _L14
_L14:
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        boolean flag1 = true;
        boolean flag;
        if (selectedMenuItem == null)
        {
            flag = super.onOptionsItemSelected(menuitem);
        } else
        {
            flag = flag1;
            if (selectedMenuItem.getId() == 0x7f100537)
            {
                int i = menuitem.getItemId();
                flag = flag1;
                if (i != 0x1040000)
                {
                    (new Intent()).putExtra("paymentMethodSelected", "PayPal");
                    if (i == 0x7f070812)
                    {
                        startProxFlowForPaymentType("PayPal", "SelectPaymentInstrument");
                        return true;
                    }
                    if (i == 0x7f070810)
                    {
                        startProxFlowForPaymentType("PayPal", "AddBankFundingSource");
                        return true;
                    }
                    flag = flag1;
                    if (i == 0x7f070811)
                    {
                        startProxFlowForPaymentType("PayPal", "AddCardFundingSource");
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            finishAfterUpdate = bundle.getBoolean("finishAfterUpdate", false);
        }
        setContentView(0x7f0301b5);
        updateUi();
        showBackButton();
        hideCloseButton();
    }

    public void onCreateContextMenu(ContextMenu contextmenu, View view, android.view.ContextMenu.ContextMenuInfo contextmenuinfo)
    {
        super.onCreateContextMenu(contextmenu, view, contextmenuinfo);
        if (view.getId() == 0x7f100537)
        {
            contextmenu.setHeaderTitle(getString(0x7f070813));
            selectedMenuItem = view;
            view = cart.cartPaymentMethods.getSelectedPaymentMethod();
            boolean flag = view.paidCompletelyByPayPalBalance();
            contextmenu.add(0, 0x7f070812, 0, getString(0x7f070812));
            if (!flag)
            {
                if (view.getActionUrlForAction("AddBankFundingSource") != null)
                {
                    contextmenu.add(0, 0x7f070810, 1, getString(0x7f070810));
                }
                if (view.getActionUrlForAction("AddCardFundingSource") != null)
                {
                    contextmenu.add(0, 0x7f070811, 2, getString(0x7f070811));
                }
            }
            contextmenu.add(0, 0x1040000, 3, getString(0x1040000));
        }
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
        if (!flag)
        {
            flag1 = true;
        }
        operation.showDynamicAlertDialog(s, ioexception, flag1);
    }

    public void onPartialFailure(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        String s;
        boolean flag;
        boolean flag1;
        s = null;
        flag = false;
        flag1 = false;
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.SET_PAYMENT_INSTRUMENT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[com.ebay.mobile.checkout.BaseCheckoutActivity.Operation.REFRESH_CART.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 1 1: default 36
    //                   1 83;
           goto _L1 _L2
_L1:
        jsonmodel = CheckoutError.mapCheckoutError(operation, s);
        if (jsonmodel != null)
        {
            flag1 = jsonmodel.shouldAbortOnError();
            dialogManager.showDynamicAlertDialog(null, jsonmodel.getErrorString(this), flag1);
        }
        String s1;
        if (!flag1 && !flag)
        {
            onSuccess(operation);
            return;
        } else
        {
            enableProgressDialog(false, false);
            return;
        }
_L2:
        s1 = jsonmodel.getValueForErrorParamater("gatewayErrorCode");
        s = s1;
        if (s1 == null)
        {
            s = jsonmodel.getValueForErrorParamater("paymentErrorCode");
        }
        s1 = s;
        if (s == null)
        {
            s1 = jsonmodel.getValueForErrorParamater("ecsErrorCode");
        }
        s = s1;
        if (s1 == null)
        {
            s = jsonmodel.getErrorId();
        }
        flag = true;
          goto _L1
    }

    protected void onResume()
    {
        super.onResume();
        TrackingData trackingdata = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        ArrayList arraylist = new ArrayList();
        if (isPayPalAvailable())
        {
            arraylist.add("pp");
        }
        if (isPuiAvailable())
        {
            arraylist.add("pui");
        }
        if (isDirectDebitAvailable())
        {
            arraylist.add("debit");
        }
        if (isCreditCardAvailable())
        {
            arraylist.add("cc");
        }
        if (isEftAvailable())
        {
            arraylist.add("eft");
        }
        if (isCopAvailable())
        {
            arraylist.add("pop");
        }
        if (arraylist.size() > 0)
        {
            trackingdata.addKeyValuePair("pmt", EbayUtil.flattenString(arraylist, ","));
        }
        trackingdata.send(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("finishAfterUpdate", finishAfterUpdate);
    }

    public void onSuccess(com.ebay.mobile.checkout.BaseCheckoutActivity.Operation operation)
    {
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (_cls2..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            updateUi();
            return;

        case 1: // '\001'
            selectedPaymentMethod = cart.cartPaymentMethods.getSelectedPaymentMethod().getName();
            if (!triggerSepaMandateFlow())
            {
                setResultStatus();
                if (finishAfterUpdate)
                {
                    finish();
                    return;
                } else
                {
                    enableProgressDialog(false, false);
                    updateUi();
                    return;
                }
            }
            break;

        case 2: // '\002'
            enableProgressDialog(false, false);
            updateUi();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
