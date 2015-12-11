// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import android.text.Html;
import com.target.mothership.model.common.TGTOrderProductImage;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.c.b.ad;
import com.target.mothership.services.apigee.c.b.t;
import com.target.mothership.services.apigee.d.b;
import com.target.mothership.util.o;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            y, TGTSaveForLaterProduct

class this._cls0
    implements aa
{

    final y this$0;

    public volatile Object a(Object obj)
    {
        return a((ad)obj);
    }

    public List a(ad ad1)
    {
        if (ad1 == null || ad1.a() == null || ad1.a().size() == 0)
        {
            return Collections.emptyList();
        }
        ArrayList arraylist = new ArrayList(ad1.a().size());
        TGTSaveForLaterProduct tgtsaveforlaterproduct;
        for (Iterator iterator = ad1.a().iterator(); iterator.hasNext(); arraylist.add(tgtsaveforlaterproduct))
        {
            b b1 = (b)iterator.next();
            tgtsaveforlaterproduct = new TGTSaveForLaterProduct();
            tgtsaveforlaterproduct.a(b1.h());
            tgtsaveforlaterproduct.a(b1.g());
            Object obj = b1.s().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                ad1 = (t)((Iterator) (obj)).next();
                if (!o.g(ad1.a()))
                {
                    continue;
                }
                obj = new TGTOrderProductImage();
                ((TGTOrderProductImage) (obj)).a(ad1.a());
                ((TGTOrderProductImage) (obj)).b(ad1.b());
                tgtsaveforlaterproduct.a(((com.target.mothership.model.common.OrderProductImage) (obj)));
                break;
            } while (true);
            obj = y.a(y.this, b1);
            ad1 = ((ad) (obj));
            if (obj == null)
            {
                ad1 = b1.m();
            }
            tgtsaveforlaterproduct.b(null);
            tgtsaveforlaterproduct.a(b1.l());
            tgtsaveforlaterproduct.a(new BigDecimal(ad1));
            tgtsaveforlaterproduct.a(b1.o());
            tgtsaveforlaterproduct.b(Html.fromHtml(b1.k()).toString());
            tgtsaveforlaterproduct.a(b1.L());
        }

        return arraylist;
    }

    oductImage()
    {
        this$0 = y.this;
        super();
    }
}
