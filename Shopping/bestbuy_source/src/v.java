// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class v
{

    private final List a = new ArrayList();

    public v()
    {
    }

    private static Long a(String s)
    {
        long l;
        try
        {
            s = Long.valueOf(s);
            l = s.longValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
label0:
        {
            if (l >= 0L)
            {
                return s;
            }
            break label0;
        }
    }

    private static String b(String s)
    {
        try
        {
            s = URLDecoder.decode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }

    public final t a()
    {
        Collections.sort(a);
        ArrayList arraylist = new ArrayList();
        long l = -1L;
        long l1 = -1L;
        Iterator iterator = a.iterator();
        String s2 = null;
        String s = null;
        String s1 = null;
        boolean flag = false;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String as[] = w.a((w)iterator.next()).split(":");
            if (as.length == 2)
            {
                if ("btERT".equalsIgnoreCase(as[0]))
                {
                    l = a(as[1]).longValue();
                } else
                if ("btDuration".equalsIgnoreCase(as[0]))
                {
                    l1 = a(as[1]).longValue();
                } else
                if ("btId".equalsIgnoreCase(as[0]))
                {
                    long l3 = l1;
                    long l2 = l;
                    if (s2 != null)
                    {
                        arraylist.add(new u(s2, Long.valueOf(l), Long.valueOf(l1)));
                        l2 = -1L;
                        l3 = -1L;
                    }
                    s2 = as[1];
                    l1 = l3;
                    l = l2;
                } else
                if ("clientRequestGUID".equalsIgnoreCase(as[0]))
                {
                    s = as[1];
                } else
                if ("serverSnapshotType".equalsIgnoreCase(as[0]))
                {
                    s1 = as[1];
                } else
                if ("hasEntryPointErrors".equalsIgnoreCase(as[0]))
                {
                    flag = true;
                }
            }
        } while (true);
        if (s2 != null)
        {
            arraylist.add(new u(s2, Long.valueOf(l), Long.valueOf(l1)));
        }
        s2 = s;
        if (s == null)
        {
            s2 = UUID.randomUUID().toString();
        }
        return new t(s2, s1, arraylist, flag);
    }

    public final void a(String s, List list)
    {
        if (s != null && list.size() == 1)
        {
            s = s.split("_");
            if (s.length == 2 && "ADRUM".equalsIgnoreCase(s[0]))
            {
                s = a(s[1]);
                if (s != null)
                {
                    s = new w(s, b((String)list.get(0)), (byte)0);
                    a.add(s);
                }
            }
        }
    }
}
