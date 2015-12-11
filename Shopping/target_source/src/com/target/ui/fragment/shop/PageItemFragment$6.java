// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.o;
import com.target.mothership.services.x;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

class val.errorMessage extends h
{

    final PageItemFragment this$0;
    final String val$errorMessage;
    final o val$retryable;

    public void a(Guest guest)
    {
        if (PageItemFragment.a(PageItemFragment.this) == null)
        {
            return;
        }
        if (val$retryable == null)
        {
            PageItemFragment.b(PageItemFragment.this, val$errorMessage);
            return;
        }
        try
        {
            val$retryable.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Guest guest)
        {
            q.a(PageItemFragment.TAG, (new StringBuilder()).append("NullPointerException : ").append(guest.getMessage()).toString());
        }
        PageItemFragment.b(PageItemFragment.this, val$errorMessage);
    }

    public void a(x x1)
    {
        if (PageItemFragment.a(PageItemFragment.this) == null)
        {
            return;
        } else
        {
            PageItemFragment.b(PageItemFragment.this, val$errorMessage);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((Guest)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    est()
    {
        this$0 = final_pageitemfragment;
        val$retryable = o1;
        val$errorMessage = String.this;
        super();
    }
}
