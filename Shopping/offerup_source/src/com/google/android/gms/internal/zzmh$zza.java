// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Iterator;

// Referenced classes of package com.google.android.gms.internal:
//            zzmh

final class etSize
    implements Iterator
{

    boolean mCanRemove;
    int mIndex;
    final int mOffset;
    int mSize;
    final zzmh zzagL;

    public final boolean hasNext()
    {
        return mIndex < mSize;
    }

    public final Object next()
    {
        Object obj = zzagL.colGetEntry(mIndex, mOffset);
        mIndex = mIndex + 1;
        mCanRemove = true;
        return obj;
    }

    public final void remove()
    {
        if (!mCanRemove)
        {
            throw new IllegalStateException();
        } else
        {
            mIndex = mIndex - 1;
            mSize = mSize - 1;
            mCanRemove = false;
            zzagL.colRemoveAt(mIndex);
            return;
        }
    }

    (zzmh zzmh1, int i)
    {
        zzagL = zzmh1;
        super();
        mCanRemove = false;
        mOffset = i;
        mSize = zzmh1.colGetSize();
    }
}
