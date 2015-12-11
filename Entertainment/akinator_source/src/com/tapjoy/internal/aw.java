// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            at, au

public abstract class aw
    implements at
{

    public aw()
    {
    }

    protected abstract au a(Object obj, boolean flag);

    public final Object a(Object obj)
    {
        obj = a(obj, false);
        if (obj != null)
        {
            return ((au) (obj)).a();
        } else
        {
            return null;
        }
    }

    public void a(Object obj, Object obj1)
    {
        a(obj, true).a(obj1);
    }
}
