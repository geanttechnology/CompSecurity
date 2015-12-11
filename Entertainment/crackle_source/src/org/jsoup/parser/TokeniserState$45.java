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
        char c = characterreader.consume();
        switch (c)
        {
        default:
            tokeniser.commentPending..append(c);
            tokeniser.transition(Comment);
            return;

        case 45: // '-'
            tokeniser.transition(CommentStartDash);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.commentPending..append('\uFFFD');
            tokeniser.transition(Comment);
            return;

        case 62: // '>'
            tokeniser.error(this);
            tokeniser.emitCommentPending();
            tokeniser.transition(Data);
            return;

        case 65535: 
            tokeniser.eofError(this);
            break;
        }
        tokeniser.emitCommentPending();
        tokeniser.transition(Data);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
