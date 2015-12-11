// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.TextView;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.b.s;
import com.wishabi.flipp.content.ShoppingList;
import com.wishabi.flipp.util.q;
import com.wishabi.flipp.widget.dv;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment, ff

final class fd
    implements dv
{

    final ShoppingListFragment a;

    fd(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final void a(TextView textview)
    {
        textview = textview.getText().toString();
        Object obj;
        if (!TextUtils.isEmpty(textview))
        {
            if ((obj = ShoppingListFragment.b(a).a(textview)) != null)
            {
                obj = ((Uri) (obj)).getLastPathSegment();
                ShoppingListFragment shoppinglistfragment = a;
                long l;
                if (obj != null && q.d(((String) (obj))))
                {
                    l = Long.parseLong(((String) (obj)));
                } else
                {
                    l = -1L;
                }
                com.wishabi.flipp.app.ShoppingListFragment.a(shoppinglistfragment, l);
                if (ShoppingListFragment.c(a) != null)
                {
                    ShoppingListFragment.c(a).a(textview);
                }
                a.a.a(textview, s.a, -1);
                return;
            }
        }
    }
}
