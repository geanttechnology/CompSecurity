// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.paypal.android.sdk:
//            gi, kq

public final class gj
{

    String a;
    String b;
    String c;
    String d;
    int e;
    final List f = new ArrayList();
    List g;
    String h;

    public gj()
    {
        b = "";
        c = "";
        e = -1;
        f.add("");
    }

    private static InetAddress a(String s, int i)
    {
        byte abyte0[];
        int k;
        int l;
        int i1;
        int j1;
        abyte0 = new byte[16];
        k = 0;
        l = -1;
        i1 = -1;
        j1 = 1;
_L12:
        int j;
        int k1;
        k1 = l;
        j = k;
        if (j1 >= i) goto _L2; else goto _L1
_L1:
        if (k == 16)
        {
            return null;
        }
        if (j1 + 2 > i || !s.regionMatches(j1, "::", 0, 2)) goto _L4; else goto _L3
_L3:
        if (l != -1)
        {
            return null;
        }
        j = j1 + 2;
        k += 2;
        if (j != i)
        {
            break MISSING_BLOCK_LABEL_529;
        }
        j = k;
        k1 = k;
          goto _L2
_L4:
        int l1;
        j = j1;
        k1 = l;
        l1 = k;
        if (k == 0) goto _L6; else goto _L5
_L5:
        if (!s.regionMatches(j1, ":", 0, 1)) goto _L8; else goto _L7
_L7:
        j = j1 + 1;
        l1 = k;
        k1 = l;
          goto _L6
_L8:
        if (!s.regionMatches(j1, ".", 0, 1))
        {
            break MISSING_BLOCK_LABEL_413;
        }
        l1 = k - 2;
        j1 = l1;
_L11:
        if (i1 >= i)
        {
            break MISSING_BLOCK_LABEL_382;
        }
        if (j1 == 16)
        {
            i = 0;
        } else
        {
label0:
            {
                j = i1;
                if (j1 == l1)
                {
                    break MISSING_BLOCK_LABEL_269;
                }
                if (s.charAt(i1) == '.')
                {
                    break label0;
                }
                i = 0;
            }
        }
_L9:
        if (i == 0)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_401;
        j = i1 + 1;
        k1 = 0;
        i1 = j;
_L10:
        if (i1 >= i)
        {
            break MISSING_BLOCK_LABEL_354;
        }
        char c1 = s.charAt(i1);
        if (c1 < '0' || c1 > '9')
        {
            break MISSING_BLOCK_LABEL_354;
        }
        if (k1 == 0 && j != i1)
        {
            i = 0;
        } else
        {
label1:
            {
                k1 = (k1 * 10 + c1) - 48;
                if (k1 <= 255)
                {
                    break label1;
                }
                i = 0;
            }
        }
          goto _L9
        i1++;
          goto _L10
label2:
        {
            if (i1 - j != 0)
            {
                break label2;
            }
            i = 0;
        }
          goto _L9
        abyte0[j1] = (byte)k1;
        j1++;
          goto _L11
        if (j1 != l1 + 4)
        {
            i = 0;
        } else
        {
            i = 1;
        }
          goto _L9
        j = k + 2;
        k1 = l;
          goto _L2
        return null;
_L6:
        l = 0;
        k = j;
        do
        {
            if (k >= i)
            {
                break;
            }
            i1 = gi.a(s.charAt(k));
            if (i1 == -1)
            {
                break;
            }
            l = (l << 4) + i1;
            k++;
        } while (true);
        i1 = k - j;
        if (i1 == 0 || i1 > 4)
        {
            return null;
        }
        j1 = l1 + 1;
        abyte0[l1] = (byte)(l >>> 8);
        i1 = j1 + 1;
        abyte0[j1] = (byte)l;
        j1 = k;
        l = k1;
        k = i1;
        i1 = j;
        if (true) goto _L12; else goto _L8
_L2:
        if (j != 16)
        {
            if (k1 == -1)
            {
                return null;
            }
            System.arraycopy(abyte0, k1, abyte0, 16 - (j - k1), j - k1);
            Arrays.fill(abyte0, k1, (16 - j) + k1, (byte)0);
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
        l1 = k;
        k1 = k;
          goto _L6
    }

    private void a(String s, int i, int j)
    {
        if (i != j)
        {
            char c1 = s.charAt(i);
            if (c1 == '/' || c1 == '\\')
            {
                f.clear();
                f.add("");
                i++;
            } else
            {
                f.set(f.size() - 1, "");
            }
            while (i < j) 
            {
                int k = gi.a(s, i, j, "/\\");
                String s1;
                boolean flag;
                if (k < j)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s1 = gi.a(s, i, k, " \"<>^`{}|/\\?#", true, false);
                if (s1.equals(".") || s1.equalsIgnoreCase("%2e"))
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                if (i == 0)
                {
                    if (s1.equals("..") || s1.equalsIgnoreCase("%2e.") || s1.equalsIgnoreCase(".%2e") || s1.equalsIgnoreCase("%2e%2e"))
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    if (i != 0)
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
                i = k;
                if (flag)
                {
                    i = k + 1;
                }
            }
        }
    }

    private static int b(String s, int i, int j)
    {
_L6:
        if (i >= j) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        k = i;
        l = i;
        s.charAt(i);
        JVM INSTR lookupswitch 2: default 40
    //                   58: 80
    //                   91: 49;
           goto _L3 _L4 _L5
_L3:
        k = i;
_L8:
        i = k + 1;
          goto _L6
_L5:
        i = k + 1;
        k = i;
        if (i >= j) goto _L8; else goto _L7
_L7:
        k = i;
        if (s.charAt(i) != ']') goto _L5; else goto _L9
_L9:
        k = i;
          goto _L8
_L2:
        l = j;
_L4:
        return l;
    }

    private static String b(String s)
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

    private static String c(String s, int i, int j)
    {
        boolean flag;
        flag = false;
        s = gi.a(s, i, j);
        if (!s.startsWith("[") || !s.endsWith("]")) goto _L2; else goto _L1
_L1:
        s = a(s, s.length() - 1);
        if (s != null) goto _L4; else goto _L3
_L3:
        return null;
_L4:
        s = s.getAddress();
        if (s.length == 16)
        {
            j = 0;
            int k = -1;
            for (i = 0; i < s.length;)
            {
                int l;
                for (l = i; l < 16 && s[l] == 0 && s[l + 1] == 0; l += 2) { }
                int k1 = l - i;
                int j1 = j;
                if (k1 > j)
                {
                    j1 = k1;
                    k = i;
                }
                i = l + 2;
                j = j1;
            }

            kq kq1 = new kq();
            i = ((flag) ? 1 : 0);
            do
            {
                if (i >= s.length)
                {
                    break;
                }
                if (i == k)
                {
                    kq1.b(58);
                    int i1 = i + j;
                    i = i1;
                    if (i1 == 16)
                    {
                        kq1.b(58);
                        i = i1;
                    }
                } else
                {
                    if (i > 0)
                    {
                        kq1.b(58);
                    }
                    kq1.g((s[i] & 0xff) << 8 | s[i + 1] & 0xff);
                    i += 2;
                }
            } while (true);
            return kq1.k();
        } else
        {
            throw new AssertionError();
        }
_L2:
        s = b(s);
        if (s != null)
        {
            i = s.length();
            if (gi.a(s, 0, i, "\000\t\n\r #%/:?@[\\]") == i)
            {
                return s;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static int d(String s, int i, int j)
    {
        try
        {
            i = Integer.parseInt(gi.a(s, i, j, "", false, false));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        if (i > 0 && i <= 65535)
        {
            return i;
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
            return gi.a(a);
        }
    }

    final gi a(gi gi1, String s)
    {
        int i;
        int j;
        j = s.length();
        i = 0;
_L26:
        if (i >= j) goto _L2; else goto _L1
_L1:
        s.charAt(i);
        JVM INSTR lookupswitch 5: default 72
    //                   9: 289
    //                   10: 289
    //                   12: 289
    //                   13: 289
    //                   32: 289;
           goto _L3 _L4 _L4 _L4 _L4 _L4
_L3:
        j = s.length() - 1;
_L14:
        if (j < i) goto _L6; else goto _L5
_L5:
        s.charAt(j);
        JVM INSTR lookupswitch 5: default 144
    //                   9: 305
    //                   10: 305
    //                   12: 305
    //                   13: 305
    //                   32: 305;
           goto _L7 _L8 _L8 _L8 _L8 _L8
_L7:
        int k = j + 1;
_L15:
        if (k - i < 2) goto _L10; else goto _L9
_L9:
        j = s.charAt(i);
        if (j >= 97 && j <= 122 || j >= 65 && j <= 90) goto _L12; else goto _L11
_L11:
        j = -1;
_L19:
        int l;
        boolean flag;
        int j1;
        if (j != -1)
        {
            if (s.regionMatches(true, i, "https:", 0, 6))
            {
                a = "https";
                i += 6;
            } else
            if (s.regionMatches(true, i, "http:", 0, 5))
            {
                a = "http";
                i += 5;
            } else
            {
                return null;
            }
        } else
        if (gi1 != null)
        {
            a = gi.a(gi1);
        } else
        {
            return null;
        }
        j1 = 0;
        flag = false;
        l = 0;
        j = i;
        do
        {
            if (j >= k)
            {
                break;
            }
            char c1 = s.charAt(j);
            if (c1 != '\\' && c1 != '/')
            {
                break;
            }
            l++;
            j++;
        } while (true);
          goto _L13
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        i = j;
          goto _L3
_L8:
        j--;
          goto _L14
_L6:
        k = i;
          goto _L15
_L12:
        j = i + 1;
_L20:
        if (j >= k) goto _L10; else goto _L16
_L16:
        l = s.charAt(j);
        if (l >= 97 && l <= 122 || l >= 65 && l <= 90 || l == 43 || l == 45 || l == 46) goto _L18; else goto _L17
_L17:
        if (l != 58)
        {
            j = -1;
        }
          goto _L19
_L18:
        j++;
          goto _L20
_L10:
        j = -1;
          goto _L19
_L13:
        if (l < 2 && gi1 != null && gi.a(gi1).equals(a)) goto _L22; else goto _L21
_L21:
        l = i + l;
        j = j1;
        i = ((flag) ? 1 : 0);
label0:
        do
        {
            j1 = gi.a(s, l, k, "@/\\?#");
            int i1;
            if (j1 != k)
            {
                i1 = s.charAt(j1);
            } else
            {
                i1 = -1;
            }
            switch (i1)
            {
            default:
                break;

            case -1: 
            case 35: // '#'
            case 47: // '/'
            case 63: // '?'
            case 92: // '\\'
                i = b(s, l, j1);
                String s1;
                if (i + 1 < j1)
                {
                    d = c(s, l, i);
                    e = d(s, i + 1, j1);
                    if (e == -1)
                    {
                        return null;
                    }
                } else
                {
                    d = c(s, l, i);
                    e = gi.a(a);
                }
                break label0;

            case 64: // '@'
                if (i == 0)
                {
                    i1 = gi.a(s, l, j1, ":");
                    s1 = gi.a(s, l, i1, " \"':;<=>@[]^`{}|/\\?#", true, false);
                    gi1 = s1;
                    if (j != 0)
                    {
                        gi1 = (new StringBuilder()).append(b).append("%40").append(s1).toString();
                    }
                    b = gi1;
                    if (i1 != j1)
                    {
                        i = 1;
                        c = gi.a(s, i1 + 1, j1, " \"':;<=>@[]^`{}|/\\?#", true, false);
                    }
                    j = i;
                    i = 1;
                } else
                {
                    c = (new StringBuilder()).append(c).append("%40").append(gi.a(s, l, j1, " \"':;<=>@[]^`{}|/\\?#", true, false)).toString();
                    l = j;
                    j = i;
                    i = l;
                }
                i1 = i;
                l = j1 + 1;
                i = j;
                j = i1;
                break;
            }
        } while (true);
        if (d == null)
        {
            return null;
        }
        j = j1;
_L24:
        i = gi.a(s, j, k, "?#");
        a(s, j, i);
        if (i < k && s.charAt(i) == '?')
        {
            j = gi.a(s, i, k, "#");
            g = gi.b(gi.a(s, i + 1, j, " \"'<>#", true, true));
            i = j;
        }
        if (i < k && s.charAt(i) == '#')
        {
            h = gi.a(s, i + 1, k, "", true, false);
        }
        return b();
_L22:
        b = gi1.e();
        c = gi1.f();
        d = gi.b(gi1);
        e = gi.c(gi1);
        f.clear();
        f.addAll(gi1.j());
        if (i != k)
        {
            j = i;
            if (s.charAt(i) != '#')
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        gi1 = gi1.k();
        if (gi1 != null)
        {
            gi1 = gi.b(gi.a(gi1, " \"'<>#"));
        } else
        {
            gi1 = null;
        }
        g = gi1;
        j = i;
        if (true) goto _L24; else goto _L23
_L23:
        if (true) goto _L26; else goto _L25
_L25:
    }

    public final gj a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("host == null");
        }
        String s1 = c(s, 0, s.length());
        if (s1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("unexpected host: ")).append(s).toString());
        } else
        {
            d = s1;
            return this;
        }
    }

    public final gi b()
    {
        if (a == null)
        {
            throw new IllegalStateException("scheme == null");
        }
        if (d == null)
        {
            throw new IllegalStateException("host == null");
        } else
        {
            return new gi(this, (byte)0);
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
        int i;
        if (d.indexOf(':') != -1)
        {
            stringbuilder.append('[');
            stringbuilder.append(d);
            stringbuilder.append(']');
        } else
        {
            stringbuilder.append(d);
        }
        i = a();
        if (i != gi.a(a))
        {
            stringbuilder.append(':');
            stringbuilder.append(i);
        }
        gi.a(stringbuilder, f);
        if (g != null)
        {
            stringbuilder.append('?');
            gi.b(stringbuilder, g);
        }
        if (h != null)
        {
            stringbuilder.append('#');
            stringbuilder.append(h);
        }
        return stringbuilder.toString();
    }
}
