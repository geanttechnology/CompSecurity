// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mobile.mash.error.FocusOnItemError;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAppUiPlugin

class val.callback
    implements Runnable
{

    final MASHAppUiPlugin this$0;
    final CallbackContext val$callback;
    final String val$menuItemId;

    public void run()
    {
        AmazonActivity amazonactivity = AmazonActivity.getTopMostBaseActivity();
        if (amazonactivity != null && cordova.getActivity() == amazonactivity)
        {
            if (amazonactivity.getGNODrawer().focusOn(val$menuItemId))
            {
                val$callback.success();
                return;
            } else
            {
                val$callback.error(FocusOnItemError.NOT_FOUND.toJSONObejct());
                return;
            }
        } else
        {
            val$callback.error(FocusOnItemError.ITEM_CAN_NOT_BE_IN_FOCUS.toJSONObejct());
            return;
        }
    }

    r()
    {
        this$0 = final_mashappuiplugin;
        val$menuItemId = s;
        val$callback = CallbackContext.this;
        super();
    }
}
