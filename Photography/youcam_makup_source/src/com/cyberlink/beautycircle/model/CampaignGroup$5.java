// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.l;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model:
//            CampaignGroup

final class  extends l
{

    public void a()
    {
        super.a();
        a(0x80000005);
    }

    public void a(int i)
    {
        super.a(i);
        a(((d) (null)));
    }

    protected void a(d d1)
    {
        if (d1 == null)
        {
            return;
        }
        CampaignGroup.a(d1.b);
        d1 = CampaignGroup.c();
        d1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = CampaignGroup.c().iterator(); iterator.hasNext(); ((j)iterator.next()).d(null)) { }
        break MISSING_BLOCK_LABEL_57;
        Exception exception;
        exception;
        d1;
        JVM INSTR monitorexit ;
        throw exception;
        CampaignGroup.c().clear();
        d1;
        JVM INSTR monitorexit ;
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    ()
    {
    }
}
