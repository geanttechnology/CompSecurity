// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            a, w, aw

static class 
{

    static void a(w w1, String s)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
label5:
                            {
label6:
                                {
label7:
                                    {
                                        if (s == null)
                                        {
                                            return;
                                        }
                                        w1.b('"');
                                        int l1 = s.length();
                                        int i1 = 0;
label8:
                                        do
                                        {
                                            {
                                                if (i1 >= l1)
                                                {
                                                    break label0;
                                                }
                                                char c1 = s.charAt(i1);
                                                switch (c1)
                                                {
                                                default:
                                                    if (c1 >= ' ' && c1 <= '~')
                                                    {
                                                        w1.b(c1);
                                                    } else
                                                    {
                                                        w1.a("\\u");
                                                        int k1 = c1;
                                                        int j1 = 0;
                                                        while (j1 < 4) 
                                                        {
                                                            int i2 = k1 >> 12 & 0xf;
                                                            k1 <<= 4;
                                                            if (i2 <= 9)
                                                            {
                                                                w1.a(i2);
                                                            } else
                                                            {
                                                                w1.b((char)((i2 - 10) + 97));
                                                            }
                                                            j1++;
                                                        }
                                                    }
                                                    break;

                                                case 8: // '\b'
                                                    break label5;

                                                case 9: // '\t'
                                                    break label1;

                                                case 10: // '\n'
                                                    break label3;

                                                case 12: // '\f'
                                                    break label4;

                                                case 13: // '\r'
                                                    break label2;

                                                case 34: // '"'
                                                    break label8;

                                                case 47: // '/'
                                                    break label6;

                                                case 92: // '\\'
                                                    break label7;
                                                }
                                            }
                                            i1++;
                                        } while (true);
                                        w1.a("\\\"");
                                        break MISSING_BLOCK_LABEL_125;
                                    }
                                    w1.a("\\\\");
                                    break MISSING_BLOCK_LABEL_125;
                                }
                                w1.a("\\/");
                                break MISSING_BLOCK_LABEL_125;
                            }
                            w1.a("\\b");
                            break MISSING_BLOCK_LABEL_125;
                        }
                        w1.a("\\f");
                        break MISSING_BLOCK_LABEL_125;
                    }
                    w1.a("\\n");
                    break MISSING_BLOCK_LABEL_125;
                }
                w1.a("\\r");
                break MISSING_BLOCK_LABEL_125;
            }
            w1.a("\\t");
            break MISSING_BLOCK_LABEL_125;
        }
        w1.b('"');
    }

    void a(w w1)
    {
    }

    boolean a()
    {
        return false;
    }

    String b()
    {
        return o();
    }

    boolean c()
    {
        return false;
    }

    double d()
    {
        return 0.0D;
    }

    int e()
    {
        return 0;
    }

    boolean f()
    {
        return false;
    }

    boolean g()
    {
        return true;
    }

    o h()
    {
        return null;
    }

    boolean i()
    {
        return false;
    }

    boolean j()
    {
        return false;
    }

    boolean k()
    {
        return false;
    }

    boolean l()
    {
        return false;
    }

    o m()
    {
        return null;
    }

    final boolean n()
    {
        return i() || c();
    }

    final String o()
    {
        aw aw1 = new aw();
        a(aw1);
        return aw1.toString();
    }

    public String toString()
    {
        return o();
    }

    ()
    {
    }
}
