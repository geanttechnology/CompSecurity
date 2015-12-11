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
        if (characterreader.isEmpty())
        {
            tokeniser.eofError(this);
            tokeniser.emit("</");
            tokeniser.transition(Data);
            return;
        }
        if (characterreader.matchesLetter())
        {
            tokeniser.createTagPending(false);
            tokeniser.transition(TagName);
            return;
        }
        if (characterreader.matches('>'))
        {
            tokeniser.error(this);
            tokeniser.advanceTransition(Data);
            return;
        } else
        {
            tokeniser.error(this);
            tokeniser.advanceTransition(BogusComment);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
