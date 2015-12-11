// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collection;
import java.util.Set;

final class egv extends egr
    implements Set
{

    private egi e;

    egv(egi egi1, Object obj, Set set)
    {
        e = egi1;
        super(egi1, obj, set, null);
    }

    public final boolean removeAll(Collection collection)
    {
        boolean flag;
        if (collection.isEmpty())
        {
            flag = false;
        } else
        {
            int i = size();
            boolean flag1 = a.a((Set)b, collection);
            flag = flag1;
            if (flag1)
            {
                int j = b.size();
                egi.a(e, j - i);
                b();
                return flag1;
            }
        }
        return flag;
    }
}
