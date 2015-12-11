// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Build;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class cnf
{

    private final Map a;

    public cnf(String s, String s1, cng cng1, cnh cnh1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("cplatform", ((cng)b.a(cng1)).d);
        hashmap.put("c", ((cnh)b.a(cnh1)).c);
        hashmap.put("cver", b.a(s1));
        hashmap.put("cos", "Android");
        hashmap.put("cosver", android.os.Build.VERSION.RELEASE);
        hashmap.put("cbr", b.a(s));
        hashmap.put("cbrver", s1);
        hashmap.put("cbrand", Build.MANUFACTURER);
        hashmap.put("cmodel", Build.MODEL);
        a = Collections.unmodifiableMap(hashmap);
    }

    public final bnf a(bnf bnf1)
    {
        b.a(bnf1);
        java.util.Map.Entry entry;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); bnf1.a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return bnf1;
    }
}
