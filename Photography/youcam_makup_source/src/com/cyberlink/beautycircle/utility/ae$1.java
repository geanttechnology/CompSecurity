// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.utility.e;
import com.tencent.mm.sdk.openapi.a;
import com.tencent.mm.sdk.openapi.b;
import com.tencent.mm.sdk.openapi.f;
import com.tencent.mm.sdk.openapi.i;
import com.tencent.mm.sdk.openapi.l;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ae, af

final class 
    implements f
{

    public void a(a a1)
    {
    }

    public void a(b b1)
    {
        if (b1 == null)
        {
            e.e(new Object[] {
                "WeChatGlobalEvent: resp null"
            });
        } else
        {
            e.c(new Object[] {
                "WeChatGlobalEvent: ", com.cyberlink.beautycircle.utility.ae.a(b1.a)
            });
            if (b1 instanceof i)
            {
                com.cyberlink.beautycircle.utility.ae.a((i)b1);
                return;
            }
            if (b1 instanceof l)
            {
                if (com.cyberlink.beautycircle.utility.ae.a() != null)
                {
                    if (b1.a == 0)
                    {
                        com.cyberlink.beautycircle.utility.ae.a().a();
                    } else
                    {
                        com.cyberlink.beautycircle.utility.ae.a().b();
                    }
                    com.cyberlink.beautycircle.utility.ae.a(null);
                    return;
                }
                if (com.cyberlink.beautycircle.utility.ae.b() != null)
                {
                    com.cyberlink.beautycircle.utility.ae.a(null);
                    return;
                }
            }
        }
    }

    ()
    {
    }
}
