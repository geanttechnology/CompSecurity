// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.c.a;

import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.ui.helper.product.b;

// Referenced classes of package com.target.ui.c.a:
//            d, a

public interface c
    extends d
{

    public abstract void a(int i);

    public abstract void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders);

    public abstract void a(Store store);

    public abstract void a(a a1, com.target.mothership.model.cart.interfaces.a.b.a a2, String s);

    public abstract void a(a a1, boolean flag);

    public abstract void a(b b1, Guest guest, o o);

    public abstract void b(a a1, boolean flag);
}
