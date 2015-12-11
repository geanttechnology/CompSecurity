// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.util.List;

// Referenced classes of package com.google.c.a.a:
//            j, q, i

public final class r extends j
{

    public r()
    {
    }

    private static String a(CharSequence charsequence, String s)
    {
        charsequence = q.b(charsequence, s);
        if (charsequence == null || charsequence.isEmpty())
        {
            return null;
        } else
        {
            return (String)charsequence.get(0);
        }
    }

    protected final i a()
    {
        return i.h;
    }

    public final boolean a(String s)
    {
        String s2;
        s2 = c(s);
        break MISSING_BLOCK_LABEL_6;
        while (true) 
        {
            do
            {
                return false;
            } while (s2.indexOf("BEGIN:VEVENT") < 0 || a("DTSTART", s2) == null);
            Object obj = q.a("ATTENDEE", s2);
            if (obj == null || ((List) (obj)).isEmpty())
            {
                s = null;
            } else
            {
                int i1 = ((List) (obj)).size();
                s = new String[i1];
                int l = 0;
                while (l < i1) 
                {
                    s[l] = (String)((List)((List) (obj)).get(l)).get(0);
                    l++;
                }
            }
            if (s != null)
            {
                int k = 0;
label0:
                do
                {
label1:
                    {
                        if (k >= s.length)
                        {
                            break label0;
                        }
                        String s1 = s[k];
                        obj = s1;
                        if (s1 == null)
                        {
                            break label1;
                        }
                        if (!s1.startsWith("mailto:"))
                        {
                            obj = s1;
                            if (!s1.startsWith("MAILTO:"))
                            {
                                break label1;
                            }
                        }
                        obj = s1.substring(7);
                    }
                    s[k] = obj;
                    k++;
                } while (true);
            }
            s = a("GEO", s2);
            if (s == null || s.indexOf(';') >= 0)
            {
                return true;
            }
        }
    }
}
