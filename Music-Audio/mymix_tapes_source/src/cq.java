// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

public class cq extends cp
    implements cv
{

    private static final bm a = d.a(cq);
    private Hashtable b;

    public cq()
    {
        super((short)224);
        b = new Hashtable();
    }

    public cq(byte abyte0[])
    {
label0:
        {
            super((short)224);
            b = new Hashtable();
            if (abyte0.length > 0)
            {
                if ((abyte0[0] & 0xff) == 224)
                {
                    break label0;
                }
                a.e("PDXDictionary() Expected a dictionary. ");
            }
            return;
        }
        int j = a(abyte0, 1);
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, abyte0.length - j, abyte1, 0, abyte1.length);
        b(abyte1);
    }

    public cq(byte abyte0[], byte byte0)
    {
        super((short)224);
        b = new Hashtable();
        b(abyte0);
    }

    private void b(byte abyte0[])
    {
        int j = 0;
        do
        {
            int k;
label0:
            {
                if (j < abyte0.length)
                {
                    k = j + 1;
                    j = abyte0[j] & 0xff;
                    if (j == 22)
                    {
                        break label0;
                    }
                    a.e((new StringBuilder("PDXDictionary.setContent() Expected an ASCII string but got ")).append(j).append(". ").toString());
                }
                return;
            }
            j = a(abyte0, k);
            k += a(j);
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, k, abyte1, 0, abyte1.length);
            k = j + k;
            String s = new String(abyte1);
            j = k + 1;
            k = abyte0[k] & 0xff;
            int l = a(abyte0, j);
            j += a(l);
            byte abyte2[] = new byte[l];
            System.arraycopy(abyte0, j, abyte2, 0, abyte2.length);
            j = l + j;
            switch (k)
            {
            default:
                a.e((new StringBuilder("PDXDictionary.setContent() Unknown PDXClass type: ")).append(k).append(". ").toString());
                break;

            case 192: 
                b.put(s, new cr(abyte2));
                break;

            case 4: // '\004'
                b.put(s, new co(abyte2));
                break;

            case 193: 
                b.put(s, new cu(abyte2));
                break;

            case 22: // '\026'
                b.put(s, new cn(abyte2));
                break;

            case 5: // '\005'
                b.put(s, new cs());
                break;

            case 224: 
                b.put(s, new cq(abyte2, (byte)0));
                break;

            case 16: // '\020'
                b.put(s, new ct(abyte2));
                break;
            }
        } while (true);
    }

    public final Enumeration a()
    {
        return b.keys();
    }

    protected final void a(String s, int j)
    {
        b.put(s, new cr(j));
    }

    public final void a(String s, cv cv1)
    {
        if (s == null || cv1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("key is : ")).append(s).append(" value is : ").append(cv1).toString());
        }
        if (((cp)cv1).c() != 224)
        {
            a.e("PDXDictionary.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
        } else
        {
            b.put(s, cv1);
            return;
        }
    }

    public final void a(String s, cw cw)
    {
        if (s == null || cw == null)
        {
            throw new IllegalArgumentException((new StringBuilder("key is : ")).append(s).append(" value is : ").append(cw).toString());
        }
        if (((cp)cw).c() != 16)
        {
            a.e("PDXDictionary.addSequence() value is not a valid sequence.");
            throw new IllegalArgumentException("value is not a valid sequence. ");
        } else
        {
            b.put(s, cw);
            return;
        }
    }

    public final void a(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("key is : ")).append(s).append(" value is : ").append(s1).toString());
        } else
        {
            s1 = new cn(s1);
            b.put(s, s1);
            return;
        }
    }

    public final void a(String s, String s1, short word0)
    {
        switch (word0)
        {
        default:
            return;

        case 193: 
            b.put(s, new cu(s1));
            return;

        case 22: // '\026'
            b.put(s, new cn(s1));
            return;
        }
    }

    public final void a(String s, byte abyte0[])
    {
        if (s == null || abyte0 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("key is : ")).append(s).append(" value is : ").append(abyte0).toString());
        } else
        {
            abyte0 = new co(abyte0);
            b.put(s, abyte0);
            return;
        }
    }

    protected final void a(String s, byte abyte0[], short word0)
    {
        switch (word0)
        {
        default:
            a.e((new StringBuilder("PDXDictionary.put() Unknown PDXClass type: ")).append(word0).append(". ").toString());
            return;

        case 192: 
            b.put(s, new cr(abyte0));
            return;

        case 4: // '\004'
            b.put(s, new co(abyte0));
            return;

        case 193: 
            b.put(s, new cu(abyte0));
            return;

        case 22: // '\026'
            b.put(s, new cn(abyte0));
            return;

        case 5: // '\005'
            b.put(s, new cs());
            return;

        case 224: 
            b.put(s, new cq(abyte0, (byte)0));
            return;

        case 16: // '\020'
            b.put(s, new ct(abyte0));
            return;
        }
    }

    public final boolean a(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("PDXDictionary.containsKey key is null");
        } else
        {
            return b.containsKey(s);
        }
    }

    public final cp b(String s)
    {
        return (cp)b.get(s);
    }

    protected final String b(int j)
    {
        int k = 0;
        String s1 = "";
        for (; k < j - 1; k++)
        {
            s1 = (new StringBuilder()).append(s1).append("    ").toString();
        }

        String s;
        String s2;
        Enumeration enumeration;
        if (j > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("    ").toString();
        } else
        {
            s2 = "";
        }
        enumeration = b.keys();
        if (j != 0)
        {
            s = (new StringBuilder()).append("").append("{ \n").toString();
        } else
        {
            s = "";
        }
        do
        {
            if (enumeration.hasMoreElements())
            {
                String s3 = (String)enumeration.nextElement();
                cp cp1 = (cp)b.get(s3);
                switch (cp1.c())
                {
                case 192: 
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": <INT> ").append(((cr)cp1).a()).append("\n").toString();
                    break;

                case 4: // '\004'
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": <BYTES> \"").append(((co)cp1).a()).append("\"\n").toString();
                    break;

                case 193: 
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": <UTF8> \"").append(((cu)cp1).a()).append("\"\n").toString();
                    break;

                case 22: // '\026'
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": <ASCII> \"").append(((cn)cp1).a()).append("\"\n").toString();
                    break;

                case 5: // '\005'
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": <NULL> \n").toString();
                    break;

                case 224: 
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": ").append(((cq)cp1).b(j + 1)).append("\n").toString();
                    break;

                case 16: // '\020'
                    s = (new StringBuilder()).append(s).append(s2).append(s3).append(": ").append(((ct)cp1).j(j + 1)).append("\n").toString();
                    break;
                }
            } else
            {
                s2 = s;
                if (j != 0)
                {
                    s2 = (new StringBuilder()).append(s).append(s1).append("} ").toString();
                }
                return s2;
            }
        } while (true);
    }

    public final void b(String s, int j)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        } else
        {
            cr cr1 = new cr(j);
            b.put(s, cr1);
            return;
        }
    }

    public final void b(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("key is : ")).append(s).append(" value is : ").append(s1).toString());
        } else
        {
            s1 = new cu(s1);
            b.put(s, s1);
            return;
        }
    }

    public final byte[] b()
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Enumeration enumeration;
        bytearrayoutputstream = new ByteArrayOutputStream();
        enumeration = b.keys();
_L10:
        Object obj;
        cn cn1;
        if (!enumeration.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)enumeration.nextElement();
        cn1 = new cn(((String) (obj)));
        bytearrayoutputstream.write(cn1.b());
        obj = (cp)b.get(obj);
        ((cp) (obj)).c();
        JVM INSTR lookupswitch 7: default 273
    //                   4: 136
    //                   5: 226
    //                   16: 254
    //                   22: 212
    //                   192: 184
    //                   193: 198
    //                   224: 240;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        if (false)
        {
        }
        continue; /* Loop/switch isn't completed */
_L2:
        bytearrayoutputstream.write(((co)obj).b());
        continue; /* Loop/switch isn't completed */
_L6:
        try
        {
            bytearrayoutputstream.write(((cr)obj).b());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            a.e((new StringBuilder("PDXDictionary.getContent() ")).append(((IOException) (obj)).toString()).append(". ").toString());
        }
        continue; /* Loop/switch isn't completed */
_L7:
        bytearrayoutputstream.write(((cu)obj).b());
        continue; /* Loop/switch isn't completed */
_L5:
        bytearrayoutputstream.write(((cn)obj).b());
        continue; /* Loop/switch isn't completed */
_L3:
        bytearrayoutputstream.write(((cs)obj).a());
        continue; /* Loop/switch isn't completed */
_L8:
        bytearrayoutputstream.write(((cq)obj).d());
        continue; /* Loop/switch isn't completed */
_L4:
        bytearrayoutputstream.write(((ct)obj).b());
        if (true) goto _L10; else goto _L9
_L9:
        return bytearrayoutputstream.toByteArray();
    }

    public final short c(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        } else
        {
            return ((cp)b.get(s)).c();
        }
    }

    public final int d(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            if (a.e())
            {
                a.e((new StringBuilder("PDXDictionary.getInteger() ")).append(s).append(" does not exist. ").toString());
            }
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 192)
        {
            if (a.e())
            {
                a.e((new StringBuilder("PDXDictionary.getInteger() ")).append(s).append(" is not a PDXInteger. ").toString());
            }
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return ((cr)cp1).a();
        }
    }

    public byte[] d()
    {
        return super.a(b());
    }

    public final byte[] e(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            a.e((new StringBuilder("PDXDictionary.getByteString() ")).append(s).append(" does not exist. ").toString());
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 4)
        {
            a.e((new StringBuilder("PDXDictionary.getByteString() ")).append(s).append(" is not a PDXByteString. ").toString());
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return ((co)cp1).a();
        }
    }

    public final String f(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            a.e((new StringBuilder("PDXDictionary.getUTF8String() ")).append(s).append(" does not exist. ").toString());
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 193)
        {
            a.e((new StringBuilder("PDXDictionary.getUTF8String() ")).append(s).append(" is not a PDXUTF8String. ").toString());
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return ((cu)cp1).a();
        }
    }

    public final String g(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            a.e((new StringBuilder("PDXDictionary.getAsciiString() ")).append(s).append(" does not exist. ").toString());
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 22)
        {
            a.e((new StringBuilder("PDXDictionary.getAsciiString() ")).append(s).append(" is not a PDXAsciiString. ").toString());
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return ((cn)cp1).a();
        }
    }

    public final cv h(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            a.e((new StringBuilder("PDXDictionary.getDictionary() ")).append(s).append(" does not exist. ").toString());
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 224)
        {
            a.e((new StringBuilder("PDXDictionary.getDictionary() ")).append(s).append(" is not a PDXDictionary. ").toString());
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return (cq)cp1;
        }
    }

    public final cw i(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("key is null.");
        }
        cp cp1 = (cp)b.get(s);
        if (cp1 == null)
        {
            a.e((new StringBuilder("PDXDictionary.getSequence() ")).append(s).append(" does not exist. ").toString());
            throw new RuntimeException("key does not exist. ");
        }
        if (cp1.c() != 16)
        {
            a.e((new StringBuilder("PDXDictionary.getSequence() ")).append(s).append(" is not a PDXSequence. ").toString());
            throw new RuntimeException("key is of wrong type. ");
        } else
        {
            return (ct)cp1;
        }
    }

    public String toString()
    {
        return b(0);
    }

}
