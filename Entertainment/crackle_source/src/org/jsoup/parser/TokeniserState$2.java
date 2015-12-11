// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jsoup.parser;


// Referenced classes of package org.jsoup.parser:
//            TokeniserState, Tokeniser, CharacterReader

static final class nit> extends TokeniserState
{

    void read(Tokeniser tokeniser, CharacterReader characterreader)
    {
        characterreader = tokeniser.consumeCharacterReference(null, false);
        if (characterreader == null)
        {
            tokeniser.emit('&');
        } else
        {
            tokeniser.emit(characterreader.charValue());
        }
        tokeniser.transition(Data);
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
