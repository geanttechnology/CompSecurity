// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            ImmutableCollection

public static abstract class 
{

    public abstract  add(Object obj);

    public transient  add(Object aobj[])
    {
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            add(aobj[i]);
        }

        return this;
    }

    ()
    {
    }
}
