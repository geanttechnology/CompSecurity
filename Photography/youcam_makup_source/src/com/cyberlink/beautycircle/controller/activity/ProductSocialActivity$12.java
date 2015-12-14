// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class a
    implements b
{

    final long a;
    final ProductSocialActivity b;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            DialogUtils.a(b, s, "Comment", a, com.cyberlink.beautycircle.utility.b, null);
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    (ProductSocialActivity productsocialactivity, long l)
    {
        b = productsocialactivity;
        a = l;
        super();
    }
}
