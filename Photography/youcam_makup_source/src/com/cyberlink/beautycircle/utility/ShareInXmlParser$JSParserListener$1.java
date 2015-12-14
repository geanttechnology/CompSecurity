// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.perfectcorp.utility.e;
import java.util.HashSet;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareInXmlParser, z

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        e.b(new Object[] {
            "OnNoMoreImage"
        });
        a.a = true;
        if (ShareInXmlParser.d(a.a) > ShareInXmlParser.h())
        {
            e.b(new Object[] {
                "Norma cleared; Do nothing."
            });
            return;
        }
        synchronized (ShareInXmlParser.f(a.a))
        {
            if (!ShareInXmlParser.f(a.a).isEmpty())
            {
                break MISSING_BLOCK_LABEL_149;
            }
            e.b(new Object[] {
                "All tasks done.  onParseCompleted."
            });
            if (ShareInXmlParser.b(a.a) != null)
            {
                ShareInXmlParser.b(a.a).a(ShareInXmlParser.g(a.a));
            }
            a.a.g();
        }
        return;
        exception;
        hashset;
        JVM INSTR monitorexit ;
        throw exception;
        hashset;
        JVM INSTR monitorexit ;
        e.b(new Object[] {
            "There are remaining tasks."
        });
        return;
    }

    ( )
    {
        a = ;
        super();
    }
}
