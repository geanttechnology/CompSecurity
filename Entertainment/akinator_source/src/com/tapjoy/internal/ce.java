// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

// Referenced classes of package com.tapjoy.internal:
//            cd

public final class ce extends ReferenceQueue
{

    public ce()
    {
    }

    public final cd a()
    {
        return (cd)super.poll();
    }

    public final cd a(Object obj, Object obj1)
    {
        return new cd(obj, obj1, this);
    }

    public final volatile Reference poll()
    {
        return (cd)super.poll();
    }
}
