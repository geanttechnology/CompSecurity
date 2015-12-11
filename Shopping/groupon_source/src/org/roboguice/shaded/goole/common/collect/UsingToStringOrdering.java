// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering

final class UsingToStringOrdering extends Ordering
    implements Serializable
{

    static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();

    private UsingToStringOrdering()
    {
    }

    public int compare(Object obj, Object obj1)
    {
        return obj.toString().compareTo(obj1.toString());
    }

    public String toString()
    {
        return "Ordering.usingToString()";
    }

}
