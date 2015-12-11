// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.Stage;
import com.google.inject.spi.DisableCircularProxiesOption;
import com.google.inject.spi.RequireAtInjectOnConstructorsOption;
import com.google.inject.spi.RequireExactBindingAnnotationsOption;
import com.google.inject.spi.RequireExplicitBindingsOption;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.internal:
//            AbstractProcessor, Errors

class InjectorOptionsProcessor extends AbstractProcessor
{

    private boolean atInjectRequired;
    private boolean disableCircularProxies;
    private boolean exactBindingAnnotationsRequired;
    private boolean jitDisabled;

    InjectorOptionsProcessor(Errors errors)
    {
        super(errors);
        disableCircularProxies = false;
        jitDisabled = false;
        atInjectRequired = false;
        exactBindingAnnotationsRequired = false;
    }

    InjectorImpl.InjectorOptions getOptions(Stage stage, InjectorImpl.InjectorOptions injectoroptions)
    {
        boolean flag3 = false;
        Preconditions.checkNotNull(stage, "stage must be set");
        if (injectoroptions == null)
        {
            return new InjectorImpl.InjectorOptions(stage, jitDisabled, disableCircularProxies, atInjectRequired, exactBindingAnnotationsRequired);
        }
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (stage == injectoroptions.stage)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "child & parent stage don't match");
        if (jitDisabled || injectoroptions.jitDisabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (disableCircularProxies || injectoroptions.disableCircularProxies)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (atInjectRequired || injectoroptions.atInjectRequired)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (exactBindingAnnotationsRequired || injectoroptions.exactBindingAnnotationsRequired)
        {
            flag3 = true;
        }
        return new InjectorImpl.InjectorOptions(stage, flag, flag1, flag2, flag3);
    }

    public Boolean visit(DisableCircularProxiesOption disablecircularproxiesoption)
    {
        disableCircularProxies = true;
        return Boolean.valueOf(true);
    }

    public Boolean visit(RequireAtInjectOnConstructorsOption requireatinjectonconstructorsoption)
    {
        atInjectRequired = true;
        return Boolean.valueOf(true);
    }

    public Boolean visit(RequireExactBindingAnnotationsOption requireexactbindingannotationsoption)
    {
        exactBindingAnnotationsRequired = true;
        return Boolean.valueOf(true);
    }

    public Boolean visit(RequireExplicitBindingsOption requireexplicitbindingsoption)
    {
        jitDisabled = true;
        return Boolean.valueOf(true);
    }

    public volatile Object visit(DisableCircularProxiesOption disablecircularproxiesoption)
    {
        return visit(disablecircularproxiesoption);
    }

    public volatile Object visit(RequireAtInjectOnConstructorsOption requireatinjectonconstructorsoption)
    {
        return visit(requireatinjectonconstructorsoption);
    }

    public volatile Object visit(RequireExactBindingAnnotationsOption requireexactbindingannotationsoption)
    {
        return visit(requireexactbindingannotationsoption);
    }

    public volatile Object visit(RequireExplicitBindingsOption requireexplicitbindingsoption)
    {
        return visit(requireexplicitbindingsoption);
    }
}
