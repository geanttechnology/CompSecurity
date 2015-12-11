// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.util.ClassUtil;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceException;
import com.amazon.searchapp.retailsearch.model.LocationResults;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, LocationListener, RetailSearchClient

public class LocationServiceCall extends RetailSearchServiceCall
{
    public static interface ResponseParser
    {

        public abstract LocationResults parse(InputStream inputstream, LocationListener locationlistener)
            throws IOException;
    }


    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/LocationServiceCall.getPackage().getName()).append(".jackson.LocationParser").toString();
    private static volatile ResponseParser parser;
    private String dataSet;

    public LocationServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/location", com/amazon/searchapp/retailsearch/model/LocationResults);
        dataSet = s;
    }

    private ResponseParser getParser()
    {
        this;
        JVM INSTR monitorenter ;
        ResponseParser responseparser;
        if (parser == null)
        {
            parser = (ResponseParser)ClassUtil.createInstance(PARSER_CLASS);
        }
        responseparser = parser;
        this;
        JVM INSTR monitorexit ;
        return responseparser;
        Exception exception;
        exception;
        throw exception;
    }

    protected void buildParameters(CollectionMap collectionmap)
        throws ServiceException
    {
        if (dataSet != null)
        {
            collectionmap.set("dataset", dataSet);
        }
        super.buildParameters(collectionmap);
    }

    protected LocationListener getListener()
    {
        return (LocationListener)super.getListener();
    }

    protected volatile ServiceCallListener getListener()
    {
        return getListener();
    }

    protected LocationResults readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        if (inputstream != null)
        {
            return getParser().parse(inputstream, getListener());
        } else
        {
            return null;
        }
    }

    protected volatile Object readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        return readResponse(i, s, inputstream);
    }

}
