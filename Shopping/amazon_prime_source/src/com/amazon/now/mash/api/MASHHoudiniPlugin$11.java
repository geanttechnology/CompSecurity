// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.AmazonActivity;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.util.LocationUtil;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
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
        String s = val$args.optString("displayName");
        String s1 = val$args.optString("domain");
        String s2 = val$args.optString("marketplaceId");
        String s3 = val$args.optString("postalCode");
        String s4 = val$args.optString("menuBackgroundURL");
        JSONObject jsonobject = val$args.optJSONObject("mapStartLocation");
        double d = -200D;
        double d1 = -200D;
        if (jsonobject != null)
        {
            d = jsonobject.optDouble("latitude", -200D);
            d1 = jsonobject.optDouble("longitude", -200D);
        }
        if (AppUtils.isDefined(s3) && AppUtils.isDefined(s2) && ImageUtil.isImageServerUrl(s4))
        {
            LocationUtil.changeLocation((AmazonActivity)cordova.getActivity(), s, s1, s2, s3, s4, d, d1, val$callbackContext);
            return;
        } else
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
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
