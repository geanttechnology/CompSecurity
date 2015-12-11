// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.api.BSAuthResponse;
import com.bitstrips.imoji.models.BSUser;
import com.bitstrips.imoji.util.PreferenceUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            SignUpActivity

class val.user
    implements Callback
{

    final SignUpActivity this$0;
    final BSUser val$user;

    public void failure(RetrofitError retrofiterror)
    {
        enableButtons();
        retrofiterror = retrofiterror.getResponse();
        if (retrofiterror != null && retrofiterror.getStatus() == 400)
        {
            SignUpActivity.access$200(SignUpActivity.this);
            return;
        } else
        {
            SignUpActivity.access$300(SignUpActivity.this);
            return;
        }
    }

    public void success(BSAuthResponse bsauthresponse, Response response)
    {
        SignUpActivity.access$000(SignUpActivity.this);
        preferenceUtils.putBoolean(0x7f06008a, true);
        SignUpActivity.access$100(SignUpActivity.this, val$user);
    }

    public volatile void success(Object obj, Response response)
    {
        success((BSAuthResponse)obj, response);
    }

    ()
    {
        this$0 = final_signupactivity;
        val$user = BSUser.this;
        super();
    }
}
