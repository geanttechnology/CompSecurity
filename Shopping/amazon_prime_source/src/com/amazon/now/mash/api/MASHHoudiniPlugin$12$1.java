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

class this._cls1
    implements com.amazon.now.location.k
{

    final ejct this$1;

    public void onComplete()
    {
        callbackContext.success();
    }

    public void onFailure()
    {
        callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
    }

    l.callbackContext()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/now/mash/api/MASHHoudiniPlugin$12

/* anonymous class */
    class MASHHoudiniPlugin._cls12
        implements Runnable
    {

        final MASHHoudiniPlugin this$0;
        final CallbackContext val$callbackContext;

        public void run()
        {
            LocationUtil.fetchStores(cordova.getActivity(), new MASHHoudiniPlugin._cls12._cls1());
        }

            
            {
                this$0 = final_mashhoudiniplugin;
                callbackContext = CallbackContext.this;
                super();
            }
    }

}
