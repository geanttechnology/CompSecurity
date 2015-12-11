// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.groupon.activity.Login;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment, TermsConditionsFragment

class this._cls0
    implements android.view.ner
{

    final SignUpFragment this$0;

    public void onClick(View view)
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(password.getWindowToken(), 0);
        logger.logClick("", "facebook_signup_click", com/groupon/activity/Login.getSimpleName(), "");
        SignUpFragment.access$002(SignUpFragment.this, "fb");
        (new TermsConditionsFragment()).show(getActivity().getFragmentManager(), "T&C");
    }

    agment()
    {
        this$0 = SignUpFragment.this;
        super();
    }
}
