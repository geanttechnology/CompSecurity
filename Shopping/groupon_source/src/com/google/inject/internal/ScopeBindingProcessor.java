// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Scope;
import com.google.inject.spi.ScopeBinding;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            AbstractProcessor, Annotations, Errors, InjectorImpl, 
//            State

final class ScopeBindingProcessor extends AbstractProcessor
{

    ScopeBindingProcessor(Errors errors)
    {
        super(errors);
    }

    public Boolean visit(ScopeBinding scopebinding)
    {
        Scope scope = (Scope)Preconditions.checkNotNull(scopebinding.getScope(), "scope");
        Class class1 = (Class)Preconditions.checkNotNull(scopebinding.getAnnotationType(), "annotation type");
        if (!Annotations.isScopeAnnotation(class1))
        {
            errors.missingScopeAnnotation(class1);
        }
        if (!Annotations.isRetainedAtRuntime(class1))
        {
            errors.missingRuntimeRetention(class1);
        }
        ScopeBinding scopebinding1 = injector.state.getScopeBinding(class1);
        if (scopebinding1 != null)
        {
            if (!scope.equals(scopebinding1.getScope()))
            {
                errors.duplicateScopes(scopebinding1, class1, scope);
            }
        } else
        {
            injector.state.putScopeBinding(class1, scopebinding);
        }
        return Boolean.valueOf(true);
    }

    public volatile Object visit(ScopeBinding scopebinding)
    {
        return visit(scopebinding);
    }
}
