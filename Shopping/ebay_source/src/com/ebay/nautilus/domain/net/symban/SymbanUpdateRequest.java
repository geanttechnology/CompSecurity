// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.data.SymbanNotification;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.symban:
//            SymbanUpdateResponse

public class SymbanUpdateRequest extends EbayCosRequest
{
    public static class Params
    {

        private final EbayCosDateTime lastRetrievalTime;
        private Boolean markAllRead;
        private List notifications;

        public Params addNotification(SymbanNotification symbannotification, com.ebay.nautilus.domain.data.SymbanNotification.StatusEnum statusenum)
        {
            if (notifications == null)
            {
                notifications = new ArrayList(1);
            }
            symbannotification = new UpdateNotification(symbannotification.getNotificationId(), statusenum.name());
            notifications.add(symbannotification);
            return this;
        }

        public Date getDate()
        {
            return lastRetrievalTime.getValue();
        }

        public Boolean isMarkAllRead()
        {
            boolean flag;
            if (markAllRead == null)
            {
                flag = false;
            } else
            {
                flag = markAllRead.booleanValue();
            }
            return Boolean.valueOf(flag);
        }

        public Params setMarkAllRead(boolean flag)
        {
            markAllRead = Boolean.valueOf(flag);
            return this;
        }

        public Params(Date date)
        {
            markAllRead = null;
            lastRetrievalTime = new EbayCosDateTime(date);
        }
    }

    private static class Params.UpdateNotification
    {

        private final String notificationId;
        private final String status;

        public Params.UpdateNotification(String s, String s1)
        {
            notificationId = s;
            status = s1;
        }
    }


    private final Params params;

    public SymbanUpdateRequest(String s, EbayCountry ebaycountry, Params params1)
    {
        super("notificationinbox", "notification", CosVersionType.V2);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
        params = params1;
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
        return ApiSettings.getUrl(ApiSettings.symbanApiUrl);
    }

    public SymbanUpdateResponse getResponse()
    {
        return new SymbanUpdateResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
