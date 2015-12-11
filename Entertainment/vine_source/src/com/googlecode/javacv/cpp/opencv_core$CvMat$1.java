// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacv.cpp;


// Referenced classes of package com.googlecode.javacv.cpp:
//            opencv_core

static final class val.type extends ThreadLocal
{

    final int val$cols;
    final int val$rows;
    final int val$type;

    protected val.type initialValue()
    {
        return eate(val$rows, val$cols, val$type);
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    (int i, int j, int k)
    {
        val$rows = i;
        val$cols = j;
        val$type = k;
        super();
    }
}
