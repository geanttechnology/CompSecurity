// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import android.content.Context;
import com.google.inject.Provider;
import roboguice.RoboGuice;

// Referenced classes of package roboguice.inject:
//            ContextScope, ContextScopedRoboInjector

public class ContextScopedProvider
{

    protected Provider provider;

    public ContextScopedProvider()
    {
    }

    public Object get(Context context)
    {
        ContextScope contextscope;
        Object obj;
        obj = RoboGuice.getInjector(context);
        contextscope = (ContextScope)((ContextScopedRoboInjector) (obj)).getInstance(roboguice/inject/ContextScope);
        obj = ((ContextScopedRoboInjector) (obj)).getScopedObjects();
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        contextscope.enter(context, ((java.util.Map) (obj)));
        obj = provider.get();
        contextscope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        contextscope.exit(context);
        throw exception;
        context;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw context;
    }
}
