// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import com.espn.androidplayersdk.utilities.Utils;
import java.util.HashMap;
import org.apache.http.HttpEntity;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            FeedsManagerAPI, FeedsCommListener, EventByIdRequest

class EventByGameIdRequest
{

    FeedsCommListener listener;
    EPCatalogManager.Callback mCallBack;

    EventByGameIdRequest(EPCatalogManager.Callback callback)
    {
        mCallBack = null;
        listener = new FeedsCommListener() {

            final EventByGameIdRequest this$0;

            public void handleError(int i)
            {
                mCallBack.onEventRetrivalError(i);
            }

            public void update(HttpEntity httpentity, String s)
            {
            }

            public void update(JSONObject jsonobject, String s, HashMap hashmap)
            {
                jsonobject = (new EventByIdRequest()).parse(jsonobject);
                if (jsonobject != null)
                {
                    try
                    {
                        mCallBack.onEventUpdate(jsonobject);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONObject jsonobject)
                    {
                        Utils.sdkLog("EventBYGameIDRequest:", 5, jsonobject);
                        mCallBack.onEventRetrivalError(9);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (JSONObject jsonobject)
                    {
                        Utils.sdkLog("EventBYGameIDRequest:", 5, jsonobject);
                    }
                    break MISSING_BLOCK_LABEL_76;
                }
                mCallBack.onEventRetrivalError(8);
                return;
                mCallBack.onEventRetrivalError(9);
                return;
            }

            
            {
                this$0 = EventByGameIdRequest.this;
                super();
            }
        };
        mCallBack = callback;
    }

    void getEvent(String s)
    {
        (new FeedsManagerAPI(listener)).getEventByGameId(s);
    }
}
