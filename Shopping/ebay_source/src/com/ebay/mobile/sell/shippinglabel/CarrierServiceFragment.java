// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.ebay.common.util.EbaySettings;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity

public class CarrierServiceFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{

    private LinkedHashMap fedexServices;
    private LayoutInflater inflater;
    private View recommendedServiceContainer;
    private View selectedService;
    protected int servicesContainerHeight;
    protected boolean showingServices;
    private LinkedHashMap uspsServices;

    public CarrierServiceFragment()
    {
        uspsServices = new LinkedHashMap();
        showingServices = false;
    }

    private void updateFedexShippingServicesUI()
    {
        ViewGroup viewgroup = (ViewGroup)getView().findViewById(0x7f100755);
        com.ebay.nautilus.domain.data.ShippingOption.ShippingKey shippingkey = ((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey;
        viewgroup.removeAllViews();
        Set set = fedexServices.keySet();
        View view = inflater.inflate(0x7f030236, viewgroup, false);
        ViewGroup viewgroup1 = (ViewGroup)view.findViewById(0x7f100763);
        view.findViewById(0x7f100762).setVisibility(8);
        Iterator iterator;
        if (set.size() > 1)
        {
            view.setTag(Boolean.valueOf(false));
        } else
        {
            view.setTag(Boolean.valueOf(true));
        }
        viewgroup1.removeAllViews();
        iterator = set.iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (String)iterator.next();
            ArrayList arraylist = (ArrayList)fedexServices.get(obj);
            ShippingOption shippingoption = null;
            Iterator iterator1 = arraylist.iterator();
            do
            {
                obj = shippingoption;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj = (ShippingOption)iterator1.next();
            } while (!((ShippingOption) (obj)).shippingKey.packageType.equals(shippingkey.packageType));
            shippingoption = ((ShippingOption) (obj));
            if (obj == null)
            {
                shippingoption = (ShippingOption)arraylist.get(0);
            }
            obj = inflater.inflate(0x7f03023a, viewgroup1, false);
            ((View) (obj)).setTag(shippingoption);
            ((View) (obj)).setOnClickListener(this);
            ((RadioButton)((View) (obj)).findViewById(0x7f100750)).setText(shippingoption.attributes.serviceName);
            if (shippingoption.costPlans.size() > 0)
            {
                ((TextView)((View) (obj)).findViewById(0x7f100751)).setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)shippingoption.costPlans.get(0)).cost.currency, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)shippingoption.costPlans.get(0)).cost.value, 2));
            } else
            {
                ((TextView)((View) (obj)).findViewById(0x7f100751)).setText("");
            }
            if (!shippingoption.selected)
            {
                continue;
            }
            ((View) (obj)).setVisibility(8);
            selectedService = ((View) (obj));
            if (((Boolean)view.getTag()).booleanValue())
            {
                view.setVisibility(8);
            }
            updateSelectedServiceText(shippingoption);
            viewgroup1.addView(((View) (obj)));
        }
        viewgroup.addView(view);
        if (selectedService == null)
        {
            recommendedServiceContainer.setVisibility(8);
            getView().findViewById(0x7f10074d).setVisibility(8);
        }
    }

    private void updateSelectedServiceText(ShippingOption shippingoption)
    {
        View view = getView().findViewById(0x7f10074f);
        ((TextView)view.findViewById(0x7f100752)).setText(shippingoption.attributes.serviceInfo);
        RadioButton radiobutton = (RadioButton)view.findViewById(0x7f100750);
        Object obj = shippingoption.getEstimatedDeliveryDateString(getActivity());
        if (obj != null)
        {
            obj = getString(0x7f07083a, new Object[] {
                obj
            });
            obj = new SpannableString((new StringBuilder()).append(shippingoption.attributes.serviceLongName).append("\n").append(((String) (obj))).toString());
            ((Spannable) (obj)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d00e7)), shippingoption.attributes.serviceLongName.length(), ((Spannable) (obj)).length(), 33);
            ((Spannable) (obj)).setSpan(new StyleSpan(0), shippingoption.attributes.serviceLongName.length(), ((Spannable) (obj)).length(), 33);
            radiobutton.setText(((CharSequence) (obj)));
        } else
        {
            radiobutton.setText(shippingoption.attributes.serviceLongName);
        }
        radiobutton.setChecked(true);
        if (shippingoption.costPlans.size() > 0)
        {
            shippingoption = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)shippingoption.costPlans.get(0)).cost;
            ((TextView)view.findViewById(0x7f100751)).setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.Cost) (shippingoption)).currency, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.Cost) (shippingoption)).value, 2));
            return;
        } else
        {
            ((TextView)view.findViewById(0x7f100751)).setText("");
            return;
        }
    }

    private void updateServiceAndCarrier(ShippingOption shippingoption)
    {
        ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
        com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippinglabeldraft, ((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey);
        labelrequestparams.spec.packageShape = com.ebay.nautilus.domain.data.ShippingLabelPackage.PackageShapeType.REGULAR;
        labelrequestparams.shippingKey = shippingoption.shippingKey;
        ((ShippingLabelActivity)getActivity()).shippingLabelDraftDataManager.updateDraftPackage(labelrequestparams, shippinglabeldraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
    }

    private void updateUSPSShippingServicesUI()
    {
        Object obj = uspsServices.keySet();
        ViewGroup viewgroup = (ViewGroup)getView().findViewById(0x7f100755);
        viewgroup.removeAllViews();
        View view;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); viewgroup.addView(view))
        {
            Object obj1 = (String)((Iterator) (obj)).next();
            view = inflater.inflate(0x7f030236, viewgroup, false);
            ViewGroup viewgroup1 = (ViewGroup)view.findViewById(0x7f100763);
            obj1 = (ArrayList)uspsServices.get(obj1);
            Object obj2 = (ShippingOption)((ArrayList) (obj1)).get(0);
            if (((ShippingOption) (obj2)).deliveryEstimate != null)
            {
                obj2 = getString(0x7f070871, new Object[] {
                    ((ShippingOption) (obj2)).attributes.serviceName, Integer.valueOf(((ShippingOption) (obj2)).deliveryEstimate.minDays), Integer.valueOf(((ShippingOption) (obj2)).deliveryEstimate.maxDays)
                });
                ((TextView)view.findViewById(0x7f100762)).setText(((CharSequence) (obj2)));
            } else
            {
                ((TextView)view.findViewById(0x7f100762)).setText(((ShippingOption) (obj2)).attributes.serviceName);
            }
            viewgroup1.removeAllViews();
            if (((ArrayList) (obj1)).size() > 1)
            {
                view.setTag(Boolean.valueOf(false));
            } else
            {
                view.setTag(Boolean.valueOf(true));
            }
            obj1 = ((ArrayList) (obj1)).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                obj2 = (ShippingOption)((Iterator) (obj1)).next();
                View view1 = inflater.inflate(0x7f03023a, viewgroup1, false);
                view1.setTag(obj2);
                view1.setOnClickListener(this);
                ((RadioButton)view1.findViewById(0x7f100750)).setText(((ShippingOption) (obj2)).attributes.packageName);
                if (((ShippingOption) (obj2)).costPlans.size() > 0)
                {
                    ((TextView)view1.findViewById(0x7f100751)).setText(EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)((ShippingOption) (obj2)).costPlans.get(0)).cost.currency, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)((ShippingOption) (obj2)).costPlans.get(0)).cost.value, 2));
                } else
                {
                    ((TextView)view1.findViewById(0x7f100751)).setText("");
                }
                if (!((ShippingOption) (obj2)).selected)
                {
                    continue;
                }
                view1.setVisibility(8);
                selectedService = view1;
                if (((Boolean)view.getTag()).booleanValue())
                {
                    view.setVisibility(8);
                }
                updateSelectedServiceText(((ShippingOption) (obj2)));
                viewgroup1.addView(view1);
            }
        }

        if (selectedService == null)
        {
            recommendedServiceContainer.setVisibility(8);
            getView().findViewById(0x7f10074d).setVisibility(8);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        recommendedServiceContainer = getView().findViewById(0x7f10074e);
        super.onActivityCreated(bundle);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131756873: 301
    //                   2131756875: 155
    //                   2131756883: 49;
           goto _L1 _L2 _L3 _L4
_L1:
        if (selectedService != view) goto _L6; else goto _L5
_L5:
        return;
_L4:
        View view1 = getView().findViewById(0x7f100755);
        boolean flag;
        if (showingServices)
        {
            ShippingLabelActivity.showOrHideView(view1, servicesContainerHeight, 0, Integer.valueOf(0));
            ((ImageView)view.findViewById(0x7f100707)).setImageResource(0x7f020252);
        } else
        {
            ShippingLabelActivity.showOrHideView(view1, 0, servicesContainerHeight, Integer.valueOf(-2));
            ((ImageView)view.findViewById(0x7f100707)).setImageResource(0x7f020256);
            getView().invalidate();
        }
        if (!showingServices)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showingServices = flag;
        return;
_L3:
        if (selectedService == null || !((ShippingOption)selectedService.getTag()).shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.USPS.name()))
        {
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).showProgress();
            ((RadioButton)getView().findViewById(0x7f10074c)).setChecked(true);
            ((RadioButton)getView().findViewById(0x7f10074a)).setChecked(false);
            view = uspsServices.keySet().iterator();
            if (view.hasNext())
            {
                view = (String)view.next();
                updateServiceAndCarrier((ShippingOption)((ArrayList)uspsServices.get(view)).get(0));
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (selectedService == null || !((ShippingOption)selectedService.getTag()).shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name()))
        {
            getView().setVisibility(8);
            ((ShippingLabelActivity)getActivity()).showProgress();
            ((RadioButton)getView().findViewById(0x7f10074a)).setChecked(true);
            ((RadioButton)getView().findViewById(0x7f10074c)).setChecked(false);
            view = fedexServices.keySet().iterator();
            if (view.hasNext())
            {
                view = (String)view.next();
                updateServiceAndCarrier((ShippingOption)((ArrayList)fedexServices.get(view)).get(0));
                return;
            }
        }
        if (true) goto _L5; else goto _L6
_L6:
        getView().setVisibility(8);
        ((ShippingLabelActivity)getActivity()).showProgress();
        selectedService = view;
        updateServiceAndCarrier((ShippingOption)view.getTag());
        return;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030230, viewgroup, false);
        layoutinflater.findViewById(0x7f100753).setOnClickListener(this);
        return layoutinflater;
    }

    public void setActionBarState()
    {
        super.setActionBarState();
        setToolbarTitle(0x7f070829);
    }

    public void updateUI()
    {
        if (((ShippingLabelActivity)getActivity()).shippingLabelDraft != null)
        {
            getView().setVisibility(0);
        }
        fedexServices = ((ShippingLabelActivity)getActivity()).fedexServices;
        uspsServices = ((ShippingLabelActivity)getActivity()).uspsServices;
        final View services = getView().findViewById(0x7f100755);
        services.setVisibility(4);
        android.view.ViewGroup.LayoutParams layoutparams = services.getLayoutParams();
        layoutparams.height = -2;
        services.setLayoutParams(layoutparams);
        if (fedexServices != null && fedexServices.size() > 0)
        {
            getView().findViewById(0x7f100749).setOnClickListener(this);
            getView().findViewById(0x7f100749).setVisibility(0);
            if (((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey.carrier.name().equals("FEDEX"))
            {
                ((RadioButton)getView().findViewById(0x7f10074a)).setChecked(true);
                updateFedexShippingServicesUI();
            } else
            {
                ((RadioButton)getView().findViewById(0x7f10074a)).setChecked(false);
            }
        }
        if (uspsServices != null && uspsServices.size() > 0)
        {
            getView().findViewById(0x7f10074b).setOnClickListener(this);
            getView().findViewById(0x7f10074b).setVisibility(0);
            if (((ShippingLabelActivity)getActivity()).selectedShippingService.shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingLabelDetails.ShippingCarrier.USPS.name()))
            {
                ((RadioButton)getView().findViewById(0x7f10074c)).setChecked(true);
                updateUSPSShippingServicesUI();
            } else
            {
                ((RadioButton)getView().findViewById(0x7f10074c)).setChecked(false);
            }
        }
        services.post(new Runnable() {

            final CarrierServiceFragment this$0;
            final View val$services;

            public void run()
            {
                servicesContainerHeight = services.getHeight();
                android.view.ViewGroup.LayoutParams layoutparams1 = services.getLayoutParams();
                layoutparams1.height = 0;
                showingServices = false;
                services.setLayoutParams(layoutparams1);
                services.setVisibility(0);
            }

            
            {
                this$0 = CarrierServiceFragment.this;
                services = view;
                super();
            }
        });
    }
}
