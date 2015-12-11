// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.util;

import com.google.inject.Binder;
import com.google.inject.internal.Errors;
import com.google.inject.spi.ScopeBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.inject.util:
//            Modules

class t> extends t>
{

    final Type this$0;
    final Map val$overridesScopeAnnotations;
    final Map val$scopeInstancesInUse;

    public volatile Object visit(ScopeBinding scopebinding)
    {
        return visit(scopebinding);
    }

    public Void visit(ScopeBinding scopebinding)
    {
        ScopeBinding scopebinding1 = (ScopeBinding)val$overridesScopeAnnotations.remove(scopebinding.getAnnotationType());
        if (scopebinding1 != null) goto _L2; else goto _L1
_L1:
        super.t(scopebinding);
_L4:
        return null;
_L2:
        Object obj = (List)val$scopeInstancesInUse.get(scopebinding.getScope());
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

    (Map map1)
    {
        this$0 = final_;
        val$overridesScopeAnnotations = Map.this;
        val$scopeInstancesInUse = map1;
        super(final_binder);
    }
}
