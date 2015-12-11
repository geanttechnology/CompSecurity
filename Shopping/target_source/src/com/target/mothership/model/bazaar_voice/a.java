// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice;

import com.target.mothership.common.params.c;
import com.target.mothership.model.e;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.bazaar_voice:
//            d

public class a
    implements d
{

    private com.target.mothership.services.a.a.c.a mService;

    public a()
    {
        mService = new com.target.mothership.services.a.a.c.a();
    }

    public void a(c c, h h)
    {
        h = new e(new com.target.mothership.model.bazaar_voice.handler.a(h));
        mService.a(c, h);
    }
}
