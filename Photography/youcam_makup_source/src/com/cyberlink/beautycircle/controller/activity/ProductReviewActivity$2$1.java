// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.content.res.Resources;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.r;
import com.cyberlink.beautycircle.utility.b;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductReviewActivity

class a extends m
{

    final a a;

    protected void a(int i)
    {
        a.a.l();
        Globals.a(a.a.getResources().getString(com.cyberlink.beautycircle.m.bc_server_connect_fail));
        e.e(new Object[] {
            "createComment error: ", Integer.valueOf(i)
        });
    }

    protected void a(Void void1)
    {
        a.a.l();
        void1 = new Intent();
        a.a.setResult(-1, void1);
        ProductReviewActivity.c(a.a);
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/ProductReviewActivity$2

/* anonymous class */
    class ProductReviewActivity._cls2
        implements b
    {

        final long a;
        final String b;
        final float c;
        final ProductReviewActivity d;

        public void a()
        {
            Globals.b("getAccountToken Fail");
        }

        public void a(String s)
        {
            d.k();
            ProductReviewActivity._cls2._cls1 _lcls1 = new ProductReviewActivity._cls2._cls1(this);
            if (ProductReviewActivity.d(d))
            {
                r.b(s, a, b, c).a(_lcls1);
                return;
            } else
            {
                r.a(s, a, b, c).a(_lcls1);
                return;
            }
        }

        public void b()
        {
            Globals.b("getAccountToken Cancel");
        }

            
            {
                d = productreviewactivity;
                a = l;
                b = s;
                c = f;
                super();
            }
    }

}
