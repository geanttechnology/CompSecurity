// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import java.util.Queue;

// Referenced classes of package com.facebook.imagepipeline.memory:
//            Bucket

class OOMSoftReferenceBucket extends Bucket
{

    private LinkedList mSpareReferences;

    public OOMSoftReferenceBucket(int i, int j, int k)
    {
        super(i, j, k);
        mSpareReferences = new LinkedList();
    }

    void addToFreeList(Object obj)
    {
        OOMSoftReference oomsoftreference1 = (OOMSoftReference)mSpareReferences.poll();
        OOMSoftReference oomsoftreference = oomsoftreference1;
        if (oomsoftreference1 == null)
        {
            oomsoftreference = new OOMSoftReference();
        }
        oomsoftreference.set(obj);
        mFreeList.add(oomsoftreference);
    }

    public Object pop()
    {
        OOMSoftReference oomsoftreference = (OOMSoftReference)mFreeList.poll();
        Object obj = oomsoftreference.get();
        oomsoftreference.clear();
        mSpareReferences.add(oomsoftreference);
        return obj;
    }
}
