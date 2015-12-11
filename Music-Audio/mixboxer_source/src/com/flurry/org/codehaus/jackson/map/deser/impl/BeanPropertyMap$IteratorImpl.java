// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.impl;

import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.impl:
//            BeanPropertyMap

private static final class _nextBucketIndex
    implements Iterator
{

    private final next _buckets[];
    private next _currentBucket;
    private int _nextBucketIndex;

    public boolean hasNext()
    {
        return _currentBucket != null;
    }

    public SettableBeanProperty next()
    {
        _currentBucket _lcurrentbucket = _currentBucket;
        if (_lcurrentbucket == null)
        {
            throw new NoSuchElementException();
        }
        Object obj;
        int i;
        for (obj = _lcurrentbucket._currentBucket; obj == null && _nextBucketIndex < _buckets.length; obj = obj[i])
        {
            obj = _buckets;
            i = _nextBucketIndex;
            _nextBucketIndex = i + 1;
        }

        _currentBucket = ((_currentBucket) (obj));
        return _lcurrentbucket._currentBucket;
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public Q(Q aq[])
    {
        int i;
        int k;
        _buckets = aq;
        k = _buckets.length;
        i = 0;
_L3:
        int j;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        aq = _buckets;
        j = i + 1;
        aq = aq[i];
        if (aq == null) goto _L2; else goto _L1
_L1:
        _currentBucket = aq;
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
