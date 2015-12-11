// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, CharacterReader, Tokeniser

static final class it> extends TokeniserState
{

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        char c = characterreader.consume();
        switch (c)
        {
        default:
            tokeniser.tagPending.bute();
            characterreader.unconsume();
            tokeniser.transition(AttributeName);
            // fall through

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
            return;

        case 47: // '/'
            tokeniser.transition(SelfClosingStartTag);
            return;

        case 62: // '>'
            tokeniser.emitTagPending();
            tokeniser.transition(Data);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.tagPending.bute();
            characterreader.unconsume();
            tokeniser.transition(AttributeName);
            return;

        case 65535: 
            tokeniser.eofError(this);
            tokeniser.transition(Data);
            return;

        case 34: // '"'
        case 39: // '\''
        case 60: // '<'
        case 61: // '='
            tokeniser.error(this);
            tokeniser.tagPending.bute();
            tokeniser.tagPending.tributeName(c);
            tokeniser.transition(AttributeName);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
