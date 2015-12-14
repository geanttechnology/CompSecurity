// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package dagger.internal:
//            Keys, BuiltInBinding, LazyBinding, Plugin, 
//            Binding

public final class Linker
{
    private static class DeferredBinding extends Binding
    {

        final String deferredKey;
        final boolean mustBeInjectable;

        private DeferredBinding(String s, Object obj, boolean flag)
        {
            super(null, null, false, obj);
            deferredKey = s;
            mustBeInjectable = flag;
        }

    }

    public static interface ErrorHandler
    {

        public abstract void handleErrors(List list);
    }

    private static class SingletonBinding extends Binding
    {

        private final Binding binding;
        private Object onlyInstance;

        public void attach(Linker linker)
        {
            binding.attach(linker);
        }

        public Object get()
        {
            if (onlyInstance == Linker.UNINITIALIZED)
            {
                onlyInstance = binding.get();
            }
            return onlyInstance;
        }

        public void injectMembers(Object obj)
        {
            binding.injectMembers(obj);
        }

        public String toString()
        {
            return (new StringBuilder()).append("@Singleton/").append(binding.toString()).toString();
        }

        private SingletonBinding(Binding binding1)
        {
            super(binding1.provideKey, binding1.membersKey, true, binding1.requiredBy);
            onlyInstance = Linker.UNINITIALIZED;
            binding = binding1;
        }

    }


    private static final Object UNINITIALIZED = new Object();
    private boolean attachSuccess;
    private final Linker base;
    private final Map bindings = new HashMap();
    private final ErrorHandler errorHandler;
    private final List errors = new ArrayList();
    private final Plugin plugin;
    private final Queue toLink = new LinkedList();

    public Linker(Linker linker, Plugin plugin1, ErrorHandler errorhandler)
    {
        attachSuccess = true;
        if (plugin1 == null)
        {
            throw new NullPointerException("plugin");
        }
        if (errorhandler == null)
        {
            throw new NullPointerException("errorHandler");
        } else
        {
            base = linker;
            plugin = plugin1;
            errorHandler = errorhandler;
            return;
        }
    }

    private void addError(String s)
    {
        errors.add(s);
    }

    private void assertLockHeld()
    {
        if (!Thread.holdsLock(this))
        {
            throw new AssertionError();
        } else
        {
            return;
        }
    }

    private Binding createJitBinding(String s, Object obj, boolean flag)
        throws ClassNotFoundException
    {
        Object obj1 = Keys.getBuiltInBindingsKey(s);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = new BuiltInBinding(s, obj, ((String) (obj1)));
_L4:
        return ((Binding) (obj));
_L2:
        obj1 = Keys.getLazyKey(s);
        if (obj1 != null)
        {
            return new LazyBinding(s, obj, ((String) (obj1)));
        }
        obj = Keys.getClassName(s);
        if (obj == null || Keys.isAnnotated(s))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = plugin.getAtInjectBinding(s, ((String) (obj)), flag);
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("No binding for ").append(s).toString());
    }

    private void putBinding(Binding binding)
    {
        binding = scope(binding);
        if (binding.provideKey != null)
        {
            putIfAbsent(bindings, binding.provideKey, binding);
        }
        if (binding.membersKey != null)
        {
            putIfAbsent(bindings, binding.membersKey, binding);
        }
    }

    private void putIfAbsent(Map map, Object obj, Object obj1)
    {
        obj1 = map.put(obj, obj1);
        if (obj1 != null)
        {
            map.put(obj, obj1);
        }
    }

    static Binding scope(Binding binding)
    {
        if (!binding.isSingleton())
        {
            return binding;
        }
        if (binding instanceof SingletonBinding)
        {
            throw new AssertionError();
        } else
        {
            return new SingletonBinding(binding);
        }
    }

    public void installBindings(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); bindings.put(entry.getKey(), scope((Binding)entry.getValue())))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public void linkRequested()
    {
        assertLockHeld();
_L2:
        Binding binding;
        String s;
        boolean flag;
        binding = (Binding)toLink.poll();
        if (binding == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!(binding instanceof DeferredBinding))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        DeferredBinding deferredbinding = (DeferredBinding)binding;
        s = deferredbinding.deferredKey;
        flag = deferredbinding.mustBeInjectable;
        if (bindings.containsKey(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj;
        obj = createJitBinding(s, binding.requiredBy, flag);
        if (!s.equals(((Binding) (obj)).provideKey) && !s.equals(((Binding) (obj)).membersKey))
        {
            throw new IllegalStateException((new StringBuilder()).append("Unable to create binding for ").append(s).toString());
        }
        try
        {
            toLink.add(obj);
            putBinding(((Binding) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            addError((new StringBuilder()).append(((Exception) (obj)).getMessage()).append(" required by ").append(binding.requiredBy).toString());
            bindings.put(s, Binding.UNRESOLVED);
        }
        continue; /* Loop/switch isn't completed */
        attachSuccess = true;
        binding.attach(this);
        if (attachSuccess)
        {
            binding.setLinked();
        } else
        {
            toLink.add(binding);
        }
        if (true) goto _L2; else goto _L1
_L1:
        errorHandler.handleErrors(errors);
        errors.clear();
        return;
        Exception exception;
        exception;
        errors.clear();
        throw exception;
    }

    public Binding requestBinding(String s, Object obj)
    {
        return requestBinding(s, obj, true);
    }

    public Binding requestBinding(String s, Object obj, boolean flag)
    {
        assertLockHeld();
        Binding binding = null;
        Linker linker = this;
        do
        {
            if (linker == null)
            {
                break;
            }
            Binding binding1 = (Binding)linker.bindings.get(s);
            if (binding1 != null)
            {
                binding = binding1;
                if (linker != this)
                {
                    binding = binding1;
                    if (!binding1.isLinked())
                    {
                        throw new AssertionError();
                    }
                }
                break;
            }
            linker = linker.base;
            binding = binding1;
        } while (true);
        if (binding == null)
        {
            s = new DeferredBinding(s, obj, flag);
            toLink.add(s);
            attachSuccess = false;
            s = null;
        } else
        {
            s = binding;
            if (!binding.isLinked())
            {
                toLink.add(binding);
                return binding;
            }
        }
        return s;
    }


}
