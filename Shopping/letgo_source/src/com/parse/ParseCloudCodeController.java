// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseRESTCloudCommand, ParseRESTCommand, ParseDecoder, ParseHttpClient

class ParseCloudCodeController
{

    final ParseHttpClient restClient;

    public ParseCloudCodeController(ParseHttpClient parsehttpclient)
    {
        restClient = parsehttpclient;
    }

    public cu callFunctionInBackground(String s, Map map, String s1)
    {
        return ParseRESTCloudCommand.callFunctionCommand(s, map, s1).executeAsync(restClient).c(new ct() {

            final ParseCloudCodeController this$0;

            public Object then(cu cu1)
                throws Exception
            {
                return convertCloudResponse(cu1.e());
            }

            
            {
                this$0 = ParseCloudCodeController.this;
                super();
            }
        });
    }

    Object convertCloudResponse(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof JSONObject)
        {
            obj1 = (JSONObject)obj;
            try
            {
                obj1 = ((JSONObject) (obj1)).get("result");
            }
            catch (JSONException jsonexception)
            {
                return obj;
            }
        }
        obj = ParseDecoder.get().decode(obj1);
        if (obj != null)
        {
            obj1 = obj;
        }
        return obj1;
    }
}
