// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.AutoCompleteTextView;
import com.groupon.http.Http;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.view.SpinnerButton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            ForgotPasswordFragment

protected class lang
    implements android.view.istener
{

    protected final String lang;
    final ForgotPasswordFragment this$0;

    private String getEndpoint(boolean flag)
    {
        if (flag)
        {
            return "https:/password_reset?";
        } else
        {
            return "https:/users/password_reset?";
        }
    }

    public void onClick(View view)
    {
        view = email.getText().toString().trim();
        if (Strings.isEmpty(view) || !com.groupon.Listener.matcher(view).matches())
        {
            email.setError(getString(0x7f08015f));
            return;
        }
        reset.startSpinning();
        view = ForgotPasswordFragment.access$500(ForgotPasswordFragment.this).getCurrentCountry();
        ForgotPasswordFragment forgotpasswordfragment = ForgotPasswordFragment.this;
        boolean flag;
        if (view.isUSACompatible() || view.isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        (new this._cls0(forgotpasswordfragment, getEndpoint(flag), lang)).lang("POST").execute();
    }

    public (String s)
    {
        this$0 = ForgotPasswordFragment.this;
        super();
        lang = s;
    }
}
