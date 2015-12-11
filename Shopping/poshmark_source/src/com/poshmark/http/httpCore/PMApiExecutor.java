// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;

import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.data_model.models.PMError;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.JSON.PMJson;
import com.poshmark.http.PMHttpResponse;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiRequest;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import org.apache.http.Header;

// Referenced classes of package com.poshmark.http.httpCore:
//            PMHttpExecutor

public class PMApiExecutor extends PMHttpExecutor
{

    public PMApiExecutor(PMApiRequest pmapirequest)
    {
        super(pmapirequest);
    }

    protected void callResponseHandler(PMHttpResponse pmhttpresponse)
    {
        PMApiResponse pmapiresponse = (PMApiResponse)pmhttpresponse;
        pmhttpresponse = (PMApiResponseHandler)((PMApiRequest)pmhttpresponse.httpRequest).responseHandler;
        if (pmhttpresponse != null)
        {
            pmhttpresponse.handleResponse(pmapiresponse);
        }
    }

    protected PMHttpResponse prepareResponse(int i, Header aheader[], String s, Throwable throwable)
    {
        Object obj2;
        Object obj3;
        Object obj4;
        PMErrorType pmerrortype1;
        obj4 = null;
        obj2 = null;
        obj3 = null;
        pmerrortype1 = PMErrorType.UNKNOWN_ERROR;
        if (throwable != null || i != 200) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        obj = PMJson.getInstance().gson();
        obj1 = ((PMApiRequest)pmHttpRequest).dataClass;
        if (obj instanceof Gson) goto _L4; else goto _L3
_L3:
        obj = ((Gson) (obj)).fromJson(s, ((Class) (obj1)));
        PMError pmerror;
        PMErrorType pmerrortype;
        obj1 = throwable;
        pmerrortype = pmerrortype1;
        pmerror = obj3;
_L7:
label0:
        {
            if (obj1 == null && pmerror == null)
            {
                throwable = obj2;
                if (i == 200)
                {
                    break label0;
                }
            }
            throwable = new PMApiError(pmerror, ((Throwable) (obj1)), i, pmerrortype);
        }
        return new PMApiResponse(i, aheader, s, obj, (PMApiRequest)pmHttpRequest, throwable);
_L4:
        try
        {
            obj = GsonInstrumentation.fromJson((Gson)obj, s, ((Class) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            pmerrortype = PMErrorType.JSON_PARSING_ERROR;
            ((Throwable) (obj1)).printStackTrace();
            obj = obj4;
            pmerror = obj3;
            continue; /* Loop/switch isn't completed */
        }
        pmerror = obj3;
        pmerrortype = pmerrortype1;
        obj1 = throwable;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = obj4;
        pmerror = obj3;
        pmerrortype = pmerrortype1;
        obj1 = throwable;
        if (throwable != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = PMJson.getInstance().gson();
        if (obj instanceof Gson)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        obj = ((Gson) (obj)).fromJson(s, com/poshmark/data_model/models/PMError);
_L5:
        pmerror = (PMError)obj;
        obj = obj4;
        pmerrortype = pmerrortype1;
        obj1 = throwable;
        continue; /* Loop/switch isn't completed */
        obj = GsonInstrumentation.fromJson((Gson)obj, s, com/poshmark/data_model/models/PMError);
          goto _L5
        obj1;
        ((Throwable) (obj1)).printStackTrace();
        obj = obj4;
        pmerror = obj3;
        pmerrortype = pmerrortype1;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
