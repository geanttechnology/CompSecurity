// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import android.content.Context;
import com.google.inject.Key;
import java.lang.reflect.ParameterizedType;
import roboguice.RoboGuice;
import roboguice.util.Ln;

// Referenced classes of package roboguice.inject:
//            ContextScope, ContextScopedRoboInjector

public abstract class Lazy
{

    private static boolean verboseLogging = false;
    private Context context;
    private Object instance;

    public Lazy(Context context1)
    {
        context = context1;
    }

    public static boolean isVerboseLoggingEnabled()
    {
        return verboseLogging;
    }

    public static void setVerboseLoggingEnabled(boolean flag)
    {
        verboseLogging = flag;
    }

    public Object get()
    {
        if (instance != null)
        {
            return instance;
        }
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        Object obj;
        if (instance == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = instance;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
        ContextScope contextscope;
        contextscope = null;
        exception = contextscope;
        Object obj1 = RoboGuice.getInjector(context);
        exception = contextscope;
        contextscope = (ContextScope)((ContextScopedRoboInjector) (obj1)).getInstance(roboguice/inject/ContextScope);
        exception = contextscope;
        contextscope.enter(context, ((ContextScopedRoboInjector) (obj1)).getScopedObjects());
        exception = contextscope;
        java.lang.reflect.Type type = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        exception = contextscope;
        if (!verboseLogging)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        exception = contextscope;
        Ln.d("Creating lazy instance of type: %s", new Object[] {
            type.toString()
        });
        exception = contextscope;
        throw new RuntimeException();
        RuntimeException runtimeexception;
        runtimeexception;
        exception = contextscope;
        runtimeexception.printStackTrace();
        exception = contextscope;
        instance = ((ContextScopedRoboInjector) (obj1)).getInstance(Key.get(type));
        exception = contextscope;
        obj1 = instance;
        contextscope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return obj1;
        Exception exception1;
        exception1;
        exception.exit(context);
        throw exception1;
    }

}
