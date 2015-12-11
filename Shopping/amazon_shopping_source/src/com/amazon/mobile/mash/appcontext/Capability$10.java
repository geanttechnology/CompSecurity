// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.appcontext;


// Referenced classes of package com.amazon.mobile.mash.appcontext:
//            Capability, CapabilityManager

static final class it> extends Capability
{

    protected void initAvailability(CapabilityManager capabilitymanager)
    {
        setIsAvailable(capabilitymanager.isAvailableAppstore());
    }

    ger(String s, int i, int j)
    {
        super(s, i, j, null);
    }
}
