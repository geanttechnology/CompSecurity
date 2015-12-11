// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;
import android.content.ContextWrapper;

// Referenced classes of package com.amazon.client.framework.acf:
//            Component

public class ComponentBase extends ContextWrapper
    implements Component
{

    public ComponentBase(Context context)
    {
        super(context);
    }

    public Context getContext()
    {
        return getBaseContext();
    }

    protected void onComponentRegistered(String s)
    {
    }

    protected void onComponentUnregistered(String s)
    {
    }
}
