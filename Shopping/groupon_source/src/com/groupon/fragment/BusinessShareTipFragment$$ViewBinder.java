// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.fragment:
//            BusinessShareTipFragment

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, BusinessShareTipFragment businesssharetipfragment, Object obj)
    {
        businesssharetipfragment.tipInput = (EditText)ewbinder.Input((View)ewbinder.Input(obj, 0x7f100166, "field 'tipInput'"), 0x7f100166, "field 'tipInput'");
        businesssharetipfragment.cancelButton = (Button)ewbinder.celButton((View)ewbinder.celButton(obj, 0x7f100168, "field 'cancelButton'"), 0x7f100168, "field 'cancelButton'");
        businesssharetipfragment.submitButton = (SpinnerButton)ewbinder.mitButton((View)ewbinder.mitButton(obj, 0x7f100169, "field 'submitButton'"), 0x7f100169, "field 'submitButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (BusinessShareTipFragment)obj, obj1);
    }

    public void unbind(BusinessShareTipFragment businesssharetipfragment)
    {
        businesssharetipfragment.tipInput = null;
        businesssharetipfragment.cancelButton = null;
        businesssharetipfragment.submitButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((BusinessShareTipFragment)obj);
    }

    public ()
    {
    }
}
