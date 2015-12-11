// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import com.google.inject.Scope;
import com.google.inject.internal.Errors;
import com.google.inject.spi.DefaultBindingScopingVisitor;
import com.google.inject.spi.DefaultElementVisitor;
import com.google.inject.spi.Element;
import com.google.inject.spi.Elements;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ScopeBinding;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Iterables;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Maps;
import org.roboguice.shaded.goole.common.collect.Sets;

public final class Modules
{
    private static class CombinedModule
        implements Module
    {

        final Set modulesSet;

        public void configure(Binder binder)
        {
            binder = binder.skipSources(new Class[] {
                getClass()
            });
            for (Iterator iterator = modulesSet.iterator(); iterator.hasNext(); binder.install((Module)iterator.next())) { }
        }

        CombinedModule(Iterable iterable)
        {
            modulesSet = ImmutableSet.copyOf(iterable);
        }
    }

    private static class EmptyModule
        implements Module
    {

        public void configure(Binder binder)
        {
        }

        private EmptyModule()
        {
        }

    }

    private static class ModuleWriter extends DefaultElementVisitor
    {

        protected final Binder binder;

        protected volatile Object visitOther(Element element)
        {
            return visitOther(element);
        }

        protected Void visitOther(Element element)
        {
            element.applyTo(binder);
            return null;
        }

        void writeAll(Iterable iterable)
        {
            for (iterable = iterable.iterator(); iterable.hasNext(); ((Element)iterable.next()).acceptVisitor(this)) { }
        }

        ModuleWriter(Binder binder1)
        {
            binder = binder1.skipSources(new Class[] {
                getClass()
            });
        }
    }

    public static interface OverriddenModuleBuilder
    {

        public abstract Module with(Iterable iterable);

        public transient abstract Module with(Module amodule[]);
    }

    static class OverrideModule extends AbstractModule
    {

        private final ImmutableSet baseModules;
        private final ImmutableSet overrides;

        private Scope getScopeInstanceOrNull(Binding binding)
        {
            return (Scope)binding.acceptScopingVisitor(new DefaultBindingScopingVisitor() {

                final OverrideModule this$0;

                public Scope visitScope(Scope scope)
                {
                    return scope;
                }

                public volatile Object visitScope(Scope scope)
                {
                    return visitScope(scope);
                }

            
            {
                this$0 = OverrideModule.this;
                super();
            }
            });
        }

        public void configure()
        {
            final java.util.HashSet overriddenKeys = binder();
            Object obj1 = Elements.getElements(currentStage(), baseModules);
            final Binder final_binder = overriddenKeys;
            Object obj = obj1;
            if (((List) (obj1)).size() == 1)
            {
                Element element = (Element)Iterables.getOnlyElement(((Iterable) (obj1)));
                final_binder = overriddenKeys;
                obj = obj1;
                if (element instanceof PrivateElements)
                {
                    obj = (PrivateElements)element;
                    final_binder = overriddenKeys.newPrivateBinder().withSource(((PrivateElements) (obj)).getSource());
                    for (overriddenKeys = ((PrivateElements) (obj)).getExposedKeys().iterator(); overriddenKeys.hasNext(); final_binder.withSource(((PrivateElements) (obj)).getExposedSource(((Key) (obj1)))).expose(((Key) (obj1))))
                    {
                        obj1 = (Key)overriddenKeys.next();
                    }

                    obj = ((PrivateElements) (obj)).getElements();
                }
            }
            final_binder = final_binder.skipSources(new Class[] {
                getClass()
            });
            obj = new LinkedHashSet(((java.util.Collection) (obj)));
            Object obj2 = Elements.getElements(currentStage(), overrides);
            overriddenKeys = Sets.newHashSet();
            obj1 = Maps.newHashMap();
            (overriddenKeys. new ModuleWriter(((Map) (obj1))) {

                final OverrideModule this$0;
                final Set val$overriddenKeys;
                final Map val$overridesScopeAnnotations;

                public volatile Object visit(Binding binding)
                {
                    return visit(binding);
                }

                public volatile Object visit(PrivateElements privateelements)
                {
                    return visit(privateelements);
                }

                public volatile Object visit(ScopeBinding scopebinding)
                {
                    return visit(scopebinding);
                }

                public Void visit(Binding binding)
                {
                    overriddenKeys.add(binding.getKey());
                    return (Void)super.visit(binding);
                }

                public Void visit(PrivateElements privateelements)
                {
                    overriddenKeys.addAll(privateelements.getExposedKeys());
                    return (Void)super.visit(privateelements);
                }

                public Void visit(ScopeBinding scopebinding)
                {
                    overridesScopeAnnotations.put(scopebinding.getAnnotationType(), scopebinding);
                    return (Void)super.visit(scopebinding);
                }

            
            {
                this$0 = final_overridemodule;
                overriddenKeys = Set.this;
                overridesScopeAnnotations = map;
                super(final_binder);
            }
            }).writeAll(((Iterable) (obj2)));
            obj2 = Maps.newHashMap();
            java.util.ArrayList arraylist = Lists.newArrayList();
            (((_cls2) (obj2)). new ModuleWriter(arraylist) {

                final OverrideModule this$0;
                final Set val$overriddenKeys;
                final List val$scopeBindings;
                final Map val$scopeInstancesInUse;

                void rewrite(Binder binder, PrivateElements privateelements, Set set)
                {
                    binder = binder.withSource(privateelements.getSource()).newPrivateBinder();
                    java.util.HashSet hashset = Sets.newHashSet();
                    for (Iterator iterator = privateelements.getExposedKeys().iterator(); iterator.hasNext();)
                    {
                        Key key = (Key)iterator.next();
                        if (set.remove(key))
                        {
                            hashset.add(key);
                        } else
                        {
                            binder.withSource(privateelements.getExposedSource(key)).expose(key);
                        }
                    }

                    privateelements = privateelements.getElements().iterator();
                    do
                    {
                        if (!privateelements.hasNext())
                        {
                            break;
                        }
                        set = (Element)privateelements.next();
                        if (!(set instanceof Binding) || !hashset.remove(((Binding)set).getKey()))
                        {
                            if (set instanceof PrivateElements)
                            {
                                rewrite(binder, (PrivateElements)set, ((Set) (hashset)));
                            } else
                            {
                                set.applyTo(binder);
                            }
                        }
                    } while (true);
                }

                public volatile Object visit(Binding binding)
                {
                    return visit(binding);
                }

                public volatile Object visit(PrivateElements privateelements)
                {
                    return visit(privateelements);
                }

                public volatile Object visit(ScopeBinding scopebinding)
                {
                    return visit(scopebinding);
                }

                public Void visit(Binding binding)
                {
                    if (!overriddenKeys.remove(binding.getKey()))
                    {
                        super.visit(binding);
                        Scope scope = getScopeInstanceOrNull(binding);
                        if (scope != null)
                        {
                            List list = (List)scopeInstancesInUse.get(scope);
                            Object obj = list;
                            if (list == null)
                            {
                                obj = Lists.newArrayList();
                                scopeInstancesInUse.put(scope, obj);
                            }
                            ((List) (obj)).add(binding.getSource());
                        }
                    }
                    return null;
                }

                public Void visit(PrivateElements privateelements)
                {
                    rewrite(binder, privateelements, overriddenKeys);
                    return null;
                }

                public Void visit(ScopeBinding scopebinding)
                {
                    scopeBindings.add(scopebinding);
                    return null;
                }

            
            {
                this$0 = final_overridemodule;
                overriddenKeys = set;
                scopeInstancesInUse = Map.this;
                scopeBindings = list;
                super(final_binder);
            }
            }).writeAll(((Iterable) (obj)));
            (((_cls3) (obj1)). new ModuleWriter(((Map) (obj2))) {

                final OverrideModule this$0;
                final Map val$overridesScopeAnnotations;
                final Map val$scopeInstancesInUse;

                public volatile Object visit(ScopeBinding scopebinding)
                {
                    return visit(scopebinding);
                }

                public Void visit(ScopeBinding scopebinding)
                {
                    ScopeBinding scopebinding1 = (ScopeBinding)overridesScopeAnnotations.remove(scopebinding.getAnnotationType());
                    if (scopebinding1 != null) goto _L2; else goto _L1
_L1:
                    super.visit(scopebinding);
_L4:
                    return null;
_L2:
                    Object obj = (List)scopeInstancesInUse.get(scopebinding.getScope());
                    if (obj != null)
                    {
                        StringBuilder stringbuilder = new StringBuilder("The scope for @%s is bound directly and cannot be overridden.");
                        stringbuilder.append((new StringBuilder()).append("%n     original binding at ").append(Errors.convert(scopebinding.getSource())).toString());
                        Object obj1;
                        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((new StringBuilder()).append("%n     bound directly at ").append(Errors.convert(obj1)).append("").toString()))
                        {
                            obj1 = ((Iterator) (obj)).next();
                        }

                        binder.withSource(scopebinding1.getSource()).addError(stringbuilder.toString(), new Object[] {
                            scopebinding.getAnnotationType().getSimpleName()
                        });
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = final_overridemodule;
                overridesScopeAnnotations = Map.this;
                scopeInstancesInUse = map1;
                super(final_binder);
            }
            }).writeAll(arraylist);
        }


        OverrideModule(Iterable iterable, ImmutableSet immutableset)
        {
            overrides = ImmutableSet.copyOf(iterable);
            baseModules = immutableset;
        }
    }

    private static final class RealOverriddenModuleBuilder
        implements OverriddenModuleBuilder
    {

        private final ImmutableSet baseModules;

        public Module with(Iterable iterable)
        {
            return new OverrideModule(iterable, baseModules);
        }

        public transient Module with(Module amodule[])
        {
            return with(((Iterable) (Arrays.asList(amodule))));
        }

        private RealOverriddenModuleBuilder(Iterable iterable)
        {
            baseModules = ImmutableSet.copyOf(iterable);
        }

    }


    public static final Module EMPTY_MODULE = new EmptyModule();

    private Modules()
    {
    }

    public static Module combine(Iterable iterable)
    {
        return new CombinedModule(iterable);
    }

    public static transient Module combine(Module amodule[])
    {
        return combine(((Iterable) (ImmutableSet.copyOf(amodule))));
    }

    public static OverriddenModuleBuilder override(Iterable iterable)
    {
        return new RealOverriddenModuleBuilder(iterable);
    }

    public static transient OverriddenModuleBuilder override(Module amodule[])
    {
        return new RealOverriddenModuleBuilder(Arrays.asList(amodule));
    }

}
