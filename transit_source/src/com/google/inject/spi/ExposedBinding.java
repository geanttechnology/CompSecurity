// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binder;
import com.google.inject.Binding;

// Referenced classes of package com.google.inject.spi:
//            HasDependencies, PrivateElements

public interface ExposedBinding
    extends Binding, HasDependencies
{

    public abstract void applyTo(Binder binder);

    public abstract PrivateElements getPrivateElements();
}
