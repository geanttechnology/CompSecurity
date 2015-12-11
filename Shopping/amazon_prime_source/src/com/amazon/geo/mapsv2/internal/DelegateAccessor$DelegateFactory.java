// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.internal;

import com.amazon.client.framework.acf.Components;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtil;

// Referenced classes of package com.amazon.geo.mapsv2.internal:
//            DelegateAccessor

private static class mDelegateClass
    implements com.amazon.client.framework.acf.util.ateClass
{

    private final Class mDelegateClass;

    public transient Object createInstance(Object aobj[])
    {
        aobj = AmazonMapsRuntimeUtil.getRemoteContext(null);
        if (aobj == null)
        {
            throw new NullPointerException("Amazon Maps is not initialized.");
        }
        aobj = ((Object []) (Components.optional(((android.content.Context) (aobj)), mDelegateClass)));
        if (aobj == null)
        {
            throw new NullPointerException("Debug library not installed.");
        } else
        {
            return ((Object) (aobj));
        }
    }

    (Class class1)
    {
        mDelegateClass = class1;
    }
}
