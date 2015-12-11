// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.os.Bundle;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            Callback, MAPWebViewHelper

class val.callback
    implements Callback
{

    final MAPWebViewHelper this$0;
    final Callback val$callback;

    public void onError(Bundle bundle)
    {
        val$callback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        try
        {
            String as[] = bundle.getStringArray("com.amazon.identity.auth.device.api.cookiekeys.all");
            MAPWebViewHelper.access$500(MAPWebViewHelper.this, as);
            MAPWebViewHelper.access$600(MAPWebViewHelper.this);
            val$callback.onSuccess(bundle);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            MAPLog.e(MAPWebViewHelper.access$700(), "Unexpected error during getCookie call", bundle);
        }
    }

    ()
    {
        this$0 = final_mapwebviewhelper;
        val$callback = Callback.this;
        super();
    }
}
