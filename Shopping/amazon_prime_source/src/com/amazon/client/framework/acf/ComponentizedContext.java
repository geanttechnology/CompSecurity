// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

// Referenced classes of package com.amazon.client.framework.acf:
//            Component, Components, ComponentRegistry

public class ComponentizedContext extends ContextWrapper
    implements Component
{

    private final ComponentRegistry mApplicationComponentRegistry;
    private ComponentRegistry mComponentRegistry;

    public ComponentizedContext(Context context)
    {
        this(context, Components.createDefaultComponentRegistry(context));
    }

    public ComponentizedContext(Context context, ComponentRegistry componentregistry)
    {
        super(context);
        mComponentRegistry = componentregistry;
        mApplicationComponentRegistry = (ComponentRegistry)Components.optional(context.getApplicationContext(), com/amazon/client/framework/acf/ComponentRegistry);
    }

    public static ComponentizedContext wrapWithActivity(Context context, Activity activity)
    {
        return wrapWithActivity(context, activity, Components.createDefaultComponentRegistry(context));
    }

    public static ComponentizedContext wrapWithActivity(Context context, Activity activity, ComponentRegistry componentregistry)
    {
        context = new ComponentizedContext(context, componentregistry);
        if (((ComponentizedContext) (context)).mComponentRegistry != null)
        {
            Components.register(((ComponentizedContext) (context)).mComponentRegistry, android/app/Activity, activity);
        }
        return context;
    }

    protected void ensureComponentRegistry()
    {
        if (mComponentRegistry == null)
        {
            mComponentRegistry = Components.createDefaultComponentRegistry(getBaseContext());
        }
    }

    public Context getContext()
    {
        return this;
    }

    public Object getSystemService(String s)
    {
        Object obj1 = null;
        if (mComponentRegistry != null)
        {
            obj1 = mComponentRegistry.getComponent(s);
        }
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (getBaseContext() != null)
            {
                obj = super.getSystemService(s);
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (mApplicationComponentRegistry != null)
            {
                obj1 = mApplicationComponentRegistry.getComponent(s);
            }
        }
        return obj1;
    }
}
