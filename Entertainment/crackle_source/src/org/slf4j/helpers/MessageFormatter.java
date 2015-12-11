// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.helpers;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public final class MessageFormatter
{

    public MessageFormatter()
    {
    }

    private static void a(StringBuffer stringbuffer, Object obj, Map map)
    {
        if (obj == null)
        {
            stringbuffer.append("null");
            return;
        }
        if (!obj.getClass().isArray())
        {
            try
            {
                stringbuffer.append(obj.toString());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                System.err.println((new StringBuilder()).append("SLF4J: Failed toString() invocation on an object of type [").append(obj.getClass().getName()).append("]").toString());
            }
            map.printStackTrace();
            stringbuffer.append("[FAILED toString()]");
            return;
        }
        if (obj instanceof boolean[])
        {
            a(stringbuffer, (boolean[])obj);
            return;
        }
        if (obj instanceof byte[])
        {
            a(stringbuffer, (byte[])obj);
            return;
        }
        if (obj instanceof char[])
        {
            a(stringbuffer, (char[])obj);
            return;
        }
        if (obj instanceof short[])
        {
            a(stringbuffer, (short[])obj);
            return;
        }
        if (obj instanceof int[])
        {
            a(stringbuffer, (int[])obj);
            return;
        }
        if (obj instanceof long[])
        {
            a(stringbuffer, (long[])obj);
            return;
        }
        if (obj instanceof float[])
        {
            a(stringbuffer, (float[])obj);
            return;
        }
        if (obj instanceof double[])
        {
            a(stringbuffer, (double[])obj);
            return;
        } else
        {
            a(stringbuffer, (Object[])obj, map);
            return;
        }
    }

    private static void a(StringBuffer stringbuffer, byte abyte0[])
    {
        stringbuffer.append('[');
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(abyte0[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, char ac[])
    {
        stringbuffer.append('[');
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ac[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, double ad[])
    {
        stringbuffer.append('[');
        int j = ad.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ad[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, float af[])
    {
        stringbuffer.append('[');
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(af[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, int ai[])
    {
        stringbuffer.append('[');
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(ai[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, long al[])
    {
        stringbuffer.append('[');
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(al[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, Object aobj[], Map map)
    {
        stringbuffer.append('[');
        if (!map.containsKey(((Object) (aobj))))
        {
            map.put(((Object) (aobj)), null);
            int j = aobj.length;
            for (int i = 0; i < j; i++)
            {
                a(stringbuffer, aobj[i], map);
                if (i != j - 1)
                {
                    stringbuffer.append(", ");
                }
            }

            map.remove(((Object) (aobj)));
        } else
        {
            stringbuffer.append("...");
        }
        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, short aword0[])
    {
        stringbuffer.append('[');
        int j = aword0.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(aword0[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    private static void a(StringBuffer stringbuffer, boolean aflag[])
    {
        stringbuffer.append('[');
        int j = aflag.length;
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(aflag[i]);
            if (i != j - 1)
            {
                stringbuffer.append(", ");
            }
        }

        stringbuffer.append(']');
    }

    public static final String arrayFormat(String s, Object aobj[])
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = null;
_L4:
        return s1;
_L2:
        s1 = s;
        if (aobj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        StringBuffer stringbuffer = new StringBuffer(s.length() + 50);
        int j = 0;
        int i = 0;
        do
        {
            if (j >= aobj.length)
            {
                break;
            }
            int k = s.indexOf("{}", i);
            if (k == -1)
            {
                s1 = s;
                if (i != 0)
                {
                    stringbuffer.append(s.substring(i, s.length()));
                    return stringbuffer.toString();
                }
                continue; /* Loop/switch isn't completed */
            }
            boolean flag;
            if (k != 0 && s.charAt(k - 1) == '\\')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (k >= 2 && s.charAt(k - 2) == '\\')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    j--;
                    stringbuffer.append(s.substring(i, k - 1));
                    stringbuffer.append('{');
                    i = k + 1;
                } else
                {
                    stringbuffer.append(s.substring(i, k - 1));
                    a(stringbuffer, aobj[j], new HashMap());
                    i = k + 2;
                }
            } else
            {
                stringbuffer.append(s.substring(i, k));
                a(stringbuffer, aobj[j], new HashMap());
                i = k + 2;
            }
            j++;
        } while (true);
        stringbuffer.append(s.substring(i, s.length()));
        return stringbuffer.toString();
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static final String format(String s, Object obj)
    {
        return arrayFormat(s, new Object[] {
            obj
        });
    }

    public static final String format(String s, Object obj, Object obj1)
    {
        return arrayFormat(s, new Object[] {
            obj, obj1
        });
    }
}
