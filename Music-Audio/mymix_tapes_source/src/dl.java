// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Vector;

public class dl extends cy
    implements df
{

    private static final bm c = d.a(dl);
    public String b;
    private dm d;
    private Object e;
    private cd f;

    public dl(String s, short word0, String s1, byte abyte0[], String s2, bi bi, bi bi1, 
            String s3, Vector vector, dh dh)
    {
        boolean flag;
        byte byte0;
        long l;
        super(s, word0, s2, bi, bi1);
        if (s1 == null)
        {
            throw new IllegalArgumentException(" application id is null.");
        }
        b = s1;
        if (abyte0 == null)
        {
            throw new IllegalArgumentException(" application key is null");
        }
        flag = true;
        l = 0x500000L;
        byte0 = 7;
        s = null;
        if (vector == null || vector.size() == 0)
        {
            bi = new Vector();
            l = 0x500000L;
            s = null;
            byte0 = 7;
            flag = true;
            break MISSING_BLOCK_LABEL_96;
        }
        bi1 = new Vector(vector.size());
        j = 0;
_L2:
        if (j >= vector.size())
        {
            break; /* Loop/switch isn't completed */
        }
        cz1 = (cz)vector.elementAt(j);
        bi = s;
        l1 = l;
        k = byte0;
        flag1 = flag;
        if (cz1.d() == cz.a.a)
        {
            if (cz1.a().equals("DEVICE_CMD_LOG_TO_SERVER_ENABLED"))
            {
                e = new Vector();
                flag1 = flag;
                k = byte0;
                l1 = l;
                bi = s;
            } else
            {
label0:
                {
                    if (!cz1.a().equals("Calllog_Disable"))
                    {
                        break MISSING_BLOCK_LABEL_401;
                    }
                    if (!(new String(cz1.b())).equals("TRUE") && !(new String(cz1.b())).equals("true"))
                    {
                        break label0;
                    }
                    flag1 = false;
                    bi = s;
                    l1 = l;
                    k = byte0;
                }
            }
        }
_L5:
        bi1.addElement(cz1);
        j++;
        s = bi;
        l = l1;
        byte0 = k;
        flag = flag1;
        if (true) goto _L2; else goto _L1
        if ((new String(cz1.b())).equals("FALSE")) goto _L4; else goto _L3
_L3:
        bi = s;
        l1 = l;
        k = byte0;
        flag1 = flag;
        if (!(new String(cz1.b())).equals("false")) goto _L5; else goto _L4
_L4:
        flag1 = true;
        bi = s;
        l1 = l;
        k = byte0;
          goto _L5
        if (cz1.a().equals("Calllog_Root_Id"))
        {
            bi = new String(cz1.b());
            l1 = l;
            k = byte0;
            flag1 = flag;
        } else
        if (cz1.a().equals("Calllog_Size_Limit"))
        {
            l1 = Long.parseLong(new String(cz1.b()));
            bi = s;
            k = byte0;
            flag1 = flag;
        } else
        {
            bi = s;
            l1 = l;
            k = byte0;
            flag1 = flag;
            if (cz1.a().equals("Calllog_Retention_Days"))
            {
                k = Integer.parseInt(new String(cz1.b()));
                bi = s;
                l1 = l;
                flag1 = flag;
            }
        }
          goto _L5
_L7:
        cz cz1;
        boolean flag1;
        int j;
        int k;
        long l1;
        if (s3 == null && flag)
        {
            c.e("NullPointerException calllogFileName is NULL.");
            throw new NullPointerException("calllogFileName can not be null!");
        }
        if (l < 0L)
        {
            c.e("NMSP_DEFINES_CALLLOG_FILE_SIZE_LIMIT can not be negative!");
            throw new NullPointerException("NMSP_DEFINES_CALLLOG_FILE_SIZE_LIMIT can not be negative!");
        }
        d = new dm(b(), c(), s1, abyte0, s2, bi, c_(), dh);
        if (flag)
        {
            f = new ch(s3, l, byte0, s, a, b, c_(), d.b());
            d.a(((ch)f).b());
        }
        return;
_L1:
        bi = bi1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public final cd a()
    {
        return f;
    }

    public final void b_()
    {
        c.b("shutdown");
        if (f != null)
        {
            ce ce1 = ((ch)f).b();
            if (ce1 != null)
            {
                ce1.a("NMSP_ShutDown").a();
            }
        }
        d.e();
    }

    public final dm h()
    {
        return d;
    }

    public final Object i()
    {
        return e;
    }

}
