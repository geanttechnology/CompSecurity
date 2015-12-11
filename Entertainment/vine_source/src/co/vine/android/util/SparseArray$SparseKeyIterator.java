// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import java.util.Iterator;

// Referenced classes of package co.vine.android.util:
//            SparseArray

public class this._cls0
    implements Iterator
{

    public int index;
    final SparseArray this$0;

    public boolean hasNext()
    {
        return index < size();
    }

    public Integer next()
    {
        index = index + 1;
        return Integer.valueOf(keyAt(index - 1));
    }

    public volatile Object next()
    {
        return next();
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    public ()
    {
        this$0 = SparseArray.this;
        super();
    }
}
