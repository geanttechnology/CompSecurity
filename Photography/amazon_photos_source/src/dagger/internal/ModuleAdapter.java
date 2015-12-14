// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import java.util.Map;

public abstract class ModuleAdapter
{

    public final boolean complete;
    public final String entryPoints[];
    public final Class includes[];
    protected Object module;
    public final boolean overrides;
    public final Class staticInjections[];

    protected ModuleAdapter(String as[], Class aclass[], boolean flag, Class aclass1[], boolean flag1)
    {
        entryPoints = as;
        staticInjections = aclass;
        overrides = flag;
        includes = aclass1;
        complete = flag1;
    }

    public abstract void getBindings(Map map);

    public Object getModule()
    {
        return module;
    }

    protected abstract Object newModule();
}
