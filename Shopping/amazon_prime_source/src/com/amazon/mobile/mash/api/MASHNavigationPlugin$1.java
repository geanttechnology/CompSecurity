// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.nav.MASHWebBackForwardList;
import com.amazon.mobile.mash.nav.MASHWebHistoryItem;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHNavigationPlugin

class val.callbackContext
    implements Runnable
{

    final MASHNavigationPlugin this$0;
    final JSONArray val$args;
    final CallbackContext val$callbackContext;

    public void run()
    {
        try
        {
            String s = val$args.getString(0);
            ((MASHWebView)webView).getMASHWebBackForwardList().getCurrentItem().setBookmark(s);
            val$callbackContext.success();
            return;
        }
        catch (JSONException jsonexception)
        {
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
        }
    }

    ()
    {
        this$0 = final_mashnavigationplugin;
        val$args = jsonarray;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
