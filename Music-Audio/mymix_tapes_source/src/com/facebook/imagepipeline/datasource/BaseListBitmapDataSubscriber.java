// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber
{

    public BaseListBitmapDataSubscriber()
    {
    }

    public void onNewResultImpl(DataSource datasource)
    {
        if (datasource.isFinished()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        datasource = (List)datasource.getResult();
        if (datasource == null)
        {
            onNewResultListImpl(null);
            return;
        }
        Object obj;
        Iterator iterator;
        obj = new ArrayList(datasource.size());
        iterator = datasource.iterator();
_L3:
        CloseableReference closeablereference;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_151;
        }
        closeablereference = (CloseableReference)iterator.next();
        if (closeablereference == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        if (!(closeablereference.get() instanceof CloseableBitmap))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        ((List) (obj)).add(((CloseableBitmap)closeablereference.get()).getUnderlyingBitmap());
          goto _L3
        obj;
        for (datasource = datasource.iterator(); datasource.hasNext(); CloseableReference.closeSafely((CloseableReference)datasource.next())) { }
        break; /* Loop/switch isn't completed */
        ((List) (obj)).add(null);
          goto _L3
        onNewResultListImpl(((List) (obj)));
        datasource = datasource.iterator();
        while (datasource.hasNext()) 
        {
            CloseableReference.closeSafely((CloseableReference)datasource.next());
        }
        if (true) goto _L1; else goto _L4
_L4:
        throw obj;
    }

    protected abstract void onNewResultListImpl(List list);
}
