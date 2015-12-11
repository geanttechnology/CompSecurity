// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import java.util.concurrent.ExecutorService;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

static final class nit> extends nit>
{

    public boolean execute(JSONArray jsonarray, CallbackContext callbackcontext, CordovaPlugin cordovaplugin)
    {
        cordovaplugin.cordova.getThreadPool().execute(new stainableTask(callbackcontext, null));
        return true;
    }

    stainableTask(String s, int i, String s1)
    {
        super(s, i, s1, null);
    }
}
