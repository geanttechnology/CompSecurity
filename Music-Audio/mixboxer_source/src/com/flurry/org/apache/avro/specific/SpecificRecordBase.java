// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;

import com.flurry.org.apache.avro.Schema;

// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificRecord, SpecificData

public abstract class SpecificRecordBase
    implements SpecificRecord, Comparable
{

    public SpecificRecordBase()
    {
    }

    public int compareTo(SpecificRecord specificrecord)
    {
        return SpecificData.get().compare(this, specificrecord, getSchema());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((SpecificRecord)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof SpecificRecord))
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            if (compareTo((SpecificRecord)obj) != 0)
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

    public String toString()
    {
        return SpecificData.get().toString(this);
    }
}
