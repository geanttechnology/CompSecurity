// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.ListingDraftContent;
import com.ebay.nautilus.domain.content.dm.listingdraft.ConditionDefinitionLoadTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.ExtractSpecificsFromTitleTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.GetProductDetailsTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.GetShippingEstimatesTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.GetShippingRecommendationTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftLoadTask;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftPreferences;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import com.ebay.nautilus.domain.data.ListingDraft;
import com.ebay.nautilus.domain.data.RecommendedShippingService;
import com.ebay.nautilus.domain.data.ShippingRecommendation;
import com.ebay.nautilus.domain.data.ShippingZonalCost;
import com.ebay.nautilus.domain.dcs.DcsNautilusBoolean;
import com.ebay.nautilus.domain.dcs.DcsNautilusString;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.api.lds.LdsConstants;
import com.ebay.nautilus.domain.net.api.lds.LdsRequestParams;
import com.ebay.nautilus.domain.net.api.lds.SiteTimeZones;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            SavedListingDraftDataManager, ListingCategoryInfoManager

public class ListingDraftDataManager extends DataManager
    implements ListingCategoryInfoManager.Observer, SavedListingDraftDataManager.Observer
{
    public static final class DispatchType extends Enum
    {

        private static final DispatchType $VALUES[];
        public static final DispatchType ACK;
        public static final DispatchType BLOCKING_CHANGE_ACK;
        public static final DispatchType BLOCKING_CHANGE_COMPLETE;
        public static final DispatchType COMPLETE;
        public static final DispatchType CREATE_COMPLETE;
        public static final DispatchType CREATE_RELIST_COMPLETE;
        public static final DispatchType PUBLISH_ACK;
        public static final DispatchType PUBLISH_COMPLETE;
        public static final DispatchType VALIDATE_ACK;
        public static final DispatchType VALIDATE_COMPLETE;

        public static DispatchType valueOf(String s)
        {
            return (DispatchType)Enum.valueOf(com/ebay/nautilus/domain/content/dm/ListingDraftDataManager$DispatchType, s);
        }

        public static DispatchType[] values()
        {
            return (DispatchType[])$VALUES.clone();
        }

        static 
        {
            ACK = new DispatchType("ACK", 0);
            COMPLETE = new DispatchType("COMPLETE", 1);
            CREATE_COMPLETE = new DispatchType("CREATE_COMPLETE", 2);
            CREATE_RELIST_COMPLETE = new DispatchType("CREATE_RELIST_COMPLETE", 3);
            VALIDATE_ACK = new DispatchType("VALIDATE_ACK", 4);
            VALIDATE_COMPLETE = new DispatchType("VALIDATE_COMPLETE", 5);
            PUBLISH_ACK = new DispatchType("PUBLISH_ACK", 6);
            PUBLISH_COMPLETE = new DispatchType("PUBLISH_COMPLETE", 7);
            BLOCKING_CHANGE_ACK = new DispatchType("BLOCKING_CHANGE_ACK", 8);
            BLOCKING_CHANGE_COMPLETE = new DispatchType("BLOCKING_CHANGE_COMPLETE", 9);
            $VALUES = (new DispatchType[] {
                ACK, COMPLETE, CREATE_COMPLETE, CREATE_RELIST_COMPLETE, VALIDATE_ACK, VALIDATE_COMPLETE, PUBLISH_ACK, PUBLISH_COMPLETE, BLOCKING_CHANGE_ACK, BLOCKING_CHANGE_COMPLETE
            });
        }

        private DispatchType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class FormatPriceTextFields
    {

        public String autoAcceptValue;
        public String autoDeclineValue;
        public String binPrice;
        public String fixedPrice;
        public String quantity;
        public String reservePrice;
        public String startPrice;

        public FormatPriceTextFields()
        {
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.DataManager.DataManagerKeyParams
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                long l = parcel.readLong();
                EbaySite ebaysite = (EbaySite)parcel.readParcelable(getClass().getClassLoader());
                return new KeyParams(l, parcel.readString(), ebaysite);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final EbaySite draftSite;
        public final long keyId;
        public final String listingMode;

        public volatile DataManager createManager(EbayContext ebaycontext)
        {
            return createManager(ebaycontext);
        }

        public ListingDraftDataManager createManager(EbayContext ebaycontext)
        {
            ebaycontext = new ListingDraftDataManager(ebaycontext, this);
            ebaycontext.create();
            return ebaycontext;
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            boolean flag2 = true;
            boolean flag3 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag3;
                if (obj != null)
                {
                    flag = flag3;
                    if (getClass() == obj.getClass())
                    {
                        obj = (KeyParams)obj;
                        flag = flag3;
                        if (draftSite.idInt == ((KeyParams) (obj)).draftSite.idInt)
                        {
                            flag = flag3;
                            if (listingMode.equals(((KeyParams) (obj)).listingMode))
                            {
                                boolean flag1;
                                if (keyId == ((KeyParams) (obj)).keyId)
                                {
                                    flag1 = flag2;
                                } else
                                {
                                    flag1 = false;
                                }
                                return flag1;
                            }
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return ((super.hashCode() * 31 + (int)(keyId ^ keyId >>> 32)) * 31 + draftSite.hashCode()) * 31 + listingMode.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(keyId);
            parcel.writeParcelable(draftSite, i);
            parcel.writeString(listingMode);
        }


        public KeyParams(long l, String s, EbaySite ebaysite)
        {
            if (s == null)
            {
                throw new IllegalArgumentException("The draft listing mode is required");
            }
            if (ebaysite == null)
            {
                throw new IllegalArgumentException("The draft site is required");
            } else
            {
                keyId = l;
                listingMode = s;
                draftSite = ebaysite;
                return;
            }
        }
    }

    public static class LoadDraftDetails
    {

        public String categoryId;
        public final ListingFormDefaults defaults = new ListingFormDefaults();
        public String draftId;
        public String epid;
        public String sourceItemId;
        public String title;

        public LoadDraftDetails()
        {
        }
    }

    public static class LoadDraftDetails.ListingFormDefaults
    {

        public String acceptedPaymentMethods;
        public String cityState;
        public String country;
        public String handlingTime;
        public String paypalEmail;
        public String policyDetails;
        public String refundMethod;
        public String refundShipmentPayee;
        public String restockingFee;
        public String returnPeriod;
        public String returnsAccepted;
        public String shippingType;
        public String zipcode;

        public LoadDraftDetails.ListingFormDefaults()
        {
        }
    }

    public static interface LoadDraftDetailsGenerator
    {

        public abstract LoadDraftDetails generateLoadDraftDetails();
    }

    public static interface Observer
    {

        public abstract void onContentChanged(ListingDraftDataManager listingdraftdatamanager, ListingDraftContent listingdraftcontent, DispatchType dispatchtype);
    }

    public static class PackageDetailFields
    {

        public String dimDepthStr;
        public String dimLengthStr;
        public String dimWidthStr;
        public String estimatedWeightStr;
        public boolean irregular;
        public String packageTypeStr;
        public String packageWeightMajorStr;
        public String packageWeightMinorStr;

        public PackageDetailFields()
        {
        }
    }

    public static class PreferenceTextFields
    {

        public String cityState;
        public String paypalEmail;
        public String postalCode;
        public String returnsDetails;

        public PreferenceTextFields()
        {
        }
    }


    public boolean canOverrideFormatWithRecommendation;
    private ListingCategoryInfoManager categoryInfoDm;
    private SparseArray conditionDefinitions;
    private ConditionDefinitionLoadTask conditionDefsTask;
    private ListingDraftContent content;
    private SavedListingDraftDataManager draftListDm;
    private boolean hasSpecificsGuidance;
    private boolean isGuaranteeSelectedThisSession;
    private Content itemSpecificsContent;
    private final KeyParams keyParams;
    private ListingDraftLoadTask lastTask;
    private boolean paypalPrefillShouldRun;
    private final ListingDraftPreferences prefs;
    private String productDescription;
    private GetProductDetailsTask productDetailsTask;
    private ListingDraftContent publishContent;
    private ListingDraftLoadTask queuedUpdateShippingForGuidanceTask;
    private ListingDraftLoadTask queuedValidationTask;
    private ArrayList shippingEstimates;
    private GetShippingEstimatesTask shippingEstimatesTask;
    private boolean shippingGuidanceShouldRun;
    private ShippingRecommendation shippingRecommendation;
    private GetShippingRecommendationTask shippingRecommendationTask;
    private final ArrayList taskList;

    private ListingDraftDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/ListingDraftDataManager$Observer);
        taskList = new ArrayList();
        content = null;
        publishContent = null;
        hasSpecificsGuidance = false;
        shippingRecommendation = null;
        isGuaranteeSelectedThisSession = false;
        shippingGuidanceShouldRun = true;
        paypalPrefillShouldRun = true;
        canOverrideFormatWithRecommendation = false;
        keyParams = keyparams;
        prefs = new ListingDraftPreferences(getContext());
    }


    private static void addFeeIfNonNull(LdsRequestParams ldsrequestparams, String s, LdsField ldsfield)
    {
        ldsfield = ldsfield.getStringValue();
        if (ldsfield != null)
        {
            ldsrequestparams.values.put(s, ldsfield);
        }
    }

    private static void addUpdatedDraftPriceValue(LdsField ldsfield, String s, LdsRequestParams ldsrequestparams)
    {
label0:
        {
label1:
            {
                if (ldsfield != null && ldsfield.isEnabled() && !s.equals(ldsfield.getStringValue()) && (ldsfield.getStringValue() != null || !s.equals("0.0")))
                {
                    if (!s.equals(""))
                    {
                        break label0;
                    }
                    if (ldsfield.getStringValue() != null)
                    {
                        break label1;
                    }
                }
                return;
            }
            ldsrequestparams.deletedValues.add(ldsfield.id);
            return;
        }
        ldsrequestparams.values.put(ldsfield.id, s);
    }

    private static void addUpdatedDraftValue(LdsField ldsfield, String s, LdsRequestParams ldsrequestparams)
    {
label0:
        {
label1:
            {
                if (ldsfield != null && ldsfield.isEnabled() && !s.equals(ldsfield.getStringValue()))
                {
                    if (!s.equals(""))
                    {
                        break label0;
                    }
                    if (ldsfield.getStringValue() != null)
                    {
                        break label1;
                    }
                }
                return;
            }
            ldsrequestparams.deletedValues.add(ldsfield.id);
            return;
        }
        ldsrequestparams.values.put(ldsfield.id, s);
    }

    private void cancelTask(ListingDraftOperation listingdraftoperation)
    {
        NautilusKernel.verifyMain();
        Iterator iterator = taskList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ListingDraftLoadTask listingdraftloadtask = (ListingDraftLoadTask)iterator.next();
            if (listingdraftloadtask.taskId == listingdraftoperation.ordinal())
            {
                listingdraftloadtask.cancel(true);
            }
        } while (true);
    }

    private void clearConditionDefinitions()
    {
        conditionDefinitions = null;
        if (conditionDefsTask != null)
        {
            conditionDefsTask.cancel(true);
        }
    }

    private void clearItemSpecifics()
    {
        itemSpecificsContent = null;
        if (categoryInfoDm != null)
        {
            unObserveDm(categoryInfoDm);
            categoryInfoDm = null;
        }
    }

    private void clearProductDescription()
    {
        productDescription = null;
        if (productDetailsTask != null)
        {
            productDetailsTask.cancel(true);
        }
    }

    private void clearShippingEstimates()
    {
        if (shippingEstimatesTask != null)
        {
            shippingEstimatesTask.cancel(true);
        }
        shippingEstimates = null;
    }

    private void clearShippingGuidance(boolean flag)
    {
        shippingRecommendation = null;
        shippingGuidanceShouldRun = flag;
    }

    private static String convertToNumericString(String s)
    {
        int i;
        try
        {
            i = (int)Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "0";
        }
        return String.valueOf(i);
    }

    private static void disablePaymentUi(ListingDraft listingdraft)
    {
        Iterator iterator = listingdraft.paymentMethods.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LdsField ldsfield = (LdsField)iterator.next();
            if (ldsfield.isEnabled())
            {
                ldsfield.setBmode("READ_ONLY");
            }
        } while (true);
        if (listingdraft.immediatePay.getBmode().equals("ENABLE"))
        {
            listingdraft.immediatePay.setBmode("READ_ONLY");
        }
        if (listingdraft.paypalEmailAddress != null && listingdraft.paypalEmailAddress.getBmode().equals("ENABLE"))
        {
            listingdraft.paypalEmailAddress.setBmode("READ_ONLY");
        }
    }

    private static void disableReturnsUi(ListingDraft listingdraft)
    {
        listingdraft.refundReturnsAccepted.setBmode("READ_ONLY");
        listingdraft.refundReturnPeriod.setBmode("READ_ONLY");
        listingdraft.refundMethod.setBmode("READ_ONLY");
        listingdraft.refundShipmentPayee.setBmode("READ_ONLY");
        listingdraft.refundRestockingFee.setBmode("READ_ONLY");
    }

    private void dispatch()
    {
        dispatch(DispatchType.ACK);
    }

    private void dispatch(DispatchType dispatchtype)
    {
        if (content != null)
        {
            if (itemSpecificsContent != null)
            {
                content.itemSpecificsForCategory = new ArrayList((Collection)itemSpecificsContent.getData());
            }
            if (conditionDefinitions != null)
            {
                content.conditionDefinitions = conditionDefinitions;
            }
            if (productDescription != null)
            {
                content.productDescription = productDescription;
            }
            content.hasSpecificsGuidance = hasSpecificsGuidance;
            content.shippingEstimates = shippingEstimates;
            content.shippingRecommendation = shippingRecommendation;
            content.isGuaranteeSelectedThisSession = isGuaranteeSelectedThisSession;
        }
        ((Observer)dispatcher).onContentChanged(this, content, dispatchtype);
    }

    private void executeTask(LdsRequestParams ldsrequestparams)
    {
        if (ldsrequestparams == null)
        {
            throw new IllegalArgumentException("Can't execute null request params");
        }
        ldsrequestparams.site = keyParams.draftSite;
        ldsrequestparams.listingMode = keyParams.listingMode;
        Object obj = draftListDm.getCurrentUser();
        if (obj == null)
        {
            throw new IllegalArgumentException("Must be authenticated to do anything with a draft");
        }
        ldsrequestparams.iafToken = ((Authentication) (obj)).iafToken;
        if (ldsrequestparams.operation.ordinal() > ListingDraftOperation.CREATE_RELIST.ordinal() && (content == null || content.getData() == null || ((ListingDraft)content.getData()).id == null))
        {
            throw new IllegalArgumentException("Don't attempt to do anything to the draft before it has loaded");
        }
        cancelTask(ldsrequestparams.operation);
        if (content != null)
        {
            ldsrequestparams.id = ((ListingDraft)content.getData()).id;
        }
        obj = new ListingDraftLoadTask(this, ldsrequestparams);
        if (!taskList.isEmpty() && ldsrequestparams.fullValidation)
        {
            queuedValidationTask = ((ListingDraftLoadTask) (obj));
            return;
        }
        if (!taskList.isEmpty() && ldsrequestparams.operation.equals(ListingDraftOperation.UPDATE_SHIPPING_FOR_GUIDANCE))
        {
            queuedUpdateShippingForGuidanceTask = ((ListingDraftLoadTask) (obj));
            return;
        } else
        {
            executeOnThreadPool(((android.os.AsyncTask) (obj)), new Void[0]);
            return;
        }
    }

    private void getItemSpecificsGuidance()
    {
        ListingDraft listingdraft = (ListingDraft)content.getData();
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (listingdraft.productId.getStringValue() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (listingdraft.title.getStringValue() != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (listingdraft.category.getStringValue() != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (!flag && flag1 && flag2)
        {
            executeOnThreadPool(new ExtractSpecificsFromTitleTask(this, listingdraft.category.getStringValue(), listingdraft.title.getStringValue()), new Void[0]);
        }
    }

    private void getShippingEstimates()
    {
        ListingDraft listingdraft = (ListingDraft)content.getData();
        if (listingdraft != null && listingdraft.shippingType != null && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.locationPostalCode)) && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.packageWeightMajor)) && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.packageWeightMinor)) && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.packageWidth)) && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.packageDepth)) && !TextUtils.isEmpty(LdsField.getStringValueSafe(listingdraft.packageLength)))
        {
            String s = listingdraft.shippingType.getStringValue();
            double d = ListingDraft.getWeightDouble(listingdraft);
            double d1 = listingdraft.packageLength.getDoubleValue();
            double d2 = listingdraft.packageWidth.getDoubleValue();
            double d3 = listingdraft.packageDepth.getDoubleValue();
            if (shippingEstimates == null && "ACTUAL_RATE".equals(s) && shippingEstimatesTask == null && isDoubleValueNonZero(d) && isDoubleValueNonZero(d1) && isDoubleValueNonZero(d2) && isDoubleValueNonZero(d3))
            {
                ArrayList arraylist = new ArrayList();
                for (Iterator iterator = listingdraft.shippingService1.options.iterator(); iterator.hasNext(); arraylist.add(((LdsOption)iterator.next()).value)) { }
                shippingEstimatesTask = new GetShippingEstimatesTask(this, draftListDm.getCurrentUser().iafToken, keyParams.draftSite, arraylist, listingdraft.locationPostalCode.getStringValue(), listingdraft.packageType.getStringValue(), ListingDraft.getWeightUnitString(listingdraft), d, ListingDraft.getDimensionsUnitString(listingdraft), d1, d2, d3);
                executeOnThreadPool(shippingEstimatesTask, new Void[0]);
            }
        }
    }

    private void getShippingGuidance()
    {
        Object obj = (ListingDraft)content.getData();
        String s2 = ((ListingDraft) (obj)).category.getStringValue();
        String s1 = ((ListingDraft) (obj)).title.getStringValue();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = "";
        }
        s1 = ((ListingDraft) (obj)).locationPostalCode.getStringValue();
        String s3 = ((ListingDraft) (obj)).locationCountry.getStringValue();
        obj = ((ListingDraft) (obj)).id;
        if (s2 != null && !s2.equals("0") && s1 != null && s3 != null)
        {
            shippingGuidanceShouldRun = false;
            shippingRecommendationTask = new GetShippingRecommendationTask(this, draftListDm.getCurrentUser().iafToken, keyParams.draftSite, s, s2, s3, s1, ((String) (obj)));
            executeOnThreadPool(shippingRecommendationTask, new Void[0]);
        }
    }

    private TimeZone getTimeZoneForSite()
    {
        return SiteTimeZones.fromSiteId(keyParams.draftSite.id);
    }

    private static boolean isDoubleValueNonZero(double d)
    {
        return Math.abs(d) > 9.9999999999999995E-07D;
    }

    private boolean isDraftLoaded()
    {
        if (content == null)
        {
            Log.e(com/ebay/nautilus/domain/content/dm/ListingDraftDataManager.getSimpleName(), "Can't run draft update operation until the data manager has finished loading.", new Exception());
            return false;
        } else
        {
            return true;
        }
    }

    private boolean isGuaranteeSelected()
    {
        ListingDraft listingdraft;
        String s;
        if (content != null && content.getData() != null)
        {
            if ((listingdraft = (ListingDraft)content.getData()).isGuaranteeAvailable() && (listingdraft.format == null || listingdraft.format.getStringValue().equals("ChineseAuction")) && (listingdraft.guaranteeSalePrice == null || listingdraft.guaranteeSalePrice.getStringValue() == null || listingdraft.startPrice == null || listingdraft.guaranteeStartPrice.getStringValue().equals(listingdraft.startPrice.getStringValue())) && (listingdraft.price == null || listingdraft.price.getStringValue() == null) && (listingdraft.reservePrice == null || listingdraft.reservePrice.getStringValue() == null) && (listingdraft.duration.getStringValue().equals(s = (new StringBuilder()).append("Days_").append(listingdraft.recommendedDuration.getStringValue()).toString()) && (listingdraft.startDateEnabled == null || !listingdraft.startDateEnabled.getBooleanValue())))
            {
                return true;
            }
        }
        return false;
    }

    private void loadConditionDefinitions()
    {
        if (content != null)
        {
            ListingDraft listingdraft = (ListingDraft)content.getData();
            if (content.getData() != null && listingdraft.conditionSetId != null)
            {
                conditionDefsTask = new ConditionDefinitionLoadTask(this, listingdraft.conditionSetId.getIntValue(), keyParams.draftSite);
                executeOnThreadPool(conditionDefsTask, new Void[0]);
                return;
            }
        }
    }

    private void loadItemSpecifics(String s)
    {
        if (categoryInfoDm != null)
        {
            return;
        } else
        {
            categoryInfoDm = (ListingCategoryInfoManager)observeDm(new ListingCategoryInfoManager.KeyParams(keyParams.draftSite, s));
            return;
        }
    }

    private void loadProductDescription()
    {
        if (content != null)
        {
            Object obj = (ListingDraft)content.getData();
            if (content.getData() != null && ((ListingDraft) (obj)).productReferenceId != null)
            {
                obj = ((ListingDraft) (obj)).productReferenceId.getStringValue();
                if (obj != null)
                {
                    productDetailsTask = new GetProductDetailsTask(this, draftListDm.getCurrentUser().iafToken, keyParams.draftSite, ((String) (obj)));
                    executeOnThreadPool(productDetailsTask, new Void[0]);
                    return;
                }
            }
        }
    }

    private static ArrayList locationsListForSaving(LdsField ldsfield, LdsField ldsfield1)
    {
        ArrayList arraylist = new ArrayList();
        if (ldsfield.hasSelection() && ldsfield.getStringValue().equals("Worldwide"))
        {
            arraylist.add(LdsField.getCaptionInt(ldsfield1, 1));
            return arraylist;
        }
        if (!ldsfield.hasSelection() && ldsfield1.hasSelection())
        {
            arraylist.add(LdsField.getCaptionInt(ldsfield1, ldsfield1.getIntValue()));
            return arraylist;
        } else
        {
            arraylist.addAll(ldsfield.getSelectedStringValues());
            return arraylist;
        }
    }

    private void removeInternationalShippingOptions(LdsRequestParams ldsrequestparams)
    {
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlShippingType", "NOT_SPECIFIED");
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
    }

    private static void reorderDomesticServices(LdsRequestParams ldsrequestparams, String s, ListingDraft listingdraft)
    {
        boolean flag = false;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   -1329987705: 195
    //                   -1189439095: 165
    //                   747221638: 210
    //                   887770248: 180;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0 = -1;
_L18:
        byte0;
        JVM INSTR tableswitch 0 3: default 80
    //                   0 225
    //                   1 359
    //                   2 493
    //                   3 627;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        ldsrequestparams = listingdraft.cloneFromParcel();
        s.hashCode();
        JVM INSTR lookupswitch 4: default 132
    //                   -1329987705: 777
    //                   -1189439095: 807
    //                   747221638: 761
    //                   887770248: 792;
           goto _L11 _L12 _L13 _L14 _L15
_L11:
        byte0 = -1;
          goto _L16
_L3:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode")) goto _L1; else goto _L17
_L17:
        byte0 = 0;
          goto _L18
_L5:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode")) goto _L1; else goto _L19
_L19:
        byte0 = 1;
          goto _L18
_L2:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode")) goto _L1; else goto _L20
_L20:
        byte0 = 2;
          goto _L18
_L4:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode")) goto _L1; else goto _L21
_L21:
        byte0 = 3;
          goto _L18
_L7:
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode", listingdraft.shippingService3.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode", listingdraft.shippingService2.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", listingdraft.shippingService1.getStringValue());
        if ("FLAT_RATE".equals(listingdraft.shippingType.getStringValue()))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee", "0");
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee", listingdraft.shippingService3fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee", listingdraft.shippingService2fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", listingdraft.shippingService1fee);
        }
          goto _L6
_L8:
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode", listingdraft.shippingService4.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode", listingdraft.shippingService2.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", listingdraft.shippingService1.getStringValue());
        if ("FLAT_RATE".equals(listingdraft.shippingType.getStringValue()))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee", "0");
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee", listingdraft.shippingService4fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee", listingdraft.shippingService2fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", listingdraft.shippingService1fee);
        }
          goto _L6
_L9:
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode", listingdraft.shippingService4.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode", listingdraft.shippingService3.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", listingdraft.shippingService1.getStringValue());
        if ("FLAT_RATE".equals(listingdraft.shippingType.getStringValue()))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee", "0");
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee", listingdraft.shippingService4fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee", listingdraft.shippingService3fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", listingdraft.shippingService1fee);
        }
          goto _L6
_L10:
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode", listingdraft.shippingService4.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode", listingdraft.shippingService3.getStringValue());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", listingdraft.shippingService2.getStringValue());
        if ("FLAT_RATE".equals(listingdraft.shippingType.getStringValue()))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[3].ShippingFee", "0");
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[2].ShippingFee", listingdraft.shippingService4fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[1].ShippingFee", listingdraft.shippingService3fee);
            addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", listingdraft.shippingService2fee);
        }
          goto _L6
_L14:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode")) goto _L11; else goto _L22
_L22:
        byte0 = flag;
          goto _L16
_L12:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[1].EBayAPISoapServiceCode")) goto _L11; else goto _L23
_L23:
        byte0 = 1;
          goto _L16
_L15:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[2].EBayAPISoapServiceCode")) goto _L11; else goto _L24
_L24:
        byte0 = 2;
          goto _L16
_L13:
        if (!s.equals("Listing.ShippingInfo.DomesticItemShippingService[3].EBayAPISoapServiceCode")) goto _L11; else goto _L25
_L25:
        byte0 = 3;
_L16:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            listingdraft.shippingService1.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService2.getSelectedValues());
            listingdraft.shippingService1fee.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService2fee.getSelectedValues());
            // fall through

        case 1: // '\001'
            listingdraft.shippingService2.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService3.getSelectedValues());
            listingdraft.shippingService2fee.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService3fee.getSelectedValues());
            // fall through

        case 2: // '\002'
            listingdraft.shippingService3.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService4.getSelectedValues());
            listingdraft.shippingService3fee.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).shippingService4fee.getSelectedValues());
            // fall through

        case 3: // '\003'
            listingdraft.shippingService4.replaceSelectedValue("NotSelected");
            break;
        }
        listingdraft.shippingService4fee.replaceSelectedValue("0");
        return;
          goto _L18
    }

    private static void reorderIntlServices(LdsRequestParams ldsrequestparams, String s, ListingDraft listingdraft)
    {
        boolean flag = false;
        s.hashCode();
        JVM INSTR lookupswitch 5: default 56
    //                   -829390680: 234
    //                   -688842070: 204
    //                   1247818663: 249
    //                   1388367273: 219
    //                   1528915883: 189;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        byte byte0 = -1;
_L21:
        byte0;
        JVM INSTR tableswitch 0 4: default 92
    //                   0 264
    //                   1 281
    //                   2 385
    //                   3 586
    //                   4 837;
           goto _L7 _L8 _L9 _L10 _L11 _L12
_L7:
        ldsrequestparams = listingdraft.cloneFromParcel();
        s.hashCode();
        JVM INSTR lookupswitch 5: default 152
    //                   -829390680: 1218
    //                   -688842070: 1248
    //                   1247818663: 1202
    //                   1388367273: 1233
    //                   1528915883: 1263;
           goto _L13 _L14 _L15 _L16 _L17 _L18
_L13:
        byte0 = -1;
          goto _L19
_L6:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode")) goto _L1; else goto _L20
_L20:
        byte0 = 0;
          goto _L21
_L3:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode")) goto _L1; else goto _L22
_L22:
        byte0 = 1;
          goto _L21
_L5:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode")) goto _L1; else goto _L23
_L23:
        byte0 = 2;
          goto _L21
_L2:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode")) goto _L1; else goto _L24
_L24:
        byte0 = 3;
          goto _L21
_L4:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode")) goto _L1; else goto _L25
_L25:
        byte0 = 4;
          goto _L21
_L8:
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
          goto _L7
_L9:
        if (listingdraft.intlShippingService5.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", listingdraft.intlShippingService5.getStringValue());
            ldsrequestparams.intlShipLocations4 = locationsListForSaving(listingdraft.intlShipToLocation5, listingdraft.intlShipToRegion5);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee", listingdraft.intlShippingFee5);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        }
          goto _L7
_L10:
        if (listingdraft.intlShippingService5.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", listingdraft.intlShippingService5.getStringValue());
            ldsrequestparams.intlShipLocations4 = locationsListForSaving(listingdraft.intlShipToLocation5, listingdraft.intlShipToRegion5);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee", listingdraft.intlShippingFee5);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
            listingdraft.intlShippingService4.replaceSelectedValue("NotSelected");
        }
        if (listingdraft.intlShippingService4.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", listingdraft.intlShippingService4.getStringValue());
            ldsrequestparams.intlShipLocations3 = locationsListForSaving(listingdraft.intlShipToLocation4, listingdraft.intlShipToRegion4);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee", listingdraft.intlShippingFee4);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", "NotSelected");
        }
          goto _L7
_L11:
        if (listingdraft.intlShippingService5.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", listingdraft.intlShippingService5.getStringValue());
            ldsrequestparams.intlShipLocations4 = locationsListForSaving(listingdraft.intlShipToLocation5, listingdraft.intlShipToRegion5);
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        }
        if (listingdraft.intlShippingService4.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", listingdraft.intlShippingService4.getStringValue());
            ldsrequestparams.intlShipLocations3 = locationsListForSaving(listingdraft.intlShipToLocation4, listingdraft.intlShipToRegion4);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee", listingdraft.intlShippingFee4);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", "NotSelected");
        }
        if (listingdraft.intlShippingService3.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", listingdraft.intlShippingService3.getStringValue());
            ldsrequestparams.intlShipLocations2 = locationsListForSaving(listingdraft.intlShipToLocation3, listingdraft.intlShipToRegion3);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee", listingdraft.intlShippingFee3);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", "NotSelected");
        }
          goto _L7
_L12:
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode", "NotSelected");
        if (listingdraft.intlShippingService5.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", listingdraft.intlShippingService5.getStringValue());
            ldsrequestparams.intlShipLocations4 = locationsListForSaving(listingdraft.intlShipToLocation5, listingdraft.intlShipToRegion5);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[3].ShippingFee", listingdraft.intlShippingFee5);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode", "NotSelected");
        }
        if (listingdraft.intlShippingService4.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", listingdraft.intlShippingService4.getStringValue());
            ldsrequestparams.intlShipLocations3 = locationsListForSaving(listingdraft.intlShipToLocation4, listingdraft.intlShipToRegion4);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[2].ShippingFee", listingdraft.intlShippingFee4);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode", "NotSelected");
        }
        if (listingdraft.intlShippingService3.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", listingdraft.intlShippingService3.getStringValue());
            ldsrequestparams.intlShipLocations2 = locationsListForSaving(listingdraft.intlShipToLocation3, listingdraft.intlShipToRegion3);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[1].ShippingFee", listingdraft.intlShippingFee3);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode", "NotSelected");
        }
        if (listingdraft.intlShippingService2.isEnabled())
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode", listingdraft.intlShippingService2.getStringValue());
            ldsrequestparams.intlShipLocations1 = locationsListForSaving(listingdraft.intlShipToLocation2, listingdraft.intlShipToRegion2);
            if ("FLAT_RATE".equals(listingdraft.intlShippingType.getStringValue()))
            {
                addFeeIfNonNull(ldsrequestparams, "Listing.ShippingInfo.IntlItemShippingService[0].ShippingFee", listingdraft.intlShippingFee2);
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode", "NotSelected");
        }
          goto _L7
_L16:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[0].EBayAPISoapServiceCode")) goto _L13; else goto _L26
_L26:
        byte0 = flag;
          goto _L19
_L14:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[1].EBayAPISoapServiceCode")) goto _L13; else goto _L27
_L27:
        byte0 = 1;
          goto _L19
_L17:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[2].EBayAPISoapServiceCode")) goto _L13; else goto _L28
_L28:
        byte0 = 2;
          goto _L19
_L15:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[3].EBayAPISoapServiceCode")) goto _L13; else goto _L29
_L29:
        byte0 = 3;
          goto _L19
_L18:
        if (!s.equals("Listing.ShippingInfo.IntlItemShippingService[4].EBayAPISoapServiceCode")) goto _L13; else goto _L30
_L30:
        byte0 = 4;
_L19:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            listingdraft.intlShippingService1.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingService2.getSelectedValues());
            listingdraft.intlShipToLocation1.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShipToLocation2.getSelectedValues());
            listingdraft.intlShippingFee1.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingFee2.getSelectedValues());
            // fall through

        case 1: // '\001'
            listingdraft.intlShippingService2.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingService3.getSelectedValues());
            listingdraft.intlShipToLocation2.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShipToLocation3.getSelectedValues());
            listingdraft.intlShippingFee2.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingFee3.getSelectedValues());
            // fall through

        case 2: // '\002'
            listingdraft.intlShippingService3.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingService4.getSelectedValues());
            listingdraft.intlShipToLocation3.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShipToLocation4.getSelectedValues());
            listingdraft.intlShippingFee3.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingFee4.getSelectedValues());
            // fall through

        case 3: // '\003'
            listingdraft.intlShippingService4.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingService5.getSelectedValues());
            listingdraft.intlShipToLocation4.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShipToLocation5.getSelectedValues());
            listingdraft.intlShippingFee4.replaceSelectedValues(((ListingDraft) (ldsrequestparams)).intlShippingFee5.getSelectedValues());
            // fall through

        case 4: // '\004'
            listingdraft.intlShippingService5.replaceSelectedValue("NotSelected");
            break;
        }
        listingdraft.intlShipToLocation5.replaceSelectedValue("NotSelected");
        listingdraft.intlShippingFee5.replaceSelectedValue("0");
        return;
          goto _L21
    }

    private static boolean shouldTurnOnBestOffer(LdsField ldsfield, String s, DeviceConfiguration deviceconfiguration, ListingDraftPreferences listingdraftpreferences, Authentication authentication)
    {
        while (ldsfield == null || !s.equals("FixedPrice") && !s.equals("StoresFixedPrice") || !deviceconfiguration.get(DcsNautilusBoolean.SellDefaultBestOffer) && !listingdraftpreferences.doesPrefExist(authentication, "sellBestOffer")) 
        {
            return false;
        }
        return listingdraftpreferences.getBestOfferEnabled(authentication);
    }

    private void updateAuctionPriceValues(FormatPriceTextFields formatpricetextfields, boolean flag)
    {
        LdsRequestParams ldsrequestparams;
        ListingDraft listingdraft;
        if (flag)
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
        } else
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_PRICE_AUCTION);
        }
        listingdraft = (ListingDraft)content.getData();
        addUpdatedDraftPriceValue(listingdraft.startPrice, formatpricetextfields.startPrice, ldsrequestparams);
        addUpdatedDraftPriceValue(listingdraft.price, formatpricetextfields.binPrice, ldsrequestparams);
        addUpdatedDraftPriceValue(listingdraft.reservePrice, formatpricetextfields.reservePrice, ldsrequestparams);
        if (ldsrequestparams.values.containsKey("Listing.StartPrice"))
        {
            listingdraft.startPrice.replaceSelectedValue(formatpricetextfields.startPrice);
        }
        if (ldsrequestparams.values.containsKey("Listing.Price"))
        {
            listingdraft.price.replaceSelectedValue(formatpricetextfields.binPrice);
        }
        if (ldsrequestparams.values.containsKey("Listing.AuctionReservePrice"))
        {
            listingdraft.reservePrice.replaceSelectedValue(formatpricetextfields.reservePrice);
        }
        if (flag)
        {
            dispatch(DispatchType.VALIDATE_ACK);
        } else
        {
            dispatch();
        }
        if (!ldsrequestparams.values.isEmpty() || !ldsrequestparams.deletedValues.isEmpty() || ldsrequestparams.fullValidation)
        {
            executeTask(ldsrequestparams);
        }
    }

    private void updateFixedPriceValues(FormatPriceTextFields formatpricetextfields, boolean flag)
    {
        LdsRequestParams ldsrequestparams;
        ListingDraft listingdraft;
        boolean flag1;
        boolean flag2;
        if (flag)
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
        } else
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_PRICE_FIXED);
        }
        listingdraft = (ListingDraft)content.getData();
        addUpdatedDraftPriceValue(listingdraft.price, formatpricetextfields.fixedPrice, ldsrequestparams);
        addUpdatedDraftValue(listingdraft.quantity, formatpricetextfields.quantity, ldsrequestparams);
        flag1 = isDoubleValueNonZero(Double.valueOf(formatpricetextfields.autoAcceptValue).doubleValue());
        flag2 = isDoubleValueNonZero(Double.valueOf(formatpricetextfields.autoDeclineValue).doubleValue());
        addUpdatedDraftValue(listingdraft.bestOfferAutoAccept, String.valueOf(flag1), ldsrequestparams);
        addUpdatedDraftPriceValue(listingdraft.bestOfferAutoAcceptValue, formatpricetextfields.autoAcceptValue, ldsrequestparams);
        addUpdatedDraftValue(listingdraft.bestOfferAutoDecline, String.valueOf(flag2), ldsrequestparams);
        addUpdatedDraftPriceValue(listingdraft.bestOfferAutoDeclineValue, formatpricetextfields.autoDeclineValue, ldsrequestparams);
        if (ldsrequestparams.values.containsKey("Listing.Price"))
        {
            listingdraft.price.replaceSelectedValue(formatpricetextfields.fixedPrice);
        }
        if (ldsrequestparams.values.containsKey("Listing.Quantity"))
        {
            listingdraft.quantity.replaceSelectedValue(formatpricetextfields.quantity);
        }
        if (ldsrequestparams.values.containsKey("Listing.BestOffer.AutoAccept"))
        {
            listingdraft.bestOfferAutoAccept.replaceSelectedValue(String.valueOf(flag1));
        }
        if (ldsrequestparams.values.containsKey("Listing.BestOffer.AutoAcceptAmount"))
        {
            listingdraft.bestOfferAutoAcceptValue.replaceSelectedValue(formatpricetextfields.autoAcceptValue);
        }
        if (ldsrequestparams.values.containsKey("Listing.BestOffer.AutoDecline"))
        {
            listingdraft.bestOfferAutoDecline.replaceSelectedValue(String.valueOf(flag2));
        }
        if (ldsrequestparams.values.containsKey("Listing.BestOffer.AutodeclineAmount"))
        {
            listingdraft.bestOfferAutoDeclineValue.replaceSelectedValue(formatpricetextfields.autoDeclineValue);
        }
        if (flag)
        {
            dispatch(DispatchType.VALIDATE_ACK);
        } else
        {
            dispatch();
        }
        if (!ldsrequestparams.values.isEmpty() || !ldsrequestparams.deletedValues.isEmpty() || ldsrequestparams.fullValidation)
        {
            executeTask(ldsrequestparams);
        }
    }

    private void updateRemoveStockPhoto()
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            Object obj = (ListingDraft)content.getData();
            ((ListingDraft) (obj)).productStockPhoto.clearSelections();
            dispatch();
            draftListDm.updateDraft(((ListingDraft) (obj)));
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_REMOVE_STOCK_PHOTO);
            ((LdsRequestParams) (obj)).deletedValues.add("Listing.Item.ProductInfo.StockPhoto");
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void cancelDraftValidation()
    {
        NautilusKernel.verifyMain();
        queuedValidationTask = null;
        cancelTask(ListingDraftOperation.UPDATE_FOR_REVIEW);
    }

    public void clearSpecificsGuidanceFlag()
    {
        hasSpecificsGuidance = false;
        dispatch();
    }

    public void create()
    {
        draftListDm = (SavedListingDraftDataManager)observeDm(SavedListingDraftDataManager.KEY);
    }

    public void deleteShippingService(String s, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_DELETE_SHIPPING);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        if (flag)
        {
            reorderDomesticServices(ldsrequestparams, s, (ListingDraft)content.getData());
            if (listingdraft.getDomesticShippingCount() == 0)
            {
                removeInternationalShippingOptions(ldsrequestparams);
            }
            clearShippingGuidance(false);
        } else
        {
            reorderIntlServices(ldsrequestparams, s, (ListingDraft)content.getData());
        }
        dispatch();
        executeTask(ldsrequestparams);
    }

    public KeyParams getParams()
    {
        return keyParams;
    }

    public volatile Object getParams()
    {
        return getParams();
    }

    public ListingDraftContent getPublishContent()
    {
        return publishContent;
    }

    public void handleConditionDefinitionsResult(SparseArray sparsearray)
    {
        conditionDefsTask = null;
        if (sparsearray != null)
        {
            conditionDefinitions = sparsearray;
            dispatch();
        }
    }

    public void handleDraftTaskResult(ListingDraftLoadTask listingdraftloadtask, ListingDraftContent listingdraftcontent)
    {
        taskList.remove(listingdraftloadtask);
        if (listingdraftcontent != null)
        {
            Object obj;
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.UPDATE_FOR_REVIEW))
            {
                obj = DispatchType.VALIDATE_COMPLETE;
            } else
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.PUBLISH))
            {
                obj = DispatchType.PUBLISH_COMPLETE;
            } else
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.CREATE))
            {
                obj = DispatchType.CREATE_COMPLETE;
            } else
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.CREATE_RELIST))
            {
                obj = DispatchType.CREATE_RELIST_COMPLETE;
            } else
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.UPDATE_CATEGORY))
            {
                obj = DispatchType.BLOCKING_CHANGE_COMPLETE;
            } else
            {
                obj = DispatchType.COMPLETE;
            }
            if (listingdraftcontent.getStatus().hasError())
            {
                ((Observer)dispatcher).onContentChanged(this, listingdraftcontent, ((DispatchType) (obj)));
                queuedValidationTask = null;
                queuedUpdateShippingForGuidanceTask = null;
                return;
            }
            if (((DispatchType) (obj)).equals(DispatchType.PUBLISH_COMPLETE))
            {
                publishContent = listingdraftcontent;
            } else
            {
                content = listingdraftcontent;
            }
            if (listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.GET) || listingdraftloadtask.getRequestParams().operation.equals(ListingDraftOperation.CREATE) && keyParams.listingMode.equals("ReviseItem"))
            {
                isGuaranteeSelectedThisSession = isGuaranteeSelected();
            } else
            {
                boolean flag1;
                if (isGuaranteeSelectedThisSession && isGuaranteeSelected())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                isGuaranteeSelectedThisSession = flag1;
            }
            dispatch(((DispatchType) (obj)));
            if (!((DispatchType) (obj)).equals(DispatchType.PUBLISH_COMPLETE))
            {
                listingdraftcontent = (ListingDraft)content.getData();
                if ((((DispatchType) (obj)).equals(DispatchType.CREATE_COMPLETE) || ((DispatchType) (obj)).equals(DispatchType.CREATE_RELIST_COMPLETE)) && !listingdraftloadtask.getRequestParams().listingMode.equals("ReviseItem"))
                {
                    draftListDm.addDraft(listingdraftcontent);
                }
                obj = ListingDraftOperation.fromOrdinal(listingdraftloadtask.taskId);
                if (((ListingDraftOperation) (obj)).shouldCompletionTriggerSecondaryTasks())
                {
                    loadItemSpecifics(((ListingDraft) (listingdraftcontent)).category.getStringValue());
                    loadConditionDefinitions();
                    loadProductDescription();
                }
                String s;
                if (taskList.isEmpty() && queuedValidationTask != null)
                {
                    executeOnThreadPool(queuedValidationTask, new Void[0]);
                    queuedValidationTask = null;
                } else
                if (taskList.isEmpty() && queuedUpdateShippingForGuidanceTask != null)
                {
                    executeOnThreadPool(queuedUpdateShippingForGuidanceTask, new Void[0]);
                    queuedUpdateShippingForGuidanceTask = null;
                }
                s = keyParams.listingMode;
                if (s != null && !s.equals("ReviseItem") && !s.equals("RelistItem") && !s.equals("SellSimilarItem"))
                {
                    listingdraftloadtask = DeviceConfiguration.getAsync();
                    boolean flag = listingdraftloadtask.get(DcsNautilusBoolean.SellPrefillSpecifics);
                    if (((ListingDraftOperation) (obj)).equals(ListingDraftOperation.CREATE) && s.equals("AddItem") && flag)
                    {
                        getItemSpecificsGuidance();
                    }
                    if (listingdraftloadtask.get(DcsNautilusBoolean.SellShippingGuidance) && shippingRecommendation == null && shippingGuidanceShouldRun)
                    {
                        if (!"NOT_SPECIFIED".equals(LdsField.getStringValueSafe(((ListingDraft) (listingdraftcontent)).shippingType)) && "NotSelected".equals(LdsField.getStringValueSafe(((ListingDraft) (listingdraftcontent)).shippingService1)) && "NotSelected".equals(LdsField.getStringValueSafe(((ListingDraft) (listingdraftcontent)).shippingService2)) && "NotSelected".equals(LdsField.getStringValueSafe(((ListingDraft) (listingdraftcontent)).shippingService3)) && "NotSelected".equals(LdsField.getStringValueSafe(((ListingDraft) (listingdraftcontent)).shippingService4)))
                        {
                            getShippingGuidance();
                        } else
                        {
                            shippingGuidanceShouldRun = false;
                        }
                    }
                    if (shippingEstimates == null || shippingEstimates.isEmpty())
                    {
                        getShippingEstimates();
                    }
                    if (canOverrideFormatWithRecommendation && ((ListingDraft) (listingdraftcontent)).recommendedFormat != null && ((ListingDraft) (listingdraftcontent)).recommendedFormat.getStringValue() != null && ((ListingDraft) (listingdraftcontent)).format != null && ((ListingDraft) (listingdraftcontent)).format.getStringValue() != null && !((ListingDraft) (listingdraftcontent)).recommendedFormat.getStringValue().equals(((ListingDraft) (listingdraftcontent)).format.getStringValue()))
                    {
                        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FORMAT);
                        ldsrequestparams.values.put("Listing.Format", ((ListingDraft) (listingdraftcontent)).recommendedFormat.getStringValue());
                        String s1 = ((ListingDraft) (listingdraftcontent)).recommendedFormat.getStringValue();
                        String s2 = DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.S.durationOverrideValueFixedPrice);
                        if (!TextUtils.isEmpty(s2) && (s1.equals("FixedPrice") || s1.equals("StoresFixedPrice")))
                        {
                            ldsrequestparams.values.put("Listing.Duration", s2);
                        }
                        if (shouldTurnOnBestOffer(((ListingDraft) (listingdraftcontent)).bestOfferEnabled, s1, listingdraftloadtask, prefs, draftListDm.getCurrentUser()))
                        {
                            ldsrequestparams.values.put("Listing.BestOffer.BestOfferEnabled", String.valueOf(true));
                            ((ListingDraft) (listingdraftcontent)).bestOfferEnabled.replaceSelectedValue(String.valueOf(true));
                        }
                        executeTask(ldsrequestparams);
                        ((ListingDraft) (listingdraftcontent)).format.replaceSelectedValue(s1);
                        dispatch();
                    }
                    if (listingdraftloadtask.get(DcsNautilusBoolean.SellPrefillPaypalEmail) && paypalPrefillShouldRun && ((ListingDraft) (listingdraftcontent)).paypalEmailAddress != null && TextUtils.isEmpty(((ListingDraft) (listingdraftcontent)).paypalEmailAddress.getStringValue()) && ((ListingDraft) (listingdraftcontent)).paypalEmailAddressKnown != null && ((ListingDraft) (listingdraftcontent)).paypalEmailAddressKnown.options.size() > 0)
                    {
                        listingdraftloadtask = ((LdsOption)((ListingDraft) (listingdraftcontent)).paypalEmailAddressKnown.options.get(0)).value;
                        if (!TextUtils.isEmpty(listingdraftloadtask))
                        {
                            LdsRequestParams ldsrequestparams1 = new LdsRequestParams(ListingDraftOperation.UPDATE_PAYMENT_METHODS);
                            ldsrequestparams1.values.put("Listing.PaymentInfo.PaypalEmailAddress", listingdraftloadtask);
                            executeTask(ldsrequestparams1);
                            ((ListingDraft) (listingdraftcontent)).paypalEmailAddress.replaceSelectedValue(listingdraftloadtask);
                            dispatch();
                            prefs.setSellerPaypalEmail(draftListDm.getCurrentUser(), listingdraftloadtask);
                        }
                    }
                    paypalPrefillShouldRun = false;
                    return;
                }
            }
        }
    }

    public void handleDraftTaskStarted(ListingDraftLoadTask listingdraftloadtask)
    {
        lastTask = listingdraftloadtask;
        taskList.add(listingdraftloadtask);
    }

    public void handleExtractSpecificsResult(ArrayList arraylist)
    {
        while (!isDraftLoaded() || arraylist == null || arraylist.isEmpty()) 
        {
            return;
        }
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_ITEM_SPECIFICS);
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            Object obj = (com.ebay.nautilus.domain.net.api.attribute.GetAttributesResponse.Attribute)arraylist.next();
            LdsField ldsfield = new LdsField();
            ldsfield.setBmode("ENABLE");
            ldsfield.id = (new StringBuilder()).append("Listing.Item.ItemSpecific[").append(((com.ebay.nautilus.domain.net.api.attribute.GetAttributesResponse.Attribute) (obj)).type).append("]").toString();
            for (obj = ((com.ebay.nautilus.domain.net.api.attribute.GetAttributesResponse.Attribute) (obj)).values.iterator(); ((Iterator) (obj)).hasNext(); ldsfield.addSelectedValue((String)((Iterator) (obj)).next())) { }
            ldsrequestparams.itemSpecifics.add(ldsfield);
            ((ListingDraft)content.getData()).selectedItemSpecifics.add(ldsfield);
            hasSpecificsGuidance = true;
        }

        dispatch();
        executeTask(ldsrequestparams);
    }

    public void handleProductDetailsResult(String s)
    {
        productDetailsTask = null;
        if (s != null)
        {
            productDescription = s;
            dispatch();
        }
    }

    public void handleShippingEstimatesResult(ArrayList arraylist)
    {
        shippingEstimatesTask = null;
        if (arraylist == null)
        {
            return;
        } else
        {
            shippingEstimates = arraylist;
            dispatch();
            return;
        }
    }

    public void handleShippingRecommendationResult(ShippingRecommendation shippingrecommendation)
    {
        shippingRecommendationTask = null;
        if (shippingrecommendation != null)
        {
            shippingRecommendation = shippingrecommendation;
            dispatch();
            if (shippingRecommendation.shippingService.serviceId != null && isDraftLoaded())
            {
                shippingrecommendation = (ListingDraft)content.getData();
                LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING_FOR_GUIDANCE);
                ldsrequestparams.values.put("Listing.ListingCurrency", shippingrecommendation.getCurrencyCode());
                HashMap hashmap;
                if (((ListingDraft) (shippingrecommendation)).siteId == 0 || 15 == ((ListingDraft) (shippingrecommendation)).siteId)
                {
                    ldsrequestparams.values.put("Listing.ShippingInfo.DomesticShippingType", "ACTUAL_RATE");
                } else
                {
                    ldsrequestparams.values.put("Listing.ShippingInfo.DomesticShippingType", "FLAT_RATE");
                }
                ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", shippingRecommendation.shippingService.serviceId);
                if (((ListingDraft) (shippingrecommendation)).siteId != 0 && shippingRecommendation.costs.size() > 0)
                {
                    ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", String.valueOf(((ShippingZonalCost)shippingRecommendation.costs.get(0)).cost));
                }
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value", String.valueOf((int)shippingRecommendation.length));
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value", String.valueOf((int)shippingRecommendation.width));
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value", String.valueOf((int)shippingRecommendation.height));
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", shippingRecommendation.getWeightMajor());
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", shippingRecommendation.getWeightMinor());
                ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageType", shippingRecommendation.packageType);
                hashmap = ldsrequestparams.values;
                if (shippingRecommendation.requireWeighDimensionValidation)
                {
                    shippingrecommendation = "true";
                } else
                {
                    shippingrecommendation = "false";
                }
                hashmap.put("Listing.ShippingInfo.IrregularPackage", shippingrecommendation);
                executeTask(ldsrequestparams);
                return;
            }
        }
    }

    public boolean isReservePriceSupported()
    {
        return !keyParams.draftSite.equals(EbaySite.AU) && !keyParams.draftSite.equals(EbaySite.ES);
    }

    public void loadData(Observer observer)
    {
        NautilusKernel.verifyMain();
        if (content != null)
        {
            if (observer != null)
            {
                observer.onContentChanged(this, content, DispatchType.ACK);
            }
        } else
        if (taskList.isEmpty())
        {
            LoadDraftDetails loaddraftdetails = null;
            if (observer instanceof LoadDraftDetailsGenerator)
            {
                loaddraftdetails = ((LoadDraftDetailsGenerator)observer).generateLoadDraftDetails();
            }
            if (loaddraftdetails != null)
            {
                observer = ListingDraftLoadTask.buildLoadParams(loaddraftdetails, keyParams);
                if (((LdsRequestParams) (observer)).id == null && ((LdsRequestParams) (observer)).sourceItemId == null)
                {
                    canOverrideFormatWithRecommendation = true;
                }
                executeTask(observer);
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onContentChanged(Content content1, SavedListingDraftDataManager.DispatchType dispatchtype)
    {
    }

    public void onItemSpecificsChanged(Content content1)
    {
        if (categoryInfoDm != null)
        {
            unObserveDm(categoryInfoDm);
            categoryInfoDm = null;
        }
        if (content1 != null && !content1.getStatus().hasError() && content1.getData() != null)
        {
            itemSpecificsContent = content1;
            dispatch();
        }
    }

    public void publishDraft(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        dispatch(DispatchType.PUBLISH_ACK);
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.PUBLISH);
        if (s != null)
        {
            ldsrequestparams.values.put("Listing.AutoRelistInfo.AutoRelistEnabled", s);
        }
        executeTask(ldsrequestparams);
    }

    public void removeDraft()
    {
        if (content == null)
        {
            return;
        } else
        {
            draftListDm.removeDraft(((ListingDraft)content.getData()).id);
            return;
        }
    }

    public void resetListingFormSession()
    {
        shippingGuidanceShouldRun = true;
        paypalPrefillShouldRun = true;
        canOverrideFormatWithRecommendation = false;
    }

    public final void retryLastRequest()
    {
        NautilusKernel.verifyMain();
        if (lastTask != null)
        {
            executeTask(lastTask.getRequestParams());
        }
    }

    public void updateBestOffer(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_BEST_OFFER);
            ldsrequestparams.values.put("Listing.BestOffer.BestOfferEnabled", String.valueOf(flag));
            ((ListingDraft)content.getData()).bestOfferEnabled.replaceSelectedValue(String.valueOf(flag));
            prefs.setBestOfferEnabled(draftListDm.getCurrentUser(), flag);
            dispatch();
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateCategory(String s, String s1)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_CATEGORY);
        ldsrequestparams.values.put("Listing.CategoryInfo[0].Id", s);
        LdsField ldsfield;
        for (s = listingdraft.selectedItemSpecifics.iterator(); s.hasNext(); ldsrequestparams.deletedValues.add(ldsfield.id))
        {
            ldsfield = (LdsField)s.next();
        }

        ldsrequestparams.deletedValues.add("Listing.Item.ProductInfo.ProductId");
        s = listingdraft.title.getStringValue();
        if (!TextUtils.isEmpty(s))
        {
            ldsrequestparams.values.put("Listing.Item.Title", s);
        }
        listingdraft.categoryNamePath.replaceSelectedValue(s1);
        listingdraft.condition.clearSelections();
        listingdraft.selectedItemSpecifics.clear();
        listingdraft.productId.clearSelections();
        listingdraft.productStockPhoto.clearSelections();
        clearItemSpecifics();
        clearConditionDefinitions();
        clearProductDescription();
        clearShippingGuidance(true);
        dispatch(DispatchType.BLOCKING_CHANGE_ACK);
        draftListDm.updateDraft(listingdraft);
        executeTask(ldsrequestparams);
    }

    public void updateCondition(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        boolean flag = isGuaranteeSelectedThisSession;
        isGuaranteeSelectedThisSession = false;
        Object obj = new LdsRequestParams(ListingDraftOperation.UPDATE_CONDITION);
        ((LdsRequestParams) (obj)).values.put("Listing.Condition", s);
        if (flag)
        {
            ((LdsRequestParams) (obj)).deletedValues.add("Listing.StartPrice");
        }
        executeTask(((LdsRequestParams) (obj)));
        obj = (ListingDraft)content.getData();
        ((ListingDraft) (obj)).condition.replaceSelectedValue(s);
        if (flag && ((ListingDraft) (obj)).startPrice != null)
        {
            ((ListingDraft) (obj)).startPrice.replaceSelectedValue("");
        }
        dispatch();
    }

    public void updateConditionDescription(String s, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        LdsRequestParams ldsrequestparams;
        ListingDraft listingdraft;
        if (flag)
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
        } else
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_CONDITION_DESCRIPTION);
        }
        listingdraft = (ListingDraft)content.getData();
        addUpdatedDraftValue(listingdraft.conditionDescription, s, ldsrequestparams);
        executeTask(ldsrequestparams);
        listingdraft.conditionDescription.replaceSelectedValue(s);
        if (flag)
        {
            dispatch(DispatchType.VALIDATE_ACK);
            return;
        } else
        {
            dispatch();
            return;
        }
    }

    public void updateCurrency(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            Object obj = (ListingDraft)content.getData();
            LdsField ldsfield = ((ListingDraft) (obj)).getCurrencyUnsafe();
            ldsfield.replaceSelectedValue(s);
            ((ListingDraft) (obj)).setCurrency(ldsfield);
            dispatch();
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_CURRENCY);
            ((LdsRequestParams) (obj)).values.put("Listing.ListingCurrency", s);
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void updateDescription(boolean flag, String s, boolean flag1)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        LdsRequestParams ldsrequestparams;
        Object obj;
        if (flag1)
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
        } else
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_DESCRIPTION);
        }
        obj = (ListingDraft)content.getData();
        if (flag)
        {
            obj = ((ListingDraft) (obj)).appendToDescription;
        } else
        {
            obj = ((ListingDraft) (obj)).description;
        }
        addUpdatedDraftValue(((LdsField) (obj)), s, ldsrequestparams);
        executeTask(ldsrequestparams);
        ((LdsField) (obj)).replaceSelectedValue(s);
        if (flag1)
        {
            dispatch(DispatchType.VALIDATE_ACK);
            return;
        } else
        {
            dispatch();
            return;
        }
    }

    public void updateDonationEnabled(boolean flag, String s, String s1)
    {
        NautilusKernel.verifyMain();
        if (isDraftLoaded())
        {
            Object obj = (ListingDraft)content.getData();
            if (flag)
            {
                if (!((ListingDraft) (obj)).charityId.getStringValue().equals(s))
                {
                    LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_CHARITY_ID);
                    if (((ListingDraft) (obj)).charityId.getStringValue().equals("0"))
                    {
                        String s2 = DeviceConfiguration.getAsync().get(DcsNautilusString.SellCharityDonationDefault);
                        s2 = prefs.getCharityDonationPercent(draftListDm.getCurrentUser(), s2);
                        if (!TextUtils.isEmpty(s2))
                        {
                            ((ListingDraft) (obj)).charityDonationPercent.replaceSelectedValue(s2);
                            ldsrequestparams.values.put("Listing.CharityInfo.DonationPercent", s2);
                        }
                    }
                    ((ListingDraft) (obj)).charityId.replaceSelectedValue(s);
                    obj = ((ListingDraft) (obj)).charityId.options;
                    boolean flag2 = false;
                    int i = 0;
                    do
                    {
label0:
                        {
                            boolean flag1 = flag2;
                            if (i < ((ArrayList) (obj)).size())
                            {
                                if (!((LdsOption)((ArrayList) (obj)).get(i)).value.equals(s))
                                {
                                    break label0;
                                }
                                flag1 = true;
                            }
                            if (!flag1)
                            {
                                LdsOption ldsoption = new LdsOption();
                                ldsoption.value = s;
                                ldsoption.caption = s1;
                                ((ArrayList) (obj)).add(ldsoption);
                            }
                            dispatch();
                            ldsrequestparams.values.put("Listing.CharityInfo.CharityId", s);
                            executeTask(ldsrequestparams);
                            return;
                        }
                        i++;
                    } while (true);
                }
            } else
            {
                ((ListingDraft) (obj)).charityId.replaceSelectedValue("0");
                dispatch();
                s = new LdsRequestParams(ListingDraftOperation.UPDATE_CHARITY_ID);
                ((LdsRequestParams) (s)).values.put("Listing.CharityInfo.CharityId", "0");
                executeTask(s);
                return;
            }
        }
    }

    public void updateDonationPercentage(String s)
    {
        NautilusKernel.verifyMain();
        Object obj;
        if (isDraftLoaded())
        {
            if (((ListingDraft) (obj = (ListingDraft)content.getData())).charityDonationPercent.isEnabled() && !TextUtils.isEmpty(s) && !s.equals(((ListingDraft) (obj)).charityDonationPercent.getStringValue()))
            {
                ((ListingDraft) (obj)).charityDonationPercent.replaceSelectedValue(s);
                dispatch();
                prefs.setCharityDonationPercent(draftListDm.getCurrentUser(), s);
                obj = new LdsRequestParams(ListingDraftOperation.UPDATE_CHARITY_PERCENTAGE);
                ((LdsRequestParams) (obj)).values.put("Listing.CharityInfo.DonationPercent", s);
                executeTask(((LdsRequestParams) (obj)));
                return;
            }
        }
    }

    public void updateDropProduct()
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_DROP_PRODUCT);
            ldsrequestparams.deletedValues.add("Listing.Item.ProductInfo.ProductId");
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateDuration(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_START_TIME_DURATION);
            ldsrequestparams.values.put("Listing.Duration", s);
            ((ListingDraft)content.getData()).duration.replaceSelectedValue(s);
            dispatch();
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateFormat(String s, FormatPriceTextFields formatpricetextfields)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FORMAT);
        ldsrequestparams.values.put("Listing.Format", s);
        Object obj;
        if (s.equals("ChineseAuction"))
        {
            formatpricetextfields = formatpricetextfields.fixedPrice;
        } else
        {
            formatpricetextfields = formatpricetextfields.binPrice;
        }
        obj = DeviceConfiguration.getAsync().get(com.ebay.nautilus.domain.dcs.DcsDomain.Selling.S.durationOverrideValueFixedPrice);
        if (!TextUtils.isEmpty(((CharSequence) (obj))) && (s.equals("FixedPrice") || s.equals("StoresFixedPrice")))
        {
            ldsrequestparams.values.put("Listing.Duration", obj);
        }
        obj = (ListingDraft)content.getData();
        addUpdatedDraftPriceValue(((ListingDraft) (obj)).price, formatpricetextfields, ldsrequestparams);
        ((ListingDraft) (obj)).format.replaceSelectedValue(s);
        if (s.equals("ChineseAuction"))
        {
            ((ListingDraft) (obj)).startPrice.clearSelections();
        }
        if (ldsrequestparams.values.containsKey("Listing.Price"))
        {
            ((ListingDraft) (obj)).price.replaceSelectedValue(formatpricetextfields);
        }
        formatpricetextfields = DeviceConfiguration.getAsync();
        if (shouldTurnOnBestOffer(((ListingDraft) (obj)).bestOfferEnabled, s, formatpricetextfields, prefs, draftListDm.getCurrentUser()))
        {
            ldsrequestparams.values.put("Listing.BestOffer.BestOfferEnabled", String.valueOf(true));
            ((ListingDraft) (obj)).bestOfferEnabled.replaceSelectedValue(String.valueOf(true));
        }
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateFormatPriceTextFields(FormatPriceTextFields formatpricetextfields, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        if (((ListingDraft)content.getData()).format.getStringValue().equals("ChineseAuction"))
        {
            updateAuctionPriceValues(formatpricetextfields, flag);
            return;
        } else
        {
            updateFixedPriceValues(formatpricetextfields, flag);
            return;
        }
    }

    public void updateGuarantee(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        isGuaranteeSelectedThisSession = flag;
        if (!isGuaranteeSelectedThisSession)
        {
            dispatch();
            return;
        }
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FORMAT);
        ListingDraft listingdraft = (ListingDraft)content.getData();
        if (listingdraft.isRecommendedFormatAuction())
        {
            if (!listingdraft.format.getStringValue().equals("ChineseAuction"))
            {
                ldsrequestparams.values.put("Listing.Format", "ChineseAuction");
                listingdraft.format.replaceSelectedValue("ChineseAuction");
            }
            String s = listingdraft.guaranteeStartPrice.getStringValue();
            if (!s.equals(listingdraft.startPrice.getStringValue()))
            {
                ldsrequestparams.values.put("Listing.StartPrice", s);
                listingdraft.startPrice.replaceSelectedValue(s);
            }
            ldsrequestparams.deletedValues.add("Listing.Price");
            listingdraft.price.replaceSelectedValue("");
            ldsrequestparams.deletedValues.add("Listing.AuctionReservePrice");
        }
        String s1 = (new StringBuilder()).append("Days_").append(listingdraft.recommendedDuration.getStringValue()).toString();
        ldsrequestparams.values.put("Listing.Duration", s1);
        listingdraft.duration.replaceSelectedValue(s1);
        ldsrequestparams.deletedValues.add("Listing.ScheduledListing");
        listingdraft.startDateEnabled.replaceSelectedValue(String.valueOf(false));
        listingdraft.startDate.clearSelections();
        executeTask(ldsrequestparams);
        dispatch();
    }

    public void updateHandlingTime(int i)
    {
        NautilusKernel.verifyMain();
        Object obj;
        if (isDraftLoaded())
        {
            if (((ListingDraft) (obj = (ListingDraft)content.getData())).handlingTime.getIntValue() != i)
            {
                prefs.setHandlingTime(draftListDm.getCurrentUser(), String.valueOf(i));
                ((ListingDraft) (obj)).handlingTime.replaceSelectedValue(String.valueOf(i));
                dispatch();
                obj = new LdsRequestParams(ListingDraftOperation.UPDATE_HANDLING_TIME);
                ((LdsRequestParams) (obj)).values.put("Listing.ShippingInfo.HandlingDuration", String.valueOf(i));
                executeTask(((LdsRequestParams) (obj)));
                return;
            }
        }
    }

    public void updateImmediatePay(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            Object obj = (ListingDraft)content.getData();
            ((ListingDraft) (obj)).immediatePay.replaceSelectedValue(String.valueOf(flag));
            disablePaymentUi(((ListingDraft) (obj)));
            dispatch();
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_IMMEDIATE_PAY);
            ((LdsRequestParams) (obj)).values.put("Listing.PaymentInfo.ImmediatePay", String.valueOf(flag));
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void updateIsScheduled(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_START_TIME_DURATION);
        if (flag)
        {
            String s = EbayDateUtils.formatIso8601DateTime(new Date(), getTimeZoneForSite());
            ldsrequestparams.values.put("Listing.StartDate", s);
            listingdraft.startDateEnabled.replaceSelectedValue(String.valueOf(true));
            listingdraft.startDate.replaceSelectedValue(s);
        } else
        {
            ldsrequestparams.deletedValues.add("Listing.ScheduledListing");
            listingdraft.startDateEnabled.replaceSelectedValue(String.valueOf(false));
            listingdraft.startDate.clearSelections();
        }
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateItemSpecificSelections(ArrayList arraylist)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        Object obj = new LdsRequestParams(ListingDraftOperation.UPDATE_ITEM_SPECIFICS);
        Object obj1 = arraylist.iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            LdsField ldsfield = (LdsField)((Iterator) (obj1)).next();
            boolean flag = false;
            Iterator iterator1 = arraylist.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                LdsField ldsfield2 = (LdsField)iterator1.next();
                if (ldsfield.id.equals(ldsfield2.id))
                {
                    flag = true;
                }
            } while (true);
            if (!flag)
            {
                ((LdsRequestParams) (obj)).deletedValues.add(ldsfield.id);
            }
        } while (true);
        obj1 = new ArrayList();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext();)
        {
            LdsField ldsfield1 = (LdsField)iterator.next();
            if (!ldsfield1.hasSelection())
            {
                ((LdsRequestParams) (obj)).deletedValues.add(ldsfield1.id);
                ((ArrayList) (obj1)).add(ldsfield1);
            } else
            {
                ((LdsRequestParams) (obj)).itemSpecifics.add(ldsfield1);
            }
        }

        if ((arraylist.size() + ((LdsRequestParams) (obj)).itemSpecifics.size()) - ((LdsRequestParams) (obj)).deletedValues.size() == 0)
        {
            ((LdsRequestParams) (obj)).deletedValues.add("Listing.Item.ItemSpecific");
        }
        executeTask(((LdsRequestParams) (obj)));
        arraylist.removeAll(((Collection) (obj1)));
        arraylist = new ArrayList(arraylist);
        obj = (ListingDraft)content.getData();
        ((ListingDraft) (obj)).selectedItemSpecifics.clear();
        ((ListingDraft) (obj)).selectedItemSpecifics.addAll(arraylist);
        dispatch();
    }

    public void updateLocationCountry(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            prefs.setItemLocationCountry(draftListDm.getCurrentUser(), s);
            Object obj = (ListingDraft)content.getData();
            ((ListingDraft) (obj)).locationCountry.replaceSelectedValue(s);
            ((ListingDraft) (obj)).locationCountry.setBmode("READ_ONLY");
            ((ListingDraft) (obj)).locationCityState.setBmode("READ_ONLY");
            ((ListingDraft) (obj)).locationPostalCode.setBmode("READ_ONLY");
            dispatch();
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_LOCATION);
            ((LdsRequestParams) (obj)).values.put("Listing.ItemLocation.CountryCode", s);
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void updatePackageDetails(PackageDetailFields packagedetailfields)
    {
        Object obj;
        LdsRequestParams ldsrequestparams;
        ListingDraft listingdraft;
        byte byte0;
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        clearShippingGuidance(false);
        clearShippingEstimates();
        packagedetailfields.dimLengthStr = convertToNumericString(packagedetailfields.dimLengthStr);
        packagedetailfields.dimWidthStr = convertToNumericString(packagedetailfields.dimWidthStr);
        packagedetailfields.dimDepthStr = convertToNumericString(packagedetailfields.dimDepthStr);
        packagedetailfields.packageWeightMajorStr = convertToNumericString(packagedetailfields.packageWeightMajorStr);
        packagedetailfields.packageWeightMinorStr = convertToNumericString(packagedetailfields.packageWeightMinorStr);
        ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_PACKAGE_DETAILS);
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageType", packagedetailfields.packageTypeStr);
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageLength.Value", packagedetailfields.dimLengthStr);
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageWidth.Value", packagedetailfields.dimWidthStr);
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.PackageDepth.Value", packagedetailfields.dimDepthStr);
        ldsrequestparams.values.put("Listing.ShippingInfo.IrregularPackage", String.valueOf(packagedetailfields.irregular));
        listingdraft = (ListingDraft)content.getData();
        listingdraft.packageType.replaceSelectedValue(packagedetailfields.packageTypeStr);
        listingdraft.packageLength.replaceSelectedValue(packagedetailfields.dimLengthStr);
        listingdraft.packageWidth.replaceSelectedValue(packagedetailfields.dimWidthStr);
        listingdraft.packageDepth.replaceSelectedValue(packagedetailfields.dimDepthStr);
        listingdraft.packageIrregular.replaceSelectedValue(String.valueOf(packagedetailfields.irregular));
        obj = packagedetailfields.estimatedWeightStr;
        listingdraft.packageWeightEstimated.replaceSelectedValue(((String) (obj)));
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 2: default 288
    //                   -1573739770: 421
    //                   -478743483: 437;
           goto _L1 _L2 _L3
_L1:
        byte0;
        JVM INSTR tableswitch 0 1: default 312
    //                   0 453
    //                   1 510;
           goto _L4 _L5 _L6
_L4:
        obj = (Pair)LdsConstants.estimatedWeightMap.get(obj);
        packagedetailfields = ((PackageDetailFields) (obj));
        if (obj == null)
        {
            packagedetailfields = new Pair(Integer.valueOf(0), Integer.valueOf(0));
        }
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", String.valueOf(((Pair) (packagedetailfields)).first));
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", String.valueOf(((Pair) (packagedetailfields)).second));
        listingdraft.packageWeightMajor.replaceSelectedValue(String.valueOf(((Pair) (packagedetailfields)).first));
        listingdraft.packageWeightMinor.replaceSelectedValue(String.valueOf(((Pair) (packagedetailfields)).second));
_L7:
        dispatch();
        executeTask(ldsrequestparams);
        return;
_L2:
        if (((String) (obj)).equals("CUSTOM_WEIGHT"))
        {
            byte0 = 0;
        }
          goto _L1
_L3:
        if (((String) (obj)).equals("ONE_LB_OR_LESS"))
        {
            byte0 = 1;
        }
          goto _L1
_L5:
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", packagedetailfields.packageWeightMajorStr);
        ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", packagedetailfields.packageWeightMinorStr);
        listingdraft.packageWeightMajor.replaceSelectedValue(packagedetailfields.packageWeightMajorStr);
        listingdraft.packageWeightMinor.replaceSelectedValue(packagedetailfields.packageWeightMinorStr);
          goto _L7
_L6:
        if ("0".equals(packagedetailfields.packageWeightMinorStr))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", "1");
            ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", "0");
            listingdraft.packageWeightMajor.replaceSelectedValue("1");
            listingdraft.packageWeightMinor.replaceSelectedValue("0");
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MajorWeight.Value", "0");
            ldsrequestparams.values.put("Listing.ShippingInfo.ShippingPackageDetails.MinorWeight.Value", packagedetailfields.packageWeightMinorStr);
            listingdraft.packageWeightMajor.replaceSelectedValue("0");
            listingdraft.packageWeightMinor.replaceSelectedValue(packagedetailfields.packageWeightMinorStr);
        }
          goto _L7
    }

    public void updatePaymentMethods(boolean aflag[])
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_PAYMENT_METHODS);
        String s = "";
        ListingDraft listingdraft = (ListingDraft)content.getData();
        ArrayList arraylist = listingdraft.getModifiablePaymentMethods();
        int i = 0;
        while (i < aflag.length) 
        {
            LdsField ldsfield = (LdsField)arraylist.get(i);
            String s1;
            if (aflag[i])
            {
                s1 = (new StringBuilder()).append(s).append(ldsfield.getIdIndex()).append(":").toString();
            } else
            {
                s1 = s;
                if (listingdraft.paymentMethods.contains(ldsfield))
                {
                    ldsrequestparams.deletedValues.add(ldsfield.id);
                    s1 = s;
                }
            }
            ldsfield.replaceSelectedValue(String.valueOf(aflag[i]));
            i++;
            s = s1;
        }
        ldsrequestparams.values.put("Listing.PaymentInfo.AcceptedPaymentMethod", s);
        prefs.setPaymentMethods(draftListDm.getCurrentUser(), keyParams.draftSite, s);
        disablePaymentUi((ListingDraft)content.getData());
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updatePhotos(String s, ArrayList arraylist)
    {
        NautilusKernel.verifyMain();
        if (isDraftLoaded())
        {
            ListingDraft listingdraft = (ListingDraft)content.getData();
            Object obj = null;
            if (listingdraft.productStockPhoto != null)
            {
                obj = listingdraft.productStockPhoto.getStringValue();
            }
            if (s == null && obj != null)
            {
                updateRemoveStockPhoto();
                return;
            }
            obj = new ArrayList();
            for (s = listingdraft.pictureUrls.iterator(); s.hasNext(); ((ArrayList) (obj)).add(((LdsField)s.next()).getStringValue())) { }
            int i = 0;
            int k = 0;
            do
            {
                if (k >= ((ArrayList) (obj)).size())
                {
                    break;
                }
                s = (String)((ArrayList) (obj)).get(k);
                if (k >= arraylist.size() || !s.equals(arraylist.get(k)))
                {
                    break;
                }
                i = k + 1;
                k++;
            } while (true);
            if (arraylist.size() != ((ArrayList) (obj)).size() || i != ((ArrayList) (obj)).size())
            {
                int k1 = listingdraft.pictureUrls.size();
                s = new LdsRequestParams(ListingDraftOperation.fromOrdinal(ListingDraftOperation.UPDATE_PHOTOS_AFTER_INDEX_0.ordinal() + i));
                for (int l = i; l < ((ArrayList) (obj)).size(); l++)
                {
                    ((LdsRequestParams) (s)).deletedValues.add((new StringBuilder()).append("Listing.Item.Picture[").append(l).append("].url").toString());
                }

                for (int i1 = i; i1 < arraylist.size(); i1++)
                {
                    ((LdsRequestParams) (s)).pictureUrls.add(arraylist.get(i1));
                }

                arraylist = new ArrayList(listingdraft.pictureUrls.subList(0, i));
                listingdraft.pictureUrls.clear();
                listingdraft.pictureUrls.addAll(arraylist);
                for (arraylist = ((LdsRequestParams) (s)).pictureUrls.iterator(); arraylist.hasNext();)
                {
                    String s1 = (String)arraylist.next();
                    LdsField ldsfield = new LdsField();
                    ldsfield.id = (new StringBuilder()).append("Listing.Item.Picture[").append(i).append("].Url").toString();
                    ldsfield.setBmode("ENABLE");
                    ldsfield.addSelectedValue(s1);
                    listingdraft.pictureUrls.add(ldsfield);
                    i++;
                }

                if (listingdraft.pictureMaxRemaining != null)
                {
                    int j = listingdraft.pictureUrls.size();
                    int j1 = listingdraft.pictureMaxRemaining.getIntValue();
                    listingdraft.pictureMaxRemaining.replaceSelectedValue(String.valueOf(j1 - (j - k1)));
                }
                dispatch();
                draftListDm.updateDraft(listingdraft);
                executeTask(s);
                return;
            }
        }
    }

    public void updatePreferenceTextFields(PreferenceTextFields preferencetextfields, boolean flag)
    {
        NautilusKernel.verifyMain();
        if (isDraftLoaded())
        {
            ListingDraft listingdraft = (ListingDraft)content.getData();
            LdsRequestParams ldsrequestparams;
            Object obj;
            String s;
            if (flag)
            {
                ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
                ldsrequestparams.fullValidation = true;
            } else
            {
                ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_PREFERENCE_FREE_TEXT);
            }
            s = preferencetextfields.paypalEmail;
            if (listingdraft.paypalEmailAddress == null)
            {
                obj = null;
            } else
            {
                obj = listingdraft.paypalEmailAddress.getStringValue();
            }
            if ((!TextUtils.isEmpty(s) || !TextUtils.isEmpty(((CharSequence) (obj)))) && s != null && !s.equals(obj))
            {
                prefs.setSellerPaypalEmail(draftListDm.getCurrentUser(), s);
                listingdraft.paypalEmailAddress.replaceSelectedValue(s);
                disablePaymentUi(listingdraft);
                ldsrequestparams.values.put("Listing.PaymentInfo.PaypalEmailAddress", s);
            }
            obj = preferencetextfields.postalCode;
            if (obj != null && !TextUtils.isEmpty(listingdraft.locationPostalCode.getStringValue()) && !((String) (obj)).equals(listingdraft.locationPostalCode.getStringValue()))
            {
                String s1 = listingdraft.locationCountry.getStringValue();
                ldsrequestparams.values.put("Listing.ItemLocation.CountryCode", s1);
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    listingdraft.locationPostalCode.clearSelections();
                    ldsrequestparams.deletedValues.add("Listing.ItemLocation.ZipCode");
                } else
                {
                    listingdraft.locationPostalCode.replaceSelectedValue(((String) (obj)));
                    ldsrequestparams.values.put("Listing.ItemLocation.ZipCode", obj);
                }
                prefs.setItemLocationPostalCode(draftListDm.getCurrentUser(), ((String) (obj)));
            }
            obj = preferencetextfields.cityState;
            if ((!TextUtils.isEmpty(((CharSequence) (obj))) || !TextUtils.isEmpty(listingdraft.locationCityState.getStringValue())) && obj != null && !((String) (obj)).equals(listingdraft.locationCityState.getStringValue()))
            {
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    listingdraft.locationCityState.replaceSelectedValue(((String) (obj)));
                    ldsrequestparams.values.put("Listing.ItemLocation.CityState", obj);
                    prefs.setItemLocationCityState(draftListDm.getCurrentUser(), ((String) (obj)));
                } else
                {
                    listingdraft.locationCityState.clearSelections();
                    ldsrequestparams.deletedValues.add("Listing.ItemLocation.CityState");
                }
            }
            if ("ReturnsAccepted".equals(listingdraft.refundReturnsAccepted.getStringValue()))
            {
                preferencetextfields = preferencetextfields.returnsDetails;
                obj = listingdraft.refundPolicyDetails.getStringValue();
                if (listingdraft.refundPolicyDetails.isEnabled() && (!TextUtils.isEmpty(preferencetextfields) || !TextUtils.isEmpty(((CharSequence) (obj)))) && preferencetextfields != null && !preferencetextfields.equals(obj))
                {
                    prefs.setReturnPolicyAdditionalDetails(draftListDm.getCurrentUser(), preferencetextfields);
                    listingdraft.refundPolicyDetails.replaceSelectedValue(preferencetextfields);
                    ldsrequestparams.values.put("Listing.ReturnPolicy.PolicyDetails", preferencetextfields);
                }
            }
            if (flag)
            {
                dispatch(DispatchType.VALIDATE_ACK);
            } else
            {
                dispatch();
            }
            if (!ldsrequestparams.values.isEmpty() || !ldsrequestparams.deletedValues.isEmpty() || ldsrequestparams.fullValidation)
            {
                executeTask(ldsrequestparams);
                return;
            }
        }
    }

    public void updateRefundMethod(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            Object obj = (ListingDraft)content.getData();
            prefs.setReturnPolicyRefundType(draftListDm.getCurrentUser(), s);
            ((ListingDraft) (obj)).refundMethod.replaceSelectedValue(s);
            disableReturnsUi(((ListingDraft) (obj)));
            dispatch();
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_REFUND_METHOD);
            ((LdsRequestParams) (obj)).values.put("Listing.ReturnPolicy.RefundMethod", s);
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void updateRefundRestockingFee(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            prefs.setReturnPolicyRestockingFee(draftListDm.getCurrentUser(), s);
            ((ListingDraft)content.getData()).refundRestockingFee.replaceSelectedValue(s);
            disableReturnsUi((ListingDraft)content.getData());
            dispatch();
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_RESTOCKING_FEE);
            ldsrequestparams.values.put("Listing.ReturnPolicy.RestockingFeeValue", s);
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateRefundShipmentPayee(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            prefs.setReturnPolicyShippingPaidBy(draftListDm.getCurrentUser(), s);
            ((ListingDraft)content.getData()).refundShipmentPayee.replaceSelectedValue(s);
            disableReturnsUi((ListingDraft)content.getData());
            dispatch();
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_RETURN_SHIPPING_PAID_BY);
            ldsrequestparams.values.put("Listing.ReturnPolicy.RefundShipmentPayee", s);
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateReturnPolicyAccepted(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        String s;
        Object obj;
        if (flag)
        {
            s = "ReturnsAccepted";
        } else
        {
            s = "ReturnsNotAccepted";
        }
        prefs.setReturnPolicy(draftListDm.getCurrentUser(), s);
        obj = (ListingDraft)content.getData();
        ((ListingDraft) (obj)).refundReturnsAccepted.replaceSelectedValue(s);
        disableReturnsUi(((ListingDraft) (obj)));
        dispatch();
        obj = new LdsRequestParams(ListingDraftOperation.UPDATE_RETURNS_ACCEPTED);
        ((LdsRequestParams) (obj)).values.put("Listing.ReturnPolicy.ReturnsAccepted", s);
        executeTask(((LdsRequestParams) (obj)));
    }

    public void updateReturnsWithin(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            Object obj = (ListingDraft)content.getData();
            prefs.setReturnPolicyWithin(draftListDm.getCurrentUser(), s);
            ((ListingDraft) (obj)).refundReturnPeriod.replaceSelectedValue(s);
            disableReturnsUi(((ListingDraft) (obj)));
            dispatch();
            obj = new LdsRequestParams(ListingDraftOperation.UPDATE_RETURN_PERIOD);
            ((LdsRequestParams) (obj)).values.put("Listing.ReturnPolicy.ReturnPeriod", s);
            executeTask(((LdsRequestParams) (obj)));
            return;
        }
    }

    public void updateScheduledStartDate(Date date)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            date = EbayDateUtils.formatIso8601DateTime(date, getTimeZoneForSite());
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_START_TIME_DURATION);
            ldsrequestparams.values.put("Listing.StartDate", date);
            ((ListingDraft)content.getData()).startDate.replaceSelectedValue(date);
            dispatch();
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateShippingDomesticService(String s, String s1, String s2, String s3, String s4)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        ldsrequestparams.values.put(s1, s2);
        if (s.equals("FLAT_RATE"))
        {
            ldsrequestparams.values.put(s3, s4);
        }
        clearShippingGuidance(false);
        listingdraft.getShippingFieldForId(s1).replaceSelectedValue(s2);
        listingdraft.getShippingFieldForId(s3).replaceSelectedValue(s4);
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateShippingDomesticType(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticShippingType", s);
        if (s.equals("ACTUAL_RATE"))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping", Boolean.toString(false));
        }
        if ("NOT_SPECIFIED".equals(listingdraft.shippingType.getStringValue()))
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.HandlingDuration", prefs.getHandlingTime(draftListDm.getCurrentUser()));
        }
        clearShippingEstimates();
        clearShippingGuidance(false);
        listingdraft.shippingType.replaceSelectedValue(s);
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateShippingFree(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].EBayAPISoapServiceCode", listingdraft.shippingService1.getStringValue());
        if (listingdraft.shippingType.getStringValue().equals("FLAT_RATE"))
        {
            if (flag)
            {
                ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].ShippingFee", "0");
                listingdraft.shippingService1fee.replaceSelectedValue("0");
            } else
            {
                ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping", "false");
            }
        } else
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.DomesticItemShippingService[0].FreeShipping", Boolean.toString(flag));
        }
        listingdraft.shippingFree.replaceSelectedValue(String.valueOf(flag));
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateShippingGsp(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        if (listingdraft.globalShipping != null && listingdraft.globalShipping.isEnabled() && listingdraft.globalShipping.getBooleanValue() != flag)
        {
            ldsrequestparams.values.put("Listing.ShippingInfo.GlobalShipping", String.valueOf(flag));
            listingdraft.globalShipping.replaceSelectedValue(String.valueOf(flag));
        }
        dispatch();
        executeTask(ldsrequestparams);
    }

    public void updateShippingIntlService(String s, String s1, String s2, String s3, String s4, String s5, ArrayList arraylist)
    {
        ListingDraft listingdraft;
        LdsRequestParams ldsrequestparams;
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        listingdraft = (ListingDraft)content.getData();
        ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlShippingType", listingdraft.intlShippingType.getStringValue());
        ldsrequestparams.values.put(s1, s2);
        if (s.equals("FLAT_RATE"))
        {
            ldsrequestparams.values.put(s3, s4);
        }
        if (s5 == null || arraylist == null || arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        byte byte0 = -1;
        s5.hashCode();
        JVM INSTR lookupswitch 5: default 184
    //                   -2054689084: 321
    //                   -1819650879: 270
    //                   -701379387: 338
    //                   -466341182: 287
    //                   886968515: 304;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        byte0;
        JVM INSTR tableswitch 0 4: default 220
    //                   0 355
    //                   1 365
    //                   2 375
    //                   3 385
    //                   4 395;
           goto _L2 _L9 _L10 _L11 _L12 _L13
_L2:
        listingdraft.getShippingFieldForId(s1).replaceSelectedValue(s2);
        listingdraft.getShippingFieldForId(s3).replaceSelectedValue(s4);
        if (arraylist != null)
        {
            listingdraft.getShippingFieldForId(s5).replaceSelectedValues(arraylist);
        }
        dispatch();
        executeTask(ldsrequestparams);
        return;
_L5:
        if (s5.equals("Listing.ShippingInfo.IntlItemShippingService[0].ShipToLocation"))
        {
            byte0 = 0;
        }
          goto _L3
_L7:
        if (s5.equals("Listing.ShippingInfo.IntlItemShippingService[1].ShipToLocation"))
        {
            byte0 = 1;
        }
          goto _L3
_L8:
        if (s5.equals("Listing.ShippingInfo.IntlItemShippingService[2].ShipToLocation"))
        {
            byte0 = 2;
        }
          goto _L3
_L4:
        if (s5.equals("Listing.ShippingInfo.IntlItemShippingService[3].ShipToLocation"))
        {
            byte0 = 3;
        }
          goto _L3
_L6:
        if (s5.equals("Listing.ShippingInfo.IntlItemShippingService[4].ShipToLocation"))
        {
            byte0 = 4;
        }
          goto _L3
_L9:
        ldsrequestparams.intlShipLocations1 = arraylist;
          goto _L2
_L10:
        ldsrequestparams.intlShipLocations2 = arraylist;
          goto _L2
_L11:
        ldsrequestparams.intlShipLocations3 = arraylist;
          goto _L2
_L12:
        ldsrequestparams.intlShipLocations4 = arraylist;
          goto _L2
_L13:
        ldsrequestparams.intlShipLocations5 = arraylist;
          goto _L2
    }

    public void updateShippingIntlType(String s)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        ListingDraft listingdraft = (ListingDraft)content.getData();
        LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
        ldsrequestparams.values.put("Listing.ShippingInfo.IntlShippingType", s);
        ldsrequestparams.values.put("Listing.ListingCurrency", listingdraft.getCurrencyCode());
        executeTask(ldsrequestparams);
        if (s != null && s.equals("NOT_SPECIFIED"))
        {
            listingdraft.intlShippingService1.setBmode("DISABLE");
            listingdraft.intlShippingService2.setBmode("DISABLE");
            listingdraft.intlShippingService3.setBmode("DISABLE");
            listingdraft.intlShippingService4.setBmode("DISABLE");
            listingdraft.intlShippingService5.setBmode("DISABLE");
        }
        listingdraft.intlShippingType.replaceSelectedValue(s);
        listingdraft.intlShippingFee1.replaceSelectedValue("0");
        listingdraft.intlShippingFee2.replaceSelectedValue("0");
        listingdraft.intlShippingFee3.replaceSelectedValue("0");
        listingdraft.intlShippingFee4.replaceSelectedValue("0");
        listingdraft.intlShippingFee5.replaceSelectedValue("0");
        dispatch();
    }

    public void updateShippingLocalPickup(boolean flag)
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_SHIPPING);
            ldsrequestparams.values.put("Listing.LocalPickupInfo.LocalPickup", String.valueOf(flag));
            ((ListingDraft)content.getData()).localPickup.replaceSelectedValue(String.valueOf(flag));
            dispatch();
            executeTask(ldsrequestparams);
            return;
        }
    }

    public void updateTitles(String s, String s1, boolean flag)
    {
        boolean flag1 = true;
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        }
        LdsRequestParams ldsrequestparams;
        ListingDraft listingdraft;
        if (flag)
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
        } else
        {
            ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_TITLES);
        }
        listingdraft = (ListingDraft)content.getData();
        addUpdatedDraftValue(listingdraft.title, s, ldsrequestparams);
        if (listingdraft.subtitle != null)
        {
            addUpdatedDraftValue(listingdraft.subtitle, s1, ldsrequestparams);
        }
        if (!ldsrequestparams.values.containsKey("Listing.Item.Title") || !isGuaranteeSelectedThisSession)
        {
            flag1 = false;
        }
        if (flag1)
        {
            isGuaranteeSelectedThisSession = false;
            ldsrequestparams.deletedValues.add("Listing.StartPrice");
        }
        executeTask(ldsrequestparams);
        listingdraft.title.replaceSelectedValue(s);
        if (listingdraft.subtitle != null)
        {
            listingdraft.subtitle.replaceSelectedValue(s1);
        }
        if (flag1 && listingdraft.startPrice != null)
        {
            listingdraft.startPrice.replaceSelectedValue("");
        }
        if (flag)
        {
            dispatch(DispatchType.VALIDATE_ACK);
        } else
        {
            dispatch();
        }
        draftListDm.updateDraft(listingdraft);
    }

    public void validateDraft()
    {
        NautilusKernel.verifyMain();
        if (!isDraftLoaded())
        {
            return;
        } else
        {
            dispatch(DispatchType.VALIDATE_ACK);
            LdsRequestParams ldsrequestparams = new LdsRequestParams(ListingDraftOperation.UPDATE_FOR_REVIEW);
            ldsrequestparams.fullValidation = true;
            executeTask(ldsrequestparams);
            return;
        }
    }
}
