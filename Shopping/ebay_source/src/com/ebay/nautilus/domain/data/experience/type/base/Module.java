// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;


// Referenced classes of package com.ebay.nautilus.domain.data.experience.type.base:
//            IModule, Action, ModuleMeta

public class Module
    implements IModule
{

    public Action action;
    public ModuleMeta meta;

    public Module()
    {
    }

    public ModuleMeta getMeta()
    {
        return meta;
    }
}
