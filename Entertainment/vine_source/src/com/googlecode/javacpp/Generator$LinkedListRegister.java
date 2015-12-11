// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.googlecode.javacpp;

import java.util.LinkedList;

// Referenced classes of package com.googlecode.javacpp:
//            Generator

public static class _cls9 extends LinkedList
{

    public int register(Object obj)
    {
        int j = indexOf(obj);
        int i = j;
        if (j < 0)
        {
            add(obj);
            i = size() - 1;
        }
        return i;
    }

    public _cls9()
    {
    }
}
