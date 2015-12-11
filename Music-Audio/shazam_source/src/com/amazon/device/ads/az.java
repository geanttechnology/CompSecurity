// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.amazon.device.ads:
//            dq

final class az
{

    public static final List a = Collections.unmodifiableList(new ArrayList() {

            
            {
                add("yyyy-MM-dd'T'HH:mmZZZZZ");
                add("yyyy-MM-dd'T'HH:mmZ");
                add("yyyy-MM-dd'T'HH:mm");
                add("yyyy-MM-dd");
            }
    });
    String b;
    String c;
    String d;
    Date e;
    Date f;

    public az(String s, String s1, String s2, String s3, String s4)
    {
        if (dq.a(s))
        {
            throw new IllegalArgumentException("No description for event");
        }
        b = s;
        c = s1;
        d = s2;
        if (dq.a(s3))
        {
            throw new IllegalArgumentException("No start date for event");
        }
        e = a(s3);
        if (dq.a(s4))
        {
            f = null;
            return;
        } else
        {
            f = a(s4);
            return;
        }
    }

    private static Date a(String s)
    {
        Iterator iterator = a.iterator();
_L1:
        Object obj;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_78;
        }
        obj = (String)iterator.next();
        obj = (new SimpleDateFormat(((String) (obj)), Locale.US)).parse(s);
_L2:
        if (obj == null)
        {
            throw new IllegalArgumentException((new StringBuilder("Could not parse datetime string ")).append(s).toString());
        } else
        {
            return ((Date) (obj));
        }
        obj;
          goto _L1
        obj = null;
          goto _L2
    }

}
