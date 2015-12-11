// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package android.support.v7:
//            xa

public class xf
{

    private final List a = new ArrayList();

    public xf()
    {
    }

    public xf a(xa xa1)
        throws IllegalArgumentException
    {
        x.a(xa1);
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (((xa)iterator.next()).a().equals(xa1.a()))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("The container is already being requested. ").append(xa1.a()).toString());
            }
        }

        a.add(xa1);
        return this;
    }

    public List a()
    {
        return a;
    }

    public String b()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = a.iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            xa xa1 = (xa)iterator.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("#");
            }
            stringbuilder.append(xa1.a());
        }
        return stringbuilder.toString();
    }
}
