// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.map.MapWebActivity;
import com.amazon.now.map.MarkerInfo;
import com.amazon.now.util.AppUtils;
import java.util.LinkedList;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final JSONObject val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        MapWebActivity mapwebactivity = (MapWebActivity)cordova.getActivity();
        JSONObject jsonobject1 = val$args.optJSONObject("destination");
        JSONObject jsonobject = val$args.optJSONObject("courier");
        JSONArray jsonarray = val$args.optJSONArray("couriers");
        Object obj = val$args.opt("origin");
        LinkedList linkedlist = new LinkedList();
        if (jsonobject1 != null)
        {
            String s3 = jsonobject1.optString("destinationName");
            double d = jsonobject1.optDouble("latitude", -200D);
            double d5 = jsonobject1.optDouble("longitude", -200D);
            if (MarkerInfo.isValid(d, d5))
            {
                linkedlist.add(new MarkerInfo(s3, d, d5));
            }
        }
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                Object obj3 = jsonarray.optJSONObject(i);
                String s1 = ((JSONObject) (obj3)).optString("courierName");
                double d1 = ((JSONObject) (obj3)).optDouble("latitude", -200D);
                double d6 = ((JSONObject) (obj3)).optDouble("longitude", -200D);
                String s4 = ((JSONObject) (obj3)).optString("imageUrl");
                obj3 = ((JSONObject) (obj3)).optString("id");
                if (MarkerInfo.isValid(d1, d6) && AppUtils.isDefined(((String) (obj3))))
                {
                    linkedlist.add(new MarkerInfo(s1, d1, d6, s4, ((String) (obj3))));
                }
            }

        }
        if (obj instanceof JSONArray)
        {
            obj = (JSONArray)obj;
            for (int j = 0; j < ((JSONArray) (obj)).length(); j++)
            {
                Object obj2 = ((JSONArray) (obj)).optJSONObject(j);
                String s2 = ((JSONObject) (obj2)).optString("originName");
                double d2 = ((JSONObject) (obj2)).optDouble("latitude", -200D);
                double d7 = ((JSONObject) (obj2)).optDouble("longitude", -200D);
                obj2 = ((JSONObject) (obj2)).optString("imageUrl");
                if (MarkerInfo.isValid(d2, d7))
                {
                    linkedlist.add(new MarkerInfo(s2, d2, d7, ((String) (obj2))));
                }
            }

        } else
        if (obj instanceof JSONObject)
        {
            Object obj1 = (JSONObject)obj;
            obj = ((JSONObject) (obj1)).optString("originName");
            double d3 = ((JSONObject) (obj1)).optDouble("latitude", -200D);
            double d8 = ((JSONObject) (obj1)).optDouble("longitude", -200D);
            obj1 = ((JSONObject) (obj1)).optString("imageUrl");
            if (MarkerInfo.isValid(d3, d8))
            {
                linkedlist.add(new MarkerInfo(((String) (obj)), d3, d8, ((String) (obj1))));
            }
        }
        if (jsonarray == null && jsonobject != null)
        {
            String s = jsonobject.optString("courierName");
            double d4 = jsonobject.optDouble("latitude", -200D);
            double d9 = jsonobject.optDouble("longitude", -200D);
            if (MarkerInfo.isValid(d4, d9))
            {
                linkedlist.add(new MarkerInfo(s, d4, d9, null, null));
            }
        }
        if (linkedlist.isEmpty())
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        } else
        {
            mapwebactivity.plotMarkers(linkedlist);
            val$callbackContext.success();
            return;
        }
    }

    ()
    {
        this$0 = final_mashhoudiniplugin;
        val$args = jsonobject;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
