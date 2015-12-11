// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import com.google.inject.Key;
import com.google.inject.Provider;
import java.util.Map;
import java.util.Stack;

// Referenced classes of package roboguice.inject:
//            ContextScope, ScopedObjects

class val.unscoped
    implements Provider
{

    final ContextScope this$0;
    final Key val$key;
    final Provider val$unscoped;

    public Object get()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        ScopedObjects scopedobjects = (ScopedObjects)getContextStack().peek();
        if (scopedobjects != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return null;
        Object obj1 = scopedobjects.getScopedObjects().get(val$key);
        Object obj;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = obj1;
        if (!scopedobjects.getScopedObjects().containsKey(val$key))
        {
            obj = val$unscoped.get();
            scopedobjects.getScopedObjects().put(val$key, obj);
        }
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ()
    {
        this$0 = final_contextscope;
        val$key = key1;
        val$unscoped = Provider.this;
        super();
    }
}
