// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead;

import com.target.mothership.model.e;
import com.target.mothership.model.h;
import com.target.mothership.services.apigee.m.c.a;

// Referenced classes of package com.target.mothership.model.typeahead:
//            a

class b
    implements com.target.mothership.model.typeahead.a
{

    private a mService;

    public b()
    {
        mService = new a();
    }

    public void a(String s, h h)
    {
        h = new e(new com.target.mothership.model.typeahead.handler.a(h));
        mService.a(s, h);
    }
}
