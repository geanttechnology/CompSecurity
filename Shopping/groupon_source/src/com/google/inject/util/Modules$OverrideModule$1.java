// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.spi.PrivateElements;
import com.google.inject.spi.ScopeBinding;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.inject.util:
//            Modules

class t> extends t>
{

    final t this$0;
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
        val$overriddenKeys.add(binding.getKey());
        return (Void)super.t(binding);
    }

    public Void visit(PrivateElements privateelements)
    {
        val$overriddenKeys.addAll(privateelements.getExposedKeys());
        return (Void)super.t(privateelements);
    }

    public Void visit(ScopeBinding scopebinding)
    {
        val$overridesScopeAnnotations.put(scopebinding.getAnnotationType(), scopebinding);
        return (Void)super.t(scopebinding);
    }

    (Map map)
    {
        this$0 = final_;
        val$overriddenKeys = Set.this;
        val$overridesScopeAnnotations = map;
        super(final_binder);
    }
}
