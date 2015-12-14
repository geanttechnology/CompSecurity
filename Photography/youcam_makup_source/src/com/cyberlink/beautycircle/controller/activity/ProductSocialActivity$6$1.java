// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class a
    implements b
{

    final a a;

    public void a()
    {
        Globals.b("getAccountToken Fail");
    }

    public void a(String s)
    {
        c.a(a.a, com.cyberlink.beautycircle.controller.activity.ProductSocialActivity.c(a.a));
    }

    public void b()
    {
        Globals.b("getAccountToken Cancel");
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ProductSocialActivity$6

/* anonymous class */
    class ProductSocialActivity._cls6
        implements android.view.View.OnClickListener
    {

        final ProductSocialActivity a;

        public void onClick(View view)
        {
            aq.c = "comment";
            AccountManager.a(a, new ProductSocialActivity._cls6._cls1(this));
        }

            
            {
                a = productsocialactivity;
                super();
            }
    }

}
