// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binder;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package com.google.inject.spi:
//            Element, ElementVisitor

public final class RequireExactBindingAnnotationsOption
    implements Element
{

    private final Object source;

    RequireExactBindingAnnotationsOption(Object obj)
    {
        source = Preconditions.checkNotNull(obj, "source");
    }

    public Object acceptVisitor(ElementVisitor elementvisitor)
    {
        return elementvisitor.visit(this);
    }

    public void applyTo(Binder binder)
    {
        binder.withSource(getSource()).requireExactBindingAnnotations();
    }

    public Object getSource()
    {
        return source;
    }
}
