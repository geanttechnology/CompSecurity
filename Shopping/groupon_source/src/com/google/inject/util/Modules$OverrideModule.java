// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.Scope;
import com.google.inject.internal.Errors;
import com.google.inject.spi.DefaultBindingScopingVisitor;
import com.google.inject.spi.Element;
import com.google.inject.spi.Elements;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ScopeBinding;
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

// Referenced classes of package com.google.inject.util:
//            Modules

static class baseModules extends AbstractModule
{

    private final ImmutableSet baseModules;
    private final ImmutableSet overrides;

    private Scope getScopeInstanceOrNull(Binding binding)
    {
        return (Scope)binding.acceptScopingVisitor(new DefaultBindingScopingVisitor() {

            final Modules.OverrideModule this$0;

            public Scope visitScope(Scope scope)
            {
                return scope;
            }

            public volatile Object visitScope(Scope scope)
            {
                return visitScope(scope);
            }

            
            {
                this$0 = Modules.OverrideModule.this;
                super();
            }
        });
    }

    public void configure()
    {
        final java.util.HashSet overriddenKeys = binder();
        final java.util.HashMap overridesScopeAnnotations = Elements.getElements(currentStage(), baseModules);
        final Binder final_binder = overriddenKeys;
        Object obj = overridesScopeAnnotations;
        if (overridesScopeAnnotations.size() == 1)
        {
            Element element = (Element)Iterables.getOnlyElement(overridesScopeAnnotations);
            final_binder = overriddenKeys;
            obj = overridesScopeAnnotations;
            if (element instanceof PrivateElements)
            {
                obj = (PrivateElements)element;
                final_binder = overriddenKeys.newPrivateBinder().withSource(((PrivateElements) (obj)).getSource());
                for (overriddenKeys = ((PrivateElements) (obj)).getExposedKeys().iterator(); overriddenKeys.hasNext(); final_binder.withSource(((PrivateElements) (obj)).getExposedSource(overridesScopeAnnotations)).expose(overridesScopeAnnotations))
                {
                    overridesScopeAnnotations = (Key)overriddenKeys.next();
                }

                obj = ((PrivateElements) (obj)).getElements();
            }
        }
        final_binder = final_binder.skipSources(new Class[] {
            getClass()
        });
        obj = new LinkedHashSet(((java.util.Collection) (obj)));
        final java.util.HashMap scopeInstancesInUse = Elements.getElements(currentStage(), overrides);
        overriddenKeys = Sets.newHashSet();
        overridesScopeAnnotations = Maps.newHashMap();
        (new Modules.ModuleWriter(overridesScopeAnnotations) {

            final Modules.OverrideModule this$0;
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
                this$0 = Modules.OverrideModule.this;
                overriddenKeys = set;
                overridesScopeAnnotations = map;
                super(final_binder);
            }
        }).writeAll(scopeInstancesInUse);
        scopeInstancesInUse = Maps.newHashMap();
        java.util.ArrayList arraylist = Lists.newArrayList();
        (new Modules.ModuleWriter(arraylist) {

            final Modules.OverrideModule this$0;
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
                        Object obj1 = list;
                        if (list == null)
                        {
                            obj1 = Lists.newArrayList();
                            scopeInstancesInUse.put(scope, obj1);
                        }
                        ((List) (obj1)).add(binding.getSource());
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
                this$0 = Modules.OverrideModule.this;
                overriddenKeys = set;
                scopeInstancesInUse = map;
                scopeBindings = list;
                super(final_binder);
            }
        }).writeAll(((Iterable) (obj)));
        (new Modules.ModuleWriter(scopeInstancesInUse) {

            final Modules.OverrideModule this$0;
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
                Object obj1 = (List)scopeInstancesInUse.get(scopebinding.getScope());
                if (obj1 != null)
                {
                    StringBuilder stringbuilder = new StringBuilder("The scope for @%s is bound directly and cannot be overridden.");
                    stringbuilder.append((new StringBuilder()).append("%n     original binding at ").append(Errors.convert(scopebinding.getSource())).toString());
                    Object obj2;
                    for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); stringbuilder.append((new StringBuilder()).append("%n     bound directly at ").append(Errors.convert(obj2)).append("").toString()))
                    {
                        obj2 = ((Iterator) (obj1)).next();
                    }

                    binder.withSource(scopebinding1.getSource()).addError(stringbuilder.toString(), new Object[] {
                        scopebinding.getAnnotationType().getSimpleName()
                    });
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = Modules.OverrideModule.this;
                overridesScopeAnnotations = map;
                scopeInstancesInUse = map1;
                super(final_binder);
            }
        }).writeAll(arraylist);
    }


    tableSet(Iterable iterable, ImmutableSet immutableset)
    {
        overrides = ImmutableSet.copyOf(iterable);
        baseModules = immutableset;
    }
}
