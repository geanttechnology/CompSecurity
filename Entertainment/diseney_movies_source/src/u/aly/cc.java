// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

// Referenced classes of package u.aly:
//            dl, da, cf, cy, 
//            ct, cg, db, bz

public class cc
{

    private final cy a;
    private final dl b;

    public cc()
    {
        this(((da) (new cs.a())));
    }

    public cc(da da1)
    {
        b = new dl();
        a = da1.a(b);
    }

    private transient Object a(byte byte0, byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        abyte0 = j(abyte0, cg1, acg);
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        byte0;
        JVM INSTR lookupswitch 8: default 88
    //                   2: 104
    //                   3: 141
    //                   4: 178
    //                   6: 215
    //                   8: 253
    //                   10: 289
    //                   11: 327
    //                   100: 360;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        b.e();
        a.B();
        return null;
_L3:
        if (((ct) (abyte0)).b != 2) goto _L2; else goto _L11
_L11:
        boolean flag = a.t();
        b.e();
        a.B();
        return Boolean.valueOf(flag);
_L4:
        if (((ct) (abyte0)).b != 3) goto _L2; else goto _L12
_L12:
        byte byte1 = a.u();
        b.e();
        a.B();
        return Byte.valueOf(byte1);
_L5:
        if (((ct) (abyte0)).b != 4) goto _L2; else goto _L13
_L13:
        double d1 = a.y();
        b.e();
        a.B();
        return Double.valueOf(d1);
_L6:
        if (((ct) (abyte0)).b != 6) goto _L2; else goto _L14
_L14:
        short word0 = a.v();
        b.e();
        a.B();
        return Short.valueOf(word0);
_L7:
        if (((ct) (abyte0)).b != 8) goto _L2; else goto _L15
_L15:
        byte0 = a.w();
        b.e();
        a.B();
        return Integer.valueOf(byte0);
_L8:
        if (((ct) (abyte0)).b != 10) goto _L2; else goto _L16
_L16:
        long l = a.x();
        b.e();
        a.B();
        return Long.valueOf(l);
_L9:
        if (((ct) (abyte0)).b != 11) goto _L2; else goto _L17
_L17:
        abyte0 = a.z();
        b.e();
        a.B();
        return abyte0;
_L10:
        if (((ct) (abyte0)).b != 11) goto _L2; else goto _L18
_L18:
        abyte0 = a.A();
        b.e();
        a.B();
        return abyte0;
        abyte0;
        throw new cf(abyte0);
        abyte0;
        b.e();
        a.B();
        throw abyte0;
    }

    private transient ct j(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        Object obj;
        cg acg1[];
        int k;
        boolean flag;
        obj = null;
        flag = false;
        b.a(abyte0);
        acg1 = new cg[acg.length + 1];
        acg1[0] = cg1;
        k = 0;
_L5:
        if (k < acg.length) goto _L2; else goto _L1
_L1:
        a.j();
        abyte0 = null;
        k = ((flag) ? 1 : 0);
_L8:
        if (k < acg1.length) goto _L4; else goto _L3
_L3:
        return abyte0;
_L2:
        acg1[k + 1] = acg[k];
        k++;
          goto _L5
_L4:
        cg1 = a.l();
        abyte0 = obj;
        if (((ct) (cg1)).b == 0) goto _L3; else goto _L6
_L6:
        abyte0 = obj;
        if (((ct) (cg1)).c > acg1[k].a()) goto _L3; else goto _L7
_L7:
        if (((ct) (cg1)).c != acg1[k].a())
        {
            db.a(a, ((ct) (cg1)).b);
            a.m();
            abyte0 = cg1;
        } else
        {
            int l = k + 1;
            abyte0 = cg1;
            k = l;
            if (l < acg1.length)
            {
                a.j();
                abyte0 = cg1;
                k = l;
            }
        }
          goto _L8
    }

    public transient Boolean a(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Boolean)a((byte)2, abyte0, cg1, acg);
    }

    public void a(bz bz1, String s)
        throws cf
    {
        a(bz1, s.getBytes());
    }

    public void a(bz bz1, String s, String s1)
        throws cf
    {
        a(bz1, s.getBytes(s1));
        a.B();
        return;
        bz1;
        throw new cf((new StringBuilder("JVM DOES NOT SUPPORT ENCODING: ")).append(s1).toString());
        bz1;
        a.B();
        throw bz1;
    }

    public void a(bz bz1, byte abyte0[])
        throws cf
    {
        b.a(abyte0);
        bz1.a(a);
        b.e();
        a.B();
        return;
        bz1;
        b.e();
        a.B();
        throw bz1;
    }

    public transient void a(bz bz1, byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        if (j(abyte0, cg1, acg) != null)
        {
            bz1.a(a);
        }
        b.e();
        a.B();
        return;
        bz1;
        throw new cf(bz1);
        bz1;
        b.e();
        a.B();
        throw bz1;
    }

    public transient Byte b(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Byte)a((byte)3, abyte0, cg1, acg);
    }

    public transient Double c(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Double)a((byte)4, abyte0, cg1, acg);
    }

    public transient Short d(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Short)a((byte)6, abyte0, cg1, acg);
    }

    public transient Integer e(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Integer)a((byte)8, abyte0, cg1, acg);
    }

    public transient Long f(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (Long)a((byte)10, abyte0, cg1, acg);
    }

    public transient String g(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (String)a((byte)11, abyte0, cg1, acg);
    }

    public transient ByteBuffer h(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        return (ByteBuffer)a((byte)100, abyte0, cg1, acg);
    }

    public transient Short i(byte abyte0[], cg cg1, cg acg[])
        throws cf
    {
        short word0;
        if (j(abyte0, cg1, acg) == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a.j();
        word0 = a.l().c;
        b.e();
        a.B();
        return Short.valueOf(word0);
        b.e();
        a.B();
        return null;
        abyte0;
        throw new cf(abyte0);
        abyte0;
        b.e();
        a.B();
        throw abyte0;
    }
}
