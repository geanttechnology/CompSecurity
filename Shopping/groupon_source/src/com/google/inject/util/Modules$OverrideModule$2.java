// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.spi.Element;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ScopeBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Sets;

// Referenced classes of package com.google.inject.util:
//            Modules

class t> extends t>
{

    final val.scopeBindings this$0;
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
        if (!val$overriddenKeys.remove(binding.getKey()))
        {
            super.t(binding);
            com.google.inject.Scope scope = cess._mth200(this._cls0.this, binding);
            if (scope != null)
            {
                List list = (List)val$scopeInstancesInUse.get(scope);
                Object obj = list;
                if (list == null)
                {
                    obj = Lists.newArrayList();
                    val$scopeInstancesInUse.put(scope, obj);
                }
                ((List) (obj)).add(binding.getSource());
            }
        }
        return null;
    }

    public Void visit(PrivateElements privateelements)
    {
        rewrite(binder, privateelements, val$overriddenKeys);
        return null;
    }

    public Void visit(ScopeBinding scopebinding)
    {
        val$scopeBindings.add(scopebinding);
        return null;
    }

    (List list)
    {
        this$0 = final_;
        val$overriddenKeys = set;
        val$scopeInstancesInUse = Map.this;
        val$scopeBindings = list;
        super(final_binder);
    }
}
