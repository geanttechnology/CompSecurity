// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.w;
import java.util.Set;

public final class iq
{

    public static String[] a(Set set)
    {
        w.a(set, "scopes can't be null.");
        set = (Scope[])set.toArray(new Scope[set.size()]);
        w.a(set, "scopes can't be null.");
        String as[] = new String[set.length];
        for (int i = 0; i < set.length; i++)
        {
            as[i] = ((Scope) (set[i])).b;
        }

        return as;
    }
}
