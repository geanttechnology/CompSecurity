// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.utils;


// Referenced classes of package com.amazon.clouddrive.utils:
//            Optional

private static final class <init> extends Optional
{

    private final Object item;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        obj = (<init>)obj;
        if (item == null) goto _L4; else goto _L3
_L3:
        if (item.equals(((item) (obj)).item)) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (((item) (obj)).item == null)
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public Object get()
    {
        return item;
    }

    public int hashCode()
    {
        if (item != null)
        {
            return item.hashCode();
        } else
        {
            return 0;
        }
    }

    private (Object obj)
    {
        super(true);
        item = obj;
    }

    item(Object obj, item item1)
    {
        this(obj);
    }
}
