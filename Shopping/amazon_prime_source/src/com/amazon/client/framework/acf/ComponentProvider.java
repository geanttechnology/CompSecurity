// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;

// Referenced classes of package com.amazon.client.framework.acf:
//            ComponentRegistry, Components

public class ComponentProvider
    implements ComponentRegistry
{

    private final ComponentRegistry mApplicationComponentRegistry;
    private final ComponentRegistry mComponentRegistry;

    public ComponentProvider(Context context)
    {
        this(context, Components.createDefaultComponentRegistry(context));
    }

    public ComponentProvider(Context context, ComponentRegistry componentregistry)
    {
        mComponentRegistry = componentregistry;
        mApplicationComponentRegistry = (ComponentRegistry)Components.optional(context.getApplicationContext(), com/amazon/client/framework/acf/ComponentRegistry);
    }

    public Object getComponent(String s)
    {
        Object obj = null;
        if (mComponentRegistry != null)
        {
            obj = mComponentRegistry.getComponent(s);
        }
        Object obj1 = obj;
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

    public void onDestroy()
    {
        if (mComponentRegistry != null)
        {
            mComponentRegistry.onDestroy();
        }
    }

    public Object registerComponent(String s, Object obj)
    {
        return mComponentRegistry.registerComponent(s, obj);
    }
}
