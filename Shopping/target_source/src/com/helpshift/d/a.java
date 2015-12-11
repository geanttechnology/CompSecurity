// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.d;

import java.util.Locale;

public class com.helpshift.d.a
{
    public class a
    {

        final com.helpshift.d.a a;
        private final StringBuilder b;
        private final StringBuilder c;
        private final int d;

        public String a()
        {
            return b.toString();
        }

        public void a(char c1)
        {
            b(c1);
            c(c1);
        }

        public void a(char c1, char c2)
        {
            b(c1);
            c(c2);
        }

        public void a(String s)
        {
            b(s);
            c(s);
        }

        public void a(String s, String s1)
        {
            b(s);
            c(s1);
        }

        public String b()
        {
            return c.toString();
        }

        public void b(char c1)
        {
            if (b.length() < d)
            {
                b.append(c1);
            }
        }

        public void b(String s)
        {
            int i1 = d - b.length();
            if (s.length() <= i1)
            {
                b.append(s);
                return;
            } else
            {
                b.append(s.substring(0, i1));
                return;
            }
        }

        public void c(char c1)
        {
            if (c.length() < d)
            {
                c.append(c1);
            }
        }

        public void c(String s)
        {
            int i1 = d - c.length();
            if (s.length() <= i1)
            {
                c.append(s);
                return;
            } else
            {
                c.append(s.substring(0, i1));
                return;
            }
        }

        public boolean c()
        {
            return b.length() >= d && c.length() >= d;
        }

        public a(int i1)
        {
            a = com.helpshift.d.a.this;
            super();
            b = new StringBuilder(a.a());
            c = new StringBuilder(a.a());
            d = i1;
        }
    }


    private static final String a[] = {
        "GN", "KN", "PN", "WR", "PS"
    };
    private static final String b[] = {
        "L", "R", "N", "M", "B", "H", "F", "V", "W", " "
    };
    private static final String c[] = {
        "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", 
        "ER"
    };
    private static final String d[] = {
        "L", "T", "K", "S", "N", "M", "B", "Z"
    };
    private int e;

    public com.helpshift.d.a()
    {
        e = 4;
    }

    private int a(a a1, int i1)
    {
        if (i1 == 0)
        {
            a1.a('A');
        }
        return i1 + 1;
    }

    private int a(String s, a a1, int i1)
    {
        if (b(s, i1))
        {
            a1.a('K');
            return i1 + 2;
        }
        if (i1 == 0 && a(s, i1, 6, "CAESAR"))
        {
            a1.a('S');
            return i1 + 2;
        }
        if (a(s, i1, 2, "CH"))
        {
            return c(s, a1, i1);
        }
        if (a(s, i1, 2, "CZ") && !a(s, i1 - 2, 4, "WICZ"))
        {
            a1.a('S', 'X');
            return i1 + 2;
        }
        if (a(s, i1 + 1, 3, "CIA"))
        {
            a1.a('X');
            return i1 + 3;
        }
        if (a(s, i1, 2, "CC") && (i1 != 1 || a(s, 0) != 'M'))
        {
            return b(s, a1, i1);
        }
        if (a(s, i1, 2, "CK", "CG", "CQ"))
        {
            a1.a('K');
            return i1 + 2;
        }
        if (a(s, i1, 2, "CI", "CE", "CY"))
        {
            if (a(s, i1, 3, "CIO", "CIE", "CIA"))
            {
                a1.a('S', 'X');
            } else
            {
                a1.a('S');
            }
            return i1 + 2;
        }
        a1.a('K');
        if (a(s, i1 + 1, 2, " C", " Q", " G"))
        {
            return i1 + 3;
        }
        if (a(s, i1 + 1, 1, "C", "K", "Q") && !a(s, i1 + 1, 2, "CE", "CI"))
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private int a(String s, a a1, int i1, boolean flag)
    {
        if (a(s, i1 + 1) == 'H')
        {
            return e(s, a1, i1);
        }
        if (a(s, i1 + 1) == 'N')
        {
            if (i1 == 1 && a(a(s, 0)) && !flag)
            {
                a1.a("KN", "N");
            } else
            if (!a(s, i1 + 2, 2, "EY") && a(s, i1 + 1) != 'Y' && !flag)
            {
                a1.a("N", "KN");
            } else
            {
                a1.a("KN");
            }
            return i1 + 2;
        }
        if (a(s, i1 + 1, 2, "LI") && !flag)
        {
            a1.a("KL", "L");
            return i1 + 2;
        }
        if (i1 == 0 && (a(s, i1 + 1) == 'Y' || a(s, i1 + 1, 2, c)))
        {
            a1.a('K', 'J');
            return i1 + 2;
        }
        if ((a(s, i1 + 1, 2, "ER") || a(s, i1 + 1) == 'Y') && !a(s, 0, 6, "DANGER", "RANGER", "MANGER") && !a(s, i1 - 1, 1, "E", "I") && !a(s, i1 - 1, 3, "RGY", "OGY"))
        {
            a1.a('K', 'J');
            return i1 + 2;
        }
        if (a(s, i1 + 1, 1, "E", "I", "Y") || a(s, i1 - 1, 4, "AGGI", "OGGI"))
        {
            if (a(s, 0, 4, "VAN ", "VON ") || a(s, 0, 3, "SCH") || a(s, i1 + 1, 2, "ET"))
            {
                a1.a('K');
            } else
            if (a(s, i1 + 1, 3, "IER"))
            {
                a1.a('J');
            } else
            {
                a1.a('J', 'K');
            }
            return i1 + 2;
        }
        if (a(s, i1 + 1) == 'G')
        {
            a1.a('K');
            return i1 + 2;
        } else
        {
            a1.a('K');
            return i1 + 1;
        }
    }

    private boolean a(char c1)
    {
        return "AEIOUY".indexOf(c1) != -1;
    }

    private static boolean a(String s, int i1, int j1, String s1)
    {
        return a(s, i1, j1, new String[] {
            s1
        });
    }

    private static boolean a(String s, int i1, int j1, String s1, String s2)
    {
        return a(s, i1, j1, new String[] {
            s1, s2
        });
    }

    private static boolean a(String s, int i1, int j1, String s1, String s2, String s3)
    {
        return a(s, i1, j1, new String[] {
            s1, s2, s3
        });
    }

    private static boolean a(String s, int i1, int j1, String s1, String s2, String s3, String s4)
    {
        return a(s, i1, j1, new String[] {
            s1, s2, s3, s4
        });
    }

    private static boolean a(String s, int i1, int j1, String s1, String s2, String s3, String s4, String s5)
    {
        return a(s, i1, j1, new String[] {
            s1, s2, s3, s4, s5
        });
    }

    private static boolean a(String s, int i1, int j1, String s1, String s2, String s3, String s4, String s5, 
            String s6)
    {
        return a(s, i1, j1, new String[] {
            s1, s2, s3, s4, s5, s6
        });
    }

    protected static boolean a(String s, int i1, int j1, String as[])
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (i1 < 0) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (i1 + j1 > s.length()) goto _L2; else goto _L3
_L3:
        s = s.substring(i1, i1 + j1);
        j1 = as.length;
        i1 = 0;
_L8:
        flag = flag1;
        if (i1 >= j1) goto _L2; else goto _L4
_L4:
        if (!s.equals(as[i1])) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private int b(String s, a a1, int i1)
    {
        if (a(s, i1 + 2, 1, "I", "E", "H") && !a(s, i1 + 2, 2, "HU"))
        {
            if (i1 == 1 && a(s, i1 - 1) == 'A' || a(s, i1 - 1, 5, "UCCEE", "UCCES"))
            {
                a1.a("KS");
            } else
            {
                a1.a('X');
            }
            return i1 + 3;
        } else
        {
            a1.a('K');
            return i1 + 2;
        }
    }

    private int b(String s, a a1, int i1, boolean flag)
    {
        if (a(s, i1, 4, "JOSE") || a(s, 0, 4, "SAN "))
        {
            if (i1 == 0 && a(s, i1 + 4) == ' ' || s.length() == 4 || a(s, 0, 4, "SAN "))
            {
                a1.a('H');
            } else
            {
                a1.a('J', 'H');
            }
            return i1 + 1;
        }
        if (i1 == 0 && !a(s, i1, 4, "JOSE"))
        {
            a1.a('J', 'A');
        } else
        if (a(a(s, i1 - 1)) && !flag && (a(s, i1 + 1) == 'A' || a(s, i1 + 1) == 'O'))
        {
            a1.a('J', 'H');
        } else
        if (i1 == s.length() - 1)
        {
            a1.a('J', ' ');
        } else
        if (!a(s, i1 + 1, 1, d) && !a(s, i1 - 1, 1, "S", "K", "L"))
        {
            a1.a('J');
        }
        if (a(s, i1 + 1) == 'J')
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private boolean b(String s, int i1)
    {
        boolean flag1 = false;
        if (!a(s, i1, 4, "CHIA")) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (i1 <= 1) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (a(a(s, i1 - 2))) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (!a(s, i1 - 1, 3, "ACH")) goto _L4; else goto _L6
_L6:
        char c1 = a(s, i1 + 2);
        if (c1 != 'I' && c1 != 'E')
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!a(s, i1 - 2, 6, "BACHER", "MACHER")) goto _L4; else goto _L7
_L7:
        return true;
    }

    private int c(String s, a a1, int i1)
    {
        if (i1 > 0 && a(s, i1, 4, "CHAE"))
        {
            a1.a('K', 'X');
            return i1 + 2;
        }
        if (c(s, i1))
        {
            a1.a('K');
            return i1 + 2;
        }
        if (d(s, i1))
        {
            a1.a('K');
            return i1 + 2;
        }
        if (i1 > 0)
        {
            if (a(s, 0, 2, "MC"))
            {
                a1.a('K');
            } else
            {
                a1.a('X', 'K');
            }
        } else
        {
            a1.a('X');
        }
        return i1 + 2;
    }

    private int c(String s, a a1, int i1, boolean flag)
    {
        if (i1 == s.length() - 1 && !flag && a(s, i1 - 2, 2, "IE") && !a(s, i1 - 4, 2, "ME", "MA"))
        {
            a1.c('R');
        } else
        {
            a1.a('R');
        }
        if (a(s, i1 + 1) == 'R')
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private boolean c(String s)
    {
        return s.indexOf('W') > -1 || s.indexOf('K') > -1 || s.indexOf("CZ") > -1 || s.indexOf("WITZ") > -1;
    }

    private boolean c(String s, int i1)
    {
        if (i1 != 0)
        {
            return false;
        }
        if (!a(s, i1 + 1, 5, "HARAC", "HARIS") && !a(s, i1 + 1, 3, "HOR", "HYM", "HIA", "HEM"))
        {
            return false;
        }
        return !a(s, 0, 5, "CHORE");
    }

    private int d(String s, a a1, int i1)
    {
        if (a(s, i1, 2, "DG"))
        {
            if (a(s, i1 + 2, 1, "I", "E", "Y"))
            {
                a1.a('J');
                return i1 + 3;
            } else
            {
                a1.a("TK");
                return i1 + 2;
            }
        }
        if (a(s, i1, 2, "DT", "DD"))
        {
            a1.a('T');
            return i1 + 2;
        } else
        {
            a1.a('T');
            return i1 + 1;
        }
    }

    private int d(String s, a a1, int i1, boolean flag)
    {
        if (a(s, i1 - 1, 3, "ISL", "YSL"))
        {
            return i1 + 1;
        }
        if (i1 == 0 && a(s, i1, 5, "SUGAR"))
        {
            a1.a('X', 'S');
            return i1 + 1;
        }
        if (a(s, i1, 2, "SH"))
        {
            if (a(s, i1 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ"))
            {
                a1.a('S');
            } else
            {
                a1.a('X');
            }
            return i1 + 2;
        }
        if (a(s, i1, 3, "SIO", "SIA") || a(s, i1, 4, "SIAN"))
        {
            if (flag)
            {
                a1.a('S');
            } else
            {
                a1.a('S', 'X');
            }
            return i1 + 3;
        }
        if (i1 == 0 && a(s, i1 + 1, 1, "M", "N", "L", "W") || a(s, i1 + 1, 1, "Z"))
        {
            a1.a('S', 'X');
            if (a(s, i1 + 1, 1, "Z"))
            {
                return i1 + 2;
            } else
            {
                return i1 + 1;
            }
        }
        if (a(s, i1, 2, "SC"))
        {
            return i(s, a1, i1);
        }
        if (i1 == s.length() - 1 && a(s, i1 - 2, 2, "AI", "OI"))
        {
            a1.c('S');
        } else
        {
            a1.a('S');
        }
        if (a(s, i1 + 1, 1, "S", "Z"))
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private boolean d(String s)
    {
        boolean flag1 = false;
        String as[] = a;
        int j1 = as.length;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (!s.startsWith(as[i1]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private boolean d(String s, int i1)
    {
        return a(s, 0, 4, "VAN ", "VON ") || a(s, 0, 3, "SCH") || a(s, i1 - 2, 6, "ORCHES", "ARCHIT", "ORCHID") || a(s, i1 + 2, 1, "T", "S") || (a(s, i1 - 1, 1, "A", "O", "U", "E") || i1 == 0) && (a(s, i1 + 2, 1, b) || i1 + 1 == s.length() - 1);
    }

    private int e(String s, a a1, int i1)
    {
        if (i1 > 0 && !a(a(s, i1 - 1)))
        {
            a1.a('K');
            return i1 + 2;
        }
        if (i1 == 0)
        {
            if (a(s, i1 + 2) == 'I')
            {
                a1.a('J');
            } else
            {
                a1.a('K');
            }
            return i1 + 2;
        }
        if (i1 > 1 && a(s, i1 - 2, 1, "B", "H", "D") || i1 > 2 && a(s, i1 - 3, 1, "B", "H", "D") || i1 > 3 && a(s, i1 - 4, 1, "B", "H"))
        {
            return i1 + 2;
        }
        if (i1 <= 2 || a(s, i1 - 1) != 'U' || !a(s, i1 - 3, 1, "C", "G", "L", "R", "T")) goto _L2; else goto _L1
_L1:
        a1.a('F');
_L4:
        return i1 + 2;
_L2:
        if (i1 > 0 && a(s, i1 - 1) != 'I')
        {
            a1.a('K');
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int e(String s, a a1, int i1, boolean flag)
    {
        if (a(s, i1 + 1) == 'H')
        {
            a1.a('J');
            return i1 + 2;
        }
        if (a(s, i1 + 1, 2, "ZO", "ZI", "ZA") || flag && i1 > 0 && a(s, i1 - 1) != 'T')
        {
            a1.a("S", "TS");
        } else
        {
            a1.a('S');
        }
        if (a(s, i1 + 1) == 'Z')
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private String e(String s)
    {
        if (s != null)
        {
            if ((s = s.trim()).length() != 0)
            {
                return s.toUpperCase(Locale.ENGLISH);
            }
        }
        return null;
    }

    private boolean e(String s, int i1)
    {
        if (i1 == s.length() - 3 && a(s, i1 - 1, 4, "ILLO", "ILLA", "ALLE"))
        {
            return true;
        }
        return (a(s, s.length() - 2, 2, "AS", "OS") || a(s, s.length() - 1, 1, "A", "O")) && a(s, i1 - 1, 4, "ALLE");
    }

    private int f(String s, a a1, int i1)
    {
        if ((i1 == 0 || a(a(s, i1 - 1))) && a(a(s, i1 + 1)))
        {
            a1.a('H');
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private boolean f(String s, int i1)
    {
        while (a(s, i1 + 1) == 'M' || a(s, i1 - 1, 3, "UMB") && (i1 + 1 == s.length() - 1 || a(s, i1 + 2, 2, "ER"))) 
        {
            return true;
        }
        return false;
    }

    private int g(String s, a a1, int i1)
    {
        if (a(s, i1 + 1) == 'L')
        {
            if (e(s, i1))
            {
                a1.b('L');
            } else
            {
                a1.a('L');
            }
            return i1 + 2;
        } else
        {
            a1.a('L');
            return i1 + 1;
        }
    }

    private int h(String s, a a1, int i1)
    {
        if (a(s, i1 + 1) == 'H')
        {
            a1.a('F');
            return i1 + 2;
        }
        a1.a('P');
        if (a(s, i1 + 1, 1, "P", "B"))
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private int i(String s, a a1, int i1)
    {
        if (a(s, i1 + 2) == 'H')
        {
            if (a(s, i1 + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM"))
            {
                if (a(s, i1 + 3, 2, "ER", "EN"))
                {
                    a1.a("X", "SK");
                } else
                {
                    a1.a("SK");
                }
            } else
            if (i1 == 0 && !a(a(s, 3)) && a(s, 3) != 'W')
            {
                a1.a('X', 'S');
            } else
            {
                a1.a('X');
            }
        } else
        if (a(s, i1 + 2, 1, "I", "E", "Y"))
        {
            a1.a('S');
        } else
        {
            a1.a("SK");
        }
        return i1 + 3;
    }

    private int j(String s, a a1, int i1)
    {
        if (a(s, i1, 4, "TION"))
        {
            a1.a('X');
            return i1 + 3;
        }
        if (a(s, i1, 3, "TIA", "TCH"))
        {
            a1.a('X');
            return i1 + 3;
        }
        if (a(s, i1, 2, "TH") || a(s, i1, 3, "TTH"))
        {
            if (a(s, i1 + 2, 2, "OM", "AM") || a(s, 0, 4, "VAN ", "VON ") || a(s, 0, 3, "SCH"))
            {
                a1.a('T');
            } else
            {
                a1.a('0', 'T');
            }
            return i1 + 2;
        }
        a1.a('T');
        if (a(s, i1 + 1, 1, "T", "D"))
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    private int k(String s, a a1, int i1)
    {
        if (a(s, i1, 2, "WR"))
        {
            a1.a('R');
            return i1 + 2;
        }
        if (i1 == 0 && (a(a(s, i1 + 1)) || a(s, i1, 2, "WH")))
        {
            if (a(a(s, i1 + 1)))
            {
                a1.a('A', 'F');
            } else
            {
                a1.a('A');
            }
            return i1 + 1;
        }
        if (i1 == s.length() - 1 && a(a(s, i1 - 1)) || a(s, i1 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") || a(s, 0, 3, "SCH"))
        {
            a1.c('F');
            return i1 + 1;
        }
        if (a(s, i1, 4, "WICZ", "WITZ"))
        {
            a1.a("TS", "FX");
            return i1 + 4;
        } else
        {
            return i1 + 1;
        }
    }

    private int l(String s, a a1, int i1)
    {
        if (i1 == 0)
        {
            a1.a('S');
            return i1 + 1;
        }
        if (i1 != s.length() - 1 || !a(s, i1 - 3, 3, "IAU", "EAU") && !a(s, i1 - 2, 2, "AU", "OU"))
        {
            a1.a("KS");
        }
        if (a(s, i1 + 1, 1, "C", "X"))
        {
            return i1 + 2;
        } else
        {
            return i1 + 1;
        }
    }

    protected char a(String s, int i1)
    {
        if (i1 < 0 || i1 >= s.length())
        {
            return '\0';
        } else
        {
            return s.charAt(i1);
        }
    }

    public int a()
    {
        return e;
    }

    public String a(String s)
    {
        return a(s, false);
    }

    public String a(String s, boolean flag)
    {
        s = e(s);
        if (s == null)
        {
            return null;
        }
        boolean flag1 = c(s);
        a a1;
        int i1;
        if (d(s))
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        a1 = new a(a());
        do
        {
            if (!a1.c() && i1 <= s.length() - 1)
            {
                switch (s.charAt(i1))
                {
                default:
                    i1++;
                    break;

                case 65: // 'A'
                case 69: // 'E'
                case 73: // 'I'
                case 79: // 'O'
                case 85: // 'U'
                case 89: // 'Y'
                    i1 = a(a1, i1);
                    break;

                case 66: // 'B'
                    a1.a('P');
                    if (a(s, i1 + 1) == 'B')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 199: 
                    a1.a('S');
                    i1++;
                    break;

                case 67: // 'C'
                    i1 = a(s, a1, i1);
                    break;

                case 68: // 'D'
                    i1 = d(s, a1, i1);
                    break;

                case 70: // 'F'
                    a1.a('F');
                    if (a(s, i1 + 1) == 'F')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 71: // 'G'
                    i1 = a(s, a1, i1, flag1);
                    break;

                case 72: // 'H'
                    i1 = f(s, a1, i1);
                    break;

                case 74: // 'J'
                    i1 = b(s, a1, i1, flag1);
                    break;

                case 75: // 'K'
                    a1.a('K');
                    if (a(s, i1 + 1) == 'K')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 76: // 'L'
                    i1 = g(s, a1, i1);
                    break;

                case 77: // 'M'
                    a1.a('M');
                    if (f(s, i1))
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 78: // 'N'
                    a1.a('N');
                    if (a(s, i1 + 1) == 'N')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 209: 
                    a1.a('N');
                    i1++;
                    break;

                case 80: // 'P'
                    i1 = h(s, a1, i1);
                    break;

                case 81: // 'Q'
                    a1.a('K');
                    if (a(s, i1 + 1) == 'Q')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 82: // 'R'
                    i1 = c(s, a1, i1, flag1);
                    break;

                case 83: // 'S'
                    i1 = d(s, a1, i1, flag1);
                    break;

                case 84: // 'T'
                    i1 = j(s, a1, i1);
                    break;

                case 86: // 'V'
                    a1.a('F');
                    if (a(s, i1 + 1) == 'V')
                    {
                        i1 += 2;
                    } else
                    {
                        i1++;
                    }
                    break;

                case 87: // 'W'
                    i1 = k(s, a1, i1);
                    break;

                case 88: // 'X'
                    i1 = l(s, a1, i1);
                    break;

                case 90: // 'Z'
                    i1 = e(s, a1, i1, flag1);
                    break;
                }
            } else
            if (flag)
            {
                return a1.b();
            } else
            {
                return a1.a();
            }
        } while (true);
    }

    public String b(String s)
    {
        return a(s);
    }

}
