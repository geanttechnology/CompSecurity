// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class in
{

    private final Bundle a;
    private List b;

    in(Bundle bundle, List list)
    {
        a = bundle;
        b = list;
    }

    public static in a(Bundle bundle)
    {
        if (bundle != null)
        {
            return new in(bundle, null);
        } else
        {
            return null;
        }
    }

    private void c()
    {
        if (b == null)
        {
            ArrayList arraylist = a.getParcelableArrayList("routes");
            if (arraylist == null || arraylist.isEmpty())
            {
                b = Collections.emptyList();
            } else
            {
                int j = arraylist.size();
                b = new ArrayList(j);
                int i = 0;
                while (i < j) 
                {
                    List list = b;
                    Object obj = (Bundle)arraylist.get(i);
                    if (obj != null)
                    {
                        obj = new if(((Bundle) (obj)), null);
                    } else
                    {
                        obj = null;
                    }
                    list.add(obj);
                    i++;
                }
            }
        }
    }

    public final List a()
    {
        c();
        return b;
    }

    public final boolean b()
    {
        c();
        int j = b.size();
        for (int i = 0; i < j; i++)
        {
            if if1 = (if)b.get(i);
            if (if1 == null || !if1.o())
            {
                return false;
            }
        }

        return true;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("MediaRouteProviderDescriptor{ ");
        stringbuilder.append("routes=").append(Arrays.toString(a().toArray()));
        stringbuilder.append(", isValid=").append(b());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }
}
