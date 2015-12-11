// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;
import java.util.Vector;

// Referenced classes of package RLSDK:
//            bw, v, by, cb, 
//            bx, ag, cc, cn, 
//            n, y, aa

public final class cd extends bw
{

    private static final int g[] = {
        7, 5, 4, 3, 1
    };
    private static final int h[] = {
        4, 20, 52, 104, 204
    };
    private static final int i[] = {
        0, 348, 1388, 2948, 3988
    };
    private static final int j[][] = {
        {
            1, 8, 4, 1
        }, {
            3, 6, 4, 1
        }, {
            3, 4, 6, 1
        }, {
            3, 2, 8, 1
        }, {
            2, 6, 5, 1
        }, {
            2, 2, 9, 1
        }
    };
    private static final int k[][];
    private static final int l[][];
    private static final int m;
    private final Vector n = new Vector(11);
    private final int o[] = new int[2];
    private final int p[];

    public cd()
    {
        p = new int[m];
    }

    private bx a(ag ag1, by by1, boolean flag, boolean flag1)
        throws v
    {
        int ai1[];
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        int j4;
        int k4;
        int l4;
        int ai[] = b;
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = 0;
        ai[3] = 0;
        ai[4] = 0;
        ai[5] = 0;
        ai[6] = 0;
        ai[7] = 0;
        float f;
        float af[];
        float af1[];
        int k1;
        if (flag1)
        {
            b(ag1, by1.b()[0], ai);
        } else
        {
            a(ag1, by1.b()[1] + 1, ai);
            int l1 = 0;
            i1 = ai.length - 1;
            while (l1 < i1) 
            {
                j2 = ai[l1];
                ai[l1] = ai[i1];
                ai[i1] = j2;
                l1++;
                i1--;
            }
        }
        f = (float)a(ai) / 17F;
        ag1 = e;
        ai1 = this.f;
        af = c;
        af1 = d;
        k1 = 0;
        while (k1 < ai.length) 
        {
            float f1 = (1.0F * (float)ai[k1]) / f;
            int j2 = (int)(0.5F + f1);
            int i1;
            if (j2 <= 0)
            {
                i1 = 1;
            } else
            {
                i1 = j2;
                if (j2 > 8)
                {
                    i1 = 8;
                }
            }
            j2 = k1 >> 1;
            if ((k1 & 1) == 0)
            {
                ag1[j2] = i1;
                af[j2] = f1 - (float)i1;
            } else
            {
                ai1[j2] = i1;
                af1[j2] = f1 - (float)i1;
            }
            k1++;
        }
        j4 = a(e);
        k4 = a(this.f);
        l4 = (j4 + k4) - 17;
        if ((j4 & 1) == 1)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if ((k4 & 1) == 0)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        flag3 = false;
        flag4 = false;
        if (j4 <= 13) goto _L2; else goto _L1
_L1:
        flag2 = true;
_L6:
        flag5 = false;
        boolean flag8 = false;
        if (k4 > 13)
        {
            flag4 = true;
        } else
        {
            flag4 = flag8;
            if (k4 < 4)
            {
                flag5 = true;
                flag4 = flag8;
            }
        }
        if (l4 == 1)
        {
            if (flag7)
            {
                if (flag6)
                {
                    throw v.a();
                }
                flag2 = true;
            } else
            {
                if (!flag6)
                {
                    throw v.a();
                }
                flag4 = true;
            }
        } else
        if (l4 == -1)
        {
            if (flag7)
            {
                if (flag6)
                {
                    throw v.a();
                }
                flag3 = true;
            } else
            {
                if (!flag6)
                {
                    throw v.a();
                }
                flag5 = true;
            }
        } else
        if (l4 == 0)
        {
            if (!flag7)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!flag6)
            {
                throw v.a();
            }
            if (j4 < k4)
            {
                flag3 = true;
                flag4 = true;
            } else
            {
                flag2 = true;
                flag5 = true;
            }
        } else
        {
            throw v.a();
        }
          goto _L3
_L2:
        flag2 = flag4;
        if (j4 < 4)
        {
            flag3 = true;
            flag2 = flag4;
        }
        continue; /* Loop/switch isn't completed */
        if (!flag6) goto _L3; else goto _L4
_L4:
        throw v.a();
_L3:
        if (flag3)
        {
            if (flag2)
            {
                throw v.a();
            }
            a(e, c);
        }
        if (flag2)
        {
            b(e, c);
        }
        if (flag5)
        {
            if (flag4)
            {
                throw v.a();
            }
            a(this.f, c);
        }
        if (flag4)
        {
            b(this.f, d);
        }
        int k2 = by1.a();
        int j1;
        int i2;
        int i4;
        if (flag)
        {
            j1 = 0;
        } else
        {
            j1 = 2;
        }
        if (flag1)
        {
            i2 = 0;
        } else
        {
            i2 = 1;
        }
        i4 = (i2 + (k2 * 4 + j1)) - 1;
        j1 = ag1.length;
        i2 = 0;
        k2 = j1 - 1;
        int l2;
        for (j1 = 0; k2 >= 0; j1 = l2)
        {
            l2 = j1;
            if (a(by1, flag, flag1))
            {
                l2 = j1 + k[i4][k2 * 2] * ag1[k2];
            }
            j1 = ag1[k2];
            k2--;
            i2 = j1 + i2;
        }

        k2 = 0;
        for (int i3 = ai1.length - 1; i3 >= 0;)
        {
            int k3 = k2;
            if (a(by1, flag, flag1))
            {
                k3 = k2 + k[i4][i3 * 2 + 1] * ai1[i3];
            }
            i3--;
            k2 = k3;
        }

        if ((i2 & 1) != 0 || i2 > 13 || i2 < 4)
        {
            throw v.a();
        }
        i2 = (13 - i2) / 2;
        int l3 = g[i2];
        int j3 = cb.a(ag1, l3, true);
        l3 = cb.a(ai1, 9 - l3, false);
        i4 = h[i2];
        return new bx(i[i2] + (j3 * i4 + l3), j1 + k2);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private by a(ag ag1, int i1, boolean flag)
    {
        int j1;
        int k1;
        int l1;
        if (flag)
        {
            for (j1 = o[0] - 1; j1 >= 0 && !ag1.a(j1); j1--) { }
            j1++;
            l1 = o[0] - j1;
            k1 = o[1];
        } else
        {
            int j2 = o[0];
            for (j1 = o[1] + 1; ag1.a(j1) && j1 < ag1.b; j1++) { }
            l1 = o[1];
            k1 = j1;
            l1 = j1 - l1;
            j1 = j2;
        }
        ag1 = a;
        for (int i2 = ag1.length - 1; i2 > 0; i2--)
        {
            ag1[i2] = ag1[i2 - 1];
        }

        ag1[0] = l1;
        try
        {
            l1 = a(((int []) (ag1)), j);
        }
        // Misplaced declaration of an exception variable
        catch (ag ag1)
        {
            return null;
        }
        return new by(l1, new int[] {
            j1, k1
        }, j1, k1, i1);
    }

    private cc a(ag ag1, Vector vector, int i1)
        throws v
    {
        by by1;
        int j1;
        int l1;
        int i2;
        int j2;
        int k2;
        boolean flag2;
        int j3;
        boolean flag5;
        if (vector.size() % 2 == 0)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        j2 = 1;
        j1 = -1;
_L17:
        int l2;
        int i3;
        by1 = a;
        by1[0] = 0;
        by1[1] = 0;
        by1[2] = 0;
        by1[3] = 0;
        j3 = ag1.b;
        if (j1 >= 0)
        {
            l1 = j1;
        } else
        if (vector.isEmpty())
        {
            l1 = 0;
        } else
        {
            l1 = ((cc)vector.lastElement()).d().b()[1];
        }
        if (vector.size() % 2 != 0)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        i2 = 0;
        do
        {
            k2 = i2;
            if (l1 >= j3)
            {
                break;
            }
            if (!ag1.a(l1))
            {
                i2 = 1;
            } else
            {
                i2 = 0;
            }
            k2 = i2;
            if (!i2)
            {
                break;
            }
            l1++;
        } while (true);
        i2 = l1;
        i3 = 0;
        l2 = k2;
        k2 = i2;
_L5:
        if (k2 >= j3) goto _L2; else goto _L1
_L1:
        if ((ag1.a(k2) ^ l2) == 0) goto _L4; else goto _L3
_L3:
        by1[i3] = by1[i3] + 1;
        i2 = l2;
        l2 = l1;
_L12:
        k2++;
        l1 = l2;
        l2 = i2;
          goto _L5
_L4:
        if (i3 != 3) goto _L7; else goto _L6
_L6:
        if (flag2)
        {
            c(by1);
        }
        if (!b(by1)) goto _L9; else goto _L8
_L8:
        o[0] = l1;
        o[1] = k2;
        by1 = a(ag1, i1, flag5);
        if (by1 != null) goto _L11; else goto _L10
_L9:
        if (flag2)
        {
            c(by1);
        }
        i2 = l1 + (by1[0] + by1[1]);
        by1[0] = by1[2];
        by1[1] = by1[3];
        by1[2] = 0;
        by1[3] = 0;
        l1 = i3 - 1;
_L13:
        by1[l1] = 1;
        if (l2 == 0)
        {
            boolean flag3 = true;
            l2 = i2;
            i3 = l1;
            i2 = ((flag3) ? 1 : 0);
        } else
        {
            boolean flag4 = false;
            l2 = i2;
            i3 = l1;
            i2 = ((flag4) ? 1 : 0);
        }
          goto _L12
_L7:
        i3++;
        i2 = l1;
        l1 = i3;
          goto _L13
_L2:
        throw v.a();
_L10:
        boolean flag;
        j1 = o[0];
        boolean flag6;
        for (flag6 = ag1.a(j1); j1 < ag1.b && ag1.a(j1) == flag6; j1++) { }
        if (!flag6)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        for (; j1 < ag1.b && ag1.a(j1) == flag6; j1++) { }
        flag = j2;
_L15:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_739;
        }
        j2 = vector.size() + 1;
        if (j2 > p.length)
        {
            throw v.a();
        }
        break; /* Loop/switch isn't completed */
_L11:
        flag = false;
        if (true) goto _L15; else goto _L14
_L14:
        for (i1 = 0; i1 < vector.size(); i1++)
        {
            p[i1] = ((cc)vector.elementAt(i1)).d().a();
        }

        p[j2 - 1] = by1.a();
label0:
        for (i1 = 0; i1 < l.length; i1++)
        {
            vector = l[i1];
            if (vector.length < j2)
            {
                continue;
            }
            boolean flag1 = true;
            int k1 = 0;
            do
            {
label1:
                {
                    flag = flag1;
                    if (k1 < j2)
                    {
                        if (p[k1] == vector[k1])
                        {
                            break label1;
                        }
                        flag = false;
                    }
                    if (!flag)
                    {
                        continue label0;
                    }
                    boolean flag7;
                    if (j2 == vector.length)
                    {
                        flag7 = true;
                    } else
                    {
                        flag7 = false;
                    }
                    vector = a(ag1, by1, flag5, true);
                    try
                    {
                        ag1 = a(ag1, by1, flag5, false);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ag ag1)
                    {
                        if (flag7)
                        {
                            ag1 = null;
                        } else
                        {
                            throw ag1;
                        }
                    }
                    return new cc(vector, ag1, by1, flag7);
                }
                k1++;
            } while (true);
        }

        throw v.a();
        j2 = ((flag) ? 1 : 0);
        if (true) goto _L17; else goto _L16
_L16:
    }

    private static boolean a(by by1, boolean flag, boolean flag1)
    {
        return by1.a() != 0 || !flag || !flag1;
    }

    private static void c(int ai[])
    {
        int j1 = ai.length;
        for (int i1 = 0; i1 < j1 / 2; i1++)
        {
            int k1 = ai[i1];
            ai[i1] = ai[j1 - i1 - 1];
            ai[j1 - i1 - 1] = k1;
        }

    }

    public final y a(int i1, ag ag1, Hashtable hashtable)
        throws v
    {
        a();
        do
        {
            do
            {
                hashtable = a(ag1, n, i1);
                n.addElement(hashtable);
            } while (!hashtable.a());
            cc cc2 = (cc)n.elementAt(0);
            bx bx1 = cc2.b();
            int j1 = cc2.c().b();
            int l2 = 1;
            int i2 = 2;
            for (; l2 < n.size(); l2++)
            {
                cc cc3 = (cc)n.elementAt(l2);
                int k3 = j1 + cc3.b().b();
                int i4 = i2 + 1;
                i2 = i4;
                j1 = k3;
                if (cc3.c() != null)
                {
                    j1 = k3 + cc3.c().b();
                    i2 = i4 + 1;
                }
            }

            if (j1 % 211 + (i2 - 4) * 211 == bx1.a())
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            if (j1 != 0)
            {
                ag1 = n;
                hashtable = n;
                i1 = (hashtable.size() << 1) - 1;
                if (((cc)hashtable.lastElement()).c() == null)
                {
                    i1--;
                }
                ag1 = new ag(i1 * 12);
                int j2 = ((cc)hashtable.elementAt(0)).c().a();
                i1 = 0;
                for (j1 = 11; j1 >= 0; j1--)
                {
                    if ((1 << j1 & j2) != 0)
                    {
                        ag1.b(i1);
                    }
                    i1++;
                }

                break;
            }
            if (hashtable.e())
            {
                throw v.a();
            }
        } while (true);
        for (int k2 = 1; k2 < hashtable.size();)
        {
            cc cc1 = (cc)hashtable.elementAt(k2);
            int i3 = cc1.b().a();
            for (int k1 = 11; k1 >= 0; k1--)
            {
                if ((1 << k1 & i3) != 0)
                {
                    ag1.b(i1);
                }
                i1++;
            }

            int l1;
            if (cc1.c() != null)
            {
                int l3 = cc1.c().a();
                int j3 = 11;
                do
                {
                    l1 = i1;
                    if (j3 < 0)
                    {
                        break;
                    }
                    if ((1 << j3 & l3) != 0)
                    {
                        ag1.b(i1);
                    }
                    i1++;
                    j3--;
                } while (true);
            } else
            {
                l1 = i1;
            }
            k2++;
            i1 = l1;
        }

        ag1 = cn.a(ag1).a();
        aa aaa[] = ((cc)hashtable.elementAt(0)).d().c();
        aa aaa1[] = ((cc)hashtable.lastElement()).d().c();
        hashtable = aaa[0];
        aa aa1 = aaa[1];
        aa aa2 = aaa1[0];
        aa aa3 = aaa1[1];
        n n1 = n.m;
        return new y(ag1, null, new aa[] {
            hashtable, aa1, aa2, aa3
        }, n1);
    }

    public final void a()
    {
        n.setSize(0);
    }

    static 
    {
        Object obj = {
            1, 3, 9, 27, 81, 32, 96, 77
        };
        int ai[] = {
            20, 60, 180, 118, 143, 7, 21, 63
        };
        int ai1[] = {
            189, 145, 13, 39, 117, 140, 209, 205
        };
        int ai2[] = {
            193, 157, 49, 147, 19, 57, 171, 91
        };
        int ai3[] = {
            185, 133, 188, 142, 4, 12, 36, 108
        };
        int ai4[] = {
            113, 128, 173, 97, 80, 29, 87, 50
        };
        int ai5[] = {
            150, 28, 84, 41, 123, 158, 52, 156
        };
        int ai6[] = {
            76, 17, 51, 153, 37, 111, 122, 155
        };
        int ai7[] = {
            43, 129, 176, 106, 107, 110, 119, 146
        };
        int ai8[] = {
            16, 48, 144, 10, 30, 90, 59, 177
        };
        int ai9[] = {
            109, 116, 137, 200, 178, 112, 125, 164
        };
        int ai10[] = {
            70, 210, 208, 202, 184, 130, 179, 115
        };
        int ai11[] = {
            134, 191, 151, 31, 93, 68, 204, 190
        };
        int ai12[] = {
            148, 22, 66, 198, 172, 94, 71, 2
        };
        int ai13[] = {
            6, 18, 54, 162, 64, 192, 154, 40
        };
        int ai14[] = {
            120, 149, 25, 75, 14, 42, 126, 167
        };
        int ai15[] = {
            79, 26, 78, 23, 69, 207, 199, 175
        };
        int ai16[] = {
            103, 98, 83, 38, 114, 131, 182, 124
        };
        int ai17[] = {
            161, 61, 183, 127, 170, 88, 53, 159
        };
        int ai18[] = {
            55, 165, 73, 8, 24, 72, 5, 15
        };
        k = (new int[][] {
            obj, ai, ai1, ai2, new int[] {
                62, 186, 136, 197, 169, 85, 44, 132
            }, ai3, ai4, ai5, new int[] {
                46, 138, 203, 187, 139, 206, 196, 166
            }, ai6, 
            ai7, ai8, ai9, ai10, ai11, ai12, ai13, ai14, ai15, ai16, 
            ai17, ai18, new int[] {
                45, 135, 194, 160, 58, 174, 100, 89
            }
        });
        obj = new int[10][];
        obj[0] = (new int[] {
            0, 0
        });
        obj[1] = (new int[] {
            0, 1, 1
        });
        obj[2] = (new int[] {
            0, 2, 1, 3
        });
        obj[3] = (new int[] {
            0, 4, 1, 3, 2
        });
        obj[4] = (new int[] {
            0, 4, 1, 3, 3, 5
        });
        obj[5] = (new int[] {
            0, 4, 1, 3, 4, 5, 5
        });
        obj[6] = (new int[] {
            0, 0, 1, 1, 2, 2, 3, 3
        });
        obj[7] = (new int[] {
            0, 0, 1, 1, 2, 2, 3, 4, 4
        });
        obj[8] = (new int[] {
            0, 0, 1, 1, 2, 2, 3, 4, 5, 5
        });
        obj[9] = (new int[] {
            0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 
            5
        });
        l = ((int [][]) (obj));
        m = obj[obj.length - 1].length;
    }
}
