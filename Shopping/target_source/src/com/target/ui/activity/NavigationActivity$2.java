// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.activity;

import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.h;
import com.target.mothership.services.x;
import com.target.ui.service.b;

// Referenced classes of package com.target.ui.activity:
//            NavigationActivity

class this._cls0 extends h
{

    final NavigationActivity this$0;

    public String a()
    {
        return NavigationActivity.TAG;
    }

    public void a(Guest guest)
    {
        com.target.ui.service.b.a().b(guest);
    }

    public void a(x x1)
    {
    }

    public volatile void a(Object obj)
    {
        a((Guest)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    .Guest()
    {
        this$0 = NavigationActivity.this;
        super();
    }
}
