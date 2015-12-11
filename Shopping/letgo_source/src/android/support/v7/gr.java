// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            iu, gi

public class gr
{

    private final gi a;
    private final iu b;
    private final int c;

    public gr(gi gi1, iu iu1, int i)
    {
        a = gi1;
        b = iu1;
        c = i;
    }

    protected String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append(list.get(i));
            if (i < list.size() - 1)
            {
                stringbuilder.append(",");
            }
        }

        return stringbuilder.toString();
    }

    protected Map a(List list, int i, String s, int j)
    {
        HashMap hashmap = new HashMap();
        if (list == null) goto _L2; else goto _L1
_L1:
        list = a(list);
        if (list.isEmpty()) goto _L2; else goto _L3
_L3:
        hashmap.put("category-id", list);
        hashmap.put("page-number", String.valueOf(i / j));
        if (s != null && !s.isEmpty())
        {
            hashmap.put("search-keyword", s);
        }
        return hashmap;
_L2:
        list = String.valueOf(0);
        if (true) goto _L3; else goto _L4
_L4:
    }

    public void a(Context context, ParseUser parseuser, List list, int i, String s)
    {
        s = a(list, i, s, c);
        if (b.b(parseuser))
        {
            list = "dummy-product-list";
        } else
        {
            list = "product-list";
        }
        a.a(context, list, s, parseuser);
    }
}
