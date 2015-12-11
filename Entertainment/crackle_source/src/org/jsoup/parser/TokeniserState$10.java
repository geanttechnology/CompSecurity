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
        String s = characterreader.consumeToAny(new char[] {
            '\t', '\n', '\f', ' ', '/', '>', '\0'
        }).toLowerCase();
        tokeniser.tagPending.gName(s);
        switch (characterreader.consume())
        {
        default:
            return;

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
            tokeniser.transition(BeforeAttributeName);
            return;

        case 47: // '/'
            tokeniser.transition(SelfClosingStartTag);
            return;

        case 62: // '>'
            tokeniser.emitTagPending();
            tokeniser.transition(Data);
            return;

        case 0: // '\0'
            tokeniser.tagPending.gName(TokeniserState.access$100());
            return;

        case 65535: 
            tokeniser.eofError(this);
            break;
        }
        tokeniser.transition(Data);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
