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
            '\t', '\n', '\f', ' ', '&', '>', '\0', '"', '\'', '<', 
            '=', '`'
        });
        if (s.length() > 0)
        {
            tokeniser.tagPending.tributeValue(s);
        }
        char c = characterreader.consume();
        switch (c)
        {
        default:
            return;

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
            tokeniser.transition(BeforeAttributeName);
            return;

        case 38: // '&'
            characterreader = tokeniser.consumeCharacterReference(Character.valueOf('>'), true);
            if (characterreader != null)
            {
                tokeniser.tagPending.tributeValue(characterreader.charValue());
                return;
            } else
            {
                tokeniser.tagPending.tributeValue('&');
                return;
            }

        case 62: // '>'
            tokeniser.emitTagPending();
            tokeniser.transition(Data);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.tagPending.tributeValue('\uFFFD');
            return;

        case 65535: 
            tokeniser.eofError(this);
            tokeniser.transition(Data);
            return;

        case 34: // '"'
        case 39: // '\''
        case 60: // '<'
        case 61: // '='
        case 96: // '`'
            tokeniser.error(this);
            tokeniser.tagPending.tributeValue(c);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
