// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.cyberlink.beautycircle.model.Product;
import com.cyberlink.beautycircle.model.network.d;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            TagProductActivity

class a extends m
{

    final TagProductActivity a;

    protected void a()
    {
        e.a(new Object[] {
            "queryProductById cancel"
        });
        if (e.a)
        {
            DialogUtils.a(a, "Oops", "queryProdInfo cancel", null);
        }
        TagProductActivity.a(a, null);
        com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).removeView(TagProductActivity.h(a));
        TagProductActivity.a(a, null);
        TagProductActivity.a(true);
    }

    protected void a(int i)
    {
        e.e(new Object[] {
            "queryProdInfo error: ", Integer.toHexString(i)
        });
        if (e.a)
        {
            DialogUtils.a(a, "Oops", (new StringBuilder()).append("queryProdInfo error: ").append(Integer.toHexString(i)).toString(), null);
        }
        TagProductActivity.a(a, null);
        com.cyberlink.beautycircle.controller.activity.TagProductActivity.d(a).removeView(TagProductActivity.h(a));
        TagProductActivity.a(a, null);
        TagProductActivity.a(true);
    }

    protected void a(d d1)
    {
        if (d1 == null || d1.a.intValue() <= 0 || d1.b == null || d1.b.isEmpty())
        {
            b(0x80000003);
        } else
        if (TagProductActivity.g(a) != null)
        {
            d1 = (Product)d1.b.get(0);
            com.cyberlink.beautycircle.model.uctActivity uctactivity = new com.cyberlink.beautycircle.model.>();
            uctactivity.>(TagProductActivity.g(a));
            uctactivity.ctId = ((Product) (d1)).productId;
            uctactivity.ctName = ((Product) (d1)).productName;
            uctactivity.Name = ((Product) (d1)).brandName;
            if (((Product) (d1)).imgThumbnail != null)
            {
                uctactivity.ctThumbnail = Uri.parse(((Product) (d1)).imgThumbnail);
            }
            TagProductActivity.a(a).add(uctactivity);
            TagProductActivity.f(a).add(TagProductActivity.h(a));
            d1 = TagProductActivity.a(a, uctactivity, TagProductActivity.a(a).size() - 1);
            TagProductActivity.b(a).addView(d1);
            TagProductActivity.c(a).add(d1);
            TagProductActivity.a(true);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    I(TagProductActivity tagproductactivity)
    {
        a = tagproductactivity;
        super();
    }
}
