// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.util;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.userfeedback.android.api.common.util:
//            IntMap

public class higherKeyEnumerator
{

    private int currentKey;
    private Enumeration higherKeyEnumerator;
    private int oneAheadIndex;
    final IntMap this$0;

    public boolean hasNext()
    {
        if (currentKey != 0x80000000)
        {
            return true;
        }
        if (oneAheadIndex <= IntMap.access$000(IntMap.this))
        {
            for (; oneAheadIndex <= IntMap.access$000(IntMap.this); oneAheadIndex = oneAheadIndex + 1)
            {
                if (IntMap.access$100(IntMap.this)[oneAheadIndex] != null)
                {
                    int i = oneAheadIndex;
                    oneAheadIndex = i + 1;
                    currentKey = i;
                    return true;
                }
            }

        }
        if (IntMap.access$200(IntMap.this) != null)
        {
            if (higherKeyEnumerator == null)
            {
                higherKeyEnumerator = IntMap.access$200(IntMap.this).keys();
            }
            if (higherKeyEnumerator.hasMoreElements())
            {
                currentKey = ((Integer)higherKeyEnumerator.nextElement()).intValue();
                return true;
            }
        }
        return false;
    }

    public int next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            int i = currentKey;
            currentKey = 0x80000000;
            return i;
        }
    }

    public ()
    {
        this$0 = IntMap.this;
        super();
        oneAheadIndex = 0;
        currentKey = 0x80000000;
        higherKeyEnumerator = null;
    }
}
