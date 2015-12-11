// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binding;
import java.util.List;

// Referenced classes of package com.google.inject.spi:
//            ProvisionListener

public static abstract class A
{

    public abstract Binding getBinding();

    public abstract List getDependencyChain();

    public abstract Object provision();

    public A()
    {
    }
}
