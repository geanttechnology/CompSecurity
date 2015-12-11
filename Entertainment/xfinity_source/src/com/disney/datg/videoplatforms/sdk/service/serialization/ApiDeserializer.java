// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.serialization;

import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.AsyncRestTemplate;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.CookieEnabledHttpRequestFactory;
import com.disney.datg.videoplatforms.sdk.service.resttemplate.RestTemplateFactory;
import java.net.URI;
import java.util.concurrent.Future;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

public abstract class ApiDeserializer
{

    protected final Class clazz;
    protected ResponseErrorHandler errorHandler;
    protected HttpMessageConverter messageConverter;
    protected HttpComponentsClientHttpRequestFactory requestFactory;

    public ApiDeserializer(Class class1)
    {
        requestFactory = new CookieEnabledHttpRequestFactory();
        errorHandler = new DefaultResponseErrorHandler();
        messageConverter = new SimpleXmlHttpMessageConverter();
        clazz = class1;
    }

    public ApiDeserializer(HttpMessageConverter httpmessageconverter, Class class1)
    {
        requestFactory = new CookieEnabledHttpRequestFactory();
        errorHandler = new DefaultResponseErrorHandler();
        messageConverter = httpmessageconverter;
        clazz = class1;
    }

    public Future executeAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        if (request.getServiceUri() == null || request.getServiceUri().toString().isEmpty())
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST);
        }
        if (i != -1)
        {
            requestFactory.setReadTimeout(i);
        }
        return RestTemplateFactory.createAsyncRestTemplate(requestFactory, messageConverter).exchange(request, httprequesthandler);
    }

    public Future getForObjectAsync(Request request, int i, HttpRequestHandler httprequesthandler)
        throws AndroidSDKException
    {
        if (request.getServiceUri() == null || request.getServiceUri().toString().isEmpty())
        {
            throw new AndroidSDKException(ErrorCode.ANDROID_SDK_SERVICE_UNDEFINED_HOST);
        }
        if (i != -1)
        {
            requestFactory.setReadTimeout(i);
        }
        return RestTemplateFactory.createAsyncRestTemplate(requestFactory, messageConverter).getForObject(request, httprequesthandler);
    }
}
