// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.internal.model.moments.zzc;

// Referenced classes of package com.google.android.gms.plus.model.moments:
//            Moment

public final class MomentBuffer extends AbstractDataBuffer
{

    public MomentBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    public Moment get(int i)
    {
        return new zzc(zzYX, i);
    }

    public volatile Object get(int i)
    {
        return get(i);
    }
}
