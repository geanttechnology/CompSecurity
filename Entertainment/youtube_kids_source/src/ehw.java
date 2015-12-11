// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

class ehw extends egx
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final Object a;
    private final Object b;

    ehw(Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }

    public Object getKey()
    {
        return a;
    }

    public Object getValue()
    {
        return b;
    }

    public final Object setValue(Object obj)
    {
        throw new UnsupportedOperationException();
    }
}
