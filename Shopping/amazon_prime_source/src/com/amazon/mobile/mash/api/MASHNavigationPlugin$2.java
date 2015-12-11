// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.util.Log;
import com.amazon.mobile.mash.error.MASHError;
import com.amazon.mobile.mash.nav.MASHNavException;
import com.amazon.mobile.mash.nav.MASHNavHandler;
import com.amazon.mobile.mash.nav.MASHNavHandlerFactory;
import com.amazon.mobile.mash.nav.MASHNavOperation;
import java.util.List;
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
        List list = MASHNavigationPlugin.access$000(MASHNavigationPlugin.this, val$args);
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
            val$callbackContext.success();
            return;
        }
        catch (JSONException jsonexception)
        {
            Log.e(MASHNavigationPlugin.access$100(), (new StringBuilder()).append("MASH API can not do operation. Error: ").append(jsonexception.getMessage()).toString());
            val$callbackContext.error(MASHError.INVALID_ARGUMENTS.toJSONObejct());
            return;
        }
        catch (MASHNavException mashnavexception)
        {
            Log.e(MASHNavigationPlugin.access$100(), (new StringBuilder()).append("MASH API can not do operation. Error: ").append(mashnavexception.getMessage()).toString());
        }
        val$callbackContext.error(MASHError.UNKNOWN.toJSONObejct());
        return;
    }

    ()
    {
        this$0 = final_mashnavigationplugin;
        val$args = jsonarray;
        val$callbackContext = CallbackContext.this;
        super();
    }
}
