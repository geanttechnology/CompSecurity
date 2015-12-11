// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.internal.ib;
import com.google.android.gms.internal.id;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            Moment, ItemScope

public static class 
{

    private String AI;
    private final Set Eq = new HashSet();
    private String Fe;
    private ib Fm;
    private ib Fn;
    private String uS;

    public Moment build()
    {
        return new id(Eq, uS, Fm, Fe, Fn, AI);
    }

    public AI setId(String s)
    {
        uS = s;
        Eq.add(Integer.valueOf(2));
        return this;
    }

    public Eq setResult(ItemScope itemscope)
    {
        Fm = (ib)itemscope;
        Eq.add(Integer.valueOf(4));
        return this;
    }

    public Eq setStartDate(String s)
    {
        Fe = s;
        Eq.add(Integer.valueOf(5));
        return this;
    }

    public Eq setTarget(ItemScope itemscope)
    {
        Fn = (ib)itemscope;
        Eq.add(Integer.valueOf(6));
        return this;
    }

    public Eq setType(String s)
    {
        AI = s;
        Eq.add(Integer.valueOf(7));
        return this;
    }

    public ()
    {
    }
}
