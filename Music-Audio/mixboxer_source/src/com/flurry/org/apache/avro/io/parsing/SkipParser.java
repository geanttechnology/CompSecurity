// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io.parsing;

import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io.parsing:
//            Parser, Symbol

public class SkipParser extends Parser
{
    public static interface SkipHandler
    {

        public abstract void skipAction()
            throws IOException;

        public abstract void skipTopSymbol()
            throws IOException;
    }


    static final boolean $assertionsDisabled;
    private final SkipHandler skipHandler;

    public SkipParser(Symbol symbol, Parser.ActionHandler actionhandler, SkipHandler skiphandler)
        throws IOException
    {
        super(symbol, actionhandler);
        skipHandler = skiphandler;
    }

    public final void skipRepeater()
        throws IOException
    {
        int i = pos;
        Symbol asymbol[] = stack;
        int j = pos - 1;
        pos = j;
        Symbol symbol = asymbol[j];
        if (!$assertionsDisabled && symbol.kind != Symbol.Kind.REPEATER)
        {
            throw new AssertionError();
        } else
        {
            pushProduction(symbol);
            skipTo(i);
            return;
        }
    }

    public final void skipSymbol(Symbol symbol)
        throws IOException
    {
        int i = pos;
        pushSymbol(symbol);
        skipTo(i);
    }

    public final void skipTo(int i)
        throws IOException
    {
        while (i < pos) 
        {
            Symbol symbol = stack[pos - 1];
            if (symbol.kind != Symbol.Kind.TERMINAL)
            {
                if (symbol.kind == Symbol.Kind.IMPLICIT_ACTION || symbol.kind == Symbol.Kind.EXPLICIT_ACTION)
                {
                    skipHandler.skipAction();
                } else
                {
                    pos = pos - 1;
                    pushProduction(symbol);
                }
            } else
            {
                skipHandler.skipTopSymbol();
            }
        }
    }

    static 
    {
        boolean flag;
        if (!com/flurry/org/apache/avro/io/parsing/SkipParser.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
