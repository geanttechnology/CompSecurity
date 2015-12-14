// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner, k, InMobiAdRequestStatus

class a
    implements Runnable
{

    final boolean a;
    final InMobiBanner b;

    public void run()
    {
        if (b.hasValidSize())
        {
            InMobiBanner.access$000(b);
            if (InMobiBanner.access$100(b))
            {
                InMobiBanner.access$200(b).b(a);
            }
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.LogLevel.ERROR, InMobiBanner.access$300(), "The height or width of the banner can not be determined");
            InMobiBanner.access$400(b).b(new InMobiAdRequestStatus(Status.StatusCode.INTERNAL_ERROR));
            return;
        }
    }

    Status.StatusCode(InMobiBanner inmobibanner, boolean flag)
    {
        b = inmobibanner;
        a = flag;
        super();
    }
}
