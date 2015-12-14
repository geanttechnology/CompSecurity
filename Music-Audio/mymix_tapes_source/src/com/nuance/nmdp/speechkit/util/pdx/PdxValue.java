// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class PdxValue
{
    public static final class Bytes extends PdxValue
    {

        private final byte a[];

        public final byte[] get()
        {
            return a;
        }

        public final java.lang.String toString(java.lang.String s)
        {
            s = new char[16];
            java.lang.String _tmp = s;
            s[0] = '0';
            s[1] = '1';
            s[2] = '2';
            s[3] = '3';
            s[4] = '4';
            s[5] = '5';
            s[6] = '6';
            s[7] = '7';
            s[8] = '8';
            s[9] = '9';
            s[10] = 'a';
            s[11] = 'b';
            s[12] = 'c';
            s[13] = 'd';
            s[14] = 'e';
            s[15] = 'f';
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("0x");
            byte abyte0[] = a;
            int j = abyte0.length;
            for (int i = 0; i < j; i++)
            {
                byte byte1 = abyte0[i];
                byte byte0 = (byte)(byte1 >> 4 & 0xf);
                byte1 &= 0xf;
                stringbuilder.append(s[byte0]);
                stringbuilder.append(s[byte1]);
            }

            return stringbuilder.toString();
        }

        public Bytes(byte abyte0[])
        {
            super(4);
            a = abyte0;
        }
    }

    public static class Dictionary extends DictionaryBase
    {

        public Dictionary()
        {
            this(null);
        }

        public Dictionary(Map map)
        {
            super(map, 2);
        }
    }

    public static abstract class DictionaryBase extends PdxValue
    {

        private final Map a = new HashMap();

        private boolean a(java.lang.String s, Object obj)
        {
            if (s == null || obj == null)
            {
                b.b(this, (new StringBuilder()).append("ignore this put action since either the key or the value is null: key[").append(s).append("] value[").append(obj).append("]").toString());
                return false;
            } else
            {
                return true;
            }
        }

        public PdxValue get(java.lang.String s)
        {
            return (PdxValue)a.get(s);
        }

        public Set getEntries()
        {
            return a.entrySet();
        }

        public void put(java.lang.String s, int i)
        {
            if (a(s, new Integer(i)))
            {
                a.put(s, new Integer(i));
            }
        }

        public void put(java.lang.String s, PdxValue pdxvalue)
        {
            if (a(s, pdxvalue))
            {
                a.put(s, pdxvalue);
            }
        }

        public void put(java.lang.String s, java.lang.String s1)
        {
            if (a(s, s1))
            {
                a.put(s, new String(s1));
            }
        }

        public void put(java.lang.String s, byte abyte0[])
        {
            if (a(s, abyte0))
            {
                a.put(s, new Bytes(abyte0));
            }
        }

        public java.lang.String toString(java.lang.String s)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("{\n");
            java.lang.String s1 = (new StringBuilder()).append(s).append("  ").toString();
            for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); stringbuilder.append(",\n"))
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                stringbuilder.append(s1);
                stringbuilder.append((java.lang.String)entry.getKey());
                stringbuilder.append(" : ");
                stringbuilder.append(((PdxValue)entry.getValue()).toString((new StringBuilder()).append(s1).append("  ").toString()));
            }

            stringbuilder.append(s);
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        DictionaryBase(Map map, int i)
        {
            super(i);
            if (map != null)
            {
                a.putAll(map);
            }
        }
    }

    public static final class Integer extends PdxValue
    {

        private final int a;

        public final int get()
        {
            return a;
        }

        public final java.lang.String toString(java.lang.String s)
        {
            return java.lang.Integer.toString(a);
        }

        public Integer(int i)
        {
            super(1);
            a = i;
        }
    }

    public static class SeqenceChunk extends DictionaryBase
    {

        public SeqenceChunk()
        {
            this(null);
        }

        public SeqenceChunk(Map map)
        {
            super(map, 6);
        }
    }

    public static class SeqenceEnd extends DictionaryBase
    {

        public SeqenceEnd()
        {
            this(null);
        }

        public SeqenceEnd(Map map)
        {
            super(map, 7);
        }
    }

    public static class SeqenceStart extends DictionaryBase
    {

        public SeqenceStart()
        {
            this(null);
        }

        public SeqenceStart(Map map)
        {
            super(map, 5);
        }
    }

    public static final class Sequence extends PdxValue
    {

        private final List a;

        private boolean a(Object obj)
        {
            if (obj == null)
            {
                b.b(this, (new StringBuilder()).append("ignore this add action since the value is null: value[").append(obj).append("]").toString());
                return false;
            } else
            {
                return true;
            }
        }

        public final void add(int i)
        {
            a.add(new Integer(i));
        }

        public final void add(PdxValue pdxvalue)
        {
            if (a(pdxvalue))
            {
                a.add(pdxvalue);
            }
        }

        public final void add(java.lang.String s)
        {
            if (a(s))
            {
                a.add(new String(s));
            }
        }

        public final void add(byte abyte0[])
        {
            if (a(abyte0))
            {
                a.add(new Bytes(abyte0));
            }
        }

        public final PdxValue get(int i)
        {
            return (PdxValue)a.get(i);
        }

        public final List getValues()
        {
            return a;
        }

        public final int size()
        {
            return a.size();
        }

        public final java.lang.String toString(java.lang.String s)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[\n");
            java.lang.String s1 = (new StringBuilder()).append(s).append("  ").toString();
            for (Iterator iterator = a.iterator(); iterator.hasNext(); stringbuilder.append(",\n"))
            {
                PdxValue pdxvalue = (PdxValue)iterator.next();
                stringbuilder.append(s1);
                stringbuilder.append(pdxvalue.toString(s1));
            }

            stringbuilder.append(s);
            stringbuilder.append("]");
            return stringbuilder.toString();
        }

        public Sequence()
        {
            this(null);
        }

        public Sequence(List list)
        {
            super(3);
            a = new ArrayList();
            if (list != null)
            {
                a.addAll(list);
            }
        }
    }

    public static final class String extends PdxValue
    {

        private final java.lang.String a;

        public final java.lang.String get()
        {
            return a;
        }

        public final java.lang.String toString(java.lang.String s)
        {
            return a.replace("\n", (new StringBuilder()).append("\n").append(s).toString());
        }

        public String(java.lang.String s)
        {
            super(0);
            a = s;
        }
    }


    public static final int TYPE_BYTES = 4;
    public static final int TYPE_DICT = 2;
    public static final int TYPE_INT = 1;
    public static final int TYPE_SEQ = 3;
    public static final int TYPE_SEQ_CHUNK = 6;
    public static final int TYPE_SEQ_END = 7;
    public static final int TYPE_SEQ_START = 5;
    public static final int TYPE_STRING = 0;
    private final int a;

    PdxValue(int i)
    {
        a = i;
    }

    public final int getType()
    {
        return a;
    }

    public abstract java.lang.String toString(java.lang.String s);
}
