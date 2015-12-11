// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.AvroRemoteException;
import com.flurry.org.apache.avro.Schema;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificRecord, SpecificData

public abstract class SpecificExceptionBase extends AvroRemoteException
    implements SpecificRecord
{

    public SpecificExceptionBase()
    {
    }

    public SpecificExceptionBase(Object obj)
    {
        super(obj);
    }

    public SpecificExceptionBase(Object obj, Throwable throwable)
    {
        super(obj, throwable);
    }

    public SpecificExceptionBase(Throwable throwable)
    {
        super(throwable);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof SpecificExceptionBase))
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            if (SpecificData.get().compare(this, obj, getSchema()) != 0)
            {
                return false;
            }
        }
        return true;
    }

    public abstract Object get(int i);

    public abstract Schema getSchema();

    public int hashCode()
    {
        return SpecificData.get().hashCode(this, getSchema());
    }

    public abstract void put(int i, Object obj);
}
