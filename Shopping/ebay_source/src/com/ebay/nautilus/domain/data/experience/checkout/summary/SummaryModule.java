// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.checkout.summary;

import com.ebay.nautilus.domain.data.experience.type.base.IModule;
import com.ebay.nautilus.domain.data.experience.type.base.ModuleMeta;

// Referenced classes of package com.ebay.nautilus.domain.data.experience.checkout.summary:
//            Summary

public class SummaryModule extends Summary
    implements IModule
{

    public ModuleMeta meta;
    public String moduleTitle;

    public SummaryModule()
    {
    }

    public ModuleMeta getMeta()
    {
        return meta;
    }
}
