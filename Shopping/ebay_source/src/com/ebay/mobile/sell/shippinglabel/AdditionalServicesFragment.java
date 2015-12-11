// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class AdditionalServicesFragment extends ShippingLabelBaseFragment
    implements android.widget.CompoundButton.OnCheckedChangeListener
{
    private class OrderNumberTextWatcher
        implements TextWatcher
    {

        final AdditionalServicesFragment this$0;

        public void afterTextChanged(Editable editable)
        {
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
            skuTextCountDisplay.setText(getString(0x7f070877, new Object[] {
                Integer.valueOf(charsequence.length())
            }));
        }

        private OrderNumberTextWatcher()
        {
            this$0 = AdditionalServicesFragment.this;
            super();
        }

    }


    protected int declaredValueHeight;
    protected int declaredValueMinimizedHeight;
    private LayoutInflater inflater;
    protected View insuranceContainer;
    protected RadioButton selectedSigConf;
    protected int skuHeight;
    protected int skuMinimizedHeight;
    protected TextView skuTextCountDisplay;

    public AdditionalServicesFragment()
    {
    }

    private void addSignatureConfirmationOptions(ShippingOption shippingoption, String s)
    {
label0:
        {
            Object obj = getView();
            if (shippingoption.attributes.signatureConfirmationSupported && shippingoption.attributes.sigConOptionsSupported.size() > 0)
            {
                ((View) (obj)).findViewById(0x7f100738).setVisibility(0);
                ((View) (obj)).findViewById(0x7f10073b).setVisibility(8);
                obj = (ViewGroup)((View) (obj)).findViewById(0x7f10073a);
                ((ViewGroup) (obj)).setVisibility(0);
                ((ViewGroup) (obj)).removeAllViews();
                View view;
                for (shippingoption = shippingoption.attributes.sigConOptionsSupported.iterator(); shippingoption.hasNext(); ((ViewGroup) (obj)).addView(view))
                {
                    com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions shippingconfirmationoptions = (com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions)shippingoption.next();
                    view = inflater.inflate(0x7f030234, ((ViewGroup) (obj)), false);
                    View view1 = view.findViewById(0x7f10075f);
                    if (shippingconfirmationoptions.optionToken.equals(s))
                    {
                        selectedSigConf = (RadioButton)view1;
                        selectedSigConf.setChecked(true);
                    }
                    ((TextView)view.findViewById(0x7f10075e)).setText(shippingconfirmationoptions.optionDisplayValue);
                    view1.setTag(shippingconfirmationoptions);
                    view.setOnClickListener(new android.view.View.OnClickListener() {

                        final AdditionalServicesFragment this$0;

                        public void onClick(View view2)
                        {
                            if (selectedSigConf != null)
                            {
                                selectedSigConf.setChecked(false);
                            }
                            selectedSigConf = (RadioButton)view2.findViewById(0x7f10075f);
                            selectedSigConf.setChecked(true);
                        }

            
            {
                this$0 = AdditionalServicesFragment.this;
                super();
            }
                    });
                }

            } else
            {
                if (!shippingoption.attributes.signatureConfirmationSupported)
                {
                    break label0;
                }
                shippingoption = (CheckBox)((View) (obj)).findViewById(0x7f10073d);
                if (s != null && s.equals("true"))
                {
                    shippingoption.setChecked(true);
                } else
                {
                    shippingoption.setChecked(false);
                }
                ((View) (obj)).findViewById(0x7f100738).setVisibility(0);
                ((View) (obj)).findViewById(0x7f10073b).setVisibility(0);
                ((View) (obj)).findViewById(0x7f10073a).setVisibility(8);
            }
            return;
        }
        getView().findViewById(0x7f10073a).setVisibility(8);
        getView().findViewById(0x7f100738).setVisibility(8);
        getView().findViewById(0x7f10073b).setVisibility(8);
        getView().findViewById(0x7f100739).setVisibility(8);
    }

    private boolean isEqual(double d, double d1)
    {
        return Math.abs(d - d1) < 0.0001D;
    }

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        switch (compoundbutton.getId())
        {
        default:
            return;

        case 2131756852: 
            compoundbutton = (ViewGroup)getView().findViewById(0x7f100732);
            if (flag)
            {
                ShippingLabelActivity.showOrHideView(compoundbutton, declaredValueMinimizedHeight, declaredValueHeight, Integer.valueOf(-2));
                return;
            } else
            {
                ShippingLabelActivity.showOrHideView(compoundbutton, declaredValueHeight, declaredValueMinimizedHeight, Integer.valueOf(declaredValueMinimizedHeight));
                return;
            }

        case 2131756865: 
            compoundbutton = (ViewGroup)getView().findViewById(0x7f10073f);
            break;
        }
        if (flag)
        {
            ShippingLabelActivity.showOrHideView(compoundbutton, skuMinimizedHeight, skuHeight, Integer.valueOf(-2));
            return;
        } else
        {
            ShippingLabelActivity.showOrHideView(compoundbutton, skuHeight, skuMinimizedHeight, Integer.valueOf(skuMinimizedHeight));
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03022f, viewgroup, false);
        ((EditText)layoutinflater.findViewById(0x7f100742)).addTextChangedListener(new OrderNumberTextWatcher());
        skuTextCountDisplay = (TextView)layoutinflater.findViewById(0x7f100743);
        return layoutinflater;
    }

    public void sendUpdates()
    {
        ShippingLabelActivity shippinglabelactivity;
        ShippingLabelDraft shippinglabeldraft;
        com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams;
        Object obj;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag2 = false;
        flag = false;
        shippinglabelactivity = (ShippingLabelActivity)getActivity();
        shippinglabeldraft = shippinglabelactivity.shippingLabelDraft;
        obj = shippinglabelactivity.selectedShippingService;
        labelrequestparams = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippinglabeldraft, shippinglabelactivity.selectedShippingService.shippingKey);
        if (!((ShippingOption) (obj)).attributes.signatureConfirmationSupported || ((ShippingOption) (obj)).attributes.sigConOptionsSupported.size() <= 0 || selectedSigConf == null) goto _L2; else goto _L1
_L1:
        com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions shippingconfirmationoptions = (com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions)selectedSigConf.getTag();
        flag1 = false;
        Iterator iterator = labelrequestparams.serviceFeatureValues.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue servicefeaturevalue1 = (com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue)iterator.next();
            if (servicefeaturevalue1.feature.equals(com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeature.SIG_CON.name()))
            {
                if (!servicefeaturevalue1.value.equals(shippingconfirmationoptions.optionToken))
                {
                    flag = true;
                }
                flag1 = true;
                servicefeaturevalue1.value = shippingconfirmationoptions.optionToken;
            }
        } while (true);
        if (!flag1)
        {
            flag = true;
            labelrequestparams.serviceFeatureValues.add(new com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue(com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeature.SIG_CON.name(), shippingconfirmationoptions.optionToken));
        }
_L4:
label0:
        {
            if (!((ShippingOption) (obj)).attributes.carrierInsuranceSupported)
            {
                flag1 = flag;
                if (!((ShippingOption) (obj)).attributes.carrierInsuranceSuppported)
                {
                    break label0;
                }
            }
            Object obj1;
            com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue servicefeaturevalue;
            boolean flag3;
            if (((CheckBox)insuranceContainer.findViewById(0x7f100734)).isChecked())
            {
                PriceView priceview = (PriceView)insuranceContainer.findViewById(0x7f100736);
                labelrequestparams.selectedInsuranceOption = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams.InsuranceProvider(((ShippingOption) (obj)).shippingKey.carrier.name());
                if (!labelrequestparams.selectedInsuranceOption.insuranceProvider.equals(shippinglabelactivity.selectedInsuranceCoverage) || !isEqual(labelrequestparams.declaredValue.value, priceview.getPrice()))
                {
                    labelrequestparams.declaredValue.value = priceview.getPrice();
                    flag = true;
                }
                shippinglabelactivity.selectedInsuranceCoverage = labelrequestparams.selectedInsuranceOption.insuranceProvider;
                flag1 = flag;
            } else
            {
                if (shippinglabelactivity.selectedInsuranceCoverage != null)
                {
                    flag = true;
                }
                labelrequestparams.selectedInsuranceOption = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams.InsuranceProvider(null);
                shippinglabelactivity.selectedInsuranceCoverage = null;
                flag1 = flag;
            }
        }
        obj = getView();
        flag3 = ((CheckBox)((View) (obj)).findViewById(0x7f100746)).isChecked();
        flag = flag1;
        if (shippinglabelactivity.printPostageOnLabel != flag3)
        {
            flag = true;
        }
        shippinglabelactivity.printPostageOnLabel = flag3;
        labelrequestparams.showPostageOnLabel = Boolean.toString(shippinglabelactivity.printPostageOnLabel);
        flag3 = ((CheckBox)((View) (obj)).findViewById(0x7f100741)).isChecked();
        if (flag3 != shippinglabelactivity.showCustomMessage)
        {
            flag = true;
        }
        shippinglabelactivity.showCustomMessage = flag3;
        labelrequestparams.showCustomMessage = Boolean.toString(shippinglabelactivity.showCustomMessage);
        labelrequestparams.customMessage = ((TextView)((View) (obj)).findViewById(0x7f100742)).getText().toString();
        flag1 = flag;
        if (flag3)
        {
            obj = shippinglabelactivity.shippingLabelDraft.labelDetails.customMessage;
            flag1 = flag;
            if (!labelrequestparams.customMessage.equals(obj))
            {
                flag1 = true;
            }
        }
        if (flag1)
        {
            shippinglabelactivity.shippingLabelDraftDataManager.updateDraftPackage(labelrequestparams, shippinglabeldraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
        }
        Util.hideSoftInput(shippinglabelactivity, getView());
        return;
_L2:
        flag = flag1;
        if (((ShippingOption) (obj)).attributes.signatureConfirmationSupported)
        {
            obj1 = (CheckBox)getView().findViewById(0x7f10073d);
            flag3 = false;
            if (obj1 != null)
            {
                flag3 = ((CheckBox) (obj1)).isChecked();
            }
            flag1 = false;
            obj1 = labelrequestparams.serviceFeatureValues.iterator();
            flag = flag2;
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                servicefeaturevalue = (com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue)((Iterator) (obj1)).next();
                if (servicefeaturevalue.feature.equals(com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeature.SIG_CON.name()))
                {
                    if (!servicefeaturevalue.value.equals(Boolean.toString(flag3)))
                    {
                        flag = true;
                    }
                    flag1 = true;
                    servicefeaturevalue.value = Boolean.toString(flag3);
                }
            } while (true);
            if (!flag1)
            {
                flag = true;
                labelrequestparams.serviceFeatureValues.add(new com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue(com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeature.SIG_CON.name(), Boolean.toString(flag3)));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f07081e);
    }

    public void updateUI()
    {
        final View shippingSkuCheckbox = getView();
        shippingSkuCheckbox.setVisibility(0);
        final ShippingLabelActivity activity = (ShippingLabelActivity)getActivity();
        final ViewGroup declaredValueContainer = activity.selectedShippingService;
        boolean flag = ((ShippingOption) (declaredValueContainer)).shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingLabelDetails.ShippingCarrier.USPS.name());
        final Object declaredValueCheck = activity.shippingLabelDraft.labelDetails.customMessage;
        ((EditText)shippingSkuCheckbox.findViewById(0x7f100742)).setText(((CharSequence) (declaredValueCheck)));
        declaredValueCheck = (CheckBox)shippingSkuCheckbox.findViewById(0x7f100741);
        ((CheckBox) (declaredValueCheck)).setChecked(activity.showCustomMessage);
        ((CheckBox) (declaredValueCheck)).setOnCheckedChangeListener(this);
        double d;
        if (flag)
        {
            ((CheckBox)shippingSkuCheckbox.findViewById(0x7f100746)).setChecked(activity.printPostageOnLabel);
            shippingSkuCheckbox.findViewById(0x7f100744).setVisibility(0);
        } else
        {
            shippingSkuCheckbox.findViewById(0x7f100744).setVisibility(8);
        }
        declaredValueCheck = (TextView)shippingSkuCheckbox.findViewById(0x7f100739);
        if (activity.selectedShippingService.attributes.sigConMessage != null)
        {
            ((TextView) (declaredValueCheck)).setVisibility(0);
            ((TextView) (declaredValueCheck)).setText(activity.selectedShippingService.attributes.sigConMessage);
        } else
        {
            ((TextView) (declaredValueCheck)).setVisibility(8);
        }
        addSignatureConfirmationOptions(declaredValueContainer, activity.shippingLabelDraft.labelDetails.sigConSelected);
        d = activity.shippingLabelDraft.labelDetails.pkg.declaredValue.value;
        declaredValueCheck = activity.shippingLabelDraft.labelDetails.pkg.declaredValue.currency;
        insuranceContainer = shippingSkuCheckbox.findViewById(0x7f100747);
        if (((ShippingOption) (declaredValueContainer)).attributes.carrierInsuranceSupported || ((ShippingOption) (declaredValueContainer)).attributes.carrierInsuranceSuppported)
        {
            insuranceContainer.setVisibility(0);
            ((ViewGroup)insuranceContainer).removeAllViews();
            Object obj = inflater;
            final ViewGroup skuContainer;
            int i;
            if (flag)
            {
                i = 0x7f03022e;
            } else
            {
                i = 0x7f030231;
            }
            ((LayoutInflater) (obj)).inflate(i, (ViewGroup)insuranceContainer, true);
            obj = (PriceView)insuranceContainer.findViewById(0x7f100736);
            ((PriceView) (obj)).setPrice(Double.valueOf(d));
            ((PriceView) (obj)).setCurrency(((String) (declaredValueCheck)));
            declaredValueCheck = (CheckBox)insuranceContainer.findViewById(0x7f100734);
            if (!TextUtils.isEmpty(activity.selectedInsuranceCoverage))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((CheckBox) (declaredValueCheck)).setChecked(flag);
            ((CheckBox) (declaredValueCheck)).setOnCheckedChangeListener(this);
            if (((ShippingOption) (declaredValueContainer)).attributes.insMessage != null)
            {
                obj = (TextView)insuranceContainer.findViewById(0x7f100731);
                ((TextView) (obj)).setText(((ShippingOption) (declaredValueContainer)).attributes.insMessage);
                ((TextView) (obj)).setVisibility(0);
            } else
            {
                insuranceContainer.findViewById(0x7f100731).setVisibility(8);
            }
            declaredValueContainer = (ViewGroup)insuranceContainer.findViewById(0x7f100732);
            obj = declaredValueContainer.getLayoutParams();
            obj.height = -2;
            declaredValueContainer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            insuranceContainer.setVisibility(4);
            shippingSkuCheckbox.post(new Runnable() {

                final AdditionalServicesFragment this$0;
                final ShippingLabelActivity val$activity;
                final CheckBox val$declaredValueCheck;
                final ViewGroup val$declaredValueContainer;

                public void run()
                {
                    declaredValueHeight = declaredValueContainer.getHeight();
                    declaredValueMinimizedHeight = declaredValueCheck.getHeight();
                    if (TextUtils.isEmpty(activity.selectedInsuranceCoverage))
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = declaredValueContainer.getLayoutParams();
                        layoutparams.height = declaredValueMinimizedHeight;
                        declaredValueContainer.setLayoutParams(layoutparams);
                    }
                    insuranceContainer.setVisibility(0);
                }

            
            {
                this$0 = AdditionalServicesFragment.this;
                declaredValueContainer = viewgroup;
                declaredValueCheck = checkbox;
                activity = shippinglabelactivity;
                super();
            }
            });
        } else
        {
            insuranceContainer.setVisibility(8);
        }
        shippingSkuCheckbox = getView().findViewById(0x7f100741);
        skuContainer = (ViewGroup)getView().findViewById(0x7f10073f);
        declaredValueCheck = skuContainer.getLayoutParams();
        declaredValueCheck.height = -2;
        skuContainer.setLayoutParams(((android.view.ViewGroup.LayoutParams) (declaredValueCheck)));
        declaredValueCheck = (ViewGroup)getView().findViewById(0x7f10073e);
        ((ViewGroup) (declaredValueCheck)).setVisibility(4);
        ((ViewGroup) (declaredValueCheck)).getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final AdditionalServicesFragment this$0;
            final ShippingLabelActivity val$activity;
            final View val$shippingSkuCheckbox;
            final ViewGroup val$skuContainer;
            final ViewGroup val$skuContainerParent;

            public void onGlobalLayout()
            {
                skuHeight = skuContainer.getHeight();
                skuMinimizedHeight = shippingSkuCheckbox.getHeight();
                if (!activity.showCustomMessage)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = skuContainer.getLayoutParams();
                    layoutparams.height = skuMinimizedHeight;
                    skuContainer.setLayoutParams(layoutparams);
                }
                skuContainerParent.setVisibility(0);
                skuContainerParent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = AdditionalServicesFragment.this;
                skuContainer = viewgroup;
                shippingSkuCheckbox = view;
                activity = shippinglabelactivity;
                skuContainerParent = viewgroup1;
                super();
            }
        });
    }
}
