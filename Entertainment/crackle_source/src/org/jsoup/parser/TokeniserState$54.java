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
            tokeniser.doctypePending.eQuirks = true;
            tokeniser.emitDoctypePending();
            tokeniser.transition(Data);
            return;
        }
        if (characterreader.matchesAny(new char[] {
    '\t', '\n', '\f', ' '
}))
        {
            characterreader.advance();
            return;
        }
        if (characterreader.matches('>'))
        {
            tokeniser.emitDoctypePending();
            tokeniser.advanceTransition(Data);
            return;
        }
        if (characterreader.matchConsumeIgnoreCase("PUBLIC"))
        {
            tokeniser.transition(AfterDoctypePublicKeyword);
            return;
        }
        if (characterreader.matchConsumeIgnoreCase("SYSTEM"))
        {
            tokeniser.transition(AfterDoctypeSystemKeyword);
            return;
        } else
        {
            tokeniser.error(this);
            tokeniser.doctypePending.eQuirks = true;
            tokeniser.advanceTransition(BogusDoctype);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
