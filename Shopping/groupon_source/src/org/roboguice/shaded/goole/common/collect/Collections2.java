// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import org.roboguice.shaded.goole.common.base.Joiner;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            CollectPreconditions

public final class Collections2
{

    static final Joiner STANDARD_JOINER = Joiner.on(", ").useForNull("null");

    static Collection cast(Iterable iterable)
    {
        return (Collection)iterable;
    }

    static StringBuilder newStringBuilderForCollection(int i)
    {
        CollectPreconditions.checkNonnegative(i, "size");
        return new StringBuilder((int)Math.min((long)i * 8L, 0x40000000L));
    }

    static boolean safeContains(Collection collection, Object obj)
    {
        Preconditions.checkNotNull(collection);
        boolean flag;
        try
        {
            flag = collection.contains(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (Collection collection)
        {
            return false;
        }
        return flag;
    }

}
