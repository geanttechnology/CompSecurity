// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.ref;


// Referenced classes of package com.amazon.ansel.fetch.tools.ref:
//            ObjectReference

public class StrongObjectReference
    implements ObjectReference
{

    private final Object reference;

    public StrongObjectReference(Object obj)
    {
        reference = obj;
    }

    public Object get()
    {
        return reference;
    }
}
