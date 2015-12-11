// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;

import com.ebay.nautilus.domain.data.cos.base.DateTime;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;
import java.util.List;

public class EventDetailsResponse extends EbayCosResponse
{
    public static class EventDetails
    {

        public boolean active;
        public DateTime endingDate;
        public String eventId;
        public String name;
        public List properties;
        public DateTime startingDate;
        public String url;

        public EventDetails()
        {
        }
    }

    public static class Response
    {

        public List events;

        public Response()
        {
        }
    }


    public Response response;

    protected EventDetailsResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        response = (Response)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/events/EventDetailsResponse$Response);
    }
}
