// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;

public class dq extends dv
    implements bn.b, cx
{

    private static final bm a = d.a(dq);
    private int b;
    private dm c;
    private boolean d;
    private bn e;

    public dq(String s, dm dm1, bn bn1)
    {
        super(s, (byte)1);
        d = false;
        c = dm1;
        e = bn1;
        b = dm1.c();
        s = new bn.a((byte)1, null);
        dm1 = Thread.currentThread();
        bn1.a();
        bn1.a(s, this, dm1);
    }

    protected final int a()
    {
        return b;
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (bn.a)obj;
        ((bn.a) (obj)).a;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 33
    //                   2 45;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        c.a(b);
        return;
_L3:
        obj1 = ((Object) ((Object[])((bn.a) (obj)).b));
        obj = (byte[])obj1[0];
        boolean flag = ((Boolean)obj1[1]).booleanValue();
        if (obj != null)
        {
            if (bx.b(c.i()))
            {
                obj1 = new ByteArrayOutputStream();
                if (obj.length < 128)
                {
                    ((ByteArrayOutputStream) (obj1)).write(obj.length & 0x7f);
                } else
                if (obj.length < 16384)
                {
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 7 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length & 0x7f);
                } else
                if (obj.length < 0x200000)
                {
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 14 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 7 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length & 0x7f);
                } else
                if (obj.length < 0x10000000)
                {
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 21 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 14 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length >> 7 & 0x7f | 0x80);
                    ((ByteArrayOutputStream) (obj1)).write(obj.length & 0x7f);
                } else
                {
                    a.e("buffer size is too big!");
                    return;
                }
                ((ByteArrayOutputStream) (obj1)).write(((byte []) (obj)), 0, obj.length);
                c.a(((ByteArrayOutputStream) (obj1)).toByteArray(), b);
            } else
            {
                c.a(((byte []) (obj)), b);
            }
        }
        if (flag)
        {
            c.b(b);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void a(byte abyte0[], int i, int j, boolean flag)
        throws dc
    {
        if (abyte0 == null && !flag)
        {
            a.e("PDXAudioParam.addAudioBuf() in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
            throw new NullPointerException("in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
        }
        if (abyte0 != null && i < 0)
        {
            a.e("PDXAudioParam.addAudioBuf() the offset of the \"buffer\" is less than 0");
            throw new IllegalArgumentException("the offset of the \"buffer\" is less than 0");
        }
        if (abyte0 != null && j <= 0)
        {
            a.e("PDXAudioParam.addAudioBuf() the indicated length of the \"buffer\" is less than 1 byte");
            throw new IllegalArgumentException("the indicated length of the \"buffer\" is less than 1 byte");
        }
        if (d)
        {
            a.e("PDXAudioParam.addAudioBuf() last audio buffer already added!");
            throw new dc("last audio buffer already added!");
        }
        if (flag)
        {
            d = true;
        }
        byte abyte1[] = null;
        if (abyte0 != null)
        {
            abyte1 = new byte[j];
            System.arraycopy(abyte0, i, abyte1, 0, j);
        }
        Object obj = new Boolean(flag);
        abyte0 = e;
        bn.a a1 = new bn.a((byte)2, ((Object) (new Object[] {
            abyte1, obj
        })));
        obj = Thread.currentThread();
        e.a();
        abyte0.a(a1, this, obj);
    }

}
