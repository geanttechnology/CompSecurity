// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.api;

import android.content.Intent;
import android.util.Log;
import com.amazon.mobile.mash.util.MASHDebug;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.PluginResult;

// Referenced classes of package com.amazon.mobile.mash.api:
//            MASHContactsPlugin

class this._cls0
    implements Runnable
{

    final MASHContactsPlugin this$0;

    public void run()
    {
        Object obj = new Intent("android.intent.action.PICK");
        ((Intent) (obj)).setType("vnd.android.cursor.dir/contact");
        cordova.startActivityForResult(MASHContactsPlugin.this, ((Intent) (obj)), 10001);
        obj = new PluginResult(org.apache.cordova.O_RESULT);
        ((PluginResult) (obj)).setKeepCallback(true);
        MASHContactsPlugin.access$000(MASHContactsPlugin.this).sendPluginResult(((PluginResult) (obj)));
        if (MASHDebug.isEnabled())
        {
            Log.i(MASHContactsPlugin.access$100(), "MASH API ShowContactPicker is executed succeccfully.");
        }
    }

    ()
    {
        this$0 = MASHContactsPlugin.this;
        super();
    }
}
