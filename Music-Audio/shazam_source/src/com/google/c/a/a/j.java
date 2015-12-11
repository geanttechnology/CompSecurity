// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import com.shazam.i.e.a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

// Referenced classes of package com.google.c.a.a:
//            e, c, g, b, 
//            q, d, r, f, 
//            m, n, k, l, 
//            h, s, p, o, 
//            i

public abstract class j
{

    private static final j a[] = {
        new e(), new c(), new g(), new b(), new q(), new d(), new r(), new f(), new m(), new n(), 
        new k(), new l(), new h(), new s(), new p(), new o()
    };
    private static final Pattern b = Pattern.compile("\\d+");
    private static final Pattern c = Pattern.compile("&");
    private static final Pattern d = Pattern.compile("=");

    public j()
    {
    }

    protected static int a(char c1)
    {
        if (c1 >= '0' && c1 <= '9')
        {
            return c1 - 48;
        }
        if (c1 >= 'a' && c1 <= 'f')
        {
            return (c1 - 97) + 10;
        }
        if (c1 >= 'A' && c1 <= 'F')
        {
            return (c1 - 65) + 10;
        } else
        {
            return -1;
        }
    }

    static String[] a(String s1, String s2, boolean flag)
    {
        int l1 = s2.length();
        int i1 = 0;
        Object obj = null;
        do
        {
            if (i1 >= l1)
            {
                break;
            }
            i1 = s2.indexOf(s1, i1);
            if (i1 < 0)
            {
                break;
            }
            int k1 = i1 + s1.length();
            boolean flag1 = true;
            i1 = k1;
            while (flag1) 
            {
                int i2 = s2.indexOf(';', i1);
                if (i2 < 0)
                {
                    i1 = s2.length();
                    flag1 = false;
                } else
                {
                    i1 = i2 - 1;
                    int j1 = 0;
                    for (; i1 >= 0 && s2.charAt(i1) == '\\'; i1--)
                    {
                        j1++;
                    }

                    if (j1 % 2 != 0)
                    {
                        i1 = i2 + 1;
                    } else
                    {
                        Object obj1 = obj;
                        if (obj == null)
                        {
                            obj1 = new ArrayList(3);
                        }
                        String s3 = b(s2.substring(k1, i2));
                        obj = s3;
                        if (flag)
                        {
                            obj = s3.trim();
                        }
                        if (!((String) (obj)).isEmpty())
                        {
                            ((List) (obj1)).add(obj);
                        }
                        i1 = i2 + 1;
                        flag1 = false;
                        obj = obj1;
                    }
                }
            }
        } while (true);
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return null;
        } else
        {
            return (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]);
        }
    }

    private static String b(String s1)
    {
        int i1 = s1.indexOf('\\');
        if (i1 < 0)
        {
            return s1;
        }
        int j1 = s1.length();
        StringBuilder stringbuilder = new StringBuilder(j1 - 1);
        stringbuilder.append(s1.toCharArray(), 0, i1);
        boolean flag = false;
        while (i1 < j1) 
        {
            char c1 = s1.charAt(i1);
            if (flag || c1 != '\\')
            {
                stringbuilder.append(c1);
                flag = false;
            } else
            {
                flag = true;
            }
            i1++;
        }
        return stringbuilder.toString();
    }

    protected static String c(String s1)
    {
        String s2 = s1;
        if (s1.startsWith("\uFEFF"))
        {
            s2 = s1.substring(1);
        }
        return s2;
    }

    public static i d(String s1)
    {
        j aj[] = a;
        int k1 = aj.length;
        for (int i1 = 0; i1 < k1; i1++)
        {
            j j1 = aj[i1];
            if (j1.a(s1))
            {
                return j1.a();
            }
        }

        return i.d;
    }

    static Map e(String s1)
    {
        int i1 = s1.indexOf('?');
        if (i1 >= 0) goto _L2; else goto _L1
_L1:
        s1 = null;
_L4:
        return s1;
_L2:
        Map map = com.shazam.i.e.a.a(3);
        String as[] = c.split(s1.substring(i1 + 1));
        int j1 = as.length;
        i1 = 0;
        do
        {
            s1 = map;
            if (i1 >= j1)
            {
                continue;
            }
            s1 = as[i1];
            String as1[] = d.split(s1, 2);
            if (as1.length == 2)
            {
                s1 = as1[0];
                String s2 = as1[1];
                try
                {
                    map.put(s1, f(s2));
                }
                // Misplaced declaration of an exception variable
                catch (String s1) { }
            }
            i1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static String f(String s1)
    {
        try
        {
            s1 = URLDecoder.decode(s1, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new IllegalStateException(s1);
        }
        return s1;
    }

    protected abstract i a();

    public abstract boolean a(String s1);

}
