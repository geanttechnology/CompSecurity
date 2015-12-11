// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import com.ebay.nautilus.domain.data.ShippingLabelDetails;
import com.ebay.nautilus.domain.data.ShippingLabelDraft;
import com.ebay.nautilus.domain.data.ShippingLabelPackage;
import com.ebay.nautilus.domain.data.ShippingOption;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippinglabel:
//            ShippingLabelBaseRequest, DraftShippingLabelResponse

public class UpdateDraftShippingLabelPackageRequest extends ShippingLabelBaseRequest
{
    public static final class LabelRequestParams
    {

        public com.ebay.nautilus.domain.data.ShippingLabelDraft.AdditionalData additionalData;
        public String customMessage;
        public com.ebay.nautilus.domain.data.ShippingOption.ShippingCostPlan.Cost declaredValue;
        public String format;
        public InsuranceProvider selectedInsuranceOption;
        public ArrayList serviceFeatureValues;
        public String shippingDate;
        public com.ebay.nautilus.domain.data.ShippingOption.ShippingKey shippingKey;
        public String showCustomMessage;
        public String showPostageOnLabel;
        public String size;
        public com.ebay.nautilus.domain.data.ShippingLabelPackage.Specs spec;

        public LabelRequestParams()
        {
        }

        public LabelRequestParams(ShippingLabelDraft shippinglabeldraft, com.ebay.nautilus.domain.data.ShippingOption.ShippingKey shippingkey)
        {
            showPostageOnLabel = Boolean.toString(shippinglabeldraft.labelDetails.printPostageOnLabel);
            if (shippinglabeldraft.labelDetails.shippingOptions != null && shippinglabeldraft.labelDetails.shippingOptions.size() > 0 && ((ShippingOption)shippinglabeldraft.labelDetails.shippingOptions.get(0)).availableShippingDates != null && ((ShippingOption)shippinglabeldraft.labelDetails.shippingOptions.get(0)).availableShippingDates.size() > 0)
            {
                shippingDate = (String)((ShippingOption)shippinglabeldraft.labelDetails.shippingOptions.get(0)).availableShippingDates.get(0);
            }
            additionalData = shippinglabeldraft.additionalData;
            declaredValue = shippinglabeldraft.labelDetails.pkg.declaredValue;
            serviceFeatureValues = shippinglabeldraft.labelDetails.serviceFeatureValues;
            spec = shippinglabeldraft.labelDetails.pkg.spec;
            shippingKey = shippingkey;
            declaredValue = shippinglabeldraft.labelDetails.pkg.declaredValue;
            customMessage = shippinglabeldraft.labelDetails.customMessage;
            showCustomMessage = Boolean.toString(shippinglabeldraft.labelDetails.showCustomMessage);
            selectedInsuranceOption = new InsuranceProvider(shippinglabeldraft.labelDetails.selectedInsuranceCoverage);
        }
    }

    public static class LabelRequestParams.InsuranceProvider
    {

        public String insuranceProvider;

        public LabelRequestParams.InsuranceProvider(String s)
        {
            insuranceProvider = s;
        }
    }


    private static final String PACKAGE = "/package";
    private final String labelId;
    private final LabelRequestParams params;
    private final URL url;

    public UpdateDraftShippingLabelPackageRequest(String s, String s1, LabelRequestParams labelrequestparams, URL url1)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        url = url1;
        labelId = s;
        iafToken = s1;
        params = labelrequestparams;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(params).getBytes();
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        URL url1;
        try
        {
            url1 = new URL(url, (new StringBuilder(getOperationName())).append("/").append(labelId).append("/package").toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException();
        }
        return url1;
    }

    public DraftShippingLabelResponse getResponse()
    {
        return new DraftShippingLabelResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
