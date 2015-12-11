// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.j;

import android.support.v4.f.a;
import com.pointinside.products.BaseProduct;
import com.target.ui.model.LookupResultParcelable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.helper.j:
//            b

class val.listener
    implements com.target.ui.util.b._cls8
{

    final b this$0;
    final a val$listener;

    public void a(Exception exception)
    {
        val$listener.a(exception);
    }

    public void a(List list)
    {
        a a1 = new a();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            LookupResultParcelable lookupresultparcelable = (LookupResultParcelable)list.next();
            if (lookupresultparcelable.product != null)
            {
                a1.put(lookupresultparcelable.product.title.toLowerCase(), lookupresultparcelable);
            }
        } while (true);
        val$listener.a(a1);
    }

    seProduct()
    {
        this$0 = final_b1;
        val$listener = val.listener.this;
        super();
    }
}
