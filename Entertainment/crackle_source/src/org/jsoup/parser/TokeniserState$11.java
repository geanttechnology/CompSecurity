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
        if (characterreader.matches('/'))
        {
            tokeniser.createTempBuffer();
            tokeniser.advanceTransition(RCDATAEndTagOpen);
            return;
        }
        if (characterreader.matchesLetter() && !characterreader.containsIgnoreCase((new StringBuilder()).append("</").append(tokeniser.appropriateEndTagName()).toString()))
        {
            tokeniser.tagPending = new >(tokeniser.appropriateEndTagName());
            tokeniser.emitTagPending();
            characterreader.unconsume();
            tokeniser.transition(Data);
            return;
        } else
        {
            tokeniser.emit("<");
            tokeniser.transition(Rcdata);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
