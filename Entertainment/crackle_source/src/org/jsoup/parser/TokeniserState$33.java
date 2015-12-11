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
        if (characterreader.matchesLetter())
        {
            characterreader = characterreader.consumeLetterSequence();
            tokeniser.dataBuffer.append(characterreader.toLowerCase());
            tokeniser.emit(characterreader);
            return;
        }
        char c = characterreader.consume();
        switch (c)
        {
        default:
            characterreader.unconsume();
            tokeniser.transition(ScriptDataDoubleEscaped);
            return;

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
        case 47: // '/'
        case 62: // '>'
            break;
        }
        if (tokeniser.dataBuffer.toString().equals("script"))
        {
            tokeniser.transition(ScriptDataEscaped);
        } else
        {
            tokeniser.transition(ScriptDataDoubleEscaped);
        }
        tokeniser.emit(c);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
