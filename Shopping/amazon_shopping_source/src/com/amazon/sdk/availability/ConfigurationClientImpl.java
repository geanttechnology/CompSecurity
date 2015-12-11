// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import com.amazon.mas.http.LogInterceptor;
import com.amazon.mas.http.Web;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            ConfigurationClient, SignatureInterceptor, Stage, SubmissionState, 
//            Configuration, Logger

public class ConfigurationClientImpl
    implements ConfigurationClient
{

    private Web webClient;

    public ConfigurationClientImpl()
    {
        webClient = new Web();
        webClient.setGzipCompression(true);
        webClient.addInterceptor(new SignatureInterceptor());
        if (!Stage.isProduction())
        {
            webClient.addInterceptor(new LogInterceptor());
        }
    }

    public Configuration getAvailabilityConfiguration(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String as[], SubmissionState submissionstate)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        jsonobject.put("sdkVersion", s);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        jsonobject.put("marketplaceId", s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        jsonobject.put("customerId", s2);
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        jsonobject.put("deviceType", s3);
        if (s4 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        jsonobject.put("deviceId", s4);
        if (s5 == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        jsonobject.put("deviceMake", s5);
        if (s6 == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        jsonobject.put("deviceModel", s6);
        if (s7 == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        jsonobject.put("deviceCarrier", s7);
        if (s8 == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        jsonobject.put("deviceOs", s8);
        if (s9 == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        jsonobject.put("region", s9);
        if (submissionstate == null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        jsonobject.put("state", submissionstate.toJson());
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        jsonobject.put("clients", new JSONArray(Arrays.asList(as)));
        jsonobject.put("timestamp", System.currentTimeMillis());
_L1:
        if (Stage.getDomain() == Stage.Domain.PROD)
        {
            s = "https://mas-sdk.amazon.com/service/config/getAvailabilityConfiguration";
        } else
        {
            s = "https://mas-sdk.amazon.com/service/config/version/gamma/getAvailabilityConfiguration";
        }
        s1 = webClient;
        s1.getClass();
        s = (new com.amazon.mas.http.Web.Request(s1)).setMethod(com.amazon.mas.http.Web.HttpMethod.POST).setUrl(s).setPostBody(jsonobject.toString());
        s = webClient.execute(s);
        if (s.getCode() == 200)
        {
            try
            {
                s = new Configuration(new JSONObject(s.getResponse()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Logger.e("error parsing service response", s);
                return null;
            }
            return s;
        } else
        {
            Logger.e((new StringBuilder()).append("service error: ").append(s.getMessage()).append("(").append(s.getCode()).append(")").toString());
            return null;
        }
        s;
        Logger.e("error building configuration request body", s);
          goto _L1
    }
}
