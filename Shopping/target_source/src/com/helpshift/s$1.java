// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import com.helpshift.i.h;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            s

class init>
    implements Comparator
{

    final s a;

    public int a(HashMap hashmap, HashMap hashmap1)
    {
        int i;
        try
        {
            i = h.a.parse(hashmap.get("created_at").toString()).compareTo(h.a.parse(hashmap1.get("created_at").toString()));
        }
        // Misplaced declaration of an exception variable
        catch (HashMap hashmap)
        {
            return 0;
        }
        return i;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((HashMap)obj, (HashMap)obj1);
    }

    n(s s1)
    {
        a = s1;
        super();
    }
}
