// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            SignUpFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, SignUpFragment signupfragment, Object obj)
    {
        signupfragment.name = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b5, "field 'name'"), 0x7f1002b5, "field 'name'");
        signupfragment.email = (AutoCompleteTextView)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002ad, "field 'email'"), 0x7f1002ad, "field 'email'");
        signupfragment.password = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002ae, "field 'password'"), 0x7f1002ae, "field 'password'");
        signupfragment.phoneNumber = (EditText)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b6, "field 'phoneNumber'"), 0x7f1002b6, "field 'phoneNumber'");
        signupfragment.city = (Button)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b7, "field 'city'"), 0x7f1002b7, "field 'city'");
        signupfragment.submit = (SpinnerButton)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002af, "field 'submit'"), 0x7f1002af, "field 'submit'");
        signupfragment.facebook = (SpinnerButton)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b1, "field 'facebook'"), 0x7f1002b1, "field 'facebook'");
        signupfragment.google = (SpinnerButton)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b2, "field 'google'"), 0x7f1002b2, "field 'google'");
        signupfragment.newsletterOptin = (CheckBox)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002b8, "field 'newsletterOptin'"), 0x7f1002b8, "field 'newsletterOptin'");
        signupfragment.subscriptionDisclaimer = (View)ewbinder.iredView(obj, 0x7f1002b9, "field 'subscriptionDisclaimer'");
        signupfragment.contactUs = (TextView)ewbinder.((View)ewbinder.iredView(obj, 0x7f1002ba, "field 'contactUs'"), 0x7f1002ba, "field 'contactUs'");
        signupfragment.orText = (View)ewbinder.onalView(obj, 0x7f1002b0, null);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (SignUpFragment)obj, obj1);
    }

    public void unbind(SignUpFragment signupfragment)
    {
        signupfragment.name = null;
        signupfragment.email = null;
        signupfragment.password = null;
        signupfragment.phoneNumber = null;
        signupfragment.city = null;
        signupfragment.submit = null;
        signupfragment.facebook = null;
        signupfragment.google = null;
        signupfragment.newsletterOptin = null;
        signupfragment.subscriptionDisclaimer = null;
        signupfragment.contactUs = null;
        signupfragment.orText = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((SignUpFragment)obj);
    }

    public ()
    {
    }
}
