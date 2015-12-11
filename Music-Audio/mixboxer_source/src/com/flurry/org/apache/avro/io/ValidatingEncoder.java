// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.Parser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.ValidatingGrammarGenerator;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            ParsingEncoder, Encoder

public class ValidatingEncoder extends ParsingEncoder
    implements com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler
{

    protected Encoder out;
    protected final Parser parser;

    ValidatingEncoder(Schema schema, Encoder encoder)
        throws IOException
    {
        this((new ValidatingGrammarGenerator()).generate(schema), encoder);
    }

    ValidatingEncoder(Symbol symbol, Encoder encoder)
        throws IOException
    {
        out = encoder;
        parser = new Parser(symbol, this);
    }

    public ValidatingEncoder configure(Encoder encoder)
    {
        parser.reset();
        out = encoder;
        return this;
    }

    public Symbol doAction(Symbol symbol, Symbol symbol1)
        throws IOException
    {
        return null;
    }

    public void flush()
        throws IOException
    {
        out.flush();
    }

    public void setItemCount(long l)
        throws IOException
    {
        super.setItemCount(l);
        out.setItemCount(l);
    }

    public void startItem()
        throws IOException
    {
        super.startItem();
        out.startItem();
    }

    public void writeArrayEnd()
        throws IOException
    {
        parser.advance(Symbol.ARRAY_END);
        out.writeArrayEnd();
        pop();
    }

    public void writeArrayStart()
        throws IOException
    {
        push();
        parser.advance(Symbol.ARRAY_START);
        out.writeArrayStart();
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
        parser.advance(Symbol.BYTES);
        out.writeBytes(bytebuffer);
    }

    public void writeBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        parser.advance(Symbol.BYTES);
        out.writeBytes(abyte0, i, j);
    }

    public void writeDouble(double d)
        throws IOException
    {
        parser.advance(Symbol.DOUBLE);
        out.writeDouble(d);
    }

    public void writeEnum(int i)
        throws IOException
    {
        parser.advance(Symbol.ENUM);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        if (i < 0 || i >= intcheckaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Enumeration out of range: max is ").append(intcheckaction.size).append(" but received ").append(i).toString());
        } else
        {
            out.writeEnum(i);
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
            out.writeFixed(abyte0, i, j);
            return;
        }
    }

    public void writeFloat(float f)
        throws IOException
    {
        parser.advance(Symbol.FLOAT);
        out.writeFloat(f);
    }

    public void writeIndex(int i)
        throws IOException
    {
        parser.advance(Symbol.UNION);
        com.flurry.org.apache.avro.io.parsing.Symbol.Alternative alternative = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
        parser.pushSymbol(alternative.getSymbol(i));
        out.writeIndex(i);
    }

    public void writeInt(int i)
        throws IOException
    {
        parser.advance(Symbol.INT);
        out.writeInt(i);
    }

    public void writeLong(long l)
        throws IOException
    {
        parser.advance(Symbol.LONG);
        out.writeLong(l);
    }

    public void writeMapEnd()
        throws IOException
    {
        parser.advance(Symbol.MAP_END);
        out.writeMapEnd();
        pop();
    }

    public void writeMapStart()
        throws IOException
    {
        push();
        parser.advance(Symbol.MAP_START);
        out.writeMapStart();
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
        parser.advance(Symbol.STRING);
        out.writeString(utf8);
    }

    public void writeString(CharSequence charsequence)
        throws IOException
    {
        parser.advance(Symbol.STRING);
        out.writeString(charsequence);
    }

    public void writeString(String s)
        throws IOException
    {
        parser.advance(Symbol.STRING);
        out.writeString(s);
    }
}
