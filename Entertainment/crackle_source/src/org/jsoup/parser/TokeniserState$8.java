// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, CharacterReader, Tokeniser

static final class nit> extends TokeniserState
{

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        switch (characterreader.current())
        {
        default:
            if (characterreader.matchesLetter())
            {
                tokeniser.createTagPending(true);
                tokeniser.transition(TagName);
                return;
            } else
            {
                tokeniser.error(this);
                tokeniser.emit('<');
                tokeniser.transition(Data);
                return;
            }

        case 33: // '!'
            tokeniser.advanceTransition(MarkupDeclarationOpen);
            return;

        case 47: // '/'
            tokeniser.advanceTransition(EndTagOpen);
            return;

        case 63: // '?'
            tokeniser.advanceTransition(BogusComment);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
