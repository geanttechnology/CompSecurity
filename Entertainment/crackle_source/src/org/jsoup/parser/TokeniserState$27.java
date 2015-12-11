// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, Tokeniser, CharacterReader

static final class it> extends TokeniserState
{

    private void anythingElse(Tokeniser tokeniser, CharacterReader characterreader)
    {
        tokeniser.emit((new StringBuilder()).append("</").append(tokeniser.dataBuffer.toString()).toString());
        tokeniser.transition(ScriptDataEscaped);
    }

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        if (characterreader.matchesLetter())
        {
            characterreader = characterreader.consumeLetterSequence();
            tokeniser.tagPending.gName(characterreader.toLowerCase());
            tokeniser.dataBuffer.append(characterreader);
            return;
        }
        if (tokeniser.isAppropriateEndTagToken() && !characterreader.isEmpty())
        {
            char c = characterreader.consume();
            switch (c)
            {
            default:
                tokeniser.dataBuffer.append(c);
                anythingElse(tokeniser, characterreader);
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
                break;
            }
            tokeniser.transition(Data);
            return;
        } else
        {
            anythingElse(tokeniser, characterreader);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
