// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.d:
//            jy

public final class kd
{

    public final List a = new ArrayList();

    public kd()
    {
    }

    public final kd a(jy jy1)
    {
        w.a(jy1);
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((jy)iterator.next()).a.equals(jy1.a))
            {
                throw new IllegalArgumentException((new StringBuilder("The container is already being requested. ")).append(jy1.a).toString());
            }
        }

        a.add(jy1);
        return this;
    }

    public final String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = a.iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            jy jy1 = (jy)iterator.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("#");
            }
            stringbuilder.append(jy1.a);
        }
        return stringbuilder.toString();
    }
}
