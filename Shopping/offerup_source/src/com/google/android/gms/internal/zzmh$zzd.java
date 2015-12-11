// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh, zzmf

final class mIndex
    implements Iterator, java.util.
{

    int mEnd;
    boolean mEntryValid;
    int mIndex;
    final zzmh zzagL;

    public final boolean equals(Object obj)
    {
        if (!mEntryValid)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        if (obj instanceof java.util.)
        {
            if (zzmf.equal(((java.util.) (obj = (java.util.)obj)).getKey(), zzagL.colGetEntry(mIndex, 0)) && zzmf.equal(((java.util.) (obj)).getValue(), zzagL.colGetEntry(mIndex, 1)))
            {
                return true;
            }
        }
        return false;
    }

    public final Object getKey()
    {
        if (!mEntryValid)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return zzagL.colGetEntry(mIndex, 0);
        }
    }

    public final Object getValue()
    {
        if (!mEntryValid)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return zzagL.colGetEntry(mIndex, 1);
        }
    }

    public final boolean hasNext()
    {
        return mIndex < mEnd;
    }

    public final int hashCode()
    {
        int j = 0;
        if (!mEntryValid)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        Object obj = zzagL.colGetEntry(mIndex, 0);
        Object obj1 = zzagL.colGetEntry(mIndex, 1);
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        if (obj1 != null)
        {
            j = obj1.hashCode();
        }
        return j ^ i;
    }

    public final volatile Object next()
    {
        return next();
    }

    public final java.util. next()
    {
        mIndex = mIndex + 1;
        mEntryValid = true;
        return this;
    }

    public final void remove()
    {
        if (!mEntryValid)
        {
            throw new IllegalStateException();
        } else
        {
            zzagL.colRemoveAt(mIndex);
            mIndex = mIndex - 1;
            mEnd = mEnd - 1;
            mEntryValid = false;
            return;
        }
    }

    public final Object setValue(Object obj)
    {
        if (!mEntryValid)
        {
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        } else
        {
            return zzagL.colSetValue(mIndex, obj);
        }
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getKey()).append("=").append(getValue()).toString();
    }

    (zzmh zzmh1)
    {
        zzagL = zzmh1;
        super();
        mEntryValid = false;
        mEnd = zzmh1.colGetSize() - 1;
        mIndex = -1;
    }
}
