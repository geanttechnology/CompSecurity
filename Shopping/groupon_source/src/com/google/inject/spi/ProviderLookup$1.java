// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.spi:
//            ProviderWithDependencies, ProviderLookup, Dependency

class this._cls0
    implements ProviderWithDependencies
{

    final ProviderLookup this$0;

    public Object get()
    {
        boolean flag;
        if (ProviderLookup.access$000(ProviderLookup.this) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "This Provider cannot be used until the Injector has been created.");
        return ProviderLookup.access$000(ProviderLookup.this).get();
    }

    public Set getDependencies()
    {
        return ImmutableSet.of(Dependency.get(ProviderLookup.access$100(ProviderLookup.this).ofType(Types.providerOf(ProviderLookup.access$100(ProviderLookup.this).getTypeLiteral().getType()))));
    }

    public String toString()
    {
        return (new StringBuilder()).append("Provider<").append(ProviderLookup.access$100(ProviderLookup.this).getTypeLiteral()).append(">").toString();
    }

    ct.ImmutableSet()
    {
        this$0 = ProviderLookup.this;
        super();
    }
}
