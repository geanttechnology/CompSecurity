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
        if (characterreader.matchConsume("--"))
        {
            tokeniser.createCommentPending();
            tokeniser.transition(CommentStart);
            return;
        }
        if (characterreader.matchConsumeIgnoreCase("DOCTYPE"))
        {
            tokeniser.transition(Doctype);
            return;
        }
        if (characterreader.matchConsume("[CDATA["))
        {
            tokeniser.transition(CdataSection);
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
