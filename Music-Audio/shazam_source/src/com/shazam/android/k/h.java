// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k;

import android.content.Intent;
import com.shazam.b.a.d;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.k:
//            i

public final class h
{

    public static Intent a(List list, i j)
    {
        d.a(j);
        if (list == null)
        {
            return null;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            Intent intent = (Intent)list.next();
            if (j.a(intent))
            {
                return intent;
            }
        }

        return null;
    }
}
