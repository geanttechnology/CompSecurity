// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.os.Bundle;
import com.amazon.client.framework.acf.ComponentRegistry;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            AggregateComponentManager

private static class isRequired
{

    public Bundle bundle;
    public ComponentRegistry componentRegistry;
    public final boolean isRequired;
    public Context module;
    public final String packageName;

    public Q(ComponentRegistry componentregistry)
    {
        packageName = null;
        isRequired = false;
        componentRegistry = componentregistry;
    }

    public componentRegistry(String s, Bundle bundle1, boolean flag)
    {
        packageName = s;
        bundle = bundle1;
        isRequired = flag;
    }
}
