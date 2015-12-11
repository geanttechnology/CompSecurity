// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            ax, dh, d, h

class j
{

    j()
    {
    }

    void a(ax ax1)
    {
    }

    void a(ax ax1, String s)
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
                                        ax1.b('"');
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
                                                        ax1.b(c1);
                                                    } else
                                                    {
                                                        ax1.a("\\u");
                                                        int k1 = c1;
                                                        int j1 = 0;
                                                        while (j1 < 4) 
                                                        {
                                                            int i2 = k1 >> 12 & 0xf;
                                                            k1 <<= 4;
                                                            if (i2 <= 9)
                                                            {
                                                                ax1.a(i2);
                                                            } else
                                                            {
                                                                ax1.b((char)((i2 - 10) + 97));
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
                                        ax1.a("\\\"");
                                        break MISSING_BLOCK_LABEL_125;
                                    }
                                    ax1.a("\\\\");
                                    break MISSING_BLOCK_LABEL_125;
                                }
                                ax1.a("\\/");
                                break MISSING_BLOCK_LABEL_125;
                            }
                            ax1.a("\\b");
                            break MISSING_BLOCK_LABEL_125;
                        }
                        ax1.a("\\f");
                        break MISSING_BLOCK_LABEL_125;
                    }
                    ax1.a("\\n");
                    break MISSING_BLOCK_LABEL_125;
                }
                ax1.a("\\r");
                break MISSING_BLOCK_LABEL_125;
            }
            ax1.a("\\t");
            break MISSING_BLOCK_LABEL_125;
        }
        ax1.b('"');
    }

    boolean a()
    {
        return false;
    }

    String b()
    {
        return p();
    }

    boolean b_()
    {
        return false;
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

    d h()
    {
        return null;
    }

    boolean i()
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

    h m()
    {
        return null;
    }

    boolean o()
    {
        return i() || c();
    }

    String p()
    {
        dh dh1 = new dh();
        a(dh1);
        return dh1.toString();
    }

    public String toString()
    {
        return p();
    }
}
