// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.cart:
//            JsonModel, IncentiveType

public class Incentive extends JsonModel
    implements Serializable
{
    public static final class Campaign extends IncentiveType
        implements Serializable
    {

        public final String FAQUrl;
        public final String adjacencyId;
        public final CurrencyAmount budgetAmount;
        public final Date campaignCreationTime;
        public final Date campaignDeletionTime;
        public final CurrencyAmount campaignDiscountAmount;
        public final Double campaignDiscountPercent;
        public final String campaignDiscountType;
        public final Date campaignExpirationTime;
        public final String campaignId;
        public final Date campaignLastModifiedTime;
        public final CurrencyAmount campaignMaxPurchaseAmount;
        public final CurrencyAmount campaignMinPurchaseAmount;
        public final Date campaignStartTime;
        public final String campaignStatus;
        public final String campaignValueType;
        public final String categoryFlag;
        public final List categoryIdList = new ArrayList();
        public final String country;
        public final String currency;
        public final String displayMsg;
        public final String externalId;
        public final String incentiveApplicationType;
        public final String language;
        public final Integer maxUsageCount;
        public final String programCode;
        public final CurrencyAmount redeemedTotalAmount;
        public final Long redeemedTotalCount;
        public final List sellerIdList = new ArrayList();

        public boolean isActive()
        {
            return !TextUtils.isEmpty(campaignStatus) && campaignStatus.equalsIgnoreCase("active");
        }

        public Campaign(JSONObject jsonobject)
            throws JSONException
        {
            super(JsonModel.getString(jsonobject, "incentiveType"));
            country = JsonModel.getString(jsonobject, "country");
            adjacencyId = JsonModel.getString(jsonobject, "adjacencyId");
            programCode = JsonModel.getString(jsonobject, "programCode");
            externalId = JsonModel.getString(jsonobject, "externalId");
            displayMsg = JsonModel.getString(jsonobject, "displayMessage");
            language = JsonModel.getString(jsonobject, "language");
            FAQUrl = JsonModel.getString(jsonobject, "FAQURL");
            campaignStatus = JsonModel.getString(jsonobject, "campaignStatus");
            campaignStartTime = JsonModel.getDate(jsonobject, "campaignStartTime");
            campaignExpirationTime = JsonModel.getDate(jsonobject, "campaignExpirationTime");
            budgetAmount = JsonModel.getCurrencyAmount(jsonobject, "budgetAmount");
            redeemedTotalAmount = JsonModel.getCurrencyAmount(jsonobject, "redeemedTotalAmount");
            redeemedTotalCount = JsonModel.getLong(jsonobject, "redeemedTotalCount");
            currency = JsonModel.getString(jsonobject, "currency");
            maxUsageCount = JsonModel.getInteger(jsonobject, "maxUsageCount");
            campaignId = JsonModel.getString(jsonobject, "campaignId");
            campaignCreationTime = JsonModel.getDate(jsonobject, "campaignCreationTime");
            campaignLastModifiedTime = JsonModel.getDate(jsonobject, "campaignLastModifiedTime");
            campaignDeletionTime = JsonModel.getDate(jsonobject, "campaignDeletionTime");
            campaignDiscountType = JsonModel.getString(jsonobject, "campaignDiscountType");
            campaignDiscountPercent = JsonModel.getDouble(jsonobject, "campaignDiscountPercent");
            campaignDiscountAmount = JsonModel.getCurrencyAmount(jsonobject, "campaignDiscountAmount");
            campaignValueType = JsonModel.getString(jsonobject, "campaignValueType");
            campaignMinPurchaseAmount = JsonModel.getCurrencyAmount(jsonobject, "campaignMinPurchaseAmount");
            campaignMaxPurchaseAmount = JsonModel.getCurrencyAmount(jsonobject, "campaignMaxPurchaseAmount");
            if (jsonobject.has("categoryIdList"))
            {
                JSONArray jsonarray = jsonobject.optJSONArray("categoryIdList");
                if (jsonarray != null)
                {
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        categoryIdList.add(JsonModel.getString(jsonarray.getJSONObject(i), "categoryId"));
                    }

                }
            }
            categoryFlag = JsonModel.getString(jsonobject, "categoryFlag");
            incentiveApplicationType = JsonModel.getString(jsonobject, "incentiveApplicationType");
            if (jsonobject.has("sellerIdList"))
            {
                jsonobject = jsonobject.optJSONArray("categoryIdList");
                if (jsonobject != null)
                {
                    for (int j = 0; j < jsonobject.length(); j++)
                    {
                        sellerIdList.add(JsonModel.getString(jsonobject.getJSONObject(j), "sellerId"));
                    }

                }
            }
        }
    }


    public final CurrencyAmount appliedDiscountAmount;
    public final Campaign campaign;
    public final String campaignId;
    public final String countryCode;
    public final Date creationTime;
    public final String currencyCode;
    public final Date deletionTime;
    public final CurrencyAmount discountAmount;
    public final Integer discountPercent;
    public final String discountType;
    public final String displayMsg;
    public final Date expiration;
    public final String id;
    public final String incentiveType;
    public final Date lastModifiedTime;
    public final CurrencyAmount maxPurchaseAmount;
    public final Integer maxUseCount;
    public final CurrencyAmount minPurchaseAmount;
    public final CurrencyAmount originalDiscountAmount;
    public final String redemptionCode;
    public final String status;
    public final Integer useCount;
    public final String userId;

    public Incentive(JSONObject jsonobject)
        throws JSONException
    {
        id = getString(jsonobject, "incentiveId");
        campaignId = getString(jsonobject, "campaignId");
        userId = getString(jsonobject, "userId");
        status = getString(jsonobject, "status");
        expiration = getDate(jsonobject, "incentiveExpirationTime");
        useCount = getInteger(jsonobject, "userUsedCount");
        maxUseCount = getInteger(jsonobject, "userMaxUsageAmount");
        redemptionCode = getString(jsonobject, "redemptionCode");
        currencyCode = getString(jsonobject, "isoCurrencyCode");
        countryCode = getString(jsonobject, "isoCountryCode");
        discountPercent = getInteger(jsonobject, "incentiveDiscountPercent");
        discountAmount = getCurrencyAmount(jsonobject, "incentiveDiscountAmount");
        discountType = getString(jsonobject, "incentiveDiscountType");
        minPurchaseAmount = getCurrencyAmount(jsonobject, "incentiveMinPurchaseAmount");
        maxPurchaseAmount = getCurrencyAmount(jsonobject, "incentiveMaxPurchaseAmount");
        appliedDiscountAmount = getCurrencyAmount(jsonobject, "incentiveAppliedDiscountAmount");
        displayMsg = getString(jsonobject, "displayMessage");
        creationTime = getDate(jsonobject, "incentiveCreationTime");
        lastModifiedTime = getDate(jsonobject, "incentiveLastModifiedTime");
        deletionTime = getDate(jsonobject, "incentiveDeletionTime");
        originalDiscountAmount = getCurrencyAmount(jsonobject, "originalDiscountAmount");
        if (jsonobject.has("parentCampaign"))
        {
            campaign = new Campaign(jsonobject.getJSONObject("parentCampaign"));
            incentiveType = campaign.type;
            return;
        } else
        {
            campaign = null;
            incentiveType = "voucher";
            return;
        }
    }

    public static final String obfuscateIncentiveCode(String s)
    {
        return (new StringBuilder()).append("x-").append(s.substring(s.length() - 4)).toString();
    }

    public boolean isVoucher()
    {
        if (campaign != null)
        {
            return campaign.isVoucher();
        } else
        {
            return "voucher".equals(incentiveType);
        }
    }
}
