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
            tokeniser.emit("<");
            characterreader.unconsume();
            tokeniser.transition(ScriptData);
            return;

        case 47: // '/'
            tokeniser.createTempBuffer();
            tokeniser.transition(ScriptDataEndTagOpen);
            return;

        case 33: // '!'
            tokeniser.emit("<!");
            tokeniser.transition(ScriptDataEscapeStart);
            return;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
