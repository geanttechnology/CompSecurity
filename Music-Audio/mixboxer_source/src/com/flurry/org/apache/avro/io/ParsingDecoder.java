// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Decoder

public abstract class ParsingDecoder extends Decoder
    implements com.flurry.org.apache.avro.io.parsing.Parser.ActionHandler, com.flurry.org.apache.avro.io.parsing.SkipParser.SkipHandler
{

    protected final SkipParser parser;

    protected ParsingDecoder(Symbol symbol)
        throws IOException
    {
        parser = new SkipParser(symbol, this, this);
    }

    public void skipAction()
        throws IOException
    {
        parser.popSymbol();
    }

    protected abstract void skipFixed()
        throws IOException;

    public void skipTopSymbol()
        throws IOException
    {
        Symbol symbol = parser.topSymbol();
        if (symbol == Symbol.NULL)
        {
            readNull();
        }
        if (symbol == Symbol.BOOLEAN)
        {
            readBoolean();
        } else
        {
            if (symbol == Symbol.INT)
            {
                readInt();
                return;
            }
            if (symbol == Symbol.LONG)
            {
                readLong();
                return;
            }
            if (symbol == Symbol.FLOAT)
            {
                readFloat();
                return;
            }
            if (symbol == Symbol.DOUBLE)
            {
                readDouble();
                return;
            }
            if (symbol == Symbol.STRING)
            {
                skipString();
                return;
            }
            if (symbol == Symbol.BYTES)
            {
                skipBytes();
                return;
            }
            if (symbol == Symbol.ENUM)
            {
                readEnum();
                return;
            }
            if (symbol == Symbol.FIXED)
            {
                skipFixed();
                return;
            }
            if (symbol == Symbol.UNION)
            {
                readIndex();
                return;
            }
            if (symbol == Symbol.ARRAY_START)
            {
                skipArray();
                return;
            }
            if (symbol == Symbol.MAP_START)
            {
                skipMap();
                return;
            }
        }
    }
}
