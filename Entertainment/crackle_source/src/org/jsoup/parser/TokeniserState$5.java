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
            tokeniser.emit(characterreader.consumeToAny(new char[] {
                '<', '\0'
            }));
            return;

        case 60: // '<'
            tokeniser.advanceTransition(RawtextLessthanSign);
            return;

        case 0: // '\0'
            tokeniser.error(this);
            characterreader.advance();
            tokeniser.emit('\uFFFD');
            return;

        case 65535: 
            tokeniser.emit(new dvance());
            break;
        }
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
