// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;

// Referenced classes of package com.amazon.client.framework.acf:
//            ComponentBase, ComponentHolder, ComponentLifecycle, Component

public abstract class ComponentFactory extends ComponentBase
    implements ComponentHolder, ComponentLifecycle
{

    private volatile Component mComponent;
    private final Object mInstanceLock = new Object();

    public ComponentFactory(Context context)
    {
        super(context);
    }

    public final Object getComponent(String s)
    {
        Component component2;
        Component component = mComponent;
        component2 = component;
        if (component != null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        Object obj1 = mInstanceLock;
        obj1;
        JVM INSTR monitorenter ;
        component2 = mComponent;
        Component component1;
        component1 = component2;
        if (component2 != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        component1 = onCreate(getContext());
        mComponent = component1;
        obj1;
        JVM INSTR monitorexit ;
        component2 = component1;
        if (component1 instanceof ComponentLifecycle)
        {
            ((ComponentLifecycle)component1).onComponentRegistered(s);
            component2 = component1;
        }
        Object obj = component2;
        if (component2 instanceof ComponentHolder)
        {
            obj = ((ComponentHolder)component2).getComponent(s);
        }
        return obj;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void onComponentRegistered(String s)
    {
        Component component = mComponent;
        if (component instanceof ComponentLifecycle)
        {
            ((ComponentLifecycle)component).onComponentRegistered(s);
        }
    }

    public void onComponentUnregistered(String s)
    {
        Component component = mComponent;
        if (component instanceof ComponentLifecycle)
        {
            ((ComponentLifecycle)component).onComponentUnregistered(s);
        }
    }

    protected abstract Component onCreate(Context context);
}
