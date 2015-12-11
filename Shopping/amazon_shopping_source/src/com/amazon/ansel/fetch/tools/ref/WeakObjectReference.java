// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.ref;

import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.ansel.fetch.tools.ref:
//            ObjectReference

public class WeakObjectReference extends WeakReference
    implements ObjectReference
{

    public WeakObjectReference(Object obj)
    {
        super(obj);
    }
}
