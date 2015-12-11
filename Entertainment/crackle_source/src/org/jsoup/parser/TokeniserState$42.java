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
        switch (characterreader.consume())
        {
        default:
            tokeniser.error(this);
            tokeniser.transition(BeforeAttributeName);
            return;

        case 62: // '>'
            tokeniser.tagPending.ing = true;
            tokeniser.emitTagPending();
            tokeniser.transition(Data);
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
