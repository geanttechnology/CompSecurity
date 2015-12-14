// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import java.util.concurrent.FutureTask;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

private static final class mRunnable extends FutureTask
    implements Comparable
{

    private final mp mRunnable;

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public int compareTo(compareTo compareto)
    {
        compareTo compareto1 = mRunnable.tItemRequest();
        compareto = compareto.mRunnable.tItemRequest();
        if (compareto1.w != null && ((w) (compareto)).w == null)
        {
            return -1;
        }
        if (compareto1.w == null && ((w) (compareto)).w != null)
        {
            return 1;
        }
        if (!compareto1.t.equals(((t) (compareto)).t))
        {
            return compareto1.t.compareTo(((t) (compareto)).t);
        } else
        {
            return compareto1.mp.compareTo(((mp) (compareto)).mp);
        }
    }

    public ( )
    {
        super(, null);
        mRunnable = ;
    }
}
