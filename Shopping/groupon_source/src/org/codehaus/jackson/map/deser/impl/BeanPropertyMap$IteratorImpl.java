// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.codehaus.jackson.map.deser.SettableBeanProperty;

// Referenced classes of package org.codehaus.jackson.map.deser.impl:
//            BeanPropertyMap

private static final class _nextBucketIndex
    implements Iterator
{

    private final _currentBucket _buckets[];
    private _currentBucket _currentBucket;
    private int _nextBucketIndex;

    public boolean hasNext()
    {
        return _currentBucket != null;
    }

    public volatile Object next()
    {
        return next();
    }

    public SettableBeanProperty next()
    {
        next next1 = _currentBucket;
        if (next1 == null)
        {
            throw new NoSuchElementException();
        }
        Object obj;
        int i;
        for (obj = next1._currentBucket; obj == null && _nextBucketIndex < _buckets.length; obj = obj[i])
        {
            obj = _buckets;
            i = _nextBucketIndex;
            _nextBucketIndex = i + 1;
        }

        _currentBucket = ((_currentBucket) (obj));
        return next1._currentBucket;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public ( a[])
    {
        int i;
        int k;
        _buckets = a;
        k = _buckets.length;
        i = 0;
_L3:
        int j;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        a = _buckets;
        j = i + 1;
        a = a[i];
        if (a == null) goto _L2; else goto _L1
_L1:
        _currentBucket = a;
_L4:
        _nextBucketIndex = j;
        return;
_L2:
        i = j;
          goto _L3
        j = i;
          goto _L4
    }
}
