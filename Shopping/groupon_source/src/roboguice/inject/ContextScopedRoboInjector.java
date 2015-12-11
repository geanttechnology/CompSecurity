// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice.inject;

import android.content.Context;
import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package roboguice.inject:
//            ContextScope

public class ContextScopedRoboInjector
    implements Injector
{

    protected Context context;
    protected Injector _flddelegate;
    protected ContextScope scope;
    private Map scopedObjects;

    public ContextScopedRoboInjector(Context context1, Injector injector, ContextScope contextscope, Map map)
    {
        _flddelegate = injector;
        context = context1;
        scope = contextscope;
        scopedObjects = map;
    }

    public Injector createChildInjector(Iterable iterable)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        iterable = _flddelegate.createChildInjector(iterable);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return iterable;
        iterable;
        scope.exit(context);
        throw iterable;
        iterable;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw iterable;
    }

    public transient Injector createChildInjector(Module amodule[])
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        amodule = _flddelegate.createChildInjector(amodule);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return amodule;
        amodule;
        scope.exit(context);
        throw amodule;
        amodule;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw amodule;
    }

    public List findBindingsByType(TypeLiteral typeliteral)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        typeliteral = _flddelegate.findBindingsByType(typeliteral);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return typeliteral;
        typeliteral;
        scope.exit(context);
        throw typeliteral;
        typeliteral;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw typeliteral;
    }

    public Map getAllBindings()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        Map map = _flddelegate.getAllBindings();
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        scope.exit(context);
        throw exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Binding getBinding(Key key)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        key = _flddelegate.getBinding(key);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return key;
        key;
        scope.exit(context);
        throw key;
        key;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw key;
    }

    public Binding getBinding(Class class1)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        class1 = _flddelegate.getBinding(class1);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        scope.exit(context);
        throw class1;
        class1;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public Map getBindings()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        Map map = _flddelegate.getBindings();
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        scope.exit(context);
        throw exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Binding getExistingBinding(Key key)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        key = _flddelegate.getExistingBinding(key);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return key;
        key;
        scope.exit(context);
        throw key;
        key;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw key;
    }

    public Object getInstance(Key key)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        key = ((Key) (_flddelegate.getInstance(key)));
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return key;
        key;
        scope.exit(context);
        throw key;
        key;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw key;
    }

    public Object getInstance(Class class1)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        class1 = ((Class) (_flddelegate.getInstance(class1)));
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        scope.exit(context);
        throw class1;
        class1;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public MembersInjector getMembersInjector(TypeLiteral typeliteral)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        typeliteral = _flddelegate.getMembersInjector(typeliteral);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return typeliteral;
        typeliteral;
        scope.exit(context);
        throw typeliteral;
        typeliteral;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw typeliteral;
    }

    public MembersInjector getMembersInjector(Class class1)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        class1 = _flddelegate.getMembersInjector(class1);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        scope.exit(context);
        throw class1;
        class1;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public Injector getParent()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        Injector injector = _flddelegate.getParent();
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return injector;
        Exception exception;
        exception;
        scope.exit(context);
        throw exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Provider getProvider(Key key)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        key = _flddelegate.getProvider(key);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return key;
        key;
        scope.exit(context);
        throw key;
        key;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw key;
    }

    public Provider getProvider(Class class1)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        class1 = _flddelegate.getProvider(class1);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        scope.exit(context);
        throw class1;
        class1;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public Map getScopeBindings()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        Map map = _flddelegate.getScopeBindings();
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        scope.exit(context);
        throw exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Map getScopedObjects()
    {
        return scopedObjects;
    }

    public Set getTypeConverterBindings()
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        Set set = _flddelegate.getTypeConverterBindings();
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return set;
        Exception exception;
        exception;
        scope.exit(context);
        throw exception;
        exception;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void injectMembers(Object obj)
    {
        roboguice/inject/ContextScope;
        JVM INSTR monitorenter ;
        scope.enter(context, scopedObjects);
        _flddelegate.injectMembers(obj);
        scope.exit(context);
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        return;
        obj;
        scope.exit(context);
        throw obj;
        obj;
        roboguice/inject/ContextScope;
        JVM INSTR monitorexit ;
        throw obj;
    }
}
