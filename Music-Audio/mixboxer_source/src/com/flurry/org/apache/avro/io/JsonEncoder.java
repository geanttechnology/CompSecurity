// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.JsonGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.Parser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.util.Utf8;
import com.flurry.org.codehaus.jackson.JsonEncoding;
import com.flurry.org.codehaus.jackson.JsonFactory;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.util.MinimalPrettyPrinter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.BitSet;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            ParsingEncoder

public class JsonEncoder extends ParsingEncoder
    implements com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler
{

    protected BitSet isEmpty;
    private JsonGenerator out;
    final Parser parser;

    JsonEncoder(Schema schema, JsonGenerator jsongenerator)
        throws IOException
    {
        isEmpty = new BitSet();
        configure(jsongenerator);
        parser = new Parser((new JsonGrammarGenerator()).generate(schema), this);
    }

    JsonEncoder(Schema schema, OutputStream outputstream)
        throws IOException
    {
        this(schema, getJsonGenerator(outputstream));
    }

    private static JsonGenerator getJsonGenerator(OutputStream outputstream)
        throws IOException
    {
        if (outputstream == null)
        {
            throw new NullPointerException("OutputStream cannot be null");
        } else
        {
            outputstream = (new JsonFactory()).createJsonGenerator(outputstream, JsonEncoding.UTF8);
            MinimalPrettyPrinter minimalprettyprinter = new MinimalPrettyPrinter();
            minimalprettyprinter.setRootValueSeparator(System.getProperty("line.separator"));
            outputstream.setPrettyPrinter(minimalprettyprinter);
            return outputstream;
        }
    }

    private void writeByteArray(byte abyte0[], int i, int j)
        throws IOException
    {
        out.writeString(new String(abyte0, i, j, "ISO-8859-1"));
    }

    public JsonEncoder configure(JsonGenerator jsongenerator)
        throws IOException
    {
        if (jsongenerator == null)
        {
            throw new NullPointerException("JsonGenerator cannot be null");
        }
        if (parser != null)
        {
            flush();
        }
        out = jsongenerator;
        return this;
    }

    public JsonEncoder configure(OutputStream outputstream)
        throws IOException
    {
        configure(getJsonGenerator(outputstream));
        return this;
    }

    public Symbol doAction(Symbol symbol, Symbol symbol1)
        throws IOException
    {
        if (!(symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction)) goto _L2; else goto _L1
_L1:
        symbol = (com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction)symbol1;
        out.writeFieldName(((com.flurry.org.apache.avro.io.parsing.Symbol.FieldAdjustAction) (symbol)).fname);
_L4:
        return null;
_L2:
        if (symbol1 == Symbol.RECORD_START)
        {
            out.writeStartObject();
            continue; /* Loop/switch isn't completed */
        }
        if (symbol1 != Symbol.RECORD_END && symbol1 != Symbol.UNION_END)
        {
            break; /* Loop/switch isn't completed */
        }
        out.writeEndObject();
        if (true) goto _L4; else goto _L3
_L3:
        if (symbol1 == Symbol.FIELD_END) goto _L4; else goto _L5
_L5:
        throw new AvroTypeException((new StringBuilder()).append("Unknown action symbol ").append(symbol1).toString());
    }

    public void flush()
        throws IOException
    {
        parser.processImplicitActions();
        if (out != null)
        {
            out.flush();
        }
    }

    public void startItem()
        throws IOException
    {
        if (!isEmpty.get(pos))
        {
            parser.advance(Symbol.ITEM_END);
        }
        super.startItem();
        isEmpty.clear(depth());
    }

    public void writeArrayEnd()
        throws IOException
    {
        if (!isEmpty.get(pos))
        {
            parser.advance(Symbol.ITEM_END);
        }
        pop();
        parser.advance(Symbol.ARRAY_END);
        out.writeEndArray();
    }

    public void writeArrayStart()
        throws IOException
    {
        parser.advance(Symbol.ARRAY_START);
        out.writeStartArray();
        push();
        isEmpty.set(depth());
    }

    public void writeBoolean(boolean flag)
        throws IOException
    {
        parser.advance(Symbol.BOOLEAN);
        out.writeBoolean(flag);
    }

    public void writeBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        if (bytebuffer.hasArray())
        {
            writeBytes(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
            return;
        }
        byte abyte0[] = new byte[bytebuffer.remaining()];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = bytebuffer.get();
        }

        writeBytes(abyte0);
    }

    public void writeBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        parser.advance(Symbol.BYTES);
        writeByteArray(abyte0, i, j);
    }

    public void writeDouble(double d)
        throws IOException
    {
        parser.advance(Symbol.DOUBLE);
        out.writeNumber(d);
    }

    public void writeEnum(int i)
        throws IOException
    {
        parser.advance(Symbol.ENUM);
        com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction enumlabelsaction = (com.flurry.org.apache.avro.io.parsing.Symbol.EnumLabelsAction)parser.popSymbol();
        if (i < 0 || i >= enumlabelsaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Enumeration out of range: max is ").append(enumlabelsaction.size).append(" but received ").append(i).toString());
        } else
        {
            out.writeString(enumlabelsaction.getLabel(i));
            return;
        }
    }

    public void writeFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        parser.advance(Symbol.FIXED);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        if (j != intcheckaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Incorrect length for fixed binary: expected ").append(intcheckaction.size).append(" but received ").append(j).append(" bytes.").toString());
        } else
        {
            writeByteArray(abyte0, i, j);
            return;
        }
    }

    public void writeFloat(float f)
        throws IOException
    {
        parser.advance(Symbol.FLOAT);
        out.writeNumber(f);
    }

    public void writeIndex(int i)
        throws IOException
    {
        parser.advance(Symbol.UNION);
        com.flurry.org.apache.avro.io.parsing.Symbol.Alternative alternative = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
        Symbol symbol = alternative.getSymbol(i);
        if (symbol != Symbol.NULL)
        {
            out.writeStartObject();
            out.writeFieldName(alternative.getLabel(i));
            parser.pushSymbol(Symbol.UNION_END);
        }
        parser.pushSymbol(symbol);
    }

    public void writeInt(int i)
        throws IOException
    {
        parser.advance(Symbol.INT);
        out.writeNumber(i);
    }

    public void writeLong(long l)
        throws IOException
    {
        parser.advance(Symbol.LONG);
        out.writeNumber(l);
    }

    public void writeMapEnd()
        throws IOException
    {
        if (!isEmpty.get(pos))
        {
            parser.advance(Symbol.ITEM_END);
        }
        pop();
        parser.advance(Symbol.MAP_END);
        out.writeEndObject();
    }

    public void writeMapStart()
        throws IOException
    {
        push();
        isEmpty.set(depth());
        parser.advance(Symbol.MAP_START);
        out.writeStartObject();
    }

    public void writeNull()
        throws IOException
    {
        parser.advance(Symbol.NULL);
        out.writeNull();
    }

    public void writeString(Utf8 utf8)
        throws IOException
    {
        writeString(utf8.toString());
    }

    public void writeString(String s)
        throws IOException
    {
        parser.advance(Symbol.STRING);
        if (parser.topSymbol() == Symbol.MAP_KEY_MARKER)
        {
            parser.advance(Symbol.MAP_KEY_MARKER);
            out.writeFieldName(s);
            return;
        } else
        {
            out.writeString(s);
            return;
        }
    }
}
