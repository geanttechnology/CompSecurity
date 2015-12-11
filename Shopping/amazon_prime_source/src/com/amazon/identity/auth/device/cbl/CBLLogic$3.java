// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.DefaultCallback;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            CBLLogic

class back extends DefaultCallback
{

    final CBLLogic this$0;
    final String val$apiName;

    public void onError(Bundle bundle)
    {
        int i = bundle.getInt("com.amazon.dcp.sso.ErrorCode");
        bundle = bundle.getString("com.amazon.dcp.sso.ErrorMessage");
        MAPLog.i(CBLLogic.access$500(), (new StringBuilder("Error while deregistering account in ")).append(val$apiName).append(" flow. ErrorCode:").append(i).append(" ErrorMessage:").append(bundle).toString());
    }

    public void onSuccess(Bundle bundle)
    {
        MAPLog.i(CBLLogic.access$500(), (new StringBuilder("Successfully completed deregistering account in ")).append(val$apiName).append(" flow").toString());
    }

    back()
    {
        this$0 = final_cbllogic;
        val$apiName = String.this;
        super();
    }
}
