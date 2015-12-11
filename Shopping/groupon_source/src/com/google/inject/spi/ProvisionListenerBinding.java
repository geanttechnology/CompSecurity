// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.Binder;
import com.google.inject.matcher.Matcher;
import java.util.List;
import org.roboguice.shaded.goole.common.collect.ImmutableList;

// Referenced classes of package com.google.inject.spi:
//            Element, ElementVisitor, ProvisionListener

public final class ProvisionListenerBinding
    implements Element
{

    private final Matcher bindingMatcher;
    private final List listeners;
    private final Object source;

    ProvisionListenerBinding(Object obj, Matcher matcher, ProvisionListener aprovisionlistener[])
    {
        source = obj;
        bindingMatcher = matcher;
        listeners = ImmutableList.copyOf(aprovisionlistener);
    }

    public Object acceptVisitor(ElementVisitor elementvisitor)
    {
        return elementvisitor.visit(this);
    }

    public void applyTo(Binder binder)
    {
        binder.withSource(getSource()).bindListener(bindingMatcher, (ProvisionListener[])listeners.toArray(new ProvisionListener[listeners.size()]));
    }

    public Matcher getBindingMatcher()
    {
        return bindingMatcher;
    }

    public List getListeners()
    {
        return listeners;
    }

    public Object getSource()
    {
        return source;
    }
}
