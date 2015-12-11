// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart.b.a;

import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.ui.fragment.cart.a.a;

// Referenced classes of package com.target.ui.fragment.cart.b.a:
//            a

public class b extends com.target.ui.fragment.cart.b.a.a
{

    public b(com.target.ui.helper.b.a a1)
    {
        super(a1);
    }

    public void a(CartDetails cartdetails)
    {
    }

    public void b()
    {
        if (mCartPresentation == null)
        {
            return;
        } else
        {
            mCartPresentation.g();
            return;
        }
    }
}
