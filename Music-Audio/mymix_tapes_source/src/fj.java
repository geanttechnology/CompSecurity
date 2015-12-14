// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Hashtable;
import java.util.Vector;

public class fj
    implements fi
{
    final class a
    {

        public fg a;
        public int b;
        public int c;

        private a()
        {
            a = new fg();
            new Vector();
            b = 0;
            c = 0;
        }

        a(byte byte0)
        {
            this();
        }
    }

    final class b
    {

        public int a;
        public int b;
        public fh c;

        private b()
        {
            a = 0;
            b = 0;
            c = null;
        }

        b(byte byte0)
        {
            this();
        }
    }


    private static final bm a = d.a(fj);
    private byte b[];
    private String c;
    private _cls1 d;

    public fj(byte abyte0[])
    {
        c = "Cp1252";
        d = null;
        b = abyte0;
        Object obj = new Object((byte)0) {

            public int a;
            public int b;
            public int c;
            public int d;
            public int e;

            private 
            {
                a = -1;
                b = -1;
                c = -1;
                d = -1;
                e = -1;
            }

            
            {
                this();
            }
        };
        int i = a(2, b());
        obj.e = i;
        i = b(i + 4, a(i));
        obj.d = i;
        i = a(i + 2, e(i));
        obj.b = a(3, i, abyte0.length);
        obj.c = a(4, i, abyte0.length);
        obj.a = a(1, i, abyte0.length);
        d = obj;
        abyte0 = d;
        if (((_cls1) (abyte0)).c != -1) goto _L2; else goto _L1
_L1:
        abyte0 = "Cp1252";
_L4:
        c = abyte0;
        return;
_L2:
        int j = ((_cls1) (abyte0)).c + 4;
        int k = (int)fr.c(b, j);
        abyte0 = fr.a(b, j + 4, k - 1, "Cp1252");
        Object obj1;
        if (abyte0 == "Windows-1252")
        {
            obj1 = "Cp1252";
        } else
        {
            obj1 = abyte0;
        }
        if (!a(((String) (obj1))))
        {
            abyte0 = "Cp1252";
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private int a(int i)
    {
        i = fr.b(b, i);
        if (a.a())
        {
            a.a((new StringBuilder("Number of sentences: ")).append(i).toString());
        }
        return i;
    }

    private int a(int i, int j)
    {
        int l;
        for (int k = 0; i < b.length && k < j; k = l)
        {
            l = k;
            if (b[i] == 0)
            {
                l = k + 1;
            }
            i++;
        }

        return i;
    }

    private int a(int i, int j, int k)
    {
        long l;
        for (; j < k; j = j + (int)l + 4)
        {
            l = fr.c(b, j);
            if (a.a())
            {
                a.a((new StringBuilder("Received extension id=")).append(l).toString());
            }
            if (l == (long)i)
            {
                return j;
            }
            j += 4;
            l = fr.c(b, j);
            if (a.a())
            {
                a.a((new StringBuilder("Received payload size: ")).append(l).toString());
            }
        }

        return -1;
    }

    private a a(int i, int j, Vector vector)
    {
        boolean flag = false;
        int l = b(i);
        i += 4;
        fg fg1 = new fg();
        a a1 = new a((byte)0);
        int k = j;
        j = i;
        for (i = ((flag) ? 1 : 0); i < l; i++)
        {
            Object obj = a(j, k, 2, vector);
            fg1.a(((b) (obj)).c);
            j = ((b) (obj)).a;
            k = ((b) (obj)).b;
            if (a.a())
            {
                obj = ((b) (obj)).c;
                a.a((new StringBuilder("Extracted word: startTime [")).append(((fh) (obj)).c()).append("] endTime [").append(((fh) (obj)).d()).append("] content [").append(((fh) (obj)).b()).append("]").toString());
            }
        }

        a1.b = j;
        a1.c = k;
        a1.a = fg1;
        return a1;
    }

    private b a(int i, int j, int k, Vector vector)
    {
        b b1 = new b((byte)0);
        int l = fr.a(b, i);
        i += 2;
        vector = (String)vector.elementAt(l - 1);
        double d1;
        long l1;
        long l2;
        if (k == 4)
        {
            l1 = d(i);
            i += k;
            l2 = d(i);
            i += k;
        } else
        {
            l1 = c(i);
            i += k;
            l2 = c(i);
            i += k;
        }
        d1 = 0.0D;
        k = j;
        if (j != -1)
        {
            d1 = fr.a(b, j);
            k = j + 2;
        }
        b1.c = new fh(vector, l1, l2, d1, true, (byte)0);
        b1.a = i;
        b1.b = k;
        return b1;
    }

    private Vector a(_cls1 _pcls1, Vector vector)
    {
        boolean flag1 = false;
        Vector vector1;
        int i;
        boolean flag;
        int j;
        int k;
        int l;
        int i1;
        if (_pcls1.a != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            i = _pcls1.a;
        } else
        {
            i = _pcls1.e;
        }
        if (_pcls1.b != -1)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        j = i;
        if (flag)
        {
            j = i + 4 + 4;
        }
        i1 = a(j);
        l = _pcls1.b;
        i = l;
        if (k != 0)
        {
            i = l + 4 + 4 + 4 + 4;
        }
        vector1 = new Vector();
        j += 4;
        k = i;
        i = ((flag1) ? 1 : 0);
        while (i < i1) 
        {
            if (flag)
            {
                _pcls1 = b(j, k, vector);
            } else
            {
                _pcls1 = a(j, k, vector);
            }
            if (a.a())
            {
                a.a((new StringBuilder("Number of words in Sentence ")).append(i).append(": [").append(((a) (_pcls1)).a.a()).append("]").toString());
            }
            vector1.addElement(((a) (_pcls1)).a);
            j = ((a) (_pcls1)).b;
            k = ((a) (_pcls1)).c;
            if (a.a())
            {
                a.a((new StringBuilder("Extracted sentence: [")).append(((a) (_pcls1)).a).append("]").toString());
            }
            i++;
        }
        return vector1;
    }

    private static void a(Hashtable hashtable)
    {
        for (int i = 0; hashtable.remove((new StringBuilder("CFD")).append(i).toString()) != null; i++) { }
        if (hashtable.containsKey("IAL"))
        {
            hashtable.put("InputAudioLength", hashtable.get("IAL"));
        }
    }

    private static void a(Hashtable hashtable, Vector vector)
    {
        int i = 0;
_L2:
        String s;
        if (i >= vector.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)hashtable.get((new StringBuilder("CFD")).append(i).toString());
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        double d1 = Double.parseDouble(s);
        ((fg)vector.elementAt(i)).a(d1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        NumberFormatException numberformatexception;
        numberformatexception;
          goto _L3
_L1:
    }

    private static boolean a(String s)
    {
        return true;
    }

    private int b()
    {
        int i = fr.a(b, 0);
        if (a.a())
        {
            a.a((new StringBuilder("Number of words: ")).append(i).toString());
        }
        return i;
    }

    private int b(int i)
    {
        return fr.b(b, i);
    }

    private int b(int i, int j)
    {
        for (int k = 0; k < j; k++)
        {
            int i1 = b(i);
            i += 4;
            for (int l = 0; l < i1; l++)
            {
                i += 6;
            }

        }

        return i;
    }

    private a b(int i, int j, Vector vector)
    {
        boolean flag = false;
        int l = b(i);
        i += 4;
        a a1 = new a((byte)0);
        int k = j;
        j = i;
        for (i = ((flag) ? 1 : 0); i < l; i++)
        {
            Object obj = a(j, k, 4, vector);
            a1.a.a(((b) (obj)).c);
            j = ((b) (obj)).a;
            k = ((b) (obj)).b;
            if (a.a())
            {
                obj = ((b) (obj)).c;
                a.a((new StringBuilder("Extracted word: startTime [")).append(((fh) (obj)).c()).append("] endTime [").append(((fh) (obj)).d()).append("] content [").append(((fh) (obj)).b()).append("]").toString());
            }
        }

        a1.b = j;
        a1.c = k;
        return a1;
    }

    private int c(int i)
    {
        return fr.a(b, i);
    }

    private Vector c(int i, int j)
    {
        Vector vector = new Vector();
        boolean flag = false;
        int k = j;
        j = ((flag) ? 1 : 0);
        while (j < i) 
        {
            int l = fr.d(b, k);
            byte abyte0[] = b;
            String s;
            if (c.equals("Cp1252"))
            {
                s = "Windows-1252";
            } else
            {
                s = c;
            }
            s = fr.a(abyte0, k, l, s);
            vector.addElement(s);
            if (a.a())
            {
                a.a((new StringBuilder("Added a word to the list: [")).append(s).append("] offset [").append(k).append("] len [").append(l).append("]").toString());
            }
            k += l + 1;
            j++;
        }
        return vector;
    }

    private long d(int i)
    {
        return fr.c(b, i);
    }

    private int e(int i)
    {
        i = fr.a(b, i);
        if (a.a())
        {
            a.a((new StringBuilder("Number of key-value pairs: ")).append(i).toString());
        }
        return i;
    }

    private Hashtable f(int i)
    {
        int j = e(i);
        Hashtable hashtable = new Hashtable();
        Vector vector = c(j, i + 2);
        if (a.a())
        {
            a.a((new StringBuilder("Extracted ")).append(vector.size()).append(" words from the set of key-value pairs.").toString());
        }
        for (i = 0; i < vector.size(); i++)
        {
            String s = (String)vector.elementAt(i);
            int k = s.indexOf('=');
            if (k == -1)
            {
                throw new IllegalArgumentException((new StringBuilder("Received an invalid key-value pair: ")).append((String)vector.elementAt(i)).toString());
            }
            hashtable.put(s.substring(0, k), s.substring(k + 1, s.length()));
        }

        return hashtable;
    }

    public final fa a()
    {
        boolean flag = false;
        a.b("Unpacking DNS binary version 3.2 results.");
        Vector vector = c(b(), 2);
        if (a.b())
        {
            a.b((new StringBuilder("Found ")).append(vector.size()).append(" in word list").toString());
            if (a.a())
            {
                for (int i = 0; i < vector.size(); i++)
                {
                    a.a(vector.elementAt(i).toString());
                }

            }
        }
        vector = a(d, vector);
        if (a.b())
        {
            a.b((new StringBuilder("Found ")).append(vector.size()).append(" in n-best list").toString());
            if (a.a())
            {
                for (int j = ((flag) ? 1 : 0); j < vector.size(); j++)
                {
                    a.a(vector.elementAt(j).toString());
                }

            }
        }
        Hashtable hashtable = f(d.d);
        a(hashtable, vector);
        a(hashtable);
        return new ff(vector);
    }

}
