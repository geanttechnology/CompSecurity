// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.InterceptingHttpAccessor;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.feed.SyndFeedHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.http.converter.xml.XmlAwareFormHttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

// Referenced classes of package org.springframework.web.client:
//            DefaultResponseErrorHandler, ResponseErrorHandler, RestClientException, RequestCallback, 
//            ResponseExtractor, ResourceAccessException, HttpMessageConverterExtractor

public class RestTemplate extends InterceptingHttpAccessor
{
    private class AcceptHeaderRequestCallback
        implements RequestCallback
    {

        private final Class responseType;
        final RestTemplate this$0;

        public void doWithRequest(ClientHttpRequest clienthttprequest)
            throws IOException
        {
            if (responseType != null)
            {
                ArrayList arraylist = new ArrayList();
                Iterator iterator = getMessageConverters().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
                    if (httpmessageconverter.canRead(responseType, null))
                    {
                        Iterator iterator1 = httpmessageconverter.getSupportedMediaTypes().iterator();
                        while (iterator1.hasNext()) 
                        {
                            MediaType mediatype1 = (MediaType)iterator1.next();
                            MediaType mediatype = mediatype1;
                            if (mediatype1.getCharSet() != null)
                            {
                                mediatype = new MediaType(mediatype1.getType(), mediatype1.getSubtype());
                            }
                            arraylist.add(mediatype);
                        }
                    }
                } while (true);
                if (!arraylist.isEmpty())
                {
                    MediaType.sortBySpecificity(arraylist);
                    if (Log.isLoggable("RestTemplate", 3))
                    {
                        Log.d("RestTemplate", (new StringBuilder()).append("Setting request Accept header to ").append(arraylist).toString());
                    }
                    clienthttprequest.getHeaders().setAccept(arraylist);
                }
            }
        }

        private AcceptHeaderRequestCallback(Class class1)
        {
            this$0 = RestTemplate.this;
            super();
            responseType = class1;
        }

    }

    private static class DefaultMessageConverters
    {

        private static final boolean jacksonPresent;
        private static final boolean javaxXmlTransformPresent = ClassUtils.isPresent("javax.xml.transform.Source", org/springframework/web/client/RestTemplate.getClassLoader());
        private static final boolean romePresent = ClassUtils.isPresent("com.google.code.rome.android.repackaged.com.sun.syndication.feed.synd.SyndFeed", org/springframework/web/client/RestTemplate.getClassLoader());
        private static final boolean simpleXmlPresent = ClassUtils.isPresent("org.simpleframework.xml.Serializer", org/springframework/web/client/RestTemplate.getClassLoader());

        public static void init(List list)
        {
            list.add(new ByteArrayHttpMessageConverter());
            list.add(new StringHttpMessageConverter());
            list.add(new ResourceHttpMessageConverter());
            if (javaxXmlTransformPresent)
            {
                list.add(new SourceHttpMessageConverter());
                list.add(new XmlAwareFormHttpMessageConverter());
            } else
            {
                list.add(new FormHttpMessageConverter());
            }
            if (simpleXmlPresent)
            {
                list.add(new SimpleXmlHttpMessageConverter());
            }
            if (jacksonPresent)
            {
                list.add(new MappingJacksonHttpMessageConverter());
            }
            if (romePresent)
            {
                list.add(new SyndFeedHttpMessageConverter());
            }
        }

        static 
        {
            boolean flag;
            if (ClassUtils.isPresent("org.codehaus.jackson.map.ObjectMapper", org/springframework/web/client/RestTemplate.getClassLoader()) && ClassUtils.isPresent("org.codehaus.jackson.JsonGenerator", org/springframework/web/client/RestTemplate.getClassLoader()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            jacksonPresent = flag;
        }
    }

    private static class HeadersExtractor
        implements ResponseExtractor
    {

        public volatile Object extractData(ClientHttpResponse clienthttpresponse)
            throws IOException
        {
            return extractData(clienthttpresponse);
        }

        public HttpHeaders extractData(ClientHttpResponse clienthttpresponse)
            throws IOException
        {
            return clienthttpresponse.getHeaders();
        }

        private HeadersExtractor()
        {
        }

    }

    private class HttpEntityRequestCallback extends AcceptHeaderRequestCallback
    {

        private final HttpEntity requestEntity;
        final RestTemplate this$0;

        public void doWithRequest(ClientHttpRequest clienthttprequest)
            throws IOException
        {
            super.doWithRequest(clienthttprequest);
            if (!requestEntity.hasBody())
            {
                clienthttprequest = clienthttprequest.getHeaders();
                HttpHeaders httpheaders = requestEntity.getHeaders();
                if (!httpheaders.isEmpty())
                {
                    clienthttprequest.putAll(httpheaders);
                }
                if (clienthttprequest.getContentLength() == -1L)
                {
                    clienthttprequest.setContentLength(0L);
                }
                return;
            }
            Object obj = requestEntity.getBody();
            Class class1 = obj.getClass();
            HttpHeaders httpheaders1 = requestEntity.getHeaders();
            MediaType mediatype = httpheaders1.getContentType();
            for (Iterator iterator = getMessageConverters().iterator(); iterator.hasNext();)
            {
                HttpMessageConverter httpmessageconverter = (HttpMessageConverter)iterator.next();
                if (httpmessageconverter.canWrite(class1, mediatype))
                {
                    if (!httpheaders1.isEmpty())
                    {
                        clienthttprequest.getHeaders().putAll(httpheaders1);
                    }
                    if (Log.isLoggable("RestTemplate", 3))
                    {
                        if (mediatype != null)
                        {
                            Log.d("RestTemplate", (new StringBuilder()).append("Writing [").append(obj).append("] as \"").append(mediatype).append("\" using [").append(httpmessageconverter).append("]").toString());
                        } else
                        {
                            Log.d("RestTemplate", (new StringBuilder()).append("Writing [").append(obj).append("] using [").append(httpmessageconverter).append("]").toString());
                        }
                    }
                    httpmessageconverter.write(obj, mediatype, clienthttprequest);
                    return;
                }
            }

            obj = (new StringBuilder()).append("Could not write request: no suitable HttpMessageConverter found for request type [").append(class1.getName()).append("]").toString();
            clienthttprequest = ((ClientHttpRequest) (obj));
            if (mediatype != null)
            {
                clienthttprequest = (new StringBuilder()).append(((String) (obj))).append(" and content type [").append(mediatype).append("]").toString();
            }
            throw new RestClientException(clienthttprequest);
        }

        private HttpEntityRequestCallback(Object obj, Class class1)
        {
            this$0 = RestTemplate.this;
            super(class1);
            if (obj instanceof HttpEntity)
            {
                requestEntity = (HttpEntity)obj;
                return;
            }
            if (obj != null)
            {
                requestEntity = new HttpEntity(obj);
                return;
            } else
            {
                requestEntity = HttpEntity.EMPTY;
                return;
            }
        }

    }

    private class ResponseEntityResponseExtractor
        implements ResponseExtractor
    {

        private final HttpMessageConverterExtractor _flddelegate;
        final RestTemplate this$0;

        public volatile Object extractData(ClientHttpResponse clienthttpresponse)
            throws IOException
        {
            return extractData(clienthttpresponse);
        }

        public ResponseEntity extractData(ClientHttpResponse clienthttpresponse)
            throws IOException
        {
            if (_flddelegate != null)
            {
                return new ResponseEntity(_flddelegate.extractData(clienthttpresponse), clienthttpresponse.getHeaders(), clienthttpresponse.getStatusCode());
            } else
            {
                return new ResponseEntity(clienthttpresponse.getHeaders(), clienthttpresponse.getStatusCode());
            }
        }

        public ResponseEntityResponseExtractor(Class class1)
        {
            this$0 = RestTemplate.this;
            super();
            if (class1 != null && !java/lang/Void.equals(class1))
            {
                _flddelegate = new HttpMessageConverterExtractor(class1, getMessageConverters());
                return;
            } else
            {
                _flddelegate = null;
                return;
            }
        }
    }


    private ResponseErrorHandler errorHandler;
    private final ResponseExtractor headersExtractor;
    private List messageConverters;

    public RestTemplate()
    {
        this(false);
    }

    public RestTemplate(ClientHttpRequestFactory clienthttprequestfactory)
    {
        this(false, clienthttprequestfactory);
    }

    public RestTemplate(boolean flag)
    {
        headersExtractor = new HeadersExtractor();
        messageConverters = new ArrayList();
        errorHandler = new DefaultResponseErrorHandler();
        if (flag)
        {
            DefaultMessageConverters.init(messageConverters);
        }
    }

    public RestTemplate(boolean flag, ClientHttpRequestFactory clienthttprequestfactory)
    {
        this(flag);
        setRequestFactory(clienthttprequestfactory);
    }

    private void handleResponseError(HttpMethod httpmethod, URI uri, ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        if (Log.isLoggable("RestTemplate", 3))
        {
            try
            {
                Log.d("RestTemplate", (new StringBuilder()).append(httpmethod.name()).append(" request for \"").append(uri).append("\" resulted in ").append(clienthttpresponse.getStatusCode()).append(" (").append(clienthttpresponse.getStatusText()).append("); invoking error handler").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpMethod httpmethod) { }
        }
        getErrorHandler().handleError(clienthttpresponse);
    }

    private void logResponseStatus(HttpMethod httpmethod, URI uri, ClientHttpResponse clienthttpresponse)
    {
        if (!Log.isLoggable("RestTemplate", 3))
        {
            break MISSING_BLOCK_LABEL_74;
        }
        Log.d("RestTemplate", (new StringBuilder()).append(httpmethod.name()).append(" request for \"").append(uri).append("\" resulted in ").append(clienthttpresponse.getStatusCode()).append(" (").append(clienthttpresponse.getStatusText()).append(")").toString());
        return;
        httpmethod;
    }

    protected Object doExecute(URI uri, HttpMethod httpmethod, RequestCallback requestcallback, ResponseExtractor responseextractor)
        throws RestClientException
    {
        RequestCallback requestcallback1;
        RequestCallback requestcallback2;
        Object obj;
        Object obj1;
        Assert.notNull(uri, "'url' must not be null");
        Assert.notNull(httpmethod, "'method' must not be null");
        obj1 = null;
        obj = null;
        requestcallback2 = obj;
        requestcallback1 = obj1;
        ClientHttpRequest clienthttprequest = createRequest(uri, httpmethod);
        if (requestcallback == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        requestcallback2 = obj;
        requestcallback1 = obj1;
        requestcallback.doWithRequest(clienthttprequest);
        requestcallback2 = obj;
        requestcallback1 = obj1;
        requestcallback = clienthttprequest.execute();
        requestcallback2 = requestcallback;
        requestcallback1 = requestcallback;
        if (getErrorHandler().hasError(requestcallback)) goto _L2; else goto _L1
_L1:
        requestcallback2 = requestcallback;
        requestcallback1 = requestcallback;
        logResponseStatus(httpmethod, uri, requestcallback);
_L8:
        if (responseextractor == null) goto _L4; else goto _L3
_L3:
        requestcallback2 = requestcallback;
        requestcallback1 = requestcallback;
        uri = ((URI) (responseextractor.extractData(requestcallback)));
        httpmethod = uri;
        if (requestcallback != null)
        {
            requestcallback.close();
            httpmethod = uri;
        }
_L6:
        return httpmethod;
_L2:
        requestcallback2 = requestcallback;
        requestcallback1 = requestcallback;
        try
        {
            handleResponseError(httpmethod, uri, requestcallback);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            requestcallback1 = requestcallback2;
        }
        finally
        {
            if (requestcallback1 != null)
            {
                requestcallback1.close();
            }
            throw uri;
        }
        throw new ResourceAccessException((new StringBuilder()).append("I/O error: ").append(uri.getMessage()).toString(), uri);
_L4:
        httpmethod = null;
        if (requestcallback == null) goto _L6; else goto _L5
_L5:
        requestcallback.close();
        return null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public ResponseEntity exchange(URI uri, HttpMethod httpmethod, HttpEntity httpentity, Class class1)
        throws RestClientException
    {
        return (ResponseEntity)execute(uri, httpmethod, new HttpEntityRequestCallback(httpentity, class1), new ResponseEntityResponseExtractor(class1));
    }

    public Object execute(URI uri, HttpMethod httpmethod, RequestCallback requestcallback, ResponseExtractor responseextractor)
        throws RestClientException
    {
        return doExecute(uri, httpmethod, requestcallback, responseextractor);
    }

    public ResponseErrorHandler getErrorHandler()
    {
        return errorHandler;
    }

    public Object getForObject(URI uri, Class class1)
        throws RestClientException
    {
        AcceptHeaderRequestCallback acceptheaderrequestcallback = new AcceptHeaderRequestCallback(class1);
        class1 = new HttpMessageConverterExtractor(class1, getMessageConverters());
        return execute(uri, HttpMethod.GET, acceptheaderrequestcallback, class1);
    }

    public List getMessageConverters()
    {
        return messageConverters;
    }
}
