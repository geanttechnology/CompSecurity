// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;


public final class y
{

    private static final double a = Math.log(10D);

    static int a(String s, int i)
    {
        int j = s.charAt(i) - 48;
        return ((j << 1) + (j << 3) + s.charAt(i + 1)) - 48;
    }

    public static void a(StringBuffer stringbuffer, int i)
    {
        int j;
label0:
        {
label1:
            {
                j = i;
                if (i < 0)
                {
                    stringbuffer.append('-');
                    if (i == 0x80000000)
                    {
                        break label1;
                    }
                    j = -i;
                }
                if (j < 10)
                {
                    stringbuffer.append((char)(j + 48));
                    return;
                }
                break label0;
            }
            stringbuffer.append("2147483648");
            return;
        }
        if (j < 100)
        {
            i = (j + 1) * 0xcccccc >> 27;
            stringbuffer.append((char)(i + 48));
            stringbuffer.append((char)((j - (i << 3) - (i << 1)) + 48));
            return;
        } else
        {
            stringbuffer.append(Integer.toString(j));
            return;
        }
    }

    public static void a(StringBuffer stringbuffer, int i, int j)
    {
        int k;
label0:
        {
label1:
            {
label2:
                {
                    k = i;
                    if (i < 0)
                    {
                        stringbuffer.append('-');
                        k = j;
                        if (i == 0x80000000)
                        {
                            break label2;
                        }
                        k = -i;
                    }
                    if (k >= 10)
                    {
                        break label0;
                    }
                    for (; j > 1; j--)
                    {
                        stringbuffer.append('0');
                    }

                    break label1;
                }
                for (; k > 10; k--)
                {
                    stringbuffer.append('0');
                }

                stringbuffer.append("2147483648");
                return;
            }
            stringbuffer.append((char)(k + 48));
            return;
        }
        if (k < 100)
        {
            for (; j > 2; j--)
            {
                stringbuffer.append('0');
            }

            i = (k + 1) * 0xcccccc >> 27;
            stringbuffer.append((char)(i + 48));
            stringbuffer.append((char)((k - (i << 3) - (i << 1)) + 48));
            return;
        }
        if (k >= 1000)
        {
            if (k < 10000)
            {
                i = 4;
            } else
            {
                i = (int)(Math.log(k) / a) + 1;
            }
        }
        for (i = 3; j > i; j--)
        {
            stringbuffer.append('0');
        }

        stringbuffer.append(Integer.toString(k));
    }

    public static String b(String s, int i)
    {
        int j = i + 32;
        String s1;
        if (s.length() <= j + 3)
        {
            s1 = s;
        } else
        {
            s1 = s.substring(0, j).concat("...");
        }
        if (i <= 0)
        {
            return (new StringBuilder("Invalid format: \"")).append(s1).append('"').toString();
        }
        if (i >= s.length())
        {
            return (new StringBuilder("Invalid format: \"")).append(s1).append("\" is too short").toString();
        } else
        {
            return (new StringBuilder("Invalid format: \"")).append(s1).append("\" is malformed at \"").append(s1.substring(i)).append('"').toString();
        }
    }

}
