// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;

// Referenced classes of package com.google.inject.spi:
//            Element, ElementVisitor, ProviderWithDependencies, Dependency

public final class ProviderLookup
    implements Element
{

    private Provider _flddelegate;
    private final Key key;
    private final Object source;

    public ProviderLookup(Object obj, Key key1)
    {
        source = Preconditions.checkNotNull(obj, "source");
        key = (Key)Preconditions.checkNotNull(key1, "key");
    }

    public Object acceptVisitor(ElementVisitor elementvisitor)
    {
        return elementvisitor.visit(this);
    }

    public void applyTo(Binder binder)
    {
        initializeDelegate(binder.withSource(getSource()).getProvider(key));
    }

    public Provider getDelegate()
    {
        return _flddelegate;
    }

    public Key getKey()
    {
        return key;
    }

    public Provider getProvider()
    {
        return new ProviderWithDependencies() {

            final ProviderLookup this$0;

            public Object get()
            {
                boolean flag;
                if (_flddelegate != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Preconditions.checkState(flag, "This Provider cannot be used until the Injector has been created.");
                return _flddelegate.get();
            }

            public Set getDependencies()
            {
                return ImmutableSet.of(Dependency.get(key.ofType(Types.providerOf(key.getTypeLiteral().getType()))));
            }

            public String toString()
            {
                return (new StringBuilder()).append("Provider<").append(key.getTypeLiteral()).append(">").toString();
            }

            
            {
                this$0 = ProviderLookup.this;
                super();
            }
        };
    }

    public Object getSource()
    {
        return source;
    }

    public void initializeDelegate(Provider provider)
    {
        boolean flag;
        if (_flddelegate == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkState(flag, "delegate already initialized");
        _flddelegate = (Provider)Preconditions.checkNotNull(provider, "delegate");
    }


}
