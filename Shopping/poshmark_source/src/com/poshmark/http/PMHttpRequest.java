// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http;

import com.poshmark.http.httpCore.PMHttpExecutor;
import com.poshmark.utils.view_holders.MultiMap;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.poshmark.http:
//            PMBaseHttpResponseHandler, PMHttpResponseHandler

public class PMHttpRequest
{
    public static final class REQUEST_TYPE extends Enum
    {

        private static final REQUEST_TYPE $VALUES[];
        public static final REQUEST_TYPE HTTP_DELETE;
        public static final REQUEST_TYPE HTTP_GET;
        public static final REQUEST_TYPE HTTP_POST;
        public static final REQUEST_TYPE HTTP_PUT;

        public static REQUEST_TYPE valueOf(String s)
        {
            return (REQUEST_TYPE)Enum.valueOf(com/poshmark/http/PMHttpRequest$REQUEST_TYPE, s);
        }

        public static REQUEST_TYPE[] values()
        {
            return (REQUEST_TYPE[])$VALUES.clone();
        }

        static 
        {
            HTTP_GET = new REQUEST_TYPE("HTTP_GET", 0);
            HTTP_POST = new REQUEST_TYPE("HTTP_POST", 1);
            HTTP_PUT = new REQUEST_TYPE("HTTP_PUT", 2);
            HTTP_DELETE = new REQUEST_TYPE("HTTP_DELETE", 3);
            $VALUES = (new REQUEST_TYPE[] {
                HTTP_GET, HTTP_POST, HTTP_PUT, HTTP_DELETE
            });
        }

        private REQUEST_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int DEFAULT_POST_TIMEOUT_MILLISECONDS = 45000;
    public static final int DEFAULT_TIMEOUT_MILLISECONDS = 20000;
    public static final int USE_DEFAULT_TIMEOUT = -1;
    public final Map formData = new MultiMap();
    public final Map headers = new HashMap();
    public final Map multipartData = new HashMap();
    public final MultiMap nestedFormData = new MultiMap();
    public final Map queryParams = new HashMap();
    public final REQUEST_TYPE requestType;
    public PMBaseHttpResponseHandler responseHandler;
    public int timeoutMilliSeconds;
    public final String url;

    public PMHttpRequest(REQUEST_TYPE request_type, String s)
    {
        int i = -1;
        super();
        timeoutMilliSeconds = -1;
        requestType = request_type;
        url = s;
        if (request_type != REQUEST_TYPE.HTTP_GET)
        {
            i = 45000;
        }
        timeoutMilliSeconds = i;
        headers.put("Accept", "*/*");
        headers.put("Accept-Language", "en-us");
    }

    public void execute(PMHttpResponseHandler pmhttpresponsehandler)
    {
        responseHandler = pmhttpresponsehandler;
        (new PMHttpExecutor(this)).execute();
    }
}
