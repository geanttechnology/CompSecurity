// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import android.app.Application;
import android.content.Context;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Referenced classes of package roboguice.inject:
//            ScopedObjects

public class ContextScope
    implements Scope
{

    protected Application application;
    protected Map applicationScopedObjects;
    protected ThreadLocal contextThreadLocal;

    public ContextScope(Application application1)
    {
        contextThreadLocal = new ThreadLocal();
        applicationScopedObjects = new HashMap();
        application = application1;
        enter(application1, applicationScopedObjects);
    }

    public void enter(Context context, Map map)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        Class class1;
        getContextStack().push(new ScopedObjects(new WeakReference(context), map));
        class1 = context.getClass();
_L2:
        Class class2;
        map.put(Key.get(class1), context);
        class2 = class1.getSuperclass();
        class1 = class2;
        if (class2 != java/lang/Object) goto _L2; else goto _L1
_L1:
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return;
        context;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void exit(Context context)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        Context context1 = (Context)((ScopedObjects)getContextStack().pop()).getContextWeakReference().get();
        if (context1 == null || context1 == context)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        throw new IllegalArgumentException(String.format("Scope for %s must be opened before it can be closed", new Object[] {
            context
        }));
        context;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw context;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
    }

    public Stack getContextStack()
    {
        Stack stack1 = (Stack)contextThreadLocal.get();
        Stack stack = stack1;
        if (stack1 == null)
        {
            stack = new Stack();
            contextThreadLocal.set(stack);
        }
        return stack;
    }

    public Provider scope(final Key key, final Provider unscoped)
    {
        return new Provider() {

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
                Object obj1 = scopedobjects.getScopedObjects().get(key);
                Object obj;
                obj = obj1;
                if (obj1 != null)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                obj = obj1;
                if (!scopedobjects.getScopedObjects().containsKey(key))
                {
                    obj = unscoped.get();
                    scopedobjects.getScopedObjects().put(key, obj);
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

            
            {
                this$0 = ContextScope.this;
                key = key1;
                unscoped = provider;
                super();
            }
        };
    }
}
