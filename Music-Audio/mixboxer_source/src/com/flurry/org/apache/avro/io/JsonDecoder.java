// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.JsonGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonLocation;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonStreamContext;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.ObjectCodec;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            ParsingDecoder

public class JsonDecoder extends ParsingDecoder
    implements com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler
{
    private static class JsonElement
    {

        public final JsonToken token;
        public final String value;

        public JsonElement(JsonToken jsontoken)
        {
            this(jsontoken, null);
        }

        public JsonElement(JsonToken jsontoken, String s)
        {
            token = jsontoken;
            value = s;
        }
    }

    private static class ReorderBuffer
    {

        public JsonParser origParser;
        public Map savedFields;

        private ReorderBuffer()
        {
            savedFields = new HashMap();
            origParser = null;
        }

    }


    static final String CHARSET = "ISO-8859-1";
    private static JsonFactory jsonFactory = new JsonFactory();
    ReorderBuffer currentReorderBuffer;
    private JsonParser in;
    Stack reorderBuffers;

    JsonDecoder(Schema schema, InputStream inputstream)
        throws IOException
    {
        this(getSymbol(schema), inputstream);
    }

    JsonDecoder(Schema schema, String s)
        throws IOException
    {
        this(getSymbol(schema), s);
    }

    private JsonDecoder(Symbol symbol, InputStream inputstream)
        throws IOException
    {
        super(symbol);
        reorderBuffers = new Stack();
        configure(inputstream);
    }

    private JsonDecoder(Symbol symbol, String s)
        throws IOException
    {
        super(symbol);
        reorderBuffers = new Stack();
        configure(s);
    }

    private void advance(Symbol symbol)
        throws IOException
    {
        parser.processTrailingImplicitActions();
        if (in.getCurrentToken() == null && parser.depth() == 1)
        {
            throw new EOFException();
        } else
        {
            parser.advance(symbol);
            return;
        }
    }

    private void checkFixed(int i)
        throws IOException
    {
        advance(Symbol.FIXED);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        if (i != intcheckaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Incorrect length for fixed binary: expected ").append(intcheckaction.size).append(" but received ").append(i).append(" bytes.").toString());
        } else
        {
            return;
        }
    }

    private long doArrayNext()
        throws IOException
    {
        if (in.getCurrentToken() == JsonToken.END_ARRAY)
        {
            parser.advance(Symbol.ARRAY_END);
            in.nextToken();
            return 0L;
        } else
        {
            return 1L;
        }
    }

    private long doMapNext()
        throws IOException
    {
        if (in.getCurrentToken() == JsonToken.END_OBJECT)
        {
            in.nextToken();
            advance(Symbol.MAP_END);
            return 0L;
        } else
        {
            return 1L;
        }
    }

    private void doSkipFixed(int i)
        throws IOException
    {
        if (in.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            byte abyte0[] = readByteArray();
            in.nextToken();
            if (abyte0.length != i)
            {
                throw new AvroTypeException((new StringBuilder()).append("Expected fixed length ").append(i).append(", but got").append(abyte0.length).toString());
            } else
            {
                return;
            }
        } else
        {
            throw error("fixed");
        }
    }

    private AvroTypeException error(String s)
    {
        return new AvroTypeException((new StringBuilder()).append("Expected ").append(s).append(". Got ").append(in.getCurrentToken()).toString());
    }

    private static Symbol getSymbol(Schema schema)
    {
        if (schema == null)
        {
            throw new NullPointerException("Schema cannot be null!");
        } else
        {
            return (new JsonGrammarGenerator()).generate(schema);
        }
    }

    private static List getVaueAsTree(JsonParser jsonparser)
        throws IOException
    {
        ArrayList arraylist;
        int j;
        j = 0;
        arraylist = new ArrayList();
_L6:
        JsonToken jsontoken = jsonparser.getCurrentToken();
        static class _cls2
        {

            static final int $SwitchMap$org$codehaus$jackson$JsonToken[];

            static 
            {
                $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_OBJECT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.START_ARRAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.END_ARRAY.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.FIELD_NAME.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_STRING.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_INT.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_TRUE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_FALSE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$codehaus$jackson$JsonToken[JsonToken.VALUE_NULL.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.org.codehaus.jackson.JsonToken[jsontoken.ordinal()];
        JVM INSTR tableswitch 1 11: default 84
    //                   1 116
    //                   2 116
    //                   3 139
    //                   4 139
    //                   5 162
    //                   6 162
    //                   7 162
    //                   8 162
    //                   9 162
    //                   10 162
    //                   11 162;
           goto _L1 _L2 _L2 _L3 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4
_L4:
        break MISSING_BLOCK_LABEL_162;
_L1:
        int i = j;
_L7:
        jsonparser.nextToken();
        j = i;
        if (i != 0) goto _L6; else goto _L5
_L5:
        arraylist.add(new JsonElement(null));
        return arraylist;
_L2:
        i = j + 1;
        arraylist.add(new JsonElement(jsontoken));
          goto _L7
_L3:
        i = j - 1;
        arraylist.add(new JsonElement(jsontoken));
          goto _L7
        arraylist.add(new JsonElement(jsontoken, jsonparser.getText()));
        i = j;
          goto _L7
    }

    private JsonParser makeParser(final List elements)
        throws IOException
    {
        return new JsonParser() {

            int pos;
            final JsonDecoder this$0;
            final List val$elements;

            public void close()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public BigInteger getBigIntegerValue()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public byte[] getBinaryValue(Base64Variant base64variant)
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public ObjectCodec getCodec()
            {
                throw new UnsupportedOperationException();
            }

            public JsonLocation getCurrentLocation()
            {
                throw new UnsupportedOperationException();
            }

            public String getCurrentName()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public JsonToken getCurrentToken()
            {
                return ((JsonElement)elements.get(pos)).token;
            }

            public BigDecimal getDecimalValue()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public double getDoubleValue()
                throws IOException
            {
                return Double.parseDouble(getText());
            }

            public float getFloatValue()
                throws IOException
            {
                return Float.parseFloat(getText());
            }

            public int getIntValue()
                throws IOException
            {
                return Integer.parseInt(getText());
            }

            public long getLongValue()
                throws IOException
            {
                return Long.parseLong(getText());
            }

            public com.flurry.org.codehaus.jackson.JsonParser.NumberType getNumberType()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public Number getNumberValue()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public JsonStreamContext getParsingContext()
            {
                throw new UnsupportedOperationException();
            }

            public String getText()
                throws IOException
            {
                return ((JsonElement)elements.get(pos)).value;
            }

            public char[] getTextCharacters()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public int getTextLength()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public int getTextOffset()
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public JsonLocation getTokenLocation()
            {
                throw new UnsupportedOperationException();
            }

            public boolean isClosed()
            {
                throw new UnsupportedOperationException();
            }

            public JsonToken nextToken()
                throws IOException
            {
                pos = pos + 1;
                return ((JsonElement)elements.get(pos)).token;
            }

            public void setCodec(ObjectCodec objectcodec)
            {
                throw new UnsupportedOperationException();
            }

            public JsonParser skipChildren()
                throws IOException
            {
                int j = 0;
_L2:
                int i;
                int ai[] = _cls2..SwitchMap.org.codehaus.jackson.JsonToken;
                List list = elements;
                i = pos;
                pos = i + 1;
                switch (ai[((JsonElement)list.get(i)).token.ordinal()])
                {
                default:
                    i = j;
                    break;

                case 1: // '\001'
                case 2: // '\002'
                    break; /* Loop/switch isn't completed */

                case 3: // '\003'
                case 4: // '\004'
                    break MISSING_BLOCK_LABEL_92;
                }
_L3:
                j = i;
                if (i <= 0)
                {
                    return this;
                }
                if (true) goto _L2; else goto _L1
_L1:
                i = j + 1;
                  goto _L3
                i = j - 1;
                  goto _L3
            }

            
            {
                this$0 = JsonDecoder.this;
                elements = list;
                super();
                pos = 0;
            }
        };
    }

    private byte[] readByteArray()
        throws IOException
    {
        return in.getText().getBytes("ISO-8859-1");
    }

    public long arrayNext()
        throws IOException
    {
        advance(Symbol.ITEM_END);
        return doArrayNext();
    }

    public JsonDecoder configure(InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            throw new NullPointerException("InputStream to read from cannot be null!");
        } else
        {
            parser.reset();
            in = jsonFactory.createJsonParser(inputstream);
            in.nextToken();
            return this;
        }
    }

    public JsonDecoder configure(String s)
        throws IOException
    {
        if (s == null)
        {
            throw new NullPointerException("String to read from cannot be null!");
        } else
        {
            parser.reset();
            in = (new JsonFactory()).createJsonParser(s);
            in.nextToken();
            return this;
        }
    }

    public Symbol doAction(Symbol symbol, Symbol symbol1)
        throws IOException
    {
        if (!(symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction)) goto _L2; else goto _L1
_L1:
        symbol = (com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction)symbol1;
        symbol1 = ((com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction) (symbol)).fname;
        if (currentReorderBuffer == null) goto _L4; else goto _L3
_L3:
        List list = (List)currentReorderBuffer.savedFields.get(symbol1);
        if (list == null) goto _L4; else goto _L5
_L5:
        currentReorderBuffer.savedFields.remove(symbol1);
        currentReorderBuffer.origParser = in;
        in = makeParser(list);
_L7:
        return null;
_L4:
        if (in.getCurrentToken() != JsonToken.FIELD_NAME)
        {
            continue; /* Loop/switch isn't completed */
        }
        do
        {
            String s = in.getText();
            in.nextToken();
            if (symbol1.equals(s))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (currentReorderBuffer == null)
            {
                currentReorderBuffer = new ReorderBuffer();
            }
            currentReorderBuffer.savedFields.put(s, getVaueAsTree(in));
        } while (in.getCurrentToken() == JsonToken.FIELD_NAME);
        throw new AvroTypeException((new StringBuilder()).append("Expected field name not found: ").append(((com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction) (symbol)).fname).toString());
_L2:
        if (symbol1 != Symbol.FIELD_END)
        {
            break; /* Loop/switch isn't completed */
        }
        if (currentReorderBuffer != null && currentReorderBuffer.origParser != null)
        {
            in = currentReorderBuffer.origParser;
            currentReorderBuffer.origParser = null;
            return null;
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (symbol1 == Symbol.RECORD_START)
        {
            if (in.getCurrentToken() == JsonToken.START_OBJECT)
            {
                in.nextToken();
                reorderBuffers.push(currentReorderBuffer);
                currentReorderBuffer = null;
                return null;
            } else
            {
                throw error("record-start");
            }
        }
        if (symbol1 == Symbol.RECORD_END || symbol1 == Symbol.UNION_END)
        {
            if (in.getCurrentToken() == JsonToken.END_OBJECT)
            {
                in.nextToken();
                if (symbol1 == Symbol.RECORD_END)
                {
                    if (currentReorderBuffer != null && !currentReorderBuffer.savedFields.isEmpty())
                    {
                        throw error((new StringBuilder()).append("Unknown fields: ").append(currentReorderBuffer.savedFields.keySet()).toString());
                    } else
                    {
                        currentReorderBuffer = (ReorderBuffer)reorderBuffers.pop();
                        return null;
                    }
                }
            } else
            {
                if (symbol1 == Symbol.RECORD_END)
                {
                    symbol = "record-end";
                } else
                {
                    symbol = "union-end";
                }
                throw error(symbol);
            }
        } else
        {
            throw new AvroTypeException((new StringBuilder()).append("Unknown action symbol ").append(symbol1).toString());
        }
        if (true) goto _L7; else goto _L8
_L8:
    }

    public long mapNext()
        throws IOException
    {
        advance(Symbol.ITEM_END);
        return doMapNext();
    }

    public long readArrayStart()
        throws IOException
    {
        advance(Symbol.ARRAY_START);
        if (in.getCurrentToken() == JsonToken.START_ARRAY)
        {
            in.nextToken();
            return doArrayNext();
        } else
        {
            throw error("array-start");
        }
    }

    public boolean readBoolean()
        throws IOException
    {
        advance(Symbol.BOOLEAN);
        JsonToken jsontoken = in.getCurrentToken();
        if (jsontoken == JsonToken.VALUE_TRUE || jsontoken == JsonToken.VALUE_FALSE)
        {
            in.nextToken();
            return jsontoken == JsonToken.VALUE_TRUE;
        } else
        {
            throw error("boolean");
        }
    }

    public ByteBuffer readBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        advance(Symbol.BYTES);
        if (in.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            bytebuffer = readByteArray();
            in.nextToken();
            return ByteBuffer.wrap(bytebuffer);
        } else
        {
            throw error("bytes");
        }
    }

    public double readDouble()
        throws IOException
    {
        advance(Symbol.DOUBLE);
        if (in.getCurrentToken() == JsonToken.VALUE_NUMBER_FLOAT)
        {
            double d = in.getDoubleValue();
            in.nextToken();
            return d;
        } else
        {
            throw error("double");
        }
    }

    public int readEnum()
        throws IOException
    {
        advance(Symbol.ENUM);
        com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction enumlabelsaction = (com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction)parser.popSymbol();
        if (in.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            in.getText();
            int i = enumlabelsaction.findLabel(in.getText());
            if (i >= 0)
            {
                in.nextToken();
                return i;
            } else
            {
                throw new AvroTypeException((new StringBuilder()).append("Unknown symbol in enum ").append(in.getText()).toString());
            }
        } else
        {
            throw error("fixed");
        }
    }

    public void readFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        checkFixed(j);
        if (in.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            byte abyte1[] = readByteArray();
            in.nextToken();
            if (abyte1.length != j)
            {
                throw new AvroTypeException((new StringBuilder()).append("Expected fixed length ").append(j).append(", but got").append(abyte1.length).toString());
            } else
            {
                System.arraycopy(abyte1, 0, abyte0, i, j);
                return;
            }
        } else
        {
            throw error("fixed");
        }
    }

    public float readFloat()
        throws IOException
    {
        advance(Symbol.FLOAT);
        if (in.getCurrentToken() == JsonToken.VALUE_NUMBER_FLOAT)
        {
            float f = in.getFloatValue();
            in.nextToken();
            return f;
        } else
        {
            throw error("float");
        }
    }

    public int readIndex()
        throws IOException
    {
        advance(Symbol.UNION);
        com.flurry.org.apache.avro.io.parsing.Symbol.Alternative alternative = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
        String s;
        int i;
        if (in.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            s = "null";
        } else
        if (in.getCurrentToken() == JsonToken.START_OBJECT && in.nextToken() == JsonToken.FIELD_NAME)
        {
            s = in.getText();
            in.nextToken();
            parser.pushSymbol(Symbol.UNION_END);
        } else
        {
            throw error("start-union");
        }
        i = alternative.findLabel(s);
        if (i < 0)
        {
            throw new AvroTypeException((new StringBuilder()).append("Unknown union branch ").append(s).toString());
        } else
        {
            parser.pushSymbol(alternative.getSymbol(i));
            return i;
        }
    }

    public int readInt()
        throws IOException
    {
        advance(Symbol.INT);
        if (in.getCurrentToken() == JsonToken.VALUE_NUMBER_INT)
        {
            int i = in.getIntValue();
            in.nextToken();
            return i;
        } else
        {
            throw error("int");
        }
    }

    public long readLong()
        throws IOException
    {
        advance(Symbol.LONG);
        if (in.getCurrentToken() == JsonToken.VALUE_NUMBER_INT)
        {
            long l = in.getLongValue();
            in.nextToken();
            return l;
        } else
        {
            throw error("long");
        }
    }

    public long readMapStart()
        throws IOException
    {
        advance(Symbol.MAP_START);
        if (in.getCurrentToken() == JsonToken.START_OBJECT)
        {
            in.nextToken();
            return doMapNext();
        } else
        {
            throw error("map-start");
        }
    }

    public void readNull()
        throws IOException
    {
        advance(Symbol.NULL);
        if (in.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            in.nextToken();
            return;
        } else
        {
            throw error("null");
        }
    }

    public Utf8 readString(Utf8 utf8)
        throws IOException
    {
        return new Utf8(readString());
    }

    public String readString()
        throws IOException
    {
        advance(Symbol.STRING);
        if (parser.topSymbol() == Symbol.MAP_KEY_MARKER)
        {
            parser.advance(Symbol.MAP_KEY_MARKER);
            if (in.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw error("map-key");
            }
        } else
        if (in.getCurrentToken() != JsonToken.VALUE_STRING)
        {
            throw error("string");
        }
        String s = in.getText();
        in.nextToken();
        return s;
    }

    public long skipArray()
        throws IOException
    {
        advance(Symbol.ARRAY_START);
        if (in.getCurrentToken() == JsonToken.START_ARRAY)
        {
            in.skipChildren();
            in.nextToken();
            advance(Symbol.ARRAY_END);
            return 0L;
        } else
        {
            throw error("array-start");
        }
    }

    public void skipBytes()
        throws IOException
    {
        advance(Symbol.BYTES);
        if (in.getCurrentToken() == JsonToken.VALUE_STRING)
        {
            in.nextToken();
            return;
        } else
        {
            throw error("bytes");
        }
    }

    protected void skipFixed()
        throws IOException
    {
        advance(Symbol.FIXED);
        doSkipFixed(((com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol()).size);
    }

    public void skipFixed(int i)
        throws IOException
    {
        checkFixed(i);
        doSkipFixed(i);
    }

    public long skipMap()
        throws IOException
    {
        advance(Symbol.MAP_START);
        if (in.getCurrentToken() == JsonToken.START_OBJECT)
        {
            in.skipChildren();
            in.nextToken();
            advance(Symbol.MAP_END);
            return 0L;
        } else
        {
            throw error("map-start");
        }
    }

    public void skipString()
        throws IOException
    {
        advance(Symbol.STRING);
        if (parser.topSymbol() == Symbol.MAP_KEY_MARKER)
        {
            parser.advance(Symbol.MAP_KEY_MARKER);
            if (in.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw error("map-key");
            }
        } else
        if (in.getCurrentToken() != JsonToken.VALUE_STRING)
        {
            throw error("string");
        }
        in.nextToken();
    }

}
