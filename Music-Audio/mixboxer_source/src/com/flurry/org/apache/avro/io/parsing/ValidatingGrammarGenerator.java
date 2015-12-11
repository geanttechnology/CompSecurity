// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.Schema;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public class ValidatingGrammarGenerator
{
    static class LitS
    {

        public final Schema actual;

        public boolean equals(Object obj)
        {
            while (!(obj instanceof LitS) || actual != ((LitS)obj).actual) 
            {
                return false;
            }
            return true;
        }

        public int hashCode()
        {
            return actual.hashCode();
        }

        public LitS(Schema schema)
        {
            actual = schema;
        }
    }


    public ValidatingGrammarGenerator()
    {
    }

    public Symbol generate(Schema schema)
    {
        return Symbol.root(new Symbol[] {
            generate(schema, ((Map) (new HashMap())))
        });
    }

    public Symbol generate(Schema schema, Map map)
    {
        static class _cls1
        {

            static final int $SwitchMap$org$apache$avro$Schema$Type[];

            static 
            {
                $SwitchMap$org$apache$avro$Schema$Type = new int[com.flurry.org.apache.avro.Schema.Type.values().length];
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.NULL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BOOLEAN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.LONG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FLOAT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.DOUBLE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.STRING.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.BYTES.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.FIXED.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ENUM.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.MAP.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.RECORD.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.UNION.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 80
    //                   1 90
    //                   2 96
    //                   3 100
    //                   4 104
    //                   5 108
    //                   6 112
    //                   7 116
    //                   8 120
    //                   9 124
    //                   10 152
    //                   11 185
    //                   12 224
    //                   13 269
    //                   14 392;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        throw new RuntimeException("Unexpected schema type");
_L2:
        Symbol symbol = Symbol.NULL;
_L17:
        return symbol;
_L3:
        return Symbol.BOOLEAN;
_L4:
        return Symbol.INT;
_L5:
        return Symbol.LONG;
_L6:
        return Symbol.FLOAT;
_L7:
        return Symbol.DOUBLE;
_L8:
        return Symbol.STRING;
_L9:
        return Symbol.BYTES;
_L10:
        return Symbol.seq(new Symbol[] {
            new Symbol.IntCheckAction(schema.getFixedSize()), Symbol.FIXED
        });
_L11:
        return Symbol.seq(new Symbol[] {
            new Symbol.IntCheckAction(schema.getEnumSymbols().size()), Symbol.ENUM
        });
_L12:
        return Symbol.seq(new Symbol[] {
            Symbol.repeat(Symbol.ARRAY_END, new Symbol[] {
                generate(schema.getElementType(), map)
            }), Symbol.ARRAY_START
        });
_L13:
        return Symbol.seq(new Symbol[] {
            Symbol.repeat(Symbol.MAP_END, new Symbol[] {
                generate(schema.getValueType(), map), Symbol.STRING
            }), Symbol.MAP_START
        });
_L14:
        Symbol symbol1;
        LitS lits;
        lits = new LitS(schema);
        symbol1 = (Symbol)map.get(lits);
        symbol = symbol1;
        if (symbol1 != null) goto _L17; else goto _L16
_L16:
        Symbol asymbol1[];
        int i;
        asymbol1 = new Symbol[schema.getFields().size()];
        symbol1 = Symbol.seq(asymbol1);
        map.put(lits, symbol1);
        i = asymbol1.length;
        schema = schema.getFields().iterator();
_L19:
        symbol = symbol1;
        if (!schema.hasNext()) goto _L17; else goto _L18
_L18:
        com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
        i--;
        asymbol1[i] = generate(field.schema(), map);
          goto _L19
          goto _L17
_L15:
        List list = schema.getTypes();
        Symbol asymbol[] = new Symbol[list.size()];
        String as[] = new String[list.size()];
        int j = 0;
        for (schema = schema.getTypes().iterator(); schema.hasNext();)
        {
            Schema schema1 = (Schema)schema.next();
            asymbol[j] = generate(schema1, map);
            as[j] = schema1.getFullName();
            j++;
        }

        return Symbol.seq(new Symbol[] {
            Symbol.alt(asymbol, as), Symbol.UNION
        });
    }
}
