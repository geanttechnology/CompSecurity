// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.commonscodecandroid;

import java.util.Comparator;

// Referenced classes of package com.comcast.cim.commonscodecandroid:
//            EncoderException, StringEncoder

public class StringEncoderComparator
    implements Comparator
{

    private final StringEncoder stringEncoder = null;

    public StringEncoderComparator()
    {
    }

    public int compare(Object obj, Object obj1)
    {
        int i;
        try
        {
            i = ((Comparable)stringEncoder.encode(obj)).compareTo((Comparable)stringEncoder.encode(obj1));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return 0;
        }
        return i;
    }
}
