// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import com.mopub.common.c.a;
import com.mopub.common.m;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.mopub.mobileads:
//            ab

public final class ac
{

    public final Map a = new HashMap();
    private final List b;

    public ac(List list)
    {
        m.a(list, "uris cannot be null");
        b = list;
        a.put(ab.c, String.format(Locale.US, "%08d", new Object[] {
            Long.valueOf(Math.round(Math.random() * 100000000D))
        }));
    }

    public final ac a(Integer integer)
    {
        if (integer != null)
        {
            int i = integer.intValue();
            integer = String.format("%02d:%02d:%02d.%03d", new Object[] {
                Long.valueOf(TimeUnit.MILLISECONDS.toHours(i)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(i) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(i) % TimeUnit.MINUTES.toSeconds(1L)), Integer.valueOf(i % 1000)
            });
            if (!TextUtils.isEmpty(integer))
            {
                a.put(ab.b, integer);
            }
        }
        return this;
    }

    public final ac a(String s)
    {
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1 = URLEncoder.encode(s, "UTF-8");
        s = s1;
_L4:
        a.put(ab.d, s);
_L2:
        return this;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        com.mopub.common.c.a.c("Failed to encode url", unsupportedencodingexception);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final List a()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!TextUtils.isEmpty(s))
            {
                ab aab[] = ab.values();
                int j = aab.length;
                for (int i = 0; i < j; i++)
                {
                    ab ab1 = aab[i];
                    String s2 = (String)a.get(ab1);
                    String s1 = s2;
                    if (s2 == null)
                    {
                        s1 = "";
                    }
                    s = s.replaceAll((new StringBuilder("\\[")).append(ab1.name()).append("\\]").toString(), s1);
                }

                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }
}
