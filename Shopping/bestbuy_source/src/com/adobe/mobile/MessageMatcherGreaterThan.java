// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.adobe.mobile:
//            MessageMatcher

final class MessageMatcherGreaterThan extends MessageMatcher
{

    MessageMatcherGreaterThan()
    {
    }

    protected boolean matches(Object obj)
    {
        obj = tryParseDouble(obj);
        if (obj == null)
        {
            return false;
        }
        for (Iterator iterator = values.iterator(); iterator.hasNext();)
        {
            Object obj1 = iterator.next();
            if ((obj1 instanceof Number) && ((Double) (obj)).doubleValue() > ((Number)obj1).doubleValue())
            {
                return true;
            }
        }

        return false;
    }
}
