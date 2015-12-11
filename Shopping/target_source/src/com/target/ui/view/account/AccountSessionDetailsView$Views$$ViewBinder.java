// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;

// Referenced classes of package com.target.ui.view.account:
//            AccountCredentialsInputViewStatic, GuestNameViewStatic

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (AccountCredentialsInputViewStatic)viewbinder.atic((View)viewbinder.atic(obj, 0x7f1002f1, "field 'credentials'"), 0x7f1002f1, "field 'credentials'");
        . = (GuestNameViewStatic)viewbinder.name((View)viewbinder.name(obj, 0x7f1002f0, "field 'name'"), 0x7f1002f0, "field 'name'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
