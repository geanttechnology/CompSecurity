// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class Symbol
{
    public static class Alternative extends Symbol
    {

        public final String labels[];
        public final Symbol symbols[];

        public int findLabel(String s)
        {
            if (s != null)
            {
                for (int i = 0; i < labels.length; i++)
                {
                    if (s.equals(labels[i]))
                    {
                        return i;
                    }
                }

            }
            return -1;
        }

        public Alternative flatten(Map map, Map map1)
        {
            Symbol asymbol[] = new Symbol[symbols.length];
            for (int i = 0; i < asymbol.length; i++)
            {
                asymbol[i] = symbols[i].flatten(map, map1);
            }

            return new Alternative(asymbol, labels);
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        public String getLabel(int i)
        {
            return labels[i];
        }

        public Symbol getSymbol(int i)
        {
            return symbols[i];
        }

        public int size()
        {
            return symbols.length;
        }

        private Alternative(Symbol asymbol[], String as[])
        {
            super(Kind.ALTERNATIVE);
            symbols = asymbol;
            labels = as;
        }

    }

    public static class DefaultStartAction extends ImplicitAction
    {

        public final byte contents[];

        public DefaultStartAction(byte abyte0[])
        {
            contents = abyte0;
        }
    }

    public static class EnumAdjustAction extends IntCheckAction
    {

        public final Object adjustments[];

        public EnumAdjustAction(int i, Object aobj[])
        {
            super(i);
            adjustments = aobj;
        }
    }

    public static class EnumLabelsAction extends IntCheckAction
    {

        public final List symbols;

        public int findLabel(String s)
        {
            if (s != null)
            {
                for (int i = 0; i < symbols.size(); i++)
                {
                    if (s.equals(symbols.get(i)))
                    {
                        return i;
                    }
                }

            }
            return -1;
        }

        public String getLabel(int i)
        {
            return (String)symbols.get(i);
        }

        public EnumLabelsAction(List list)
        {
            super(list.size());
            symbols = list;
        }
    }

    public static class ErrorAction extends ImplicitAction
    {

        public final String msg;

        private ErrorAction(String s)
        {
            msg = s;
        }

    }

    public static class FieldAdjustAction extends ImplicitAction
    {

        public final String fname;
        public final int rindex;

        public FieldAdjustAction(int i, String s)
        {
            rindex = i;
            fname = s;
        }
    }

    public static final class FieldOrderAction extends ImplicitAction
    {

        public final com.flurry.org.apache.avro.Schema.Field fields[];

        public FieldOrderAction(com.flurry.org.apache.avro.Schema.Field afield[])
        {
            fields = afield;
        }
    }

    private static class Fixup
    {

        public final int pos;
        public final Symbol symbols[];

        public Fixup(Symbol asymbol[], int i)
        {
            symbols = asymbol;
            pos = i;
        }
    }

    public static class ImplicitAction extends Symbol
    {

        public final boolean isTrailing;

        private ImplicitAction()
        {
            this(false);
        }


        private ImplicitAction(boolean flag)
        {
            super(Kind.IMPLICIT_ACTION);
            isTrailing = flag;
        }

    }

    public static class IntCheckAction extends Symbol
    {

        public final int size;

        public IntCheckAction(int i)
        {
            super(Kind.EXPLICIT_ACTION);
            size = i;
        }
    }

    public static final class Kind extends Enum
    {

        private static final Kind $VALUES[];
        public static final Kind ALTERNATIVE;
        public static final Kind EXPLICIT_ACTION;
        public static final Kind IMPLICIT_ACTION;
        public static final Kind REPEATER;
        public static final Kind ROOT;
        public static final Kind SEQUENCE;
        public static final Kind TERMINAL;

        public static Kind valueOf(String s)
        {
            return (Kind)Enum.valueOf(com/flurry/org/apache/avro/io/parsing/Symbol$Kind, s);
        }

        public static Kind[] values()
        {
            return (Kind[])$VALUES.clone();
        }

        static 
        {
            TERMINAL = new Kind("TERMINAL", 0);
            ROOT = new Kind("ROOT", 1);
            SEQUENCE = new Kind("SEQUENCE", 2);
            REPEATER = new Kind("REPEATER", 3);
            ALTERNATIVE = new Kind("ALTERNATIVE", 4);
            IMPLICIT_ACTION = new Kind("IMPLICIT_ACTION", 5);
            EXPLICIT_ACTION = new Kind("EXPLICIT_ACTION", 6);
            $VALUES = (new Kind[] {
                TERMINAL, ROOT, SEQUENCE, REPEATER, ALTERNATIVE, IMPLICIT_ACTION, EXPLICIT_ACTION
            });
        }

        private Kind(String s, int i)
        {
            super(s, i);
        }
    }

    public static class Repeater extends Symbol
    {

        public final Symbol end;

        private static Symbol[] makeProduction(Symbol asymbol[])
        {
            Symbol asymbol1[] = new Symbol[asymbol.length + 1];
            System.arraycopy(asymbol, 0, asymbol1, 1, asymbol.length);
            return asymbol1;
        }

        public Repeater flatten(Map map, Map map1)
        {
            Repeater repeater = new Repeater(end, new Symbol[flattenedSize(production, 1)]);
            flatten(production, 1, repeater.production, 1, map, map1);
            return repeater;
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        private transient Repeater(Symbol symbol, Symbol asymbol[])
        {
            super(Kind.REPEATER, makeProduction(asymbol));
            end = symbol;
            production[0] = this;
        }

    }

    public static class ResolvingAction extends ImplicitAction
    {

        public final Symbol reader;
        public final Symbol writer;

        public ResolvingAction flatten(Map map, Map map1)
        {
            return new ResolvingAction(writer.flatten(map, map1), reader.flatten(map, map1));
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        private ResolvingAction(Symbol symbol, Symbol symbol1)
        {
            writer = symbol;
            reader = symbol1;
        }

    }

    protected static class Root extends Symbol
    {

        private static Symbol[] makeProduction(Symbol asymbol[])
        {
            Symbol asymbol1[] = new Symbol[flattenedSize(asymbol, 0) + 1];
            flatten(asymbol, 0, asymbol1, 1, new HashMap(), new HashMap());
            return asymbol1;
        }

        private transient Root(Symbol asymbol[])
        {
            super(Kind.ROOT, makeProduction(asymbol));
            production[0] = this;
        }

    }

    protected static class Sequence extends Symbol
        implements Iterable
    {

        public Sequence flatten(Map map, Map map1)
        {
            Sequence sequence1 = (Sequence)map.get(this);
            Sequence sequence = sequence1;
            if (sequence1 == null)
            {
                sequence = new Sequence(new Symbol[flattenedSize()]);
                map.put(this, sequence);
                Object obj = new ArrayList();
                map1.put(sequence, obj);
                flatten(production, 0, sequence.production, 0, map, map1);
                for (map = ((List) (obj)).iterator(); map.hasNext(); System.arraycopy(sequence.production, 0, ((Fixup) (obj)).symbols, ((Fixup) (obj)).pos, sequence.production.length))
                {
                    obj = (Fixup)map.next();
                }

                map1.remove(sequence);
            }
            return sequence;
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        public final int flattenedSize()
        {
            return flattenedSize(production, 0);
        }

        public Symbol get(int i)
        {
            return production[i];
        }

        public Iterator iterator()
        {
            return new Iterator() {

                private int pos;
                final Sequence this$0;

                public boolean hasNext()
                {
                    return pos > 0;
                }

                public Symbol next()
                {
                    if (pos > 0)
                    {
                        Symbol asymbol[] = production;
                        int i = pos - 1;
                        pos = i;
                        return asymbol[i];
                    } else
                    {
                        throw new NoSuchElementException();
                    }
                }

                public volatile Object next()
                {
                    return next();
                }

                public void remove()
                {
                    throw new UnsupportedOperationException();
                }

            
            {
                this$0 = Sequence.this;
                super();
                pos = production.length;
            }
            };
        }

        public int size()
        {
            return production.length;
        }

        private Sequence(Symbol asymbol[])
        {
            super(Kind.SEQUENCE, asymbol);
        }

    }

    public static class SkipAction extends ImplicitAction
    {

        public final Symbol symToSkip;

        public SkipAction flatten(Map map, Map map1)
        {
            return new SkipAction(symToSkip.flatten(map, map1));
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        public SkipAction(Symbol symbol)
        {
            super(true);
            symToSkip = symbol;
        }
    }

    private static class Terminal extends Symbol
    {

        private final String printName;

        public String toString()
        {
            return printName;
        }

        public Terminal(String s)
        {
            super(Kind.TERMINAL);
            printName = s;
        }
    }

    public static class UnionAdjustAction extends ImplicitAction
    {

        public final int rindex;
        public final Symbol symToParse;

        public UnionAdjustAction flatten(Map map, Map map1)
        {
            return new UnionAdjustAction(rindex, symToParse.flatten(map, map1));
        }

        public volatile Symbol flatten(Map map, Map map1)
        {
            return flatten(map, map1);
        }

        public UnionAdjustAction(int i, Symbol symbol)
        {
            rindex = i;
            symToParse = symbol;
        }
    }

    public static class WriterUnionAction extends ImplicitAction
    {

        public WriterUnionAction()
        {
        }
    }


    public static final Symbol ARRAY_END = new Terminal("array-end");
    public static final Symbol ARRAY_START = new Terminal("array-start");
    public static final Symbol BOOLEAN = new Terminal("boolean");
    public static final Symbol BYTES = new Terminal("bytes");
    public static final Symbol DEFAULT_END_ACTION = new ImplicitAction(true);
    public static final Symbol DOUBLE = new Terminal("double");
    public static final Symbol ENUM = new Terminal("enum");
    public static final Symbol FIELD_ACTION = new Terminal("field-action");
    public static final Symbol FIELD_END = new ImplicitAction(true);
    public static final Symbol FIXED = new Terminal("fixed");
    public static final Symbol FLOAT = new Terminal("float");
    public static final Symbol INT = new Terminal("int");
    public static final Symbol ITEM_END = new Terminal("item-end");
    public static final Symbol LONG = new Terminal("long");
    public static final Symbol MAP_END = new Terminal("map-end");
    public static final Symbol MAP_KEY_MARKER = new Terminal("map-key-marker");
    public static final Symbol MAP_START = new Terminal("map-start");
    public static final Symbol NULL = new Terminal("null");
    public static final Symbol RECORD_END = new ImplicitAction(true);
    public static final Symbol RECORD_START = new ImplicitAction(false);
    public static final Symbol STRING = new Terminal("string");
    public static final Symbol UNION = new Terminal("union");
    public static final Symbol UNION_END = new ImplicitAction(true);
    public final Kind kind;
    public final Symbol production[];

    protected Symbol(Kind kind1)
    {
        this(kind1, null);
    }

    protected Symbol(Kind kind1, Symbol asymbol[])
    {
        production = asymbol;
        kind = kind1;
    }

    static Symbol alt(Symbol asymbol[], String as[])
    {
        return new Alternative(asymbol, as);
    }

    static Symbol error(String s)
    {
        return new ErrorAction(s);
    }

    static void flatten(Symbol asymbol[], int i, Symbol asymbol1[], int j, Map map, Map map1)
    {
        int k = j;
        j = i;
        while (j < asymbol.length) 
        {
            Object obj = asymbol[j].flatten(map, map1);
            if (obj instanceof Sequence)
            {
                Symbol asymbol2[] = ((Symbol) (obj)).production;
                obj = (List)map1.get(obj);
                if (obj == null)
                {
                    System.arraycopy(asymbol2, 0, asymbol1, k, asymbol2.length);
                } else
                {
                    ((List) (obj)).add(new Fixup(asymbol1, k));
                }
                i = k + asymbol2.length;
            } else
            {
                asymbol1[k] = ((Symbol) (obj));
                i = k + 1;
            }
            j++;
            k = i;
        }
    }

    protected static int flattenedSize(Symbol asymbol[], int i)
    {
        int k = 0;
        int j = i;
        while (j < asymbol.length) 
        {
            if (asymbol[j] instanceof Sequence)
            {
                i = k + ((Sequence)asymbol[j]).flattenedSize();
            } else
            {
                i = k + 1;
            }
            j++;
            k = i;
        }
        return k;
    }

    static transient Symbol repeat(Symbol symbol, Symbol asymbol[])
    {
        return new Repeater(symbol, asymbol);
    }

    static Symbol resolve(Symbol symbol, Symbol symbol1)
    {
        return new ResolvingAction(symbol, symbol1);
    }

    static transient Symbol root(Symbol asymbol[])
    {
        return new Root(asymbol);
    }

    static transient Symbol seq(Symbol asymbol[])
    {
        return new Sequence(asymbol);
    }

    public Symbol flatten(Map map, Map map1)
    {
        return this;
    }

    public int flattenedSize()
    {
        return 1;
    }

}
