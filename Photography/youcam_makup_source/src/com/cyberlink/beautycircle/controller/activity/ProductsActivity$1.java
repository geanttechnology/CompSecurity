// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import com.cyberlink.beautycircle.controller.fragment.s;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.DialogUtils;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductsActivity

class a
    implements s
{

    final ProductsActivity a;

    public void a()
    {
        a.l();
    }

    public void b()
    {
        a.l();
        DialogUtils.a(a, null, a.getResources().getString(m.bc_register_error_invalid_locale), null, null, a.getResources().getString(m.bc_dialog_button_ok), null);
    }

    (ProductsActivity productsactivity)
    {
        a = productsactivity;
        super();
    }
}
