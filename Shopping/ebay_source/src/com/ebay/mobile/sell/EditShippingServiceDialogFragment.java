// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckedTextView;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingEstimate;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell:
//            ShippingLocationDialogFragment, ShippingServicesSelectionDialog

public class EditShippingServiceDialogFragment extends DialogFragment
    implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener, com.ebay.android.widget.EbaySpinner.OnUserSelectionChanged, ShippingLocationDialogFragment.ShippingLocationCallback
{
    static class EditShippingDialogConfig extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public EditShippingDialogConfig createFromParcel(Parcel parcel)
            {
                return (EditShippingDialogConfig)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/sell/EditShippingServiceDialogFragment$EditShippingDialogConfig);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public EditShippingDialogConfig[] newArray(int i)
            {
                return new EditShippingDialogConfig[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        private boolean allowDelete;
        private String currency;
        private ArrayList estimates;
        private LdsField fee;
        private LdsField freeShipping;
        private boolean isInternational;
        private boolean isNewService;
        private LdsField location;
        private LdsField region;
        private Set selectedShippingServices;
        private LdsField service;
        private Map shippingServices;
        private LdsField shippingType;

        public EditShippingDialogConfig setAllowDelete(boolean flag)
        {
            allowDelete = flag;
            return this;
        }

        public EditShippingDialogConfig setCurrency(String s)
        {
            currency = s;
            return this;
        }

        public EditShippingDialogConfig setEstimates(ArrayList arraylist)
        {
            estimates = arraylist;
            return this;
        }

        public EditShippingDialogConfig setFee(LdsField ldsfield)
        {
            fee = ldsfield;
            return this;
        }

        public EditShippingDialogConfig setFreeShipping(LdsField ldsfield)
        {
            freeShipping = ldsfield;
            return this;
        }

        public EditShippingDialogConfig setInternational(boolean flag)
        {
            isInternational = flag;
            return this;
        }

        public EditShippingDialogConfig setLocation(LdsField ldsfield)
        {
            location = ldsfield;
            return this;
        }

        public EditShippingDialogConfig setNewService(boolean flag)
        {
            isNewService = flag;
            return this;
        }

        public EditShippingDialogConfig setRegion(LdsField ldsfield)
        {
            region = ldsfield;
            return this;
        }

        public EditShippingDialogConfig setSelectedShippingServices(Set set)
        {
            selectedShippingServices = set;
            return this;
        }

        public EditShippingDialogConfig setService(LdsField ldsfield)
        {
            service = ldsfield;
            return this;
        }

        public EditShippingDialogConfig setShippingServices(Map map)
        {
            shippingServices = map;
            return this;
        }

        public EditShippingDialogConfig setShippingType(LdsField ldsfield)
        {
            shippingType = ldsfield;
            return this;
        }















        EditShippingDialogConfig()
        {
        }
    }

    static final class ShippingServiceCategoryType extends Enum
    {

        private static final ShippingServiceCategoryType $VALUES[];
        public static final ShippingServiceCategoryType EBAY_SHIPPING;
        public static final ShippingServiceCategoryType ECONOMY;
        public static final ShippingServiceCategoryType EXPEDITED;
        public static final ShippingServiceCategoryType NONE;
        public static final ShippingServiceCategoryType ONE_DAY;
        public static final ShippingServiceCategoryType OTHER;
        public static final ShippingServiceCategoryType PICKUP;
        public static final ShippingServiceCategoryType STANDARD;
        final String categoryIdentifier;

        public static String getCategoryCaption(ShippingServiceCategoryType shippingservicecategorytype, Activity activity, int i)
        {
            String s = activity.getString(0x7f0709e8);
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType = new int[ShippingServiceCategoryType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.EBAY_SHIPPING.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.ECONOMY.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.STANDARD.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.EXPEDITED.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.ONE_DAY.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.PICKUP.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$mobile$sell$EditShippingServiceDialogFragment$ShippingServiceCategoryType[ShippingServiceCategoryType.OTHER.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.mobile.sell.EditShippingServiceDialogFragment.ShippingServiceCategoryType[shippingservicecategorytype.ordinal()])
            {
            default:
                return s;

            case 1: // '\001'
                return activity.getString(0x7f0709e0);

            case 2: // '\002'
                return activity.getString(0x7f0709e1);

            case 3: // '\003'
                return activity.getString(0x7f0709e7);

            case 4: // '\004'
                return activity.getString(0x7f0709e2);

            case 5: // '\005'
                return activity.getString(0x7f0709e3);

            case 6: // '\006'
                return activity.getString(0x7f0709e6);

            case 7: // '\007'
                return getSiteBasedOthersCaptionString(i, activity);
            }
        }

        private static String getSiteBasedOthersCaptionString(int i, Activity activity)
        {
            switch (i)
            {
            default:
                return String.format(activity.getString(0x7f0709e5), new Object[] {
                    EbaySite.getInstanceFromId(i).localeCountry
                });

            case 77: // 'M'
                return activity.getString(0x7f0709e4);
            }
        }

        public static ShippingServiceCategoryType parseString(String s)
        {
            if (EBAY_SHIPPING.getCategoryIdentifier().equals(s))
            {
                return EBAY_SHIPPING;
            }
            if (ECONOMY.getCategoryIdentifier().equals(s))
            {
                return ECONOMY;
            }
            if (STANDARD.getCategoryIdentifier().equals(s))
            {
                return STANDARD;
            }
            if (EXPEDITED.getCategoryIdentifier().equals(s))
            {
                return EXPEDITED;
            }
            if (ONE_DAY.getCategoryIdentifier().equals(s))
            {
                return ONE_DAY;
            }
            if (PICKUP.getCategoryIdentifier().equals(s))
            {
                return PICKUP;
            }
            if (OTHER.getCategoryIdentifier().equals(s))
            {
                return OTHER;
            } else
            {
                return NONE;
            }
        }

        public static ShippingServiceCategoryType valueOf(String s)
        {
            return (ShippingServiceCategoryType)Enum.valueOf(com/ebay/mobile/sell/EditShippingServiceDialogFragment$ShippingServiceCategoryType, s);
        }

        public static ShippingServiceCategoryType[] values()
        {
            return (ShippingServiceCategoryType[])$VALUES.clone();
        }

        public String getCategoryIdentifier()
        {
            return categoryIdentifier;
        }

        static 
        {
            EBAY_SHIPPING = new ShippingServiceCategoryType("EBAY_SHIPPING", 0, "EBAY_SHIPPING");
            ECONOMY = new ShippingServiceCategoryType("ECONOMY", 1, "ECONOMY");
            STANDARD = new ShippingServiceCategoryType("STANDARD", 2, "STANDARD");
            EXPEDITED = new ShippingServiceCategoryType("EXPEDITED", 3, "EXPEDITED");
            ONE_DAY = new ShippingServiceCategoryType("ONE_DAY", 4, "ONE_DAY");
            PICKUP = new ShippingServiceCategoryType("PICKUP", 5, "Pickup");
            OTHER = new ShippingServiceCategoryType("OTHER", 6, "OTHER");
            NONE = new ShippingServiceCategoryType("NONE", 7, "NONE");
            $VALUES = (new ShippingServiceCategoryType[] {
                EBAY_SHIPPING, ECONOMY, STANDARD, EXPEDITED, ONE_DAY, PICKUP, OTHER, NONE
            });
        }

        private ShippingServiceCategoryType(String s, int i, String s1)
        {
            super(s, i);
            categoryIdentifier = s1;
        }
    }

    public static interface ShippingServiceDialogHandler
    {

        public abstract boolean isDataAvailable();

        public abstract void onDeleteShippingService(String s, boolean flag);

        public abstract void onSaveDomesticShippingService(String s, String s1, String s2, String s3, String s4);

        public abstract void onSaveInternationalShippingService(String s, String s1, String s2, String s3, String s4, boolean flag, String s5, 
                ArrayList arraylist);
    }

    static class ShippingServiceInfo extends BaseDataMapped
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ShippingServiceInfo createFromParcel(Parcel parcel)
            {
                return (ShippingServiceInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/sell/EditShippingServiceDialogFragment$ShippingServiceInfo);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ShippingServiceInfo[] newArray(int i)
            {
                return new ShippingServiceInfo[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public com.ebay.common.model.EbayDetail.ShippingServiceDetail serviceDetail;
        public ShippingEstimate serviceEstimate;
        public LdsOption serviceOption;


        public ShippingServiceInfo()
        {
        }
    }


    private static final String DIALOG_EXTRA_ALLOW_DELETE = "allowDelete";
    private static final String DIALOG_EXTRA_CURRENCY = "currencyCode";
    private static final String DIALOG_EXTRA_FEE = "fee";
    private static final String DIALOG_EXTRA_FREE_SHIPPING = "freeShipping";
    private static final String DIALOG_EXTRA_INTERNATIONAL = "international";
    private static final String DIALOG_EXTRA_LOCATION = "location";
    private static final String DIALOG_EXTRA_NEW_SERVICE = "is_new";
    private static final String DIALOG_EXTRA_REGION = "region";
    private static final String DIALOG_EXTRA_SELECTED_SHIPPING_SERVICES = "selected_shipping_services";
    private static final String DIALOG_EXTRA_SERVICE = "service";
    private static final String DIALOG_EXTRA_SHIPPING_ESTIMATES = "shipping_estimates";
    private static final String DIALOG_EXTRA_SHIPPING_SERVICE_DETAILS = "shipping_service_details";
    private static final String DIALOG_EXTRA_SHIPPING_TYPE = "shippingType";
    private static final String SHIPPING_LOCATIONS = "shipping_locations";
    private static final String SHIPPING_OPTION = "shipping_option";
    private PriceView costEditText;
    private View costRow;
    private String currencyCode;
    private LdsField fee;
    private CheckedTextView freeShipping;
    private boolean hasFiredInitialSpinner;
    private boolean isInternational;
    private boolean isNewService;
    private ShippingServiceDialogHandler listener;
    private LdsField location;
    private boolean overrideService1Delete;
    private LdsField region;
    private Set selectedServices;
    private LdsField service;
    private final Map serviceCategoryToInfoMap = new HashMap();
    private Map serviceNameToServiceDetailsMap;
    private Button serviceSpinnerBtn;
    private List shippingEstimates;
    private View shippingServiceLabel;
    private LdsField shippingType;
    private Button shipsToButton;
    private View shipsToLabel;

    public EditShippingServiceDialogFragment()
    {
        hasFiredInitialSpinner = false;
        overrideService1Delete = false;
    }

    public static EditShippingServiceDialogFragment createInstance(Fragment fragment, int i, EditShippingDialogConfig editshippingdialogconfig)
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("service", editshippingdialogconfig.service);
        bundle.putParcelable("fee", editshippingdialogconfig.fee);
        bundle.putParcelable("location", editshippingdialogconfig.location);
        bundle.putParcelable("region", editshippingdialogconfig.region);
        bundle.putParcelable("shippingType", editshippingdialogconfig.shippingType);
        bundle.putParcelable("freeShipping", editshippingdialogconfig.freeShipping);
        bundle.putString("currencyCode", editshippingdialogconfig.currency);
        bundle.putBoolean("international", editshippingdialogconfig.isInternational);
        bundle.putBoolean("is_new", editshippingdialogconfig.isNewService);
        bundle.putBoolean("allowDelete", editshippingdialogconfig.allowDelete);
        bundle.putSerializable("shipping_estimates", editshippingdialogconfig.estimates);
        bundle.putSerializable("shipping_service_details", (Serializable)editshippingdialogconfig.shippingServices);
        bundle.putSerializable("selected_shipping_services", (Serializable)editshippingdialogconfig.selectedShippingServices);
        editshippingdialogconfig = new EditShippingServiceDialogFragment();
        editshippingdialogconfig.setTargetFragment(fragment, i);
        editshippingdialogconfig.setArguments(bundle);
        return editshippingdialogconfig;
    }

    private void createLdsToShippingServiceDetailsMap()
    {
        if (serviceNameToServiceDetailsMap != null)
        {
            HashMap hashmap = new HashMap();
            if (shippingEstimates != null)
            {
                ShippingEstimate shippingestimate;
                for (Iterator iterator = shippingEstimates.iterator(); iterator.hasNext(); hashmap.put(shippingestimate.shippingService.serviceId, shippingestimate))
                {
                    shippingestimate = (ShippingEstimate)iterator.next();
                }

            }
            if (service.options != null)
            {
                Iterator iterator1 = service.options.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Object obj = (LdsOption)iterator1.next();
                    if (!((LdsOption) (obj)).value.equals("NotSelected"))
                    {
                        ShippingServiceInfo shippingserviceinfo = new ShippingServiceInfo();
                        ShippingServiceCategoryType shippingservicecategorytype = ShippingServiceCategoryType.NONE;
                        shippingserviceinfo.serviceOption = ((LdsOption) (obj));
                        shippingserviceinfo.serviceEstimate = (ShippingEstimate)hashmap.get(((LdsOption) (obj)).value);
                        shippingserviceinfo.serviceDetail = new com.ebay.common.model.EbayDetail.ShippingServiceDetail();
                        shippingserviceinfo.serviceDetail.shippingCategory = shippingservicecategorytype.getCategoryIdentifier();
                        if (serviceNameToServiceDetailsMap.containsKey(((LdsOption) (obj)).value))
                        {
                            shippingserviceinfo.serviceDetail = (com.ebay.common.model.EbayDetail.ShippingServiceDetail)serviceNameToServiceDetailsMap.get(((LdsOption) (obj)).value);
                            shippingservicecategorytype = ShippingServiceCategoryType.parseString(shippingserviceinfo.serviceDetail.shippingCategory);
                        }
                        if (serviceCategoryToInfoMap.containsKey(shippingservicecategorytype))
                        {
                            obj = (ArrayList)serviceCategoryToInfoMap.get(shippingservicecategorytype);
                        } else
                        {
                            obj = new ArrayList();
                        }
                        ((ArrayList) (obj)).add(shippingserviceinfo);
                        serviceCategoryToInfoMap.put(shippingservicecategorytype, obj);
                    }
                } while (true);
            }
        }
    }

    private void createUI(View view)
    {
        freeShipping = (CheckedTextView)view.findViewById(0x7f100646);
        freeShipping.setOnClickListener(this);
        costEditText = (PriceView)view.findViewById(0x7f100700);
        costRow = view.findViewById(0x7f1006ff);
        shipsToButton = (Button)view.findViewById(0x7f1006fe);
        shipsToButton.setOnClickListener(this);
        shipsToLabel = view.findViewById(0x7f1006fd);
        shippingServiceLabel = view.findViewById(0x7f1006fc);
        serviceSpinnerBtn = (Button)view.findViewById(0x7f1006fb);
        serviceSpinnerBtn.setOnClickListener(this);
    }

    private void doDeleteShippingMethod()
    {
        ShippingServiceDialogHandler shippingservicedialoghandler = listener;
        String s = service.id;
        boolean flag;
        if (!isInternational)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shippingservicedialoghandler.onDeleteShippingService(s, flag);
    }

    private void doSaveShippingMethod()
    {
        Object obj1 = null;
        Object obj = (ShippingServiceInfo)serviceSpinnerBtn.getTag();
        if (obj == null)
        {
            return;
        }
        if (isInternational)
        {
            ArrayList arraylist = new ArrayList();
            if (location != null)
            {
                for (Iterator iterator = location.getSelectedValues().iterator(); iterator.hasNext(); arraylist.add((String)iterator.next())) { }
            }
            boolean flag = freeShipping.isChecked();
            ShippingServiceDialogHandler shippingservicedialoghandler = listener;
            String s4 = shippingType.getStringValue();
            String s6 = service.id;
            String s7 = ((ShippingServiceInfo) (obj)).serviceOption.value;
            String s;
            if (fee != null)
            {
                obj = fee.id;
            } else
            {
                obj = null;
            }
            if (flag)
            {
                s = "0";
            } else
            {
                s = String.valueOf(costEditText.getPrice());
            }
            if (location != null)
            {
                obj1 = location.id;
            }
            shippingservicedialoghandler.onSaveInternationalShippingService(s4, s6, s7, ((String) (obj)), s, flag, ((String) (obj1)), arraylist);
            return;
        }
        boolean flag1 = freeShipping.isChecked();
        obj1 = listener;
        String s2 = shippingType.getStringValue();
        String s3 = service.id;
        String s5 = ((ShippingServiceInfo) (obj)).serviceOption.value;
        String s1;
        if (fee != null)
        {
            obj = fee.id;
        } else
        {
            obj = null;
        }
        if (flag1)
        {
            s1 = "0";
        } else
        {
            s1 = String.valueOf(costEditText.getPrice());
        }
        ((ShippingServiceDialogHandler) (obj1)).onSaveDomesticShippingService(s2, s3, s5, ((String) (obj)), s1);
    }

    private String getShipsToText(LdsField ldsfield, LdsField ldsfield1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = ldsfield.getSelectedValues().iterator();
label0:
        do
        {
            int i;
label1:
            {
                if (iterator.hasNext())
                {
                    i = Integer.parseInt((String)iterator.next());
                    if (i != 2 && i != 0)
                    {
                        break label1;
                    }
                }
                if (!TextUtils.isEmpty(stringbuilder))
                {
                    break label0;
                }
                ldsfield = ldsfield1.getSelectedValues().iterator();
                do
                {
                    if (!ldsfield.hasNext())
                    {
                        break label0;
                    }
                    String s = (String)ldsfield.next();
                    Iterator iterator1 = ldsfield1.options.iterator();
                    while (iterator1.hasNext()) 
                    {
                        LdsOption ldsoption = (LdsOption)iterator1.next();
                        if (ldsoption.value != null && !ldsoption.value.equals("None") && ldsoption.value.equals(s))
                        {
                            if (!TextUtils.isEmpty(stringbuilder))
                            {
                                stringbuilder.append(", ");
                            }
                            stringbuilder.append(ldsoption.caption);
                        }
                    }
                } while (true);
            }
            if (!TextUtils.isEmpty(stringbuilder))
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(((LdsOption)ldsfield.options.get(i)).caption);
        } while (true);
        if (TextUtils.isEmpty(stringbuilder))
        {
            return getResources().getString(0x7f070a76);
        } else
        {
            return stringbuilder.toString();
        }
    }

    private void loadServiceSpinner()
    {
        Object obj = new HashMap();
        for (Iterator iterator = serviceCategoryToInfoMap.values().iterator(); iterator.hasNext();)
        {
            Iterator iterator1 = ((ArrayList)iterator.next()).iterator();
            while (iterator1.hasNext()) 
            {
                ShippingServiceInfo shippingserviceinfo = (ShippingServiceInfo)iterator1.next();
                ((Map) (obj)).put(shippingserviceinfo.serviceOption.value, shippingserviceinfo);
            }
        }

        Object obj1 = selectedServices.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            Object obj2 = (String)((Iterator) (obj1)).next();
            if (((Map) (obj)).containsKey(obj2))
            {
                obj2 = (ShippingServiceInfo)((Map) (obj)).get(obj2);
                ((ArrayList)serviceCategoryToInfoMap.get(ShippingServiceCategoryType.parseString(((ShippingServiceInfo) (obj2)).serviceDetail.shippingCategory))).remove(obj2);
            }
        } while (true);
        obj1 = service.getStringValue();
        if (obj1 != null && !((String) (obj1)).equals("NotSelected") && service.options != null)
        {
            if (((Map) (obj)).containsKey(obj1))
            {
                obj = (ShippingServiceInfo)((Map) (obj)).get(obj1);
                serviceSpinnerBtn.setText(((ShippingServiceInfo) (obj)).serviceOption.caption);
                serviceSpinnerBtn.setTag(obj);
            }
        } else
        if (!hasFiredInitialSpinner && obj1 != null && ((String) (obj1)).equals("NotSelected"))
        {
            hasFiredInitialSpinner = true;
            serviceSpinnerBtn.performClick();
            return;
        }
    }

    private void selectLocation(LdsField ldsfield, String s, int i)
    {
        ldsfield.replaceSelectedValue(s);
        region.replaceSelectedValue((new StringBuilder()).append("").append(i).toString());
    }

    private String setupButtonWithCustomLocations(List list)
    {
        Object obj;
        obj = "";
        Iterator iterator = list.iterator();
        do
        {
label0:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                String s = (String)iterator.next();
                Iterator iterator1 = location.options.iterator();
                list = ((List) (obj));
                do
                {
                    obj = list;
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    LdsOption ldsoption = (LdsOption)iterator1.next();
                    if (!ldsoption.value.equals("None") && ldsoption.value.equals(s))
                    {
                        obj = list;
                        if (!TextUtils.isEmpty(list))
                        {
                            obj = (new StringBuilder()).append(list).append(", ").toString();
                        }
                        list = (new StringBuilder()).append(((String) (obj))).append(ldsoption.caption).toString();
                    }
                } while (true);
            }
        } while (true);
        list = ((List) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            list = getResources().getString(0x7f070a76);
        }
        return list;
    }

    private void updateUI()
    {
        if ("FLAT_RATE".equals(shippingType.getStringValue()) || "ACTUAL_RATE".equals(shippingType.getStringValue()))
        {
            if (!overrideService1Delete && service.id.equals("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode"))
            {
                ((AlertDialog)getDialog()).getButton(-2).setVisibility(8);
            }
            serviceSpinnerBtn.setEnabled(service.isEnabled());
            if ("FLAT_RATE".equals(shippingType.getStringValue()))
            {
                costRow.setEnabled(fee.isEnabled());
                costEditText.setEnabled(fee.isEnabled());
                costEditText.setFocusable(fee.isEnabled());
                costEditText.setCurrency(currencyCode);
                freeShipping.setVisibility(8);
                costRow.setVisibility(0);
                double d = fee.getDoubleValue();
                if (d >= 0.0D)
                {
                    costEditText.setPrice(Double.valueOf(d));
                }
                shippingServiceLabel.setVisibility(8);
            } else
            {
                freeShipping.setVisibility(8);
                costRow.setVisibility(8);
                if (shippingEstimates != null && !shippingEstimates.isEmpty() && !isInternational)
                {
                    shippingServiceLabel.setVisibility(0);
                } else
                {
                    shippingServiceLabel.setVisibility(8);
                }
            }
            if (isInternational)
            {
                shipsToButton.setText(getShipsToText(region, location));
                shipsToButton.setVisibility(0);
                shipsToLabel.setVisibility(0);
            } else
            {
                shipsToButton.setVisibility(8);
                shipsToLabel.setVisibility(8);
            }
            loadServiceSpinner();
        }
    }

    public void onChange(int i, Object obj)
    {
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        i;
        JVM INSTR tableswitch -2 -1: default 24
    //                   -2 61
    //                   -1 54;
           goto _L1 _L2 _L3
_L1:
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(costEditText.getWindowToken(), 0);
        dismiss();
        return;
_L3:
        doSaveShippingMethod();
        continue; /* Loop/switch isn't completed */
_L2:
        if (!isNewService)
        {
            doDeleteShippingMethod();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onClick(View view)
    {
        byte byte0 = 0;
        view.getId();
        JVM INSTR lookupswitch 3: default 40
    //                   2131756614: 41
    //                   2131756795: 111
    //                   2131756798: 88;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        freeShipping.toggle();
        if ("FLAT_RATE".equals(shippingType.getStringValue()))
        {
            view = costRow;
            if (freeShipping.isChecked())
            {
                byte0 = 8;
            }
            view.setVisibility(byte0);
            return;
        }
          goto _L1
_L4:
        ShippingLocationDialogFragment.createInstance(this, 0, region, location).show(getFragmentManager(), "shipping_locations");
        return;
_L3:
        ShippingServicesSelectionDialog.createInstance(this, 0, serviceCategoryToInfoMap, currencyCode).show(getFragmentManager(), "shipping_option");
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(0, 0x7f0a002b);
        bundle = getArguments();
        if (bundle != null)
        {
            service = (LdsField)bundle.getParcelable("service");
            fee = (LdsField)bundle.getParcelable("fee");
            location = (LdsField)bundle.getParcelable("location");
            region = (LdsField)bundle.getParcelable("region");
            shippingType = (LdsField)bundle.getParcelable("shippingType");
            currencyCode = bundle.getString("currencyCode");
            isInternational = bundle.getBoolean("international");
            isNewService = bundle.getBoolean("is_new");
            overrideService1Delete = bundle.getBoolean("allowDelete");
            serviceNameToServiceDetailsMap = (Map)bundle.getSerializable("shipping_service_details");
            shippingEstimates = (List)bundle.getSerializable("shipping_estimates");
            selectedServices = (Set)bundle.getSerializable("selected_shipping_services");
        }
        if (serviceNameToServiceDetailsMap == null)
        {
            serviceNameToServiceDetailsMap = new HashMap();
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = LayoutInflater.from(getActivity()).inflate(0x7f030216, null);
        createUI(bundle);
        createLdsToShippingServiceDetailsMap();
        return (new android.support.v7.app.AlertDialog.Builder(getActivity())).setTitle(0x7f0705b4).setView(bundle).setCancelable(true).setPositiveButton(0x7f070738, this).setNegativeButton(0x7f070285, this).create();
    }

    public void onResume()
    {
        super.onResume();
        try
        {
            listener = (ShippingServiceDialogHandler)getTargetFragment();
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException("Your target fragment or activity need to implement the ShippingServiceDialogHandler interface to use this dialog.");
        }
        if (listener == null || !listener.isDataAvailable())
        {
            DialogFragment dialogfragment = (DialogFragment)getFragmentManager().findFragmentByTag("shipping_locations");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
            dialogfragment = (DialogFragment)getFragmentManager().findFragmentByTag("shipping_option");
            if (dialogfragment != null)
            {
                dialogfragment.dismiss();
            }
            dismiss();
            return;
        } else
        {
            updateUI();
            return;
        }
    }

    public void onShipToDialogLocationsResult(int i, ArrayList arraylist)
    {
        location.clearSelections();
        LdsOption ldsoption;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); location.addSelectedValue(ldsoption.value))
        {
            ldsoption = (LdsOption)arraylist.next();
        }

        shipsToButton.setText(setupButtonWithCustomLocations(location.getSelectedValues()));
    }

    public void onShipToDialogRegionResult(int i, LdsOption ldsoption)
    {
        i = ldsoption.getIntValue();
        i;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 56
    //                   1 76
    //                   2 66
    //                   3 91
    //                   4 106
    //                   5 121;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        shipsToButton.setText(ldsoption.caption);
        return;
_L2:
        location.clearSelections();
        continue; /* Loop/switch isn't completed */
_L4:
        location.clearSelections();
        continue; /* Loop/switch isn't completed */
_L3:
        selectLocation(location, "Worldwide", i);
        continue; /* Loop/switch isn't completed */
_L5:
        selectLocation(location, "CA", i);
        continue; /* Loop/switch isn't completed */
_L6:
        selectLocation(location, "DE", i);
        continue; /* Loop/switch isn't completed */
_L7:
        selectLocation(location, "GB", i);
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void setSelectedServiceInfo(ShippingServiceInfo shippingserviceinfo)
    {
        serviceSpinnerBtn.setText(shippingserviceinfo.serviceOption.caption);
        serviceSpinnerBtn.setTag(shippingserviceinfo);
    }
}
