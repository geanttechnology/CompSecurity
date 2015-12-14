// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class a extends m
{

    final ProductSocialActivity a;

    protected void a(com.cyberlink.beautycircle.model.mentResult mentresult)
    {
        if (mentresult != null)
        {
            ArrayList arraylist = mentresult.results;
            ProductSocialActivity.a(a, arraylist.size());
            ProductSocialActivity.a(a, arraylist);
            if (mentresult.totalSize != null)
            {
                int i = mentresult.totalSize.intValue();
                mentresult = a.findViewById(j.more_comment_btn);
                if (i > ProductSocialActivity.f(a))
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                mentresult.setVisibility(i);
                return;
            }
        }
    }

    protected void b(Object obj)
    {
        a((com.cyberlink.beautycircle.model.mentResult)obj);
    }

    (ProductSocialActivity productsocialactivity)
    {
        a = productsocialactivity;
        super();
    }
}
