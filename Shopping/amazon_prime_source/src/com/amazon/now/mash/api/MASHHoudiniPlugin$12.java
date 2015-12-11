// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash.api;

import com.amazon.mobile.mash.error.MASHError;
import com.amazon.now.util.LocationUtil;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.mash.api:
//            MASHHoudiniPlugin

class val.callbackContext
    implements Runnable
{

    final MASHHoudiniPlugin this$0;
    final CallbackContext val$callbackContext;

    public void run()
    {
        LocationUtil.fetchStores(cordova.getActivity(), new com.amazon.now.location.Store.StoreFetchCallback() {

            final MASHHoudiniPlugin._cls12 this$1;

            public void onComplete()
            {
                callbackContext.success();
            }

            public void onFailure()
            {
                callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
            }

            
            {
                this$1 = MASHHoudiniPlugin._cls12.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = final_mashhoudiniplugin;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
