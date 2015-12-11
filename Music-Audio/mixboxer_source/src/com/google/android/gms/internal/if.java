// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

// Referenced classes of package com.google.android.gms.internal:
//            id, ie

public final class if extends b
    implements Moment
{

    private id Fo;

    public if(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private id fu()
    {
        this;
        JVM INSTR monitorenter ;
        if (Fo == null)
        {
            byte abyte0[] = getByteArray("momentImpl");
            Parcel parcel = Parcel.obtain();
            parcel.unmarshall(abyte0, 0, abyte0.length);
            parcel.setDataPosition(0);
            Fo = id.CREATOR.at(parcel);
            parcel.recycle();
        }
        this;
        JVM INSTR monitorexit ;
        return Fo;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object freeze()
    {
        return ft();
    }

    public id ft()
    {
        return fu();
    }

    public String getId()
    {
        return fu().getId();
    }

    public ItemScope getResult()
    {
        return fu().getResult();
    }

    public String getStartDate()
    {
        return fu().getStartDate();
    }

    public ItemScope getTarget()
    {
        return fu().getTarget();
    }

    public String getType()
    {
        return fu().getType();
    }

    public boolean hasId()
    {
        return fu().hasId();
    }

    public boolean hasResult()
    {
        return fu().hasId();
    }

    public boolean hasStartDate()
    {
        return fu().hasStartDate();
    }

    public boolean hasTarget()
    {
        return fu().hasTarget();
    }

    public boolean hasType()
    {
        return fu().hasType();
    }
}
