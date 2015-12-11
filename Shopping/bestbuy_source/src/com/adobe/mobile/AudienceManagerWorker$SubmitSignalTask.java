// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.adobe.mobile:
//            MobileConfig, MobilePrivacyStatus, StaticMethods, AudienceManagerWorker, 
//            RequestHandler

public class callback
    implements Runnable
{

    public final  callback;
    public final Map data;

    public void run()
    {
        final HashMap callbackData = new HashMap();
        boolean flag = MobileConfig.getInstance().mobileUsingAudienceManager();
        if (flag) goto _L2; else goto _L1
_L1:
        if (callback != null)
        {
            (new Thread(new Runnable() {

                final AudienceManagerWorker.SubmitSignalTask this$0;
                final HashMap val$callbackData;

                public void run()
                {
                    callback.call(callbackData);
                }

            
            {
                this$0 = AudienceManagerWorker.SubmitSignalTask.this;
                callbackData = hashmap;
                super();
            }
            })).start();
        }
_L4:
        return;
_L2:
        if (MobileConfig.getInstance().getPrivacyStatus() != MobilePrivacyStatus.MOBILE_PRIVACY_STATUS_OPT_OUT)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        StaticMethods.logDebugFormat("Audience Manager - Privacy status is set to opt out, no signals will be submitted.", new Object[0]);
        if (callback == null) goto _L4; else goto _L3
_L3:
        (new Thread(new _cls1())).start();
        return;
        Object obj;
        obj = AudienceManagerWorker.access$400(data);
        if (((String) (obj)).length() > 1)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        StaticMethods.logWarningFormat("Audience Manager - Unable to create URL object", new Object[0]);
        if (callback == null) goto _L4; else goto _L5
_L5:
        (new Thread(new _cls1())).start();
        return;
        byte abyte0[];
        StaticMethods.logDebugFormat("Audience Manager - request (%s)", new Object[] {
            obj
        });
        abyte0 = RequestHandler.retrieveData(((String) (obj)), null, 2000, "Audience Manager");
        String s = "";
        obj = s;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_203;
        }
        obj = s;
        if (abyte0.length > 0)
        {
            obj = new String(abyte0, "UTF-8");
        }
        obj = new JSONObject(((String) (obj)));
        AudienceManagerWorker.access$500(((JSONObject) (obj)));
        AudienceManagerWorker.access$600(((JSONObject) (obj)).getString("uuid"));
        obj = AudienceManagerWorker.access$700(((JSONObject) (obj)));
        if (((HashMap) (obj)).size() > 0)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        StaticMethods.logWarningFormat("Audience Manager - response was empty", new Object[0]);
        if (callback == null) goto _L4; else goto _L6
_L6:
        (new Thread(new _cls1())).start();
        return;
        StaticMethods.logDebugFormat("Audience Manager - response (%s)", new Object[] {
            obj
        });
        AudienceManagerWorker.access$800(((Map) (obj)));
        callbackData.putAll(((Map) (obj)));
        if (callback != null)
        {
            (new Thread(new _cls1())).start();
            return;
        }
          goto _L4
        Object obj1;
        obj1;
        StaticMethods.logWarningFormat("Audience Manager - Unable to decode server response (%s)", new Object[] {
            ((UnsupportedEncodingException) (obj1)).getLocalizedMessage()
        });
        if (callback != null)
        {
            (new Thread(new _cls1())).start();
            return;
        }
          goto _L4
        obj1;
        StaticMethods.logWarningFormat("Audience Manager - Unable to parse JSON data (%s)", new Object[] {
            ((JSONException) (obj1)).getLocalizedMessage()
        });
        if (callback != null)
        {
            (new Thread(new _cls1())).start();
            return;
        }
          goto _L4
        obj1;
        StaticMethods.logWarningFormat("Audience Manager - Unexpected error parsing result (%s)", new Object[] {
            ((Exception) (obj1)).getLocalizedMessage()
        });
        if (callback == null) goto _L4; else goto _L7
_L7:
        (new Thread(new _cls1())).start();
        return;
        obj1;
        if (callback != null)
        {
            (new Thread(new _cls1())).start();
        }
        throw obj1;
    }

    public (Map map,  )
    {
        data = map;
        callback = ;
    }
}
