// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.ebay.app.AlertDialogFragment;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.net.api.shippinglabel.CancelShippingLabelNetLoader;
import com.ebay.common.net.api.shippinglabel.GenerateShippingLabelNetLoader;
import com.ebay.common.net.api.shippinglabel.GenerateShippingLabelResponse;
import com.ebay.common.net.api.shippinglabel.GetShippingLabelNetLoader;
import com.ebay.common.net.api.shippinglabel.GetShippingLabelResponse;
import com.ebay.common.util.EbaySettings;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ErrorDialogFragment;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.util.EbayPhoneNumberUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.domain.data.LabelWorkOrder;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelOrder;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingLabelPdfContainer;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelFragment, PackageInfoFragment, CarrierServiceFragment, AdditionalServicesFragment, 
//            ShipsFromAddressFragment, ShipToAddressFragment, ShippingLabelBaseFragment, ShippingLabelPreviewFragment, 
//            VoidLabelFragment, FedexEulaDialogFragment, ShippingSuccessFragment

public class ShippingLabelActivity extends BaseActivity
    implements DialogFragmentCallback, com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener, com.ebay.nautilus.domain.content.dm.AddressDataManager.Observer, com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager.Observer
{
    public static class ShowHideAnimation extends Animation
    {

        final long animationDuration;
        int finishHeight;
        int heightDif;
        int startHeight;
        View view;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i = (int)((float)heightDif * f) + startHeight;
            if (f >= 1.0F)
            {
                i = finishHeight;
            }
            view.getLayoutParams().height = i;
            view.requestLayout();
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public ShowHideAnimation(View view1, int i, int j)
        {
            animationDuration = 500L;
            view = view1;
            startHeight = i;
            finishHeight = j;
            heightDif = j - i;
            setDuration(500L);
        }

        public ShowHideAnimation(View view1, int i, int j, int k)
        {
            animationDuration = 500L;
            view = view1;
            startHeight = i;
            finishHeight = k;
            heightDif = j - i;
            setDuration(500L);
        }
    }

    public static final class VoidLabelReasons extends Enum
    {

        private static final VoidLabelReasons $VALUES[];
        public static final VoidLabelReasons CHANGED_MIND;
        public static final VoidLabelReasons LABEL_DESTROYED;
        public static final VoidLabelReasons LABEL_LOST;
        public static final VoidLabelReasons NOT_PRINTED;
        final int displayStringResourceId;

        public static VoidLabelReasons valueOf(String s)
        {
            return (VoidLabelReasons)Enum.valueOf(com/ebay/mobile/sell/shippinglabel/ShippingLabelActivity$VoidLabelReasons, s);
        }

        public static VoidLabelReasons[] values()
        {
            return (VoidLabelReasons[])$VALUES.clone();
        }

        public int getDisplayStringResourceId()
        {
            return displayStringResourceId;
        }

        static 
        {
            NOT_PRINTED = new VoidLabelReasons("NOT_PRINTED", 0, 0x7f070851);
            LABEL_DESTROYED = new VoidLabelReasons("LABEL_DESTROYED", 1, 0x7f07084a);
            LABEL_LOST = new VoidLabelReasons("LABEL_LOST", 2, 0x7f07084c);
            CHANGED_MIND = new VoidLabelReasons("CHANGED_MIND", 3, 0x7f07082a);
            $VALUES = (new VoidLabelReasons[] {
                NOT_PRINTED, LABEL_DESTROYED, LABEL_LOST, CHANGED_MIND
            });
        }

        private VoidLabelReasons(String s, int i, int j)
        {
            super(s, i);
            displayStringResourceId = j;
        }
    }


    private static final String BLOCKING_BILLING_AGREEMENT = "BA_NOT_SETUP";
    private static final String BLOCKING_GSP = "GSP";
    private static final String BLOCKING_INTL = "IS_INTL_SHIPMENT";
    static final int CANCEL_LABEL_PACKAGE_LOADER_ID = 2;
    private static final int ERROR_CREATE_LABEL_REQUEST_CODE = 2;
    private static final int ERROR_GENERATE_LABEL_REQUEST_CODE = 3;
    private static final int ERROR_REQUEST_CODE = 1;
    private static final String EXTRA_PARAM_IMG_URL = "item.image";
    private static final String EXTRA_PARAM_ITEMID = "item.id";
    private static final String EXTRA_PARAM_TRANSACTIONID = "transaction.id";
    private static final int FEDEX_EULA_ERROR_ID = 6;
    public static final String FILENAME = "eBayShippingLabel";
    private static final String FILE_ENDING = ".pdf";
    static final int GENERATE_LABEL_PACKAGE_LOADER_ID = 1;
    static final int GET_LABEL_LOADER_ID = 3;
    private static final String STATE_IMG_URL = "itemImage";
    private static final String STATE_ITEMID = "itemId";
    private static final String STATE_PDF_FILE = "pdfFile";
    private static final String STATE_PRINT_POSTAGE = "printPostageOnLabel";
    private static final String STATE_PRINT_SKU = "printSku";
    private static final String STATE_SELECTED_INSURANCE = "selectedInsurance";
    private static final String STATE_TRANSACTIONID = "transactionId";
    public static final String TAG_ADDITIONAL_SERVICES_FRAGMENT = "additional_services_fragment";
    public static final String TAG_CARRIER_SERVICES_FRAGMENT = "carrier_services_fragment";
    public static final String TAG_FEDEX_EULA_DIALOG_FRAGMENT = "fedex_eula_fragment";
    static final int TAG_FEDEX_EULA_WEBVIEW_ACTIVITY = 2;
    public static final String TAG_PACKAGE_INFO_FRAGMENT = "package_info_fragment";
    public static final String TAG_PACKAGE_TYPE_FRAGMENT = "package_type_fragment";
    static final int TAG_PRINT_PSL_ACTIVITY = 1;
    public static final String TAG_SHIPPING_LABEL_REVIEW_FRAGMENT = "label_review_fragment";
    public static final String TAG_SHIPPING_LABEL_SUCCESS_FRAGMENT = "label_success_fragment";
    public static final String TAG_SHIPPING_LABEL_VOID_FRAGMENT = "label_void_fragment";
    public static final String TAG_SHIP_FROM_FRAGMENT = "ship_from_fragment";
    public static final String TAG_SHIP_TO_FRAGMENT = "ship_to_fragment";
    private static final String TRACKING_EMPTY_RESPONSE = "EMPTY_RESPONSE";
    private static final String TRACKING_GSP_BLOCKING = "GSP_NOT_SUPPORTED";
    private static final String TRACKING_NETWORK_ERROR = "NETWORK_ERROR";
    private static final String TRACKING_UNKNOWN_ERROR = "UKNOWN";
    private static final int VERIFY_PURCHASE_DIALOG = 2;
    AddressDataManager addressDataManager;
    private String fedexEulaUrl;
    LinkedHashMap fedexServices;
    private ShippingLabelFragment fragment;
    String imageURL;
    private long itemId;
    private String labelId;
    File pdfFile;
    boolean printPostageOnLabel;
    private View progressLayout;
    String selectedInsuranceCoverage;
    ShippingOption selectedShippingService;
    List shippingAddresses;
    ShippingLabelDraft shippingLabelDraft;
    public ShippingLabelDraftDataManager shippingLabelDraftDataManager;
    boolean showCustomMessage;
    public View toolbar;
    private long transactionId;
    LinkedHashMap uspsServices;

    public ShippingLabelActivity()
    {
    }

    public static String buildAddressString(ShippingLabelContact shippinglabelcontact, boolean flag)
    {
        com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingLocation.Address address = shippinglabelcontact.location.address;
        String s = shippinglabelcontact.fullName;
        Object obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = "";
        }
        obj = new StringBuilder(((String) (obj)));
        if (!TextUtils.isEmpty(address.addressLine1))
        {
            ((StringBuilder) (obj)).append("\n").append(address.addressLine1);
        }
        if (!TextUtils.isEmpty(address.addressLine2))
        {
            ((StringBuilder) (obj)).append("\n").append(address.addressLine2);
        }
        if (!TextUtils.isEmpty(address.addressLine3))
        {
            ((StringBuilder) (obj)).append("\n").append(address.addressLine3);
        }
        if (!TextUtils.isEmpty(address.city) || !TextUtils.isEmpty(address.stateOrProvince) || !TextUtils.isEmpty(address.postalCode) || !TextUtils.isEmpty(address.country))
        {
            ((StringBuilder) (obj)).append("\n");
            if (!TextUtils.isEmpty(address.city))
            {
                ((StringBuilder) (obj)).append(address.city).append(", ");
            }
            if (!TextUtils.isEmpty(address.stateOrProvince))
            {
                ((StringBuilder) (obj)).append(address.stateOrProvince).append(" ");
            }
            if (!TextUtils.isEmpty(address.postalCode))
            {
                ((StringBuilder) (obj)).append(address.postalCode).append(" ");
            }
            if (!TextUtils.isEmpty(address.country))
            {
                ((StringBuilder) (obj)).append(address.country);
            }
        }
        if (!TextUtils.isEmpty(shippinglabelcontact.phone) && flag)
        {
            ((StringBuilder) (obj)).append("\n").append(EbayPhoneNumberUtil.formatPhoneNumber(shippinglabelcontact.phone.replace("|", " "), "US"));
        }
        return ((StringBuilder) (obj)).toString();
    }

    private boolean handleBlockingError(ShippingLabelDraft shippinglabeldraft)
    {
        if (shippinglabeldraft == null || shippinglabeldraft.labelDetails == null)
        {
            return false;
        }
        if (((ShippingLabelOrder)shippinglabeldraft.labelDetails.pkg.manifest.orderInfo.get(0)).planCode.equals("GSP"))
        {
            shippinglabeldraft = new com.ebay.app.AlertDialogFragment.Builder();
            shippinglabeldraft.setMessage(getString(0x7f070843));
            shippinglabeldraft.setPositiveButton(getString(0x7f070738));
            shippinglabeldraft.setTitle(getString(0x7f070839));
            shippinglabeldraft.createFromActivity(1).show(getFragmentManager(), null);
            sendTracking(this, "ShippingLabelError", "ERR_MSG", "GSP_NOT_SUPPORTED");
            return true;
        }
        if (shippinglabeldraft.additionalData.entry != null && shippinglabeldraft.additionalData.entry.length != 0)
        {
            com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry apslentry[] = shippinglabeldraft.additionalData.entry;
            int j = apslentry.length;
            for (int i = 0; i < j; i++)
            {
                com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry pslentry = apslentry[i];
                if (pslentry.key.equals("BA_NOT_SETUP"))
                {
                    shippinglabeldraft = new com.ebay.app.AlertDialogFragment.Builder();
                    shippinglabeldraft.setMessage(getString(0x7f070826));
                    shippinglabeldraft.setPositiveButton(getString(0x7f070738));
                    shippinglabeldraft.setTitle(getString(0x7f070827));
                    shippinglabeldraft.createFromActivity(1).show(getFragmentManager(), null);
                    sendTracking(this, "ShippingLabelError", "ERR_MSG", "BA_NOT_SETUP");
                    return true;
                }
                if (pslentry.key.equals("IS_INTL_SHIPMENT") && pslentry.value[0].equals("true"))
                {
                    shippinglabeldraft = new com.ebay.app.AlertDialogFragment.Builder();
                    shippinglabeldraft.setMessage(getString(0x7f070848));
                    shippinglabeldraft.setPositiveButton(getString(0x7f070738));
                    shippinglabeldraft.setTitle(getString(0x7f070839));
                    shippinglabeldraft.createFromActivity(1).show(getFragmentManager(), null);
                    sendTracking(this, "ShippingLabelError", "ERR_MSG", "IS_INTL_SHIPMENT");
                    return true;
                }
                if (pslentry.key.equals("FEDEX_EULA_URL"))
                {
                    fedexEulaUrl = pslentry.value[0];
                }
            }

        }
        shippinglabeldraft = shippinglabeldraft.getErrors();
        if (shippinglabeldraft != null && shippinglabeldraft.size() != 0)
        {
            ErrorMessageDetails errormessagedetails = (ErrorMessageDetails)shippinglabeldraft.get(0);
            if (!TextUtils.isEmpty(errormessagedetails.errorName))
            {
                shippinglabeldraft = errormessagedetails.errorName;
            } else
            {
                shippinglabeldraft = "UKNOWN";
            }
            sendTracking(this, "ShippingLabelError", "ERR_MSG", shippinglabeldraft);
            if (errormessagedetails.getId() == 6)
            {
                showFedexEulaDialog();
            }
            if (errormessagedetails.subdomain.startsWith("BLOCKING_"))
            {
                finish();
                return true;
            }
        }
        return false;
    }

    private static void sendTracking(Activity activity, String s, String s1, String s2)
    {
        if (s1 == null)
        {
            s = new TrackingData(s, TrackingType.PAGE_IMPRESSION);
        } else
        {
            s = new TrackingData(s, TrackingType.EVENT);
            s.addKeyValuePair(s1, s2);
        }
        s.send(activity);
    }

    public static void showOrHideView(View view, int i, int j, Integer integer)
    {
        if (integer == null)
        {
            view.startAnimation(new ShowHideAnimation(view, i, j));
            return;
        } else
        {
            view.startAnimation(new ShowHideAnimation(view, i, j, integer.intValue()));
            return;
        }
    }

    public static void startActivity(Fragment fragment1, long l, long l1, String s)
    {
        Intent intent = new Intent(fragment1.getActivity(), com/ebay/mobile/sell/shippinglabel/ShippingLabelActivity);
        intent.putExtra("item.id", l);
        intent.putExtra("transaction.id", l1);
        intent.putExtra("item.image", s);
        fragment1.startActivityForResult(intent, 113);
        sendTracking(fragment1.getActivity(), "ShippingLabel", null, null);
    }

    public void acceptFedexEula()
    {
        getFragmentManager().findFragmentById(0x7f100761).getView().setVisibility(8);
        showProgress();
        com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippingLabelDraft, selectedShippingService.shippingKey);
        labelrequestparams.spec.packageShape = com.ebay.nautilus.domain.data.ShippingLabelPackage.PackageShapeType.REGULAR;
        if (true)
        {
            com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry apslentry[] = labelrequestparams.additionalData.entry;
            com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry apslentry1[] = new com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry[apslentry.length + 1];
            for (int i = 0; i < apslentry.length; i++)
            {
                apslentry1[i] = apslentry[i];
            }

            apslentry1[apslentry1.length - 1] = new com.ebay.nautilus.domain.data.ShippingLabelDraft.PSLEntry();
            apslentry1[apslentry1.length - 1].key = "FEDEX_EULA";
            apslentry1[apslentry1.length - 1].value = new String[1];
            apslentry1[apslentry1.length - 1].value[0] = "ACCEPT";
            labelrequestparams.additionalData.entry = apslentry1;
        }
        shippingLabelDraftDataManager.updateDraftPackage(labelrequestparams, shippingLabelDraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
    }

    public void cancelLabel(VoidLabelReasons voidlabelreasons)
    {
        showProgress();
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        voidlabelreasons = new CancelShippingLabelNetLoader(getEbayContext(), labelId, authentication.iafToken, voidlabelreasons.name());
        getFwLoaderManager().start(2, voidlabelreasons, true);
    }

    public void declineFedexEula()
    {
        Object obj = uspsServices.keySet().iterator();
        if (((Iterator) (obj)).hasNext())
        {
            obj = (String)((Iterator) (obj)).next();
            obj = (ShippingOption)((ArrayList)uspsServices.get(obj)).get(0);
            com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams labelrequestparams = new com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelPackageRequest.LabelRequestParams(shippingLabelDraft, selectedShippingService.shippingKey);
            labelrequestparams.spec.packageShape = com.ebay.nautilus.domain.data.ShippingLabelPackage.PackageShapeType.REGULAR;
            labelrequestparams.shippingKey = ((ShippingOption) (obj)).shippingKey;
            shippingLabelDraftDataManager.updateDraftPackage(labelrequestparams, shippingLabelDraft.draftLabelId, ApiSettings.getUrl(EbaySettings.printShippingLabelUrl));
        }
    }

    public void displayError(String s, String s1, String s2)
    {
        Object obj = getFragmentManager().findFragmentById(0x7f100761);
        if (s.equals("PSL"))
        {
            if (!(obj instanceof ShippingLabelFragment))
            {
                s = getFragmentManager().beginTransaction();
                fragment = new ShippingLabelFragment();
                s.replace(0x7f100761, fragment);
                s.commit();
            }
        } else
        if (s.equals("PACKAGE_DETAILS"))
        {
            if (!(obj instanceof PackageInfoFragment))
            {
                s = new PackageInfoFragment();
                obj = getFragmentManager().beginTransaction();
                ((FragmentTransaction) (obj)).addToBackStack("pakcageInfo");
                ((FragmentTransaction) (obj)).replace(0x7f100761, s, "package_info_fragment");
                ((FragmentTransaction) (obj)).commit();
            }
        } else
        if (s.equals("CARRIER_SVC"))
        {
            if (!(obj instanceof CarrierServiceFragment))
            {
                s = new CarrierServiceFragment();
                obj = getFragmentManager().beginTransaction();
                ((FragmentTransaction) (obj)).addToBackStack("carrierServices");
                ((FragmentTransaction) (obj)).replace(0x7f100761, s, "carrier_services_fragment");
                ((FragmentTransaction) (obj)).commit();
            }
        } else
        if (s.equals("PACKAGE_DETAILS_ADDN_OPT"))
        {
            if (!(obj instanceof AdditionalServicesFragment))
            {
                s = new AdditionalServicesFragment();
                obj = getFragmentManager().beginTransaction();
                ((FragmentTransaction) (obj)).addToBackStack("additionalServices");
                ((FragmentTransaction) (obj)).replace(0x7f100761, s, "additional_services_fragment");
                ((FragmentTransaction) (obj)).commit();
            }
        } else
        if (s.equals("SHIP_FROM"))
        {
            if (!(obj instanceof ShipsFromAddressFragment))
            {
                s = new ShipsFromAddressFragment();
                obj = getFragmentManager().beginTransaction();
                ((FragmentTransaction) (obj)).addToBackStack("shipFrom");
                ((FragmentTransaction) (obj)).replace(0x7f100761, s, "ship_from_fragment");
                ((FragmentTransaction) (obj)).commit();
            }
        } else
        if (s.equals("SHIP_TO") && !(obj instanceof ShipToAddressFragment))
        {
            s = new ShipToAddressFragment();
            FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            fragmenttransaction.addToBackStack("shipTo");
            fragmenttransaction.replace(0x7f100761, s, "ship_to_fragment");
            fragmenttransaction.commit();
        }
        showButterBarMessage(1, s1, false);
        if (TextUtils.isEmpty(s2))
        {
            s2 = "UKNOWN";
        }
        sendTracking(this, "ShippingLabelError", "ERR_MSG", s2);
    }

    public void finish()
    {
        shippingLabelDraftDataManager.clearCache();
        super.finish();
    }

    public void generateLabel()
    {
        if (selectedShippingService.shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.USPS.name()))
        {
            com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
            builder.setMessage(getString(0x7f070867));
            builder.setPositiveButton(getString(0x7f070738));
            builder.setTitle(getString(0x7f070868));
            builder.createFromActivity(2).show(getFragmentManager(), null);
            return;
        } else
        {
            loadLabel();
            return;
        }
    }

    public String getLabelFileName()
    {
        StringBuilder stringbuilder = new StringBuilder("eBayShippingLabel");
        stringbuilder.append("_").append(itemId);
        return stringbuilder.toString();
    }

    public String getLabelFileNameWithExtension()
    {
        StringBuilder stringbuilder = new StringBuilder("eBayShippingLabel");
        stringbuilder.append("_").append(itemId).append(".pdf");
        return stringbuilder.toString();
    }

    public boolean handleNonBlockingError(List list, boolean flag)
    {
label0:
        {
            if (!flag && list != null && list.size() > 0)
            {
                list = (ErrorMessageDetails)list.get(0);
                if (list.getId() != 6)
                {
                    break label0;
                }
            }
            return false;
        }
        if (!TextUtils.isEmpty(((ErrorMessageDetails) (list)).longMessage))
        {
            displayError(((ErrorMessageDetails) (list)).subdomain, ((ErrorMessageDetails) (list)).longMessage, ((ErrorMessageDetails) (list)).errorName);
            return true;
        } else
        {
            displayError(((ErrorMessageDetails) (list)).subdomain, ((ErrorMessageDetails) (list)).altLongMessage, ((ErrorMessageDetails) (list)).errorName);
            return true;
        }
    }

    public void hideProgress()
    {
        progressLayout.setVisibility(8);
    }

    public void loadLabel()
    {
        showProgress();
        findViewById(0x7f100760).setVisibility(0);
        Object obj = MyApp.getPrefs().getAuthentication();
        obj = new GenerateShippingLabelNetLoader(getEbayContext(), shippingLabelDraft.draftLabelId, ((Authentication) (obj)).iafToken);
        getFwLoaderManager().start(1, ((FwLoader) (obj)), true);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            showSuccess(false, false);
            return;

        case 2: // '\002'
            showFedexEulaDialog();
            break;
        }
    }

    public void onAddressDeleted(AddressDataManager addressdatamanager, Content content)
    {
        ShippingLabelBaseFragment shippinglabelbasefragment = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
        if (shippinglabelbasefragment instanceof ShipsFromAddressFragment)
        {
            ((ShipsFromAddressFragment)shippinglabelbasefragment).onAddressDeleted(addressdatamanager, content);
        }
    }

    public void onAddressPrimary(AddressDataManager addressdatamanager, Content content)
    {
        ShippingLabelBaseFragment shippinglabelbasefragment = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
        if (shippinglabelbasefragment instanceof ShipsFromAddressFragment)
        {
            ((ShipsFromAddressFragment)shippinglabelbasefragment).onAddressPrimary(addressdatamanager, content);
        }
    }

    public void onAddressUpdated(AddressDataManager addressdatamanager, Content content)
    {
        ShippingLabelBaseFragment shippinglabelbasefragment = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
        if (shippinglabelbasefragment instanceof ShipsFromAddressFragment)
        {
            ((ShipsFromAddressFragment)shippinglabelbasefragment).onAddressUpdated(addressdatamanager, content);
        }
    }

    public void onAddressesChanged(AddressDataManager addressdatamanager, Content content, boolean flag)
    {
        ResultStatus resultstatus = content.getStatus();
        Object obj = new ArrayList();
        shippingAddresses = new ArrayList();
        if (resultstatus.hasError())
        {
            shippingAddresses = null;
        } else
        {
            obj = (List)content.getData();
        }
        if (obj == null)
        {
            addressDataManager.onCurrentCountryChanged((UserContextDataManager)DataManager.getIfExists(getEbayContext(), UserContextDataManager.KEY), MyApp.getPrefs().getCurrentCountry());
            addressDataManager.forceReloadData();
        } else
        {
            if (obj != null)
            {
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Address address = (Address)iterator.next();
                    if (address.addressType.equals("Shipment_From"))
                    {
                        shippingAddresses.add(address);
                    }
                } while (true);
            }
            if (shippingLabelDraft != null && obj != null)
            {
                hideProgress();
                ShippingLabelBaseFragment shippinglabelbasefragment = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
                if (shippinglabelbasefragment instanceof ShipsFromAddressFragment)
                {
                    ((ShipsFromAddressFragment)shippinglabelbasefragment).onAddressesChanged(addressdatamanager, content, flag);
                }
                shippinglabelbasefragment.updateUI();
                return;
            }
        }
    }

    public void onBackPressed()
    {
        ShippingLabelBaseFragment shippinglabelbasefragment = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
        if (shippinglabelbasefragment == null || !shippinglabelbasefragment.onBackPressed())
        {
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030235);
        progressLayout = findViewById(0x7f100143);
        toolbar = findViewById(0x7f1003a1);
        toolbar.findViewById(0x7f1003ab).setOnClickListener(new android.view.View.OnClickListener() {

            final ShippingLabelActivity this$0;

            public void onClick(View view)
            {
                onBackPressed();
            }

            
            {
                this$0 = ShippingLabelActivity.this;
                super();
            }
        });
        if (bundle != null)
        {
            itemId = bundle.getLong("itemId");
            imageURL = bundle.getString("itemImage");
            transactionId = bundle.getLong("transactionId");
            selectedInsuranceCoverage = bundle.getString("selectedInsurance");
            printPostageOnLabel = bundle.getBoolean("printPostageOnLabel");
            showCustomMessage = bundle.getBoolean("printSku");
            if (bundle.containsKey("pdfFile"))
            {
                pdfFile = new File(bundle.getString("pdfFile"));
            }
            return;
        } else
        {
            itemId = getIntent().getLongExtra("item.id", 0L);
            transactionId = getIntent().getLongExtra("transaction.id", 0L);
            imageURL = getIntent().getStringExtra("item.image");
            bundle = getFragmentManager().beginTransaction();
            fragment = new ShippingLabelFragment();
            bundle.replace(0x7f100761, fragment);
            bundle.commit();
            return;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return false;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (i == 1 && j == 1)
        {
            finish();
        } else
        {
            if (i == 2 && j == 1)
            {
                loadLabel();
                return;
            }
            if (i == 2)
            {
                ((ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761)).updateUI();
                return;
            }
        }
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 2 3: default 28
    //                   2 29
    //                   3 41;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        showProgress();
        shippingLabelDraftDataManager.createShippingLabel();
        return;
_L4:
        Object obj = (ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761);
        if (obj != null)
        {
            obj = ((ShippingLabelBaseFragment) (obj)).getView();
            if (obj != null)
            {
                ((View) (obj)).setVisibility(8);
            }
        }
        showProgress();
        generateLabel();
        return;
    }

    public void onDraftChanged(ShippingLabelDraftDataManager shippinglabeldraftdatamanager, Content content, boolean flag)
    {
        hideProgress();
        ShippingLabelDraft shippinglabeldraft = (ShippingLabelDraft)content.getData();
        if (handleBlockingError(shippinglabeldraft))
        {
            return;
        }
        if (content.getStatus().hasError() && shippinglabeldraft == null)
        {
            if (shippingLabelDraft != null)
            {
                sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
                showButterBarMessage(1, ResultStatus.getSafeLongMessage(getEbayContext(), content.getStatus().getFirstError()), true);
                ((ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761)).updateUI();
                return;
            } else
            {
                sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
                shippingLabelDraftDataManager.clearCache();
                showButterBarMessage(2, ResultStatus.getSafeLongMessage(getEbayContext(), content.getStatus().getFirstError()), true);
                return;
            }
        }
        if (shippinglabeldraft == null || shippinglabeldraft.labelDetails == null)
        {
            sendTracking(this, "ShippingLabelError", "ERR_MSG", "EMPTY_RESPONSE");
            finish();
            return;
        }
        shippinglabeldraftdatamanager = shippinglabeldraft.getErrors();
        if (shippinglabeldraft.labelDetails == null && shippinglabeldraftdatamanager != null && shippinglabeldraftdatamanager.size() > 0)
        {
            shippinglabeldraftdatamanager = (ErrorMessageDetails)shippinglabeldraftdatamanager.get(0);
            if (!TextUtils.isEmpty(((ErrorMessageDetails) (shippinglabeldraftdatamanager)).longMessage))
            {
                displayError(((ErrorMessageDetails) (shippinglabeldraftdatamanager)).subdomain, ((ErrorMessageDetails) (shippinglabeldraftdatamanager)).longMessage, ((ErrorMessageDetails) (shippinglabeldraftdatamanager)).errorName);
                return;
            }
        }
        shippinglabeldraft.labelDetails.printPostageOnLabel = printPostageOnLabel;
        shippinglabeldraft.labelDetails.showCustomMessage = showCustomMessage;
        shippinglabeldraft.labelDetails.selectedInsuranceCoverage = selectedInsuranceCoverage;
        fedexServices = new LinkedHashMap();
        uspsServices = new LinkedHashMap();
        shippinglabeldraftdatamanager = shippinglabeldraft.labelDetails.shippingOptions;
        Collections.sort(shippinglabeldraftdatamanager, new Comparator() {

            final ShippingLabelActivity this$0;

            public int compare(ShippingOption shippingoption1, ShippingOption shippingoption2)
            {
                int i = shippingoption1.attributes.serviceDisplayOrder;
                int j = shippingoption2.attributes.serviceDisplayOrder;
                if (i < j)
                {
                    return -1;
                }
                return i != j ? 1 : 0;
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((ShippingOption)obj, (ShippingOption)obj1);
            }

            
            {
                this$0 = ShippingLabelActivity.this;
                super();
            }
        });
        shippinglabeldraft.labelDetails.sigConSelected = null;
        content = shippinglabeldraft.labelDetails.serviceFeatureValues.iterator();
        do
        {
            if (!content.hasNext())
            {
                break;
            }
            com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue servicefeaturevalue = (com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeatureValue)content.next();
            if (servicefeaturevalue.feature.equals(com.ebay.nautilus.domain.data.ShippingLabelDetails.ServiceFeature.SIG_CON.name()))
            {
                shippinglabeldraft.labelDetails.sigConSelected = servicefeaturevalue.value;
            }
        } while (true);
        Iterator iterator = shippinglabeldraftdatamanager.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ShippingOption shippingoption = (ShippingOption)iterator.next();
            if (shippingoption.selected)
            {
                selectedShippingService = shippingoption;
            }
            if (shippingoption.shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.FEDEX.name()))
            {
                content = (ArrayList)fedexServices.get(shippingoption.shippingKey.service);
                shippinglabeldraftdatamanager = content;
                if (content == null)
                {
                    shippinglabeldraftdatamanager = new ArrayList();
                    fedexServices.put(shippingoption.shippingKey.service, shippinglabeldraftdatamanager);
                }
                shippinglabeldraftdatamanager.add(shippingoption);
            }
            if (shippingoption.shippingKey.carrier.name().equals(com.ebay.nautilus.domain.data.ShippingOption.ShippingCarrierType.USPS.name()))
            {
                content = (ArrayList)uspsServices.get(shippingoption.shippingKey.service);
                shippinglabeldraftdatamanager = content;
                if (content == null)
                {
                    shippinglabeldraftdatamanager = new ArrayList();
                    uspsServices.put(shippingoption.shippingKey.service, shippinglabeldraftdatamanager);
                }
                shippinglabeldraftdatamanager.add(shippingoption);
            }
        } while (true);
        shippingLabelDraft = shippinglabeldraft;
        ((ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761)).updateUI();
        handleNonBlockingError(shippinglabeldraft.getErrors(), flag);
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        shippingLabelDraftDataManager = (ShippingLabelDraftDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.ShippingLabelDraftDataManager.KeyParams(Long.toString(itemId), Long.toString(transactionId), ApiSettings.get(EbaySettings.printShippingLabelUrl), authentication.iafToken), this);
        addressDataManager = (AddressDataManager)datamanagercontainer.initialize(new com.ebay.nautilus.domain.content.dm.AddressDataManager.KeyParams("Shipment_From"), this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("selectedInsurance", selectedInsuranceCoverage);
        bundle.putBoolean("printPostageOnLabel", printPostageOnLabel);
        bundle.putBoolean("printSku", showCustomMessage);
        bundle.putLong("transactionId", transactionId);
        bundle.putLong("itemId", itemId);
        bundle.putString("itemImage", imageURL);
        if (pdfFile != null)
        {
            bundle.putString("pdfFile", pdfFile.getAbsolutePath());
        }
        super.onSaveInstanceState(bundle);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        if (fwloader != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 33
    //                   2 478
    //                   3 83;
           goto _L3 _L4 _L5 _L6
_L3:
        return;
_L6:
        findViewById(0x7f100760).setVisibility(8);
        fwloader = (EbaySimpleNetLoader)fwloader;
        if (fwloader.getResultStatus().hasError())
        {
            sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
            setResult(2);
            finish();
            return;
        }
        sendTracking(this, "ShippingLabelSuccess", null, null);
        fwloader = (GetShippingLabelResponse)fwloader.getResponse();
        if (((GetShippingLabelResponse) (fwloader)).label.labelDetails.length == 0)
        {
            hideProgress();
            ((ShippingLabelBaseFragment)getFragmentManager().findFragmentById(0x7f100761)).updateUI();
            return;
        }
        labelId = ((GetShippingLabelResponse) (fwloader)).label.labelDetails[0].labelId;
        obj3 = null;
        obj2 = null;
        fragmenttransaction = null;
        abyte0 = ((GetShippingLabelResponse) (fwloader)).label.labelDetails[0].label.byteStream;
        pdfFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), getLabelFileNameWithExtension());
        fwloader = new BufferedOutputStream(new FileOutputStream(pdfFile, false));
        fwloader.write(abyte0, 0, abyte0.length);
        fwloader.flush();
        StreamUtil.closeQuietly(fwloader);
_L7:
        hideProgress();
        fwloader = new ShippingLabelPreviewFragment();
        fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.replace(0x7f100761, fwloader, "label_review_fragment");
        fragmenttransaction.commit();
        return;
        fwloader;
        fwloader = fragmenttransaction;
_L10:
        StreamUtil.closeQuietly(fwloader);
          goto _L7
        fwloader;
        fwloader = obj3;
_L9:
        StreamUtil.closeQuietly(fwloader);
          goto _L7
        Object obj;
        obj;
        fwloader = obj2;
_L8:
        StreamUtil.closeQuietly(fwloader);
        throw obj;
_L4:
        fwloader = (EbaySimpleNetLoader)fwloader;
        FragmentTransaction fragmenttransaction;
        Object obj2;
        Object obj3;
        byte abyte0[];
        if (fwloader.getResultStatus().hasError())
        {
            sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
            showButterBarMessage(3, fwloader.getResultStatus().getFirstError().getShortMessage(getEbayContext()), true);
            return;
        }
        fwloader = (GenerateShippingLabelResponse)fwloader.getResponse();
        if (!handleNonBlockingError(((GenerateShippingLabelResponse) (fwloader)).workOrder.getErrors(), false))
        {
            if (((GenerateShippingLabelResponse) (fwloader)).workOrder != null && ((GenerateShippingLabelResponse) (fwloader)).workOrder.workOrderID != null)
            {
                (new UserCache(this)).setShipped(Long.toString(itemId), Long.toString(transactionId), true);
                setResult(-1);
                Authentication authentication = MyApp.getPrefs().getAuthentication();
                fwloader = new GetShippingLabelNetLoader(getEbayContext(), ((GenerateShippingLabelResponse) (fwloader)).workOrder.workOrderID, authentication.iafToken);
                getFwLoaderManager().start(3, fwloader, true);
                return;
            } else
            {
                sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
                finish();
                return;
            }
        }
          goto _L1
_L5:
        Object obj1 = (CancelShippingLabelNetLoader)fwloader;
        if (((CancelShippingLabelNetLoader) (obj1)).getResultStatus().hasError())
        {
            EbayErrorHandler.handleResultStatus(this, 0, ((CancelShippingLabelNetLoader)fwloader).getResultStatus());
            sendTracking(this, "ShippingLabelError", "ERR_MSG", "NETWORK_ERROR");
            fwloader = (VoidLabelFragment)getFragmentManager().findFragmentByTag("label_void_fragment");
            if (fwloader != null)
            {
                fwloader.updateUI();
                return;
            }
        } else
        {
            obj1 = ((CancelShippingLabelNetLoader) (obj1)).getVoidReason();
            fwloader = ((FwLoader) (obj1));
            if (obj1 == null)
            {
                fwloader = "UKNOWN";
            }
            sendTracking(this, "ShippingLabelVoid", "rsn", fwloader);
            showSuccess(false, true);
            return;
        }
          goto _L1
        obj1;
          goto _L8
        obj1;
          goto _L9
        obj1;
          goto _L10
    }

    public void showButterBarMessage(int i, String s, boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        bundle.putBoolean("isError", true);
        if (i >= 0)
        {
            bundle.putInt("id", i);
        }
        bundle.putBoolean("asMessageBar", true);
        if (flag)
        {
            bundle.putBoolean("allowRetry", true);
        }
        Object obj = getFragmentManager();
        s = ((FragmentManager) (obj)).beginTransaction();
        obj = ((FragmentManager) (obj)).findFragmentByTag("messageDialog");
        if (obj != null)
        {
            s.remove(((Fragment) (obj)));
        }
        s.addToBackStack(null);
        obj = new ErrorDialogFragment();
        ((ErrorDialogFragment) (obj)).setArguments(bundle);
        ((ErrorDialogFragment) (obj)).show(s, "messageDialog");
    }

    public void showFedexEula()
    {
        Intent intent = new Intent(this, com/ebay/mobile/activities/ShowWebViewActivity);
        intent.putExtra("url", fedexEulaUrl);
        intent.putExtra("use_sso", true);
        startActivityForResult(intent, 2);
    }

    void showFedexEulaDialog()
    {
        FedexEulaDialogFragment.newInstance().show(getFragmentManager(), "fedex_eula_fragment");
    }

    public void showProgress()
    {
        progressLayout.setVisibility(0);
    }

    public void showSuccess(boolean flag, boolean flag1)
    {
        ShippingSuccessFragment shippingsuccessfragment = new ShippingSuccessFragment();
        Object obj = new Bundle();
        ((Bundle) (obj)).putBoolean("label_printed", flag);
        ((Bundle) (obj)).putBoolean("label_voided", flag1);
        shippingsuccessfragment.setArguments(((Bundle) (obj)));
        obj = getFragmentManager().beginTransaction();
        ((FragmentTransaction) (obj)).replace(0x7f100761, shippingsuccessfragment, "label_success_fragment");
        ((FragmentTransaction) (obj)).commit();
    }
}
