// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;


// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            CachedCommand

public static interface Exception
{

    public abstract Object fromString(String s)
        throws Exception;

    public abstract String toString(Object obj);
}
