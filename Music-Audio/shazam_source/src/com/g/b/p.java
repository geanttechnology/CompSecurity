// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import c.c;
import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class p
{
    public static final class a
    {

        String a;
        String b;
        String c;
        String d;
        int e;
        final List f = new ArrayList();
        List g;
        String h;

        private static String a(String s)
        {
            boolean flag;
            try
            {
                s = IDN.toASCII(s).toLowerCase(Locale.US);
                flag = s.isEmpty();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
            if (flag)
            {
                return null;
            } else
            {
                return s;
            }
        }

        private static InetAddress a(String s, int k)
        {
            byte abyte0[];
            int i1;
            int j1;
            int k1;
            int l1;
            abyte0 = new byte[16];
            i1 = 0;
            j1 = -1;
            k1 = -1;
            l1 = 1;
_L12:
            int l;
            int i2;
            i2 = j1;
            l = i1;
            if (l1 >= k) goto _L2; else goto _L1
_L1:
            if (i1 == 16)
            {
                return null;
            }
            if (l1 + 2 > k || !s.regionMatches(l1, "::", 0, 2)) goto _L4; else goto _L3
_L3:
            if (j1 != -1)
            {
                return null;
            }
            l = l1 + 2;
            i1 += 2;
            if (l != k)
            {
                break MISSING_BLOCK_LABEL_537;
            }
            l = i1;
            i2 = i1;
              goto _L2
_L4:
            int j2;
            l = l1;
            i2 = j1;
            j2 = i1;
            if (i1 == 0) goto _L6; else goto _L5
_L5:
            if (!s.regionMatches(l1, ":", 0, 1)) goto _L8; else goto _L7
_L7:
            l = l1 + 1;
            j2 = i1;
            i2 = j1;
              goto _L6
_L8:
            if (!s.regionMatches(l1, ".", 0, 1))
            {
                break MISSING_BLOCK_LABEL_413;
            }
            j2 = i1 - 2;
            l1 = j2;
_L11:
            if (k1 >= k)
            {
                break MISSING_BLOCK_LABEL_382;
            }
            if (l1 == 16)
            {
                k = 0;
            } else
            {
label0:
                {
                    l = k1;
                    if (l1 == j2)
                    {
                        break MISSING_BLOCK_LABEL_269;
                    }
                    if (s.charAt(k1) == '.')
                    {
                        break label0;
                    }
                    k = 0;
                }
            }
_L9:
            if (k == 0)
            {
                return null;
            }
            break MISSING_BLOCK_LABEL_401;
            l = k1 + 1;
            i2 = 0;
            k1 = l;
_L10:
            if (k1 >= k)
            {
                break MISSING_BLOCK_LABEL_354;
            }
            char c1 = s.charAt(k1);
            if (c1 < '0' || c1 > '9')
            {
                break MISSING_BLOCK_LABEL_354;
            }
            if (i2 == 0 && l != k1)
            {
                k = 0;
            } else
            {
label1:
                {
                    i2 = (i2 * 10 + c1) - 48;
                    if (i2 <= 255)
                    {
                        break label1;
                    }
                    k = 0;
                }
            }
              goto _L9
            k1++;
              goto _L10
label2:
            {
                if (k1 - l != 0)
                {
                    break label2;
                }
                k = 0;
            }
              goto _L9
            abyte0[l1] = (byte)i2;
            l1++;
              goto _L11
            if (l1 != j2 + 4)
            {
                k = 0;
            } else
            {
                k = 1;
            }
              goto _L9
            l = i1 + 2;
            i2 = j1;
              goto _L2
            return null;
_L6:
            j1 = 0;
            i1 = l;
            do
            {
                if (i1 >= k)
                {
                    break;
                }
                k1 = p.a(s.charAt(i1));
                if (k1 == -1)
                {
                    break;
                }
                j1 = (j1 << 4) + k1;
                i1++;
            } while (true);
            k1 = i1 - l;
            if (k1 == 0 || k1 > 4)
            {
                return null;
            }
            l1 = j2 + 1;
            abyte0[j2] = (byte)(j1 >>> 8 & 0xff);
            k1 = l1 + 1;
            abyte0[l1] = (byte)(j1 & 0xff);
            l1 = i1;
            j1 = i2;
            i1 = k1;
            k1 = l;
            if (true) goto _L12; else goto _L8
_L2:
            if (l != 16)
            {
                if (i2 == -1)
                {
                    return null;
                }
                System.arraycopy(abyte0, i2, abyte0, 16 - (l - i2), l - i2);
                Arrays.fill(abyte0, i2, (16 - l) + i2, (byte)0);
            }
            try
            {
                s = InetAddress.getByAddress(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new AssertionError();
            }
            return s;
            j2 = i1;
            i2 = i1;
              goto _L6
        }

        static int b(String s, int k, int l)
        {
_L6:
            if (k >= l) goto _L2; else goto _L1
_L1:
            int i1;
            int j1;
            i1 = k;
            j1 = k;
            s.charAt(k);
            JVM INSTR lookupswitch 2: default 40
        //                       58: 80
        //                       91: 49;
               goto _L3 _L4 _L5
_L3:
            i1 = k;
_L8:
            k = i1 + 1;
              goto _L6
_L5:
            k = i1 + 1;
            i1 = k;
            if (k >= l) goto _L8; else goto _L7
_L7:
            i1 = k;
            if (s.charAt(k) != ']') goto _L5; else goto _L9
_L9:
            i1 = k;
              goto _L8
_L2:
            j1 = l;
_L4:
            return j1;
        }

        static String c(String s, int k, int l)
        {
            Object obj = null;
            s = p.a(s, k, l);
            if (s.startsWith("[") && s.endsWith("]"))
            {
                InetAddress inetaddress = a(s, s.length() - 1);
                s = obj;
                if (inetaddress != null)
                {
                    s = inetaddress.getHostAddress();
                }
            } else
            {
                String s1 = a(s);
                s = obj;
                if (s1 != null)
                {
                    k = s1.length();
                    s = obj;
                    if (p.a(s1, 0, k, "\000\t\n\r #%/:?@[\\]") == k)
                    {
                        return s1;
                    }
                }
            }
            return s;
        }

        static int d(String s, int k, int l)
        {
            try
            {
                k = Integer.parseInt(p.a(s, k, l, "", false, false));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return -1;
            }
            if (k > 0 && k <= 65535)
            {
                return k;
            } else
            {
                return -1;
            }
        }

        final int a()
        {
            if (e != -1)
            {
                return e;
            } else
            {
                return p.a(a);
            }
        }

        final void a(String s, int k, int l)
        {
            if (k != l)
            {
                char c1 = s.charAt(k);
                if (c1 == '/' || c1 == '\\')
                {
                    f.clear();
                    f.add("");
                    k++;
                } else
                {
                    f.set(f.size() - 1, "");
                }
                while (k < l) 
                {
                    int i1 = p.a(s, k, l, "/\\");
                    String s1;
                    boolean flag;
                    if (i1 < l)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    s1 = p.a(s, k, i1, " \"<>^`{}|/\\?#", true, false);
                    if (s1.equals(".") || s1.equalsIgnoreCase("%2e"))
                    {
                        k = 1;
                    } else
                    {
                        k = 0;
                    }
                    if (k == 0)
                    {
                        if (s1.equals("..") || s1.equalsIgnoreCase("%2e.") || s1.equalsIgnoreCase(".%2e") || s1.equalsIgnoreCase("%2e%2e"))
                        {
                            k = 1;
                        } else
                        {
                            k = 0;
                        }
                        if (k != 0)
                        {
                            if (((String)f.remove(f.size() - 1)).isEmpty() && !f.isEmpty())
                            {
                                f.set(f.size() - 1, "");
                            } else
                            {
                                f.add("");
                            }
                        } else
                        {
                            if (((String)f.get(f.size() - 1)).isEmpty())
                            {
                                f.set(f.size() - 1, s1);
                            } else
                            {
                                f.add(s1);
                            }
                            if (flag)
                            {
                                f.add("");
                            }
                        }
                    }
                    k = i1;
                    if (flag)
                    {
                        k = i1 + 1;
                    }
                }
            }
        }

        public final String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(a);
            stringbuilder.append("://");
            if (!b.isEmpty() || !c.isEmpty())
            {
                stringbuilder.append(b);
                if (!c.isEmpty())
                {
                    stringbuilder.append(':');
                    stringbuilder.append(c);
                }
                stringbuilder.append('@');
            }
            int k;
            if (d.indexOf(':') != -1)
            {
                stringbuilder.append('[');
                stringbuilder.append(d);
                stringbuilder.append(']');
            } else
            {
                stringbuilder.append(d);
            }
            k = a();
            if (k != p.a(a))
            {
                stringbuilder.append(':');
                stringbuilder.append(k);
            }
            p.a(stringbuilder, f);
            if (g != null)
            {
                stringbuilder.append('?');
                p.b(stringbuilder, g);
            }
            if (h != null)
            {
                stringbuilder.append('#');
                stringbuilder.append(h);
            }
            return stringbuilder.toString();
        }

        public a()
        {
            b = "";
            c = "";
            e = -1;
            f.add("");
        }
    }


    private static final char b[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };
    final String a;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List g;
    private final List h;
    private final String i;
    private final String j;

    private p(a a1)
    {
        Object obj1 = null;
        super();
        a = a1.a;
        c = d(a1.b);
        d = d(a1.c);
        e = a1.d;
        f = a1.a();
        g = a(a1.f);
        Object obj;
        if (a1.g != null)
        {
            obj = a(a1.g);
        } else
        {
            obj = null;
        }
        h = ((List) (obj));
        obj = obj1;
        if (a1.h != null)
        {
            obj = d(a1.h);
        }
        i = ((String) (obj));
        j = a1.toString();
    }

    private p(a a1, byte byte0)
    {
        this(a1);
    }

    static int a(char c1)
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

    public static int a(String s)
    {
        if (s.equals("http"))
        {
            return 80;
        }
        return !s.equals("https") ? -1 : 443;
    }

    static int a(String s, int k, int l, String s1)
    {
        return b(s, k, l, s1);
    }

    public static p a(URL url)
    {
        return b(url.toString());
    }

    static String a(String s, int k, int l)
    {
        int i1 = k;
_L11:
        if (i1 >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.charAt(i1) != '%') goto _L2; else goto _L1
_L1:
        c c1;
        c1 = new c();
        c1.a(s, k, i1);
        k = i1;
_L9:
        if (k >= l) goto _L4; else goto _L3
_L3:
        i1 = s.codePointAt(k);
        if (i1 != 37 || k + 2 >= l) goto _L6; else goto _L5
_L5:
        int j1;
        int k1;
        j1 = a(s.charAt(k + 1));
        k1 = a(s.charAt(k + 2));
        if (j1 == -1 || k1 == -1) goto _L6; else goto _L7
_L7:
        c1.b((j1 << 4) + k1);
        k += 2;
_L8:
        k += Character.charCount(i1);
        continue; /* Loop/switch isn't completed */
_L6:
        c1.a(i1);
        if (true) goto _L8; else goto _L4
_L4:
        return c1.o();
        if (true) goto _L9; else goto _L2
_L2:
        i1++;
        if (true) goto _L11; else goto _L10
_L10:
        return s.substring(k, l);
    }

    static String a(String s, int k, int l, String s1, boolean flag, boolean flag1)
    {
        int i1 = k;
_L7:
        Object obj;
        c c3;
        int j1;
        if (i1 >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = s.codePointAt(i1);
        if (j1 >= 32 && j1 < 127 && s1.indexOf(j1) == -1 && (j1 != 37 || flag) && (!flag1 || j1 != 43))
        {
            break MISSING_BLOCK_LABEL_355;
        }
        c3 = new c();
        c3.a(s, k, i1);
        k = i1;
        obj = null;
_L2:
        c c2;
label0:
        {
            if (k >= l)
            {
                break MISSING_BLOCK_LABEL_349;
            }
            i1 = s.codePointAt(k);
            if (flag)
            {
                c2 = obj;
                if (i1 == 9)
                {
                    break label0;
                }
                c2 = obj;
                if (i1 == 10)
                {
                    break label0;
                }
                c2 = obj;
                if (i1 == 12)
                {
                    break label0;
                }
                c2 = obj;
                if (i1 == 13)
                {
                    break label0;
                }
            }
            if (!flag1 || i1 != 43)
            {
                break; /* Loop/switch isn't completed */
            }
            String s2;
            if (flag)
            {
                s2 = "%20";
            } else
            {
                s2 = "%2B";
            }
            c3.a(s2);
            c2 = obj;
        }
_L4:
        k = Character.charCount(i1) + k;
        obj = c2;
        if (true) goto _L2; else goto _L1
_L1:
        c c1;
        if (i1 >= 32 && i1 < 127 && s1.indexOf(i1) == -1 && (i1 != 37 || flag))
        {
            break MISSING_BLOCK_LABEL_334;
        }
        c1 = obj;
        if (obj == null)
        {
            c1 = new c();
        }
        c1.a(i1);
_L5:
        c2 = c1;
        if (c1.e()) goto _L4; else goto _L3
_L3:
        j1 = c1.g() & 0xff;
        c3.b(37);
        c3.b(b[j1 >> 4 & 0xf]);
        c3.b(b[j1 & 0xf]);
          goto _L5
        c3.a(i1);
        c2 = obj;
          goto _L4
        return c3.o();
        i1 += Character.charCount(j1);
        if (true) goto _L7; else goto _L6
_L6:
        return s.substring(k, l);
    }

    private static List a(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (String)iterator.next();
            if (list != null)
            {
                list = d(list);
            } else
            {
                list = null;
            }
            arraylist.add(list);
        }
        return Collections.unmodifiableList(arraylist);
    }

    static void a(StringBuilder stringbuilder, List list)
    {
        int l = list.size();
        for (int k = 0; k < l; k++)
        {
            stringbuilder.append('/');
            stringbuilder.append((String)list.get(k));
        }

    }

    private static int b(String s, int k, int l, String s1)
    {
        do
        {
label0:
            {
                int i1 = l;
                if (k < l)
                {
                    if (s1.indexOf(s.charAt(k)) == -1)
                    {
                        break label0;
                    }
                    i1 = k;
                }
                return i1;
            }
            k++;
        } while (true);
    }

    public static p b(String s)
    {
        a a1;
        int k;
        int l;
        a1 = new a();
        k = s.length();
        l = 0;
_L19:
        if (l >= k) goto _L2; else goto _L1
_L1:
        s.charAt(l);
        JVM INSTR lookupswitch 5: default 80
    //                   9: 291
    //                   10: 291
    //                   12: 291
    //                   13: 291
    //                   32: 291;
           goto _L3 _L4 _L4 _L4 _L4 _L4
_L3:
        k = s.length() - 1;
_L12:
        if (k < l) goto _L6; else goto _L5
_L5:
        s.charAt(k);
        JVM INSTR lookupswitch 5: default 152
    //                   9: 307
    //                   10: 307
    //                   12: 307
    //                   13: 307
    //                   32: 307;
           goto _L7 _L8 _L8 _L8 _L8 _L8
_L7:
        int j1 = k + 1;
_L13:
        if (j1 - l < 2) goto _L10; else goto _L9
_L9:
        k = s.charAt(l);
        int k1;
        char c2;
        if ((k < 97 || k > 122) && (k < 65 || k > 90))
        {
            k = -1;
            break MISSING_BLOCK_LABEL_206;
        }
        k = l + 1;
          goto _L11
_L4:
        l++;
        continue; /* Loop/switch isn't completed */
_L2:
        l = k;
          goto _L3
_L8:
        k--;
          goto _L12
_L6:
        j1 = l;
          goto _L13
_L11:
        if (k >= j1) goto _L10; else goto _L14
_L14:
        c1 = s.charAt(k);
        if (c1 >= 'a' && c1 <= 'z' || c1 >= 'A' && c1 <= 'Z' || c1 == '+' || c1 == '-' || c1 == '.') goto _L16; else goto _L15
_L15:
        if (c1 != ':')
        {
            k = -1;
        }
          goto _L17
_L16:
        k++;
          goto _L11
_L10:
        k = -1;
_L17:
        if (k != -1)
        {
            char c1;
            if (s.regionMatches(true, l, "https:", 0, 6))
            {
                a1.a = "https";
                k = l + 6;
            } else
            if (s.regionMatches(true, l, "http:", 0, 5))
            {
                a1.a = "http";
                k = l + 5;
            } else
            {
                return null;
            }
            l = 0;
            k1 = k;
            do
            {
                if (k1 >= j1)
                {
                    break;
                }
                c2 = s.charAt(k1);
                if (c2 != '\\' && c2 != '/')
                {
                    break;
                }
                l++;
                k1++;
            } while (true);
        } else
        {
            return null;
        }
        int l1 = 0;
        boolean flag = false;
        int j2 = k + l;
        l = ((flag) ? 1 : 0);
        k = l1;
        l1 = j2;
label0:
        do
        {
            j2 = b(s, l1, j1, "@/\\?#");
            int i2;
            if (j2 != j1)
            {
                i2 = s.charAt(j2);
            } else
            {
                i2 = -1;
            }
            switch (i2)
            {
            default:
                break;

            case -1: 
            case 35: // '#'
            case 47: // '/'
            case 63: // '?'
            case 92: // '\\'
                k = a.b(s, l1, j2);
                String s1;
                String s2;
                if (k + 1 < j2)
                {
                    a1.d = com.g.b.a.c(s, l1, k);
                    a1.e = a.d(s, k + 1, j2);
                    if (a1.e == -1)
                    {
                        return null;
                    }
                } else
                {
                    a1.d = com.g.b.a.c(s, l1, k);
                    a1.e = a(a1.a);
                }
                break label0;

            case 64: // '@'
                if (k == 0)
                {
                    i2 = b(s, l1, j2, ":");
                    s2 = a(s, l1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false);
                    s1 = s2;
                    if (l != 0)
                    {
                        s1 = (new StringBuilder()).append(a1.b).append("%40").append(s2).toString();
                    }
                    a1.b = s1;
                    if (i2 != j2)
                    {
                        k = 1;
                        a1.c = a(s, i2 + 1, j2, " \"':;<=>@[]\\^`{}|/\\?#", true, false);
                    }
                    l1 = 1;
                    l = k;
                    k = l1;
                } else
                {
                    a1.c = (new StringBuilder()).append(a1.c).append("%40").append(a(s, l1, j2, " \"':;<=>@[]\\^`{}|/\\?#", true, false)).toString();
                    l1 = l;
                    l = k;
                    k = l1;
                }
                i2 = k;
                l1 = j2 + 1;
                k = l;
                l = i2;
                break;
            }
        } while (true);
        if (a1.d == null)
        {
            return null;
        }
        k = a(s, j2, j1, "?#");
        a1.a(s, j2, k);
        if (k < j1 && s.charAt(k) == '?')
        {
            int i1 = a(s, k, j1, "#");
            a1.g = c(a(s, k + 1, i1, " \"'<>#", true, true));
            k = i1;
        }
        if (k < j1 && s.charAt(k) == '#')
        {
            a1.h = a(s, k + 1, j1, "", true, false);
        }
        if (a1.a == null)
        {
            throw new IllegalStateException("scheme == null");
        }
        if (a1.d == null)
        {
            throw new IllegalStateException("host == null");
        }
        return new p(a1, (byte)0);
        if (true) goto _L19; else goto _L18
_L18:
    }

    static void b(StringBuilder stringbuilder, List list)
    {
        int l = list.size();
        for (int k = 0; k < l; k += 2)
        {
            String s = (String)list.get(k);
            String s1 = (String)list.get(k + 1);
            if (k > 0)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append(s);
            if (s1 != null)
            {
                stringbuilder.append('=');
                stringbuilder.append(s1);
            }
        }

    }

    private static List c(String s)
    {
        ArrayList arraylist = new ArrayList();
        int k = 0;
        while (k <= s.length()) 
        {
            int i1 = s.indexOf('&', k);
            int l = i1;
            if (i1 == -1)
            {
                l = s.length();
            }
            i1 = s.indexOf('=', k);
            if (i1 == -1 || i1 > l)
            {
                arraylist.add(s.substring(k, l));
                arraylist.add(null);
            } else
            {
                arraylist.add(s.substring(k, i1));
                arraylist.add(s.substring(i1 + 1, l));
            }
            k = l + 1;
        }
        return arraylist;
    }

    private static String d(String s)
    {
        return a(s, 0, s.length());
    }

    public final URL a()
    {
        URL url;
        try
        {
            url = new URL(j);
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException(malformedurlexception);
        }
        return url;
    }

    public final URI b()
    {
        URI uri;
        try
        {
            uri = new URI(j);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new IllegalStateException((new StringBuilder("not valid as a java.net.URI: ")).append(j).toString());
        }
        return uri;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof p) && ((p)obj).j.equals(j);
    }

    public final int hashCode()
    {
        return j.hashCode();
    }

    public final String toString()
    {
        return j;
    }

}
