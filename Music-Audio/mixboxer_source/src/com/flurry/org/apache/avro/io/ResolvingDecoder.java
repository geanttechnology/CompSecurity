// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroTypeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.apache.avro.io.parsing.ResolvingGrammarGenerator;
import com.flurry.org.apache.avro.io.parsing.SkipParser;
import com.flurry.org.apache.avro.io.parsing.Symbol;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            ValidatingDecoder, Decoder, DecoderFactory

public class ResolvingDecoder extends ValidatingDecoder
{

    static final boolean $assertionsDisabled;
    private Decoder backup;

    ResolvingDecoder(Schema schema, Schema schema1, Decoder decoder)
        throws IOException
    {
        this(resolve(schema, schema1), decoder);
    }

    private ResolvingDecoder(Object obj, Decoder decoder)
        throws IOException
    {
        super((Symbol)obj, decoder);
    }

    public static Object resolve(Schema schema, Schema schema1)
        throws IOException
    {
        if (schema == null)
        {
            throw new NullPointerException("writer cannot be null!");
        }
        if (schema1 == null)
        {
            throw new NullPointerException("reader cannot be null!");
        } else
        {
            return (new ResolvingGrammarGenerator()).generate(schema, schema1);
        }
    }

    public Symbol doAction(Symbol symbol, Symbol symbol1)
        throws IOException
    {
        if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.FieldOrderAction)
        {
            if (symbol == Symbol.FIELD_ACTION)
            {
                return symbol1;
            } else
            {
                return null;
            }
        }
        if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction)
        {
            symbol1 = (com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction)symbol1;
            if (((com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction) (symbol1)).reader != symbol)
            {
                throw new AvroTypeException((new StringBuilder()).append("Found ").append(((com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction) (symbol1)).reader).append(" while looking for ").append(symbol).toString());
            } else
            {
                return ((com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction) (symbol1)).writer;
            }
        }
        if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.SkipAction)
        {
            symbol = ((com.flurry.org.apache.avro.io.parsing.Symbol.SkipAction)symbol1).symToSkip;
            parser.skipSymbol(symbol);
        } else
        if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.WriterUnionAction)
        {
            symbol = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
            parser.pushSymbol(symbol.getSymbol(in.readIndex()));
        } else
        {
            if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.ErrorAction)
            {
                throw new AvroTypeException(((com.flurry.org.apache.avro.io.parsing.Symbol.ErrorAction)symbol1).msg);
            }
            if (symbol1 instanceof com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction)
            {
                symbol = (com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction)symbol1;
                backup = in;
                in = DecoderFactory.get().binaryDecoder(((com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction) (symbol)).contents, null);
            } else
            if (symbol1 == Symbol.DEFAULT_END_ACTION)
            {
                in = backup;
            } else
            {
                throw new AvroTypeException((new StringBuilder()).append("Unknown action: ").append(symbol1).toString());
            }
        }
        return null;
    }

    public final void drain()
        throws IOException
    {
        parser.processImplicitActions();
    }

    public double readDouble()
        throws IOException
    {
        Symbol symbol = parser.advance(Symbol.DOUBLE);
        if (symbol == Symbol.INT)
        {
            return (double)in.readInt();
        }
        if (symbol == Symbol.LONG)
        {
            return (double)in.readLong();
        }
        if (symbol == Symbol.FLOAT)
        {
            return (double)in.readFloat();
        }
        if (!$assertionsDisabled && symbol != Symbol.DOUBLE)
        {
            throw new AssertionError();
        } else
        {
            return in.readDouble();
        }
    }

    public int readEnum()
        throws IOException
    {
        parser.advance(Symbol.ENUM);
        Object obj = (com.flurry.org.apache.avro.io.parsing.Symbol.EnumAdjustAction)parser.popSymbol();
        int i = in.readEnum();
        obj = ((com.flurry.org.apache.avro.io.parsing.Symbol.EnumAdjustAction) (obj)).adjustments[i];
        if (obj instanceof Integer)
        {
            return ((Integer)obj).intValue();
        } else
        {
            throw new AvroTypeException((String)obj);
        }
    }

    public final com.flurry.org.apache.avro.Schema.Field[] readFieldOrder()
        throws IOException
    {
        return ((com.flurry.org.apache.avro.io.parsing.Symbol.FieldOrderAction)parser.advance(Symbol.FIELD_ACTION)).fields;
    }

    public float readFloat()
        throws IOException
    {
        Symbol symbol = parser.advance(Symbol.FLOAT);
        if (symbol == Symbol.INT)
        {
            return (float)in.readInt();
        }
        if (symbol == Symbol.LONG)
        {
            return (float)in.readLong();
        }
        if (!$assertionsDisabled && symbol != Symbol.FLOAT)
        {
            throw new AssertionError();
        } else
        {
            return in.readFloat();
        }
    }

    public int readIndex()
        throws IOException
    {
        parser.advance(Symbol.UNION);
        com.flurry.org.apache.avro.io.parsing.Symbol.UnionAdjustAction unionadjustaction = (com.flurry.org.apache.avro.io.parsing.Symbol.UnionAdjustAction)parser.popSymbol();
        parser.pushSymbol(unionadjustaction.symToParse);
        return unionadjustaction.rindex;
    }

    public long readLong()
        throws IOException
    {
        Symbol symbol = parser.advance(Symbol.LONG);
        if (symbol == Symbol.INT)
        {
            return (long)in.readInt();
        }
        if (symbol == Symbol.DOUBLE)
        {
            return (long)in.readDouble();
        }
        if (!$assertionsDisabled && symbol != Symbol.LONG)
        {
            throw new AssertionError();
        } else
        {
            return in.readLong();
        }
    }

    public void skipAction()
        throws IOException
    {
        Object obj = parser.popSymbol();
        if (obj instanceof com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction)
        {
            parser.pushSymbol(((com.flurry.org.apache.avro.io.parsing.Symbol.ResolvingAction)obj).writer);
        } else
        {
            if (obj instanceof com.flurry.org.apache.avro.io.parsing.Symbol.SkipAction)
            {
                parser.pushSymbol(((com.flurry.org.apache.avro.io.parsing.Symbol.SkipAction)obj).symToSkip);
                return;
            }
            if (obj instanceof com.flurry.org.apache.avro.io.parsing.Symbol.WriterUnionAction)
            {
                obj = (com.flurry.org.apache.avro.io.parsing.Symbol.Alternative)parser.popSymbol();
                parser.pushSymbol(((com.flurry.org.apache.avro.io.parsing.Symbol.Alternative) (obj)).getSymbol(in.readIndex()));
                return;
            }
            if (obj instanceof com.flurry.org.apache.avro.io.parsing.Symbol.ErrorAction)
            {
                throw new AvroTypeException(((com.flurry.org.apache.avro.io.parsing.Symbol.ErrorAction)obj).msg);
            }
            if (obj instanceof com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction)
            {
                obj = (com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction)obj;
                backup = in;
                in = DecoderFactory.get().binaryDecoder(((com.flurry.org.apache.avro.io.parsing.Symbol.DefaultStartAction) (obj)).contents, null);
                return;
            }
            if (obj == Symbol.DEFAULT_END_ACTION)
            {
                in = backup;
                return;
            }
        }
    }

    static 
    {
        boolean flag;
        if (!com/flurry/org/apache/avro/io/ResolvingDecoder.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
