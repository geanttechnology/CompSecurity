// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            cq, ag, ct, cs, 
//            cp, cr, v, cv

final class cw
{

    private final ag a;
    private final cq b = new cq();
    private final StringBuffer c = new StringBuffer();

    cw(ag ag1)
    {
        a = ag1;
    }

    static int a(ag ag1, int i, int j)
    {
        int l = 0;
        if (j > 32)
        {
            throw new IllegalArgumentException("extractNumberValueFromBitArray can't handle more than 32 bits");
        }
        for (int k = 0; k < j;)
        {
            int i1 = l;
            if (ag1.a(i + k))
            {
                i1 = l | 1 << j - k - 1;
            }
            k++;
            l = i1;
        }

        return l;
    }

    private cp a()
    {
_L6:
        int j = b.a;
        if (j + 7 <= a.b) goto _L2; else goto _L1
_L1:
        Object obj;
        int i;
        boolean flag;
        if (j + 4 <= a.b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L3:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        i = b.a;
        if (i + 7 > a.b)
        {
            i = a(i, 4);
            if (i == 0)
            {
                obj = new ct(a.b, 10, 10);
            } else
            {
                obj = new ct(a.b, i - 1, 10);
            }
        } else
        {
            j = a(i, 7);
            obj = new ct(i + 7, (j - 8) / 11, (j - 8) % 11);
        }
        b.a = ((ct) (obj)).e();
        if (((ct) (obj)).c())
        {
            if (((ct) (obj)).d())
            {
                obj = new cs(b.a, c.toString());
            } else
            {
                obj = new cs(b.a, c.toString(), ((ct) (obj)).b());
            }
            return new cp(((cs) (obj)));
        }
        break MISSING_BLOCK_LABEL_294;
_L2:
        i = j;
_L4:
label0:
        {
            if (i >= j + 3)
            {
                break MISSING_BLOCK_LABEL_190;
            }
            if (!a.a(i))
            {
                break label0;
            }
            flag = true;
        }
          goto _L3
        i++;
          goto _L4
        flag = a.a(j + 3);
          goto _L3
        c.append(((ct) (obj)).a());
        if (((ct) (obj)).d())
        {
            return new cp(new cs(b.a, c.toString()));
        }
        c.append(((ct) (obj)).b());
        if (true) goto _L6; else goto _L5
_L5:
        j = b.a;
        if (j + 1 <= a.b) goto _L8; else goto _L7
_L7:
        i = 0;
_L10:
        if (i != 0)
        {
            b.d();
            cq cq1 = b;
            cq1.a = cq1.a + 4;
        }
        return new cp((byte)0);
_L8:
        i = 0;
        do
        {
            if (i >= 4 || i + j >= a.b)
            {
                break;
            }
            if (a.a(j + i))
            {
                i = 0;
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        i = 1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private boolean a(int i)
    {
        if (i + 1 <= a.b) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
_L6:
        if (j >= 5 || j + i >= a.b)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (j != 2) goto _L4; else goto _L3
_L3:
        if (!a.a(i + 2)) goto _L1; else goto _L5
_L5:
        j++;
          goto _L6
_L4:
        if (!a.a(i + j)) goto _L5; else goto _L7
_L7:
        return false;
        return true;
    }

    private cp b()
    {
_L12:
        int i = b.a;
        if (i + 5 > a.b) goto _L2; else goto _L1
_L1:
        int j = a(i, 5);
        if (j < 5 || j >= 16) goto _L4; else goto _L3
_L3:
        i = 1;
_L6:
        cr cr1;
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = b.a;
        int k = a(i, 5);
        if (k == 15)
        {
            cr1 = new cr(i + 5, '$');
        } else
        if (k >= 5 && k < 15)
        {
            cr1 = new cr(i + 5, (char)((k + 48) - 5));
        } else
        {
            int l = a(i, 7);
            if (l >= 64 && l < 90)
            {
                cr1 = new cr(i + 7, (char)(l + 1));
            } else
            {
label0:
                {
                    if (l < 90 || l >= 116)
                    {
                        break label0;
                    }
                    cr1 = new cr(i + 7, (char)(l + 7));
                }
            }
        }
_L10:
        b.a = cr1.e();
        if (cr1.b())
        {
            return new cp(new cs(b.a, c.toString()));
        }
        break MISSING_BLOCK_LABEL_801;
_L4:
        if (i + 7 > a.b) goto _L2; else goto _L5
_L5:
label1:
        {
            k = a(i, 7);
            if (k < 64 || k >= 116)
            {
                break label1;
            }
            i = 1;
        }
          goto _L6
        if (i + 8 > a.b) goto _L2; else goto _L7
_L7:
        i = a(i, 8);
        if (i < 232 || i >= 253) goto _L2; else goto _L8
_L8:
        i = 1;
          goto _L6
_L2:
        i = 0;
          goto _L6
        int i1 = a(i, 8);
        switch (i1)
        {
        default:
            throw new RuntimeException((new StringBuilder("Decoding invalid ISO/IEC 646 value: ")).append(i1).toString());

        case 232: 
            cr1 = new cr(i + 8, '!');
            break;

        case 233: 
            cr1 = new cr(i + 8, '"');
            break;

        case 234: 
            cr1 = new cr(i + 8, '%');
            break;

        case 235: 
            cr1 = new cr(i + 8, '&');
            break;

        case 236: 
            cr1 = new cr(i + 8, '\'');
            break;

        case 237: 
            cr1 = new cr(i + 8, '(');
            break;

        case 238: 
            cr1 = new cr(i + 8, ')');
            break;

        case 239: 
            cr1 = new cr(i + 8, '*');
            break;

        case 240: 
            cr1 = new cr(i + 8, '+');
            break;

        case 241: 
            cr1 = new cr(i + 8, ',');
            break;

        case 242: 
            cr1 = new cr(i + 8, '-');
            break;

        case 243: 
            cr1 = new cr(i + 8, '.');
            break;

        case 244: 
            cr1 = new cr(i + 8, '/');
            break;

        case 245: 
            cr1 = new cr(i + 8, ':');
            break;

        case 246: 
            cr1 = new cr(i + 8, ';');
            break;

        case 247: 
            cr1 = new cr(i + 8, '<');
            break;

        case 248: 
            cr1 = new cr(i + 8, '=');
            break;

        case 249: 
            cr1 = new cr(i + 8, '>');
            break;

        case 250: 
            cr1 = new cr(i + 8, '?');
            break;

        case 251: 
            cr1 = new cr(i + 8, '_');
            break;

        case 252: 
            cr1 = new cr(i + 8, ' ');
            break;
        }
        if (true) goto _L10; else goto _L9
_L9:
        c.append(cr1.a());
        if (true) goto _L12; else goto _L11
_L11:
        if (!b(b.a)) goto _L14; else goto _L13
_L13:
        cq cq1 = b;
        cq1.a = cq1.a + 3;
        b.c();
_L16:
        return new cp((byte)0);
_L14:
        if (a(b.a))
        {
            if (b.a + 5 < a.b)
            {
                cq cq2 = b;
                cq2.a = cq2.a + 5;
            } else
            {
                b.a = a.b;
            }
            b.d();
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    private boolean b(int i)
    {
        if (i + 3 <= a.b) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = i;
label0:
        do
        {
label1:
            {
                if (j >= i + 3)
                {
                    break label1;
                }
                if (a.a(j))
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    final int a(int i, int j)
    {
        return a(a, i, j);
    }

    final cs a(int i, String s)
    {
        c.setLength(0);
        if (s != null)
        {
            c.append(s);
        }
        b.a = i;
_L9:
        int j;
        j = b.a;
        if (!b.a())
        {
            break MISSING_BLOCK_LABEL_660;
        }
_L15:
        i = b.a;
        if (i + 5 > a.b) goto _L2; else goto _L1
_L1:
        int k = a(i, 5);
        if (k < 5 || k >= 16) goto _L4; else goto _L3
_L3:
        i = 1;
_L12:
        if (i == 0) goto _L6; else goto _L5
_L5:
        boolean flag;
        i = b.a;
        int l = a(i, 5);
        if (l == 15)
        {
            s = new cr(i + 5, '$');
        } else
        if (l >= 5 && l < 15)
        {
            s = new cr(i + 5, (char)((l + 48) - 5));
        } else
        {
label0:
            {
                i1 = a(i, 6);
                if (i1 < 32 || i1 >= 58)
                {
                    break label0;
                }
                s = new cr(i + 6, (char)(i1 + 33));
            }
        }
_L14:
        b.a = s.e();
        if (!s.b()) goto _L8; else goto _L7
_L7:
        s = new cp(new cs(b.a, c.toString()));
_L16:
        flag = s.b();
_L17:
        if (j != b.a)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0 && !flag || flag)
        {
            s = s.a();
            int i1;
            if (s != null && s.b())
            {
                return new cs(b.a, c.toString(), s.c());
            } else
            {
                return new cs(b.a, c.toString());
            }
        }
          goto _L9
_L4:
        if (i + 6 > a.b) goto _L2; else goto _L10
_L10:
        i = a(i, 6);
        if (i < 16 || i >= 63) goto _L2; else goto _L11
_L11:
        i = 1;
          goto _L12
_L2:
        i = 0;
          goto _L12
        switch (i1)
        {
        default:
            throw new RuntimeException((new StringBuilder("Decoding invalid alphanumeric value: ")).append(i1).toString());

        case 58: // ':'
            s = new cr(i + 6, '*');
            break;

        case 59: // ';'
            s = new cr(i + 6, ',');
            break;

        case 60: // '<'
            s = new cr(i + 6, '-');
            break;

        case 61: // '='
            s = new cr(i + 6, '.');
            break;

        case 62: // '>'
            s = new cr(i + 6, '/');
            break;
        }
        if (true) goto _L14; else goto _L13
_L13:
_L8:
        c.append(s.a());
          goto _L15
_L6:
        if (b(b.a))
        {
            s = b;
            s.a = ((cq) (s)).a + 3;
            b.c();
        } else
        if (a(b.a))
        {
            if (b.a + 5 < a.b)
            {
                s = b;
                s.a = ((cq) (s)).a + 5;
            } else
            {
                b.a = a.b;
            }
            b.e();
        }
        s = new cp((byte)0);
          goto _L16
        if (b.b())
        {
            s = b();
            flag = s.b();
        } else
        {
            s = a();
            flag = s.b();
        }
          goto _L17
    }

    final String a(StringBuffer stringbuffer, int i)
        throws v
    {
        String s = null;
        do
        {
            cs cs1 = a(i, s);
            stringbuffer.append(cv.a(cs1.a()));
            if (cs1.b())
            {
                s = String.valueOf(cs1.c());
            } else
            {
                s = null;
            }
            if (i != cs1.e())
            {
                i = cs1.e();
            } else
            {
                return stringbuffer.toString();
            }
        } while (true);
    }
}
