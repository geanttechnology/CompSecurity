// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class ct extends cp
    implements cw
{

    private static final bm a = d.a(ct);
    private Vector b;

    public ct()
    {
        super((short)16);
        b = new Vector();
    }

    public ct(byte abyte0[])
    {
        super((short)16);
        b = new Vector();
        int k = 0;
        do
        {
            if (k >= abyte0.length)
            {
                break;
            }
            int i1 = k + 1;
            int l = abyte0[k] & 0xff;
            k = a(abyte0, i1);
            i1 += a(k);
            byte abyte1[] = new byte[k];
            System.arraycopy(abyte0, i1, abyte1, 0, abyte1.length);
            k += i1;
            switch (l)
            {
            default:
                a.e((new StringBuilder("PDXSequence() Unknown PDXClass type: ")).append(l).append(". ").toString());
                break;

            case 192: 
                b.addElement(new cr(abyte1));
                break;

            case 4: // '\004'
                b.addElement(new co(abyte1));
                break;

            case 193: 
                b.addElement(new cu(abyte1));
                break;

            case 22: // '\026'
                b.addElement(new cn(abyte1));
                break;

            case 5: // '\005'
                b.addElement(new cs());
                break;

            case 224: 
                b.addElement(new cq(abyte1, (byte)0));
                break;

            case 16: // '\020'
                b.addElement(new ct(abyte1));
                break;
            }
        } while (true);
    }

    public final int a()
    {
        return b.size();
    }

    public final void a(cv cv)
    {
        if (cv == null)
        {
            throw new IllegalArgumentException("value is null.");
        }
        if (((cp)cv).c() != 224)
        {
            a.e("PDXSequence.addDictionary() value is not a valid dictionary.");
            throw new IllegalArgumentException("value is not a valid dictionary. ");
        } else
        {
            b.addElement(cv);
            return;
        }
    }

    public final void a(cw cw1)
    {
        if (cw1 == null)
        {
            throw new IllegalArgumentException("value is null.");
        }
        if (((cp)cw1).c() != 16)
        {
            a.e("PDXSequence.addSequence() value is not a valid sequence.");
            throw new IllegalArgumentException("value is not a valid sequence. ");
        } else
        {
            b.addElement(cw1);
            return;
        }
    }

    public final void a(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("value is null.");
        } else
        {
            s = new cu(s);
            b.addElement(s);
            return;
        }
    }

    public final short b(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getType() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        } else
        {
            return ((cp)b.elementAt(k)).c();
        }
    }

    public final void b(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("value is null.");
        } else
        {
            abyte0 = new co(abyte0);
            b.addElement(abyte0);
            return;
        }
    }

    public final byte[] b()
    {
        ByteArrayOutputStream bytearrayoutputstream;
        Enumeration enumeration;
        bytearrayoutputstream = new ByteArrayOutputStream();
        enumeration = b.elements();
_L10:
        Object obj;
        if (!enumeration.hasMoreElements())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (cp)enumeration.nextElement();
        ((cp) (obj)).c();
        JVM INSTR lookupswitch 7: default 245
    //                   4: 104
    //                   5: 194
    //                   16: 222
    //                   22: 180
    //                   192: 152
    //                   193: 166
    //                   224: 208;
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
            a.e((new StringBuilder("PDXSequence.toByteArray() ")).append(((IOException) (obj)).toString()).append(". ").toString());
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
        return super.a(bytearrayoutputstream.toByteArray());
    }

    public final int c(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getInteger() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 192)
        {
            a.e((new StringBuilder("PDXSequence.getInteger() index ")).append(k).append(" is not a PDXInteger. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return ((cr)cp1).a();
        }
    }

    public final byte[] d(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getByteString() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 4)
        {
            a.e((new StringBuilder("PDXSequence.getByteString() index ")).append(k).append(" is not a PDXByteString. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return ((co)cp1).a();
        }
    }

    public final String e(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getUTF8String() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 193)
        {
            a.e((new StringBuilder("PDXSequence.getUTF8String() index ")).append(k).append(" is not a PDXUTF8String. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return ((cu)cp1).a();
        }
    }

    public final String f(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getAsciiString() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 22)
        {
            a.e((new StringBuilder("PDXSequence.getAsciiString() index ")).append(k).append(" is not a PDXAsciiString. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return ((cn)cp1).a();
        }
    }

    public final cv g(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getDictionary() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 224)
        {
            a.e((new StringBuilder("PDXSequence.getDictionary() index ")).append(k).append(" is not a PDXDictionary. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return (cq)cp1;
        }
    }

    public final cw h(int k)
    {
        if (k >= b.size())
        {
            a.e((new StringBuilder("PDXSequence.getSequence() index ")).append(k).append(" is out of range. ").toString());
            throw new IndexOutOfBoundsException();
        }
        cp cp1 = (cp)b.elementAt(k);
        if (cp1.c() != 16)
        {
            a.e((new StringBuilder("PDXSequence.getSequence() index ")).append(k).append(" is not a PDXSequence. ").toString());
            throw new RuntimeException("index is of wrong type.");
        } else
        {
            return (ct)cp1;
        }
    }

    public final void i(int k)
    {
        cr cr1 = new cr(k);
        b.addElement(cr1);
    }

    protected final String j(int k)
    {
        int l = 0;
        String s1 = "";
        for (; l < k - 1; l++)
        {
            s1 = (new StringBuilder()).append(s1).append("    ").toString();
        }

        String s;
        String s2;
        Object obj;
        Enumeration enumeration;
        if (k > 0)
        {
            s2 = (new StringBuilder()).append(s1).append("    ").toString();
        } else
        {
            s2 = "";
        }
        enumeration = b.elements();
        s = (new StringBuilder()).append("").append("[ \n").toString();
        if (!enumeration.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_523;
        }
        obj = (cp)enumeration.nextElement();
        switch (((cp) (obj)).c())
        {
        default:
            break;

        case 192: 
            break; /* Loop/switch isn't completed */

        case 4: // '\004'
            s = (new StringBuilder()).append(s).append(s2).append("<BYTES> \"").append(((co)obj).a()).append("\" ").toString();
            continue; /* Loop/switch isn't completed */

        case 193: 
            s = (new StringBuilder()).append(s).append(s2).append("<UTF8> \"").append(((cu)obj).a()).append("\" ").toString();
            continue; /* Loop/switch isn't completed */

        case 22: // '\026'
            s = (new StringBuilder()).append(s).append(s2).append("<ASCII> \"").append(((cn)obj).a()).append("\" ").toString();
            continue; /* Loop/switch isn't completed */

        case 5: // '\005'
            s = (new StringBuilder()).append(s).append(s2).append("<NULL> ").toString();
            continue; /* Loop/switch isn't completed */

        case 224: 
            s = (new StringBuilder()).append(s).append(s2).append(((cq)obj).b(k + 1)).toString();
            continue; /* Loop/switch isn't completed */

        case 16: // '\020'
            break;
        }
        break MISSING_BLOCK_LABEL_486;
_L4:
        obj = s;
        if (enumeration.hasMoreElements())
        {
            obj = (new StringBuilder()).append(s).append(",").toString();
        }
        s = (new StringBuilder()).append(((String) (obj))).append("\n").toString();
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_98;
_L1:
        s = (new StringBuilder()).append(s).append(s2).append("<INT> ").append(((cr)obj).a()).toString();
        continue; /* Loop/switch isn't completed */
        s = (new StringBuilder()).append(s).append(s2).append(((ct)obj).j(k + 1)).toString();
        if (true) goto _L4; else goto _L3
_L3:
        return (new StringBuilder()).append(s).append(s1).append("] ").toString();
    }

    public String toString()
    {
        return j(0);
    }

}
