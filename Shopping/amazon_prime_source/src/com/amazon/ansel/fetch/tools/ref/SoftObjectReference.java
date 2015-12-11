// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.ref;

import java.lang.ref.SoftReference;

// Referenced classes of package com.amazon.ansel.fetch.tools.ref:
//            ObjectReference

public class SoftObjectReference extends SoftReference
    implements ObjectReference
{

    public SoftObjectReference(Object obj)
    {
        super(obj);
    }
}
