// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import android.graphics.Bitmap;
import android.util.SparseIntArray;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.TimeZone;

// Referenced classes of package com.android.camera.exif:
//            b, k, n, j, 
//            d, ExifInvalidFormatException, i

public class c
{

    public static final int A = a(0, (short)532);
    public static final int B = a(0, (short)-32104);
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G = a(2, (short)-32102);
    public static final int H = a(2, (short)-32099);
    public static final int I = a(2, (short)-30686);
    public static final int J = a(2, (short)-30684);
    public static final int K = a(2, (short)-30681);
    public static final int L = a(2, (short)-30680);
    public static final int M = a(2, (short)-28672);
    public static final int N = a(2, (short)-28669);
    public static final int O = a(2, (short)-28668);
    public static final int P = a(2, (short)-28415);
    public static final int Q = a(2, (short)-28414);
    public static final int R = a(2, (short)-28159);
    public static final int S = a(2, (short)-28158);
    public static final int T = a(2, (short)-28157);
    public static final int U = a(2, (short)-28156);
    public static final int V = a(2, (short)-28155);
    public static final int W = a(2, (short)-28154);
    public static final int X = a(2, (short)-28153);
    public static final int Y = a(2, (short)-28152);
    public static final int Z = a(2, (short)-28151);
    public static final int a = a(0, (short)256);
    public static final int aA = a(2, (short)-23549);
    public static final int aB = a(2, (short)-23548);
    public static final int aC = a(2, (short)-23547);
    public static final int aD = a(2, (short)-23546);
    public static final int aE = a(2, (short)-23545);
    public static final int aF = a(2, (short)-23544);
    public static final int aG = a(2, (short)-23543);
    public static final int aH = a(2, (short)-23542);
    public static final int aI = a(2, (short)-23541);
    public static final int aJ = a(2, (short)-23540);
    public static final int aK = a(2, (short)-23520);
    public static final int aL = a(4, (short)0);
    public static final int aM = a(4, (short)1);
    public static final int aN = a(4, (short)2);
    public static final int aO = a(4, (short)3);
    public static final int aP = a(4, (short)4);
    public static final int aQ = a(4, (short)5);
    public static final int aR = a(4, (short)6);
    public static final int aS = a(4, (short)7);
    public static final int aT = a(4, (short)8);
    public static final int aU = a(4, (short)9);
    public static final int aV = a(4, (short)10);
    public static final int aW = a(4, (short)11);
    public static final int aX = a(4, (short)12);
    public static final int aY = a(4, (short)13);
    public static final int aZ = a(4, (short)14);
    public static final int aa = a(2, (short)-28150);
    public static final int ab = a(2, (short)-28140);
    public static final int ac = a(2, (short)-28036);
    public static final int ad = a(2, (short)-28026);
    public static final int ae = a(2, (short)-28016);
    public static final int af = a(2, (short)-28015);
    public static final int ag = a(2, (short)-28014);
    public static final int ah = a(2, (short)-24576);
    public static final int ai = a(2, (short)-24575);
    public static final int aj = a(2, (short)-24574);
    public static final int ak = a(2, (short)-24573);
    public static final int al = a(2, (short)-24572);
    public static final int am;
    public static final int an = a(2, (short)-24053);
    public static final int ao = a(2, (short)-24052);
    public static final int ap = a(2, (short)-24050);
    public static final int aq = a(2, (short)-24049);
    public static final int ar = a(2, (short)-24048);
    public static final int as = a(2, (short)-24044);
    public static final int at = a(2, (short)-24043);
    public static final int au = a(2, (short)-24041);
    public static final int av = a(2, (short)-23808);
    public static final int aw = a(2, (short)-23807);
    public static final int ax = a(2, (short)-23806);
    public static final int ay = a(2, (short)-23551);
    public static final int az = a(2, (short)-23550);
    public static final int b = a(0, (short)257);
    public static final int ba = a(4, (short)15);
    public static final int bb = a(4, (short)16);
    public static final int bc = a(4, (short)17);
    public static final int bd = a(4, (short)18);
    public static final int be = a(4, (short)19);
    public static final int bf = a(4, (short)20);
    public static final int bg = a(4, (short)21);
    public static final int bh = a(4, (short)22);
    public static final int bi = a(4, (short)23);
    public static final int bj = a(4, (short)24);
    public static final int bk = a(4, (short)25);
    public static final int bl = a(4, (short)26);
    public static final int bm = a(4, (short)27);
    public static final int bn = a(4, (short)28);
    public static final int bo = a(4, (short)29);
    public static final int bp = a(4, (short)30);
    public static final int bq = a(3, (short)1);
    protected static HashSet br;
    public static final ByteOrder bs;
    private static HashSet bt;
    public static final int c = a(0, (short)258);
    public static final int d = a(0, (short)259);
    public static final int e = a(0, (short)262);
    public static final int f = a(0, (short)270);
    public static final int g = a(0, (short)271);
    public static final int h = a(0, (short)272);
    public static final int i;
    public static final int j = a(0, (short)274);
    public static final int k = a(0, (short)277);
    public static final int l = a(0, (short)278);
    public static final int m;
    public static final int n = a(0, (short)282);
    public static final int o = a(0, (short)283);
    public static final int p = a(0, (short)284);
    public static final int q = a(0, (short)296);
    public static final int r = a(0, (short)301);
    public static final int s = a(0, (short)305);
    public static final int t = a(0, (short)306);
    public static final int u = a(0, (short)315);
    public static final int v = a(0, (short)318);
    public static final int w = a(0, (short)319);
    public static final int x = a(0, (short)529);
    public static final int y = a(0, (short)530);
    public static final int z = a(0, (short)531);
    private b bu;
    private final DateFormat bv = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    private final DateFormat bw = new SimpleDateFormat("yyyy:MM:dd");
    private final Calendar bx = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray by;

    public c()
    {
        bu = new b(bs);
        by = null;
        bw.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static int a(int i1, short word0)
    {
        return 0xffff & word0 | i1 << 16;
    }

    protected static int a(int ai1[])
    {
        if (ai1 != null && ai1.length != 0) goto _L2; else goto _L1
_L1:
        int k1 = 0;
_L4:
        return k1;
_L2:
        int ai2[];
        int i1;
        int j1;
        ai2 = com.android.camera.exif.k.a();
        j1 = 0;
        i1 = 0;
_L5:
        k1 = i1;
        if (j1 >= 5) goto _L4; else goto _L3
_L3:
        int i2;
        i2 = ai1.length;
        k1 = 0;
_L6:
label0:
        {
            int l1 = i1;
            if (k1 < i2)
            {
                l1 = ai1[k1];
                if (ai2[j1] != l1)
                {
                    break label0;
                }
                l1 = i1 | 1 << j1;
            }
            j1++;
            i1 = l1;
        }
          goto _L5
        k1++;
          goto _L6
    }

    public static short a(int i1)
    {
        return (short)i1;
    }

    protected static boolean a(short word0)
    {
        return bt.contains(Short.valueOf(word0));
    }

    private static n[] a(double d1)
    {
        d1 = Math.abs(d1);
        int i1 = (int)d1;
        d1 = (d1 - (double)i1) * 60D;
        int j1 = (int)d1;
        int k1 = (int)((d1 - (double)j1) * 6000D);
        return (new n[] {
            new n(i1, 1L), new n(j1, 1L), new n(k1, 100L)
        });
    }

    public static int b(int i1)
    {
        return i1 >>> 16;
    }

    private void c()
    {
        int i1 = a(new int[] {
            0, 1
        }) << 24;
        by.put(g, i1 | 0x20000 | 0);
        by.put(a, i1 | 0x40000 | 1);
        by.put(b, i1 | 0x40000 | 1);
        by.put(c, i1 | 0x30000 | 3);
        by.put(d, i1 | 0x30000 | 1);
        by.put(e, i1 | 0x30000 | 1);
        by.put(j, i1 | 0x30000 | 1);
        by.put(k, i1 | 0x30000 | 1);
        by.put(p, i1 | 0x30000 | 1);
        by.put(y, i1 | 0x30000 | 2);
        by.put(z, i1 | 0x30000 | 1);
        by.put(n, i1 | 0x50000 | 1);
        by.put(o, i1 | 0x50000 | 1);
        by.put(q, i1 | 0x30000 | 1);
        by.put(i, i1 | 0x40000 | 0);
        by.put(l, i1 | 0x40000 | 1);
        by.put(m, i1 | 0x40000 | 0);
        by.put(r, i1 | 0x30000 | 0x300);
        by.put(v, i1 | 0x50000 | 2);
        by.put(w, i1 | 0x50000 | 6);
        by.put(x, i1 | 0x50000 | 3);
        by.put(A, i1 | 0x50000 | 6);
        by.put(t, i1 | 0x20000 | 0x14);
        by.put(f, i1 | 0x20000 | 0);
        by.put(g, i1 | 0x20000 | 0);
        by.put(h, i1 | 0x20000 | 0);
        by.put(s, i1 | 0x20000 | 0);
        by.put(u, i1 | 0x20000 | 0);
        by.put(B, i1 | 0x20000 | 0);
        by.put(C, i1 | 0x40000 | 1);
        by.put(D, i1 | 0x40000 | 1);
        i1 = a(new int[] {
            1
        }) << 24;
        by.put(E, i1 | 0x40000 | 1);
        by.put(F, i1 | 0x40000 | 1);
        i1 = a(new int[] {
            2
        }) << 24;
        by.put(M, i1 | 0x70000 | 4);
        by.put(ah, i1 | 0x70000 | 4);
        by.put(ai, i1 | 0x30000 | 1);
        by.put(P, i1 | 0x70000 | 4);
        by.put(Q, i1 | 0x50000 | 1);
        by.put(aj, i1 | 0x40000 | 1);
        by.put(ak, i1 | 0x40000 | 1);
        by.put(ac, i1 | 0x70000 | 0);
        by.put(ad, i1 | 0x70000 | 0);
        by.put(al, i1 | 0x20000 | 0xd);
        by.put(N, i1 | 0x20000 | 0x14);
        by.put(O, i1 | 0x20000 | 0x14);
        by.put(ae, i1 | 0x20000 | 0);
        by.put(af, i1 | 0x20000 | 0);
        by.put(ag, i1 | 0x20000 | 0);
        by.put(aK, i1 | 0x20000 | 0x21);
        by.put(G, i1 | 0x50000 | 1);
        by.put(H, i1 | 0x50000 | 1);
        by.put(I, i1 | 0x30000 | 1);
        by.put(J, i1 | 0x20000 | 0);
        by.put(K, i1 | 0x30000 | 0);
        by.put(L, i1 | 0x70000 | 0);
        by.put(R, 0xa0000 | i1 | 1);
        by.put(S, i1 | 0x50000 | 1);
        by.put(T, 0xa0000 | i1 | 1);
        by.put(U, 0xa0000 | i1 | 1);
        by.put(V, i1 | 0x50000 | 1);
        by.put(W, i1 | 0x50000 | 1);
        by.put(X, i1 | 0x30000 | 1);
        by.put(Y, i1 | 0x30000 | 1);
        by.put(Z, i1 | 0x30000 | 1);
        by.put(aa, i1 | 0x50000 | 1);
        by.put(ab, i1 | 0x30000 | 0);
        by.put(an, i1 | 0x50000 | 1);
        by.put(ao, i1 | 0x70000 | 0);
        by.put(ap, i1 | 0x50000 | 1);
        by.put(aq, i1 | 0x50000 | 1);
        by.put(ar, i1 | 0x30000 | 1);
        by.put(as, i1 | 0x30000 | 2);
        by.put(at, i1 | 0x50000 | 1);
        by.put(au, i1 | 0x30000 | 1);
        by.put(av, i1 | 0x70000 | 1);
        by.put(aw, i1 | 0x70000 | 1);
        by.put(ax, i1 | 0x70000 | 0);
        by.put(ay, i1 | 0x30000 | 1);
        by.put(az, i1 | 0x30000 | 1);
        by.put(aA, i1 | 0x30000 | 1);
        by.put(aB, i1 | 0x50000 | 1);
        by.put(aC, i1 | 0x30000 | 1);
        by.put(aD, i1 | 0x30000 | 1);
        by.put(aE, i1 | 0x50000 | 1);
        by.put(aF, i1 | 0x30000 | 1);
        by.put(aG, i1 | 0x30000 | 1);
        by.put(aH, i1 | 0x30000 | 1);
        by.put(aI, i1 | 0x70000 | 0);
        by.put(aJ, i1 | 0x30000 | 1);
        by.put(am, i1 | 0x40000 | 1);
        i1 = a(new int[] {
            4
        }) << 24;
        by.put(aL, 0x10000 | i1 | 4);
        by.put(aM, i1 | 0x20000 | 2);
        by.put(aO, i1 | 0x20000 | 2);
        by.put(aN, 0xa0000 | i1 | 3);
        by.put(aP, 0xa0000 | i1 | 3);
        by.put(aQ, 0x10000 | i1 | 1);
        by.put(aR, i1 | 0x50000 | 1);
        by.put(aS, i1 | 0x50000 | 3);
        by.put(aT, i1 | 0x20000 | 0);
        by.put(aU, i1 | 0x20000 | 2);
        by.put(aV, i1 | 0x20000 | 2);
        by.put(aW, i1 | 0x50000 | 1);
        by.put(aX, i1 | 0x20000 | 2);
        by.put(aY, i1 | 0x50000 | 1);
        by.put(aZ, i1 | 0x20000 | 2);
        by.put(ba, i1 | 0x50000 | 1);
        by.put(bb, i1 | 0x20000 | 2);
        by.put(bc, i1 | 0x50000 | 1);
        by.put(bd, i1 | 0x20000 | 0);
        by.put(be, i1 | 0x20000 | 2);
        by.put(bf, i1 | 0x50000 | 1);
        by.put(bi, i1 | 0x20000 | 2);
        by.put(bj, i1 | 0x50000 | 1);
        by.put(bk, i1 | 0x20000 | 2);
        by.put(bl, i1 | 0x50000 | 1);
        by.put(bm, i1 | 0x70000 | 0);
        by.put(bn, i1 | 0x70000 | 0);
        by.put(bo, i1 | 0x20000 | 0xb);
        by.put(bp, i1 | 0x30000 | 0xb);
        i1 = a(new int[] {
            3
        });
        by.put(bq, i1 << 24 | 0x20000 | 0);
    }

    protected static boolean d(int i1, int j1)
    {
        boolean flag1 = false;
        int ai1[] = com.android.camera.exif.k.a();
        int k1 = f(i1);
        i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < ai1.length)
                {
                    if (j1 != ai1[i1] || (k1 >> i1 & 1) != 1)
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

    protected static int f(int i1)
    {
        return i1 >>> 24;
    }

    protected static short g(int i1)
    {
        return (short)(i1 >> 16 & 0xff);
    }

    protected static int h(int i1)
    {
        return 0xffff & i1;
    }

    public j a(int i1, int j1)
    {
        if (!com.android.camera.exif.j.a(j1))
        {
            return null;
        } else
        {
            return bu.a(a(i1), j1);
        }
    }

    public j a(int i1, int j1, Object obj)
    {
        int k1 = b().get(i1);
        j j2;
        if (k1 == 0 || obj == null)
        {
            j2 = null;
        } else
        {
            short word0 = g(k1);
            int l1 = h(k1);
            boolean flag;
            if (l1 != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!d(k1, j1))
            {
                return null;
            }
            j j3 = new j(a(i1), word0, l1, j1, flag);
            j2 = j3;
            if (!j3.a(obj))
            {
                return null;
            }
        }
        return j2;
    }

    public j a(int i1, Object obj)
    {
        return a(i1, b(i1), obj);
    }

    public j a(j j1)
    {
        return bu.a(j1);
    }

    public OutputStream a(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            throw new IllegalArgumentException("Argument is null");
        } else
        {
            outputstream = new d(outputstream, this);
            outputstream.a(bu);
            return outputstream;
        }
    }

    public void a()
    {
        bu.a(null);
    }

    public void a(Bitmap bitmap, OutputStream outputstream)
    {
        if (bitmap == null || outputstream == null)
        {
            throw new IllegalArgumentException("Argument is null");
        } else
        {
            outputstream = a(outputstream);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 90, outputstream);
            outputstream.flush();
            return;
        }
    }

    public void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("Argument is null");
        }
        try
        {
            inputstream = (new i(this)).a(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new IOException((new StringBuilder()).append("Invalid exif format : ").append(inputstream).toString());
        }
        bu = inputstream;
    }

    public void a(byte abyte0[])
    {
        a(((InputStream) (new ByteArrayInputStream(abyte0))));
    }

    public void a(byte abyte0[], OutputStream outputstream)
    {
        if (abyte0 == null || outputstream == null)
        {
            throw new IllegalArgumentException("Argument is null");
        } else
        {
            outputstream = a(outputstream);
            outputstream.write(abyte0, 0, abyte0.length);
            outputstream.flush();
            return;
        }
    }

    public boolean a(double d1, double d2)
    {
        j j1 = a(aN, a(d1));
        j j2 = a(aP, a(d2));
        int i1 = aM;
        Object obj;
        j j3;
        if (d1 >= 0.0D)
        {
            obj = "N";
        } else
        {
            obj = "S";
        }
        j3 = a(i1, obj);
        i1 = aO;
        if (d2 >= 0.0D)
        {
            obj = "E";
        } else
        {
            obj = "W";
        }
        obj = a(i1, obj);
        if (j1 == null || j2 == null || j3 == null || obj == null)
        {
            return false;
        } else
        {
            a(j1);
            a(j2);
            a(j3);
            a(((j) (obj)));
            return true;
        }
    }

    protected SparseIntArray b()
    {
        if (by == null)
        {
            by = new SparseIntArray();
            c();
        }
        return by;
    }

    public Integer b(int i1, int j1)
    {
        int ai1[] = c(i1, j1);
        if (ai1 == null || ai1.length <= 0)
        {
            return null;
        } else
        {
            return new Integer(ai1[0]);
        }
    }

    public Integer c(int i1)
    {
        return b(i1, d(i1));
    }

    public int[] c(int i1, int j1)
    {
        j j2 = a(i1, j1);
        if (j2 == null)
        {
            return null;
        } else
        {
            return j2.g();
        }
    }

    public int d(int i1)
    {
        if (b().get(i1) == 0)
        {
            return -1;
        } else
        {
            return b(i1);
        }
    }

    protected j e(int i1)
    {
        int j1 = b().get(i1);
        if (j1 == 0)
        {
            return null;
        }
        short word0 = g(j1);
        j1 = h(j1);
        int k1;
        boolean flag;
        if (j1 != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        k1 = b(i1);
        return new j(a(i1), word0, j1, k1, flag);
    }

    static 
    {
        i = a(0, (short)273);
        m = a(0, (short)279);
        C = a(0, (short)-30871);
        D = a(0, (short)-30683);
        E = a(1, (short)513);
        F = a(1, (short)514);
        am = a(2, (short)-24571);
        bt = new HashSet();
        bt.add(Short.valueOf(a(D)));
        bt.add(Short.valueOf(a(C)));
        bt.add(Short.valueOf(a(E)));
        bt.add(Short.valueOf(a(am)));
        bt.add(Short.valueOf(a(i)));
        br = new HashSet(bt);
        br.add(Short.valueOf(a(-1)));
        br.add(Short.valueOf(a(F)));
        br.add(Short.valueOf(a(m)));
        bs = ByteOrder.BIG_ENDIAN;
    }
}
