// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import android.view.ViewGroup;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.rendering.RenderView;
import java.util.Hashtable;

// Referenced classes of package com.inmobi.rendering.mraid:
//            MraidMediaProcessor, g

class a
    implements a
{

    final MraidMediaProcessor a;

    public void a(g g1)
    {
        Logger.a(com.inmobi.commons.core.utilities.l.INTERNAL, MraidMediaProcessor.j(), ">>> onPlayerCompleted");
        MraidMediaProcessor.b(a).setAdActiveFlag(false);
        ViewGroup viewgroup = g1.f();
        if (viewgroup != null)
        {
            ((ViewGroup)viewgroup.getParent()).removeView(viewgroup);
        }
        g1.a(null);
        this;
        JVM INSTR monitorenter ;
        if (MraidMediaProcessor.a(a) != null && g1.f.equalsIgnoreCase(MraidMediaProcessor.a(a).f))
        {
            MraidMediaProcessor.c(a).remove(MraidMediaProcessor.a(a).f);
            MraidMediaProcessor.a(a, null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        g1;
        this;
        JVM INSTR monitorexit ;
        throw g1;
    }

    public void b(g g1)
    {
        Logger.a(com.inmobi.commons.core.utilities.l.INTERNAL, MraidMediaProcessor.j(), ">>> onPlayerPrepared");
    }

    LogLevel(MraidMediaProcessor mraidmediaprocessor)
    {
        a = mraidmediaprocessor;
        super();
    }
}
