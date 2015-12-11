// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, LogInFragment loginfragment, Object obj)
    {
        loginfragment.email = (AutoCompleteTextView)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002ad, "field 'email'"), 0x7f1002ad, "field 'email'");
        loginfragment.password = (EditText)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002ae, "field 'password'"), 0x7f1002ae, "field 'password'");
        loginfragment.submit = (SpinnerButton)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002af, "field 'submit'"), 0x7f1002af, "field 'submit'");
        loginfragment.facebook = (SpinnerButton)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002b1, "field 'facebook'"), 0x7f1002b1, "field 'facebook'");
        loginfragment.google = (SpinnerButton)ewbinder.w((View)ewbinder.uiredView(obj, 0x7f1002b2, "field 'google'"), 0x7f1002b2, "field 'google'");
        loginfragment.forgotPassword = (View)ewbinder.uiredView(obj, 0x7f1002b3, "field 'forgotPassword'");
        loginfragment.orText = (View)ewbinder.ionalView(obj, 0x7f1002b0, null);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (LogInFragment)obj, obj1);
    }

    public void unbind(LogInFragment loginfragment)
    {
        loginfragment.email = null;
        loginfragment.password = null;
        loginfragment.submit = null;
        loginfragment.facebook = null;
        loginfragment.google = null;
        loginfragment.forgotPassword = null;
        loginfragment.orText = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((LogInFragment)obj);
    }

    public ()
    {
    }
}
