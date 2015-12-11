// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.models.error.GrouponException;
import com.groupon.models.signup.SignupResponse;
import com.groupon.service.SignUpService;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment

class t> extends SignUpService
{

    final SignUpFragment this$0;

    protected void onException(Exception exception)
    {
        submit.stopSpinning();
        if ((exception instanceof GrouponException) && SignUpFragment.access$600(SignUpFragment.this, (GrouponException)exception))
        {
            return;
        } else
        {
            super.onException(exception);
            return;
        }
    }

    protected void onSuccess(SignupResponse signupresponse)
    {
        submit.stopSpinning();
        SignUpFragment.access$500(SignUpFragment.this, signupresponse);
    }

    transient se(Context context, String s, Object aobj[])
    {
        this$0 = SignUpFragment.this;
        super(context, s, aobj);
    }
}
