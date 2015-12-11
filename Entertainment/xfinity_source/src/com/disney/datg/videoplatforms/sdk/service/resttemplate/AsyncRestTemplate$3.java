// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import com.disney.datg.videoplatforms.sdk.service.HttpRequestHandler;
import com.disney.datg.videoplatforms.sdk.service.Request;
import java.util.List;
import java.util.concurrent.Callable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service.resttemplate:
//            AsyncRestTemplate

class val.asyncHandler
    implements Callable
{

    final AsyncRestTemplate this$0;
    final HttpRequestHandler val$asyncHandler;
    final Request val$request;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public ResponseEntity call()
    {
        Object obj1;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        obj1 = null;
        obj2 = null;
        obj4 = null;
        obj5 = null;
        obj6 = null;
        ..SwitchMap.org.springframework.http.HttpMethod[val$request.getHttpMethod().ordinal()];
        JVM INSTR tableswitch 1 1: default 244
    //                   1 120;
           goto _L1 _L2
_L1:
        byte abyte0[] = (byte[])AsyncRestTemplate.access$000(AsyncRestTemplate.this).getForObject(val$request.getServiceUri(), [B);
        Object obj;
        obj = obj6;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        obj = obj6;
        if (abyte0.length <= 0)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        obj = new ResponseEntity(abyte0, HttpStatus.OK);
        val$asyncHandler.onResponse(val$request, ((ResponseEntity) (obj)));
        return ((ResponseEntity) (obj));
_L2:
        AsyncRestTemplate.access$000(AsyncRestTemplate.this).getMessageConverters().add(new FormHttpMessageConverter());
          goto _L1
        obj;
_L10:
        val$asyncHandler.onError(val$request, ((Exception) (obj)));
        return ((ResponseEntity) (obj1));
        obj;
        obj1 = obj2;
_L8:
        val$asyncHandler.onError(val$request, ((Exception) (obj)));
        return ((ResponseEntity) (obj1));
        obj;
        obj1 = obj4;
_L6:
        val$asyncHandler.onError(val$request, ((Exception) (obj)));
        return ((ResponseEntity) (obj1));
        obj;
        obj1 = obj5;
_L4:
        ((Exception) (obj)).printStackTrace();
        return ((ResponseEntity) (obj1));
        Object obj3;
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L6; else goto _L5
_L5:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L8; else goto _L7
_L7:
        obj3;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L10; else goto _L9
_L9:
    }

    ()
    {
        this$0 = final_asyncresttemplate;
        val$request = request1;
        val$asyncHandler = HttpRequestHandler.this;
        super();
    }
}
