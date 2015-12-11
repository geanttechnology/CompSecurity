// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;
import android.os.Bundle;

// Referenced classes of package com.amazon.client.framework.acf:
//            ComponentBase, ComponentRegistry

public abstract class ComponentInjector extends ComponentBase
{

    public ComponentInjector(Context context)
    {
        super(context);
    }

    public abstract void onInject(ComponentRegistry componentregistry, Bundle bundle);
}
