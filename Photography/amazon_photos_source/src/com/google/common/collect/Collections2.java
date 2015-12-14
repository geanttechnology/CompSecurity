// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Joiner;
import java.util.Collection;

public final class Collections2
{

    static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

    static boolean safeContains(Collection collection, Object obj)
    {
        boolean flag;
        try
        {
            flag = collection.contains(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return false;
        }
        return flag;
    }

}
