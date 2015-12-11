// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            ForgotPasswordFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, ForgotPasswordFragment forgotpasswordfragment, Object obj)
    {
        forgotpasswordfragment.title = (TextView)ewbinder.le((View)ewbinder.(obj, 0x7f1002a0, "field 'title'"), 0x7f1002a0, "field 'title'");
        forgotpasswordfragment.messageHint = (TextView)ewbinder.sageHint((View)ewbinder.(obj, 0x7f1002a1, "field 'messageHint'"), 0x7f1002a1, "field 'messageHint'");
        forgotpasswordfragment.messageThanks = (TextView)ewbinder.sageThanks((View)ewbinder.(obj, 0x7f1002a2, "field 'messageThanks'"), 0x7f1002a2, "field 'messageThanks'");
        forgotpasswordfragment.email = (AutoCompleteTextView)ewbinder.il((View)ewbinder.(obj, 0x7f1002a3, "field 'email'"), 0x7f1002a3, "field 'email'");
        forgotpasswordfragment.cancel = (Button)ewbinder.cel((View)ewbinder.(obj, 0x7f1002a5, "field 'cancel'"), 0x7f1002a5, "field 'cancel'");
        forgotpasswordfragment.reset = (SpinnerButton)ewbinder.et((View)ewbinder.(obj, 0x7f1002a6, "field 'reset'"), 0x7f1002a6, "field 'reset'");
        forgotpasswordfragment.options = (LinearLayout)ewbinder.ions((View)ewbinder.(obj, 0x7f1002a4, "field 'options'"), 0x7f1002a4, "field 'options'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ForgotPasswordFragment)obj, obj1);
    }

    public void unbind(ForgotPasswordFragment forgotpasswordfragment)
    {
        forgotpasswordfragment.title = null;
        forgotpasswordfragment.messageHint = null;
        forgotpasswordfragment.messageThanks = null;
        forgotpasswordfragment.email = null;
        forgotpasswordfragment.cancel = null;
        forgotpasswordfragment.reset = null;
        forgotpasswordfragment.options = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((ForgotPasswordFragment)obj);
    }

    public ()
    {
    }
}
