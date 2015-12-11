// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import java.lang.reflect.Constructor;
import javax.inject.Provider;

// Referenced classes of package com.google.inject:
//            NoOpAnnotatedBindingBuilder, Scope, Key, TypeLiteral, 
//            Provider

private class <init>
    implements LinkedBindingBuilder
{

    final NoOpAnnotatedBindingBuilder this$0;

    public void asEagerSingleton()
    {
    }

    public void in(Scope scope)
    {
    }

    public void in(Class class1)
    {
    }

    public ScopedBindingBuilder to(Key key)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder to(TypeLiteral typeliteral)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder to(Class class1)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toConstructor(Constructor constructor)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toConstructor(Constructor constructor, TypeLiteral typeliteral)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public void toInstance(Object obj)
    {
    }

    public ScopedBindingBuilder toProvider(Key key)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toProvider(com.google.inject.Provider provider)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toProvider(TypeLiteral typeliteral)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toProvider(Class class1)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    public ScopedBindingBuilder toProvider(Provider provider)
    {
        return NoOpAnnotatedBindingBuilder.access$200(NoOpAnnotatedBindingBuilder.this);
    }

    private ()
    {
        this$0 = NoOpAnnotatedBindingBuilder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
