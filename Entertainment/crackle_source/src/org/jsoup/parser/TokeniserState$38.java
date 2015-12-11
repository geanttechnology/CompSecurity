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
            '"', '&', '\0'
        });
        if (s.length() > 0)
        {
            tokeniser.tagPending.tributeValue(s);
        }
        switch (characterreader.consume())
        {
        default:
            return;

        case 34: // '"'
            tokeniser.transition(AfterAttributeValue_quoted);
            return;

        case 38: // '&'
            characterreader = tokeniser.consumeCharacterReference(Character.valueOf('"'), true);
            if (characterreader != null)
            {
                tokeniser.tagPending.tributeValue(characterreader.charValue());
                return;
            } else
            {
                tokeniser.tagPending.tributeValue('&');
                return;
            }

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.tagPending.tributeValue('\uFFFD');
            return;

        case 65535: 
            tokeniser.eofError(this);
            tokeniser.transition(Data);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
