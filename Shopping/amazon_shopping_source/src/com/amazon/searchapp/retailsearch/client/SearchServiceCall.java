// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.util.ClassUtil;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.UrlMaker;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, SearchRequest, DeviceInformation, DeviceInfoParameter, 
//            SearchParameterName, SearchListener, RetailSearchClient

public class SearchServiceCall extends RetailSearchServiceCall
{
    public static interface ResponseParser
    {

        public abstract SearchResult parse(InputStream inputstream, SearchListener searchlistener)
            throws IOException;
    }


    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/SearchServiceCall.getPackage().getName()).append(".jackson.SearchParser").toString();
    private static volatile ResponseParser defaultParser;
    private UrlMaker dataUrl;
    private final ResponseParser parser;
    private final SearchRequest request;

    public SearchServiceCall(RetailSearchClient retailsearchclient, SearchRequest searchrequest, SearchListener searchlistener, ResponseParser responseparser)
    {
        super(retailsearchclient, searchlistener, HttpMethod.GET.getName(), "/s", com/amazon/searchapp/retailsearch/model/SearchResult);
        request = searchrequest;
        parser = responseparser;
    }

    private void addDeviceInformation(CollectionMap collectionmap)
    {
        DeviceInformation deviceinformation = request.getDeviceInformation();
        if (deviceinformation != null)
        {
            if (deviceinformation.getCarrier() != null)
            {
                collectionmap.set(DeviceInfoParameter.CARRIER.getName(), deviceinformation.getCarrier());
            }
            if (deviceinformation.getManufacturer() != null)
            {
                collectionmap.set(DeviceInfoParameter.MANUFACTURER.getName(), deviceinformation.getManufacturer());
            }
            if (deviceinformation.getModel() != null)
            {
                collectionmap.set(DeviceInfoParameter.MODEL.getName(), deviceinformation.getModel());
            }
            if (deviceinformation.getDeviceType() != null)
            {
                collectionmap.set(DeviceInfoParameter.DEVICE_TYPE.getName(), deviceinformation.getDeviceType());
            }
            if (deviceinformation.getDeviceDescriptorId() != null)
            {
                collectionmap.set(DeviceInfoParameter.DEVICE_DESCRIPTOR_ID.getName(), deviceinformation.getDeviceDescriptorId());
            }
            if (deviceinformation.getOsVersion() != null)
            {
                collectionmap.set(DeviceInfoParameter.OS_VERSION.getName(), deviceinformation.getOsVersion());
            }
            if (deviceinformation.getRef() != null)
            {
                collectionmap.set(DeviceInfoParameter.REF.getName(), deviceinformation.getRef());
            }
            if (deviceinformation.getDeviceDensityClassification() != null)
            {
                collectionmap.set(DeviceInfoParameter.DEVICE_DENSITY_CLASSIFICATION.getName(), deviceinformation.getDeviceDensityClassification());
            }
            if (deviceinformation.getDeviceScreenLayout() != null)
            {
                collectionmap.set(DeviceInfoParameter.DEVICE_SCREEN_LAYOUT.getName(), deviceinformation.getDeviceScreenLayout());
            }
            if (deviceinformation.getSerial() != null)
            {
                collectionmap.set(DeviceInfoParameter.SERIAL.getName(), deviceinformation.getSerial());
            }
            if (deviceinformation.getBuildProduct() != null)
            {
                collectionmap.set(DeviceInfoParameter.BUILD_PRODUCT.getName(), deviceinformation.getBuildProduct());
            }
            if (deviceinformation.getBuildFingerprint() != null)
            {
                collectionmap.set(DeviceInfoParameter.BUILD_FINGERPRINT.getName(), deviceinformation.getBuildFingerprint());
            }
            if (deviceinformation.getSimOperator() != null)
            {
                collectionmap.set(DeviceInfoParameter.SIM_OPERATOR.getName(), deviceinformation.getSimOperator());
            }
            if (deviceinformation.getPhoneType() != null)
            {
                collectionmap.set(DeviceInfoParameter.PHONE_TYPE.getName(), deviceinformation.getPhoneType());
                return;
            }
        }
    }

    private String addRefTag(String s)
    {
        if (request.getRefTag() == null)
        {
            return s;
        }
        if (s != null)
        {
            s = new StringBuilder(s);
        } else
        {
            s = new StringBuilder();
        }
        s.append("ref").append('=').append(request.getRefTag());
        return s.toString();
    }

    private ResponseParser getDefaultParser()
    {
        this;
        JVM INSTR monitorenter ;
        ResponseParser responseparser;
        if (defaultParser == null)
        {
            defaultParser = (ResponseParser)ClassUtil.createInstance(PARSER_CLASS);
        }
        responseparser = defaultParser;
        this;
        JVM INSTR monitorexit ;
        return responseparser;
        Exception exception;
        exception;
        throw exception;
    }

    private ResponseParser getParser()
    {
        if (parser != null)
        {
            return parser;
        } else
        {
            return getDefaultParser();
        }
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        if (dataUrl != null)
        {
            collectionmap.set(dataUrl.getQuery());
        }
        if (request.getDataSet() != null)
        {
            collectionmap.set(SearchParameterName.DATA_SET.getName(), request.getDataSet());
        }
        if (request.getAlias() != null)
        {
            collectionmap.set(SearchParameterName.ALIAS.getName(), request.getAlias());
        }
        if (request.getMerchant() != null)
        {
            collectionmap.set(SearchParameterName.MERCHANT.getName(), request.getMerchant());
        }
        if (request.getKeywords() != null)
        {
            collectionmap.set(SearchParameterName.KEYWORDS.getName(), request.getKeywords());
        }
        if (request.getSort() != null)
        {
            collectionmap.set(SearchParameterName.SORT.getName(), request.getSort());
        }
        if (request.getRefinements() != null)
        {
            collectionmap.set(SearchParameterName.REFINEMENT_HISTORY.getName(), request.getRefinements());
        }
        if (request.getPage() != 0)
        {
            collectionmap.set(SearchParameterName.PAGE.getName(), String.valueOf(request.getPage()));
        }
        if (request.getPageSize() >= 0)
        {
            collectionmap.set(SearchParameterName.MAX_RESULTS.getName(), String.valueOf(request.getPageSize()));
        }
        if (request.getImageResolution() != null)
        {
            collectionmap.set(SearchParameterName.IMAGE_RESOLUTION.getName(), String.valueOf(request.getImageResolution()));
        }
        if (request.getImageCrop())
        {
            collectionmap.set(SearchParameterName.IMAGE_CROP.getName(), String.valueOf(request.getImageCrop()));
        }
        if (request.getSearchMethod() != null)
        {
            collectionmap.set(SearchParameterName.SEARCH_METHOD.getName(), request.getSearchMethod());
        }
        if (request.getParameters() != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = request.getParameters().entrySet().iterator(); iterator.hasNext(); collectionmap.set(entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        addDeviceInformation(collectionmap);
        super.buildParameters(collectionmap);
    }

    protected String buildPath()
    {
        String s;
        if (dataUrl != null)
        {
            s = dataUrl.getPath();
        } else
        {
            s = getDefaultPath();
        }
        return addRefTag(s);
    }

    protected void buildServiceCall()
        throws IOException
    {
        if (request.getDataUrl() != null)
        {
            try
            {
                dataUrl = new UrlMaker(request.getDataUrl());
            }
            catch (URISyntaxException urisyntaxexception)
            {
                throw new IOException(urisyntaxexception);
            }
        }
        super.buildServiceCall();
    }

    protected SearchListener getListener()
    {
        return (SearchListener)super.getListener();
    }

    protected volatile ServiceCallListener getListener()
    {
        return getListener();
    }

    protected SearchResult readResponse(int i, String s, InputStream inputstream)
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
