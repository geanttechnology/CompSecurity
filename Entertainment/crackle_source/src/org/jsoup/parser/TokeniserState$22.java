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
        if (characterreader.isEmpty())
        {
            tokeniser.eofError(this);
            tokeniser.transition(Data);
            return;
        }
        switch (characterreader.current())
        {
        default:
            tokeniser.emit(characterreader.consumeToAny(new char[] {
                '-', '<', '\0'
            }));
            return;

        case 45: // '-'
            tokeniser.emit('-');
            tokeniser.advanceTransition(ScriptDataEscapedDash);
            return;

        case 60: // '<'
            tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            characterreader.advance();
            tokeniser.emit('\uFFFD');
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
