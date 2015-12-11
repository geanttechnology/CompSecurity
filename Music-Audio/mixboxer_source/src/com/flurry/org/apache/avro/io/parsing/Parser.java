// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import com.flurry.org.apache.avro.AvroTypeException;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Symbol

public class Parser
{
    public static interface ActionHandler
    {

        public abstract Symbol doAction(Symbol symbol, Symbol symbol1)
            throws IOException;
    }


    protected int pos;
    protected Symbol stack[];
    protected final ActionHandler symbolHandler;

    public Parser(Symbol symbol, ActionHandler actionhandler)
        throws IOException
    {
        symbolHandler = actionhandler;
        stack = new Symbol[5];
        stack[0] = symbol;
        pos = 1;
    }

    private void expandStack()
    {
        Symbol asymbol[] = new Symbol[stack.length + Math.max(stack.length, 1024)];
        System.arraycopy(stack, 0, asymbol, 0, stack.length);
        stack = asymbol;
    }

    public final Symbol advance(Symbol symbol)
        throws IOException
    {
        do
        {
            Symbol asymbol[] = stack;
            int i = pos - 1;
            pos = i;
            Symbol symbol1 = asymbol[i];
            if (symbol1 == symbol)
            {
                return symbol1;
            }
            Symbol.Kind kind = symbol1.kind;
            if (kind == Symbol.Kind.IMPLICIT_ACTION)
            {
                symbol1 = symbolHandler.doAction(symbol, symbol1);
                if (symbol1 != null)
                {
                    return symbol1;
                }
            } else
            {
                if (kind == Symbol.Kind.TERMINAL)
                {
                    throw new AvroTypeException((new StringBuilder()).append("Attempt to process a ").append(symbol).append(" when a ").append(symbol1).append(" was expected.").toString());
                }
                if (kind == Symbol.Kind.REPEATER && symbol == ((Symbol.Repeater)symbol1).end)
                {
                    return symbol;
                }
                pushProduction(symbol1);
            }
        } while (true);
    }

    public int depth()
    {
        return pos;
    }

    public Symbol popSymbol()
    {
        Symbol asymbol[] = stack;
        int i = pos - 1;
        pos = i;
        return asymbol[i];
    }

    public final void processImplicitActions()
        throws IOException
    {
        do
        {
            if (pos <= 1)
            {
                break;
            }
            Symbol symbol = stack[pos - 1];
            if (symbol.kind == Symbol.Kind.IMPLICIT_ACTION)
            {
                pos = pos - 1;
                symbolHandler.doAction(null, symbol);
                continue;
            }
            if (symbol.kind == Symbol.Kind.TERMINAL)
            {
                break;
            }
            pos = pos - 1;
            pushProduction(symbol);
        } while (true);
    }

    public final void processTrailingImplicitActions()
        throws IOException
    {
        do
        {
            if (pos < 1)
            {
                break;
            }
            Symbol symbol = stack[pos - 1];
            if (symbol.kind != Symbol.Kind.IMPLICIT_ACTION || !((Symbol.ImplicitAction)symbol).isTrailing)
            {
                break;
            }
            pos = pos - 1;
            symbolHandler.doAction(null, symbol);
        } while (true);
    }

    public final void pushProduction(Symbol symbol)
    {
        for (symbol = symbol.production; pos + symbol.length > stack.length;)
        {
            expandStack();
        }

        System.arraycopy(symbol, 0, stack, pos, symbol.length);
        pos = pos + symbol.length;
    }

    public void pushSymbol(Symbol symbol)
    {
        if (pos == stack.length)
        {
            expandStack();
        }
        Symbol asymbol[] = stack;
        int i = pos;
        pos = i + 1;
        asymbol[i] = symbol;
    }

    public void reset()
    {
        pos = 1;
    }

    public Symbol topSymbol()
    {
        return stack[pos - 1];
    }
}
