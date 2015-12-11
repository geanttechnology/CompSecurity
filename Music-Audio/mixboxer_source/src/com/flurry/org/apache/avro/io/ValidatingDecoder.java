// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import com.flurry.org.apache.avro.io.parsing.ValidatingGrammarGenerator;
import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            ParsingDecoder, Decoder

public class ValidatingDecoder extends ParsingDecoder
    implements com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler
{

    protected Decoder in;

    ValidatingDecoder(Schema schema, Decoder decoder)
        throws IOException
    {
        this(getSymbol(schema), decoder);
    }

    ValidatingDecoder(Symbol symbol, Decoder decoder)
        throws IOException
    {
        super(symbol);
        configure(decoder);
    }

    private void checkFixed(int i)
        throws IOException
    {
        parser.advance(Symbol.FIXED);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        if (i != intcheckaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Incorrect length for fixed binary: expected ").append(intcheckaction.size).append(" but received ").append(i).append(" bytes.").toString());
        } else
        {
            return;
        }
    }

    private static Symbol getSymbol(Schema schema)
    {
        if (schema == null)
        {
            throw new NullPointerException("Schema cannot be null");
        } else
        {
            return (new ValidatingGrammarGenerator()).generate(schema);
        }
    }

    public long arrayNext()
        throws IOException
    {
        parser.processTrailingImplicitActions();
        long l = in.arrayNext();
        if (l == 0L)
        {
            parser.advance(Symbol.ARRAY_END);
        }
        return l;
    }

    public ValidatingDecoder configure(Decoder decoder)
        throws IOException
    {
        parser.reset();
        in = decoder;
        return this;
    }

    public Symbol doAction(Symbol symbol, Symbol symbol1)
        throws IOException
    {
        return null;
    }

    public long mapNext()
        throws IOException
    {
        parser.processTrailingImplicitActions();
        long l = in.mapNext();
        if (l == 0L)
        {
            parser.advance(Symbol.MAP_END);
        }
        return l;
    }

    public long readArrayStart()
        throws IOException
    {
        parser.advance(Symbol.ARRAY_START);
        long l = in.readArrayStart();
        if (l == 0L)
        {
            parser.advance(Symbol.ARRAY_END);
        }
        return l;
    }

    public boolean readBoolean()
        throws IOException
    {
        parser.advance(Symbol.BOOLEAN);
        return in.readBoolean();
    }

    public ByteBuffer readBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        parser.advance(Symbol.BYTES);
        return in.readBytes(bytebuffer);
    }

    public double readDouble()
        throws IOException
    {
        parser.advance(Symbol.DOUBLE);
        return in.readDouble();
    }

    public int readEnum()
        throws IOException
    {
        parser.advance(Symbol.ENUM);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        int i = in.readEnum();
        if (i < 0 || i >= intcheckaction.size)
        {
            throw new AvroTypeException((new StringBuilder()).append("Enumeration out of range: max is ").append(intcheckaction.size).append(" but received ").append(i).toString());
        } else
        {
            return i;
        }
    }

    public void readFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        checkFixed(j);
        in.readFixed(abyte0, i, j);
    }

    public float readFloat()
        throws IOException
    {
        parser.advance(Symbol.FLOAT);
        return in.readFloat();
    }

    public int readIndex()
        throws IOException
    {
        parser.advance(Symbol.UNION);
        com.flurry.org.apache.avro.io.parsing.Symbol.Alternative alternative = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
        int i = in.readIndex();
        parser.pushSymbol(alternative.getSymbol(i));
        return i;
    }

    public int readInt()
        throws IOException
    {
        parser.advance(Symbol.INT);
        return in.readInt();
    }

    public long readLong()
        throws IOException
    {
        parser.advance(Symbol.LONG);
        return in.readLong();
    }

    public long readMapStart()
        throws IOException
    {
        parser.advance(Symbol.MAP_START);
        long l = in.readMapStart();
        if (l == 0L)
        {
            parser.advance(Symbol.MAP_END);
        }
        return l;
    }

    public void readNull()
        throws IOException
    {
        parser.advance(Symbol.NULL);
        in.readNull();
    }

    public Utf8 readString(Utf8 utf8)
        throws IOException
    {
        parser.advance(Symbol.STRING);
        return in.readString(utf8);
    }

    public String readString()
        throws IOException
    {
        parser.advance(Symbol.STRING);
        return in.readString();
    }

    public long skipArray()
        throws IOException
    {
        parser.advance(Symbol.ARRAY_START);
        for (long l = in.skipArray(); l != 0L; l = in.skipArray())
        {
            for (; l > 0L; l--)
            {
                parser.skipRepeater();
            }

        }

        parser.advance(Symbol.ARRAY_END);
        return 0L;
    }

    public void skipBytes()
        throws IOException
    {
        parser.advance(Symbol.BYTES);
        in.skipBytes();
    }

    protected void skipFixed()
        throws IOException
    {
        parser.advance(Symbol.FIXED);
        com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction intcheckaction = (com.flurry.org.apache.avro.io.parsing.Symbol.IntCheckAction)parser.popSymbol();
        in.skipFixed(intcheckaction.size);
    }

    public void skipFixed(int i)
        throws IOException
    {
        checkFixed(i);
        in.skipFixed(i);
    }

    public long skipMap()
        throws IOException
    {
        parser.advance(Symbol.MAP_START);
        for (long l = in.skipMap(); l != 0L; l = in.skipMap())
        {
            for (; l > 0L; l--)
            {
                parser.skipRepeater();
            }

        }

        parser.advance(Symbol.MAP_END);
        return 0L;
    }

    public void skipString()
        throws IOException
    {
        parser.advance(Symbol.STRING);
        in.skipString();
    }
}
