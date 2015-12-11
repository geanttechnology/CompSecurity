// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.app.Dialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.cart.Cart;
import com.ebay.common.model.cart.Incentive;
import com.ebay.common.model.cart.ItemIncentives;
import com.ebay.common.model.cart.JsonModel;
import com.ebay.common.model.cart.PayPalCheckoutDetails;
import com.ebay.common.model.cart.UserIncentives;
import com.ebay.common.view.util.DialogManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.checkout:
//            BaseCheckoutActivity, CheckoutError

public class IncentivesActivity extends BaseCheckoutActivity
    implements android.view.View.OnClickListener, android.widget.CompoundButton.OnCheckedChangeListener
{
    private static final class IncentiveLayoutData
        implements Comparable
    {

        final CurrencyAmount amount;
        final String code;
        final String description;
        final boolean isApplied;
        final CurrencyAmount remainingAmount;

        public int compareTo(IncentiveLayoutData incentivelayoutdata)
        {
            if (code != null && incentivelayoutdata.code != null)
            {
                return code.compareTo(incentivelayoutdata.code);
            }
            if (code == null)
            {
                return -1;
            }
            return incentivelayoutdata != null ? 0 : 1;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((IncentiveLayoutData)obj);
        }

        IncentiveLayoutData(com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive, String s, CurrencyAmount currencyamount)
        {
            code = appliedincentive.code;
            description = s;
            if (appliedincentive.redeemedAmount != null)
            {
                amount = appliedincentive.redeemedAmount;
            } else
            {
                amount = null;
            }
            remainingAmount = currencyamount;
            isApplied = true;
        }

        IncentiveLayoutData(Incentive incentive, String s)
        {
            code = incentive.redemptionCode;
            description = s;
            if (incentive.discountAmount != null)
            {
                amount = incentive.discountAmount;
            } else
            {
                amount = null;
            }
            remainingAmount = null;
            isApplied = false;
        }

        IncentiveLayoutData(com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive incentive, String s)
        {
            code = incentive.code;
            description = s;
            if (incentive.balance != null)
            {
                amount = incentive.balance;
            } else
            {
                amount = null;
            }
            remainingAmount = null;
            isApplied = false;
        }
    }

    public final class InputFilterAlphaNumCaps extends android.text.InputFilter.AllCaps
    {

        final IncentivesActivity this$0;

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
        {
            for (int i1 = i; i1 < j; i1++)
            {
                if (!Character.isLetterOrDigit(charsequence.charAt(i1)))
                {
                    return "";
                }
            }

            return super.filter(charsequence, i, j, spanned, k, l);
        }

        public InputFilterAlphaNumCaps()
        {
            this$0 = IncentivesActivity.this;
            super();
        }
    }

    private static final class ViewState extends Enum
    {

        private static final ViewState $VALUES[];
        public static final ViewState INCENTIVE_INPUT;
        public static final ViewState INCENTIVE_LIST;

        public static ViewState valueOf(String s)
        {
            return (ViewState)Enum.valueOf(com/ebay/mobile/checkout/IncentivesActivity$ViewState, s);
        }

        public static ViewState[] values()
        {
            return (ViewState[])$VALUES.clone();
        }

        static 
        {
            INCENTIVE_INPUT = new ViewState("INCENTIVE_INPUT", 0);
            INCENTIVE_LIST = new ViewState("INCENTIVE_LIST", 1);
            $VALUES = (new ViewState[] {
                INCENTIVE_INPUT, INCENTIVE_LIST
            });
        }

        private ViewState(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String EXTRA_INCENTIVES_CHANGED = "incentives_changed";
    private static final String EXTRA_VIEW_STATE = "view_state";
    protected final DialogManager dialogManager = (DialogManager)getShim(com/ebay/common/view/util/DialogManager);
    private EditText incentiveInput;
    private boolean incentivesChanged;
    private LayoutInflater inflater;
    private ViewState viewState;

    public IncentivesActivity()
    {
    }

    private void appendLayout(ViewGroup viewgroup, String s, CurrencyAmount currencyamount, String s1, CurrencyAmount currencyamount1, boolean flag)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f0302c7, viewgroup, false);
        TextView textview;
        boolean flag1;
        if (s != null)
        {
            ((TextView)viewgroup1.findViewById(0x7f100987)).setText(s);
            viewgroup1.findViewById(0x7f100986).setVisibility(0);
            viewgroup1.findViewById(0x7f100988).setVisibility(8);
        } else
        {
            viewgroup1.findViewById(0x7f100986).setVisibility(8);
            viewgroup1.findViewById(0x7f100988).setVisibility(0);
        }
        if (currencyamount1 != null && currencyamount1.getCurrencyCode().equals(currencyamount.getCurrencyCode()))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        s = (TextView)viewgroup1.findViewById(0x7f10098a);
        if (flag)
        {
            s.setText(0x7f070c34);
        } else
        {
            s.setText(0x7f070c35);
        }
        textview = (TextView)viewgroup1.findViewById(0x7f10098b);
        if (currencyamount != null)
        {
            textview.setText(EbayCurrencyUtil.formatDisplay(currencyamount, 2));
            textview.setVisibility(0);
            s.setVisibility(0);
        } else
        {
            textview.setVisibility(4);
            s.setVisibility(4);
        }
        if (flag1)
        {
            ((TextView)viewgroup1.findViewById(0x7f10098d)).setText(EbayCurrencyUtil.formatDisplay(currencyamount1, 2));
            viewgroup1.findViewById(0x7f10098c).setVisibility(0);
        } else
        {
            viewgroup1.findViewById(0x7f10098c).setVisibility(8);
        }
        s = (CheckBox)viewgroup1.findViewById(0x7f100985);
        s.setChecked(flag);
        s.setTag(s1);
        s.setOnCheckedChangeListener(this);
        viewgroup.addView(viewgroup1);
    }

    private void createUi()
    {
        setContentView(0x7f0302c8);
        findViewById(0x7f100995).setOnClickListener(this);
        findViewById(0x7f100996).setOnClickListener(this);
        incentiveInput = (EditText)findViewById(0x7f100929);
        incentiveInput.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final IncentivesActivity this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    ((InputMethodManager)getSystemService("input_method")).showSoftInput(view, 1);
                    return;
                } else
                {
                    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    return;
                }
            }

            
            {
                this$0 = IncentivesActivity.this;
                super();
            }
        });
        incentiveInput.setFilters(new InputFilter[] {
            new InputFilterAlphaNumCaps()
        });
        incentiveInput.setFocusable(true);
        hideCloseButton();
        setActivityTitle();
    }

    private void done()
    {
        if (incentiveInput != null)
        {
            Util.hideSoftInput(this, incentiveInput);
        }
        byte byte0;
        if (incentivesChanged)
        {
            byte0 = -1;
        } else
        {
            byte0 = 0;
        }
        setCheckoutResult(byte0, null);
        finish();
    }

    private int getApplicableIncentivesCount()
    {
        int j = 0;
        Iterator iterator = cart.getIncentives().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive = (com.ebay.common.model.cart.Cart.AppliedIncentive)iterator.next();
            if (appliedincentive.isVoucher() || appliedincentive.isGiftCard() || appliedincentive.isGiftCertificate() || appliedincentive.isCoupon())
            {
                j++;
            }
        } while (true);
        int i = j;
        if (userIncentives != null)
        {
            i = j;
            if (userIncentives.incentives != null)
            {
                i = j + userIncentives.incentives.size();
            }
        }
        j = i;
        if (itemIncentivesCoupons != null)
        {
            j = i;
            if (itemIncentivesCoupons.incentives != null)
            {
                j = i + itemIncentivesCoupons.incentives.size();
            }
        }
        i = j;
        if (payPalCheckoutDetails != null)
        {
            i = j;
            if (payPalCheckoutDetails.incentives.length > 0)
            {
                i = j + payPalCheckoutDetails.incentives.length;
            }
        }
        return i;
    }

    private CurrencyAmount getRemainingAmount(com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive)
    {
        if (payPalCheckoutDetails != null && payPalCheckoutDetails.incentives != null)
        {
            com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive aincentive[] = payPalCheckoutDetails.incentives;
            int j = aincentive.length;
            int i = 0;
            while (i < j) 
            {
                com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive incentive = aincentive[i];
                if (incentive.code.equals(appliedincentive.code))
                {
                    return incentive.balance.subtract(appliedincentive.redeemedAmount);
                }
                i++;
            }
        }
        return null;
    }

    private String getUserIncentiveDisplayMsgIfPresent(String s, String s1)
    {
        Object obj;
label0:
        {
            obj = s1;
            if (itemIncentivesCoupons == null)
            {
                break label0;
            }
            obj = s1;
            if (itemIncentivesCoupons.incentives == null)
            {
                break label0;
            }
            Iterator iterator = itemIncentivesCoupons.incentives.iterator();
            do
            {
                obj = s1;
                if (!iterator.hasNext())
                {
                    break label0;
                }
                obj = (Incentive)iterator.next();
            } while (!s.equals(((Incentive) (obj)).redemptionCode) || TextUtils.isEmpty(((Incentive) (obj)).displayMsg));
            obj = ((Incentive) (obj)).displayMsg;
        }
        return ((String) (obj));
    }

    private void resetIncentiveInput()
    {
        incentiveInput.setText(null);
        findViewById(0x7f100991).setVisibility(8);
        viewState = ViewState.INCENTIVE_LIST;
    }

    private void sendTrackingEventForRedemption(boolean flag)
    {
        TrackingData trackingdata = new TrackingData("CheckoutGiftCardReedemed", TrackingType.EVENT);
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        trackingdata.addKeyValuePair("credeemed", s);
        trackingdata.send(this);
    }

    private void setActivityTitle()
    {
        if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            setTitle(0x7f0700e5);
        } else
        {
            setTitle(0x7f0700e6);
        }
        if (viewState == ViewState.INCENTIVE_LIST || !isPayPalSelected() && cart.isProx())
        {
            TextView textview = (TextView)findViewById(0x7f100992);
            if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
            {
                textview.setText(0x7f070c32);
            } else
            {
                textview.setText(0x7f0700e9);
            }
        } else
        {
            TextView textview1 = (TextView)findViewById(0x7f100929);
            if (MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
            {
                textview1.setHint(0x7f0700e2);
            } else
            {
                textview1.setHint(0x7f0700e3);
            }
        }
        setBackButtonOnClickListener(new android.view.View.OnClickListener() {

            final IncentivesActivity this$0;

            public void onClick(View view)
            {
                ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                if (viewState == ViewState.INCENTIVE_LIST)
                {
                    done();
                    return;
                } else
                {
                    viewState = ViewState.INCENTIVE_LIST;
                    resetIncentiveInput();
                    updateUi(true);
                    return;
                }
            }

            
            {
                this$0 = IncentivesActivity.this;
                super();
            }
        });
    }

    private void showContent()
    {
        if (!isPayPalSelected() && cart.isProx())
        {
            findViewById(0x7f10098e).setVisibility(0);
            findViewById(0x7f10098f).setVisibility(8);
            findViewById(0x7f100993).setVisibility(8);
            findViewById(0x7f100990).setVisibility(8);
            findViewById(0x7f100995).setVisibility(8);
        } else
        if (viewState == ViewState.INCENTIVE_INPUT)
        {
            findViewById(0x7f10098e).setVisibility(8);
            findViewById(0x7f10098f).setVisibility(0);
            findViewById(0x7f100993).setVisibility(8);
            findViewById(0x7f100990).setVisibility(0);
            findViewById(0x7f100995).setVisibility(8);
        } else
        {
            findViewById(0x7f10098e).setVisibility(8);
            findViewById(0x7f10098f).setVisibility(8);
            findViewById(0x7f100993).setVisibility(0);
            findViewById(0x7f100990).setVisibility(0);
            findViewById(0x7f100995).setVisibility(0);
        }
        enableProgressDialog(false, false);
    }

    private void submitIncentiveCode()
    {
        TextView textview = (TextView)findViewById(0x7f100991);
        if (!TextUtils.isEmpty(incentiveInput.getText().toString()))
        {
            Util.hideSoftInput(this, incentiveInput);
            textview.setText(null);
            textview.setVisibility(8);
            showContent();
            apiRedeemIncentive(incentiveInput.getText().toString());
            return;
        }
        int i = 0x7f070c2c;
        if (!MyApp.getPrefs().getCurrentSite().equals(EbaySite.US))
        {
            i = 0x7f070c2d;
        }
        textview.setText(getString(i));
        textview.setVisibility(0);
    }

    private void updateUi(boolean flag)
    {
        enableProgressDialog(false, false);
        if (viewState == ViewState.INCENTIVE_LIST)
        {
            ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100994);
            viewgroup.removeAllViews();
            HashMap hashmap = new HashMap();
            Iterator iterator2 = cart.getIncentives().iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                com.ebay.common.model.cart.Cart.AppliedIncentive appliedincentive = (com.ebay.common.model.cart.Cart.AppliedIncentive)iterator2.next();
                if (appliedincentive.isVoucher())
                {
                    Object obj2 = null;
                    Iterator iterator3 = userIncentives.incentives.iterator();
                    do
                    {
                        Object obj = obj2;
                        if (!iterator3.hasNext())
                        {
                            break;
                        }
                        obj = (Incentive)iterator3.next();
                        if (!((Incentive) (obj)).campaign.isVoucher() || !appliedincentive.code.equals(((Incentive) (obj)).redemptionCode))
                        {
                            continue;
                        }
                        if (((Incentive) (obj)).currencyCode.equals(appliedincentive.redeemedAmount.getCurrencyCode()))
                        {
                            obj = new CurrencyAmount(((Incentive) (obj)).discountAmount.subtract(appliedincentive.redeemedAmount).getValueAsBigDecimal(), appliedincentive.redeemedAmount.getCurrencyCode());
                        } else
                        {
                            obj = null;
                        }
                        break;
                    } while (true);
                    obj2 = obj;
                    if (obj != null)
                    {
                        obj2 = appliedincentive.redeemedAmount.subtract(appliedincentive.redeemedAmount);
                    }
                    hashmap.put(appliedincentive.code, new IncentiveLayoutData(appliedincentive, null, ((CurrencyAmount) (obj2))));
                    continue;
                }
                if (appliedincentive.isGiftCard() || appliedincentive.isGiftCertificate())
                {
                    hashmap.put(appliedincentive.code, new IncentiveLayoutData(appliedincentive, incentiveTypeToString(this, appliedincentive), getRemainingAmount(appliedincentive)));
                } else
                if (appliedincentive.isCoupon())
                {
                    hashmap.put(appliedincentive.code, new IncentiveLayoutData(appliedincentive, getUserIncentiveDisplayMsgIfPresent(appliedincentive.code, appliedincentive.message), null));
                }
            } while (true);
            if (userIncentives != null && userIncentives.incentives != null)
            {
                Iterator iterator = userIncentives.incentives.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Incentive incentive = (Incentive)iterator.next();
                    if (!hashmap.containsKey(incentive.redemptionCode))
                    {
                        if (incentive.campaign.isVoucher())
                        {
                            hashmap.put(incentive.redemptionCode, new IncentiveLayoutData(incentive, null));
                        } else
                        if (incentive.campaign.isCoupon())
                        {
                            hashmap.put(incentive.redemptionCode, new IncentiveLayoutData(incentive, incentive.displayMsg));
                        }
                    }
                } while (true);
            }
            if (itemIncentivesCoupons != null && itemIncentivesCoupons.incentives != null)
            {
                Iterator iterator1 = itemIncentivesCoupons.incentives.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Incentive incentive1 = (Incentive)iterator1.next();
                    if (incentive1 != null && incentive1.campaign != null && !hashmap.containsKey(incentive1.redemptionCode) && incentive1.campaign.isCoupon() && incentive1.campaign.isActive())
                    {
                        hashmap.put(incentive1.redemptionCode, new IncentiveLayoutData(incentive1, incentive1.displayMsg));
                    }
                } while (true);
            }
            if (payPalCheckoutDetails != null && payPalCheckoutDetails.incentives.length > 0)
            {
                com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive aincentive[] = payPalCheckoutDetails.incentives;
                int j = aincentive.length;
                for (int i = 0; i < j; i++)
                {
                    com.ebay.common.model.cart.PayPalCheckoutDetails.Incentive incentive2 = aincentive[i];
                    if (incentive2 != null && !hashmap.containsKey(incentive2.code) && (incentive2.isGiftCard() || incentive2.isGiftCertificate()) && incentive2.balance.isGreaterThanZero())
                    {
                        hashmap.put(incentive2.code, new IncentiveLayoutData(incentive2, getString(0x7f070c24)));
                    }
                }

            }
            if (hashmap.size() > 0)
            {
                Object obj1 = Collections.list(Collections.enumeration(hashmap.values()));
                Collections.sort(((List) (obj1)));
                IncentiveLayoutData incentivelayoutdata;
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); appendLayout(viewgroup, incentivelayoutdata.description, incentivelayoutdata.amount, incentivelayoutdata.code, incentivelayoutdata.remainingAmount, incentivelayoutdata.isApplied))
                {
                    incentivelayoutdata = (IncentiveLayoutData)((Iterator) (obj1)).next();
                }

                findViewById(0x7f100995).requestFocus();
            } else
            {
                if (flag)
                {
                    done();
                    return;
                }
                viewState = ViewState.INCENTIVE_INPUT;
                incentiveInput.requestFocus();
            }
        }
        setActivityTitle();
        showContent();
    }

    void applyIncentive(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        showContent();
        if (s != null)
        {
            arraylist.add(s);
        }
        if (s1 != null)
        {
            arraylist1.add(s1);
        }
        enableProgressDialog(true, false);
        apiApplyIncentives(arraylist, arraylist1);
    }

    public String getTrackingEventName()
    {
        return "CheckoutIncentiveEntry";
    }

    public void onBackPressed()
    {
        if (viewState == ViewState.INCENTIVE_INPUT && getApplicableIncentivesCount() > 0)
        {
            viewState = ViewState.INCENTIVE_LIST;
            resetIncentiveInput();
            updateUi(false);
            return;
        } else
        {
            done();
            return;
        }
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        boolean flag1 = false;
        if (!networkAvailable())
        {
            if (!flag)
            {
                flag1 = true;
            }
            compoundbutton.setChecked(flag1);
            return;
        }
        String s = (String)compoundbutton.getTag();
        Object obj = null;
        Object obj1 = null;
        if (flag)
        {
            if (cart.isTotalZero())
            {
                dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070c2e), false);
                compoundbutton.setChecked(false);
                return;
            }
            compoundbutton = obj1;
        } else
        {
            compoundbutton = s;
            s = obj;
        }
        applyIncentive(s, compoundbutton);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131757461: 
            if (cart.isTotalZero())
            {
                dialogManager.showDynamicAlertDialog(getString(0x7f070130), getString(0x7f070c2e), false);
                return;
            } else
            {
                viewState = ViewState.INCENTIVE_INPUT;
                updateUi(false);
                return;
            }

        case 2131757462: 
            break;
        }
        if (viewState == ViewState.INCENTIVE_INPUT)
        {
            submitIncentiveCode();
            return;
        } else
        {
            done();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        if (bundle == null)
        {
            incentivesChanged = false;
            viewState = ViewState.INCENTIVE_LIST;
        } else
        {
            incentivesChanged = bundle.getBoolean("incentives_changed");
            viewState = ViewState.values()[bundle.getInt("view_state")];
        }
        createUi();
        updateUi(false);
        setActivityTitle();
    }

    protected Dialog onCreateDialog(int i)
    {
        return DialogManager.createAlertDialog(this, i);
    }

    public void onError(BaseCheckoutActivity.Operation operation, boolean flag, IOException ioexception)
    {
        boolean flag1 = false;
        if (isFinishing())
        {
            return;
        }
        showContent();
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

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (false) goto _L2; else goto _L1
_L1:
        menuitem.getItemId();
        JVM INSTR tableswitch 16908332 16908332: default 28
    //                   16908332 30;
           goto _L2 _L3
_L2:
        return false;
_L3:
        done();
        return false;
    }

    public void onPartialFailure(BaseCheckoutActivity.Operation operation, JsonModel jsonmodel)
    {
        static class _cls3
        {

            static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

            static 
            {
                $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[BaseCheckoutActivity.Operation.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.APPLY_INCENTIVES.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[BaseCheckoutActivity.Operation.REDEEM_INCENTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 135
    //                   2 38;
           goto _L1 _L2 _L3
_L1:
        onSuccess(operation);
_L5:
        return;
_L3:
        TextView textview = (TextView)findViewById(0x7f100991);
        Object obj1 = ((Cart)jsonmodel).getValueForErrorParamater("incentiveErrorCode");
        Object obj = null;
        jsonmodel = obj;
        if (obj1 != null)
        {
            obj1 = CheckoutError.mapCheckoutError(BaseCheckoutActivity.Operation.REDEEM_INCENTIVE, ((String) (obj1)));
            jsonmodel = obj;
            if (obj1 != null)
            {
                jsonmodel = ((CheckoutError) (obj1)).getErrorString(this);
            }
        }
        textview.setText(jsonmodel);
        if (jsonmodel == null)
        {
            onSuccess(operation);
            return;
        } else
        {
            sendTrackingEventForRedemption(false);
            textview.setVisibility(0);
            viewState = ViewState.INCENTIVE_INPUT;
            updateUi(false);
            return;
        }
_L2:
        jsonmodel = ((Cart)jsonmodel).getValueForErrorParamater("incentiveErrorCode");
        if (jsonmodel != null)
        {
            jsonmodel = CheckoutError.mapCheckoutError(BaseCheckoutActivity.Operation.APPLY_INCENTIVES, jsonmodel);
            if (jsonmodel != null)
            {
                dialogManager.showDynamicAlertDialog(null, jsonmodel.getErrorString(this), jsonmodel.shouldAbortOnError());
                if (!jsonmodel.shouldAbortOnError())
                {
                    onSuccess(operation);
                    return;
                }
            }
        } else
        {
            onSuccess(operation);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("incentives_changed", incentivesChanged);
        bundle.putInt("view_state", viewState.ordinal());
    }

    public void onSuccess(BaseCheckoutActivity.Operation operation)
    {
        switch (_cls3..SwitchMap.com.ebay.mobile.checkout.BaseCheckoutActivity.Operation[operation.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            incentivesChanged = true;
            viewState = ViewState.INCENTIVE_LIST;
            updateUi(false);
            return;

        case 2: // '\002'
            resetIncentiveInput();
            break;
        }
        updateUi(false);
        incentivesChanged = true;
        (new TrackingData("CheckoutIncentiveApplied", TrackingType.EVENT)).send(this);
        sendTrackingEventForRedemption(true);
    }



/*
    static ViewState access$002(IncentivesActivity incentivesactivity, ViewState viewstate)
    {
        incentivesactivity.viewState = viewstate;
        return viewstate;
    }

*/



}
