// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.util.Log;
import android.view.View;
import com.bitstrips.imoji.api.BSAuthPasswordResetResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BSPasswordRecoveryActivity

class this._cls0
    implements Callback
{

    final BSPasswordRecoveryActivity this$0;

    public void failure(RetrofitError retrofiterror)
    {
        Log.e("BSPasswordRecovery", "Unable to contact password recovery service.");
        BSPasswordRecoveryActivity.access$000(BSPasswordRecoveryActivity.this);
        BSPasswordRecoveryActivity.access$100(BSPasswordRecoveryActivity.this);
    }

    public void success(BSAuthPasswordResetResponse bsauthpasswordresetresponse, Response response)
    {
        findViewById(0x7f0b0095).setVisibility(8);
        findViewById(0x7f0b0096).setVisibility(0);
        Log.d("BSPasswordRecovery", (new StringBuilder()).append("TOKEN: ").append(bsauthpasswordresetresponse.getPasswordResetToken()).toString());
    }

    public volatile void success(Object obj, Response response)
    {
        success((BSAuthPasswordResetResponse)obj, response);
    }

    _cls9()
    {
        this$0 = BSPasswordRecoveryActivity.this;
        super();
    }
}
