// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.DialogFragment;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.EbaySpinner;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.givingworks.NonProfitDataManager;
import com.ebay.common.util.EmailAddressInputFilter;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.sell.widget.PaypalEmailAutoComplete;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.ListingDraftDataManager;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell:
//            BaseSpokeFragment, GivingWorksFragment, ListingFragmentActivity, NumberPickerDialogFragment

public class PreferencesSpokeFragment extends BaseSpokeFragment
    implements android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged, DialogFragmentCallback, com.ebay.common.net.api.givingworks.NonProfitDataManager.Observer, NumberPickerDialogFragment.NumberPickerListener, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.Observer
{
    private class HandlingTimeAdapter extends ArrayAdapter
    {

        private final Context context;
        final PreferencesSpokeFragment this$0;

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public View getDropDownView(int i, View view, ViewGroup viewgroup)
        {
            view = (LayoutInflater)context.getSystemService("layout_inflater");
            if (isEnabled(i))
            {
                view = view.inflate(0x7f030217, viewgroup, false);
                ((TextView)view.findViewById(0x1020014)).setText(((LdsOption)getItem(i)).caption);
                return view;
            } else
            {
                view = view.inflate(0x7f030219, viewgroup, false);
                ((TextView)view.findViewById(0x7f1003b9)).setText(((LdsOption)getItem(i)).caption);
                return view;
            }
        }

        public boolean isEnabled(int i)
        {
            return ((LdsOption)getItem(i)).getIntValue() != -1;
        }

        public HandlingTimeAdapter(Context context1)
        {
            this$0 = PreferencesSpokeFragment.this;
            super(context1, 0x7f030223);
            context = context1;
        }
    }

    private class URLSpanNoUnderline extends URLSpan
    {

        final PreferencesSpokeFragment this$0;

        public void updateDrawState(TextPaint textpaint)
        {
            super.updateDrawState(textpaint);
            textpaint.setUnderlineText(false);
        }

        public URLSpanNoUnderline(String s)
        {
            this$0 = PreferencesSpokeFragment.this;
            super(s);
        }
    }


    private static final int DIALOG_EXCEPTIONAL_HANDLING_TIME = 0;
    private static final int DIALOG_PAYMENT_METHODS = 1;
    private static final int EXCEPTIONAL_HANDLING_TIME_VALUE = -1;
    private static final int RETURNS_ACCEPTED_VALUE = 0;
    private static final int RETURNS_NOT_ACCEPTED_VALUE = 1;
    private static final String SELECT_CHARITY_FRAGMENT = "select_charity";
    private View charityContainer;
    private String charityId;
    private TextView charityName;
    private TextView charitySubtitle;
    private View charityTitle;
    private EditText cityStateText;
    private ArrayAdapter countryAdapter;
    private EbaySpinner countrySpinner;
    private ListingDraftDataManager dm;
    private CheckBox donationCheckBox;
    private TextView donationPercentage;
    private View donationPercentageContainer;
    private TextView donationTextView;
    private List favoriteCharities;
    private View favoriteCharitiesContainer;
    private HandlingTimeAdapter handlingAdapter;
    private EbaySpinner handlingSpinner;
    protected ImageCache imageCache;
    private CheckedTextView immediatePayCheckBox;
    private View immediatePayHelpContent;
    private View immediatePayHelpTitle;
    private View immediatePayRow;
    private ListingDraft latestDraft;
    private int minimumExceptionHandlingTime;
    private View parent;
    private Button paymentMethodsButton;
    protected PaypalEmailAutoComplete paypalEmailAddress;
    private ArrayAdapter paypalEmailAddressAdapter;
    private LinearLayout paypalEmailAddressRow;
    private EditText policyDetails;
    private View policyDetailsLayout;
    private EditText postalCodeText;
    private View progress;
    private EbaySpinner refundMethod;
    private ArrayAdapter refundMethodAdapter;
    private View refundMethodLayout;
    private EbaySpinner restockingFee;
    private ArrayAdapter restockingFeeAdapter;
    private View restockingFeeLayout;
    private EbaySpinner returnPeriod;
    private ArrayAdapter returnPeriodAdapter;
    private View returnPeriodLayout;
    private EbaySpinner returnPolicy;
    private View returnPolicyProgress;
    private EbaySpinner returnShippingPaidBy;
    private ArrayAdapter returnShippingPaidByAdapter;
    private View returnShippingPaidByLayout;
    private ImageView showMoreArrow;
    private View showMoreLayout;
    private TextView showMoreText;
    private boolean showingAdvancedOptions;

    public PreferencesSpokeFragment()
    {
        minimumExceptionHandlingTime = -1;
        showingAdvancedOptions = false;
    }

    private boolean[] getCheckedPaymentMethods()
    {
        ArrayList arraylist = latestDraft.getModifiablePaymentMethods();
        boolean aflag[] = new boolean[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            aflag[i] = ((LdsField)arraylist.get(i)).getBooleanValue();
        }

        return aflag;
    }

    private String[] getPaymentMethods()
    {
        ArrayList arraylist = latestDraft.getModifiablePaymentMethods();
        String as[] = new String[arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            as[i] = ((LdsField)arraylist.get(i)).caption;
        }

        return as;
    }

    private void hideReturnsAcceptedOptions()
    {
        returnPeriodLayout.setVisibility(8);
        refundMethodLayout.setVisibility(8);
        returnShippingPaidByLayout.setVisibility(8);
        restockingFeeLayout.setVisibility(8);
        policyDetailsLayout.setVisibility(8);
    }

    private void initializeTextFieldValues()
    {
        LdsField ldsfield = latestDraft.paypalEmailAddress;
        viewUpdate(paypalEmailAddress, latestDraft.paypalEmailAddress);
        if (ldsfield != null)
        {
            updateTextValue(paypalEmailAddress, ldsfield);
        }
        cityStateText.setText(latestDraft.locationCityState.getStringValue());
        postalCodeText.setText(latestDraft.locationPostalCode.getStringValue());
        if (latestDraft.refundPolicyDetails != null)
        {
            policyDetails.setText(latestDraft.refundPolicyDetails.getStringValue());
        }
    }

    private void loadHandlingTimeOptions()
    {
        handlingAdapter.clear();
        Object obj = latestDraft.handlingTime.options;
        ArrayList arraylist = new ArrayList();
        if (latestDraft.extendedHandlingDuration != null)
        {
            arraylist = latestDraft.extendedHandlingDuration.options;
        }
        int j = latestDraft.handlingTime.getIntValue();
        if (obj != null)
        {
            LdsOption ldsoption = new LdsOption();
            ldsoption.caption = getString(0x7f070546);
            ldsoption.value = "-1";
            boolean flag = false;
            Iterator iterator1 = ((List) (obj)).iterator();
label0:
            do
            {
                LdsOption ldsoption1;
                boolean flag1;
label1:
                {
                    if (!iterator1.hasNext())
                    {
                        break label0;
                    }
                    ldsoption1 = (LdsOption)iterator1.next();
                    flag1 = flag;
                    if (flag)
                    {
                        break label1;
                    }
                    int k = ldsoption1.getIntValue();
                    Iterator iterator2 = arraylist.iterator();
                    do
                    {
                        flag1 = flag;
                        if (!iterator2.hasNext())
                        {
                            break label1;
                        }
                    } while (((LdsOption)iterator2.next()).getIntValue() != k);
                    handlingAdapter.add(ldsoption);
                    flag1 = true;
                    minimumExceptionHandlingTime = k;
                }
                if (ldsoption1.getIntValue() == 0)
                {
                    flag = flag1;
                    if (j != 0)
                    {
                        continue;
                    }
                }
                handlingAdapter.add(ldsoption1);
                flag = flag1;
            } while (true);
        }
label2:
        {
            handlingSpinner.setAdapter(handlingAdapter);
            if (obj == null)
            {
                break label2;
            }
            Iterator iterator = ((List) (obj)).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label2;
                }
                obj = (LdsOption)iterator.next();
            } while (((LdsOption) (obj)).getIntValue() != j);
            int i = handlingAdapter.getPosition(obj);
            handlingSpinner.setSelection(i);
        }
    }

    private void showCharitySelector()
    {
        GivingWorksFragment givingworksfragment = new GivingWorksFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(GivingWorksFragment.DRAFT_KEY_PARAMS, dm.getParams());
        bundle.putBoolean("charity_selection_enabled", true);
        bundle.putString("charity_selected_id", latestDraft.charityId.getStringValue());
        bundle.putInt("charity_selection_label", 0x7f07022f);
        givingworksfragment.setArguments(bundle);
        givingworksfragment.show(getFragmentManager(), "select_charity");
    }

    private void showReturnsAcceptedOptions()
    {
        if (returnPeriodAdapter.getCount() > 0)
        {
            returnPeriodLayout.setVisibility(0);
        } else
        {
            returnPeriodLayout.setVisibility(8);
        }
        if (refundMethodAdapter.getCount() > 0)
        {
            refundMethodLayout.setVisibility(0);
        } else
        {
            refundMethodLayout.setVisibility(8);
        }
        if (returnShippingPaidByAdapter.getCount() > 0)
        {
            returnShippingPaidByLayout.setVisibility(0);
        } else
        {
            returnShippingPaidByLayout.setVisibility(8);
        }
        if (restockingFeeAdapter.getCount() > 0)
        {
            restockingFeeLayout.setVisibility(0);
        } else
        {
            restockingFeeLayout.setVisibility(8);
        }
        viewUpdate(policyDetails, latestDraft.refundPolicyDetails);
        if (latestDraft.refundPolicyDetails != null && !"DISABLE".equals(latestDraft.refundPolicyDetails.getBmode()))
        {
            policyDetailsLayout.setVisibility(0);
            return;
        } else
        {
            policyDetailsLayout.setVisibility(8);
            return;
        }
    }

    private void stripUnderlines(TextView textview)
    {
        Spannable spannable = (Spannable)textview.getText();
        URLSpan aurlspan[] = (URLSpan[])spannable.getSpans(0, spannable.length(), android/text/style/URLSpan);
        int j = aurlspan.length;
        for (int i = 0; i < j; i++)
        {
            URLSpan urlspan = aurlspan[i];
            int k = spannable.getSpanStart(urlspan);
            int l = spannable.getSpanEnd(urlspan);
            spannable.removeSpan(urlspan);
            spannable.setSpan(new URLSpanNoUnderline(urlspan.getURL()), k, l, 0);
        }

        textview.setText(spannable);
    }

    private void updateCharityState()
    {
        int i;
label0:
        {
            boolean flag2 = true;
            boolean flag = false;
            if (!DeviceConfiguration.getAsync().get(DcsBoolean.ebayGivingSelling))
            {
                charityContainer.setVisibility(8);
                charitySubtitle.setVisibility(8);
                charityTitle.setVisibility(8);
                return;
            }
            ((ListingFragmentActivity)getActivity()).setCharityLoaded(true);
            charityContainer.setVisibility(0);
            charitySubtitle.setVisibility(0);
            charityTitle.setVisibility(0);
            Object obj = MyApp.getPrefs().getCurrentCountry();
            String s = com.ebay.common.view.util.EbayCountryManager.Default.ebayGivingWorksCreditFeesUrl(((com.ebay.nautilus.domain.EbayCountry) (obj)));
            charitySubtitle.setText(Html.fromHtml(getString(0x7f0709a5, new Object[] {
                s
            })));
            charitySubtitle.setMovementMethod(LinkMovementMethod.getInstance());
            stripUnderlines(charitySubtitle);
            obj = com.ebay.common.view.util.EbayCountryManager.Default.ebayGivingWorksTnCUrl(((com.ebay.nautilus.domain.EbayCountry) (obj)));
            donationTextView.setText(Html.fromHtml(getString(0x7f0709a9, new Object[] {
                obj
            })));
            donationTextView.setMovementMethod(LinkMovementMethod.getInstance());
            stripUnderlines(donationTextView);
            viewUpdate(donationCheckBox, latestDraft.charityId);
            donationCheckBox.setClickable(donationCheckBox.isEnabled());
            viewUpdate(favoriteCharitiesContainer, latestDraft.charityId);
            viewUpdate(charityName, latestDraft.charityId);
            favoriteCharitiesContainer.setClickable(charityName.isEnabled());
            viewUpdate(donationPercentage, latestDraft.charityDonationPercent);
            donationPercentage.setClickable(donationPercentage.isEnabled());
            boolean flag1;
            if (latestDraft.charityId.getStringValue() != null)
            {
                flag1 = flag2;
                if (!latestDraft.charityId.getStringValue().equals("0"))
                {
                    break label0;
                }
            }
            if (donationCheckBox.isChecked())
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
        }
        donationCheckBox.setChecked(flag1);
        obj = donationPercentageContainer;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        obj = favoriteCharitiesContainer;
        if (flag1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
    }

    private void updateCharityValues()
    {
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ebayGivingSelling)) goto _L2; else goto _L1
_L1:
        return;
_L2:
label0:
        {
            String s;
            Iterator iterator;
            LdsOption ldsoption;
            boolean flag;
            if (latestDraft.charityId.getStringValue() != null && !latestDraft.charityId.getStringValue().equals("0"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            donationCheckBox.setChecked(flag);
            if (latestDraft.charityDonationPercent == null || donationPercentage == null)
            {
                break label0;
            }
            viewUpdate(donationPercentage, latestDraft.charityDonationPercent);
            donationPercentage.setClickable(donationPercentage.isEnabled());
            s = latestDraft.charityDonationPercent.getStringValue();
            iterator = latestDraft.charityDonationPercent.options.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                ldsoption = (LdsOption)iterator.next();
            } while (!ldsoption.value.equals(s));
            donationPercentage.setTag(ldsoption);
            donationPercentage.setText(ldsoption.caption);
        }
        viewUpdate(favoriteCharitiesContainer, latestDraft.charityId);
        viewUpdate(charityName, latestDraft.charityId);
        s = latestDraft.charityId.getSelectedCaption();
        if (flag && !TextUtils.isEmpty(s))
        {
            charityName.setText(s);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void updatePaymentMethods(List list)
    {
        boolean flag = false;
        boolean flag1 = false;
        Object obj = "";
        Iterator iterator = list.iterator();
        list = ((List) (obj));
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsField ldsfield = (LdsField)iterator.next();
            if (!"DISABLE".equals(ldsfield.getBmode()) && ldsfield.getBooleanValue())
            {
                if ("PayPal".equals(ldsfield.getIdIndex()))
                {
                    flag1 = true;
                }
                obj = list;
                if (!TextUtils.isEmpty(list))
                {
                    obj = (new StringBuilder()).append(list).append(", ").toString();
                }
                list = (new StringBuilder()).append(((String) (obj))).append(ldsfield.caption).toString();
                flag = true;
            }
        } while (true);
        obj = paypalEmailAddressRow;
        int i;
        boolean flag2;
        if (flag1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((LinearLayout) (obj)).setVisibility(i);
        obj = paymentMethodsButton;
        if (latestDraft.getModifiablePaymentMethods().size() > 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        ((Button) (obj)).setEnabled(flag2);
        if (flag)
        {
            paymentMethodsButton.setText(list);
        } else
        {
            paymentMethodsButton.setText(getString(0x7f0709a4));
        }
        if ("DISABLE".equals(latestDraft.immediatePay.getBmode()))
        {
            showMoreLayout.setVisibility(8);
            immediatePayRow.setVisibility(8);
            immediatePayHelpTitle.setVisibility(8);
            immediatePayHelpContent.setVisibility(8);
        } else
        {
            showMoreLayout.setVisibility(0);
            immediatePayRow.setVisibility(0);
            if (!latestDraft.immediatePay.isEnabled())
            {
                updateCheckedTextValue(immediatePayCheckBox, latestDraft.immediatePay);
                return;
            }
        }
    }

    private void updatePostalCode(LdsField ldsfield, LdsField ldsfield1)
    {
        if (ldsfield1.getStringValue() == null || ldsfield.isEnabled())
        {
            postalCodeText.setEnabled(true);
            postalCodeText.setFocusable(true);
            postalCodeText.setFocusableInTouchMode(true);
            return;
        } else
        {
            postalCodeText.setText(ldsfield.getStringValue());
            postalCodeText.setEnabled(false);
            postalCodeText.setFocusable(false);
            postalCodeText.setFocusableInTouchMode(false);
            return;
        }
    }

    private void updateReturnPolicyValues()
    {
        int i = 1;
        Object obj = latestDraft.refundReturnsAccepted.getStringValue();
        boolean flag;
        if (obj != null && ((String) (obj)).equals("ReturnsAccepted"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = returnPolicy;
        if (flag)
        {
            i = 0;
        }
        ((EbaySpinner) (obj)).setSelection(i);
        if (flag)
        {
            if (returnPeriodAdapter.getCount() == 0)
            {
                returnPolicyProgress.setVisibility(0);
                returnPolicy.setEnabled(false);
                return;
            } else
            {
                showReturnsAcceptedOptions();
                updateSpinnerValue(latestDraft.refundReturnPeriod, returnPeriod);
                updateSpinnerValue(latestDraft.refundMethod, refundMethod);
                updateSpinnerValue(latestDraft.refundShipmentPayee, returnShippingPaidBy);
                updateSpinnerValue(latestDraft.refundRestockingFee, restockingFee);
                return;
            }
        } else
        {
            hideReturnsAcceptedOptions();
            return;
        }
    }

    private void updateSpinnerOptions(LdsField ldsfield, ArrayAdapter arrayadapter)
    {
        if (ldsfield.options != null)
        {
            for (ldsfield = ldsfield.options.iterator(); ldsfield.hasNext(); arrayadapter.add((LdsOption)ldsfield.next())) { }
        }
    }

    private void updateSpinnerValue(LdsField ldsfield, EbaySpinner ebayspinner)
    {
label0:
        {
            if (ldsfield.options == null)
            {
                break label0;
            }
            viewUpdate(ebayspinner, ldsfield);
            String s = ldsfield.getStringValue();
            Iterator iterator = ldsfield.options.iterator();
            LdsOption ldsoption;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                ldsoption = (LdsOption)iterator.next();
            } while (!ldsoption.value.equals(s));
            ebayspinner.setSelection(ldsfield.options.indexOf(ldsoption));
        }
    }

    private void updateState()
    {
        viewUpdate(paypalEmailAddress, latestDraft.paypalEmailAddress);
        viewUpdate(immediatePayCheckBox, latestDraft.immediatePay);
        updatePaymentMethods(latestDraft.paymentMethods);
        viewUpdate(countrySpinner, latestDraft.locationCountry);
        viewUpdate(cityStateText, latestDraft.locationCityState);
        viewUpdate(handlingSpinner, latestDraft.handlingTime);
        updatePostalCode(latestDraft.locationPostalCode, latestDraft.locationCountry);
        viewUpdate(returnPolicy, latestDraft.refundReturnsAccepted);
        viewUpdate(policyDetails, latestDraft.refundPolicyDetails);
        viewUpdate(returnShippingPaidBy, latestDraft.refundShipmentPayee);
        viewUpdate(restockingFee, latestDraft.refundRestockingFee);
        if (returnPolicyProgress.getVisibility() == 0)
        {
            returnPolicyProgress.setVisibility(8);
        }
        if (countryAdapter.isEmpty())
        {
            updateSpinnerOptions(latestDraft.locationCountry, countryAdapter);
        }
        if (handlingAdapter.isEmpty())
        {
            loadHandlingTimeOptions();
        }
        if (returnPeriodAdapter.getCount() == 0)
        {
            updateSpinnerOptions(latestDraft.refundReturnPeriod, returnPeriodAdapter);
        }
        if (refundMethodAdapter.getCount() == 0)
        {
            updateSpinnerOptions(latestDraft.refundMethod, refundMethodAdapter);
        }
        if (returnShippingPaidByAdapter.getCount() == 0)
        {
            updateSpinnerOptions(latestDraft.refundShipmentPayee, returnShippingPaidByAdapter);
        }
        if (restockingFeeAdapter.getCount() == 0)
        {
            updateSpinnerOptions(latestDraft.refundRestockingFee, restockingFeeAdapter);
        }
        updateCharityState();
    }

    private void updateValues()
    {
        initializeTextFieldValues();
        if (latestDraft.paypalEmailAddressKnown != null)
        {
            paypalEmailAddressAdapter.clear();
            LdsOption ldsoption;
            for (Iterator iterator = latestDraft.paypalEmailAddressKnown.options.iterator(); iterator.hasNext(); paypalEmailAddressAdapter.add(ldsoption.value))
            {
                ldsoption = (LdsOption)iterator.next();
            }

            paypalEmailAddressAdapter.notifyDataSetChanged();
        }
        updateSpinnerValue(latestDraft.locationCountry, countrySpinner);
        updateCheckedTextValue(immediatePayCheckBox, latestDraft.immediatePay);
        updateCharityValues();
    }

    protected int getLayoutResource()
    {
        return 0x7f03020f;
    }

    public int getTitleRes()
    {
        return 0x7f0709d6;
    }

    protected void handleValidationError(String s)
    {
        if ("Listing.PaymentInfo.PaypalEmailAddress".equals(s))
        {
            paypalEmailAddress.requestFocus();
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        imageCache = new ImageCache(getActivity());
    }

    public void onChange(int i, Object obj)
    {
        switch (i)
        {
        default:
            return;

        case 2131756668: 
            boolean flag = obj.equals(getString(0x7f070928));
            dm.updateReturnPolicyAccepted(flag);
            return;

        case 2131756664: 
            if (minimumExceptionHandlingTime > -1 && ((LdsOption)obj).getIntValue() >= minimumExceptionHandlingTime)
            {
                com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
                builder.setMessage(getString(0x7f070162));
                builder.setPositiveButton(0x7f070738);
                builder.createFromFragment(0, this).show(getFragmentManager(), null);
            }
            dm.updateHandlingTime(((LdsOption)obj).getIntValue());
            return;

        case 2131756665: 
            obj = ((LdsOption)obj).value;
            dm.updateLocationCountry(((String) (obj)));
            return;

        case 2131756672: 
            obj = ((LdsOption)obj).value;
            dm.updateReturnsWithin(((String) (obj)));
            return;

        case 2131756675: 
            obj = ((LdsOption)obj).value;
            dm.updateRefundMethod(((String) (obj)));
            return;

        case 2131756678: 
            obj = ((LdsOption)obj).value;
            dm.updateRefundShipmentPayee(((String) (obj)));
            return;

        case 2131756681: 
            obj = ((LdsOption)obj).value;
            dm.updateRefundRestockingFee(((String) (obj)));
            return;
        }
    }

    public void onClick(View view)
    {
        int k;
        int l;
        switch (view.getId())
        {
        default:
            return;

        case 2131756658: 
            view = new com.ebay.app.AlertDialogFragment.Builder();
            view.setTitle(getString(0x7f070585));
            String as[] = getPaymentMethods();
            boolean aflag[] = getCheckedPaymentMethods();
            view.setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc).setMultiChoiceItems(as, aflag);
            view.createFromFragment(1, this).show(getFragmentManager(), "paymentmethods");
            return;

        case 2131756663: 
            immediatePayCheckBox.toggle();
            dm.updateImmediatePay(immediatePayCheckBox.isChecked());
            return;

        case 2131756805: 
            int i;
            boolean flag;
            if (!showingAdvancedOptions)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            showingAdvancedOptions = flag;
            view = showMoreArrow;
            if (showingAdvancedOptions)
            {
                i = 0x7f020256;
            } else
            {
                i = 0x7f020252;
            }
            view.setImageResource(i);
            view = showMoreText;
            if (showingAdvancedOptions)
            {
                i = 0x7f0705c1;
            } else
            {
                i = 0x7f0705c2;
            }
            view.setText(i);
            showOrHideView(immediatePayRow, showingAdvancedOptions, -2, showMoreLayout.getHeight(), true);
            return;

        case 2131756688: 
            if (donationCheckBox.isChecked())
            {
                if (favoriteCharities != null && favoriteCharities.size() == 1)
                {
                    view = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)favoriteCharities.get(0);
                    ((ListingFragmentActivity)getActivity()).setCharityChanged(true);
                    dm.updateDonationEnabled(true, ((com.ebay.common.model.givingworks.NonprofitData.Nonprofit) (view)).nonprofitId, ((com.ebay.common.model.givingworks.NonprofitData.Nonprofit) (view)).name);
                    return;
                } else
                {
                    donationCheckBox.setChecked(false);
                    showCharitySelector();
                    return;
                }
            } else
            {
                dm.updateDonationEnabled(false, "0", null);
                return;
            }

        case 2131756693: 
            showCharitySelector();
            return;

        case 2131756696: 
            view = new ArrayList();
            l = 0;
            k = -1;
            break;
        }
        if (donationPercentage.getTag() != null)
        {
            k = ((LdsOption)donationPercentage.getTag()).getIntValue();
        }
        int j = 0;
        Object obj = latestDraft.charityDonationPercent.options.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            LdsOption ldsoption = (LdsOption)((Iterator) (obj)).next();
            if (ldsoption.getIntValue() != -1)
            {
                view.add(ldsoption.caption);
                if (ldsoption.getIntValue() == k)
                {
                    l = j;
                }
                j++;
            }
        } while (true);
        obj = new NumberPickerDialogFragment();
        ((NumberPickerDialogFragment) (obj)).setNumberPickerListener(this);
        ((NumberPickerDialogFragment) (obj)).setCaptionsAndStartOffset((String[])view.toArray(new String[view.size()]), Integer.valueOf(l));
        ((NumberPickerDialogFragment) (obj)).show(getFragmentManager(), "donationPicker");
    }

    public void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.DispatchType dispatchtype)
    {
        if (listingdraftcontent.getStatus().hasError())
        {
            return;
        }
        boolean flag = false;
        if (latestDraft == null)
        {
            flag = true;
        }
        latestDraft = (ListingDraft)listingdraftcontent.getData();
        updateState();
        if (flag)
        {
            updateValues();
        } else
        if (latestDraft.charityId != null && charityId != null && !charityId.equals(latestDraft.charityId.getStringValue()))
        {
            updateCharityValues();
        }
        updateReturnPolicyValues();
        progress.setVisibility(8);
        parent.setVisibility(0);
        if (latestDraft.charityId != null)
        {
            listingdraftdatamanager = latestDraft.charityId.getStringValue();
        } else
        {
            listingdraftdatamanager = null;
        }
        charityId = listingdraftdatamanager;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initDataManagers();
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i == 1 && j == 1)
        {
            boolean aflag[] = ((AlertDialogFragment)dialogfragment).getCheckedItems();
            dm.updatePaymentMethods(aflag);
        }
        dialogfragment.dismiss();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        dm = (ListingDraftDataManager)datamanagercontainer.initialize((com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.KeyParams)getArguments().getParcelable("key_params"), this);
        if (DeviceConfiguration.getAsync().get(DcsBoolean.ebayGivingSelling))
        {
            datamanagercontainer.initialize(NonProfitDataManager.KEY, this);
            return;
        } else
        {
            favoriteCharities = new ArrayList();
            return;
        }
    }

    public void onNonProfitsChanged(NonProfitDataManager nonprofitdatamanager, Content content)
    {
        if (!content.getStatus().hasError() && content.getData() != null)
        {
            favoriteCharities = new ArrayList((Collection)content.getData());
        } else
        {
            favoriteCharities = null;
        }
        if (latestDraft != null)
        {
            updateCharityValues();
            updateCharityState();
        }
    }

    public void onNumberSelected(int i)
    {
        ((ListingFragmentActivity)getActivity()).setDonationChanged(true);
        LdsOption ldsoption;
        if (((LdsOption)latestDraft.charityDonationPercent.options.get(0)).getIntValue() == -1)
        {
            ldsoption = (LdsOption)latestDraft.charityDonationPercent.options.get(i + 1);
        } else
        {
            ldsoption = (LdsOption)latestDraft.charityDonationPercent.options.get(i);
        }
        donationPercentage.setTag(ldsoption);
        donationPercentage.setText(ldsoption.caption);
        dm.updateDonationPercentage(ldsoption.value);
    }

    public void onResume()
    {
        super.onResume();
        ((ListingFragmentActivity)getActivity()).sendTrackingForSpokeEvent("SellingUserPrefs");
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        ((TextView)view.findViewById(0x7f10069a)).setText(Html.fromHtml(getString(0x7f0709b5)));
        handlingSpinner = (EbaySpinner)view.findViewById(0x7f100678);
        handlingAdapter = new HandlingTimeAdapter(view.getContext());
        handlingSpinner.setChangeListener(this);
        countrySpinner = (EbaySpinner)view.findViewById(0x7f100679);
        countryAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        countryAdapter.setDropDownViewResource(0x1090009);
        countrySpinner.setAdapter(countryAdapter);
        countrySpinner.setChangeListener(this);
        cityStateText = (EditText)view.findViewById(0x7f10067b);
        postalCodeText = (EditText)view.findViewById(0x7f10067a);
        returnPeriodLayout = view.findViewById(0x7f10067e);
        returnPeriod = (EbaySpinner)view.findViewById(0x7f100680);
        returnPeriodAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        returnPeriodAdapter.setDropDownViewResource(0x1090009);
        returnPeriod.setAdapter(returnPeriodAdapter);
        returnPeriod.setChangeListener(this);
        refundMethodLayout = view.findViewById(0x7f100681);
        refundMethod = (EbaySpinner)view.findViewById(0x7f100683);
        refundMethodAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        refundMethodAdapter.setDropDownViewResource(0x7f030217);
        refundMethod.setAdapter(refundMethodAdapter);
        refundMethod.setChangeListener(this);
        returnShippingPaidByLayout = view.findViewById(0x7f100684);
        returnShippingPaidBy = (EbaySpinner)view.findViewById(0x7f100686);
        returnShippingPaidByAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        returnShippingPaidByAdapter.setDropDownViewResource(0x7f030217);
        returnShippingPaidBy.setAdapter(returnShippingPaidByAdapter);
        returnShippingPaidBy.setChangeListener(this);
        restockingFeeLayout = view.findViewById(0x7f100687);
        restockingFee = (EbaySpinner)view.findViewById(0x7f100689);
        restockingFeeAdapter = new ArrayAdapter(view.getContext(), 0x7f030223);
        restockingFeeAdapter.setDropDownViewResource(0x1090009);
        restockingFee.setAdapter(restockingFeeAdapter);
        restockingFee.setChangeListener(this);
        policyDetailsLayout = view.findViewById(0x7f10068a);
        policyDetails = (EditText)view.findViewById(0x7f10068c);
        paymentMethodsButton = (Button)view.findViewById(0x7f100672);
        paymentMethodsButton.setOnClickListener(this);
        paypalEmailAddressRow = (LinearLayout)view.findViewById(0x7f100673);
        paypalEmailAddress = (PaypalEmailAutoComplete)view.findViewById(0x7f100675);
        paypalEmailAddress.setFilters(new InputFilter[] {
            new EmailAddressInputFilter()
        });
        paypalEmailAddressAdapter = new ArrayAdapter(view.getContext(), 0x7f030209);
        paypalEmailAddress.setAdapter(paypalEmailAddressAdapter);
        paypalEmailAddress.setThreshold(0);
        (new Handler()).post(new Runnable() {

            final PreferencesSpokeFragment this$0;

            public void run()
            {
                paypalEmailAddress.dismissDropDown();
            }

            
            {
                this$0 = PreferencesSpokeFragment.this;
                super();
            }
        });
        immediatePayRow = view.findViewById(0x7f100676);
        immediatePayCheckBox = (CheckedTextView)view.findViewById(0x7f100677);
        immediatePayCheckBox.setOnClickListener(this);
        immediatePayHelpTitle = view.findViewById(0x7f100699);
        immediatePayHelpContent = view.findViewById(0x7f10069a);
        returnPolicy = (EbaySpinner)view.findViewById(0x7f10067c);
        bundle = new ArrayAdapter(view.getContext(), 0x7f030223, view.getContext().getResources().getStringArray(0x7f0e0018));
        bundle.setDropDownViewResource(0x7f030217);
        returnPolicy.setAdapter(bundle);
        returnPolicy.setChangeListener(this);
        donationPercentageContainer = view.findViewById(0x7f100696);
        favoriteCharitiesContainer = view.findViewById(0x7f100693);
        donationCheckBox = (CheckBox)view.findViewById(0x7f100690);
        donationCheckBox.setOnClickListener(this);
        donationPercentage = (TextView)view.findViewById(0x7f100698);
        donationPercentage.setOnClickListener(this);
        charityContainer = view.findViewById(0x7f10068f);
        charityTitle = view.findViewById(0x7f10068d);
        charitySubtitle = (TextView)view.findViewById(0x7f10068e);
        donationTextView = (TextView)view.findViewById(0x7f100692);
        charityName = (TextView)view.findViewById(0x7f100695);
        charityName.setOnClickListener(this);
        returnPolicyProgress = view.findViewById(0x7f10067d);
        showMoreLayout = view.findViewById(0x7f100705);
        showMoreLayout.setOnClickListener(this);
        showMoreText = (TextView)view.findViewById(0x7f100706);
        showMoreArrow = (ImageView)view.findViewById(0x7f100707);
        progress = view.findViewById(0x7f100143);
        parent = view.findViewById(0x7f1004bc);
        progress.setVisibility(0);
        parent.setVisibility(8);
    }

    protected void saveOutstandingChanges(boolean flag)
    {
        com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PreferenceTextFields preferencetextfields = new com.ebay.nautilus.domain.content.dm.ListingDraftDataManager.PreferenceTextFields();
        preferencetextfields.paypalEmail = paypalEmailAddress.getText().toString();
        preferencetextfields.postalCode = postalCodeText.getText().toString();
        preferencetextfields.cityState = cityStateText.getText().toString();
        preferencetextfields.returnsDetails = policyDetails.getText().toString();
        dm.updatePreferenceTextFields(preferencetextfields, flag);
    }
}
