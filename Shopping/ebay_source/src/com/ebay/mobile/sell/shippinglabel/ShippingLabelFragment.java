// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelOrder;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelBaseFragment, ShippingLabelActivity, PackageInfoFragment, CarrierServiceFragment, 
//            PackageTypeFragment, ShipToAddressFragment, ShipsFromAddressFragment, AdditionalServicesFragment

public class ShippingLabelFragment extends ShippingLabelBaseFragment
    implements android.view.View.OnClickListener
{
    private static final class CostLineItemValues extends Enum
    {

        private static final CostLineItemValues $VALUES[];
        public static final CostLineItemValues DEL_CONFIRMATION;
        public static final CostLineItemValues EBAY_DIS;
        public static final CostLineItemValues FUEL_SURCHARGE;
        public static final CostLineItemValues INSURANCE_COST;
        public static final CostLineItemValues NONMAC_SRCHRG;
        public static final CostLineItemValues OTHER_SURCHARGES;
        public static final CostLineItemValues POSTAGE_COST;
        public static final CostLineItemValues RESI_SURCHARGE;
        public static final CostLineItemValues RETAIL_RATE;
        public static final CostLineItemValues SIG_CONFIRMATION;
        public int displayString;

        public static CostLineItemValues valueOf(String s)
        {
            return (CostLineItemValues)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelFragment$CostLineItemValues, s);
        }

        public static CostLineItemValues[] values()
        {
            return (CostLineItemValues[])$VALUES.clone();
        }

        static 
        {
            EBAY_DIS = new CostLineItemValues("EBAY_DIS", 0, 0x7f070832);
            RETAIL_RATE = new CostLineItemValues("RETAIL_RATE", 1, 0x7f07086c);
            POSTAGE_COST = new CostLineItemValues("POSTAGE_COST", 2, 0x7f07085a);
            INSURANCE_COST = new CostLineItemValues("INSURANCE_COST", 3, 0x7f070846);
            FUEL_SURCHARGE = new CostLineItemValues("FUEL_SURCHARGE", 4, 0x7f070840);
            OTHER_SURCHARGES = new CostLineItemValues("OTHER_SURCHARGES", 5, 0x7f070855);
            NONMAC_SRCHRG = new CostLineItemValues("NONMAC_SRCHRG", 6, 0x7f070850);
            RESI_SURCHARGE = new CostLineItemValues("RESI_SURCHARGE", 7, 0x7f07086a);
            DEL_CONFIRMATION = new CostLineItemValues("DEL_CONFIRMATION", 8, 0x7f07082f);
            SIG_CONFIRMATION = new CostLineItemValues("SIG_CONFIRMATION", 9, 0x7f070875);
            $VALUES = (new CostLineItemValues[] {
                EBAY_DIS, RETAIL_RATE, POSTAGE_COST, INSURANCE_COST, FUEL_SURCHARGE, OTHER_SURCHARGES, NONMAC_SRCHRG, RESI_SURCHARGE, DEL_CONFIRMATION, SIG_CONFIRMATION
            });
        }

        private CostLineItemValues(String s, int i, int j)
        {
            super(s, i);
            displayString = j;
        }
    }

    public static final class PackageTypeImages extends Enum
    {

        private static final PackageTypeImages $VALUES[];
        public static final PackageTypeImages BOX;
        public static final PackageTypeImages ENVLP;
        public static final PackageTypeImages PAK;
        public static final PackageTypeImages TUBE;
        public static final PackageTypeImages YR_PKG;
        public int displayImg;

        public static PackageTypeImages valueOf(String s)
        {
            return (PackageTypeImages)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelFragment$PackageTypeImages, s);
        }

        public static PackageTypeImages[] values()
        {
            return (PackageTypeImages[])$VALUES.clone();
        }

        static 
        {
            ENVLP = new PackageTypeImages("ENVLP", 0, 0x7f020220);
            PAK = new PackageTypeImages("PAK", 1, 0x7f020221);
            BOX = new PackageTypeImages("BOX", 2, 0x7f02021f);
            TUBE = new PackageTypeImages("TUBE", 3, 0x7f020222);
            YR_PKG = new PackageTypeImages("YR_PKG", 4, 0x7f020223);
            $VALUES = (new PackageTypeImages[] {
                ENVLP, PAK, BOX, TUBE, YR_PKG
            });
        }

        private PackageTypeImages(String s, int i, int j)
        {
            super(s, i);
            displayImg = ordinal();
            displayImg = j;
        }
    }


    private final UnderlineSpan noUnderlineSpan = new UnderlineSpan() {

        final ShippingLabelFragment this$0;

        public void updateDrawState(TextPaint textpaint)
        {
            textpaint.setUnderlineText(false);
        }

            
            {
                this$0 = ShippingLabelFragment.this;
                super();
            }
    };

    public ShippingLabelFragment()
    {
    }

    public static PackageTypeImages asPackageTypeImage(String s)
    {
        PackageTypeImages apackagetypeimages[] = PackageTypeImages.values();
        int j = apackagetypeimages.length;
        for (int i = 0; i < j; i++)
        {
            PackageTypeImages packagetypeimages = apackagetypeimages[i];
            if (packagetypeimages.name().equalsIgnoreCase(s))
            {
                return packagetypeimages;
            }
        }

        return null;
    }

    private void createAndAddCostLineItemView(ViewGroup viewgroup, com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostLineItems costlineitems, LayoutInflater layoutinflater, boolean flag)
    {
        boolean flag1 = false;
        if (isEqual(costlineitems.lineItemCost.value, 0.0D))
        {
            flag1 = true;
            if (costlineitems.lineItemName.equals(CostLineItemValues.EBAY_DIS.name()))
            {
                return;
            }
        }
        layoutinflater = layoutinflater.inflate(0x7f030237, viewgroup, false);
        TextView textview = (TextView)layoutinflater.findViewById(0x7f100764);
        TextView textview1 = (TextView)layoutinflater.findViewById(0x7f100765);
        String s = getString(CostLineItemValues.valueOf(costlineitems.lineItemName).displayString);
        if (costlineitems.lineItemName.equals(CostLineItemValues.EBAY_DIS.name()))
        {
            int j = getResources().getColor(0x7f0d009c);
            textview.setTextColor(j);
            textview1.setTextColor(j);
        }
        textview.setText(s);
        int i;
        if (flag1)
        {
            textview1.setText(getString(0x7f070421));
        } else
        if (costlineitems.lineItemCost.value < 0.0D)
        {
            textview1.setText((new StringBuilder()).append("-").append(EbayCurrencyUtil.formatDisplay(costlineitems.lineItemCost.currency, Math.abs(costlineitems.lineItemCost.value), 2)).toString());
        } else
        {
            textview1.setText(EbayCurrencyUtil.formatDisplay(costlineitems.lineItemCost.currency, costlineitems.lineItemCost.value, 2));
        }
        if (flag)
        {
            i = 0;
        } else
        {
            i = viewgroup.getChildCount();
        }
        viewgroup.addView(layoutinflater, i);
    }

    private void createAndAddTotalShippingCost(ViewGroup viewgroup, LayoutInflater layoutinflater, com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan shippingcostplan, boolean flag)
    {
        layoutinflater = layoutinflater.inflate(0x7f030237, viewgroup, false);
        TextView textview = (TextView)layoutinflater.findViewById(0x7f100764);
        TextView textview1;
        int i;
        if (flag)
        {
            textview.setText(getString(0x7f07085c));
        } else
        {
            textview.setText(getString(0x7f07085d));
        }
        textview.setTypeface(textview.getTypeface(), 1);
        i = (int)(getResources().getDimension(0x7f0901bc) / getResources().getDisplayMetrics().density);
        textview.setTextSize(i);
        textview1 = (TextView)layoutinflater.findViewById(0x7f100765);
        textview1.setText(EbayCurrencyUtil.formatDisplay(shippingcostplan.cost.currency, shippingcostplan.cost.value, 2));
        textview1.setTypeface(textview.getTypeface(), 1);
        textview1.setTextSize(i);
        i = getResources().getColor(0x7f0d00dd);
        textview.setTextColor(i);
        textview1.setTextColor(i);
        layoutinflater.setPadding(layoutinflater.getPaddingLeft(), layoutinflater.getPaddingTop(), layoutinflater.getPaddingRight(), layoutinflater.getPaddingBottom());
        viewgroup.addView(layoutinflater, viewgroup.getChildCount());
    }

    private boolean isEqual(double d, double d1)
    {
        return Math.abs(d - d1) < 0.0001D;
    }

    public boolean isHomeUp()
    {
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public boolean onBackPressed()
    {
        return false;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131756941: 
            view = (ShippingLabelActivity)getActivity();
            ShippingLabelDraft shippinglabeldraft = ((ShippingLabelActivity) (view)).shippingLabelDraft;
            ArrayList arraylist = ((ShippingLabelActivity) (view)).selectedShippingService.costPlans;
            List list = shippinglabeldraft.getErrors();
            if (arraylist.size() != 0 || list == null || list.size() == 0)
            {
                getView().setVisibility(8);
                view.generateLabel();
                return;
            } else
            {
                view.handleNonBlockingError(shippinglabeldraft.getErrors(), false);
                return;
            }

        case 2131756923: 
            view = new PackageInfoFragment();
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.addToBackStack("pakcageInfo");
            fragmenttransaction.replace(0x7f100761, view, "package_info_fragment");
            fragmenttransaction.commit();
            return;

        case 2131756917: 
            view = new CarrierServiceFragment();
            FragmentTransaction fragmenttransaction1 = getFragmentManager().beginTransaction();
            fragmenttransaction1.addToBackStack("carrierServices");
            fragmenttransaction1.replace(0x7f100761, view, "carrier_services_fragment");
            fragmenttransaction1.commit();
            return;

        case 2131756921: 
            view = new PackageTypeFragment();
            FragmentTransaction fragmenttransaction2 = getFragmentManager().beginTransaction();
            fragmenttransaction2.addToBackStack("packageType");
            fragmenttransaction2.replace(0x7f100761, view, "package_type_fragment");
            fragmenttransaction2.commit();
            return;

        case 2131756927: 
        case 2131756928: 
            view = new ShipToAddressFragment();
            FragmentTransaction fragmenttransaction3 = getFragmentManager().beginTransaction();
            fragmenttransaction3.addToBackStack("shipTo");
            fragmenttransaction3.replace(0x7f100761, view, "ship_to_fragment");
            fragmenttransaction3.commit();
            return;

        case 2131756931: 
            view = new ShipsFromAddressFragment();
            FragmentTransaction fragmenttransaction4 = getFragmentManager().beginTransaction();
            fragmenttransaction4.addToBackStack("shipFrom");
            fragmenttransaction4.replace(0x7f100761, view, "ship_from_fragment");
            fragmenttransaction4.commit();
            return;

        case 2131756925: 
            view = new AdditionalServicesFragment();
            FragmentTransaction fragmenttransaction5 = getFragmentManager().beginTransaction();
            fragmenttransaction5.addToBackStack("additionalServices");
            fragmenttransaction5.replace(0x7f100761, view, "additional_services_fragment");
            fragmenttransaction5.commit();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f030239, viewgroup, false);
        layoutinflater.findViewById(0x7f10077b).setOnClickListener(this);
        layoutinflater.findViewById(0x7f100779).setOnClickListener(this);
        layoutinflater.findViewById(0x7f100775).setOnClickListener(this);
        layoutinflater.findViewById(0x7f10078d).setOnClickListener(this);
        layoutinflater.findViewById(0x7f10077f).setOnClickListener(this);
        layoutinflater.findViewById(0x7f100780).setOnClickListener(this);
        layoutinflater.findViewById(0x7f100783).setOnClickListener(this);
        layoutinflater.findViewById(0x7f10077d).setOnClickListener(this);
        return layoutinflater;
    }

    public void setActionBarState()
    {
        hideDoneButton();
        setToolbarTitle(0x7f070872);
    }

    public void updateUI()
    {
        Object obj5 = ((ShippingLabelActivity)getActivity()).shippingLabelDraft;
        if (obj5 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view;
        Object obj6;
        boolean flag;
        view = getView();
        view.setVisibility(0);
        view.findViewById(0x7f100766).setVisibility(0);
        view.findViewById(0x7f100771).setVisibility(0);
        obj6 = ((ShippingLabelActivity)getActivity()).selectedShippingService;
        flag = false;
        if (obj6 == null) goto _L4; else goto _L3
_L3:
        flag = ((ShippingOption) (obj6)).shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name());
        Object obj = null;
        Object obj2;
        if (((ShippingOption) (obj6)).deliveryEstimate.minDays > 0 || ((ShippingOption) (obj6)).deliveryEstimate.maxDays > 0)
        {
            int i = ((ShippingOption) (obj6)).deliveryEstimate.minDays;
            int k = ((ShippingOption) (obj6)).deliveryEstimate.maxDays;
            URLSpan aurlspan[];
            URLSpan urlspan;
            if (i > 0 && k > 0 && i != k)
            {
                obj = getString(0x7f070870, new Object[] {
                    Integer.valueOf(i), Integer.valueOf(k)
                });
            } else
            {
                if (i <= 0)
                {
                    i = k;
                }
                obj = getResources().getQuantityString(0x7f080027, i, new Object[] {
                    Integer.valueOf(i)
                });
            }
        }
        obj2 = new StringBuilder(((ShippingOption) (obj6)).attributes.serviceName);
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ((StringBuilder) (obj2)).append(" ").append(((String) (obj)));
        }
        obj = ((ShippingOption) (obj6)).getEstimatedDeliveryDateString(getActivity());
        if (obj != null)
        {
            i = ((StringBuilder) (obj2)).length();
            obj = getString(0x7f07083a, new Object[] {
                obj
            });
            ((StringBuilder) (obj2)).append("\n").append(((String) (obj)));
            obj = new SpannableString(((StringBuilder) (obj2)).toString());
            ((Spannable) (obj)).setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0d00e7)), i, ((Spannable) (obj)).length(), 33);
            ((Spannable) (obj)).setSpan(new StyleSpan(0), i, ((Spannable) (obj)).length(), 33);
            ((TextView)view.findViewById(0x7f100777)).setText(((CharSequence) (obj)));
        } else
        {
            ((TextView)view.findViewById(0x7f100777)).setText(((StringBuilder) (obj2)).toString());
        }
        ((TextView)view.findViewById(0x7f100778)).setText(((ShippingOption) (obj6)).attributes.packageName);
        if (!flag)
        {
            ((ImageView)view.findViewById(0x7f100776)).setImageResource(0x7f020224);
            view.findViewById(0x7f100779).setVisibility(8);
            ((Button)view.findViewById(0x7f10078d)).setText(0x7f070864);
            obj = (TextView)view.findViewById(0x7f10078c);
            obj2 = (Spannable)Html.fromHtml(getString(0x7f07087c));
            aurlspan = (URLSpan[])((Spannable) (obj2)).getSpans(0, ((Spannable) (obj2)).length(), android/text/style/URLSpan);
            k = aurlspan.length;
            for (i = 0; i < k; i++)
            {
                urlspan = aurlspan[i];
                ((Spannable) (obj2)).setSpan(noUnderlineSpan, ((Spannable) (obj2)).getSpanStart(urlspan), ((Spannable) (obj2)).getSpanEnd(urlspan), 0);
            }

            ((TextView) (obj)).setText(((CharSequence) (obj2)));
            ((TextView) (obj)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry apslentry[];
        int j;
        int l;
        ((ImageView)view.findViewById(0x7f100776)).setImageResource(0x7f02021e);
        view.findViewById(0x7f100779).setVisibility(0);
        ((Button)view.findViewById(0x7f10078d)).setText(0x7f07082b);
        apslentry = ((ShippingLabelDraft) (obj5)).additionalData.entry;
        l = apslentry.length;
        j = 0;
_L12:
        if (j >= l) goto _L6; else goto _L7
_L7:
        Object obj3 = apslentry[j];
        if (!((com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry) (obj3)).key.equals("FEDEX_TC_URL")) goto _L9; else goto _L8
_L8:
        TextView textview = (TextView)view.findViewById(0x7f10078c);
        obj3 = (Spannable)Html.fromHtml(getString(0x7f07087b, new Object[] {
            ((com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry) (obj3)).value[0]
        }));
        URLSpan aurlspan1[] = (URLSpan[])((Spannable) (obj3)).getSpans(0, ((Spannable) (obj3)).length(), android/text/style/URLSpan);
        int i1 = aurlspan1.length;
        for (j = 0; j < i1; j++)
        {
            URLSpan urlspan1 = aurlspan1[j];
            ((Spannable) (obj3)).setSpan(noUnderlineSpan, ((Spannable) (obj3)).getSpanStart(urlspan1), ((Spannable) (obj3)).getSpanEnd(urlspan1), 0);
        }

        textview.setText(((CharSequence) (obj3)));
        textview.setMovementMethod(LinkMovementMethod.getInstance());
_L6:
        Object obj1;
        Object obj4;
        obj4 = ((ShippingOption) (obj6)).costPlans;
        LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f100772);
        LinearLayout linearlayout1 = (LinearLayout)view.findViewById(0x7f10078b);
        double d;
        if (((ArrayList) (obj4)).size() == 0)
        {
            linearlayout.setVisibility(8);
            linearlayout1.setVisibility(8);
            view.findViewById(0x7f100773).setVisibility(8);
        } else
        {
            linearlayout.setVisibility(0);
            linearlayout.removeAllViews();
            linearlayout1.setVisibility(0);
            linearlayout1.removeAllViews();
            view.findViewById(0x7f100773).setVisibility(0);
            obj3 = null;
            obj1 = null;
            Object obj7 = ((ArrayList) (obj4)).iterator();
            do
            {
                if (!((Iterator) (obj7)).hasNext())
                {
                    break;
                }
                obj4 = (com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan)((Iterator) (obj7)).next();
                if (((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj4)).type.equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostPlanTypes.DISCOUNTED.name()))
                {
                    obj3 = obj4;
                } else
                if (((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj4)).type.equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostPlanTypes.RETAIL.name()))
                {
                    obj1 = obj4;
                }
            } while (true);
            obj7 = getActivity().getLayoutInflater();
            Iterator iterator = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj3)).costLineItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                obj4 = (com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostLineItems)iterator.next();
                boolean flag1 = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostLineItems) (obj4)).lineItemName.equals(CostLineItemValues.POSTAGE_COST.name());
                if (flag1)
                {
                    if (obj1 == null)
                    {
                        continue;
                    }
                    obj4 = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj1)).getPostageCostLineItem();
                }
                createAndAddCostLineItemView(linearlayout, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostLineItems) (obj4)), ((LayoutInflater) (obj7)), flag1);
                createAndAddCostLineItemView(linearlayout1, ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.CostLineItems) (obj4)), ((LayoutInflater) (obj7)), flag1);
            } while (true);
            createAndAddTotalShippingCost(linearlayout, ((LayoutInflater) (obj7)), ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj3)), flag);
            createAndAddTotalShippingCost(linearlayout1, ((LayoutInflater) (obj7)), ((com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan) (obj3)), flag);
        }
        ((TextView)view.findViewById(0x7f10077a)).setText(((ShippingLabelActivity)getActivity()).selectedShippingService.attributes.packageName);
_L13:
        if (obj6 != null && (((ShippingOption) (obj6)).attributes.weightSupported || ((ShippingOption) (obj6)).attributes.dimensionSupported))
        {
            getView().findViewById(0x7f10077b).setVisibility(0);
            obj1 = ((ShippingLabelDraft) (obj5)).labelDetails.pkg.spec;
            obj1 = String.format("%s%s, %s%s x %s%s x %s%s", new Object[] {
                Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).weight.value), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).weight.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.length), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.width), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault()), Double.toString(((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.height), ((com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs) (obj1)).dimensionMeasure.unit.toLowerCase(Locale.getDefault())
            });
            ((TextView)getView().findViewById(0x7f10077c)).setText(((CharSequence) (obj1)));
        } else
        {
            getView().findViewById(0x7f10077b).setVisibility(8);
        }
        obj4 = null;
        if (((ShippingLabelDraft) (obj5)).labelDetails.showCustomMessage)
        {
            obj4 = getString(0x7f070862);
        }
        obj3 = obj4;
        if (TextUtils.isEmpty(((ShippingLabelDraft) (obj5)).labelDetails.sigConSelected)) goto _L11; else goto _L10
_L10:
        if (((ShippingLabelDraft) (obj5)).labelDetails.sigConSelected.equals("true"))
        {
            obj1 = getString(0x7f070876);
        } else
        {
label0:
            {
                if (!((ShippingLabelDraft) (obj5)).labelDetails.sigConSelected.equals("false"))
                {
                    break label0;
                }
                obj1 = null;
            }
        }
_L15:
        obj3 = obj4;
        if (obj1 != null)
        {
            if (obj4 == null)
            {
                obj3 = obj1;
            } else
            {
                obj3 = (new StringBuilder()).append(((String) (obj4))).append(", ").append(((String) (obj1))).toString();
            }
        }
_L11:
        obj1 = obj3;
        if (!TextUtils.isEmpty(((ShippingLabelDraft) (obj5)).labelDetails.selectedInsuranceCoverage))
        {
            if (obj3 == null)
            {
                obj1 = getString(0x7f070845);
            } else
            {
                obj1 = (new StringBuilder()).append(((String) (obj3))).append(", ").append(getString(0x7f070845)).toString();
            }
        }
        ((TextView)getView().findViewById(0x7f10077e)).setText(((CharSequence) (obj1)));
        obj1 = ((ShippingLabelDraft) (obj5)).labelDetails.from;
        if (obj1 != null)
        {
            ((TextView)view.findViewById(0x7f100783)).setText(ShippingLabelActivity.buildAddressString(((ShippingLabelContact) (obj1)), flag));
        }
        obj1 = ((ShippingLabelDraft) (obj5)).labelDetails.to;
        if (obj1 != null)
        {
            ((TextView)view.findViewById(0x7f100780)).setText(ShippingLabelActivity.buildAddressString(((ShippingLabelContact) (obj1)), flag));
            if (com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocationType.RESIDENTIAL.equals(((ShippingLabelContact) (obj1)).location.locationType) && flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            obj1 = view.findViewById(0x7f100781);
            if (j != 0)
            {
                j = 0;
            } else
            {
                j = 8;
            }
            ((View) (obj1)).setVisibility(j);
        }
        obj1 = ((ShippingLabelDraft) (obj5)).labelDetails.pkg;
        if (((ShippingLabelPackage) (obj1)).manifest.orderInfo.size() != 0 && ((ShippingLabelOrder)((ShippingLabelPackage) (obj1)).manifest.orderInfo.get(0)).lineItems.size() != 0)
        {
            obj1 = (ShippingLabelOrder)((ShippingLabelPackage) (obj1)).manifest.orderInfo.get(0);
            obj3 = (TextView)view.findViewById(0x7f10078a);
            d = ((ShippingLabelOrder) (obj1)).orderTotalCost.value;
            ((TextView) (obj3)).setText(EbayCurrencyUtil.formatDisplay(((ShippingLabelOrder) (obj1)).orderTotalCost.currency, Double.valueOf(d).doubleValue(), 2));
            obj3 = (TextView)view.findViewById(0x7f100789);
            d = ((ShippingLabelOrder) (obj1)).buyerPaidShippingCost.value;
            ((TextView) (obj3)).setText(EbayCurrencyUtil.formatDisplay(((ShippingLabelOrder) (obj1)).buyerPaidShippingCost.currency, Double.valueOf(d).doubleValue(), 2));
            obj1 = ((ShippingLabelOrder) (obj1)).lineItems.iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                obj4 = (com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem)((Iterator) (obj1)).next();
                obj3 = (TextView)view.findViewById(0x7f100788);
                ((TextView)view.findViewById(0x7f100787)).setText(((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (obj4)).title);
                obj5 = (RemoteImageView)view.findViewById(0x7f100786);
                if (((ShippingLabelActivity)getActivity()).imageURL != null)
                {
                    ((RemoteImageView) (obj5)).setRemoteImageUrl(((ShippingLabelActivity)getActivity()).imageURL);
                }
                ((TextView)view.findViewById(0x7f10075b)).setText(getString(0x7f070849, new Object[] {
                    Integer.valueOf((int)((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (obj4)).quantity)
                }));
                obj5 = (TextView)view.findViewById(0x7f10075c);
                obj4 = EbayCurrencyUtil.formatDisplay(((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (obj4)).unitItemValue.currency, ((com.ebay.nautilus.domain.data.ShippingLabelOrder.OrderLineItem) (obj4)).unitItemValue.value, 2);
                ((TextView) (obj5)).setText(((CharSequence) (obj4)));
                ((TextView) (obj3)).setText(((CharSequence) (obj4)));
            }
        }
          goto _L1
_L9:
        j++;
          goto _L12
_L4:
        ((TextView)view.findViewById(0x7f10077a)).setText("");
        view.findViewById(0x7f100772).setVisibility(8);
        view.findViewById(0x7f10078b).setVisibility(8);
        view.findViewById(0x7f100773).setVisibility(8);
          goto _L13
        obj3 = null;
        obj6 = ((ShippingOption) (obj6)).attributes.sigConOptionsSupported.iterator();
_L17:
        obj1 = obj3;
        if (!((Iterator) (obj6)).hasNext()) goto _L15; else goto _L14
_L14:
        obj1 = (com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions)((Iterator) (obj6)).next();
        if (!((com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions) (obj1)).optionToken.equals(((ShippingLabelDraft) (obj5)).labelDetails.sigConSelected)) goto _L17; else goto _L16
_L16:
        obj1 = ((com.ebay.nautilus.domain.data.ShippingOption.ShippingAttributes.ShippingConfirmationOptions) (obj1)).optionDisplayValue;
          goto _L15
    }
}
