// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import com.socialin.android.videogenerator.actions.Action;
import com.socialin.android.videogenerator.actions.a;

// Referenced classes of package com.socialin.android.videogenerator:
//            ActionCollector

final class a
    implements Runnable
{

    private Action a;
    private ActionCollector b;

    public final void run()
    {
        if (com.socialin.android.videogenerator.ActionCollector.a(b) == null)
        {
            com.socialin.android.videogenerator.ActionCollector.a(b, com.socialin.android.videogenerator.ActionCollector.a(ActionCollector.b(b)));
        }
        com.socialin.android.videogenerator.ActionCollector.a(b);
        ActionCollector.c(b).a(a);
        com.socialin.android.videogenerator.ActionCollector.a(b, a);
        if (com.socialin.android.videogenerator.ActionCollector.a(b) != null)
        {
            ActionCollector.b(b, com.socialin.android.videogenerator.ActionCollector.a(b));
        }
    }

    (ActionCollector actioncollector, Action action)
    {
        b = actioncollector;
        a = action;
        super();
    }
}
