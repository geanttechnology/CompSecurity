// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            Moment, ItemScope

public static class opeEntity
{

    private String zzFz;
    private final Set zzaLT = new HashSet();
    private String zzaMG;
    private ItemScopeEntity zzaMO;
    private ItemScopeEntity zzaMP;
    private String zzwj;

    public Moment build()
    {
        return new MomentEntity(zzaLT, zzwj, zzaMO, zzaMG, zzaMP, zzFz);
    }

    public zzFz setId(String s)
    {
        zzwj = s;
        zzaLT.add(Integer.valueOf(2));
        return this;
    }

    public zzaLT setResult(ItemScope itemscope)
    {
        zzaMO = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(4));
        return this;
    }

    public zzaLT setStartDate(String s)
    {
        zzaMG = s;
        zzaLT.add(Integer.valueOf(5));
        return this;
    }

    public zzaLT setTarget(ItemScope itemscope)
    {
        zzaMP = (ItemScopeEntity)itemscope;
        zzaLT.add(Integer.valueOf(6));
        return this;
    }

    public zzaLT setType(String s)
    {
        zzFz = s;
        zzaLT.add(Integer.valueOf(7));
        return this;
    }

    public opeEntity()
    {
    }
}
