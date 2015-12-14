// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import com.socialin.android.d;
import com.socialin.android.videogenerator.actions.a;
import java.io.IOException;
import java.io.ObjectOutputStream;

// Referenced classes of package com.socialin.android.videogenerator:
//            ActionCollector

public final class a
    implements Runnable
{

    private ActionCollector a;

    public final void run()
    {
        a a1;
        a1 = ActionCollector.c(a);
        if (a1.b == null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        a1.b.close();
        return;
        IOException ioexception;
        ioexception;
        d.b(a.a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        return;
    }

    public (ActionCollector actioncollector)
    {
        a = actioncollector;
        super();
    }
}
