// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject;

import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import javax.inject.Provider;

// Referenced classes of package com.google.inject:
//            Scope, Key, TypeLiteral, Provider

public class NoOpAnnotatedBindingBuilder
    implements AnnotatedBindingBuilder
{
    private class NoOpLinkedBindingBuilder
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
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder to(TypeLiteral typeliteral)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder to(Class class1)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toConstructor(Constructor constructor)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toConstructor(Constructor constructor, TypeLiteral typeliteral)
        {
            return scopedBindingBuilder;
        }

        public void toInstance(Object obj)
        {
        }

        public ScopedBindingBuilder toProvider(Key key)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toProvider(com.google.inject.Provider provider)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toProvider(TypeLiteral typeliteral)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toProvider(Class class1)
        {
            return scopedBindingBuilder;
        }

        public ScopedBindingBuilder toProvider(Provider provider)
        {
            return scopedBindingBuilder;
        }

        private NoOpLinkedBindingBuilder()
        {
            this$0 = NoOpAnnotatedBindingBuilder.this;
            super();
        }

    }

    private static class NoOpScopedBindingBuilder
        implements ScopedBindingBuilder
    {

        public void asEagerSingleton()
        {
        }

        public void in(Scope scope)
        {
        }

        public void in(Class class1)
        {
        }

        private NoOpScopedBindingBuilder()
        {
        }

    }


    private NoOpLinkedBindingBuilder noOpLinkedBindingBuilder;
    private ScopedBindingBuilder scopedBindingBuilder;

    public NoOpAnnotatedBindingBuilder()
    {
        scopedBindingBuilder = new NoOpScopedBindingBuilder();
        noOpLinkedBindingBuilder = new NoOpLinkedBindingBuilder();
    }

    public LinkedBindingBuilder annotatedWith(Class class1)
    {
        return noOpLinkedBindingBuilder;
    }

    public LinkedBindingBuilder annotatedWith(Annotation annotation)
    {
        return this;
    }

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
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder to(TypeLiteral typeliteral)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder to(Class class1)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toConstructor(Constructor constructor)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toConstructor(Constructor constructor, TypeLiteral typeliteral)
    {
        return scopedBindingBuilder;
    }

    public void toInstance(Object obj)
    {
    }

    public ScopedBindingBuilder toProvider(Key key)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toProvider(com.google.inject.Provider provider)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toProvider(TypeLiteral typeliteral)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toProvider(Class class1)
    {
        return scopedBindingBuilder;
    }

    public ScopedBindingBuilder toProvider(Provider provider)
    {
        return scopedBindingBuilder;
    }

}
