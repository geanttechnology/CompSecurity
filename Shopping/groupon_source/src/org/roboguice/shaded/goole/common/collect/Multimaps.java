// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Map;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Multimap

public final class Multimaps
{

    static boolean equalsImpl(Multimap multimap, Object obj)
    {
        if (obj == multimap)
        {
            return true;
        }
        if (obj instanceof Multimap)
        {
            obj = (Multimap)obj;
            return multimap.asMap().equals(((Multimap) (obj)).asMap());
        } else
        {
            return false;
        }
    }
}
