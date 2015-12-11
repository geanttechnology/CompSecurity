// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.content.Intent;
import android.util.Log;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.nav.MASHNavException;
import com.amazon.mobile.mash.nav.MASHNavHandler;
import com.amazon.mobile.mash.nav.MASHNavHandlerFactory;
import com.amazon.mobile.mash.nav.MASHNavOperation;
import com.amazon.mobile.mash.nav.MASHWebBackForwardList;
import com.amazon.mobile.mash.nav.MASHWebHistoryItem;
import java.util.ArrayList;
import java.util.List;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHCordovaPlugin

public class MASHNavigationPlugin extends MASHCordovaPlugin
{

    public static final String SERVICE_NAME = "MASHNavigation";
    private static final String TAG = com/amazon/mobile/mash/api/MASHNavigationPlugin.getSimpleName();
    private CallbackContext mNavStackSeqCallbackContext;

    public MASHNavigationPlugin()
    {
    }

    private MASHNavOperation createMASHNavOperation(JSONObject jsonobject)
        throws JSONException
    {
        MASHNavOperation mashnavoperation = new MASHNavOperation();
        mashnavoperation.setOperation(jsonobject.getString("op"));
        if (jsonobject.has("bookmark"))
        {
            mashnavoperation.setBookmark(jsonobject.getString("bookmark"));
        }
        if (jsonobject.has("backAmount"))
        {
            mashnavoperation.setBackAmount(jsonobject.getInt("backAmount"));
        }
        com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mashnavrequest = null;
        if (jsonobject.has("url"))
        {
            com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest mashnavrequest1 = new com.amazon.mobile.mash.nav.MASHNavOperation.MASHNavRequest();
            mashnavrequest1.setUrl(jsonobject.getString("url"));
            if (jsonobject.has("method"))
            {
                mashnavrequest1.setMethod(jsonobject.getString("method"));
            }
            mashnavrequest = mashnavrequest1;
            if (jsonobject.has("parameters"))
            {
                mashnavrequest1.setParams(jsonobject.getJSONObject("parameters"));
                mashnavrequest = mashnavrequest1;
            }
        }
        mashnavoperation.setRequest(mashnavrequest);
        return mashnavoperation;
    }

    private List getOperationList(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(createMASHNavOperation(jsonarray.getJSONObject(i)));
        }

        return arraylist;
    }

    private void performNavigationStackSequence(final JSONArray args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHNavigationPlugin this$0;
            final JSONArray val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                List list = getOperationList(args);
                int i = 0;
_L2:
                if (i >= list.size())
                {
                    break; /* Loop/switch isn't completed */
                }
                MASHNavHandlerFactory.getMASHNavHandlerFactoryImpl(((MASHNavOperation)list.get(i)).getOperation()).createOperationHandler(MASHNavigationPlugin.this, list, i).navigate();
                i++;
                if (true) goto _L2; else goto _L1
_L1:
                try
                {
                    callbackContext.success();
                    return;
                }
                catch (JSONException jsonexception)
                {
                    Log.e(MASHNavigationPlugin.TAG, (new StringBuilder()).append("MASH API can not do operation. Error: ").append(jsonexception.getMessage()).toString());
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                    return;
                }
                catch (MASHNavException mashnavexception)
                {
                    Log.e(MASHNavigationPlugin.TAG, (new StringBuilder()).append("MASH API can not do operation. Error: ").append(mashnavexception.getMessage()).toString());
                }
                callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
                return;
            }

            
            {
                this$0 = MASHNavigationPlugin.this;
                args = jsonarray;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    private void setBookmark(final JSONArray args, final CallbackContext callbackContext)
    {
        runOnUiThread(new Runnable() {

            final MASHNavigationPlugin this$0;
            final JSONArray val$args;
            final CallbackContext val$callbackContext;

            public void run()
            {
                try
                {
                    String s = args.getString(0);
                    ((MASHWebView)webView).getMASHWebBackForwardList().getCurrentItem().setBookmark(s);
                    callbackContext.success();
                    return;
                }
                catch (JSONException jsonexception)
                {
                    callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
                }
            }

            
            {
                this$0 = MASHNavigationPlugin.this;
                args = jsonarray;
                callbackContext = callbackcontext;
                super();
            }
        });
    }

    public boolean execute(String s, JSONArray jsonarray, CallbackContext callbackcontext)
    {
        if ("SetBookmark".equals(s))
        {
            setBookmark(jsonarray, callbackcontext);
        } else
        if ("PerformNavigationStackSequence".equals(s))
        {
            mNavStackSeqCallbackContext = callbackcontext;
            performNavigationStackSequence(jsonarray, callbackcontext);
        } else
        {
            return false;
        }
        return true;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (i != 10003 || j != 10001)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        JSONArray jsonarray;
        try
        {
            intent = intent.getStringArrayExtra("remainingOperations");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.i(TAG, (new StringBuilder()).append("MASH API can not do operation. Error: ").append(intent.getMessage()).toString());
            mNavStackSeqCallbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        jsonarray = new JSONArray();
        i = 0;
_L2:
        if (i >= intent.length)
        {
            break; /* Loop/switch isn't completed */
        }
        jsonarray.put(new JSONObject(intent[i]));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        performNavigationStackSequence(jsonarray, mNavStackSeqCallbackContext);
    }



}
