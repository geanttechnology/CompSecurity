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

public class opeEntity
{

    private String zzAV;
    private String zzGM;
    private String zzaAq;
    private ItemScopeEntity zzaAy;
    private ItemScopeEntity zzaAz;
    private final Set zzazD = new HashSet();

    public Moment build()
    {
        return new MomentEntity(zzazD, zzGM, zzaAy, zzaAq, zzaAz, zzAV);
    }

    public zzAV setId(String s)
    {
        zzGM = s;
        zzazD.add(Integer.valueOf(2));
        return this;
    }

    public zzazD setResult(ItemScope itemscope)
    {
        zzaAy = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(4));
        return this;
    }

    public zzazD setStartDate(String s)
    {
        zzaAq = s;
        zzazD.add(Integer.valueOf(5));
        return this;
    }

    public zzazD setTarget(ItemScope itemscope)
    {
        zzaAz = (ItemScopeEntity)itemscope;
        zzazD.add(Integer.valueOf(6));
        return this;
    }

    public zzazD setType(String s)
    {
        zzAV = s;
        zzazD.add(Integer.valueOf(7));
        return this;
    }

    public opeEntity()
    {
    }
}
