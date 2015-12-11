// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.Encoder;
import com.flurry.org.apache.avro.io.EncoderFactory;
import com.flurry.org.codehaus.jackson.JsonNode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            ValidatingGrammarGenerator, Symbol

public class ResolvingGrammarGenerator extends ValidatingGrammarGenerator
{
    static class LitS2 extends ValidatingGrammarGenerator.LitS
    {

        public Schema expected;

        public boolean equals(Object obj)
        {
            if (obj instanceof LitS2)
            {
                if (actual == ((LitS2) (obj = (LitS2)obj)).actual && expected == ((LitS2) (obj)).expected)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return super.hashCode() + expected.hashCode();
        }

        public LitS2(Schema schema, Schema schema1)
        {
            super(schema);
            expected = schema1;
        }
    }


    private static EncoderFactory factory = (new EncoderFactory()).configureBufferSize(32);

    public ResolvingGrammarGenerator()
    {
    }

    private static int bestBranch(Schema schema, Schema schema1)
    {
        com.flurry.org.apache.avro.Schema.Type type;
        int i;
        type = schema1.getType();
        i = 0;
        for (Iterator iterator = schema.getTypes().iterator(); iterator.hasNext(); i++)
        {
            Object obj = (Schema)iterator.next();
            if (type != ((Schema) (obj)).getType())
            {
                continue;
            }
            if (type == com.flurry.org.apache.avro.Schema.Type.RECORD || type == com.flurry.org.apache.avro.Schema.Type.ENUM || type == com.flurry.org.apache.avro.Schema.Type.FIXED)
            {
                String s = schema1.getFullName();
                obj = ((Schema) (obj)).getFullName();
                if (s != null && s.equals(obj) || s == obj && type == com.flurry.org.apache.avro.Schema.Type.RECORD)
                {
                    return i;
                }
            } else
            {
                return i;
            }
        }

        i = 0;
        schema = schema.getTypes().iterator();
_L2:
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

        if (!schema.hasNext())
        {
            break MISSING_BLOCK_LABEL_282;
        }
        schema1 = (Schema)schema.next();
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[type.ordinal()])
        {
        default:
            break;

        case 3: // '\003'
            break; /* Loop/switch isn't completed */

        case 4: // '\004'
        case 5: // '\005'
            break;
        }
        break MISSING_BLOCK_LABEL_246;
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[schema1.getType().ordinal()])
        {
        case 4: // '\004'
        case 6: // '\006'
            return i;
        }
          goto _L3
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[schema1.getType().ordinal()])
        {
        case 6: // '\006'
            return i;
        }
          goto _L3
        return -1;
    }

    public static void encode(Encoder encoder, Schema schema, JsonNode jsonnode)
        throws IOException
    {
        _cls1..SwitchMap.org.apache.avro.Schema.Type[schema.getType().ordinal()];
        JVM INSTR tableswitch 1 14: default 80
    //                   1 761
    //                   2 717
    //                   3 544
    //                   4 587
    //                   5 630
    //                   6 674
    //                   7 453
    //                   8 496
    //                   9 354
    //                   10 185
    //                   11 198
    //                   12 258
    //                   13 81
    //                   14 330;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15
_L1:
        return;
_L14:
        Iterator iterator1 = schema.getFields().iterator();
        while (iterator1.hasNext()) 
        {
            com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)iterator1.next();
            String s1 = field.name();
            JsonNode jsonnode1 = jsonnode.get(s1);
            schema = jsonnode1;
            if (jsonnode1 == null)
            {
                schema = field.defaultValue();
            }
            if (schema == null)
            {
                throw new AvroTypeException((new StringBuilder()).append("No default value for: ").append(s1).toString());
            }
            encode(encoder, field.schema(), ((JsonNode) (schema)));
        }
          goto _L1
_L11:
        encoder.writeEnum(schema.getEnumOrdinal(jsonnode.getTextValue()));
        return;
_L12:
        encoder.writeArrayStart();
        encoder.setItemCount(jsonnode.size());
        schema = schema.getElementType();
        JsonNode jsonnode2;
        for (jsonnode = jsonnode.iterator(); jsonnode.hasNext(); encode(encoder, schema, jsonnode2))
        {
            jsonnode2 = (JsonNode)jsonnode.next();
            encoder.startItem();
        }

        encoder.writeArrayEnd();
        return;
_L13:
        encoder.writeMapStart();
        encoder.setItemCount(jsonnode.size());
        schema = schema.getValueType();
        String s;
        for (Iterator iterator = jsonnode.getFieldNames(); iterator.hasNext(); encode(encoder, schema, jsonnode.get(s)))
        {
            encoder.startItem();
            s = (String)iterator.next();
            encoder.writeString(s);
        }

        encoder.writeMapEnd();
        return;
_L15:
        encoder.writeIndex(0);
        encode(encoder, (Schema)schema.getTypes().get(0), jsonnode);
        return;
_L10:
        if (!jsonnode.isTextual())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-string default value for fixed: ").append(jsonnode).toString());
        }
        byte abyte0[] = jsonnode.getTextValue().getBytes("ISO-8859-1");
        jsonnode = abyte0;
        if (abyte0.length != schema.getFixedSize())
        {
            jsonnode = new byte[schema.getFixedSize()];
            int i;
            if (schema.getFixedSize() > abyte0.length)
            {
                i = abyte0.length;
            } else
            {
                i = schema.getFixedSize();
            }
            System.arraycopy(abyte0, 0, jsonnode, 0, i);
        }
        encoder.writeFixed(jsonnode);
        return;
_L8:
        if (!jsonnode.isTextual())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-string default value for string: ").append(jsonnode).toString());
        } else
        {
            encoder.writeString(jsonnode.getTextValue());
            return;
        }
_L9:
        if (!jsonnode.isTextual())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-string default value for bytes: ").append(jsonnode).toString());
        } else
        {
            encoder.writeBytes(jsonnode.getTextValue().getBytes("ISO-8859-1"));
            return;
        }
_L4:
        if (!jsonnode.isNumber())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-numeric default value for int: ").append(jsonnode).toString());
        } else
        {
            encoder.writeInt(jsonnode.getIntValue());
            return;
        }
_L5:
        if (!jsonnode.isNumber())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-numeric default value for long: ").append(jsonnode).toString());
        } else
        {
            encoder.writeLong(jsonnode.getLongValue());
            return;
        }
_L6:
        if (!jsonnode.isNumber())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-numeric default value for float: ").append(jsonnode).toString());
        } else
        {
            encoder.writeFloat((float)jsonnode.getDoubleValue());
            return;
        }
_L7:
        if (!jsonnode.isNumber())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-numeric default value for double: ").append(jsonnode).toString());
        } else
        {
            encoder.writeDouble(jsonnode.getDoubleValue());
            return;
        }
_L3:
        if (!jsonnode.isBoolean())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-boolean default for boolean: ").append(jsonnode).toString());
        } else
        {
            encoder.writeBoolean(jsonnode.getBooleanValue());
            return;
        }
_L2:
        if (!jsonnode.isNull())
        {
            throw new AvroTypeException((new StringBuilder()).append("Non-null default value for null type: ").append(jsonnode).toString());
        } else
        {
            encoder.writeNull();
            return;
        }
    }

    private static byte[] getBinary(Schema schema, JsonNode jsonnode)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        com.flurry.org.apache.avro.io.BinaryEncoder binaryencoder = factory.binaryEncoder(bytearrayoutputstream, null);
        encode(binaryencoder, schema, jsonnode);
        binaryencoder.flush();
        return bytearrayoutputstream.toByteArray();
    }

    private static Symbol mkEnumAdjust(List list, List list1)
    {
        Object aobj[] = new Object[list.size()];
        int i = 0;
        while (i < aobj.length) 
        {
            int j = list1.indexOf(list.get(i));
            Object obj;
            if (j == -1)
            {
                obj = (new StringBuilder()).append("No match for ").append((String)list.get(i)).toString();
            } else
            {
                obj = new Integer(j);
            }
            aobj[i] = obj;
            i++;
        }
        return new Symbol.EnumAdjustAction(list1.size(), aobj);
    }

    private Symbol resolveRecords(Schema schema, Schema schema1, Map map)
        throws IOException
    {
        LitS2 lits2 = new LitS2(schema, schema1);
        Symbol symbol = (Symbol)map.get(lits2);
        Object obj = symbol;
        if (symbol == null)
        {
            List list = schema.getFields();
            obj = schema1.getFields();
            com.flurry.org.apache.avro.Schema.Field afield[] = new com.flurry.org.apache.avro.Schema.Field[((List) (obj)).size()];
            int i = 0;
            int j = list.size() + 1;
            Iterator iterator1 = list.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.flurry.org.apache.avro.Schema.Field field1 = schema1.getField(((com.flurry.org.apache.avro.Schema.Field)iterator1.next()).name());
                if (field1 != null)
                {
                    afield[i] = field1;
                    i++;
                }
            } while (true);
            iterator1 = ((List) (obj)).iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                com.flurry.org.apache.avro.Schema.Field field2 = (com.flurry.org.apache.avro.Schema.Field)iterator1.next();
                if (schema.getField(field2.name()) == null)
                {
                    if (field2.defaultValue() == null)
                    {
                        schema = Symbol.error((new StringBuilder()).append("Found ").append(schema.toString(true)).append(", expecting ").append(schema1.toString(true)).toString());
                        map.put(lits2, schema);
                        return schema;
                    }
                    afield[i] = field2;
                    j += 3;
                    i++;
                }
            } while (true);
            Symbol asymbol[] = new Symbol[j];
            i = j - 1;
            asymbol[i] = new Symbol.FieldOrderAction(afield);
            Symbol symbol1 = Symbol.seq(asymbol);
            map.put(lits2, symbol1);
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                com.flurry.org.apache.avro.Schema.Field field = (com.flurry.org.apache.avro.Schema.Field)iterator.next();
                com.flurry.org.apache.avro.Schema.Field field3 = schema1.getField(field.name());
                if (field3 == null)
                {
                    i--;
                    asymbol[i] = new Symbol.SkipAction(generate(field.schema(), field.schema(), map));
                } else
                {
                    i--;
                    asymbol[i] = generate(field.schema(), field3.schema(), map);
                }
            }

            schema1 = ((List) (obj)).iterator();
            do
            {
                obj = symbol1;
                if (!schema1.hasNext())
                {
                    break;
                }
                obj = (com.flurry.org.apache.avro.Schema.Field)schema1.next();
                if (schema.getField(((com.flurry.org.apache.avro.Schema.Field) (obj)).name()) == null)
                {
                    byte abyte0[] = getBinary(((com.flurry.org.apache.avro.Schema.Field) (obj)).schema(), ((com.flurry.org.apache.avro.Schema.Field) (obj)).defaultValue());
                    i--;
                    asymbol[i] = new Symbol.DefaultStartAction(abyte0);
                    i--;
                    asymbol[i] = generate(((com.flurry.org.apache.avro.Schema.Field) (obj)).schema(), ((com.flurry.org.apache.avro.Schema.Field) (obj)).schema(), map);
                    i--;
                    asymbol[i] = Symbol.DEFAULT_END_ACTION;
                }
            } while (true);
        }
        return ((Symbol) (obj));
    }

    private Symbol resolveUnion(Schema schema, Schema schema1, Map map)
        throws IOException
    {
        Object obj = schema.getTypes();
        int i = ((List) (obj)).size();
        schema = new Symbol[i];
        String as[] = new String[i];
        i = 0;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Schema schema2 = (Schema)((Iterator) (obj)).next();
            schema[i] = generate(schema2, schema1, map);
            as[i] = schema2.getFullName();
            i++;
        }

        return Symbol.seq(new Symbol[] {
            Symbol.alt(schema, as), new Symbol.WriterUnionAction()
        });
    }

    public final Symbol generate(Schema schema, Schema schema1)
        throws IOException
    {
        return Symbol.root(new Symbol[] {
            generate(schema, schema1, ((Map) (new HashMap())))
        });
    }

    public Symbol generate(Schema schema, Schema schema1, Map map)
        throws IOException
    {
        com.flurry.org.apache.avro.Schema.Type type;
        com.flurry.org.apache.avro.Schema.Type type1;
        type = schema.getType();
        type1 = schema1.getType();
        if (type != type1) goto _L2; else goto _L1
_L1:
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[type.ordinal()])
        {
        default:
            throw new AvroTypeException((new StringBuilder()).append("Unkown type for schema: ").append(type).toString());

        case 1: // '\001'
            return Symbol.NULL;

        case 2: // '\002'
            return Symbol.BOOLEAN;

        case 3: // '\003'
            return Symbol.INT;

        case 4: // '\004'
            return Symbol.LONG;

        case 5: // '\005'
            return Symbol.FLOAT;

        case 6: // '\006'
            return Symbol.DOUBLE;

        case 7: // '\007'
            return Symbol.STRING;

        case 8: // '\b'
            return Symbol.BYTES;

        case 9: // '\t'
            if (schema.getFullName().equals(schema1.getFullName()) && schema.getFixedSize() == schema1.getFixedSize())
            {
                return Symbol.seq(new Symbol[] {
                    new Symbol.IntCheckAction(schema.getFixedSize()), Symbol.FIXED
                });
            }
            break;

        case 10: // '\n'
            if (schema.getFullName() == null || schema.getFullName().equals(schema1.getFullName()))
            {
                return Symbol.seq(new Symbol[] {
                    mkEnumAdjust(schema.getEnumSymbols(), schema1.getEnumSymbols()), Symbol.ENUM
                });
            }
            break;

        case 11: // '\013'
            return Symbol.seq(new Symbol[] {
                Symbol.repeat(Symbol.ARRAY_END, new Symbol[] {
                    generate(schema.getElementType(), schema1.getElementType(), map)
                }), Symbol.ARRAY_START
            });

        case 12: // '\f'
            return Symbol.seq(new Symbol[] {
                Symbol.repeat(Symbol.MAP_END, new Symbol[] {
                    generate(schema.getValueType(), schema1.getValueType(), map), Symbol.STRING
                }), Symbol.MAP_START
            });

        case 13: // '\r'
            return resolveRecords(schema, schema1, map);

        case 14: // '\016'
            return resolveUnion(schema, schema1, map);
        }
          goto _L3
_L2:
        if (type == com.flurry.org.apache.avro.Schema.Type.UNION)
        {
            return resolveUnion(schema, schema1, map);
        }
        _cls1..SwitchMap.org.apache.avro.Schema.Type[type1.ordinal()];
        JVM INSTR tableswitch 1 14: default 468
    //                   1 524
    //                   2 524
    //                   3 524
    //                   4 497
    //                   5 579
    //                   6 628
    //                   7 524
    //                   8 524
    //                   9 468
    //                   10 524
    //                   11 524
    //                   12 524
    //                   13 524
    //                   14 680;
           goto _L4 _L5 _L5 _L5 _L6 _L7 _L8 _L5 _L5 _L4 _L5 _L5 _L5 _L5 _L9
_L5:
        break; /* Loop/switch isn't completed */
_L4:
        throw new RuntimeException((new StringBuilder()).append("Unexpected schema type: ").append(type1).toString());
_L6:
        _cls1..SwitchMap.org.apache.avro.Schema.Type[type.ordinal()];
        JVM INSTR tableswitch 3 3: default 524
    //                   3 566;
           goto _L3 _L10
_L3:
        return Symbol.error((new StringBuilder()).append("Found ").append(schema.toString(true)).append(", expecting ").append(schema1.toString(true)).toString());
_L10:
        return Symbol.resolve(super.generate(schema, map), Symbol.LONG);
_L7:
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[type.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
            return Symbol.resolve(super.generate(schema, map), Symbol.FLOAT);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        switch (_cls1..SwitchMap.org.apache.avro.Schema.Type[type.ordinal()])
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return Symbol.resolve(super.generate(schema, map), Symbol.DOUBLE);
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L9:
        int i = bestBranch(schema1, schema);
        if (i >= 0)
        {
            return Symbol.seq(new Symbol[] {
                new Symbol.UnionAdjustAction(i, generate(schema, (Schema)schema1.getTypes().get(i), map)), Symbol.UNION
            });
        }
        if (true) goto _L3; else goto _L11
_L11:
    }

}
