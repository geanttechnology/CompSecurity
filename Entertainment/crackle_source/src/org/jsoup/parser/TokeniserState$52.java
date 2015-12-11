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
        if (!characterreader.matchesLetter()) goto _L2; else goto _L1
_L1:
        tokeniser.createDoctypePending();
        tokeniser.transition(DoctypeName);
_L4:
        return;
_L2:
        char c = characterreader.consume();
        switch (c)
        {
        default:
            tokeniser.createDoctypePending();
            tokeniser.doctypePending..append(c);
            tokeniser.transition(DoctypeName);
            return;

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 32: // ' '
            break;

        case 0: // '\0'
            tokeniser.error(this);
            tokeniser.doctypePending..append('\uFFFD');
            tokeniser.transition(DoctypeName);
            return;

        case 65535: 
            tokeniser.eofError(this);
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
        tokeniser.createDoctypePending();
        tokeniser.doctypePending.eQuirks = true;
        tokeniser.emitDoctypePending();
        tokeniser.transition(Data);
        return;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
