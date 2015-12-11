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
//            ValidatingGrammarGenerator, Symbol

public class JsonGrammarGenerator extends ValidatingGrammarGenerator
{

    public JsonGrammarGenerator()
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
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.UNION.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ENUM.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.ARRAY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.MAP.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$apache$avro$Schema$Type[com.flurry.org.apache.avro.Schema.Type.RECORD.ordinal()] = 14;
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
    //                   2 90
    //                   3 90
    //                   4 90
    //                   5 90
    //                   6 90
    //                   7 90
    //                   8 90
    //                   9 90
    //                   10 90
    //                   11 99
    //                   12 127
    //                   13 172
    //                   14 229;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L6
_L1:
        throw new RuntimeException("Unexpected schema type");
_L2:
        Symbol symbol = super.generate(schema, map);
_L8:
        return symbol;
_L3:
        return Symbol.seq(new Symbol[] {
            new Symbol.EnumLabelsAction(schema.getEnumSymbols()), Symbol.ENUM
        });
_L4:
        return Symbol.seq(new Symbol[] {
            Symbol.repeat(Symbol.ARRAY_END, new Symbol[] {
                Symbol.ITEM_END, generate(schema.getElementType(), map)
            }), Symbol.ARRAY_START
        });
_L5:
        return Symbol.seq(new Symbol[] {
            Symbol.repeat(Symbol.MAP_END, new Symbol[] {
                Symbol.ITEM_END, generate(schema.getValueType(), map), Symbol.MAP_KEY_MARKER, Symbol.STRING
            }), Symbol.MAP_START
        });
_L6:
        ValidatingGrammarGenerator.LitS lits = new ValidatingGrammarGenerator.LitS(schema);
        Symbol symbol1 = (Symbol)map.get(lits);
        symbol = symbol1;
        if (symbol1 == null)
        {
            Symbol asymbol[] = new Symbol[schema.getFields().size() * 3 + 2];
            Symbol symbol2 = Symbol.seq(asymbol);
            map.put(lits, symbol2);
            int j = asymbol.length;
            int i = 0;
            j--;
            asymbol[j] = Symbol.RECORD_START;
            for (schema = schema.getFields().iterator(); schema.hasNext();)
            {
                com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)schema.next();
                j--;
                asymbol[j] = new Symbol.FieldAdjustAction(i, field.name());
                j--;
                asymbol[j] = generate(field.schema(), map);
                j--;
                asymbol[j] = Symbol.FIELD_END;
                i++;
            }

            asymbol[j - 1] = Symbol.RECORD_END;
            return symbol2;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }
}
