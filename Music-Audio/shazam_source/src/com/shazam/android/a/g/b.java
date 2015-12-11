// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.g;

import com.shazam.model.search.SearchSection;
import java.util.List;

// Referenced classes of package com.shazam.android.a.g:
//            c

public final class b
    implements c
{

    private final List a;
    private final List b;

    public b(List list, List list1)
    {
        a = list;
        b = list1;
    }

    public final SearchSection a(int i)
    {
        for (int j = 0; j < a.size(); j++)
        {
            if (i <= ((Integer)a.get(j)).intValue())
            {
                return (SearchSection)b.get(j);
            }
        }

        return null;
    }
}
