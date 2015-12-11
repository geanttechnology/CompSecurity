// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.amazon.client.framework.acf:
//            Components, ComponentRegistry

public class ChainedComponents extends AtomicReference
{

    private static final long serialVersionUID = 0x83828cd3228db598L;

    public ChainedComponents()
    {
    }

    public static ComponentRegistry chain(Context context, ComponentRegistry componentregistry)
    {
        return (ComponentRegistry)((ChainedComponents)Components.required(context, com/amazon/client/framework/acf/ChainedComponents)).getAndSet(componentregistry);
    }
}
