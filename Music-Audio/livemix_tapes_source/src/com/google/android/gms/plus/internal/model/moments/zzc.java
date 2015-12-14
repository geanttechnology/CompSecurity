// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.plus.internal.model.moments:
//            MomentEntity, zzb

public final class zzc extends com.google.android.gms.common.data.zzc
    implements Moment
{

    private MomentEntity zzaMQ;

    public zzc(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private MomentEntity zzyW()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaMQ == null)
        {
            byte abyte0[] = getByteArray("momentImpl");
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(abyte0, 0, abyte0.length);
            parcel.setDataPosition(0);
            zzaMQ = MomentEntity.CREATOR.zzfU(parcel);
            parcel.recycle();
        }
        this;
        JVM INSTR monitorexit ;
        return zzaMQ;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object freeze()
    {
        return zzyV();
    }

    public String getId()
    {
        return zzyW().getId();
    }

    public ItemScope getResult()
    {
        return zzyW().getResult();
    }

    public String getStartDate()
    {
        return zzyW().getStartDate();
    }

    public ItemScope getTarget()
    {
        return zzyW().getTarget();
    }

    public String getType()
    {
        return zzyW().getType();
    }

    public boolean hasId()
    {
        return zzyW().hasId();
    }

    public boolean hasResult()
    {
        return zzyW().hasResult();
    }

    public boolean hasStartDate()
    {
        return zzyW().hasStartDate();
    }

    public boolean hasTarget()
    {
        return zzyW().hasTarget();
    }

    public boolean hasType()
    {
        return zzyW().hasType();
    }

    public MomentEntity zzyV()
    {
        return zzyW();
    }
}
